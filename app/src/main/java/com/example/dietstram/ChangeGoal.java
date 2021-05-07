package com.example.dietstram;

import android.database.Cursor;

import java.util.Calendar;

public class ChangeGoal {


    static final int goalId = 1;

    public static void updateGoalDBMain(DBAdapter db, double targetWeight, String weeklyGoal) {

       // long rowId = 0;
        String[] fields = new String[]{"user_activity_level"};
        Cursor c = db.select("users",fields, "_id", goalId);
        String activity = c.getString(0);

        updateGoalDB(targetWeight, weeklyGoal, db);
        calculateEnergy(weeklyGoal, activity, db);

        updateTempGoalDBMain(db, targetWeight, weeklyGoal, activity);
    }

    public static void updateTempGoalDBMain(DBAdapter db, double targetWeight, String weeklyGoal, String activity) {
        updateTempGoalDB(targetWeight, weeklyGoal, db);
        calculateTempEnergy(weeklyGoal, activity, db);
    }


    public static void calculateEnergy(String weeklyGoal, String activity, DBAdapter db) {
        /*Get Row number from 'users'*/

        /*Calculate Energy*/

        double weight = Double.parseDouble(getTempWeight(db));

        /*1: bmr*/
        double bmr = getBmr(db, weight);
        double energyBmrSQL = db.quoteSmart(bmr);
        db.update("goal", "_id", goalId, "goal_energy_bmr", energyBmrSQL);
        updateDbEnergyFatsCarbsProteins(db, bmr,
            new String[]{"goal_fat_bmr", "goal_carbs_bmr", "goal_proteins_bmr"}, "goal_energy_bmr");

        /*2: with diet*/
        double energyDiet = getEnergyDiet(db, weeklyGoal, bmr);
        updateDbEnergyFatsCarbsProteins(db, energyDiet,
            new String[]{"goal_fat_diet", "goal_carbs_diet", "goal_proteins_diet"}, "goal_energy_diet");

        /*3: with activity*/
        double bmrWithActivity = getBmrWithActivity(bmr, activity);
        updateDbEnergyFatsCarbsProteins(db, bmrWithActivity,
            new String[]{"goal_fat_with_activity", "goal_carbs_with_activity",
                "goal_proteins_with_activity"}, "goal_energy_with_activity");

        /*4: with_activity_and_diet*/
        double bmrGoal = getEnergyDiet(db, weeklyGoal, bmrWithActivity);
        updateDbEnergyFatsCarbsProteins(db, bmrGoal,
            new String[]{"goal_fat_with_activity_and_diet", "goal_carbs_with_activity_and_diet",
                "goal_proteins_with_activity_and_diet"}, "goal_energy_with_activity_and_diet");

    }

    private static double getBmrWithActivity(double bmr, String stringUserActivityLevel) {

        double activityCoefficient = getActivityCoefficient(stringUserActivityLevel);
        double bmrWithActivity = bmr * activityCoefficient;
        return bmrWithActivity;
    }

    private static double getEnergyDiet(DBAdapter db, String weeklyGoal, double bmr) {
        //Carefully or quickly
        double doubleWeeklyGoal = weeklyGoal.equals("0") ? 0.2 : 0.3;
        double kcal = 0;
        double energyDiet = bmr;
        kcal = bmr * doubleWeeklyGoal;

        //long rowId = 0;
        String fields[] = new String[]{"goal_i_want_to"};
        Cursor c = db.select("goal",fields, "_id", goalId);
        String iWantTo = c.getString(0);

        if (iWantTo.startsWith("l")) {
            //Loose wait
            energyDiet = Math.round(bmr - kcal);
        } else if (iWantTo.startsWith("g")) {
            //Gain
            energyDiet = Math.round(bmr + kcal);
        }
        return energyDiet;
    }

    private static double getBmr(DBAdapter db, double weight) {
        long rowId = 0;
        String fields[] = new String[]{
            "_id",
            "user_dob",
            "user_gender",
            "user_height"
        };
        Cursor c = db.select("users", fields,"_id", goalId);
        String stringUserDOB = c.getString(1);
        String stringUserGender = c.getString(2);
        String stringUserHeight = c.getString(3);

        String[] items = stringUserDOB.split("-");
        String day = items[2];
        String month = items[1];
        String year = items[0];
        String stringUserAge = getAge(Integer.parseInt(year), Integer.parseInt(month),
            Integer.parseInt(day));

        double bmr;
        double commonPart =
            10 * weight + 6.25 * Double.parseDouble(stringUserHeight) - 5 * Integer
                .parseInt(stringUserAge);

        if (stringUserGender.startsWith("m")) {
            //Male
            // =(10 x вес (кг) + 6.25 x рост (см) – 5 x возраст (г) + 5) x A;
            bmr = commonPart + 5;

        } else {
            //Female
            // (10 x вес (кг) + 6.25 x рост (см) – 5 x возраст (г) – 161) x A.
            bmr = commonPart - 161;
        }
        return bmr;
    }

    private static void updateDbEnergyFatsCarbsProteins(DBAdapter db, double bmr, String[] fields,
                                                        String mainField) {

        //CalculateProteins
        //14 % protein
        //70 % karbohydrat
        //16 % fat
        double energyBmrSQL = db.quoteSmart(bmr);

        db.update("goal", "_id", goalId, mainField, energyBmrSQL);

        double proteinsBmr = Math.round(bmr * 14 / 100);
        double carbsBmr = Math.round(bmr * 70 / 100);
        double fatBmr = Math.round(bmr * 16 / 100);

        double proteinsBmrSQL = db.quoteSmart(proteinsBmr);
        double carbsBmrSQL = db.quoteSmart(carbsBmr);
        double fatBmrSQL = db.quoteSmart(fatBmr);

        db.update("goal", "_id", goalId, fields[0], fatBmrSQL);
        db.update("goal", "_id", goalId, fields[1], carbsBmrSQL);
        db.update("goal", "_id", goalId, fields[2], proteinsBmrSQL);
    }

    private static void updateGoalDB(double targetWeight, String weeklyGoal, DBAdapter db) {

        String[] fields = new String[]{
            "goal_current_weight"
        };
        Cursor c = db.select("goal", fields,"_id", goalId);
        String weight = c.getString(0);
        double diff = Double.parseDouble(weight) - targetWeight;
        String iWantTo;
        if (diff > 0) {
            iWantTo = "loose weight";
        } else if (diff < 0) {
            iWantTo = "gain weight";
        } else {
            iWantTo = "keep weight";
        }

        String weeklyGoalSQL = db.quoteSmart(weeklyGoal);
        String iWantToSQL = db.quoteSmart(iWantTo);

        double targetWeightSQL = db.quoteSmart(targetWeight);

        db.update("goal", "_id", goalId, "goal_target_weight", targetWeightSQL);
        db.update("goal", "_id", goalId, "goal_i_want_to", iWantToSQL);
        db.update("goal", "_id", goalId, "goal_weekly_goal", weeklyGoalSQL);
    }

    /* Temp ---------------------------------------------------------------------- */
    public static void calculateTempEnergy(String weeklyGoal, String activity, DBAdapter db) {
        /*Get Row number from 'users'*/

        /*Calculate Energy*/
        double weight = Double.parseDouble(getTempWeight(db));

        /*1: bmr*/
        double bmr = getBmr(db, weight);
        double energyBmrSQL = db.quoteSmart(bmr);
        db.update("temp_goal", "_id", goalId, "t_goal_energy_bmr", energyBmrSQL);
        updateTempDbEnergyFatsCarbsProteins(db, bmr,
            new String[]{"t_goal_fat_bmr", "t_goal_carbs_bmr", "t_goal_proteins_bmr"}, "t_goal_energy_bmr");

        /*2: with diet*/
        double energyDiet = getEnergyDiet(db, weeklyGoal, bmr);
        updateTempDbEnergyFatsCarbsProteins(db, energyDiet,
            new String[]{"t_goal_fat_diet", "t_goal_carbs_diet", "t_goal_proteins_diet"}, "t_goal_energy_diet");

        /*3: with activity*/
        double bmrWithActivity = getBmrWithActivity(bmr, activity);
        updateTempDbEnergyFatsCarbsProteins(db, bmrWithActivity,
            new String[]{"t_goal_fat_with_activity", "t_goal_carbs_with_activity",
                "t_goal_proteins_with_activity"}, "t_goal_energy_with_activity");

        /*4: with_activity_and_diet*/
        double bmrGoal = getEnergyDiet(db, weeklyGoal, bmrWithActivity);
        updateTempDbEnergyFatsCarbsProteins(db, bmrGoal,
            new String[]{"t_goal_fat_with_activity_and_diet", "t_goal_carbs_with_activity_and_diet",
                "t_goal_proteins_with_activity_and_diet"}, "t_goal_energy_with_activity_and_diet");

    }


    private static void updateTempDbEnergyFatsCarbsProteins(DBAdapter db, double bmr, String[] fields,
                                                            String mainField) {

        //CalculateProteins
        //20-25 % protein
        //40-50 % karbohydrat
        //25-35 % fat
        double energyBmrSQL = db.quoteSmart(bmr);

        db.update("temp_goal", "_id", goalId, mainField, energyBmrSQL);

        double proteinsBmr = Math.round(bmr * 25 / 100);
        double carbsBmr = Math.round(bmr * 50 / 100);
        double fatBmr = Math.round(bmr * 25 / 100);

        double proteinsBmrSQL = db.quoteSmart(proteinsBmr);
        double carbsBmrSQL = db.quoteSmart(carbsBmr);
        double fatBmrSQL = db.quoteSmart(fatBmr);

        db.update("temp_goal", "_id", goalId, fields[0], fatBmrSQL);
        db.update("temp_goal", "_id", goalId, fields[1], carbsBmrSQL);
        db.update("temp_goal", "_id", goalId, fields[2], proteinsBmrSQL);
    }

    private static void updateTempGoalDB(double targetWeight, String weeklyGoal, DBAdapter db) {

        String weight = getTempWeight(db);
        double diff = Double.parseDouble(weight) - targetWeight;
        String iWantTo;
        if (diff > 0) {
            iWantTo = "loose weight";
        } else if (diff < 0) {
            iWantTo = "gain weight";
        } else {
            iWantTo = "keep weight";
        }
        String weeklyGoalSQL = db.quoteSmart(weeklyGoal);
        String iWantToSQL = db.quoteSmart(iWantTo);

        double targetWeightSQL = db.quoteSmart(targetWeight);


        db.update("temp_goal", "_id", goalId, "t_goal_target_weight", targetWeightSQL);
        db.update("temp_goal", "_id", goalId, "t_goal_i_want_to", iWantToSQL);
        db.update("temp_goal", "_id", goalId, "t_goal_weekly_goal", weeklyGoalSQL);
    }

    private static String getTempWeight(DBAdapter db) {
        String[] fieldsGoal = new String[]{
            "goal_current_weight"
        };
        Cursor cGoal = db.select("goal", fieldsGoal,"_id", goalId);
        String weightGoal = cGoal.getString(0);


        String[] fieldsTemp = new String[]{
            "t_goal_current_weight"
        };
        Cursor c = db.select("temp_goal", fieldsTemp,"_id" ,goalId);

        return c.getString(0)==null?weightGoal:c.getString(0);
    }
    /* // temp ------------------------------------------------------------ */

    private static double getActivityCoefficient(String userActivityLevel) {

        //1,2 – минимальная активность,
        //1,375 – слабый уровень активности
        //1,55 – умеренный уровень активности
        //1,7 – тяжелая или трудоемкая активность
        //1,9 – экстремальный уровень
        switch (userActivityLevel) {
            case "0":
                return 1.2;
            case "1":
                return 1.375;
            case "2":
                return 1.55;
            case "3":
                return 1.7;
            default:
                return 1.9;

        }
    }

    /*get Age ------------------------------ */
    private static String getAge(int year, int month, int day) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return "" + age;
    }
}

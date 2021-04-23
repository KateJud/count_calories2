package com.example.dietstram;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class SignUpGoal extends AppCompatActivity {

  /* ------------------------------------------------------------------------------------------ */
  /*                                                                                            */
  /*                                       Variables                                            */
  /*                                                                                            */
  /* ------------------------------------------------------------------------------------------ */

  /* My fields -------------------------------------------------------------------------------- */
  private String errorMessage = "";
  //TODO
  int goalId = 1;

  /* Widgets fields --------------------------------------------------------------------------- */

  /* ImageView ------------------------------------------------------------------------------ */
  ImageView imageViewError;

  /* EditText ------------------------------------------------------------------------------- */
  EditText editTextTargetWeight;

  /* TextView --------------------------------------------------------------------------------- */
  TextView textViewErrorMessage;
  TextView textViewKgEachWeek;
  TextView textViewKg;

  /* Button --------------------------------------------------------------------------- */
  Button buttonSubmit;

  /* Spinner --------------------------------------------------------------------------- */
  Spinner spinnerWantTo;
  Spinner spinnerWeeklyGoal;

  /* RadioGroup --------------------------------------------------------------------------- */

  /* RadioButton --------------------------------------------------------------------------- */


  private void setAllWidgets() {

    /* ImageView */
    imageViewError = findViewById(R.id.imageViewError);

    /* EditText ------------------------------------------------------------------------------- */
    editTextTargetWeight = findViewById(R.id.editTextTargetWeight);


    /* TextView --------------------------------------------------------------------------------- */
    textViewErrorMessage = findViewById(R.id.textViewErrorMessage);
    textViewKg = findViewById(R.id.textViewKg);
    textViewKgEachWeek = findViewById(R.id.textViewKgEachWeek);


    /* Button --------------------------------------------------------------------------- */
    buttonSubmit = findViewById(R.id.buttonSubmit);

    /* Spinner --------------------------------------------------------------------------- */
    spinnerWantTo = findViewById(R.id.spinnerWantTo);
    spinnerWeeklyGoal = findViewById(R.id.spinnerWeeklyGoalB);


    /* RadioGroup --------------------------------------------------------------------------- */

  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sign_up_goal);

    setAllWidgets();

    /* Hide error and message */
    hideError();

    /* Measurement */
    measurementUsed();

    buttonSubmit.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        signUpGoalSubmit();
      }
    });


  }

  /* MeasurementUsed */
  public void measurementUsed() {
    DBAdapter db = new DBAdapter(this);
    db.open();

    /* Get row number one from users */
    //TODO rowId!!
    long rowId = 0;
    String[] fields = new String[]{"_id", "user_measurement"};

    Cursor cursor = db.selectPrimaryKey("users", "_id", rowId, fields);
    String measurement = cursor.getString(1);

    // Toast.makeText(this,"Measure: "+measurement,Toast.LENGTH_LONG).show();

    db.close();

    if (measurement.startsWith("m")) {
      //Metric

    } else {
      //Imperial

      //Kg to pounds
      textViewKg.setText("pounds");
      textViewKgEachWeek.setText("pounds each week");
    }

  }

  private void hideError() {
    textViewErrorMessage.setVisibility(View.GONE);
    imageViewError.setVisibility(View.GONE);
  }


  /*SignUpGoal Submit ----------------------------------------------------- */
  public void signUpGoalSubmit() {
    errorMessage = "";
    //Get Target Weight
    double doubleTargetWeight = getTargetWeight();

    //Spinner WantTo
    //0: loose
    //1: gain
    int positionWantTo = spinnerWantTo.getSelectedItemPosition();


    /* Spinner WeeklyGoal*/
    String stringWeeklyGoal = spinnerWeeklyGoal.getSelectedItem().toString();

    //Error handling
    tryFinishSignUp(doubleTargetWeight, positionWantTo, stringWeeklyGoal);

  }

  private double getTargetWeight() {
    String stringTargetWeight = editTextTargetWeight.getText().toString();
    double doubleTargetWeight = 0;
    try {
      doubleTargetWeight = Double.parseDouble(stringTargetWeight);
    } catch (NumberFormatException nfe) {
      errorMessage = "Target weight has to be a number.";
    }
    return doubleTargetWeight;
  }

  private void tryFinishSignUp(double targetWeight, int iWantTo, String weeklyGoal) {
    //Нет ошибки
    textViewErrorMessage.setText(errorMessage);
    if (errorMessage.isEmpty()) {
      //Update database

      DBAdapter db = new DBAdapter(this);
      db.open();
      System.out.println();
      System.out.println("ssssssssssssssssssssssss");;
      updateGoalDB(targetWeight, iWantTo, weeklyGoal, db);
      System.out.println("eeeeeee");
      calculateEnergy(targetWeight, iWantTo, weeklyGoal, db);
      System.out.println("ddddd");
      db.close();

      hideError();

      //Move MainActivity
      Intent i = new Intent(SignUpGoal.this, MainActivity.class);
      startActivity(i);
    } else {
      //There is error
      textViewErrorMessage.setVisibility(View.VISIBLE);
      imageViewError.setVisibility(View.VISIBLE);

    }
  }

  private void calculateEnergy(double targetWeight, int iWantTo, String weeklyGoal, DBAdapter db) {
    /*Get Row number from 'users'*/
    //ToDo


    /*Calculate Energy*/

    /*1: bmr*/
    double bmr = getBmr(db, targetWeight);
    System.out.println("1bmr:"+bmr);
    double energyBmrSQL = db.quoteSmart(bmr);
    db.update("goal", "_id", goalId, "goal_energy_bmr", energyBmrSQL);
    updateDbEnergyFatsCarbsProteins(db, bmr,
        new String[]{"goal_fat_bmr", "goal_carbs_bmr", "goal_proteins_bmr"}, "goal_energy_bmr");

    /*2: with diet*/
    double energyDiet = getEnergyDiet(iWantTo, weeklyGoal, bmr);
    System.out.println("2bmr:"+energyDiet);
    updateDbEnergyFatsCarbsProteins(db, energyDiet,
        new String[]{"goal_fat_diet", "goal_carbs_diet", "goal_proteins_diet"}, "goal_energy_diet");

    /*3: with activity*/
    double bmrWithActivity = getBmrWithActivity(db, bmr);
    updateDbEnergyFatsCarbsProteins(db, bmrWithActivity,
        new String[]{"goal_fat_with_activity", "goal_carbs_with_activity",
            "goal_proteins_with_activity"}, "goal_energy_with_activity");

    /*4: with_activity_and_diet*/
    double bmrGoal = getEnergyDiet(iWantTo, weeklyGoal, bmrWithActivity);
    updateDbEnergyFatsCarbsProteins(db, bmrGoal,
        new String[]{"goal_fat_with_activity_and_diet", "goal_carbs_with_activity_and_diet",
            "goal_proteins_with_activity_and_diet"}, "goal_energy_with_activity_and_diet");

  }

  private double getBmrWithActivity(DBAdapter db, double bmr) {
    long rowId = 0;
    String fields[] = new String[]{
        "_id",
        "user_dob",
        "user_gender",
        "user_height",
        "user_activity_level"};
    Cursor c = db.selectPrimaryKey("users", "_id", rowId, fields);
    String stringUserActivityLevel = c.getString(4);
    double activityCoefficient = getActivityCoefficient(stringUserActivityLevel);
    double bmrWithActivity = bmr * activityCoefficient;
    return bmrWithActivity;
  }

  private double getEnergyDiet(int iWantTo, String weeklyGoal, double bmr) {
    double doubleWeeklyGoal = Double.parseDouble(weeklyGoal);
    double kcal = 0;
    double energyDiet = 0;
    kcal = 7700 * doubleWeeklyGoal;
    if (iWantTo == 0) {
      //Loose wait
      energyDiet = Math.round(bmr - kcal / 7);
    } else {
      //Gain
      energyDiet = Math.round(bmr + kcal / 7);
    }
    return energyDiet;
  }

  private double getBmr(DBAdapter db, double targetWeight) {
    long rowId = 0;
    String fields[] = new String[]{
        "_id",
        "user_dob",
        "user_gender",
        "user_height",
        "user_activity_level"};
    Cursor c = db.selectPrimaryKey("users", "_id", rowId, fields);
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
        10 * targetWeight + 6.25 * Double.parseDouble(stringUserHeight) - 5 * Integer
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

  private void updateDbEnergyFatsCarbsProteins(DBAdapter db, double bmr, String[] fields,
      String mainField) {

    //CalculateProteins
    //20-25 % protein
    //40-50 % karbohydrat
    //25-35 % fat
    double energyBmrSQL = db.quoteSmart(bmr);

    db.update("goal", "_id", goalId, mainField, energyBmrSQL);

    double proteinsBmr = Math.round(bmr * 25 / 100);
    double carbsBmr = Math.round(bmr * 50 / 100);
    double fatBmr = Math.round(bmr * 25 / 100);

    double proteinsBmrSQL = db.quoteSmart(proteinsBmr);
    double carbsBmrSQL = db.quoteSmart(carbsBmr);
    double fatBmrSQL = db.quoteSmart(fatBmr);

    db.update("goal", "_id", goalId, fields[0], fatBmrSQL);
    db.update("goal", "_id", goalId, fields[1], carbsBmrSQL);
    db.update("goal", "_id", goalId, fields[2], proteinsBmrSQL);
  }

  private void updateGoalDB(double targetWeight, int iWantTo, String weeklyGoal, DBAdapter db) {
    String weeklyGoalSQL = db.quoteSmart(weeklyGoal);
    int iWantToSQL = db.quoteSmart(iWantTo);
    double targetWeightSQL = db.quoteSmart(targetWeight);

    db.update("goal", "_id", goalId, "goal_target_weight", targetWeightSQL);
    db.update("goal", "_id", goalId, "goal_i_want_to", iWantToSQL);
    db.update("goal", "_id", goalId, "goal_weekly_goal", weeklyGoalSQL);
  }

  double getActivityCoefficient(String userActivityLevel) {

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
  private String getAge(int year, int month, int day) {
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

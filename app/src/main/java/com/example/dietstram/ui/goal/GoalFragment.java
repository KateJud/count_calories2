package com.example.dietstram.ui.goal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import com.example.dietstram.DBAdapter;
import com.example.dietstram.MainActivity;
import com.example.dietstram.R;
import com.example.dietstram.SignUpGoal;
import com.example.dietstram.ui.food.FoodFragment;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Calendar;

import static com.example.dietstram.OpenCloseDB.changeTitle;

//TODO SUbmiT??
public class GoalFragment extends Fragment {
    /* Action buttons */
    MenuItem menuItemEdit;
    MenuItem menuItemDelete;
    MenuItem menuItemAdd;


    private String currentId;
    private String currentName;
    private View mainView;

    private GoalViewModel goalViewModel;

    /*TextView --------------------------------------------- */
    //Loose|gain Table
    TextView textViewProteins;
    TextView textViewCarbs;
    TextView textViewFat;

    TextView textViewEnergyLooseWithout;
    TextView textViewProteinsLooseWithout;
    TextView textViewCarbsLooseWithout;
    TextView textViewFatLooseWithout;

    TextView textViewEnergyLooseWith;
    TextView textViewProteinsLooseWith;
    TextView textViewCarbsLooseWith;
    TextView textViewFatLooseWith;


    //Keep weight
    TextView textViewProteinsKeep;
    TextView textViewCarbsKeep;
    TextView textViewFatKeep; //textViewFatKeep);

    TextView textViewEnergyKeepWithout;
    TextView textViewProteinsKeepWithout; //textViewProteinsKeepWithout);
    TextView textViewCarbsKeepWithout; //textViewCarbsKeepWithout);
    TextView textViewFatKeepWithout; //textViewFatKeepWithout);

    TextView textViewEnergyKeepWith;
    TextView textViewProteinsKeepWith; //textViewProteinsKeepWith);
    TextView textViewCarbsKeepWith; //textViewCarbsKeepWith);
    TextView textViewFatKeepWith; //textViewFatKeepWith);

    /*Spinner */
    Spinner spinnerWantTo;
    Spinner spinnerWeeklyGoal;

    /* EditText */
    EditText editTextUserWeight;
    EditText editTextUserTargetWeight;

    /* Check box */
    CheckBox checkBoxAdvanced;

    private void setAllWidgets() {
        //Loose|gain Table
        textViewProteins = getActivity().findViewById(R.id.textViewProteins);
        textViewCarbs = getActivity().findViewById(R.id.textViewCarbs);
        textViewFat = getActivity().findViewById(R.id.textViewFat);

        textViewEnergyLooseWithout = getActivity().findViewById(R.id.textViewEnergyLooseWithout);
        textViewProteinsLooseWithout = getActivity().findViewById(R.id.textViewProteinsLooseWithout);
        textViewCarbsLooseWithout = getActivity().findViewById(R.id.textViewCarbsLooseWithout);
        textViewFatLooseWithout = getActivity().findViewById(R.id.textViewFatLooseWithout);

        textViewEnergyLooseWith = getActivity().findViewById(R.id.textViewEnergyLooseWith);
        textViewProteinsLooseWith = getActivity().findViewById(R.id.textViewProteinsLooseWith);
        textViewCarbsLooseWith = getActivity().findViewById(R.id.textViewCarbsLooseWith);
        textViewFatLooseWith = getActivity().findViewById(R.id.textViewFatLooseWith);


        //Keep weight
        textViewProteinsKeep = getActivity().findViewById(R.id.textViewProteinsKeep);
        textViewCarbsKeep = getActivity().findViewById(R.id.textViewCarbsKeep);
        textViewFatKeep = getActivity().findViewById(R.id.textViewFatKeep);

        textViewEnergyKeepWithout = getActivity().findViewById(R.id.textViewEnergyKeepWithout);
        textViewProteinsKeepWithout = getActivity().findViewById(R.id.textViewProteinsKeepWithout);
        textViewCarbsKeepWithout = getActivity().findViewById(R.id.textViewCarbsKeepWithout);
        textViewFatKeepWithout = getActivity().findViewById(R.id.textViewFatKeepWithout);

        textViewEnergyKeepWith = getActivity().findViewById(R.id.textViewEnergyKeepWith);
        textViewProteinsKeepWith = getActivity().findViewById(R.id.textViewProteinsKeepWith);
        textViewCarbsKeepWith = getActivity().findViewById(R.id.textViewCarbsKeepWith);
        textViewFatKeepWith = getActivity().findViewById(R.id.textViewFatKeepWith);


        spinnerWantTo = getActivity().findViewById(R.id.spinnerWantTo);
        spinnerWeeklyGoal = getActivity().findViewById(R.id.spinnerWeeklyGoal);

        //EditText
        editTextUserWeight = getActivity().findViewById(R.id.editTextUserWeight);
        editTextUserTargetWeight = getActivity().findViewById(R.id.editTextUserTargetWeight);

        //CheckBox
        checkBoxAdvanced = getActivity().findViewById(R.id.checkboxAdvanced);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Set title */
        changeTitle(getActivity(), "Profile");

    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        goalViewModel =
            ViewModelProviders.of(this).get(GoalViewModel.class);
        mainView = inflater.inflate(R.layout.fragment_goal, container, false);

        return mainView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setAllWidgets();
        toggleNumberViewGoal(false);

        initializeData();

        setHasOptionsMenu(true);
    }

    private void setMainView(int id) {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mainView = inflater.inflate(id, null);
        ViewGroup rootView = (ViewGroup) getView();
        rootView.removeAllViews();
        rootView.addView(mainView);

    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        //Inflate menu
        ((MainActivity) getActivity()).getMenuInflater().inflate(R.menu.menu_goal, menu);

        //Assign variables
        menuItemEdit = menu.findItem(R.id.action_food_edit);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_food_edit) {
            editGoal();
        }

        return super.onOptionsItemSelected(item);
    }

    /* Change layout ----------------------------------------- */
    private void changeLayout(int id) {
        /*  Change layout */
        setMainView(id);
    }

    private void madeMenuItemInvisible() {

        //Show edit button
        menuItemEdit.setVisible(false);

    }

    private void editGoal() {

        //show edit button
        madeMenuItemInvisible();
        /* Change layout */
        changeLayout(R.layout.fragment_goal_edit);
        setAllWidgets();

        /* Get data from database */
        DBAdapter db = getDbAdapter();

        String fields[] = {
            "_id",
            "goal_current_weight",
            "goal_target_weight",
            "goal_i_want_to",
            "goal_weekly_goal",

        };
        Cursor cursor = db.select("goal", fields, "_id", goalId);
        String stringGoalCurrentWeight = cursor.getString(1);
        String stringGoalTargetWeight = cursor.getString(2);
        String stringGoalIWantTo = cursor.getString(3);
        String stringGoalWeeklyGoal = cursor.getString(4);

        //Measurement +activity level
        /* Measurement */
        long rowId = 1;
        String[] fields2 = {"_id", "user_measurement", "user_activity_level"};
        Cursor cursor2 = db.select("users", fields2, "_id", rowId);
        String measurement = cursor2.getString(1);
        String activityLevel = cursor2.getString(2);

        TextView textViewGoalKg = getActivity().findViewById(R.id.textViewGoalKg);
        TextView textViewGoalKg2 = getActivity().findViewById(R.id.textViewGoalKg2);

        if (measurement.startsWith("m")) {
            textViewGoalKg.setText(getActivity().getString(R.string.kg));
            textViewGoalKg2.setText(getActivity().getString(R.string.kg));
        } else {
            textViewGoalKg.setText(getActivity().getString(R.string.pounds));
            textViewGoalKg2.setText(getActivity().getString(R.string.pounds));
        }



        /* Weight */
        //todo if pounds
        editTextUserWeight.setText(stringGoalCurrentWeight);

        /* Target Weight */
        editTextUserTargetWeight.setText(stringGoalTargetWeight);

        /* I want to */
        spinnerWantTo.setSelection(Integer.parseInt(stringGoalIWantTo));

        /* I want to */
        String[] arr=getActivity().getResources().getStringArray(R.array.array_weekly_goal_kg);

        spinnerWeeklyGoal.setSelection(Arrays.asList(arr).indexOf(stringGoalWeeklyGoal));

        /*  ActivityLevel */
        spinnerWeeklyGoal.setSelection(Integer.parseInt(activityLevel));

        db.close();


        /* Numbers */
        updateNumberTable();


        // Submit listener
        Button buttonSubmit = getActivity().findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileEditGoalSubmit();
            }
        });


    }

    private DBAdapter getDbAdapter() {
        DBAdapter db = new DBAdapter(getActivity());
        db.open();
        return db;
    }

    private void initializeData() {

        /* Get data from database */
        DBAdapter db = getDbAdapter();

        String fields[] = {
            "_id",
            "goal_current_weight",
            "goal_target_weight",
            "goal_i_want_to",
            "goal_weekly_goal"

        };
        Cursor cursor = db.select("goal", fields, "_id", goalId);
        String stringGoalCurrentWeight = cursor.getString(1);
        String stringGoalTargetWeight = cursor.getString(2);
        String stringGoalIWantTo = cursor.getString(3);
        String stringGoalWeeklyGoal = cursor.getString(4);

        /* Weight */
        TextView textViewUserWeight = getActivity().findViewById(R.id.textViewUserWeight);
        textViewUserWeight.setText(stringGoalCurrentWeight);

        /* Target Weight */
        TextView textViewUserTargetWeight = getActivity().findViewById(R.id.textViewUserTargetWeight);
        textViewUserTargetWeight.setText(stringGoalTargetWeight);

        /* Method */
        //Method

        String method = "";
        String ifYouWant = "";
        if (stringGoalIWantTo.equals("0")) {
            ifYouWant = "If you want to loose weight ";
            method = "Loose " + stringGoalWeeklyGoal;
        } else {
            ifYouWant = "If you want to gain weight ";
            method = "Gain " + stringGoalWeeklyGoal;
        }

        /* Measurement */
        long rowId = 1;
        String[] fields2 = {"_id", "user_measurement", "user_activity_level"};
        Cursor cursor2 = db.select("users", fields2, "_id", rowId);
        String measurement = cursor2.getString(1);
        String activityLevel = cursor2.getString(2);


        if (measurement.startsWith("m")) {
            method = method + " kg/week";
        } else {
            method = method + " pounds/week";
        }

        TextView textViewUserMethod = getActivity().findViewById(R.id.textViewUserMethod);
        textViewUserMethod.setText(method);

        /*  ActivityLevel */
        TextView textViewUserActivity = getActivity().findViewById(R.id.textViewUserActivity);
        String stringActivityLevel = getActivity().getResources().getStringArray(R.array.array_activity_level)[Integer.parseInt(activityLevel)];
        textViewUserActivity.setText(stringActivityLevel);

        /* Name of first table: If you want to */
        TextView textViewLooseWeight = getActivity().findViewById(R.id.textViewLooseWeight);
        textViewLooseWeight.setText(ifYouWant);



        /* Numbers */
        updateNumberTable();

        checkBoxAdvanced.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleNumberViewGoal(isChecked);
            }
        });

        db.close();
    }

    private void updateNumberTable() {
        DBAdapter db = getDbAdapter();

        //Get goal data
        String[] fields_goal = {
            "goal_energy_bmr ",
            "goal_proteins_bmr ",
            "goal_carbs_bmr ",
            "goal_fat_bmr ",
            "goal_energy_diet ",
            "goal_proteins_diet ",
            "goal_carbs_diet ",
            "goal_fat_diet ",
            "goal_energy_with_activity ",
            "goal_proteins_with_activity ",
            "goal_carbs_with_activity ",
            "goal_fat_with_activity ",
            "goal_energy_with_activity_and_diet ",
            "goal_proteins_with_activity_and_diet ",
            "goal_carbs_with_activity_and_diet ",
            "goal_fat_with_activity_and_diet "
        };
        Cursor goalCursor = db.select("goal", fields_goal, "", "", "_id", "DESC");
        //Cursor goalCursor = db.select("goal", fields_goal, "_id", goalId);


        //Ready as variables
        String goal_energy_bmr = goalCursor.getString(0);
        String goal_proteins_bmr = goalCursor.getString(1);
        String goal_carbs_bmr = goalCursor.getString(2);
        String goal_fat_bmr = goalCursor.getString(3);
        String goal_energy_diet = goalCursor.getString(4);
        String goal_proteins_diet = goalCursor.getString(5);
        String goal_carbs_diet = goalCursor.getString(6);
        String goal_fat_diet = goalCursor.getString(7);
        String goal_energy_with_activity = goalCursor.getString(8);
        String goal_proteins_with_activity = goalCursor.getString(9);
        String goal_carbs_with_activity = goalCursor.getString(10);
        String goal_fat_with_activity = goalCursor.getString(11);
        String goal_energy_with_activity_and_diet = goalCursor.getString(12);
        String goal_proteins_with_activity_and_diet = goalCursor.getString(13);
        String goal_carbs_with_activity_and_diet = goalCursor.getString(14);
        String goal_fat_with_activity_and_diet = goalCursor.getString(15);

        //1 diet
        textViewEnergyLooseWithout.setText(goal_energy_diet);
        textViewProteinsLooseWithout.setText(goal_proteins_diet);
        textViewCarbsLooseWithout.setText(goal_carbs_diet);
        textViewFatLooseWithout.setText(goal_fat_diet);


        //2 diet and activity
        textViewEnergyLooseWith.setText(goal_energy_with_activity_and_diet);
        textViewProteinsLooseWith.setText(goal_proteins_with_activity_and_diet);
        textViewCarbsLooseWith.setText(goal_carbs_with_activity_and_diet);
        textViewFatLooseWith.setText(goal_fat_with_activity_and_diet);

        //3 BMR
        textViewEnergyKeepWithout.setText(goal_energy_bmr);
        textViewProteinsKeepWithout.setText(goal_proteins_bmr);
        textViewCarbsKeepWithout.setText(goal_carbs_bmr);
        textViewFatKeepWithout.setText(goal_fat_bmr);

        //4 With activity
        textViewEnergyKeepWith.setText(goal_energy_with_activity);
        textViewProteinsKeepWith.setText(goal_proteins_with_activity);
        textViewCarbsKeepWith.setText(goal_carbs_with_activity);
        textViewFatKeepWith.setText(goal_fat_with_activity);


        db.close();

    }

    public void toggleNumberViewGoal(boolean isChecked) {

        //        //Loose|gain Table
        //        TextView textViewProteins = getActivity().findViewById(R.id.textViewProteins);
        //        TextView textViewCarbs = getActivity().findViewById(R.id.textViewCarbs);
        //        TextView textViewFat = getActivity().findViewById(R.id.textViewFat);
        //
        //        TextView textViewProteinsLooseWithout = getActivity().findViewById(R.id.textViewProteinsLooseWithout);
        //        TextView textViewCarbsLooseWithout = getActivity().findViewById(R.id.textViewCarbsLooseWithout);
        //        TextView textViewFatLooseWithout = getActivity().findViewById(R.id.textViewFatLooseWithout);
        //
        //        TextView textViewProteinsLooseWith = getActivity().findViewById(R.id.textViewProteinsLooseWith);
        //        TextView textViewCarbsLooseWith = getActivity().findViewById(R.id.textViewCarbsLooseWith);
        //        TextView textViewFatLooseWith = getActivity().findViewById(R.id.textViewFatLooseWith);
        //
        //
        //        //Keep weight
        //        TextView textViewProteinsKeep = getActivity().findViewById(R.id.textViewProteinsKeep);
        //        TextView textViewCarbsKeep = getActivity().findViewById(R.id.textViewCarbsKeep);
        //        TextView textViewFatKeep = getActivity().findViewById(R.id.textViewFatKeep);
        //
        //        TextView textViewKeepProteinsKeepWithout = getActivity().findViewById(R.id.textViewProteinsKeepWithout);
        //        TextView textViewKeepCarbsKeepWithout = getActivity().findViewById(R.id.textViewCarbsKeepWithout);
        //        TextView textViewKeepFatKeepWithout = getActivity().findViewById(R.id.textViewFatKeepWithout);
        //
        //        TextView textViewProteinsKeepWith = getActivity().findViewById(R.id.textViewProteinsKeepWith);
        //        TextView textViewCarbsKeepWith = getActivity().findViewById(R.id.textViewCarbsKeepWith);
        //        TextView textViewFatKeepWith = getActivity().findViewById(R.id.textViewFatKeepWith);

        if (isChecked) {
            //Видно
            textViewProteins.setVisibility(View.VISIBLE);
            textViewCarbs.setVisibility(View.VISIBLE);
            textViewFat.setVisibility(View.VISIBLE);

            textViewProteinsLooseWithout.setVisibility(View.VISIBLE);
            textViewCarbsLooseWithout.setVisibility(View.VISIBLE);
            textViewFatLooseWithout.setVisibility(View.VISIBLE);

            textViewProteinsLooseWith.setVisibility(View.VISIBLE);
            textViewCarbsLooseWith.setVisibility(View.VISIBLE);
            textViewFatLooseWith.setVisibility(View.VISIBLE);


            //Keep weight
            textViewProteinsKeep.setVisibility(View.VISIBLE);
            textViewCarbsKeep.setVisibility(View.VISIBLE);
            textViewFatKeep.setVisibility(View.VISIBLE);

            textViewProteinsKeepWithout.setVisibility(View.VISIBLE);
            textViewCarbsKeepWithout.setVisibility(View.VISIBLE);
            textViewFatKeepWithout.setVisibility(View.VISIBLE);

            textViewProteinsKeepWith.setVisibility(View.VISIBLE);
            textViewCarbsKeepWith.setVisibility(View.VISIBLE);
            textViewFatKeepWith.setVisibility(View.VISIBLE);
        } else {
            //Невидно
            textViewProteins.setVisibility(View.INVISIBLE);
            textViewCarbs.setVisibility(View.INVISIBLE);
            textViewFat.setVisibility(View.INVISIBLE);

            textViewProteinsLooseWithout.setVisibility(View.INVISIBLE);
            textViewCarbsLooseWithout.setVisibility(View.INVISIBLE);
            textViewFatLooseWithout.setVisibility(View.INVISIBLE);

            textViewProteinsLooseWith.setVisibility(View.INVISIBLE);
            textViewCarbsLooseWith.setVisibility(View.INVISIBLE);
            textViewFatLooseWith.setVisibility(View.INVISIBLE);


            //Keep weight
            textViewProteinsKeep.setVisibility(View.INVISIBLE);
            textViewCarbsKeep.setVisibility(View.INVISIBLE);
            textViewFatKeep.setVisibility(View.INVISIBLE);

            textViewProteinsKeepWithout.setVisibility(View.INVISIBLE);
            textViewCarbsKeepWithout.setVisibility(View.INVISIBLE);
            textViewFatKeepWithout.setVisibility(View.INVISIBLE);

            textViewProteinsKeepWith.setVisibility(View.INVISIBLE);
            textViewCarbsKeepWith.setVisibility(View.INVISIBLE);
            textViewFatKeepWith.setVisibility(View.INVISIBLE);
        }

    }

    String errorMessage;

    /*SignUpGoal Submit ----------------------------------------------------- */
    public void profileEditGoalSubmit() {
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

    void editGoalSubmitOnClick() {
        //I want to

        //Spinner weekly goal

        //Activity level


        //Current weight
        String currentWeight = editTextUserWeight.getText().toString();
        double doubleCurrWeight = 0;


    }


    private double getTargetWeight() {
        String stringTargetWeight = editTextUserTargetWeight.getText().toString();
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

        if (errorMessage.isEmpty()) {
            //Update database

            DBAdapter db = getDbAdapter();
            updateGoalDB(targetWeight, iWantTo, weeklyGoal, db);
            calculateEnergy(targetWeight, iWantTo, weeklyGoal, db);
            db.close();


            //Move to Goal (not edit)
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, new GoalFragment(), GoalFragment.class.getName()).commit();

        } else {
            //There is error
            Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();

        }
    }

    private void calculateEnergy(double targetWeight, int iWantTo, String weeklyGoal, DBAdapter db) {
        /*Get Row number from 'users'*/
        //ToDo


        /*Calculate Energy*/

        /*1: bmr*/
        double bmr = getBmr(db, targetWeight);
        System.out.println("1bmr:" + bmr);
        double energyBmrSQL = db.quoteSmart(bmr);
        db.update("goal", "_id", goalId, "goal_energy_bmr", energyBmrSQL);
        updateDbEnergyFatsCarbsProteins(db, bmr,
            new String[]{"goal_fat_bmr", "goal_carbs_bmr", "goal_proteins_bmr"}, "goal_energy_bmr");

        /*2: with diet*/
        double energyDiet = getEnergyDiet(iWantTo, weeklyGoal, bmr);
        System.out.println("2bmr:" + energyDiet);
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

    //TODO
    int goalId = 1;

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
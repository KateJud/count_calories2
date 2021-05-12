package com.example.dietstram.ui.goal;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

import com.example.dietstram.ChangeGoal;
import com.example.dietstram.DBAdapter;
import com.example.dietstram.MainActivity;
import com.example.dietstram.R;

import java.util.Arrays;

import static com.example.dietstram.OpenCloseDB.changeTitle;
import static com.example.dietstram.OpenCloseDB.convertKgToPounds;

//TODO SUbmiT??
public class GoalFragment extends Fragment {
    static final int goalId = 1;

    /* Action buttons */
    MenuItem menuItemEdit;
    MenuItem menuItemDelete;
    MenuItem menuItemAdd;


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
    private Spinner spinnerWeeklyGoal;
    private Spinner spinnerActivityLevel;

    /* EditText */
    private EditText editTextUserWeight;
    private EditText editTextUserTargetWeight;
    private EditText editTextEnergyGoal;
    private EditText editTextProteinGoal;
    private EditText editTextCarbsGoal;
    private EditText editTextFatGoal;


    /* Check box */
    private CheckBox checkBoxAdvanced;
    private CheckBox checkBoxEnergyGoal;
    private CheckBox checkBoxProteinGoal;
    private CheckBox checkBoxCarbsGoal;
    private CheckBox checkBoxFatGoal;

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

        //Spinner
        spinnerWeeklyGoal = getActivity().findViewById(R.id.spinnerWeeklyGoal);
        spinnerActivityLevel = getActivity().findViewById(R.id.spinnerActivityLevel);

        //EditText
        editTextUserWeight = getActivity().findViewById(R.id.editTextUserWeight);
        editTextUserTargetWeight = getActivity().findViewById(R.id.editTextUserTargetWeight);

        editTextEnergyGoal = getActivity().findViewById(R.id.editTextEnergyGoal);
        editTextProteinGoal = getActivity().findViewById(R.id.editTextProteinGoal);
        editTextCarbsGoal = getActivity().findViewById(R.id.editTextCarbsGoal);
        editTextFatGoal = getActivity().findViewById(R.id.editTextFatGoal);


        //CheckBox
        checkBoxAdvanced = getActivity().findViewById(R.id.checkboxAdvanced);

        checkBoxEnergyGoal = getActivity().findViewById(R.id.checkboxEnergySave);
        checkBoxProteinGoal = getActivity().findViewById(R.id.checkboxProteinSave);
        checkBoxCarbsGoal = getActivity().findViewById(R.id.checkboxCarbsSave);
        checkBoxFatGoal = getActivity().findViewById(R.id.checkboxFatSave);

    }

    private void setListeners() {

        //Energy
        editTextEnergyGoal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkBoxEnergyGoal.setEnabled(!editTextEnergyGoal.getText().toString().isEmpty());
            }
        });

        checkBoxEnergyGoal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DBAdapter db = getDbAdapter();
                if (isChecked) {
                    editTextEnergyGoal.setEnabled(false);
                    //Energy
                    db.update("goal", "_id", goalId, "goal_user_energy", 1);
                    db.update("goal", "_id", goalId, "goal_energy_with_activity_and_diet", 1);
                } else {
                    editTextEnergyGoal.setEnabled(true);
                    db.update("goal", "_id", goalId, "goal_user_energy", 0);
                }
                db.close();
            }
        });

        //Protein
        editTextProteinGoal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkBoxProteinGoal.setEnabled(!editTextProteinGoal.getText().toString().isEmpty());
            }
        });

        checkBoxProteinGoal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DBAdapter db = getDbAdapter();
                if (isChecked) {
                    editTextProteinGoal.setEnabled(false);
                    //Protein
                    db.update("goal", "_id", goalId, "goal_user_protein", 1);
                    db.update("goal", "_id", goalId, "goal_protein_with_activity_and_diet", 1);
                } else {
                    editTextProteinGoal.setEnabled(true);
                    db.update("goal", "_id", goalId, "goal_user_protein", 0);
                }
                db.close();
            }
        });

        //Carbs
        editTextCarbsGoal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkBoxCarbsGoal.setEnabled(!editTextCarbsGoal.getText().toString().isEmpty());
            }
        });

        checkBoxCarbsGoal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                DBAdapter db = getDbAdapter();
                if (isChecked) {
                    editTextCarbsGoal.setEnabled(false);
                    //Carbs
                    db.update("goal", "_id", goalId, "goal_user_carbs", 1);
                    db.update("goal", "_id", goalId, "goal_carbs_with_activity_and_diet", 1);
                } else {
                    editTextCarbsGoal.setEnabled(true);
                    db.update("goal", "_id", goalId, "goal_user_carbs", 0);
                }
                db.close();
            }
        });

        //Fat

        editTextFatGoal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkBoxFatGoal.setEnabled(!editTextFatGoal.getText().toString().isEmpty());
            }
        });

        checkBoxFatGoal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                DBAdapter db = getDbAdapter();

                if (isChecked) {
                    editTextFatGoal.setEnabled(false);
                    //Fat
                    db.update("goal", "_id", goalId, "goal_user_fat", 1);
                    db.update("goal", "_id", goalId, "goal_fat_with_activity_and_diet", 1);
                } else {
                    editTextFatGoal.setEnabled(true);
                    db.update("goal", "_id", goalId, "goal_user_fat", 0);
                }
                db.close();
            }

        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Set title */
        changeTitle(getActivity(), "Goal");

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
        menuItemEdit = menu.findItem(R.id.action_edit);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {
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
        setListeners();

        /* Get data from database */
        DBAdapter db = getDbAdapter();

        String[] fields = {
            "_id",
            "goal_current_weight",
            "goal_target_weight",
            "goal_i_want_to",
            "goal_weekly_goal",
            "goal_energy_with_activity_and_diet ",
            "goal_protein_with_activity_and_diet ",
            "goal_carbs_with_activity_and_diet ",
            "goal_fat_with_activity_and_diet ",
            "goal_user_energy",
            "goal_user_protein",
            "goal_user_carbs",
            "goal_user_fat",

        };
        Cursor cursor = db.select("goal", fields, "_id", goalId);
        String stringGoalCurrentWeight = cursor.getString(1);
        String stringGoalTargetWeight = cursor.getString(2);
        String stringGoalIWantTo = cursor.getString(3);
        String stringGoalWeeklyGoal = cursor.getString(4);

        String stringGoalEnergy = cursor.getString(5);
        String stringGoalProtein = cursor.getString(6);
        String stringGoalCarbs = cursor.getString(7);
        String stringGoalFat = cursor.getString(8);

        String stringUserSaveEnergy = cursor.getString(9);
        String stringUserSaveProtein = cursor.getString(10);
        String stringUserSaveCarbs = cursor.getString(11);
        String stringUserSaveFat = cursor.getString(12);

        //Energy
        editTextEnergyGoal.setText(stringGoalEnergy);
        if (stringUserSaveEnergy.equals("1")) {
            checkBoxEnergyGoal.setChecked(true);
        }

        //Protein
        editTextProteinGoal.setText(stringGoalProtein);
        if (stringUserSaveProtein.equals("1")) {
            checkBoxProteinGoal.setChecked(true);
        }

        //Carbs
        editTextCarbsGoal.setText(stringGoalCarbs);
        if (stringUserSaveCarbs.equals("1")) {
            checkBoxCarbsGoal.setChecked(true);
        }

        //Fat
        editTextFatGoal.setText(stringGoalFat);
        if (stringUserSaveFat.equals("1")) {
            checkBoxFatGoal.setChecked(true);
        }

        //Measurement +activity level
        /* Measurement */
        long rowId = 1;
        String[] fields2 = {"_id", "user_measurement", "user_activity_level"};
        Cursor cursor2 = db.select("users", fields2, "_id", rowId);
        String measurement = cursor2.getString(1);
        String activityLevel = cursor2.getString(2);

        TextView textViewGoalKg = getActivity().findViewById(R.id.textViewGoalKg);
        TextView textViewGoalKg2 = getActivity().findViewById(R.id.textViewGoalKg2);


        /* I want to */
        final TextView textViewUserWantTo = getActivity().findViewById(R.id.textViewUserWantTo);
        textViewUserWantTo.setText(stringGoalIWantTo);

        /* Weight */
        /* Target Weight */
        if (measurement.startsWith("m")) {
            textViewGoalKg.setText(getActivity().getString(R.string.kg));
            textViewGoalKg2.setText(getActivity().getString(R.string.kg));
            editTextUserWeight.setText(stringGoalCurrentWeight);
            editTextUserTargetWeight.setText(stringGoalTargetWeight);
        } else {
            textViewGoalKg.setText(getActivity().getString(R.string.pounds));
            textViewGoalKg2.setText(getActivity().getString(R.string.pounds));
            editTextUserWeight.setText("" + convertKgToPounds(stringGoalCurrentWeight));
            editTextUserTargetWeight.setText("" + convertKgToPounds(stringGoalTargetWeight));
        }



        /* Listener */
        editTextUserWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                String weight = editTextUserWeight.getText().toString();
                String targetWeight = editTextUserTargetWeight.getText().toString();
                if (!weight.isEmpty() && !targetWeight.isEmpty()) {
                    //update currentWeight (temp)
                    DBAdapter db = getDbAdapter();
                    db.update("temp_goal", "_id", goalId, "t_goal_current_weight", db.quoteSmart(weight));


                    //update temp db
                    updateTempGoalDB();
                    String[] fields = {"t_goal_i_want_to"};
                    Cursor c = db.select("temp_goal", fields, "_id", goalId);
                    textViewUserWantTo.setText(c.getString(0));
                    db.close();
                }
            }
        });



        /* Weekly goal */
        String[] arr = getActivity().getResources().getStringArray(R.array.array_weekly_goal_kg);
        spinnerWeeklyGoal.setSelection(Arrays.asList(arr).indexOf(stringGoalWeeklyGoal));
        spinnerWeeklyGoal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateTempGoalDB();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        /*  ActivityLevel */
        spinnerActivityLevel.setSelection(Integer.parseInt(activityLevel));
        spinnerActivityLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateTempGoalDB();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        db.close();


        /* Numbers */
        updateTempTable(true);

        // Submit listener
        Button buttonSubmit = getActivity().findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goalEditGoalSubmit();
            }
        });

    }

    private void updateGoalWithCheckBoxSave() {
        DBAdapter db = getDbAdapter();

        /*Check box  Save*/
        //Energy
        if (checkBoxEnergyGoal.isChecked()) {
            db.update("goal", "_id", goalId, "goal_user_energy", 1);
        } else {
            db.update("goal", "_id", goalId, "goal_user_energy", 0);
        }
        //Protein
        if (checkBoxEnergyGoal.isChecked()) {
            db.update("goal", "_id", goalId, "goal_user_protein", 1);
        } else {
            db.update("goal", "_id", goalId, "goal_user_protein", 0);
        }
        //Carbs
        if (checkBoxEnergyGoal.isChecked()) {
            db.update("goal", "_id", goalId, "goal_user_carbs", 1);
        } else {
            db.update("goal", "_id", goalId, "goal_user_carbs", 0);
        }
        //Fat
        if (checkBoxEnergyGoal.isChecked()) {
            db.update("goal", "_id", goalId, "goal_user_fat", 1);
        } else {
            db.update("goal", "_id", goalId, "goal_user_fat", 0);
        }

        db.close();
    }

    private void updateTempGoalDB() {

        DBAdapter db = getDbAdapter();
        //dou int string
        double targetWeight = Double.parseDouble(editTextUserTargetWeight.getText().toString());

        /* Spinner WeeklyGoal*/
        String weeklyGoal = spinnerWeeklyGoal.getSelectedItem().toString();

        //ActivityLevel
        String activityLevel = String.valueOf(spinnerActivityLevel.getSelectedItemPosition());
        ChangeGoal.updateTempGoalDBMain(db, targetWeight, weeklyGoal, activityLevel);

        db.close();
        //update table
        updateTempTable(false);
    }


    private DBAdapter getDbAdapter() {
        DBAdapter db = new DBAdapter(getActivity());
        db.open();
        return db;
    }

    private void initializeData() {

        /* Get data from database */
        DBAdapter db = getDbAdapter();

        String[] fields = {
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
        if (stringGoalIWantTo.startsWith("l")) {
            ifYouWant = "If you want to loose weight ";
            method = "Loose " + stringGoalWeeklyGoal;
        } else if (stringGoalIWantTo.startsWith("g")) {
            ifYouWant = "If you want to gain weight ";
            method = "Gain " + stringGoalWeeklyGoal;
        } else {
            ifYouWant = "If you want to keep weight ";
            method = "Just keep ";
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
        updateTempTable(true);

        checkBoxAdvanced.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggleNumberViewGoal(isChecked);
            }
        });

        db.close();
    }

    private void updateTempTable(boolean firstTime) {
        // при начальной загрузке все подгружается с goal
        //При любом изменениии все сохраняется в tempGoal и подгружается оттуда
        //Update temp table (после любого изменения)
        //только полсе submit все сохраняем в бд

        DBAdapter db = getDbAdapter();
        Cursor goalCursor;
        String[] fields;
        if (firstTime) {

            //Get goal data
            fields = new String[]{
                "goal_energy_bmr ",
                "goal_protein_bmr ",
                "goal_carbs_bmr ",
                "goal_fat_bmr ",
                "goal_energy_diet ",
                "goal_protein_diet ",
                "goal_carbs_diet ",
                "goal_fat_diet ",
                "goal_energy_with_activity ",
                "goal_protein_with_activity ",
                "goal_carbs_with_activity ",
                "goal_fat_with_activity ",
                "goal_energy_with_activity_and_diet ",
                "goal_protein_with_activity_and_diet ",
                "goal_carbs_with_activity_and_diet ",
                "goal_fat_with_activity_and_diet "
            };
            goalCursor = db.select("goal", fields, "_id", 1);
        } else {
            //Get goal data
            fields = new String[]{
                "t_goal_energy_bmr ",
                "t_goal_protein_bmr ",
                "t_goal_carbs_bmr ",
                "t_goal_fat_bmr ",
                "t_goal_energy_diet ",
                "t_goal_protein_diet ",
                "t_goal_carbs_diet ",
                "t_goal_fat_diet ",
                "t_goal_energy_with_activity ",
                "t_goal_protein_with_activity ",
                "t_goal_carbs_with_activity ",
                "t_goal_fat_with_activity ",
                "t_goal_energy_with_activity_and_diet ",
                "t_goal_protein_with_activity_and_diet ",
                "t_goal_carbs_with_activity_and_diet ",
                "t_goal_fat_with_activity_and_diet "
            };
            goalCursor = db.select("temp_goal", fields, "_id", 1);
        }

        //Cursor goalCursor = db.select("goal", fields_goal, "_id", goalId);


        //Ready as variables
        String goal_energy_bmr = goalCursor.getString(0);
        String goal_protein_bmr = goalCursor.getString(1);
        String goal_carbs_bmr = goalCursor.getString(2);
        String goal_fat_bmr = goalCursor.getString(3);
        String goal_energy_diet = goalCursor.getString(4);
        String goal_protein_diet = goalCursor.getString(5);
        String goal_carbs_diet = goalCursor.getString(6);
        String goal_fat_diet = goalCursor.getString(7);
        String goal_energy_with_activity = goalCursor.getString(8);
        String goal_protein_with_activity = goalCursor.getString(9);
        String goal_carbs_with_activity = goalCursor.getString(10);
        String goal_fat_with_activity = goalCursor.getString(11);
        String goal_energy_with_activity_and_diet = goalCursor.getString(12);
        String goal_protein_with_activity_and_diet = goalCursor.getString(13);
        String goal_carbs_with_activity_and_diet = goalCursor.getString(14);
        String goal_fat_with_activity_and_diet = goalCursor.getString(15);

        //1 diet
        textViewEnergyLooseWithout.setText(goal_energy_diet);
        textViewProteinsLooseWithout.setText(goal_protein_diet);
        textViewCarbsLooseWithout.setText(goal_carbs_diet);
        textViewFatLooseWithout.setText(goal_fat_diet);


        //2 diet and activity
        textViewEnergyLooseWith.setText(goal_energy_with_activity_and_diet);
        textViewProteinsLooseWith.setText(goal_protein_with_activity_and_diet);
        textViewCarbsLooseWith.setText(goal_carbs_with_activity_and_diet);
        textViewFatLooseWith.setText(goal_fat_with_activity_and_diet);

        //3 BMR
        textViewEnergyKeepWithout.setText(goal_energy_bmr);
        textViewProteinsKeepWithout.setText(goal_protein_bmr);
        textViewCarbsKeepWithout.setText(goal_carbs_bmr);
        textViewFatKeepWithout.setText(goal_fat_bmr);

        //4 With activity
        textViewEnergyKeepWith.setText(goal_energy_with_activity);
        textViewProteinsKeepWith.setText(goal_protein_with_activity);
        textViewCarbsKeepWith.setText(goal_carbs_with_activity);
        textViewFatKeepWith.setText(goal_fat_with_activity);


        db.close();

    }

    public void toggleNumberViewGoal(boolean isChecked) {

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
    public void goalEditGoalSubmit() {
        errorMessage = "";
        if (checkBoxEnergyGoal.isChecked() && editTextEnergyGoal.getText().toString().isEmpty()) {
            errorMessage = "Energy mustn't be empty";
        }

        //Get Target Weight
        double doubleTargetWeight = getTargetWeight();

        /* Spinner WeeklyGoal*/
        String stringWeeklyGoal = spinnerWeeklyGoal.getSelectedItem().toString();

        /* Spinner ActivityLevel */
        String stringActivityLevel = spinnerActivityLevel.getSelectedItem().toString();


        //Error handling
        tryFinishSubmit(doubleTargetWeight, stringWeeklyGoal,stringActivityLevel);

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

    private void tryFinishSubmit(double targetWeight, String weeklyGoal,String activityLevel) {
        //Нет ошибки

        if (errorMessage.isEmpty()) {
            //Update database

            DBAdapter db = getDbAdapter();
            String weight = editTextUserWeight.getText().toString();
            db.update("goal", "_id", goalId, "goal_current_weight", db.quoteSmart(weight));
            db.update("goal", "_id", goalId, "goal_activity_level", db.quoteSmart(activityLevel));

            ChangeGoal.updateGoalDBMain(db, targetWeight, weeklyGoal);
            db.close();

            //Move to Goal (not edit)
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, new GoalFragment(), GoalFragment.class.getName()).commit();

        } else {
            //There is error
            Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();

        }
    }

}
package com.example.calorycounter.ui.profile;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.calorycounter.RegistrationActivity;
import com.example.calorycounter.ui.goal.ChangeGoal;
import com.example.calorycounter.database.DBAdapter;
import com.example.calorycounter.MainActivity;
import com.example.calorycounter.R;
import com.example.calorycounter.ui.home.HomeFragment;

import java.util.Locale;

import static com.example.calorycounter.helpers.ConvertClass.convertCmToFeetInchesFEET;
import static com.example.calorycounter.helpers.ConvertClass.convertCmToFeetInchesINCHES;
import static com.example.calorycounter.helpers.ConvertClass.convertFeetInchesToCm;

public class ProfileFragment extends Fragment {

    private String errorMessage = "";

    /* EditText --------------------------------------------------------------------------------- */
    private EditText editTextHeightCm;
    private EditText editTextHeightInches;
    private EditText editTextNickName;

    /* DataPicker ---------------------------------------------------------------------------------- */
    private DatePicker dataPicker;

    /* Spinner ---------------------------------------------------------------------------------- */
    private Spinner spinnerMeasurement;

    /* RadioGroup ------------------------------------------------------------------------------- */
    private RadioGroup radioGroupGender;

    private TextView textViewLogOut;

    private View mainView;


    private void setAllWidgets() {
        /* Spinner -------------------------------------------------------------------------------- */
        spinnerMeasurement = getActivity().findViewById(R.id.spinnerMeasurement);
        /* RadioGroup ---------------------------------------------------------------------------- */
        radioGroupGender = getActivity().findViewById(R.id.radioGroupGender);
        /* EditText ------------------------------------------------------------------------------- */
        editTextHeightCm = getActivity().findViewById(R.id.editTextHeightCm);
        editTextHeightInches = getActivity().findViewById(R.id.editTextHeightInches);
        editTextNickName = getActivity().findViewById(R.id.editTextNickName);
        /* DataPicker ------------------------------------------------------------------------------- */
        dataPicker = getActivity().findViewById(R.id.datePicker);

        textViewLogOut=getActivity().findViewById(R.id.textViewLogOut);
        Context context=getContext();
        textViewLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBAdapter db=getDbAdapter();
                db.deleteAll("users_in");
                db.close();
               Intent  i = new Intent(getActivity(), RegistrationActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Set title */
        changeTitle("Profile");

    }

    void changeTitle(String title) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(title);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        mainView = inflater.inflate(R.layout.fragment_profile, container, false);

        return mainView;
    }


    private DBAdapter getDbAdapter() {
        DBAdapter db = new DBAdapter(getActivity());
        db.open();
        return db;
    }

    //Set toolbar menu items
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setAllWidgets();
        initializeData();

    }

    public void initializeData() {

        /* Get data from data base */
        DBAdapter db = getDbAdapter();

        String[] fields = {
            "_id",
            "user_dob",
            "user_gender",
            "user_height",
            "user_measurement",
            "user_nickname"
        };
        Cursor cursor = db.select("users", fields, "_id", db.quoteSmart(MainActivity.USER_ID));
        String stringUserDOB = cursor.getString(1);
        String stringUserGender = cursor.getString(2);
        String stringUserHeight = cursor.getString(3);
        String stringUserMeasurement = cursor.getString(4);
        String stringUserEmail = cursor.getString(5);

        /* NickName */
        editTextNickName.setText(stringUserEmail);

        /* DOB */
        String[] items = stringUserDOB.split("-");
        String stringYear = items[0];
        String stringMonth = items[1];
        String stringDay = items[2];
        dataPicker.init(Integer.parseInt(stringYear), Integer.parseInt(stringMonth), Integer.parseInt(stringDay), null);

        /* Gender */
        RadioButton radioButtonGenderMale = getActivity().findViewById(R.id.radioButtonGenderMale);
        RadioButton radioButtonGenderFemale = getActivity().findViewById(R.id.radioButtonGenderFemale);
        if (stringUserGender.startsWith("m")) {
            radioButtonGenderMale.setChecked(true);
        } else {
            radioButtonGenderFemale.setChecked(true);
        }

        /* Measurement */
        Spinner spinnerMeasurement = getActivity().findViewById(R.id.spinnerMeasurement);
        if (stringUserMeasurement.startsWith("m")) {
            spinnerMeasurement.setSelection(0);
        } else {
            spinnerMeasurement.setSelection(1);
        }
        /* Listener */
        spinnerMeasurementListener();

        /* Height */
        editTextHeightCm.setText(stringUserHeight);

        Button buttonSave = getActivity().findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSaveOnClick();
            }
        });

    }

    private void buttonSaveOnClick() {

        String nickName = editTextNickName.getText().toString();
        if (nickName.isEmpty()) {
            errorMessage = "NickName mustn't be empty";
        }

        //DateOfBirth
        String stringDateOfBirth = getDOB();

        //Gender
        String stringGender = getGender();

        //Height
        double height = getHeight();

        //Measurement
        String measurement = spinnerMeasurement.getSelectedItem().toString().toLowerCase();

        //Error handling
        tryFinishSave(nickName, stringDateOfBirth, stringGender, height, measurement);


    }

    private void tryFinishSave(String nickName, String stringDateOfBirth, String stringGender,
                               double height, String measurement) {

        //Нет ошибки
        if (errorMessage.isEmpty()) {
            //Put data into database
            putDataToDB(nickName, stringDateOfBirth, stringGender, height, measurement);

        } else {
            Toast.makeText(getActivity(), "Error: " + errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    private void putDataToDB(String nickName, String stringDateOfBirth, String stringGender, double height, String measurement) {

        DBAdapter db = new DBAdapter(getActivity());
        db.open();

        //Quote smart
        String stringDateOfBirthSQL = db.quoteSmart(stringDateOfBirth);
        String stringGenderSQL = db.quoteSmart(stringGender);
        String heightSQL = db.quoteSmart("" + height);
        String measurementSQL = db.quoteSmart(measurement);
        String nickNameSQL = db.quoteSmart(nickName);


        String[] fieldsUser = {"user_dob",
            "user_gender",
            "user_height",
            "user_measurement",
            "user_nickname"};
        String[] values = {stringDateOfBirthSQL, stringGenderSQL, heightSQL, measurementSQL, nickNameSQL};

        db.update("users", "_id", db.quoteSmart( Long.parseLong( MainActivity.USER_ID)), fieldsUser, values);
        Toast.makeText(getActivity(), "Everything was saved :)", Toast.LENGTH_LONG).show();

        /* UpdateGoal Db */
        String[] fieldsGoal = {"goal_target_weight",
            "goal_weekly_goal",
        };
        Cursor cursorGoal = db.select("goal", fieldsGoal, "_id", db.quoteSmart( MainActivity.USER_ID));

        double targetWeight = cursorGoal.getDouble(0);
        String weeklyGoal = cursorGoal.getString(1);


        ChangeGoal.updateGoalDBMain(db, targetWeight, weeklyGoal);
        db.close();

        moveToHomeLayout();

    }

    private void moveToHomeLayout() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, new HomeFragment(), HomeFragment.class.getName()).addToBackStack(null).commit();
    }

    private String getGender() {
        //get selected radio button from selected group
        int selectedId = radioGroupGender.getCheckedRadioButtonId();
        //find button by id
        RadioButton radioButtonGender = getActivity().findViewById(selectedId);
        return (radioButtonGender.getText().toString()).toLowerCase(Locale.ROOT);
    }

    private String getDOB() {
        //DateOfBirth Day
        String stringDOBDay = String.valueOf(dataPicker.getDayOfMonth());

        //DateOfBirth Month
        String stringDOBMonth = String.valueOf(dataPicker.getMonth());

        //DateOfBirth Year
        String stringDOBYear = String.valueOf(dataPicker.getYear());

        //Put date of birth together
        String dateOfBirth = stringDOBYear + "-" + stringDOBMonth + "-" + stringDOBDay;
        return dateOfBirth;
    }

    private boolean isMetric() {
        String stringMeasurement = spinnerMeasurement.getSelectedItem().toString();
        return !stringMeasurement.startsWith("I");
    }

    private double getHeight() {
        String stringHeightCm = editTextHeightCm.getText().toString();
        String stringHeightInches = editTextHeightInches.getText().toString();

        double heightCm = 0;

        if (isMetric()) {
            //Convert cm
            try {
                heightCm = Double.parseDouble(stringHeightCm);
            } catch (NumberFormatException nfe) {
                errorMessage = "Height has to be number";
            }
        } else {
            //Convert  inches
            try {
                //cm= ((foot*12)+inches)*2.54
                heightCm = convertFeetInchesToCm(stringHeightCm, stringHeightInches);

            } catch (NumberFormatException nfe) {
                errorMessage = "Height has to be number";
            }
        }
        System.out.println();
        System.out.println(heightCm);
        System.out.println();
        return heightCm;
    }

    private void spinnerMeasurementListener() {
        //Measurement spinner
        spinnerMeasurement.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onMeasurementChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //onMeasurementChanged();
            }
        });
    }
    /* Measurement Changed --------------------------------------------------------------------- */

    private void onMeasurementChanged() {

        String stringMeasurement = spinnerMeasurement.getSelectedItem().toString();

        String stringHeightCm = editTextHeightCm.getText().toString();
        String stringHeightInches = editTextHeightInches.getText().toString();

        editTextHeightInches.setVisibility(View.GONE);

        //editTextHeightInches.setVisibility(View.GONE);
        TextView textViewCm = getActivity().findViewById(R.id.textViewCm);

        if (stringMeasurement.startsWith("I")) {
            //Imperial
            editTextHeightInches.setVisibility(View.VISIBLE);
            textViewCm.setText(R.string.feetInches);

            //Change Cm to Feet and Inches
            if (!stringHeightCm.isEmpty()) {
                // feet = (cm* 0.3937008)/12
                editTextHeightCm.setText("" + convertCmToFeetInchesFEET(stringHeightCm));
                editTextHeightInches.setText("" + convertCmToFeetInchesINCHES(stringHeightCm));
            }

        } else {
            //Metric
            editTextHeightInches.setVisibility(View.GONE);
            textViewCm.setText(R.string.cm);

            //Change Feet and Inches to Cm
            if (!stringHeightCm.isEmpty() && !stringHeightInches.isEmpty()) {
                editTextHeightCm.setText("" + convertFeetInchesToCm(stringHeightCm, stringHeightInches));
            }
        }
    }//public void measureChanged
}
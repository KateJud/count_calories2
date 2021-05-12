package com.example.dietstram;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SignUp extends AppCompatActivity {

    /* ------------------------------------------------------------------------------------------ */
    /*                                                                                            */
    /*                                       Variables                                            */
    /*                                                                                            */
    /* ------------------------------------------------------------------------------------------ */

    /* My fields -------------------------------------------------------------------------------- */
    private String errorMessage = "";

    /* Widgets fields --------------------------------------------------------------------------- */

    /* ImageView -------------------------------------------------------------------------------- */
    private ImageView imageViewError;

    /* EditText --------------------------------------------------------------------------------- */
    private EditText editTextEmail;
    private EditText editTextHeightCm;
    private EditText editTextHeightInches;
    private EditText editTextWeight;

    /* TextView --------------------------------------------------------------------------------- */
    private TextView textViewErrorMessage;

    /* Button ----------------------------------------------------------------------------------- */
    private Button buttonSignUp;

    /* Spinner ---------------------------------------------------------------------------------- */
    private Spinner spinnerMeasurement;
    private Spinner spinnerActivityLevel;

    /* DataPicker ---------------------------------------------------------------------------------- */
    private DatePicker dataPicker;


    /* RadioGroup ------------------------------------------------------------------------------- */
    private RadioGroup radioGroupGender;
    /* RadioButton ------------------------------------------------------------------------------ */


    private void setAllWidgets() {

        /* ImageView */
        imageViewError = findViewById(R.id.imageViewError);

        /* EditText ------------------------------------------------------------------------------- */
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextHeightCm = findViewById(R.id.editTextHeightCm);
        editTextHeightInches = findViewById(R.id.editTextHeightInches);
        editTextWeight = findViewById(R.id.editTextWeight);

        /* TextView ------------------------------------------------------------------------------- */
        textViewErrorMessage = findViewById(R.id.textViewErrorMessage);
        //textViewEmail = findViewById(R.id.textViewEmail);

        /* Button --------------------------------------------------------------------------------- */
        buttonSignUp = findViewById(R.id.buttonSignUp);

        /* Spinner -------------------------------------------------------------------------------- */
        spinnerMeasurement = findViewById(R.id.spinnerMeasurement);
        spinnerActivityLevel = findViewById(R.id.spinnerActivityLevel);

        /* RadioGroup ---------------------------------------------------------------------------- */
        radioGroupGender = findViewById(R.id.radioGroupGender);
        /* DataPicker ------------------------------------------------------------------------------- */
        dataPicker = findViewById(R.id.datePicker);


    }

    /* ------------------------------------------------------------------------------------------ */
    /*                                                                                            */
    /*                                       OnCreate                                             */
    /*                                                                                            */
    /* ------------------------------------------------------------------------------------------ */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        setAllWidgets();

        /*Sign up */
        /*Listener*/
        buttonSignUpListener();

        /*Hide error and message */
        hideError();

        /*Hide inches field*/
        hideInches();

        /*Listener measurement spinner*/
        spinnerMeasurementListener();


    }//protected void onCreate


    /* Styles ----------------------------------------------------------------------------------- */

    private void hideInches() {
        editTextHeightInches.setVisibility(View.GONE);
    }

    private void hideError() {
        textViewErrorMessage.setVisibility(View.GONE);
        imageViewError.setVisibility(View.GONE);
    }

    /* ------------------------------------------------------------------------------------------ */
    /*                                                                                            */
    /*                                       Listeners                                            */
    /*                                                                                            */
    /* ------------------------------------------------------------------------------------------ */

    /* SignUp ----------------------------------------------------------------------------------- */

    private void buttonSignUpListener() {
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpSubmit();
            }
        });
    }

    /* Measure ----------------------------------------------------------------------------------- */

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
        String stringWeight = editTextWeight.getText().toString();

        editTextHeightInches.setVisibility(View.GONE);

        //editTextHeightInches.setVisibility(View.GONE);
        TextView textViewCm = findViewById(R.id.textViewCm);
        TextView textViewKg = findViewById(R.id.textViewKg);

        if (stringMeasurement.startsWith("I")) {
            //Imperial
            editTextHeightInches.setVisibility(View.VISIBLE);
            textViewCm.setText("feet and inches");
            textViewKg.setText("pounds");

            //Change Cm to Feet and Inches
            if (!stringHeightCm.isEmpty()) {
                // feet = (cm* 0.3937008)/12
                editTextHeightCm.setText("" + convertCmToFeetInchesFEET(stringHeightCm));
                editTextHeightInches.setText("" + convertCmToFeetInchesINCHES(stringHeightCm));
            }

            //Change Kg to Pounds
            if (!stringWeight.isEmpty()) {
                editTextWeight.setText("" + convertKgToPounds(stringWeight));
            }

        } else {

            //Metric
            editTextHeightInches.setVisibility(View.GONE);
            textViewCm.setText("cm");
            textViewKg.setText("kg");

            //Change Feet and Inches to Cm
            if (!stringHeightCm.isEmpty() && !stringHeightInches.isEmpty()) {
                editTextHeightCm.setText("" + convertFeetInchesToCm(stringHeightCm, stringHeightInches));
            }

            //Change Pounds to Kg
            if (!stringWeight.isEmpty()) {
                editTextWeight.setText("" + convertPoundsToKg(stringWeight));
            }
        }

        Toast.makeText(this, "Metric", Toast.LENGTH_SHORT).show();
    }//public void measureChanged


    /* Convert ------------------------------------------------------------------------------------ */

    private long convertCmToFeetInchesFEET(String stringHeightCm) {

        double heightCm = Double.parseDouble(stringHeightCm);
        return Math.round((heightCm / 2.54) / 12);
    }

    private long convertCmToFeetInchesINCHES(String stringHeightCm) {
        double heightCm = Double.parseDouble(stringHeightCm);
        double heightInchesTotal = heightCm / 2.54;
        double heightFeet = heightInchesTotal - 12 * convertCmToFeetInchesFEET(stringHeightCm);
        return Math.round(heightFeet);
    }

    private long convertFeetInchesToCm(String stringHeightFeet, String stringHeightInches) {

        double heightFeet = Double.parseDouble(stringHeightFeet);
        double heightInches = Double.parseDouble(stringHeightInches);
        return Math.round(((heightFeet * 12) + heightInches) * 2.54);
    }

    private long convertKgToPounds(String stringKg) {
        return Math.round(Double.parseDouble(stringKg) / 0.45359237);
    }

    private long convertPoundsToKg(String stringPounds) {
        return Math.round(Double.parseDouble(stringPounds) * 0.45359237);
    }


    /*Sign up Submit ---------------------------------------------------------------------------- */
    private void signUpSubmit() {
        errorMessage = "";

        //Email
        String stringEmail = getEmail();

        //DateOfBirth
        String stringDateOfBirth = getDOB();

        //Gender
        String stringGender = getGender();

        //Height
        double height = getHeight();

        //Weight
        double weight = getWeight();

        //Activity level
        int positionActivityLevel = spinnerActivityLevel.getSelectedItemPosition();

        //Error handling
        tryFinishSignUp(stringEmail, stringDateOfBirth, stringGender, height, weight,
            positionActivityLevel);

    }

    private void tryFinishSignUp(String stringEmail, String stringDateOfBirth, String stringGender,
                                 double height, double weight, int positionActivityLevel) {
        //Нет ошибки
        textViewErrorMessage.setText(errorMessage);
        if (errorMessage.isEmpty()) {
            //Put data into database

            putDataToDB(stringEmail, stringDateOfBirth, stringGender, height, weight,
                positionActivityLevel);

            hideError();

            //Move MainActivity
            Intent i = new Intent(SignUp.this, SignUpGoal.class);
            startActivity(i);
        } else {
            //There is error
            textViewErrorMessage.setVisibility(View.VISIBLE);
            imageViewError.setVisibility(View.VISIBLE);

        }
    }

    /* Additional Methods ---------------------------------------------------------------------- */

    private void putDataToDB(String stringEmail, String stringDateOfBirth, String stringGender,
                             double height, double weight, int positionActivityLevel) {
        DBAdapter db = new DBAdapter(this);
        //Quote smart

        //For users
        String stringInput = getInputToDB(stringEmail, stringDateOfBirth, stringGender, height,
            positionActivityLevel, db);

        //For goal
        String stringInput2 = getInputToDB2(weight, db);

        db.open();
        db.insert("users",
            "_id, user_email, user_dob, user_gender, user_height, user_activity_level, user_measurement",
            stringInput);

        db.insert("goal",
            "_id, goal_current_weight, goal_date",
            stringInput2);
        db.close();
    }

    private String getInputToDB(String stringEmail, String stringDateOfBirth, String stringGender,
                                double height, int positionActivityLevel, DBAdapter db) {
        String stringEmailSQL = db.quoteSmart(stringEmail);
        String stringDateOfBirthSQL = db.quoteSmart(stringDateOfBirth);
        String stringGenderSQL = db.quoteSmart(stringGender);
        String stringMeasurement = (spinnerMeasurement.getSelectedItem().toString())
            .toLowerCase(Locale.ROOT);
        String stringMeasurementSQL = db.quoteSmart(stringMeasurement);

        double heightCmSQL = db.quoteSmart(height);
        int activityLevelSQL = db.quoteSmart(positionActivityLevel);

        String stringInput =
            "NULL " + "," + stringEmailSQL + "," + stringDateOfBirthSQL + "," + stringGenderSQL + ","
                + heightCmSQL + "," + activityLevelSQL + "," + stringMeasurementSQL;
        return stringInput;
    }

    private String getInputToDB2(double weight, DBAdapter db) {

        //CurrentData
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String goalDate = dateFormat.format(Calendar.getInstance().getTime());

        String goalDateSQL = db.quoteSmart(goalDate);
        double weightKgSQL = db.quoteSmart(weight);

        String stringInput2 =
            "NULL " + "," + weightKgSQL + "," + goalDateSQL;
        return stringInput2;
    }

    private double getWeight() {
        String stringWeight = editTextWeight.getText().toString();
        double doubleWeight = 0;
        try {
            doubleWeight = Double.parseDouble(stringWeight);
        } catch (NumberFormatException nfe) {

            errorMessage = "Weight has to be number";
        }
        if (!isMetric()) {
            //Imperial
            //Pound to Kg
            doubleWeight = convertPoundsToKg(stringWeight);
        }
        return doubleWeight;
    }

    private boolean isMetric() {
        String stringMeasurement = spinnerMeasurement.getSelectedItem().toString();
        return !stringMeasurement.startsWith("I");
    }

    private double getHeight() {
        String stringHeightCm = editTextHeightCm.getText().toString();
        String stringHeightInches = editTextHeightInches.getText().toString();

        double heightCm = 0;
        boolean metric = true;

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
        return heightCm;
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


    private String getGender() {
        //get selected radio button from selected group
        int selectedId = radioGroupGender.getCheckedRadioButtonId();
        //find button by id
        RadioButton radioButtonGender = findViewById(selectedId);
        String stringGender = (radioButtonGender.getText().toString()).toLowerCase(Locale.ROOT);
        return stringGender;
    }


    private String getEmail() {

        String stringEmail = editTextEmail.getText().toString();
        Toast.makeText(this, "Hi, " + stringEmail + "!", Toast.LENGTH_SHORT).show();

        if (stringEmail.isEmpty() || stringEmail.startsWith(" ")) {
            //   textViewEmail.setTextColor(Color.RED);
            errorMessage = "Please fill in an e-mail address";
            textViewErrorMessage.setText(errorMessage);
        } else {
//      textViewEmail.setTextColor(Color.DKGRAY);
        }
        return stringEmail;
    }


}

package com.example.calorycounter.ui.signup;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.calorycounter.MainActivity;
import com.example.calorycounter.database.DBAdapter;
import com.example.calorycounter.R;

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
    private EditText editTextNickName;
    private EditText editTextPassword;
    private EditText editTextHeightCm;
    private EditText editTextHeightInches;
    private EditText editTextWeight;

    /* TextView --------------------------------------------------------------------------------- */
    private TextView textViewErrorMessage;
    private TextView textViewHeight;
    private TextView textViewWeight;

    /* Button ----------------------------------------------------------------------------------- */
    private Button buttonSignUp;

    /* Spinner ---------------------------------------------------------------------------------- */
    private Spinner spinnerMeasurement;


    /* DataPicker ---------------------------------------------------------------------------------- */
    private DatePicker dataPicker;

    /* RadioGroup ------------------------------------------------------------------------------- */
    private RadioGroup radioGroupGender;
    /* RadioButton ------------------------------------------------------------------------------ */

    private void setAllWidgets() {

        /* ImageView */
        imageViewError = findViewById(R.id.imageViewError);

        /* EditText ------------------------------------------------------------------------------- */
        editTextNickName = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextHeightCm = findViewById(R.id.editTextHeightCm);
        editTextHeightInches = findViewById(R.id.editTextHeightInches);
        editTextWeight = findViewById(R.id.editTextWeight);

        /* TextView ------------------------------------------------------------------------------- */
        textViewErrorMessage = findViewById(R.id.textViewErrorMessage);
        textViewWeight = findViewById(R.id.textViewWeight);
        textViewHeight = findViewById(R.id.textViewHeight);


        /* Button --------------------------------------------------------------------------------- */
        buttonSignUp = findViewById(R.id.buttonSignUp);

        /* Spinner -------------------------------------------------------------------------------- */
        spinnerMeasurement = findViewById(R.id.spinnerMeasurement);


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

        /*Listener nickName*/
        onNickNameChanged();

        /*Listener*/
        buttonSignUpListener();

        /*Hide error and message */
        hideError();

        /*Hide inches field*/
        hideInches();

        /*Listener measurement spinner*/
        spinnerMeasurementListener();


    }//protected void onCreate

    private void onNickNameChanged() {
        final Context context=this;

        editTextNickName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
//if()
                //Если такой уже есть user тогда
                String[] fieldsUser={
                    "user_nickname"
                };
                DBAdapter db=new DBAdapter(context);
                db.open();
                String currentNick=db.quoteSmart( editTextNickName.getText().toString());

                Cursor cursor=db.select("users",fieldsUser,"user_nickname",currentNick);
                if(cursor.getCount()==0){
                    editTextNickName.setBackgroundResource (R.drawable.et_bg);
                }else {
                    editTextNickName.setBackgroundResource (R.drawable.et_bg_error);
                }

                    db.close();

            }
        });
    }


    @Override public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

        //Toast.makeText(this,"back",Toast.LENGTH_LONG).show();
    }

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
            textViewCm.setText(getResources().getString(R.string.feetInches));
            textViewKg.setText(getResources().getString(R.string.pounds));

            //Change Cm to Feet and Inches
            if (!stringHeightCm.isEmpty()) {
                // feet = (cm* 0.3937008)/12
                editTextHeightCm.setText(String.format(getResources().getString(R.string.format_long), convertCmToFeetInchesFEET(stringHeightCm)));
                editTextHeightInches.setText(String.format(getResources().getString(R.string.format_long), convertCmToFeetInchesINCHES(stringHeightCm)));
            }

            //Change Kg to Pounds
            if (!stringWeight.isEmpty()) {
                editTextWeight.setText(String.format(getResources().getString(R.string.format_long), convertKgToPounds(stringWeight)));
            }

        } else {

            //Metric
            editTextHeightInches.setVisibility(View.GONE);
            textViewCm.setText(getResources().getString(R.string.cm));
            textViewKg.setText(getResources().getString(R.string.kg));

            //Change Feet and Inches to Cm
            if (!stringHeightCm.isEmpty() && !stringHeightInches.isEmpty()) {
                editTextHeightCm.setText(String.format(getResources().getString(R.string.format_long), convertFeetInchesToCm(stringHeightCm, stringHeightInches)));
            }

            //Change Pounds to Kg
            if (!stringWeight.isEmpty()) {
                editTextWeight.setText(String.format(getResources().getString(R.string.format_long), convertPoundsToKg(stringWeight)));
            }
        }

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

        //NickName
        String stringNickName = getNickName();

        //Email
        String stringPassword = getPassword();

        //DateOfBirth
        String stringDateOfBirth = getDOB();

        //Gender
        String stringGender = getGender();

        //Height
        double height = getHeight();

        //Weight
        double weight = getWeight();


        //Error handling
        tryFinishSignUp(stringNickName,stringPassword, stringDateOfBirth, stringGender, height, weight);

    }

    private void tryFinishSignUp(String stringEmail,String stringPassword , String stringDateOfBirth, String stringGender,
                                 double height, double weight) {
        //Нет ошибки
        textViewErrorMessage.setText(errorMessage);
        if (errorMessage.isEmpty()) {

            //Put data into database
            putDataToDB(stringEmail,stringPassword, stringDateOfBirth, stringGender, height, weight);
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

    private void putDataToDB(String stringEmail,String stringPassword, String stringDateOfBirth, String stringGender,
                             double height, double weight) {
        DBAdapter db = new DBAdapter(this);
        //Quote smart

        //For users
        String stringInput = getInputToDB(stringEmail,stringPassword, stringDateOfBirth, stringGender, height, db);

        //For goal
        String stringInput2 = getInputToDB2(weight, db);

        db.open();
        db.insert("users",
            "_id, user_nickname, user_password, user_dob, user_gender, user_height, user_measurement",
            stringInput);
        Cursor currentUserId= db.select("users",new String[]{"_id"},"user_nickname",db.quoteSmart( stringEmail));
        MainActivity.USER_ID= currentUserId.getString(0);

        db.insert("goal",
            "_id, goal_current_weight, goal_date",
            stringInput2);
        db.close();
    }

    private String getInputToDB(String stringEmail,String stringPassword ,String stringDateOfBirth, String stringGender,
                                double height,  DBAdapter db) {
        String stringEmailSQL = db.quoteSmart(stringEmail);
        String stringPasswordSQL = db.quoteSmart(stringPassword);
        String stringDateOfBirthSQL = db.quoteSmart(stringDateOfBirth);
        String stringGenderSQL = db.quoteSmart(stringGender);
        String stringMeasurement = (spinnerMeasurement.getSelectedItem().toString())
            .toLowerCase(Locale.ROOT);
        String stringMeasurementSQL = db.quoteSmart(stringMeasurement);

        double heightCmSQL = db.quoteSmart(height);

        return "NULL " + "," + stringEmailSQL + ","  + stringPasswordSQL + "," + stringDateOfBirthSQL + "," + stringGenderSQL + ","
            + heightCmSQL + ","  + stringMeasurementSQL;
    }

    private String getInputToDB2(double weight, DBAdapter db) {

        //CurrentData
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String goalDate = dateFormat.format(Calendar.getInstance().getTime());

        String goalDateSQL = db.quoteSmart(goalDate);
        double weightKgSQL = db.quoteSmart(weight);

        return "NULL " + "," + weightKgSQL + "," + goalDateSQL;
    }

    private double getWeight() {
        String stringWeight = editTextWeight.getText().toString();
        double doubleWeight = 0;
        try {
            doubleWeight = Double.parseDouble(stringWeight);
            textViewWeight.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.login_form_details)));

        } catch (NumberFormatException nfe) {

            errorMessage = "Weight has to be number";
            textViewWeight.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.my_red)));
        }
        if (!isMetric()) {
            //Imperial
            //Pound to Kg
            return convertPoundsToKg(stringWeight);
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


        if (isMetric()) {
            //Convert cm
            try {
                textViewHeight.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.login_form_details)));
                return Double.parseDouble(stringHeightCm);
            } catch (NumberFormatException nfe) {
                errorMessage = "Height has to be number";
                textViewHeight.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.my_red)));
            }
        } else {
            //Convert  inches
            try {
                //cm= ((foot*12)+inches)*2.54
                return convertFeetInchesToCm(stringHeightCm, stringHeightInches);

            } catch (NumberFormatException nfe) {
                errorMessage = "Height has to be number";
            }
        }
        return 0;
    }


    private String getDOB() {
        //DateOfBirth Day
        String stringDOBDay = String.valueOf(dataPicker.getDayOfMonth());

        //DateOfBirth Month
        String stringDOBMonth = String.valueOf(dataPicker.getMonth());

        //DateOfBirth Year
        String stringDOBYear = String.valueOf(dataPicker.getYear());

        //Put date of birth together
        return stringDOBYear + "-" + stringDOBMonth + "-" + stringDOBDay;
    }


    private String getGender() {
        //get selected radio button from selected group
        int selectedId = radioGroupGender.getCheckedRadioButtonId();
        //find button by id
        RadioButton radioButtonGender = findViewById(selectedId);
        return (radioButtonGender.getText().toString()).toLowerCase(Locale.ROOT);
    }


    private String getNickName() {

        String stringNickName =
            editTextNickName.getText().toString();

        if (stringNickName.isEmpty() || editTextNickName.getBackground().getConstantState()==ContextCompat.getDrawable(this,R.drawable.et_bg_error).getConstantState()) {
            errorMessage = "Please fill in a unique nickName";
            editTextNickName.setHintTextColor(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.my_red)));
            textViewErrorMessage.setText(errorMessage);
        }
        return stringNickName;
    }

    private String getPassword() {

        String stringPassword = editTextPassword.getText().toString();

        if (stringPassword.isEmpty()) {
            errorMessage = "Please fill in your password";
            editTextPassword.setHintTextColor(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.my_red)));
            textViewErrorMessage.setText(errorMessage);
        }
        return stringPassword;
    }


}

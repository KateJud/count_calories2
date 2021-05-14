package com.example.dietstram.ui.signup;

import android.content.Intent;
import android.content.res.ColorStateList;
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
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.dietstram.ui.goal.ChangeGoal;
import com.example.dietstram.database.DBAdapter;
import com.example.dietstram.MainActivity;
import com.example.dietstram.R;

public class SignUpGoal extends AppCompatActivity {

    /* ------------------------------------------------------------------------------------------ */
    /*                                                                                            */
    /*                                       Variables                                            */
    /*                                                                                            */
    /* ------------------------------------------------------------------------------------------ */

    /* My fields -------------------------------------------------------------------------------- */
    private String errorMessage = "";

    /* Widgets fields --------------------------------------------------------------------------- */

    /* ImageView ------------------------------------------------------------------------------ */
    private ImageView imageViewError;

    /* EditText ------------------------------------------------------------------------------- */
    private EditText editTextTargetWeight;

    /* TextView --------------------------------------------------------------------------------- */
    private TextView textViewErrorMessage;
    private TextView textViewTargetWeight;
    private TextView textViewKg;

    /* Button --------------------------------------------------------------------------- */
    private Button buttonSubmit;

    /* Spinner --------------------------------------------------------------------------- */
    private Spinner spinnerWeeklyGoal;
    private Spinner spinnerActivityLevel;


    private void setAllWidgets() {

        /* ImageView */
        imageViewError = findViewById(R.id.imageViewError);

        /* EditText ------------------------------------------------------------------------------- */
        editTextTargetWeight = findViewById(R.id.editTextTargetWeight);


        /* TextView --------------------------------------------------------------------------------- */
        textViewErrorMessage = findViewById(R.id.textViewErrorMessage);
        textViewKg = findViewById(R.id.textViewKg);
        textViewTargetWeight = findViewById(R.id.textViewTargetWeight);


        /* Button --------------------------------------------------------------------------- */
        buttonSubmit = findViewById(R.id.buttonSubmit);

        /* Spinner --------------------------------------------------------------------------- */
        spinnerWeeklyGoal = findViewById(R.id.spinnerWeeklyGoalB);
        spinnerActivityLevel = findViewById(R.id.spinnerActivityLevel);

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

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

        //Toast.makeText(this,"back",Toast.LENGTH_LONG).show();
    }

    /* MeasurementUsed */
    public void measurementUsed() {
        DBAdapter db = new DBAdapter(this);
        db.open();

        /* Get row number one from users */
        String[] fields = new String[]{"_id", "user_measurement"};

        Cursor cursor = db.select("users", fields, "_id", db.quoteSmart(MainActivity.USER_ID));
        String measurement = cursor.getString(1);

        // Toast.makeText(this,"Measure: "+measurement,Toast.LENGTH_LONG).show();

        db.close();

        if (!measurement.startsWith("m")) {
            //Imperial

            //Kg to pounds
            textViewKg.setText("pounds");
        }  //Metric


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

//Activity level
        int positionActivityLevel = spinnerActivityLevel.getSelectedItemPosition();

        /* Spinner WeeklyGoal*/
        //0: carefully
        //1: quickly
        String stringWeeklyGoal = String.valueOf(spinnerWeeklyGoal.getSelectedItemPosition());

        //Error handling
        tryFinishSignUp(doubleTargetWeight, stringWeeklyGoal, positionActivityLevel);

    }

    private double getTargetWeight() {
        String stringTargetWeight = editTextTargetWeight.getText().toString();
        double doubleTargetWeight = 0;
        try {
            doubleTargetWeight = Double.parseDouble(stringTargetWeight);
            textViewTargetWeight.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.login_form_details)));

        } catch (NumberFormatException nfe) {
            errorMessage = "Target weight has to be a number.";
            textViewTargetWeight.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.my_red)));

        }
        return doubleTargetWeight;
    }

    private void tryFinishSignUp(double targetWeight, String weeklyGoal, int activityLevel) {
        //Нет ошибки
        textViewErrorMessage.setText(errorMessage);
        if (errorMessage.isEmpty()) {
            //Update database

            DBAdapter db = new DBAdapter(this);
            db.open();
            db.update("users", "_id", db.quoteSmart(Integer.parseInt(MainActivity.USER_ID)), "user_activity_level", db.quoteSmart(activityLevel));
            db.insert("temp_goal", "_id", "NULL");
            ChangeGoal.updateGoalDBMain(db, targetWeight, weeklyGoal);
            db.close();

            hideError();

            /* ------------*/
            DBAdapter db2 = new DBAdapter(this);
            db2.open();
            db2.insert("users_in", "users_i_id", db.quoteSmart(MainActivity.USER_ID));
            db2.close();
            /* ------------*/


            //Move MainActivity
            Intent i = new Intent(SignUpGoal.this, MainActivity.class);
            startActivity(i);
        } else {
            //There is error
            textViewErrorMessage.setVisibility(View.VISIBLE);
            imageViewError.setVisibility(View.VISIBLE);

        }
    }


}

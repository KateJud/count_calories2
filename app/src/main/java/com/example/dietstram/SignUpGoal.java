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


    /* Button --------------------------------------------------------------------------- */
    buttonSubmit = findViewById(R.id.buttonSubmit);

    /* Spinner --------------------------------------------------------------------------- */
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

//    //Spinner WantTo
//    //0: loose
//    //1: gain
//    int positionWantTo = spinnerWantTo.getSelectedItemPosition();


    /* Spinner WeeklyGoal*/
    //0: carefully
    //1: quickly
    String stringWeeklyGoal =String.valueOf( spinnerWeeklyGoal.getSelectedItemPosition());

    //Error handling
    tryFinishSignUp(doubleTargetWeight, stringWeeklyGoal);

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

  private void tryFinishSignUp(double targetWeight, String weeklyGoal) {
    //Нет ошибки
    textViewErrorMessage.setText(errorMessage);
    if (errorMessage.isEmpty()) {
      //Update database


      DBAdapter db = new DBAdapter(this);
      db.open();
      db.insert("temp_goal", "_id", "NULL");
      ChangeGoal.updateGoalDBMain(db,targetWeight, weeklyGoal);
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


}

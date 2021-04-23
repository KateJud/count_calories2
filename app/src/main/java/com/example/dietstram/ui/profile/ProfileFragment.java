package com.example.dietstram.ui.profile;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.dietstram.DBAdapter;
import com.example.dietstram.MainActivity;
import com.example.dietstram.R;

import java.util.Calendar;
import java.util.Locale;

import static com.example.dietstram.OpenCloseDB.convertCmToFeetInchesFEET;
import static com.example.dietstram.OpenCloseDB.convertCmToFeetInchesINCHES;
import static com.example.dietstram.OpenCloseDB.convertFeetInchesToCm;
import static com.example.dietstram.OpenCloseDB.convertKgToPounds;
import static com.example.dietstram.OpenCloseDB.convertPoundsToKg;

public class ProfileFragment extends Fragment {

    private String errorMessage = "";

    /* EditText --------------------------------------------------------------------------------- */
    private EditText editTextHeightCm;
    private EditText editTextHeightInches;


    /* Spinner ---------------------------------------------------------------------------------- */
    private Spinner spinnerMeasurement;
    private Spinner spinnerDOBYear;
    private Spinner spinnerDOBMonth;
    private Spinner spinnerDOBDay;
    /* RadioGroup ------------------------------------------------------------------------------- */
    private RadioGroup radioGroupGender;

    /* Action buttons */
    MenuItem menuItemEdit;
    MenuItem menuItemDelete;

    private ProfileViewModel profileViewModel;
    private View mainView;

////Todo
//    privite  OnFragmentInteractionListener mListener;


    private void setAllWidgets() {
        /* Spinner -------------------------------------------------------------------------------- */
        spinnerMeasurement =  getActivity().findViewById(R.id.spinnerMeasurement);
        spinnerDOBDay = getActivity().findViewById(R.id.spinnerDOBDay);
        spinnerDOBYear = getActivity().findViewById(R.id.spinnerDOBYear);
        spinnerDOBMonth = getActivity().findViewById(R.id.spinnerDOBMonth);
        /* RadioGroup ---------------------------------------------------------------------------- */
        radioGroupGender = getActivity().findViewById(R.id.radioGroupGender);
        /* EditText ------------------------------------------------------------------------------- */
        editTextHeightCm = getActivity().findViewById(R.id.editTextHeightCm);
        editTextHeightInches = getActivity().findViewById(R.id.editTextHeightInches);
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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
            ViewModelProviders.of(this).get(ProfileViewModel.class);
        mainView = inflater.inflate(R.layout.fragment_profile, container, false);

        return mainView;
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
        ((MainActivity) getActivity()).getMenuInflater().inflate(R.menu.menu_food, menu);

        //Assign variables
        menuItemEdit = menu.findItem(R.id.action_food_edit);
        menuItemDelete = menu.findItem(R.id.action_food_delete);

        //Hide as default
        menuItemEdit.setVisible(false);
        menuItemDelete.setVisible(false);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
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

//        setHasOptionsMenu(true);
    }

    public void initializeData() {


        /* Get data from data base */
        DBAdapter db = getDbAdapter();
        //TODO
        long longRowId = 1;
        String fields[] = {
            "_id",
            "user_dob",
            "user_gender",
            "user_height",
            "user_measurement"
        };
        Cursor cursor = db.select("users", fields, "_id", longRowId);
        String stringUserDOB = cursor.getString(1);
        String stringUserGender = cursor.getString(2);
        String stringUserHeight = cursor.getString(3);
        String stringUserMeasurement = cursor.getString(4);

        /* DOB */

        String[] items = stringUserDOB.split("-");
        String stringYear = items[0];
        String stringMonth = items[1];
        String stringDay = items[2];

        /* DOB: Day */
        fillDays(stringDay);
        /* DOB: Month */
        fillMonth(stringMonth);
        /* DOB: year */
        fillYears(stringYear);

        /* Gender */
        RadioButton radioButtonGenderMale = getActivity().findViewById(R.id.radioButtonGenderMale);
        RadioButton radioButtonGenderFemale = getActivity().findViewById(R.id.radioButtonGenderFemale);
        if (stringUserGender.startsWith("m")) {
            radioButtonGenderMale.setChecked(true);
        } else {
            radioButtonGenderFemale.setChecked(true);
        }


        /* Height */

        TextView textViewHeightCm = getActivity().findViewById(R.id.textViewCm);
        EditText editTextHeightCm = getActivity().findViewById(R.id.editTextHeightCm);
        EditText editTextHeightInches = getActivity().findViewById(R.id.editTextHeightInches);
        if (stringUserMeasurement.startsWith("m")) {
            editTextHeightInches.setVisibility(View.GONE);
            editTextHeightCm.setText(stringUserHeight);
        } else {
            textViewHeightCm.setText("feet and inches");
            double heightCm = Double.parseDouble(stringUserHeight);
            double heightFeet = 0;
            double heightInches = 0;
            heightFeet = heightCm * 0.3937008 / 12;
            editTextHeightCm.setText("" + (int) heightFeet);

        }



        /* Measurement */
        Spinner spinnerMeasurement = getActivity().findViewById(R.id.spinnerMeasurement);
        if (stringUserMeasurement.startsWith("m")) {
            spinnerMeasurement.setSelection(0);
        } else {
            spinnerMeasurement.setSelection(1);
        }

        Button buttonSave = getActivity().findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSaveOnClick();
            }
        });


    }

    private void buttonSaveOnClick() {

        //DateOfBirth
        String stringDateOfBirth = getDOB();

        //Gender
        String stringGender = getGender();

        //Height
        double height = getHeight();

        //Measurement
        String measurement = spinnerMeasurement.getSelectedItem().toString().toLowerCase();


        //Error handling
        tryFinishSave(stringDateOfBirth, stringGender, height, measurement);
    }

    private void tryFinishSave(String stringDateOfBirth, String stringGender,
                               double height, String measurement) {

        //Нет ошибки
        if (errorMessage.isEmpty()) {
            //Put data into database
            putDataToDB(stringDateOfBirth, stringGender, height, measurement);

        } else {
            Toast.makeText(getActivity(), "Error: " + errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    private void putDataToDB(String stringDateOfBirth, String stringGender, double height, String measurement) {
        //TODO
        long id = 1;
        DBAdapter db = new DBAdapter(getActivity());
        db.open();

        //Quote smart
        String stringDateOfBirthSQL = db.quoteSmart(stringDateOfBirth);
        String stringGenderSQL = db.quoteSmart(stringGender);
        String heightSQL = db.quoteSmart("" + height);
        String measurementSQL = db.quoteSmart(measurement);


        String[] fields = {"user_dob",
            "user_gender",
            "user_height",
            "user_measurement"};
        String[] values = {stringDateOfBirthSQL, stringGenderSQL, heightSQL, measurementSQL};


        db.update("users", "_id", id, fields, values);
        Toast.makeText(getActivity(), "Everything was saved :)" , Toast.LENGTH_LONG).show();

        db.close();
    }

    private String getGender() {
        //get selected radio button from selected group
        int selectedId = radioGroupGender.getCheckedRadioButtonId();
        //find button by id
        RadioButton radioButtonGender = getActivity().findViewById(selectedId);
        String stringGender = (radioButtonGender.getText().toString()).toLowerCase(Locale.ROOT);
        return stringGender;
    }

    private String getDOB() {
        //DateOfBirth Day
        String stringDOBDay = spinnerDOBDay.getSelectedItem().toString();
        int DOBDay;
        try {
            DOBDay = Integer.parseInt(stringDOBDay);
            if (DOBDay < 10) {
                stringDOBDay = "0" + DOBDay;
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Could not be parse");
            errorMessage = "Please select a day for your birthday correctly";
        }

        //DateOfBirth Month
        String stringDOBMonth = spinnerDOBMonth.getSelectedItem().toString();
        stringDOBMonth = convertMonthToNumber(stringDOBMonth);

        //DateOfBirth Year
        String stringDOBYear = spinnerDOBYear.getSelectedItem().toString();

        //Put date of birth together
        String dateOfBirth = stringDOBYear + "-" + stringDOBMonth + "-" + stringDOBDay;
        return dateOfBirth;
    }

    private String convertMonthToNumber(String stringDOBMonth) {
        if (stringDOBMonth.startsWith("Jan")) {
            stringDOBMonth = "01";
        }
        if (stringDOBMonth.startsWith("Feb")) {
            stringDOBMonth = "02";
        }
        if (stringDOBMonth.startsWith("Mar")) {
            stringDOBMonth = "03";
        }
        if (stringDOBMonth.startsWith("Apr")) {
            stringDOBMonth = "04";
        }
        if (stringDOBMonth.startsWith("May")) {
            stringDOBMonth = "05";
        }
        if (stringDOBMonth.startsWith("Jun")) {
            stringDOBMonth = "06";
        }
        if (stringDOBMonth.startsWith("Jul")) {
            stringDOBMonth = "07";
        }
        if (stringDOBMonth.startsWith("Jul")) {
            stringDOBMonth = "08";
        }
        if (stringDOBMonth.startsWith("Jul")) {
            stringDOBMonth = "09";
        }
        if (stringDOBMonth.startsWith("Jul")) {
            stringDOBMonth = "10";
        }
        if (stringDOBMonth.startsWith("Nov")) {
            stringDOBMonth = "11";
        }
        if (stringDOBMonth.startsWith("Dec")) {
            stringDOBMonth = "12";
        }
        return stringDOBMonth;
    }

    /* Measurement changed*/
    void measurementChanged() {
        //Measurement spinner

    }

    private final String[] arraySpinnerDOBDay = new String[31];
    private final String[] arraySpinnerDOBYear = new String[68]; //13-60


    private void fillYears(String stringYear) {
        //13-80
        int spinnerYearSelectedIndex = 0;
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR) - 13;
        int yearEnd = year - 68;
        for (int k = 0, i = yearEnd; i < year; k++, i++) {
            arraySpinnerDOBYear[67 - k ] = "" + i;
            if (stringYear.equals(arraySpinnerDOBYear[67 - k ])) {
                spinnerYearSelectedIndex = 67 - k;
            }
        }

        ArrayAdapter<String> adapterYear = new ArrayAdapter<String>(getActivity(),
            android.R.layout.simple_spinner_item, arraySpinnerDOBYear);
        spinnerDOBYear.setAdapter(adapterYear);
        spinnerDOBYear.setSelection(spinnerYearSelectedIndex);
    }

    private void fillDays(String stringDay) {
        int spinnerDaySelectedIndex = 0;
        String[] arraySpinnerDay = new String[31];
        for (int i = 0; i < 31; i++) {
            arraySpinnerDay[i] = "" + (i + 1);
            if (stringDay.equals("0" + arraySpinnerDay[i]) || stringDay.equals(arraySpinnerDay[i])) {
                spinnerDaySelectedIndex = i;
            }
        }
        //Populate spinner

        ArrayAdapter<String> adapterDay = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arraySpinnerDay);
        spinnerDOBDay.setAdapter(adapterDay);
        spinnerDOBDay.setSelection(spinnerDaySelectedIndex);
    }

    private void fillMonth(String stringMonth) {
        spinnerDOBMonth.setSelection(Integer.parseInt(stringMonth)-1);
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
            textViewCm.setText("feet and inches");

            //Change Cm to Feet and Inches
            if (!stringHeightCm.isEmpty()) {
                // feet = (cm* 0.3937008)/12
                editTextHeightCm.setText("" + convertCmToFeetInchesFEET(stringHeightCm));
                editTextHeightInches.setText("" + convertCmToFeetInchesINCHES(stringHeightCm));
            }

        } else {

            //Metric
            editTextHeightInches.setVisibility(View.GONE);
            textViewCm.setText("cm");

            //Change Feet and Inches to Cm
            if (!stringHeightCm.isEmpty() && !stringHeightInches.isEmpty()) {
                editTextHeightCm.setText("" + convertFeetInchesToCm(stringHeightCm, stringHeightInches));
            }

        }

    }//public void measureChanged
}
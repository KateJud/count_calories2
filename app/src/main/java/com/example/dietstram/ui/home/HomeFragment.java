package com.example.dietstram.ui.home;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
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
import com.example.dietstram.ui.add_food.AddFoodToDiaryFragment;
import com.example.dietstram.ui.categories.CategoriesFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.example.dietstram.OpenCloseDB.changeTitle;

public class HomeFragment extends Fragment {

    //Holding variables
    private String currentData;
    private String currentDataDay;
    private String currentDataMonth;
    private String currentDataYear;

    /* Fields */
    private View mainView;
    /*My fields*/
    Cursor listCursor;
    Cursor listCursorFood;

    /* TextView */
    TextView textViewFoodName;//.findViewById(R.id.textViewFoodName);
    TextView textViewFoodManufactureName;//.findViewById(R.id.textViewManufacture);
    TextView textViewFoodAbout;//.findViewById(R.id.textViewFoodAbout);
    TextView textViewDescription;//.findViewById(R.id.textViewFoodDescription);

    TextView textViewFoodEnergyPerHundred;//.findViewById(R.id.textViewFoodEnergyPerHundred);
    TextView textViewFoodProteinsPerHundred;//.findViewById(R.id.textViewFoodProteinsPerHundred);
    TextView textViewFoodCarbsPerHundred;//.findViewById(R.id.textViewFoodCarbsPerHundred);
    TextView textViewFoodFatPerHundred;//.findViewById(R.id.textViewFoodFatPerHundred);

    TextView textViewFoodEnergyPerN;//.findViewById(R.id.textViewFoodEnergyPerN);
    TextView textViewFoodProteinsPerN;//.findViewById(R.id.textViewFoodProteinsPerN);
    TextView textViewFoodCarbsPerN;//.findViewById(R.id.textViewFoodCarbsPerN);
    TextView textViewFoodFatPerN;//.findViewById(R.id.textViewFoodFatPerN);

    /* EditText */
    EditText editTextPortionSizePCS;
    EditText editTextPortionSizeGram;


    /* --------------------------------------------------- */


    /* My fields */
    Cursor listCategoryCursor;
    int error;

    /* Action buttons */
    MenuItem menuItemEdit;
    MenuItem menuItemDelete;

    /* Holder on buttons on toolbar */
    private String currentCategoryId;
    private String currentCategoryName;

    private String currentFoodId;
    private String currentFoodName;

    private String currentMealNumber;

    private String currentPortionSizePCS;
    private String currentPortionSizeGram;
    private boolean lockPortionSizePCS = false;
    private boolean lockPortionSizeGram = false;


    private void setAllWidgets() {
        textViewFoodName = getView().findViewById(R.id.textViewFoodName);
        textViewFoodManufactureName = getView().findViewById(R.id.textViewManufacture);
        textViewFoodAbout = getView().findViewById(R.id.textViewFoodAbout);
        textViewDescription = getView().findViewById(R.id.textViewFoodDescription);
        //Values from table
        textViewFoodEnergyPerHundred = getView().findViewById(R.id.textViewFoodEnergyPerHundred);
        textViewFoodProteinsPerHundred = getView().findViewById(R.id.textViewFoodProteinsPerHundred);
        textViewFoodCarbsPerHundred = getView().findViewById(R.id.textViewFoodCarbsPerHundred);
        textViewFoodFatPerHundred = getView().findViewById(R.id.textViewFoodFatPerHundred);

        textViewFoodEnergyPerN = getView().findViewById(R.id.textViewFoodEnergyPerN);
        textViewFoodProteinsPerN = getView().findViewById(R.id.textViewFoodProteinsPerN);
        textViewFoodCarbsPerN = getView().findViewById(R.id.textViewFoodCarbsPerN);
        textViewFoodFatPerN = getView().findViewById(R.id.textViewFoodFatPerN);

        editTextPortionSizePCS = getActivity().findViewById(R.id.editTextPortionSizePCS);
        editTextPortionSizeGram = getActivity().findViewById(R.id.editTextPortionSizeGram);


    }


    private DBAdapter getDbAdapter() {
        DBAdapter db = new DBAdapter(getActivity());
        db.open();
        return db;
    }


    private HomeViewModel homeViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Set title */
        changeTitle(getActivity(), "Home");
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel.class);
        mainView = inflater.inflate(R.layout.fragment_home, container, false);

        return mainView;
    }

    MenuItem menuItemAddFood;

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        //Inflate menu
        ((MainActivity) getActivity()).getMenuInflater().inflate(R.menu.menu_home, menu);

        //Assign variables
        menuItemAddFood = menu.findItem(R.id.action_add_food);
        menuItemAddFood.setVisible(true);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add_food) {
            addFoodTODiarySelectMealNumber();
        }

        return super.onOptionsItemSelected(item);
    }

    private void addFoodTODiarySelectMealNumber() {
        changeLayout(R.layout.fragment_home_select_meal_number);

        TextView textViewBreakfast = getActivity().findViewById(R.id.textViewBreakfast);
        textViewBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFood(0);
            }
        });


        TextView textViewLunch = getActivity().findViewById(R.id.textViewLunch);
        textViewLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFood(1);
            }
        });
    }

    /* Change layout ----------------------------------------- */
    private void changeLayout(int id) {
        /*  Change layout */
        setMainView(id);
    }

    private void setMainView(int id) {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mainView = inflater.inflate(id, null);
        ViewGroup rootView = (ViewGroup) getView();
        rootView.removeAllViews();
        rootView.addView(mainView);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setAllWidgets();


        initializeHome();

        setHasOptionsMenu(true);
    }

    private void initializeHome() {

        /* Database */
        DBAdapter db = getDbAdapter();

        /*Find data*/
        //Date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        currentData = dateFormat.format(Calendar.getInstance().getTime());
        String fdDataSQL = db.quoteSmart(currentData);


        //Fill table
        updateTableItems(currentData, "0");//Breakfast
        updateTableItems(currentData, "1");//Lunch
        updateTableItems(currentData, "2");//Supper
        updateTableItems(currentData, "3");//Snacks

        //Calculate of eaten calories today
        calculateNumberOfCalEatenToday();


        ImageButton imageButtonBreakfastAdd = getActivity().findViewById(R.id.imageButtonBreakfastAdd);
        imageButtonBreakfastAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFood(0); //Breakfast
            }
        });

    }

    private void calculateNumberOfCalEatenToday() {
        DBAdapter db = getDbAdapter();

        String currentDateSQL = db.quoteSmart(currentData);

        //Select

        String[] fieldsFdSum = new String[]{
            "fd_sum_id ",
            "fd_sum_date ",
            "fd_sum_meal_no ",
            "fd_sum_energy ",
            "fd_sum_proteins ",
            "fd_sum_carbs ",
            "fd_sum_fat "
        };
        Cursor cursorFdSum = db.select("food_diary_fd_sum", fieldsFdSum, "fd_sum_date", db.quoteSmart(currentData));

        String fdceMealNo = "";
        int fdceEatenEnergy = 0;
        int fdceEatenProteins = 0;
        int fdceEatenCarbs = 0;
        int fdceEatenFat = 0;

        int haveNull = 0;

        for (int i = 0; i < cursorFdSum.getCount(); i++) {

            if (fdceMealNo.isEmpty()) {
                haveNull = 1;

            } else {

                fdceEatenEnergy += Integer.parseInt(cursorFdSum.getString(4));
                fdceEatenProteins += Integer.parseInt(cursorFdSum.getString(5));
                fdceEatenCarbs += Integer.parseInt(cursorFdSum.getString(6));
                fdceEatenFat += Integer.parseInt(cursorFdSum.getString(7));

            }
        }

        if (cursorFdSum.getCount() == 0) {
            //Insert database
            String insertFields = "fd_sum_id ," +
                "fd_sum_date ," +

                "fd_sum_energy ," +
                "fd_sum_proteins ," +
                "fd_sum_carbs ," +
                "fd_sum_fat ";
            String insertValues = "Null," +
                db.quoteSmart(currentData) + "," +

                db.quoteSmart(fdceEatenEnergy) + "," +
                db.quoteSmart(fdceEatenProteins) + "," +
                db.quoteSmart(fdceEatenCarbs) + " ," +
                db.quoteSmart(fdceEatenFat);

            db.insert("food_diary_sum", insertFields, insertValues);

        } else {
            // Update

            String[] updateFields = {"fd_sum_energy ",
                "fd_sum_proteins ",
                "fd_sum_carbs ",
                "fd_sum_fat "};
            String[] updateValues = {db.quoteSmart("" + fdceEatenEnergy),
                db.quoteSmart("" + fdceEatenProteins),
                db.quoteSmart("" + fdceEatenCarbs),
                db.quoteSmart("" + fdceEatenFat)};

            long id = Long.parseLong(cursorFdSum.getString(0));

            db.update("food_diary_sum", "_id", id, updateFields, updateValues);

        }
        /* Update head table */
        String[] fieldsGoal = {"_id", "goal_energy_with_activity_and_diet"};
        Cursor cursorGoal = db.select("goal", fieldsGoal);
        cursorGoal.moveToLast();
        String stringGoalEnergyWithActivityDiet = cursorGoal.getString(1);

        //Update goal

        //Goal
        TextView textViewGoalWithActivityBody = getActivity().findViewById(R.id.textViewGoalWithActivityBody);
        textViewGoalWithActivityBody.setText(stringGoalEnergyWithActivityDiet);

        //Food
        TextView textViewFoodBody = getActivity().findViewById(R.id.textViewFoodBody);
        textViewFoodBody.setText("" + fdceEatenEnergy);

        //Sum
        TextView textViewSumBody = getActivity().findViewById(R.id.textViewSumBody);
        int sum = Integer.parseInt(stringGoalEnergyWithActivityDiet) - fdceEatenEnergy;
        textViewSumBody.setText("" + sum);


        db.close();
    }


    private void moveToAddFoodToDiaryLayout(int mealNumber) {
        Bundle bundle = new Bundle();
        bundle.putString("mealNumber", String.valueOf(mealNumber));
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        Fragment fragment = new AddFoodToDiaryFragment();

        //Need to pass meal number
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment, CategoriesFragment.class.getName()).commit();
    }


    /* Update Table */
    private void updateTableItems(String date, String mealNumber) {

        DBAdapter db = getDbAdapter();

        String currentDateSQL = db.quoteSmart(currentData);
        String mealNoSql = db.quoteSmart(mealNumber);

        //Select
        String[] fieldsFdce = new String[]{
            "_id ",
            "fdce_date ",
            "fdce_meal_no ",
            "fdce_eaten_energy ",
            "fdce_eaten_proteins ",
            "fdce_eaten_carbs ",
            "fdce_eaten_fat "
        };
        String[] fdceWhereClause = {"fdce_date",
            "fdce_meal_no"};
        String[] fdceWhereCondition = {currentDateSQL,
            mealNoSql};
        String[] fdceWhereAndOr = {" AND "};


        int errorFdce = 0;
        Cursor cursorFdce;
        cursorFdce = db.select("food_diary_cal_eaten", fieldsFdce, fdceWhereClause, fdceWhereCondition, fdceWhereAndOr);

        if (cursorFdce.getCount() == 0) {
            errorFdce = 1;
            String insertFields = "_id ," +
                "fdce_date ," +
                "fdce_meal_no ," +
                "fdce_eaten_energy ," +
                "fdce_eaten_proteins ," +
                "fdce_eaten_carbs ," +
                "fdce_eaten_fat ";
            String insertValues = "Null," +
                db.quoteSmart(currentData) + "," +
                db.quoteSmart(mealNumber) + "," +
                "'0' ," +
                "'0' ," +
                "'0' ," +
                "'0' ";
            db.insert("food_diary_cal_eaten", insertFields, insertValues);
            cursorFdce = db.select("food_diary_cal_eaten", fieldsFdce, fdceWhereClause, fdceWhereCondition, fdceWhereAndOr);
        }
        String fdceId = cursorFdce.getString(0);

        String[] fieldsFd = {"_id ",
            "fd_food_id ",
            "fd_serving_size_gram ",
            "fd_serving_size_gram_measurement ",
            "fd_serving_size_pcs  ",
            "fd_serving_size_pcs_measurement  ",
            "fd_energy_calculated ",
            "fd_protein_calculated ",
            "fd_carbohydrates_calculated ",
            "fd_fat_calculated ",
        };

        String[] fdWhereClause = {"fd_date",
            "fd_meal_number"};
        String[] fdWhereCondition = {currentDateSQL,
            mealNoSql};
        String[] fdWhereAndOr = {" AND "};


        Cursor cursorFd = db.select("food_diary", fieldsFd, fdWhereClause, fdWhereCondition, fdWhereAndOr);


        String[] fieldsFood = {"_id ",
            " food_name",
            " food_manufactor_name",
            " food_serving_size_gram",
            " food_serving_size_gram_measurement",
            " food_serving_size_pcs",
            " food_serving_size_pcs_measurement",
            " food_energy_calculated ",
        };
        Cursor cursorFood;

        //Ready variables for sum

        int fdceEatenEnergy = 0;
        int fdceEatenProteins = 0;
        int fdceEatenCarbs = 0;
        int fdceEatenFat = 0;

        //Loop through cursor
        for (int i = 0; i < cursorFd.getCount(); i++) {
            //Variables from food_diary
            String fdId = cursorFd.getString(1);

            String fdServingSizeGram = cursorFd.getString(2);
            String fdServingSizeGramMeasurement = cursorFd.getString(3);
            String fdServingSizePcs = cursorFd.getString(4);
            String fdServingSizePcsMeasurement = cursorFd.getString(5);
            String fdEnergyCalculated = cursorFd.getString(6);
            String fdProteinCalculated = cursorFd.getString(7);
            String fdCarbsCalculated = cursorFd.getString(8);
            String fdFatCalculated = cursorFd.getString(9);

            //food name
            cursorFood = db.select("food", fieldsFood, "_id", db.quoteSmart(fdId));
            String foodName = cursorFood.getColumnName(1);
            String foodManufacture = cursorFood.getString(2);


            String subLine = foodManufacture + ", " +
                fdServingSizeGram + ", " +
                fdServingSizeGramMeasurement + " " +
                fdServingSizePcs + " " +
                fdServingSizePcsMeasurement;

            //Add table rows
            TableLayout tableLayout;
            TextView textViewX;
            if (mealNumber.equals("0")) {
                tableLayout = getActivity().findViewById(R.id.tableLayoutBreakfastItems);
            } else if (mealNumber.equals("1")) {
                //tableLayout = getActivity().findViewById(R.id.tableLayoutLunchItems);
            } else if (mealNumber.equals("2")) {
                //tableLayout = getActivity().findViewById(R.id.tableLayoutsupperItems);
            } else if (mealNumber.equals("3")) {
                //tableLayout = getActivity().findViewById(R.id.tableLayoutsncksItems);
            }

            TableRow tableRow = new TableRow(getActivity());
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

            //TextView Name
            TextView textViewName = new TextView(getActivity());
            textViewName.setText(foodName);
            tableRow.addView(textViewName);

            //TextView Energy
            TextView textViewEnergy = new TextView(getActivity());
            textViewEnergy.setText(fdEnergyCalculated);
            tableRow.addView(textViewEnergy);

            //TextView SubLine
            TextView textViewSubLine = new TextView(getActivity());
            textViewEnergy.setText(subLine);
            tableRow.addView(textViewEnergy);


            TextView textViewBreakfastItemsName = getActivity().findViewById(R.id.textViewBreakfastItemsName);
            textViewBreakfastItemsName.setText(foodName);


            TextView textViewBreakfastItemsSub = getActivity().findViewById(R.id.textViewBreakfastItemsSubName);
            textViewBreakfastItemsSub.setText(subLine);

            TextView textViewBreakfastItemsEnergy = getActivity().findViewById(R.id.textViewBreakfastItemsEnergy);
            textViewBreakfastItemsEnergy.setText(fdEnergyCalculated);


            //Sum fields
            fdceEatenEnergy += Integer.parseInt(fdEnergyCalculated);
            fdceEatenProteins += Integer.parseInt(fdProteinCalculated);
            fdceEatenCarbs += Integer.parseInt(fdCarbsCalculated);
            fdceEatenFat += Integer.parseInt(fdFatCalculated);

            cursorFd.moveToNext();
        }

        //Update view table
        TextView textViewEnergyX;
        if (mealNumber.equals("0")) {
            textViewEnergyX = getActivity().findViewById(R.id.textViewBreakfastEnergy);
        } else if (mealNumber.equals("1")) {
            //tableLayout = getActivity().findViewById(R.id.tableLayoutLunchItems);
        } else if (mealNumber.equals("2")) {
            //tableLayout = getActivity().findViewById(R.id.tableLayoutsupperItems);
        } else if (mealNumber.equals("3")) {
            //tableLayout = getActivity().findViewById(R.id.tableLayoutsncksItems);
        }


        TextView textViewBreakfastEnergy = getActivity().findViewById(R.id.textViewBreakfastEnergy);
        textViewBreakfastEnergy.setText("" + fdceEatenEnergy);

        //Update fdce_table
        String updateFields = "fdce_eaten_energy ," +
            "fdce_eaten_proteins ," +
            "fdce_eaten_carbs ," +
            "fdce_eaten_fat ";
        String updateValues = fdceEatenEnergy + "," +
            fdceEatenProteins + "," +
            fdceEatenCarbs + "," +
            fdceEatenFat;
        db.update("food_diary_cal_eaten", "_id", Long.parseLong(fdceId), updateFields, updateValues);


        db.close();
    }


    /* Add food ------------------------------------ */
    private void addFood(int mealNumber) {
        moveToAddFoodToDiaryLayout(mealNumber);


    }

    /* 0000000000000000000000000000000000000000000000000000000000000000000000000000000000000 */
    private void onClickEditFdLineSubmit() {

        //we want to edit food
        int error = 0;
        DBAdapter db = getDbAdapter();
        long fdId = Long.parseLong(currentFdId);

        //Get food info
        String[] fields = {

            " food_serving_size_gram",
            " food_energy",
            " food_proteins",
            " food_carbohydrates",
            " food_fat ",
        };

        String currentIdSQL = db.quoteSmart(currentFoodId);
        Cursor foodCursor = db.select("food", fields, "_id", currentIdSQL);

        //Convert cursor to string
        double foodServingSizeGram = Double.parseDouble(foodCursor.getString(0));

        double foodEnergy = Double.parseDouble(foodCursor.getString(1));
        double foodProteins = Double.parseDouble(foodCursor.getString(2));
        double foodCarbohydrates = Double.parseDouble(foodCursor.getString(3));
        double foodFat = Double.parseDouble(foodCursor.getString(4));

        //Update fd serving size gram
        //todo
        EditText editText = getActivity().findViewById(R.id.editTextServingSize);
        double servingSizeGram = Double.parseDouble(editText.getText().toString());
        db.update("food_diary", "_id", fdId, "fd_serving_size_gram", db.quoteSmart(servingSizeGram));

        //Energy calculated
        double fdEnergyCalculated = Math.round((servingSizeGram * foodEnergy) / 100);
        String fdEnergyCalculatedSQL = db.quoteSmart("" + fdEnergyCalculated);
        db.update("food_diary", "_id", fdId, "fd_energy_calculated", fdEnergyCalculatedSQL);

        //Proteins calculated
        double fdProteinCalculated = Math.round((servingSizeGram * foodProteins) / 100);
        String fdProteinCalculatedSQL = db.quoteSmart("" + fdProteinCalculated);
        db.update("food_diary", "_id", fdId, "fd_proteins_calculated", fdProteinCalculatedSQL);

        //Carbohydrates calculated
        double fdCarbohydratesCalculated = Math.round((servingSizeGram * foodCarbohydrates) / 100);
        String fdCarbohydratesCalculatedSQL = db.quoteSmart("" + fdCarbohydratesCalculated);
        db.update("food_diary", "_id", fdId, "fd_carbohydrates_calculated", fdCarbohydratesCalculatedSQL);


        //Fat calculated
        double fdFatCalculated = Math.round((servingSizeGram * foodFat) / 100);
        String fdFatCalculatedSQL = db.quoteSmart("" + fdFatCalculated);
        db.update("food_diary", "_id", fdId, "fd_fat_calculated", fdFatCalculatedSQL);

        db.close();
        Toast.makeText(getActivity(), "Saved " + currentFoodName, Toast.LENGTH_SHORT).show();

        restartFragmentHome();
    }


    String currentFdId;

    private void onClickDeleteFdLineSubmit() {
        DBAdapter db = getDbAdapter();
        long fdId = Long.parseLong(currentFdId);

        db.delete("food_diary", "_id", fdId);
        db.close();

        Toast.makeText(getActivity(), "Deleted " + currentFoodName, Toast.LENGTH_SHORT).show();


        restartFragmentHome();

    }

    private void restartFragmentHome() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, new HomeFragment(), HomeFragment.class.getName());
    }


    private void rowOnClickEditDeleteLine(String stringTableRowTextName) {

        //show edit button
        DBAdapter db = getDbAdapter();
        changeLayout(R.layout.fragment_home_edit_or_delete);
        setAllWidgets();

        String[] fieldsFd = {"_id ",
            "fd_food_id ",
            "fd_serving_size_gram ",
            "fd_serving_size_gram_measurement ",
            "fd_serving_size_pcs  ",
            "fd_serving_size_pcs_measurement  ",
            "fd_energy_calculated ",
            "fd_protein_calculated ",
            "fd_carbohydrates_calculated ",
            "fd_fat_calculated ",
        };

        Cursor cursorFd = db.select("food_diary", fieldsFd, "fd_date", db.quoteSmart(currentData));
        String stringFdId = "0";//cursorFd.getString(0);

        /* Get data fro database */
        String[] fieldsFood = new String[]{"_id",
            " food_name",
            " food_manufactor_name",
        };

        //Convert Cursor to strings
        String foodId = "";
        String name = "";
        String manufactureName = "";

        String servingSizeGram = "";
        String servingSizeGramMeasurement = "";
        String servingSizePcs = "";
        String servingSizePCSMeasurement = "";
        String energyCalculated;

        Cursor cursorFood;

        for (int i = 0; i < cursorFd.getCount(); i++) {

            stringFdId = cursorFd.getString(0);
            foodId = cursorFd.getString(1);
            servingSizeGram = cursorFd.getString(2);
            servingSizeGramMeasurement = cursorFd.getString(3);
            servingSizePcs = cursorFd.getString(4);
            servingSizePCSMeasurement = cursorFd.getString(5);
            energyCalculated = cursorFd.getString(6);

            cursorFood = db.select("food", fieldsFood, "_id", db.quoteSmart(foodId));
            foodId = cursorFood.getString(0);
            name = cursorFood.getString(1);
            manufactureName = cursorFood.getString(2);

            String subLine = manufactureName + ", " +
                servingSizeGram + " " +
                servingSizeGramMeasurement + ", " +
                servingSizePcs + " " +
                servingSizePCSMeasurement;

            if (stringTableRowTextName.equals(name)) {
                break;
            } else if (stringTableRowTextName.equals(subLine)) {
                break;
            }
            cursorFd.moveToNext();
        }


        db.close();


        //Show fields
        if (name.equals("")) {
            Toast.makeText(getActivity(), "can't load food name", Toast.LENGTH_SHORT).show();
        } else {
            currentFoodName = name;
            currentFoodId = foodId;
            currentFdId = stringFdId;

            //textViewFoodName
            TextView textViewFoodName = getActivity().findViewById(R.id.textViewFoodName);
            textViewFoodName.setText(name);

            //textViewFoodManufactureName
            TextView textViewFoodManufactureName = getActivity().findViewById(R.id.textViewFoodManufactureName);
            textViewFoodManufactureName.setText(manufactureName);


            //editTextServingSizePcs
            EditText editTextServingSizePcs = getActivity().findViewById(R.id.editTextServingSizePcs);
            editTextServingSizePcs.setText(servingSizePcs);

            //textViewServingSizePcsMeasurement
            TextView textViewServingSizePcsMeasurement = getActivity().findViewById(R.id.textViewServingSizePcsMeasurement);
            textViewServingSizePcsMeasurement.setText(servingSizePCSMeasurement);

            //editTextServingSizeGram
            EditText editTextServingSizeGram = getActivity().findViewById(R.id.editTextServingSizeGram);
            editTextServingSizeGram.setText(servingSizeGram);


            //textViewServingSizeMeasurement
            TextView textViewServingSizeMeasurement = getActivity().findViewById(R.id.textViewServingSizeMeasurement);
            textViewServingSizeMeasurement.setText(servingSizeGramMeasurement);


            /* Listener for editTextPortionSizePCS */
            editTextPortionSizePCS.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {

                    editPortionSizePCSOnChanged();

                }
            });

            editTextPortionSizePCS.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                    } else {
                        String lock = "portionSizePCS";
                        releaseLock(lock);
                    }

                }
            });

            /* Listener for editTextPortionSizeGram */
            editTextPortionSizeGram.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {

                    editPortionSizeGramOnChanged();

                }
            });
            editTextPortionSizeGram.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                    } else {
                        String lock = "portionSizeGram";
                        releaseLock(lock);
                    }

                }
            });


            //Submit Button
            Button buttonSubmitEdit = getActivity().findViewById(R.id.buttonSubmitEdit);
            buttonSubmitEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickEditFdLineSubmit();
                }
            });

            //Submit Button
            Button buttonSubmitDelete = getActivity().findViewById(R.id.buttonSubmitDelete);
            buttonSubmitDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickDeleteFdLineSubmit();
                }
            });

        }
    }

    private void releaseLock(String lock) {
        if (lock.equals("portionSizeGram")) {
            lockPortionSizeGram = false;
        } else {
            lockPortionSizePCS = false;
        }

    }

    public void editPortionSizePCSOnChanged() {


        if (!lockPortionSizeGram) {
            lockPortionSizePCS = true;
            //GetValue of pcs
            // editTextPortionSizePCS;
            String portionSizePCS = editTextPortionSizePCS.getText().toString();

            //GetValue of gram
            //editTextPortionSizeGram;
            String portionSizeGram = editTextPortionSizeGram.getText().toString();

            if (portionSizeGram.equals(currentPortionSizePCS) && portionSizeGram.equals(currentPortionSizeGram)) {
                return;
            }
            if (portionSizePCS.isEmpty()) {
                editTextPortionSizeGram.setText("");

            } else {
                double doublePortionSizePCS = Double.parseDouble(portionSizePCS);


                // Calculate how much n portion size is in gram
                /* Get data fro database */
                String[] fields = new String[]{
                    "_id",
                    "food_serving_size_gram",
                    "food_serving_size_gram_measurement",
                    "food_serving_size_pcs",
                    "food_serving_size_pcs_measurement"
                };

                DBAdapter db = getDbAdapter();
                String currentIdSQL = db.quoteSmart(currentFoodId);
                Cursor foodCursor = db.select("food", fields, "_id", currentIdSQL);

                //Convert Cursor to strings
                String servingSize = foodCursor.getString(1);
                String servingMeasurement = foodCursor.getString(2);
                String servingNameNumber = foodCursor.getString(3);
                String servingNameWord = foodCursor.getString(4);

                db.close();

                // Have changed pcs
                // Update gram
                double doublePortionSizeGram = Math.round(doublePortionSizePCS * Double.parseDouble(servingSize) / Double.parseDouble(servingNameNumber));
                editTextPortionSizeGram.setText("" + doublePortionSizeGram);
            }
        }
    }

    public void editPortionSizeGramOnChanged() {


        if (!lockPortionSizePCS) {
            lockPortionSizeGram = true;

            //GetValue of pcs
            // editTextPortionSizePCS;
            String portionSizePCS = editTextPortionSizePCS.getText().toString();

            //GetValue of gram
            //editTextPortionSizeGram;
            String portionSizeGram = editTextPortionSizeGram.getText().toString();
            //check not to loop
            if (portionSizeGram.equals(currentPortionSizePCS) && portionSizeGram.equals(currentPortionSizeGram)) {
                return;
            }

            if (portionSizeGram.isEmpty()) {
                editTextPortionSizePCS.setText("");

            } else {

                double doublePortionSizeGram = Double.parseDouble(portionSizeGram);


                // Calculate how much n portion size is in gram
                /* Get data fro database */
                String[] fields = new String[]{
                    "_id",
                    "food_serving_size_gram",
                    "food_serving_size_gram_measurement",
                    "food_serving_size_pcs",
                    "food_serving_size_pcs_measurement"
                };

                DBAdapter db = getDbAdapter();
                String currentIdSQL = db.quoteSmart(currentFoodId);
                Cursor foodCursor = db.select("food", fields, "_id", currentIdSQL);

                //Convert Cursor to strings
                String servingSize = foodCursor.getString(1);
                String servingMeasurement = foodCursor.getString(2);
                String servingNameNumber = foodCursor.getString(3);
                String servingNameWord = foodCursor.getString(4);

                db.close();

                // Have changed pcs
                // Update gram
                double doublePortionSizePCS = Math.round(doublePortionSizeGram * Double.parseDouble(servingNameNumber) / Double.parseDouble(servingSize));
                editTextPortionSizePCS.setText("" + doublePortionSizePCS);

            }
        }
    }


}
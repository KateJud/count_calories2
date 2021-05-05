package com.example.dietstram.ui.add_food;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dietstram.DBAdapter;
import com.example.dietstram.FoodCursorAdapter;
import com.example.dietstram.MainActivity;
import com.example.dietstram.R;
import com.example.dietstram.ui.food.FoodFragment;
import com.example.dietstram.ui.home.HomeFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static com.example.dietstram.OpenCloseDB.changeTitle;


public class AddFoodToDiaryFragment extends Fragment {

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
    /* Necessary  fields */
    private View mainView;

    /* My fields */
    Cursor listCategoryCursor;
    Cursor listCursorFood;
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


    public AddFoodToDiaryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /* Set title */
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Add food to diary");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_food_to_diary, container, false);
    }


    private DBAdapter getDbAdapter() {
        DBAdapter db = new DBAdapter(getActivity());
        db.open();
        return db;
    }


    // Run method when started
    //Set toolbar menu items
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //populateList("0", "");

        //setHasOptionsMenu(true);

        String action="";
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            currentMealNumber = bundle.getString("mealNumber");
            currentFoodId = bundle.getString("currentFoodId");
            action = bundle.getString("action");

        }
        if(action.isEmpty()){
            populateListCategory("0", "");
        }else if(action.equals("foodInCategoryListItemClicked")){
            preFoodInCategoryListItemClicked();
        }
    }

    //Came from another class
    private void preFoodInCategoryListItemClicked() {
        /*DataBase*/
        DBAdapter db = getDbAdapter();

        String[] fields = new String[]{
            "_id",
            "food_name",
            "food_manufactor_name",
            "food_description",
            "food_serving_size_gram",
            "food_serving_size_gram_measurement",
            "food_serving_size_pcs",
            "food_serving_size_pcs_measurement",
            "food_energy_calculated",
        };
        listCursorFood = db.select("food", fields, "_id", db.quoteSmart(currentFoodId));

        db.close();
        foodInCategoryListItemClicked(0);
    }

    private void populateListCategory(String parentId, String categoryName) {

        /*DataBase*/
        DBAdapter db = getDbAdapter();

        String[] fields = new String[]{
            "_id",
            "category_name",
            "category_parent_id"
        };
        listCategoryCursor = db.select("categories", fields, "category_parent_id", parentId, "category_name", "ASC");
        ArrayList<String> values = new ArrayList<>();


        //Convert categories to string
        int categoryCount = listCategoryCursor.getCount();
        for (int i = 0; i < categoryCount; i++) {
            values.add(listCategoryCursor.getString(listCategoryCursor.getColumnIndex("category_name")));
            listCategoryCursor.moveToNext();

        }

        //Create adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);

        //Set adapter
        final ListView listView = getActivity().findViewById(R.id.listViewAddFood);
        listView.setAdapter(adapter);

        //OnClick
        if (parentId.equals("0")) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    listItemClicked(position);
                }
            });
        }


        //Close
        db.close();


    }

    private void listItemClicked(int position) {

        //Move to id selected
        listCategoryCursor.moveToPosition(position);

        //GetId and name from cursor
        String id = listCategoryCursor.getString(0);
        String name = listCategoryCursor.getString(1);
        String parentCategoryId = listCategoryCursor.getString(2);

        //Change Title
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Add food from " + name + " to Diary");

        currentCategoryId = id;
        currentCategoryName = name;

        //Move to subclass
        populateListCategory(id, name);

        //Show food in category
        showFoodInCategory(currentCategoryId, currentCategoryName, parentCategoryId);

    }

    private void setMainView(int id) {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mainView = inflater.inflate(id, null);
        ViewGroup rootView = (ViewGroup) getView();
        rootView.removeAllViews();
        rootView.addView(mainView);

    }

    private void changeLayout(int id) {
        /*  Change layout */
        setMainView(id);
    }



    private void showFoodInCategory(String categoryId, String categoryName, String categoryParentId) {
        if (!categoryParentId.equals("0")) {

            changeLayout(R.layout.fragment_food);

            /*DataBase*/
            DBAdapter db = getDbAdapter();

            String[] fields = new String[]{
                "_id",
                "food_name",
                "food_manufactor_name",
                "food_description",
                "food_serving_size_gram",
                "food_serving_size_gram_measurement",
                "food_serving_size_pcs",
                "food_serving_size_pcs_measurement",
                "food_energy_calculated",
            };
            listCursorFood = db.select("food", fields, "", "", "food_name", "ASC");

            ListView listView = getActivity().findViewById(R.id.listViewFood);
            FoodCursorAdapter foodCursorAdapter = new FoodCursorAdapter(getActivity(), listCursorFood);

            //Attach cursor adapter to the ListView
            listView.setAdapter(foodCursorAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    foodInCategoryListItemClicked(position);
                }
            });

            //Close
            db.close();
        }
    }

    private void foodInCategoryListItemClicked(int listItemFoodIndexClicked) {

        //show edit button
        //TODO madeMenuItemVisible();

        /* Change layout */
        changeLayout(R.layout.fragment_add_food_to_diary_view_food);
        setAllWidgets();

        //Move to id selected
        listCursorFood.moveToPosition(listItemFoodIndexClicked);

        //GetId and name from cursor
        currentFoodId = listCursorFood.getString(0);
        currentFoodName = listCursorFood.getString(1);

        //Change Title
        changeTitle(getActivity(), "Add " + currentFoodName);

        /* Get data fro database */
        String[] fields = new String[]{
            " food_name",
            " food_manufactor_name",
            " food_description",
            " food_serving_size_gram",
            " food_serving_size_gram_measurement",
            " food_serving_size_pcs",
            " food_serving_size_pcs_measurement",
            " food_energy ",
            " food_protein ",
            " food_carbohydrates ",
            " food_fat ",
            " food_energy_calculated ",
            " food_protein_calculated ",
            " food_carbohydrates_calculated ",
            " food_fat_calculated ",
            " food_user_id ",
            " food_barcode ",
            " food_category_id ",
            " food_thumb",
            " food_image_a ",
            " food_image_b ",
            " food_image_c ",
        };

        DBAdapter db = getDbAdapter();
        String currentIdSQL = db.quoteSmart(currentFoodId);
        Cursor foodCursor = db.select("food", fields, "_id", currentIdSQL);

        //Convert Cursor to strings
        String name = foodCursor.getString(0);
        String manufactureName = foodCursor.getString(1);
        String description = foodCursor.getString(2);
        String servingSizeGram = foodCursor.getString(3);
        String servingSizeGramMeasurement = foodCursor.getString(4);
        String servingSizePcs = foodCursor.getString(5);
        String servingSizePCSMeasurement = foodCursor.getString(6);
        String energy = foodCursor.getString(7);
        String protein = foodCursor.getString(8);
        String carbohydrates = foodCursor.getString(9);
        String fat = foodCursor.getString(10);
        String energyCalculated = foodCursor.getString(11);
        String proteinCalculated = foodCursor.getString(12);
        String carbohydratesCalculated = foodCursor.getString(13);
        String fatCalculated = foodCursor.getString(14);
        String userId = foodCursor.getString(15);
        String barcode = foodCursor.getString(16);
        String categoryId = foodCursor.getString(17);
        String thumb = foodCursor.getString(18);
        String imageA = foodCursor.getString(19);
        String imageB = foodCursor.getString(20);
        String imageC = foodCursor.getString(21);
        db.close();
        //HeadLine
        textViewFoodName.setText(name);

        //SubHeadLine
        textViewFoodManufactureName.setText(manufactureName);

        //Image


        //Calculation line
        String about = servingSizeGram + " " + servingSizeGramMeasurement + "=" + servingSizePcs + " " + servingSizePCSMeasurement + ".";
        textViewFoodAbout.setText(about);

        //Description
        textViewDescription.setText(description);

        //Values from table
        textViewFoodEnergyPerHundred.setText(energy);
        textViewFoodProteinsPerHundred.setText(protein);
        textViewFoodCarbsPerHundred.setText(carbohydrates);
        textViewFoodFatPerHundred.setText(fat);

        textViewFoodEnergyPerN.setText(energyCalculated);
        textViewFoodProteinsPerN.setText(proteinCalculated);
        textViewFoodCarbsPerN.setText(carbohydratesCalculated);
        textViewFoodFatPerN.setText(fatCalculated);

        //Portion size pcs
        editTextPortionSizePCS.setText(servingSizePcs);

        //Portion gram
        editTextPortionSizeGram.setText(servingSizeGram);

        TextView textViewPcs = getActivity().findViewById(R.id.textViewPcs);
        textViewPcs.setText(servingSizePCSMeasurement);

        currentPortionSizePCS = servingSizePcs;
        currentPortionSizeGram = servingSizeGram;


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
        Button buttonSubmit = getActivity().findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFoodToDiary();
            }
        });


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

    private void addFoodToDiary() {


        //GetId and name from cursor
//        currentFoodId = listCursorFood.getString(0);
//        currentFoodName = listCursorFood.getString(1);
        //----------------------------------------------------


//        "fd_id INTEGER , " +
//            "fd_date DATE," +
//            "fd_meal_number INT," +
//            "fd_food_id INT," +
//            "fd_serving_size_gram DOUBLE," +
//            "fd_serving_size_gram_measurement VARCHAR,"+
//            "fd_serving_size_pcs DOUBLE ,"+
//            "fd_serving_size_pcs_measurement VARCHAR ,"+
//            "fd_energy_calculated DOUBLE," +
//            "fd_protein_calculated DOUBLE," +
//            "fd_carbohydrates_calculated DOUBLE," +
//            "fd_fat_calculated DOUBLE," +
//            "fd_user_id INT"


        //We want to add food
        DBAdapter db = getDbAdapter();
        int error = 0;

        /* Get data fro database */
        String[] fields = new String[]{
            " food_name",
            " food_manufactor_name",
            " food_description",
            " food_serving_size_gram",
            " food_serving_size_gram_measurement",
            " food_serving_size_pcs",
            " food_serving_size_pcs_measurement",
            " food_energy ",
            " food_protein ",
            " food_carbohydrates ",
            " food_fat ",
            " food_energy_calculated ",
            " food_protein_calculated ",
            " food_carbohydrates_calculated ",
            " food_fat_calculated ",
            " food_user_id ",
            " food_barcode ",
            " food_category_id ",
            " food_thumb",
            " food_image_a ",
            " food_image_b ",
            " food_image_c ",
        };


        String currentIdSQL = db.quoteSmart(currentFoodId);
        Cursor foodCursor = db.select("food", fields, "_id", currentIdSQL);

        //Convert Cursor to strings
        String name = foodCursor.getString(0);
        String manufactureName = foodCursor.getString(1);
        String description = foodCursor.getString(2);
        String servingSizeGram = foodCursor.getString(3);
        String servingSizeGramMeasurement = foodCursor.getString(4);
        String servingSizePcs = foodCursor.getString(5);
        String servingSizePCSMeasurement = foodCursor.getString(6);
        String energy = foodCursor.getString(7);
        String protein = foodCursor.getString(8);
        String carbohydrate = foodCursor.getString(9);
        String fat = foodCursor.getString(10);
        String energyCalculated = foodCursor.getString(11);
        String proteinCalculated = foodCursor.getString(12);
        String carbohydratesCalculated = foodCursor.getString(13);
        String fatCalculated = foodCursor.getString(14);
        String userId = foodCursor.getString(15);
        String barcode = foodCursor.getString(16);
        String categoryId = foodCursor.getString(17);
        String thumb = foodCursor.getString(18);
        String imageA = foodCursor.getString(19);
        String imageB = foodCursor.getString(20);
        String imageC = foodCursor.getString(21);


        //Get gram
        String stringPortionSizeGram = editTextPortionSizeGram.getText().toString();

        double doublePortionSizeGram = Double.parseDouble(stringPortionSizeGram);
        //Todo error?
        if (stringPortionSizeGram.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Gram cannot be empty", Toast.LENGTH_SHORT).show();

        }

        //Date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fdDate = dateFormat.format(Calendar.getInstance().getTime());
        String fdDateSQL = db.quoteSmart(fdDate);

        //fd_meal_number
        String mealNumber = currentMealNumber;
        String mealNumberSQL = db.quoteSmart(mealNumber);

        //food_id
        String foodId = currentFoodId;
        String foodIdSQL = db.quoteSmart(foodId);


        //fd_serving_size_gram
        String servingSizeGramNew = editTextPortionSizeGram.getText().toString();
        String servingSizeGramSQL = db.quoteSmart(servingSizeGramNew);

        //fd_serving_size_gram_measurement
        String servingSizeGramMeasurementSQL = db.quoteSmart(servingSizeGram);


        //fd_serving_size_pcs
        String servingSizePcsNew = editTextPortionSizePCS.getText().toString();
        String servingSizePcsSQL = db.quoteSmart(servingSizePcsNew);

        // fd_serving_size_pcs_measurement
        String servingSizePCSMeasurementSQL = db.quoteSmart(servingSizePCSMeasurement);

        //fd_energy_calculated
        //Energy=consump*kcal/100
        double energyPerHundred = Double.parseDouble(energy);
        double energyCalculatedNew = Math.round(doublePortionSizeGram * energyPerHundred / 100);
        String energyCalculateSQL = db.quoteSmart("" + energyCalculatedNew);

        //fd_protein_calculated
        double proteinPerHundred = Double.parseDouble(protein);
        double proteinCalculatedNew = Math.round(doublePortionSizeGram * proteinPerHundred / 100);
        String proteinCalculateSQL = db.quoteSmart("" + proteinCalculatedNew);

        //fd_carbohydrates_calculated
        double carbohydratePerHundred = Double.parseDouble(carbohydrate);
        double carbohydrateCalculatedNew = Math.round(doublePortionSizeGram * carbohydratePerHundred / 100);
        String carbohydrateCalculateSQL = db.quoteSmart("" + carbohydrateCalculatedNew);


        //fd_fat_calculated
        double fatPerHundred = Double.parseDouble(fat);
        double fatCalculatedNew = Math.round(doublePortionSizeGram * fatPerHundred / 100);
        String fatCalculateSQL = db.quoteSmart("" + fatCalculatedNew);


        //fd_fat_meal_id -- ?

        //InsertToSQL
        if (error == 0) {

            String fieldsToInsert =
                "_id ," +
                    "fd_date ," +
                    "fd_meal_number ," +
                    "fd_food_id ," +
                    "fd_serving_size_gram ," +
                    "fd_serving_size_gram_measurement ," +
                    "fd_serving_size_pcs  ," +
                    "fd_serving_size_pcs_measurement  ," +
                    "fd_energy_calculated ," +
                    "fd_protein_calculated ," +
                    "fd_carbohydrates_calculated ," +
                    "fd_fat_calculated ," +
                    "fd_fat_meal_id ";
            String values =
                "NULL," +
                    fdDateSQL + "," +
                    mealNumberSQL + "," +
                    foodIdSQL + "," +
                    servingSizeGramSQL + "," +
                    servingSizeGramMeasurementSQL + "," +
                    servingSizePcsSQL + "," +
                    servingSizePCSMeasurementSQL + "," +
                    energyCalculateSQL + "," +
                    proteinCalculateSQL + "," +
                    carbohydrateCalculateSQL + "," +
                    fatCalculateSQL;


            db.insert("food_diary", fieldsToInsert, values);
            Toast.makeText(getActivity(), "Food diary updated", Toast.LENGTH_SHORT).show();

            moveToHomeLayout();
        }


        db.close();
    }

    private void moveToHomeLayout() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, new HomeFragment(), HomeFragment.class.getName()).commit();
    }
}
package com.example.calorycounter.ui.addfood;

import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.SearchRecentSuggestions;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calorycounter.database.DBAdapter;
import com.example.calorycounter.adapters.FoodCursorAdapter;
import com.example.calorycounter.MainActivity;
import com.example.calorycounter.helpers.MySuggestionProvider;
import com.example.calorycounter.R;
import com.example.calorycounter.ui.home.HomeFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.example.calorycounter.helpers.ConvertClass.changeTitle;


public class AddFoodToDiaryFragment extends Fragment {

    /* private TextView */
    private TextView textViewFoodName;
    private TextView textViewFoodAbout;
    private TextView textViewDescription;

    private TextView textViewFoodEnergyPerHundred;
    private TextView textViewFoodProteinsPerHundred;
    private TextView textViewFoodCarbsPerHundred;
    private TextView textViewFoodFatPerHundred;

    private TextView textViewFoodEnergyPerN;
    private TextView textViewFoodProteinsPerN;
    private TextView textViewFoodCarbsPerN;
    private TextView textViewFoodFatPerN;

    /* EditText */
    private EditText editTextPortionSizePCS;
    private EditText editTextPortionSizeGram;

    /* SearchView */
    private SearchView searchView;


    /* My fields */
    private Cursor listCursorFood;

    private String currentFoodId;

    private String currentMealNumber;

    private String currentPortionSizePCS;
    private String currentPortionSizeGram;
    private boolean lockPortionSizePCS = false;
    private boolean lockPortionSizeGram = false;


    private void setAllWidgets() {
        textViewFoodName = getView().findViewById(R.id.textViewFoodName);
        TextView textViewFoodManufactureName = getView().findViewById(R.id.textViewManufacture);
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


        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView =  getActivity().findViewById(R.id.searchFood);

        if(searchView!=null) {
            setStyleToSeracher();
            setListenersToSearcher(searchManager);
        }

    }

    private void setListenersToSearcher(SearchManager searchManager) {
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        // Здесь можно указать будет ли строка поиска изначально развернута или свернута в значок
        searchView.setIconifiedByDefault(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Обратный вызов при изменении текста, запрос - это текст после изменения
                SearchRecentSuggestions suggestions = new SearchRecentSuggestions(getActivity(),
                    MySuggestionProvider.AUTHORITY, MySuggestionProvider.MODE);
                suggestions.saveRecentQuery(query, null);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Обратный вызов при отправке текста, newText - последний текст, отправленный для поиска
                populateListFood(newText);
                return false;
            }
        });
    }

    private void setStyleToSeracher() {
        /*Style */
        int searchPlateId = searchView.getContext().getResources().getIdentifier("android:id/search_plate", null, null);
        // Getting the 'search_plate' LinearLayout.
        View searchPlate = searchView.findViewById(searchPlateId);
        // Setting background of 'search_plate' to earlier defined drawable.
        searchPlate.setBackgroundResource(R.drawable.bg_search_view);
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
        return inflater.inflate(R.layout.fragment_food, container, false);
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

        setHasOptionsMenu(true);

        String action = "";
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            currentMealNumber = bundle.getString("mealNumber");
            currentFoodId = bundle.getString("currentFoodId");
            action = bundle.getString("action");

        }
        if (action.isEmpty()) {
            populateListFood("");
           // populateListCategory("0", "");
        } else if (action.equals("foodInCategoryListItemClicked")) {
            preFoodInCategoryListItemClicked();
        }
        setAllWidgets();
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
        listItemClickedFood(0);
    }

    private void populateListFood(String filter) {
        /*DataBase*/
        DBAdapter db = getDbAdapter();

        String[] fields = new String[]{
            "_id",
            "food_name",
            "food_serving_size_gram",
            "food_serving_size_gram_measurement",
            "food_energy_calculated",
            "food_protein_calculated",
            "food_carbohydrates_calculated",
            "food_fat_calculated"
        };
        listCursorFood = db.selectFood("food", fields, filter);
        //listCursor = db.selectFood("food", fields, "", "", "food_name", "ASC");

        // set up the RecyclerView
        RecyclerView recyclerView = getActivity().findViewById(R.id.listViewFood);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FoodCursorAdapter foodCursorAdapter = new FoodCursorAdapter(getActivity(), listCursorFood);
        foodCursorAdapter.setOnEntryClickListener(new FoodCursorAdapter.OnEntryClickListener() {
            @Override
            public void onEntryClick(View view, int position) {

                listItemClickedFood(position);
            }
        });

        recyclerView.setAdapter(foodCursorAdapter);


        //Close
        db.close();

    }


    private void setMainView(int id) {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        /* --------------------------------------------------- */
        /* Necessary  fields */
        View mainView = inflater.inflate(id, null);
        ViewGroup rootView = (ViewGroup) getView();
        rootView.removeAllViews();
        rootView.addView(mainView);

    }

    private void changeLayout(int id) {
        /*  Change layout */
        setMainView(id);
    }




    private void listItemClickedFood(int listItemFoodIndexClicked) {

        /* Change layout */
        changeLayout(R.layout.fragment_add_food_to_diary_view_food);
        setAllWidgets();

        //Move to id selected
        listCursorFood.moveToPosition(listItemFoodIndexClicked);

        //GetId and name from cursor
        currentFoodId = listCursorFood.getString(0);
        String currentFoodName = listCursorFood.getString(1);

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
                if (!hasFocus) {
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
                if (!hasFocus) {
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
                    "food_serving_size_pcs_measurement",
                    " food_energy_calculated ",
                    " food_protein_calculated ",
                    " food_carbohydrates_calculated ",
                    " food_fat_calculated ",
                };

                DBAdapter db = getDbAdapter();
                String currentIdSQL = db.quoteSmart(currentFoodId);
                Cursor foodCursor = db.select("food", fields, "_id", currentIdSQL);

                //Convert Cursor to strings
                String servingSize = foodCursor.getString(1);
                String servingMeasurement = foodCursor.getString(2);
                String servingNameNumber = foodCursor.getString(3);
                String servingNameWord = foodCursor.getString(4);


                // Have changed pcs
                // Update gram

                double doublePortionSizeGram = doublePortionSizePCS * Double.parseDouble(servingSize) / Double.parseDouble(servingNameNumber);
                editTextPortionSizeGram.setText(String.format(getActivity().getString(R.string.format_double), doublePortionSizeGram));
                updateTablePerN(foodCursor, servingSize, doublePortionSizeGram);


                db.close();


                //Per meal: 1000 kal -120 г
                // x kal -10
                //
            }
        }
    }

    private void updateTablePerN(Cursor foodCursor, String servingSize, double doublePortionSizeGram) {
        //energy, size gram
        //new energy= energyOld*newSize/oldSize
        String energyOld = foodCursor.getString(5);
        String proteinOld = foodCursor.getString(6);
        String carbsOld = foodCursor.getString(7);
        String fatOld = foodCursor.getString(8);


        double koeff = doublePortionSizeGram / Double.parseDouble(servingSize);
        double energyNew = Double.parseDouble(energyOld) * koeff;
        double proteinNew = Double.parseDouble(proteinOld) * koeff;
        double carbsNew = Double.parseDouble(carbsOld) * koeff;
        double fatNew = Double.parseDouble(fatOld) * koeff;


        //String.format(getActivity().getString(R.string.format_double), doublePortionSizePCS)
        textViewFoodEnergyPerN.setText(String.format(getActivity().getString(R.string.format_double),  energyNew));
        textViewFoodProteinsPerN.setText(String.format(getActivity().getString(R.string.format_double),proteinNew));
        textViewFoodCarbsPerN.setText(String.format(getActivity().getString(R.string.format_double),carbsNew));
        textViewFoodFatPerN.setText(String.format(getActivity().getString(R.string.format_double),fatNew));
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
                    "food_serving_size_pcs_measurement",
                    " food_energy_calculated ",
                    " food_protein_calculated ",
                    " food_carbohydrates_calculated ",
                    " food_fat_calculated "
                };

                DBAdapter db = getDbAdapter();
                String currentIdSQL = db.quoteSmart(currentFoodId);
                Cursor foodCursor = db.select("food", fields, "_id", currentIdSQL);

                //Convert Cursor to strings
                String servingSize = foodCursor.getString(1);
                String servingMeasurement = foodCursor.getString(2);
                String servingNameNumber = foodCursor.getString(3);
                String servingNameWord = foodCursor.getString(4);


                // Have changed pcs
                // Update gram
                double doublePortionSizePCS = doublePortionSizeGram * Double.parseDouble(servingNameNumber) / Double.parseDouble(servingSize);
                editTextPortionSizePCS.setText(String.format(getActivity().getString(R.string.format_double), doublePortionSizePCS));


                updateTablePerN(foodCursor, servingSize, doublePortionSizeGram);

                db.close();

            }
        }
    }

    private void addFoodToDiary() {

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
        String servingSizeGramMeasurementSQL = db.quoteSmart(servingSizeGramMeasurement);


        //fd_serving_size_pcs
        String servingSizePcsNew = editTextPortionSizePCS.getText().toString();
        String servingSizePcsSQL = db.quoteSmart(servingSizePcsNew);

        // fd_serving_size_pcs_measurement
        String servingSizePCSMeasurementSQL = db.quoteSmart(servingSizePCSMeasurement);

        //fd_energy_calculated
        //Energy=consump*kcal/100
        double energyPerHundred = Double.parseDouble(energy);
        double energyCalculatedNew = doublePortionSizeGram * energyPerHundred / 100;
        String energyCalculateSQL = db.quoteSmart("" + energyCalculatedNew);

        //fd_protein_calculated
        double proteinPerHundred = Double.parseDouble(protein);
        double proteinCalculatedNew = doublePortionSizeGram * proteinPerHundred / 100;
        String proteinCalculateSQL = db.quoteSmart("" + proteinCalculatedNew);

        //fd_carbohydrates_calculated
        double carbohydratePerHundred = Double.parseDouble(carbohydrate);
        double carbohydrateCalculatedNew = doublePortionSizeGram * carbohydratePerHundred / 100;
        String carbohydrateCalculateSQL = db.quoteSmart("" + carbohydrateCalculatedNew);


        //fd_fat_calculated
        double fatPerHundred = Double.parseDouble(fat);
        double fatCalculatedNew = doublePortionSizeGram * fatPerHundred / 100;
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
                    "fd_fat_calculated ";
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
        fragmentManager.beginTransaction().replace(R.id.flContent, new HomeFragment(), HomeFragment.class.getName()).addToBackStack(null).commit();
    }
}
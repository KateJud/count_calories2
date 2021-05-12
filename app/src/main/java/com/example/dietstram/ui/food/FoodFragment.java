package com.example.dietstram.ui.food;
//TODO падает пре редактировании на spinner

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.view.ContextThemeWrapper;
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
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietstram.DBAdapter;
import com.example.dietstram.FoodCursorAdapter;
import com.example.dietstram.MainActivity;
import com.example.dietstram.MySuggestionProvider;
import com.example.dietstram.R;
import com.example.dietstram.ui.addfood.AddFoodToDiaryFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FoodFragment extends Fragment  {


    /* Action buttons */
    private MenuItem menuItemEdit;
    private MenuItem menuItemDelete;
    private MenuItem menuItemAdd;

    private SearchView searchView;


    /* Holder on buttons on toolbar */
    private String currentId = "";
    private String currentName;
    private String selectedMainCategoryName = "";

    /*My fields*/
   private Cursor listCursor;
    private View mainView;
    private boolean getFromCategoriesFlag = false;


    private void preListItemClickedReadyCursor() {
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
            "food_energy_calculated"
        };
        listCursor = db.select("food", fields, "_id", db.quoteSmart(currentId), "food_name", "ASC");

        //Close
        db.close();

        listItemClicked(0);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FoodViewModel foodViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        mainView = inflater.inflate(R.layout.fragment_food, container, false);
        return mainView;
    }

    // Run method when started
    //Set toolbar menu items
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /* Set title */
        changeTitle("Food");
        setHasOptionsMenu(true);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            currentId = bundle.getString("currentFoodId");
        }

        if (currentId.isEmpty()) {
            populateListFood("");
        } else {
            //Came from another layout
            //And need a cursor
            preListItemClickedReadyCursor();
            getFromCategoriesFlag = true;
        }

        setAllWidgets();
    }

    private void setAllWidgets() {
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView =  getActivity().findViewById(R.id.searchFood);
        if(searchView!=null) {
            setStyleToSeracher();
            setListenersToSearcher(searchManager);
        }
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        //Inflate menu
        ((MainActivity) getActivity()).getMenuInflater().inflate(R.menu.menu_categories, menu);

        //Assign variables
        menuItemEdit = menu.findItem(R.id.action_edit);
        menuItemDelete = menu.findItem(R.id.action_delete);
        menuItemAdd = menu.findItem(R.id.action_add);


        //Hide as default (if list)
        if (!getFromCategoriesFlag || getActivity().findViewById(android.R.id.content) == getActivity().findViewById(R.id.layoutFood)) {
            makeMenuItemInvisible();
        } else {
            //If food
            makeMenuItemVisible();
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


    private DBAdapter getDbAdapter() {
        DBAdapter db = new DBAdapter(getActivity());
        db.open();
        return db;
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
        listCursor = db.selectFood("food", fields, filter);
        //listCursor = db.selectFood("food", fields, "", "", "food_name", "ASC");

        // set up the RecyclerView
        RecyclerView recyclerView = getActivity().findViewById(R.id.listViewFood);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FoodCursorAdapter foodCursorAdapter = new FoodCursorAdapter(getActivity(), listCursor);
        foodCursorAdapter.setOnEntryClickListener(new FoodCursorAdapter.OnEntryClickListener() {
            @Override
            public void onEntryClick(View view, int position) {

                listItemClicked(position);
            }
        });

        recyclerView.setAdapter(foodCursorAdapter);


        //Close
        db.close();

    }


    public void listItemClicked(int listItemIDClicked) {
        /* Change layout */
        changeLayout(R.layout.fragment_food_view);

        //show edit button
        if (menuItemEdit != null) {
            makeMenuItemVisible();
        }

        //Move to id selected
        listCursor.moveToPosition(listItemIDClicked);

        //GetId and name from cursor
        currentId = listCursor.getString(0);
        currentName = listCursor.getString(1);

        //Change Title
        changeTitle(currentName);

        /* Get data fro database */
        String[] fields = new String[]{
            " food_name",
            " food_manufactor_name",
            " food_description",
            "food_serving_size_gram",
            "food_serving_size_gram_measurement",
            "food_serving_size_pcs",
            "food_serving_size_pcs_measurement",
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
        String currentIdSQL = db.quoteSmart(currentId);
        Cursor foodCursor = db.select("food", fields, "_id", currentIdSQL);

        //Convert Cursor to strings
        String name = foodCursor.getString(0);
        String manufactureName = foodCursor.getString(1);
        String description = foodCursor.getString(2);
        String servingSize = foodCursor.getString(3);
        String servingMeasurement = foodCursor.getString(4);
        String servingNameNumber = foodCursor.getString(5);
        String servingNameWord = foodCursor.getString(6);
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

        //HeadLine
        TextView textViewFoodName = getView().findViewById(R.id.textViewFoodName);
        textViewFoodName.setText(name);

        //SubHeadLine
        TextView textViewFoodManufactureName = getView().findViewById(R.id.textViewManufacture);
        textViewFoodManufactureName.setText(manufactureName);

        //Calculation line
        TextView textViewFoodAbout = getView().findViewById(R.id.textViewFoodAbout);
        String about = servingSize + " " + servingMeasurement + "=" + servingNameNumber + " " + servingNameWord + ".";
        textViewFoodAbout.setText(about);

        //Description
        TextView textViewDescription = getView().findViewById(R.id.textViewFoodDescription);
        textViewDescription.setText(description);

        //Values from table
        TextView textViewFoodEnergyPerHundred = getView().findViewById(R.id.textViewFoodEnergyPerHundred);
        textViewFoodEnergyPerHundred.setText(energy);
        TextView textViewFoodProteinsPerHundred = getView().findViewById(R.id.textViewFoodProteinsPerHundred);
        textViewFoodProteinsPerHundred.setText(protein);
        TextView textViewFoodCarbsPerHundred = getView().findViewById(R.id.textViewFoodCarbsPerHundred);
        textViewFoodCarbsPerHundred.setText(carbohydrates);
        TextView textViewFoodFatPerHundred = getView().findViewById(R.id.textViewFoodFatPerHundred);
        textViewFoodFatPerHundred.setText(fat);

        TextView textViewFoodEnergyPerN = getView().findViewById(R.id.textViewFoodEnergyPerN);
        textViewFoodEnergyPerN.setText(energyCalculated);
        TextView textViewFoodProteinsPerN = getView().findViewById(R.id.textViewFoodProteinsPerN);
        textViewFoodProteinsPerN.setText(proteinCalculated);
        TextView textViewFoodCarbsPerN = getView().findViewById(R.id.textViewFoodCarbsPerN);
        textViewFoodCarbsPerN.setText(carbohydratesCalculated);
        TextView textViewFoodFatPerN = getView().findViewById(R.id.textViewFoodFatPerN);
        textViewFoodFatPerN.setText(fatCalculated);


        db.close();

        //set Listener
        ImageView imageViewFoodAdd = getActivity().findViewById(R.id.imageViewFoodAdd);
        imageViewFoodAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFoodToDiarySelectMealNumber();
            }
        });

    }

    private void addFoodToDiarySelectMealNumber() {
        changeLayout(R.layout.fragment_home_select_meal_number);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentData = dateFormat.format(Calendar.getInstance().getTime());

        DBAdapter db = getDbAdapter();
        String[] fieldsMeal = {"_id," +
            "meal_name"};
        Cursor c = db.select("meal", fieldsMeal, "meal_date", db.quoteSmart(currentData));
        db.close();

        TableLayout tableLayoutMain = getActivity().findViewById(R.id.tableViewMealNames);
        for (int i = 0; i < c.getCount(); i++) {

            final String mealId = c.getString(0);

            TableRow tableRowMealName = new TableRow(getActivity());

            /* Name */
            TableRow.LayoutParams textNameParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 8f);
            TextView textViewMealName = new TextView(new ContextThemeWrapper(getActivity(), R.style.Widget_TextViewBig), null, 0);
            textViewMealName.setText(c.getString(1));
            tableRowMealName.addView(textViewMealName, textNameParams);

            textViewMealName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addFoodToDiarySelectMealNumberMoveToAdd(Integer.parseInt(mealId));
                }
            });

            tableLayoutMain.addView(tableRowMealName);

            c.moveToNext();
        }


    }

    private void addFoodToDiarySelectMealNumberMoveToAdd(int mealNumber) {
        Bundle bundle = new Bundle();
        bundle.putString("mealNumber", String.valueOf(mealNumber));
        bundle.putString("currentFoodId", currentId);
        bundle.putString("action", "foodInCategoryListItemClicked");
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        Fragment fragment = new AddFoodToDiaryFragment();

        //Need to pass meal number
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment, AddFoodToDiaryFragment.class.getName()).commit();

    }

    void changeTitle(String title) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            addFood();
        }
        if (item.getItemId() == R.id.action_edit) {
            editFood();
        }
        if (item.getItemId() == R.id.action_delete) {
            deleteFood();
        }

        return super.onOptionsItemSelected(item);
    }

    /* Add food ----------------------------------------- */
    private void addFood() {

        /* Change layout */
        int id = R.layout.fragment_food_edit;
        changeLayout(id);

        /* Change title */
        changeTitle("Add food");

        DBAdapter db = getDbAdapter();

        /* Populate spinner */

        //Get Categories
        String[] spinnerFields = new String[]{
            "_id",
            "category_name",
            "category_parent_id"
        };

        /* Main spinner */
        Cursor dbCursorMain = db.select("categories", spinnerFields, "category_parent_id", "0", "category_name", "ASC");

        //Create array
        int dbCursorCount = dbCursorMain.getCount();
        String[] arraySpinnerMainCategories = new String[dbCursorCount];

        for (int i = 0; i < dbCursorCount; i++) {
            arraySpinnerMainCategories[i] = dbCursorMain.getString(1).toString();
            dbCursorMain.moveToNext();
        }

        //Populate spinner
        Spinner spinnerMain = getActivity().findViewById(R.id.spinnerMainCategory);
        ArrayAdapter<String> adapterMain = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arraySpinnerMainCategories);

        spinnerMain.setAdapter(adapterMain);

        /* Listener for main category changed */
        spinnerMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                foodCategoryMainChanged(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button buttonSave = getActivity().findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonAddSaveOnClick();
            }
        });

        db.close();
    }

    private void buttonAddSaveOnClick() {

        DBAdapter db = getDbAdapter();
        //Error
        int error = 0;
        /* General */

        //Name
        EditText editTextName = getActivity().findViewById(R.id.editTextName);
        String stringName = editTextName.getText().toString();
        String stringNameSQL = db.quoteSmart(stringName);
        if (stringName.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill name", Toast.LENGTH_LONG).show();
        }

        //Manufacture
        EditText editTextManufacture = getActivity().findViewById(R.id.editTextManufacture);
        String stringManufacture = editTextManufacture.getText().toString();
        String stringManufactureSQL = db.quoteSmart(stringManufacture);

        //Description
        EditText editTextDescription = getActivity().findViewById(R.id.editTextDescription);
        String stringDescription = editTextDescription.getText().toString();
        String stringDescriptionSQL = db.quoteSmart(stringDescription);


        //Barcode
        EditText editTextBarcode = getActivity().findViewById(R.id.editTextBarcode);
        String stringBarcode = editTextBarcode.getText().toString();
        String stringBarcodeSQL = db.quoteSmart(stringBarcode);


        // SubCategory
        Spinner spinnerSubCategory = getActivity().findViewById(R.id.spinnerSubCategory);
        int subCategory = spinnerSubCategory.getSelectedItemPosition();
        String subCategorySQL = db.quoteSmart("" + subCategory);


        //Serving table
        //Size
        EditText editTextSize = getActivity().findViewById(R.id.editTextServingSize);
        String stringSize = editTextSize.getText().toString();
        String stringSizeSQL = db.quoteSmart(stringSize);
        double size = 0;
        if (stringSize.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill Size", Toast.LENGTH_LONG).show();
        }
        try {
            size = Double.parseDouble(stringSize);

        } catch (NumberFormatException e) {
            Toast.makeText(getActivity(), "Error:  Please fill Size", Toast.LENGTH_LONG).show();

        }

        //Measurement
        EditText editTextMeasurement = getActivity().findViewById(R.id.editTextServingMeasurement);
        String stringMeasurement = editTextMeasurement.getText().toString();
        String stringMeasurementSQL = db.quoteSmart(stringMeasurement);
        if (stringMeasurement.isEmpty()) {

            Toast.makeText(getActivity(), "Error:  Please fill Measurement", Toast.LENGTH_LONG).show();
            error = 1;
        }

        //Number
        EditText editTextNumber = getActivity().findViewById(R.id.editTextServingNumber);
        String stringNumber = editTextNumber.getText().toString();
        String stringNumberSQL = db.quoteSmart(stringNumber);
        if (stringNumber.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill Number", Toast.LENGTH_LONG).show();
        }

        //Word
        EditText editTextWord = getActivity().findViewById(R.id.editTextServingWord);
        String stringWord = editTextWord.getText().toString();
        String stringWordSQL = db.quoteSmart(stringWord);
        if (stringWord.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill Number measurement", Toast.LENGTH_LONG).show();
        }

        //Energy
        EditText editTextEnergy = getActivity().findViewById(R.id.editTextFoodEnergyPerHundred);
        String stringEnergy = editTextEnergy.getText().toString();
        String stringEnergySQL = db.quoteSmart(stringEnergy);
        if (stringEnergy.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill Energy", Toast.LENGTH_LONG).show();
        }
        //Proteins
        EditText editTextProteins = getActivity().findViewById(R.id.editTextFoodProteinsPerHundred);
        String stringProteins = editTextProteins.getText().toString();
        String stringProteinsSQL = db.quoteSmart(stringProteins);
        if (stringProteins.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill Proteins", Toast.LENGTH_LONG).show();
        }

        //Carbs
        EditText editTextCarbs = getActivity().findViewById(R.id.editTextFoodCarbsPerHundred);
        String stringCarbs = editTextCarbs.getText().toString();
        String stringCarbsSQL = db.quoteSmart(stringCarbs);
        if (stringCarbs.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill Carbs", Toast.LENGTH_LONG).show();
        }
        //Fat
        EditText editTextFat = getActivity().findViewById(R.id.editTextFoodFatPerHundred);
        String stringFat = editTextFat.getText().toString();
        String stringFatSQL = db.quoteSmart(stringFat);
        if (stringFat.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill Fat", Toast.LENGTH_LONG).show();
        }


        //Toast.makeText(getActivity(), "error "+error, Toast.LENGTH_LONG).show();
        if (error == 0) {
            double energyCalculated = Math.round((size * Double.parseDouble(stringEnergy)) / 100);
            double proteinCalculated = Math.round((size * Double.parseDouble(stringProteins)) / 100);
            double carbsCalculated = Math.round((size * Double.parseDouble(stringCarbs)) / 100);
            double fatCalculated = Math.round((size * Double.parseDouble(stringFat)) / 100);

            String energyCalculatedSQL = db.quoteSmart("" + energyCalculated);
            String proteinCalculatedSQL = db.quoteSmart("" + proteinCalculated);
            String carbsCalculatedSQL = db.quoteSmart("" + carbsCalculated);
            String fatCalculatedSQL = db.quoteSmart("" + fatCalculated);

            String fields =
                " food_name," +
                    " food_manufactor_name," +
                    " food_description," +
                    " food_serving_size_gram," +
                    " food_serving_size_gram_measurement," +
                    " food_serving_size_pcs," +
                    " food_serving_size_pcs_measurement," +
                    " food_energy," +
                    " food_protein," +
                    " food_carbohydrates," +
                    " food_fat," +
                    " food_energy_calculated," +
                    " food_protein_calculated," +
                    " food_carbohydrates_calculated," +
                    " food_fat_calculated," +
                    " food_barcode," +
                    " food_category_id ";
            String values = stringNameSQL + "," +
                stringManufactureSQL + "," +
                stringDescriptionSQL + "," +
                stringSizeSQL + "," +
                stringMeasurementSQL + "," +
                stringNumberSQL + "," +
                stringWordSQL + "," +
                stringEnergySQL + "," +
                stringProteinsSQL + "," +
                stringCarbsSQL + "," +
                stringFatSQL + "," +
                energyCalculatedSQL + "," +
                proteinCalculatedSQL + "," +
                carbsCalculatedSQL + "," +
                fatCalculatedSQL + "," +
                stringBarcodeSQL + "," +
                subCategorySQL;


            db.insert("food", fields, values);
            Toast.makeText(getActivity(), "Everything is saved", Toast.LENGTH_LONG).show();

            db.close();
            moveToCorrectLayout();
        }

    }
    /* // Add food ----------------------------------------- */

    /* Delete food ----------------------------------------- */
    private void deleteFood() {
        createAlertDialog();

//        int id = R.layout.fragment_food_delete;
//        changeLayout(id);
//
//        Button buttonDelete = getActivity().findViewById(R.id.buttonDelete);
//        buttonDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onDeleteClicked();
//            }
//        });
//        Button buttonCancel = getActivity().findViewById(R.id.buttonCancel);
//        buttonCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onCancelClicked();
//            }
//        });
    }

    private void createAlertDialog() {
        String button1String = "Delete";
        String button2String = "Cancel";

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Delete");  // заголовок
        builder.setMessage(R.string.delete_message); // сообщение
        builder.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                onDeleteClicked();
            }
        });
        builder.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.setCancelable(true);
        builder.show();

    }


    private void onCancelClicked() {
        moveToCorrectLayout();
    }

    private void moveToCorrectLayout() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, new FoodFragment(), FoodFragment.class.getName()).commit();
    }

    private void onDeleteClicked() {
        //Delete Form Sql
        DBAdapter db = getDbAdapter();

        //Insert into database
        //Ready variables
        long longCurrentIdSQL = db.quoteSmart(Long.parseLong(currentId));
        db.delete("food", "_id", longCurrentIdSQL);

        /* Close */
        db.close();

        //Give feedback
        Toast.makeText(getActivity(), "Food deleted", Toast.LENGTH_SHORT).show();

        //Move user back to correct layout
        moveToCorrectLayout();
        int id = R.layout.fragment_food;
        setMainView(id);


    }
    /* // Delete food ----------------------------------------- */

    /* Edit food ----------------------------------------- */
    private void editFood() {
        //show edit button
        makeMenuItemInvisible();
        /* Change layout */
        changeLayout(R.layout.fragment_food_edit);


        //GetId and name from cursor
        currentId = listCursor.getString(0);
        currentName = listCursor.getString(1);

        //Change Title
        changeTitle("Edit " + currentName);

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
        String currentIdSQL = db.quoteSmart(currentId);
        Cursor foodCursor = db.select("food", fields, "_id", currentIdSQL);

        //Convert Cursor to strings
        String name = foodCursor.getString(0);
        String manufactureName = foodCursor.getString(1);
        String description = foodCursor.getString(2);
        String servingSize = foodCursor.getString(3);
        String servingMeasurement = foodCursor.getString(4);
        String servingNameNumber = foodCursor.getString(5);
        String servingNameWord = foodCursor.getString(6);
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

        //HeadLine
        EditText editTextFoodName = getView().findViewById(R.id.editTextName);
        editTextFoodName.setText(name);

        //Manufacture
        EditText editTextFoodManufactureName = getView().findViewById(R.id.editTextManufacture);
        editTextFoodManufactureName.setText(manufactureName);

        //Description
        EditText editTextFoodDescription = getView().findViewById(R.id.editTextDescription);
        editTextFoodDescription.setText(description);

        //Barcode
        EditText editTextBarcode = getView().findViewById(R.id.editTextBarcode);
        editTextBarcode.setText(barcode);

        //Size
        EditText editTextServingSize = getView().findViewById(R.id.editTextServingSize);
        editTextServingSize.setText(servingSize);

        //Measurement
        EditText editTextServingMeasurement = getView().findViewById(R.id.editTextServingMeasurement);
        editTextServingMeasurement.setText(servingMeasurement);

        //Number
        EditText editTextServingNumber = getView().findViewById(R.id.editTextServingNumber);
        editTextServingNumber.setText(servingNameNumber);

        //Word
        EditText editTextServingWord = getView().findViewById(R.id.editTextServingWord);
        editTextServingWord.setText(servingNameWord);


        //Values from table
        EditText editTextFoodEnergyPerHundred = getView().findViewById(R.id.editTextFoodEnergyPerHundred);
        editTextFoodEnergyPerHundred.setText(energy);
        EditText editTextFoodProteinsPerHundred = getView().findViewById(R.id.editTextFoodProteinsPerHundred);
        editTextFoodProteinsPerHundred.setText(protein);
        EditText editTextFoodCarbsPerHundred = getView().findViewById(R.id.editTextFoodCarbsPerHundred);
        editTextFoodCarbsPerHundred.setText(carbohydrates);
        EditText editTextFoodFatPerHundred = getView().findViewById(R.id.editTextFoodFatPerHundred);
        editTextFoodFatPerHundred.setText(fat);


        /* Populate spinner */

        //Get Categories
        String[] spinnerFields = new String[]{
            "_id",
            "category_name",
            "category_parent_id"
        };

        Cursor dbCursorCurrentFoodCategory = db.select("categories", spinnerFields, "_id", categoryId, "category_name", "ASC");

        String currentFoodCategoryParentId = dbCursorCurrentFoodCategory.getString(2);

        /* Sub spinner */

        Cursor dbCursorSub = db.select("categories", spinnerFields, "category_parent_id", currentFoodCategoryParentId, "category_name", "ASC");

        //Create array
        int dbCursorCount = dbCursorSub.getCount();
        String[] arraySpinnerCategoriesSub = new String[dbCursorCount];

        //find out sub category selected
        String selectedSubCategoryParentId = "0";
        int selectedSubCategoryIndex = 0;

        for (int i = 0; i < dbCursorCount; i++) {
            arraySpinnerCategoriesSub[i] = dbCursorSub.getString(1).toString();
            if (dbCursorSub.getString(0).equals(categoryId)) {
                selectedSubCategoryIndex = i;
                selectedSubCategoryParentId = dbCursorSub.getString(2).toString();
            }
            dbCursorSub.moveToNext();
        }

        //Populate spinner
        Spinner spinnerSub = getActivity().findViewById(R.id.spinnerSubCategory);
        ArrayAdapter<String> adapterSub = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arraySpinnerCategoriesSub);

        spinnerSub.setAdapter(adapterSub);

        //Select correct spinner item
        spinnerSub.setSelection(selectedSubCategoryIndex);

        /* Main spinner */
        Cursor dbCursorMain = db.select("categories", spinnerFields, "category_parent_id", "0", "category_name", "ASC");

        //Create array
        dbCursorCount = dbCursorMain.getCount();
        String[] arraySpinnerMainCategories = new String[dbCursorCount];
        //This is a parent

        int selectedMainCategoryIndex = 0;

        for (int i = 0; i < dbCursorCount; i++) {
            arraySpinnerMainCategories[i] = dbCursorMain.getString(1).toString();
            if (dbCursorMain.getString(0).equals(selectedSubCategoryParentId)) {
                selectedMainCategoryIndex = i;
                selectedMainCategoryName = dbCursorMain.getString(1);
            }
            dbCursorMain.moveToNext();
        }

        //Populate spinner
        Spinner spinnerMain = getActivity().findViewById(R.id.spinnerMainCategory);
        ArrayAdapter<String> adapterMain = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arraySpinnerMainCategories);

        spinnerMain.setAdapter(adapterMain);

        //Select correct spinner item
        spinnerMain.setSelection(selectedMainCategoryIndex);

        /* Listener for main category changed */
        spinnerMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                foodCategoryMainChanged(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        db.close();


        Button buttonSave = getActivity().findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonEditSaveOnClick();
            }
        });


    }

    private void foodCategoryMainChanged(String selectedItem) {
        if (!selectedItem.equals(selectedMainCategoryName)) {

            /* Database */
            DBAdapter db = getDbAdapter();

            //Find id of main category
            String selectedItemCategoryName = db.quoteSmart(selectedItem);

            //Find id of main category
            String[] spinnerFields = new String[]{
                "_id",
                "category_name",
                "category_parent_id"
            };

            Cursor findMainCategoryCursor = db.select("categories", spinnerFields, "category_name", selectedItemCategoryName);
            String stringMainCategoryId = findMainCategoryCursor.getString(0);
            String stringMainCategoryIdSQL = db.quoteSmart(stringMainCategoryId);

            //UpdateSubcategory
            /* Sub spinner */

            Cursor dbCursorSub = db.select("categories", spinnerFields, "category_parent_id", stringMainCategoryIdSQL, "category_name", "ASC");

            //Create array
            int dbCursorCount = dbCursorSub.getCount();
            String[] arraySpinnerCategoriesSub = new String[dbCursorCount];

            for (int i = 0; i < dbCursorCount; i++) {
                arraySpinnerCategoriesSub[i] = dbCursorSub.getString(1).toString();
                dbCursorSub.moveToNext();
            }

            //Populate spinner
            Spinner spinnerSub = getActivity().findViewById(R.id.spinnerSubCategory);
            ArrayAdapter<String> adapterSub = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arraySpinnerCategoriesSub);

            spinnerSub.setAdapter(adapterSub);

            db.close();

        }
    }

    private void buttonEditSaveOnClick() {
        DBAdapter db = getDbAdapter();
        //Error
        int error = 0;
        long rowId = Long.parseLong(currentId);
        /* General */

        //Name
        EditText editTextName = getActivity().findViewById(R.id.editTextName);
        String stringName = editTextName.getText().toString();
        String stringNameSQL = db.quoteSmart(stringName);
        if (stringName.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill name", Toast.LENGTH_LONG).show();
        }

        //Manufacture
        EditText editTextManufacture = getActivity().findViewById(R.id.editTextManufacture);
        String stringManufacture = editTextManufacture.getText().toString();
        String stringManufactureSQL = db.quoteSmart(stringManufacture);
        if (stringManufacture.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill manufacture", Toast.LENGTH_LONG).show();
        }

        //Description
        EditText editTextDescription = getActivity().findViewById(R.id.editTextDescription);
        String stringDescription = editTextDescription.getText().toString();
        String stringDescriptionSQL = db.quoteSmart(stringDescription);


        //Barcode
        EditText editTextBarcode = getActivity().findViewById(R.id.editTextBarcode);
        String stringBarcode = editTextBarcode.getText().toString();
        String stringBarcodeSQL = db.quoteSmart(stringBarcode);
        if (stringBarcode.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill Barcode", Toast.LENGTH_LONG).show();
        }

        // SubCategory
        Spinner spinnerSubCategory = getActivity().findViewById(R.id.spinnerSubCategory);
        int subCategory = spinnerSubCategory.getSelectedItemPosition();
        String subCategorySQL = db.quoteSmart("" + subCategory);


        //Serving table
        //Size
        EditText editTextSize = getActivity().findViewById(R.id.editTextServingSize);
        String stringSize = editTextSize.getText().toString();
        String stringSizeSQL = db.quoteSmart(stringSize);
        double size = 0;
        if (stringSize.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill Size", Toast.LENGTH_LONG).show();
        }
        try {
            size = Double.parseDouble(stringSize);

        } catch (NumberFormatException e) {
            Toast.makeText(getActivity(), "Error:  Please fill Size", Toast.LENGTH_LONG).show();

        }

        //Measurement
        EditText editTextMeasurement = getActivity().findViewById(R.id.editTextServingMeasurement);
        String stringMeasurement = editTextMeasurement.getText().toString();
        String stringMeasurementSQL = db.quoteSmart(stringMeasurement);
        if (stringMeasurement.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill Measurement", Toast.LENGTH_LONG).show();
        }

        //Number
        EditText editTextNumber = getActivity().findViewById(R.id.editTextServingNumber);
        String stringNumber = editTextNumber.getText().toString();
        String stringNumberSQL = db.quoteSmart(stringNumber);
        if (stringNumber.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill Number", Toast.LENGTH_LONG).show();
        }

        //Word
        EditText editTextWord = getActivity().findViewById(R.id.editTextServingWord);
        String stringWord = editTextWord.getText().toString();
        String stringWordSQL = db.quoteSmart(stringWord);
        if (stringWord.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill Word", Toast.LENGTH_LONG).show();
        }

        //Energy
        EditText editTextEnergy = getActivity().findViewById(R.id.editTextFoodEnergyPerHundred);
        String stringEnergy = editTextEnergy.getText().toString();
        String stringEnergySQL = db.quoteSmart(stringEnergy);
        if (stringEnergy.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill Energy", Toast.LENGTH_LONG).show();
        }
        //Proteins
        EditText editTextProteins = getActivity().findViewById(R.id.editTextFoodProteinsPerHundred);
        String stringProteins = editTextProteins.getText().toString();
        String stringProteinsSQL = db.quoteSmart(stringProteins);
        if (stringProteins.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill Proteins", Toast.LENGTH_LONG).show();
        }

        //Carbs
        EditText editTextCarbs = getActivity().findViewById(R.id.editTextFoodCarbsPerHundred);
        String stringCarbs = editTextCarbs.getText().toString();
        String stringCarbsSQL = db.quoteSmart(stringCarbs);
        if (stringCarbs.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill Carbs", Toast.LENGTH_LONG).show();
        }
        //Fat
        EditText editTextFat = getActivity().findViewById(R.id.editTextFoodFatPerHundred);
        String stringFat = editTextFat.getText().toString();
        String stringFatSQL = db.quoteSmart(stringFat);
        if (stringFat.isEmpty()) {
            error = 1;
            Toast.makeText(getActivity(), "Error:  Please fill Fat", Toast.LENGTH_LONG).show();
        }


        //Toast.makeText(getActivity(), "error "+error, Toast.LENGTH_LONG).show();
        if (error == 0) {
            double energyCalculated = Math.round((size * Double.parseDouble(stringEnergy)) / 100);
            double proteinCalculated = Math.round((size * Double.parseDouble(stringProteins)) / 100);
            double carbsCalculated = Math.round((size * Double.parseDouble(stringCarbs)) / 100);
            double fatCalculated = Math.round((size * Double.parseDouble(stringFat)) / 100);

            String energyCalculatedSQL = db.quoteSmart("" + energyCalculated);
            String proteinCalculatedSQL = db.quoteSmart("" + proteinCalculated);
            String carbsCalculatedSQL = db.quoteSmart("" + carbsCalculated);
            String fatCalculatedSQL = db.quoteSmart("" + fatCalculated);

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
                " food_barcode ",
                " food_category_id "
            };
            String[] values = {stringNameSQL,
                stringManufactureSQL,
                stringDescriptionSQL,
                stringSizeSQL,
                stringMeasurementSQL,
                stringNumberSQL,
                stringWordSQL,
                stringEnergySQL,
                stringProteinsSQL,
                stringCarbsSQL,
                stringFatSQL,
                energyCalculatedSQL,
                proteinCalculatedSQL,
                carbsCalculatedSQL,
                fatCalculatedSQL,
                stringBarcodeSQL,
                subCategorySQL
            };


            db.update("food", "_id", rowId, fields, values);
            Toast.makeText(getActivity(), "Everything is saved", Toast.LENGTH_LONG).show();

        }


        db.close();
        moveToCorrectLayout();

    }
    /*// Edit food ----------------------------------------- */

    /* Visible & invisible ----------------------------------------- */
    private void makeMenuItemVisible() {

        //Show edit button
        menuItemEdit.setVisible(true);
        menuItemDelete.setVisible(true);
        menuItemAdd.setVisible(false);

        //todo{
//        menuItemSearch.setQuery("", false);
//        menuItemSearch.onActionViewCollapsed();
//        menuItemSearch.setVisibility(View.INVISIBLE);


    }


    private void makeMenuItemInvisible() {

        //Show edit button
        menuItemEdit.setVisible(false);
        menuItemDelete.setVisible(false);
        menuItemAdd.setVisible(true);

//        menuItemSearch.setEnabled(true);
//        menuItemSearch.setVisibility(View.VISIBLE);
    }
    /*//  Visible & invisible ----------------------------------------- */

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


}

package com.example.dietstram.ui.categories;

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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import com.example.dietstram.DBAdapter;
import com.example.dietstram.FoodCursorAdapter;
import com.example.dietstram.MainActivity;
import com.example.dietstram.R;
import com.example.dietstram.ui.add_food.AddFoodToDiaryFragment;
import com.example.dietstram.ui.food.FoodFragment;

import java.util.ArrayList;


public class CategoriesFragment extends Fragment {

    /*Necessary  fields*/
    private View mainView;

    /*My fields*/
    Cursor listCursorCategory;
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


    private CategoriesViewModel categoriesViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Set title */
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Categories");
    }

    //Sets main view variables
    //so we can change views on the fragment
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        categoriesViewModel =
            ViewModelProviders.of(this).get(CategoriesViewModel.class);
        mainView = inflater.inflate(R.layout.fragment_categories, container, false);
        return mainView;
    }

    // Run method when started
    //Set toolbar menu items
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        populateList("0", "");

        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        //Inflate menu
        ((MainActivity) getActivity()).getMenuInflater().inflate(R.menu.menu_categories, menu);

        //Assign variables
        menuItemEdit = menu.findItem(R.id.action_edit);
        menuItemDelete = menu.findItem(R.id.action_delete);

        //Hide as default
        menuItemEdit.setVisible(false);
        menuItemDelete.setVisible(false);


    }


    private void populateList(String parentId, String parentName) {

        /*DataBase*/
        DBAdapter db = getDbAdapter();

        String[] fields = new String[]{
            "_id",
            "category_name",
            "category_parent_id"
        };
        listCursorCategory = db.select("categories", fields, "category_parent_id", parentId, "category_name", "ASC");
        ArrayList<String> values = new ArrayList<>();


        //Convert categories to string
        int categoryCount = listCursorCategory.getCount();
        for (int i = 0; i < categoryCount; i++) {
            values.add(listCursorCategory.getString(listCursorCategory.getColumnIndex("category_name")));
            listCursorCategory.moveToNext();

        }

        //Create adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);

        //Set adapter
        final ListView listView = getActivity().findViewById(R.id.listViewCategories);
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

        changeMenuItemVisibility(parentId);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            addCategory();
        }
        if (item.getItemId() == R.id.action_edit) {
            editCategory();
        }
        if (item.getItemId() == R.id.action_delete) {
            deleteCategory();
        }

        return super.onOptionsItemSelected(item);
    }

    private void editCategory() {
        //Edit name -- currentName
        //Edit id -- currentId
        int id = R.layout.fragment_categories_add_edit;
        changeLayout(id);

        DBAdapter db = getDbAdapter();

        //Parent id
        String[] fields = new String[]{
            "category_parent_id"
        };
        Cursor findParentId = db.select("categories", fields, "_id", db.quoteSmart(currentCategoryId));
        String currentParentId = findParentId.getString(0).toString();
        int intParentId = 0;

        /* Fill Name */
        EditText editTextName = getActivity().findViewById(R.id.editTextName);
        editTextName.setText(currentCategoryName);

        /* Fill spinner with categories */

        //Get Categories
        String[] fields2 = new String[]{
            "_id",
            "category_name",
            "category_parent_id"
        };

        Cursor dbCursor = db.select("categories", fields2, "category_parent_id", "0", "category_name", "ASC");


        //Create array
        int dbCursorCount = dbCursor.getCount();
        String[] arraySpinnerCategories = new String[dbCursorCount + 1];

        //This is a parent
        arraySpinnerCategories[0] = "-";

        for (int i = 1; i < dbCursorCount + 1; i++) {
            arraySpinnerCategories[i] = dbCursor.getString(1).toString();
            if (dbCursor.getString(0).equals(currentParentId)) {
                intParentId = i;
            }
            dbCursor.moveToNext();
        }

        //Populate spinner
        Spinner spinnerParent = (Spinner) getActivity().findViewById(R.id.spinnerCategoryParent);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arraySpinnerCategories);

        spinnerParent.setAdapter(adapter);

        //Select correct spinner item
        spinnerParent.setSelection(intParentId);

        /* Close database */
        db.close();

        /* Submit listener */
        Button buttonHome = getActivity().findViewById(R.id.buttonCategoriesSubmit);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editCategorySubmit();
            }
        });

    }

    private void changeLayout(int id) {
        /*  Change layout */
        setMainView(id);
    }

    private void editCategorySubmit() {
        DBAdapter db = getDbAdapter();
        error = 0;
        String stringName = getName();

        //Parent
        String parentId = getParentId(db);

        if (error == 0) {
            //Insert into database
            //Ready variables
            long longCurrentIdSQL = db.quoteSmart(Long.parseLong(currentCategoryId));

            String stringNameSQL = db.quoteSmart(stringName);
            String parentIdSQL = db.quoteSmart(parentId);
            String input = "NULL, " + stringNameSQL + ", " + parentIdSQL;
            db.update("categories", "_id", longCurrentIdSQL, "category_name", stringNameSQL);
            db.update("categories", "_id", longCurrentIdSQL, "category_parent_id", parentIdSQL);

            //Give feedback
            Toast.makeText(getActivity(), "Changes saved", Toast.LENGTH_SHORT).show();

            //Move user back to correct layout
            moveToCorrectLayout();
            int id = R.layout.fragment_categories;
            setMainView(id);

        }
        db.close();
    }


    private void deleteCategory() {
        int id = R.layout.fragment_categories_delete;
        changeLayout(id);

        Button buttonDelete = getActivity().findViewById(R.id.buttonCategoriesDelete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleteClicked();
            }
        });
        Button buttonCancel = getActivity().findViewById(R.id.buttonCategoriesCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCancelClicked();
            }
        });

    }

    private void onCancelClicked(){
        moveToCorrectLayout();
    }

    private void onDeleteClicked(){
        //Delete Form Sql
        DBAdapter db = getDbAdapter();

        //Insert into database
        //Ready variables
        long longCurrentIdSQL = db.quoteSmart(Long.parseLong(currentCategoryId));
        db.delete("categories", "_id", longCurrentIdSQL);

        /* Close */
        db.close();

        //Give feedback
        Toast.makeText(getActivity(), "Category deleted", Toast.LENGTH_SHORT).show();

        //Move user back to correct layout
        moveToCorrectLayout();
        int id = R.layout.fragment_categories;
        setMainView(id);


    }

    private void addCategory() {

        /* Change layout */
        int id = R.layout.fragment_categories_add_edit;
        changeLayout(id);

        /* Fill spinner with categories */
        DBAdapter db = getDbAdapter();
        //Get Categories
        String[] fields = new String[]{
            "_id",
            "category_name",
            "category_parent_id"
        };
        Cursor dbCursor = db.select("categories", fields, "category_parent_id", 0);

        //Convert cursor to string
        int dbCursorCount = dbCursor.getCount();

        //Create array
        String[] arraySpinnerCategories = new String[dbCursorCount + 1];
        arraySpinnerCategories[0] = "-";

        for (int i = 1; i < dbCursorCount + 1; i++) {
            arraySpinnerCategories[i] = dbCursor.getString(1).toString();
            dbCursor.moveToNext();
        }

        //Populate spinner
        Spinner spinnerParent = (Spinner) getActivity().findViewById(R.id.spinnerCategoryParent);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arraySpinnerCategories);

        spinnerParent.setAdapter(adapter);

        //
        Button buttonHome = getActivity().findViewById(R.id.buttonCategoriesSubmit);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewCategorySubmit();
            }
        });

        db.close();
    }

    private DBAdapter getDbAdapter() {
        DBAdapter db = new DBAdapter(getActivity());
        db.open();
        return db;
    }


    private void createNewCategorySubmit() {
        DBAdapter db = getDbAdapter();
        error = 0;
        String stringName = getName();

        //Parent
        String parentId = getParentId(db);

        if (error == 0) {
            //Insert into database
            //Ready variables
            String stringNameSQL = db.quoteSmart(stringName);
            String parentIdSQL = db.quoteSmart(parentId);
            String input = "NULL, " + stringNameSQL + ", " + parentIdSQL;
            db.insert("categories", "_id, category_name, category_parent_id", input);

            //Give feedback
            Toast.makeText(getActivity(), "Category created", Toast.LENGTH_SHORT).show();

            //Move user back to correct layout
            moveToCorrectLayout();
            int id = R.layout.fragment_categories;
            setMainView(id);

        }
        db.close();

    }

    private void moveToCorrectLayout() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, new CategoriesFragment(), CategoriesFragment.class.getName()).commit();
    }

    private String getParentId(DBAdapter db) {
        Spinner spinner = getActivity().findViewById(R.id.spinnerCategoryParent);
        String stringSpinnerCategoryParent = spinner.getSelectedItem().toString();
        String parentId;
        if (stringSpinnerCategoryParent.equals("-")) {
            parentId = "0";
        } else {
            //Find id from the text
            String stringSpinnerCategoryParentSQL = db.quoteSmart(stringSpinnerCategoryParent);

            String[] fields = new String[]{
                "_id",
                "category_name",
                "category_parent_id"
            };

            Cursor findParentId = db.select("categories", fields, "category_name", stringSpinnerCategoryParentSQL);
            parentId = findParentId.getString(0).toString();

        }
        return parentId;
    }

    private String getName() {
        //Name
        EditText editTextName = getActivity().findViewById(R.id.editTextName);
        String stringName = editTextName.getText().toString();
        if (stringName.isEmpty()) {
            Toast.makeText(getActivity(), "Please fill a name", Toast.LENGTH_SHORT).show();

            error = 1;
        }
        return stringName;
    }


    private void setMainView(int id) {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mainView = inflater.inflate(id, null);
        ViewGroup rootView = (ViewGroup) getView();
        rootView.removeAllViews();
        rootView.addView(mainView);

    }


    private void changeMenuItemVisibility(String parentId) {
        if (parentId.equals("0")) {
            //Remove edit button
        } else {
            //Show edit button
            menuItemEdit.setVisible(true);
            menuItemDelete.setVisible(true);
        }
    }

    public void listItemClicked(int arg2) {
//        categoryCursor.move(1);
//        Toast.makeText(getActivity(), "id^ " + arg2, Toast.LENGTH_SHORT).show();

        //Move to id selected
        listCursorCategory.moveToPosition(arg2);

        //GetId and name from cursor
        String id = listCursorCategory.getString(0);
        String name = listCursorCategory.getString(1);
        String parentId = listCursorCategory.getString(2);

        //Change Title

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(name);

        currentCategoryId = id;
        currentCategoryName = name;

        //Move to subclass
        populateList(id, name);

        //show food in diary
        showFoodInCategory(currentCategoryId, currentCategoryName,  parentId);

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

            ListView listViewFood = getActivity().findViewById(R.id.listViewFood);
            FoodCursorAdapter foodCursorAdapter = new FoodCursorAdapter(getActivity(), listCursorFood);

            //Attach cursor adapter to the ListView
            listViewFood.setAdapter(foodCursorAdapter);

            listViewFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    foodListItemClicked(position);
                }
            });

            //Close
            db.close();

            //  changeMenuItemVisibility(parentId);

        }
    }

        public void foodListItemClicked(int listItemIDClicked){
            //We should use Food
            currentFoodId=listCursorFood.getString(0);
            currentFoodName=listCursorFood.getString(1);

            /* Change fragment to FoodView */
            //Initialize fragment
            moveToFoodFragmentLayout();


            Toast.makeText(getActivity(), "Error:  Please fill name", Toast.LENGTH_LONG).show();



        }
    private void moveToFoodFragmentLayout() {
        Bundle bundle = new Bundle();
        bundle.putString("currentFoodId", String.valueOf(currentFoodId));
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        Fragment fragment = new FoodFragment();

        //Need to pass meal number
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
    }
    }



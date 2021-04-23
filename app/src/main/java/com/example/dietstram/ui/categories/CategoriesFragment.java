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
import com.example.dietstram.MainActivity;
import com.example.dietstram.R;

import java.util.ArrayList;


public class CategoriesFragment extends Fragment {

    /*Necessary  fields*/
    private View mainView;

    /*My fields*/
    Cursor listCursor;
    int error;

    /* Action buttons */
    MenuItem menuItemEdit;
    MenuItem menuItemDelete;

    /* Holder on buttons on toolbar */
    private String currentId;
    private String currentName;


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
//        final TextView textView = root.findViewById(R.id.text_categories);
//        categoriesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Overridein
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });


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
        listCursor = db.select("categories", fields, "category_parent_id", parentId, "category_name", "ASC");
        ArrayList<String> values = new ArrayList<>();


        //Convert categories to string
        int categoryCount = listCursor.getCount();
        for (int i = 0; i < categoryCount; i++) {
            values.add(listCursor.getString(listCursor.getColumnIndex("category_name")));
            listCursor.moveToNext();

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
        Cursor findParentId = db.select("categories", fields, "_id", db.quoteSmart(currentId));
        String currentParentId = findParentId.getString(0).toString();
        int intParentId = 0;

        /* Fill Name */
        EditText editTextName = getActivity().findViewById(R.id.editTextName);
        editTextName.setText(currentName);

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
            long longCurrentIdSQL = db.quoteSmart(Long.parseLong(currentId));

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
        long longCurrentIdSQL = db.quoteSmart(Long.parseLong(currentId));
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
        listCursor.moveToPosition(arg2);

        //GetId and name from cursor
        String id = listCursor.getString(0);
        String name = listCursor.getString(1);
        String parentId = listCursor.getString(2);

        //Change Title

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(name);

        currentId = id;
        currentName = name;

        //Move to subclass
        populateList(id, name);

    }

}
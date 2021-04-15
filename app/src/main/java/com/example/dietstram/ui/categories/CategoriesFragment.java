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

    Cursor categoryCursor;
    private View mainView;

    private CategoriesViewModel categoriesViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Set title */
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Categories");
    }

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            createNewCategory();
        }

        return super.onOptionsItemSelected(item);
    }

    public void createNewCategory() {

        /* Change layout */
        int id = R.layout.fragment_categories_add_edit;
        setMainView(id);

        /* Fill spinner with categories */
        DBAdapter db = new DBAdapter(getActivity());
        db.open();
//Get Categories
        String[] fields = new String[]{
            "category_id",
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


    private void createNewCategorySubmit() {
        DBAdapter db = new DBAdapter(getActivity());
        db.open();
        int error = 0;

        //Name
        EditText editTextName = getActivity().findViewById(R.id.editTextName);
        String stringName = editTextName.getText().toString();
        if (stringName.isEmpty()) {
            Toast.makeText(getActivity(), "Please fill a name", Toast.LENGTH_SHORT).show();

            error = 1;
        }


        //Parent
        Spinner spinner = getActivity().findViewById(R.id.spinnerCategoryParent);
        String stringSpinnerCategoryParent = spinner.getSelectedItem().toString();
        String parentId;
        if (stringSpinnerCategoryParent.equals("-")) {
            parentId = "0";
        } else {
            //Find id from the text
            String stringSpinnerCategoryParentSQL = db.quoteSmart(stringSpinnerCategoryParent);

            String[] fields = new String[]{
                "category_id",
                "category_name",
                "category_parent_id"
            };

            Cursor findParentId = db.select("categories", fields, "category_name", stringSpinnerCategoryParentSQL);
            parentId = findParentId.getString(0).toString();


        }

        if (error == 0) {
            //Insert into database


            //Ready variables
            String stringNameSQL = db.quoteSmart(stringName);
            String parentIdSQL = db.quoteSmart(parentId);
            String input = "NULL, " + stringNameSQL + ", " + parentIdSQL;
            db.insert("categories", "category_id, category_name, category_parent_id", input);

            //Give feedback
            Toast.makeText(getActivity(), "Category created", Toast.LENGTH_SHORT).show();

            //Move user back to correct layout
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, new CategoriesFragment(), CategoriesFragment.class.getName()).commit();
            int id = R.layout.fragment_categories;
            setMainView(id);

        }
        db.close();

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

        Toast.makeText(getActivity(), "activity created", Toast.LENGTH_SHORT).show();

        populateList("0", "");

        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {


        //Inflate menu
        ((MainActivity) getActivity()).getMenuInflater().inflate(R.menu.menu_categories, menu);

    }


    private void populateList(String parentId, String parentName) {

        /*DataBase*/
        DBAdapter db = new DBAdapter(getActivity());
        db.open();

//TODO
        String[] fields = new String[]{
            "category_id",
            "category_name",
            "category_parent_id"
        };

        categoryCursor = db.select("categories", fields, "category_parent_id", parentId, "category_name", "ASC");

        ArrayList<String> values = new ArrayList<>();


        //Convert categories to string
        int categoryCount = categoryCursor.getCount();
        for (int i = 0; i < categoryCount; i++) {
            values.add(categoryCursor.getString(categoryCursor.getColumnIndex("category_name")));
            categoryCursor.moveToNext();

        }

        //Close
        //categoryCursor.close();

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
    }

    public void listItemClicked(int arg2) {
//        categoryCursor.move(1);
//        Toast.makeText(getActivity(), "id^ " + arg2, Toast.LENGTH_SHORT).show();

        //Move to id selected
        categoryCursor.moveToPosition(arg2);

        //GetId and name from cursor
        String id = categoryCursor.getString(0);
        String name = categoryCursor.getString(1);
        String parentId = categoryCursor.getString(2);

        //Change Title

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(name);

        //Move to subclass
        populateList(id, name);

    }

}
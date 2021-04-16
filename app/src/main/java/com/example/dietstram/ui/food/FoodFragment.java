package com.example.dietstram.ui.food;

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
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dietstram.DBAdapter;
import com.example.dietstram.FoodCursorAdapter;
import com.example.dietstram.MainActivity;
import com.example.dietstram.R;

import java.util.ArrayList;

public class FoodFragment extends Fragment {

    /*Necessary  fields*/
    private FoodViewModel foodViewModel;

    /* Action buttons */
    MenuItem menuItemEdit;
    MenuItem menuItemDelete;

    /* Holder on buttons on toolbar */
    private String currentId;
    private String currentName;

    /*My fields*/
    Cursor listCursor;
    int error;
    private View mainView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Set title */
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Food");
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        foodViewModel =
            ViewModelProviders.of(this).get(FoodViewModel.class);
        mainView = inflater.inflate(R.layout.fragment_food, container, false);
//        final TextView textView = mainView.findViewById(R.id.text_food);
//        foodViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
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

        populateListFood();

        setHasOptionsMenu(true);
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

    private DBAdapter getDbAdapter() {
        DBAdapter db = new DBAdapter(getActivity());
        db.open();
        return db;
    }

    private void populateListFood() {
        /*DataBase*/
        DBAdapter db = getDbAdapter();

        String[] fields = new String[]{
            "food_id",
            "food_name",
            " food_manufactor_name",
            "food_description",
            " food_serving_size",
            " food_serving_mesurment",
            " food_serving_name_number",
            " food_serving_name_word",
            " food_energy_calculated",
        };
        listCursor = db.select("food", fields, "", "", "food_name", "ASC");

        ListView listView = getActivity().findViewById(R.id.listViewFood);
        FoodCursorAdapter foodCursorAdapter = new FoodCursorAdapter(getActivity(), listCursor);
        listView.setAdapter(foodCursorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listItemClicked(position);
            }
        });

        //Close
        db.close();

        //  changeMenuItemVisibility(parentId);
    }


    public void listItemClicked(int listItemIDClicked) {
        madeMenuItemVisible();
        /* Change layout */
        changeLayout(R.layout.fragment_food_view);

        //Move to id selected
        listCursor.moveToPosition(listItemIDClicked);

        //GetId and name from cursor
        currentId = listCursor.getString(0);
        currentName = listCursor.getString(1);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_food_add) {
            // createNewCategory();
        }
        if (item.getItemId() == R.id.action_food_edit) {
            // editCategory();
        }
        if (item.getItemId() == R.id.action_food_delete) {
            // deleteCategory();
        }

        return super.onOptionsItemSelected(item);
    }


    private void madeMenuItemVisible() {

        //Show edit button
        menuItemEdit.setVisible(true);
        menuItemDelete.setVisible(true);
    }

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

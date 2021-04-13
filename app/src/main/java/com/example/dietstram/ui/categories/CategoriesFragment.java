package com.example.dietstram.ui.categories;

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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.dietstram.DBAdapter;
import com.example.dietstram.MainActivity;
import com.example.dietstram.R;

import java.util.ArrayList;

public class CategoriesFragment extends Fragment {

    Cursor categoryCursor;
    private View mainView;

    private CategoriesViewModel categoriesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        categoriesViewModel =
            ViewModelProviders.of(this).get(CategoriesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_categories, container, false);
//        final TextView textView = root.findViewById(R.id.text_categories);
//        categoriesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Overridein
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });




        return root;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_add){
            createNewCategory();
        }

        return super.onOptionsItemSelected(item);
    }
    public void  createNewCategory(){

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Toast.makeText(getActivity(), "activity created", Toast.LENGTH_SHORT).show();

        populateList("0", "");

setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){


        //Inflate menu
        ((MainActivity)getActivity()).getMenuInflater().inflate(R.menu.menu_categories,menu);

    }


    private void populateList(String parentId, String parentName) {

        /*DataBase*/
        DBAdapter db = new DBAdapter(getActivity());
        db.open();

        //Get Categories
        String[] fields = new String[]{
            "category_id",
            "category_name",
            "category_parent_id"
        };

        //TODO
        categoryCursor = db.select("categories", fields, "category_parent_id", parentId);

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
                    //listItemClicked(position);
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
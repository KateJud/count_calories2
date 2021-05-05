package com.example.dietstram;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FoodCursorAdapter extends android.widget.CursorAdapter {


    public FoodCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.fragment_food_list_items, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textViewName = view.findViewById(R.id.textViewListName);
        TextView textViewNumber = view.findViewById(R.id.textViewListNumber);
        TextView textViewSubName = view.findViewById(R.id.textViewListSubName);


        int getId = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String getName = cursor.getString(cursor.getColumnIndexOrThrow("food_name"));
        String getManufacture = cursor.getString(cursor.getColumnIndexOrThrow("food_manufactor_name"));
        String getDescription = cursor.getString(cursor.getColumnIndexOrThrow("food_description"));
        String getServingSize = cursor.getString(cursor.getColumnIndexOrThrow("food_serving_size_gram"));
        String getServingMesurment = cursor.getString(cursor.getColumnIndexOrThrow("food_serving_size_gram_measurement"));
        String getServingNameNumber = cursor.getString(cursor.getColumnIndexOrThrow("food_serving_size_pcs"));
        String getServingNameWord = cursor.getString(cursor.getColumnIndexOrThrow("food_serving_size_pcs_measurement"));
        int getFoodEnergyCalculated = cursor.getInt(cursor.getColumnIndexOrThrow("food_energy_calculated"));

        String subLine= getManufacture + ", "
            + getServingMesurment + ", "
            + getServingSize + " "
            + getServingNameNumber + " "
            + getServingNameWord;

        textViewName.setText(getName);
        textViewNumber.setText(String.valueOf( getFoodEnergyCalculated));
        textViewSubName.setText(subLine);
    }
}

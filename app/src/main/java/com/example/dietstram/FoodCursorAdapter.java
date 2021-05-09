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
        TextView textViewListSubSizeGram = view.findViewById(R.id.textViewListSubSizeGram);
        TextView textViewSubName = view.findViewById(R.id.textViewListSubName);


        int getId = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String getName = cursor.getString(cursor.getColumnIndexOrThrow("food_name"));
        String getFoodSizeGramCalculated=cursor.getString(cursor.getColumnIndexOrThrow("food_serving_size_gram"));
        String getServingMeasurement = cursor.getString(cursor.getColumnIndexOrThrow("food_serving_size_gram_measurement"));
        String getFoodSizeProteinCalculated=cursor.getString(cursor.getColumnIndexOrThrow("food_protein_calculated"));
        String getFoodSizeCarbsCalculated=cursor.getString(cursor.getColumnIndexOrThrow("food_carbohydrates_calculated"));
        String getFoodSizeFatCalculated=cursor.getString(cursor.getColumnIndexOrThrow("food_fat_calculated"));
        String getFoodEnergyCalculated = cursor.getString(cursor.getColumnIndexOrThrow("food_energy_calculated"));

        //100 g \n
        //  protein: , carbs: fat:ng,
        String gramLine=getFoodSizeGramCalculated+" "+getServingMeasurement;

        String subLine=  "protein: "+getFoodSizeProteinCalculated+"g," +
            " carbs: "+getFoodSizeCarbsCalculated+"g," +
            "fat: "+ getFoodSizeFatCalculated+"g";

        textViewName.setText(getName);
        textViewNumber.setText( getFoodEnergyCalculated);
        textViewListSubSizeGram.setText(gramLine);
        textViewSubName.setText(subLine);
    }
}

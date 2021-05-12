package com.example.dietstram.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietstram.database.DBAdapter;
import com.example.dietstram.R;

public class FoodCursorAdapter extends RecyclerView.Adapter<FoodCursorAdapter.RecyclerViewHolder> {

    private final Cursor cursor;
    private final Context context;

    public FoodCursorAdapter(Context context, Cursor c) {
        this.context = context;
        this.cursor = c;

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_food_list_items, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        cursor.moveToPosition(position);

        int getId = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String getName = cursor.getString(cursor.getColumnIndexOrThrow("food_name"));
        String getFoodSizeGramCalculated = cursor.getString(cursor.getColumnIndexOrThrow("food_serving_size_gram"));
        String getServingMeasurement = cursor.getString(cursor.getColumnIndexOrThrow("food_serving_size_gram_measurement"));
        String getFoodSizeProteinCalculated = cursor.getString(cursor.getColumnIndexOrThrow("food_protein_calculated"));
        String getFoodSizeCarbsCalculated = cursor.getString(cursor.getColumnIndexOrThrow("food_carbohydrates_calculated"));
        String getFoodSizeFatCalculated = cursor.getString(cursor.getColumnIndexOrThrow("food_fat_calculated"));
        String getFoodEnergyCalculated = cursor.getString(cursor.getColumnIndexOrThrow("food_energy_calculated"));

        //100 g \n
        //  protein: , carbs: fat:ng,
        String gramLine = getFoodSizeGramCalculated + " " + getServingMeasurement;

        holder.textViewName.setText(getName);
        holder.textViewListSubSizeGram.setText(gramLine);

        holder.linearLayoutSubLine.addView(getSubLine(context, getFoodEnergyCalculated, getFoodSizeProteinCalculated, getFoodSizeCarbsCalculated, getFoodSizeFatCalculated));

        holder.setIsRecyclable(false);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    private OnEntryClickListener mOnEntryClickListener;

    public interface OnEntryClickListener {
        void onEntryClick(View view, int position);
    }

    public void setOnEntryClickListener(OnEntryClickListener onEntryClickListener) {
        mOnEntryClickListener = onEntryClickListener;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textViewName;
        private final TextView textViewListSubSizeGram;
        private final LinearLayout linearLayoutSubLine;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            // we do this because we want to check when an item has been clicked:
            itemView.setOnClickListener(this);

            textViewName = itemView.findViewById(R.id.textViewListName);
            textViewListSubSizeGram = itemView.findViewById(R.id.textViewListSubSizeGram);
            linearLayoutSubLine = itemView.findViewById(R.id.linearLayoutSubLine);

        }

        @Override
        public void onClick(View v) {

            // The user may not set a click listener for list items, in which case our listener
            // will be null, so we need to check for this
            if (mOnEntryClickListener != null) {
                mOnEntryClickListener.onEntryClick(v, getLayoutPosition());
            }
        }
    }

    LinearLayout getSubLine(Context context, String stringEnergy, String stringProtein, String stringCarbs, String stringFat) {

        DBAdapter db = new DBAdapter(context);
        db.open();
        String[] fieldsGoal = {
            "goal_energy_with_activity_and_diet",
            "goal_energy_with_activity_and_diet",
            "goal_energy_with_activity_and_diet",
            "goal_energy_with_activity_and_diet",
        };
        Cursor cursorGoal = db.select("goal", fieldsGoal, "_id", 1);
        String stringEnergyGoal = cursorGoal.getString(0);
        String stringProteinGoal = cursorGoal.getString(1);
        String stringCarbsGoal = cursorGoal.getString(2);
        String stringFatGoal = cursorGoal.getString(3);
        db.close();


        LinearLayout linearLayout = new LinearLayout(context);

        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        imageParams.height = 70;
        imageParams.width = 70;
        //imageParams.setMargins(0, 0, 0, 0);

        //Energy
        ImageView imageViewEnergy = new ImageView(context);
        imageViewEnergy.setLayoutParams(imageParams);
        imageViewEnergy.setImageResource(R.drawable.ic_energy);
        TextView textViewEnergy = new TextView(context, null, R.style.Widget_TextViewSmallComponents);
        textViewEnergy.setText(String.format(context.getResources().getString(R.string.format_kcal), stringEnergy));

        //~300
        if (Double.parseDouble(stringEnergy) * 8 < Double.parseDouble(stringEnergyGoal)) {
            textViewEnergy.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_green)));
        } else if (Double.parseDouble(stringEnergy) * 4 < Double.parseDouble(stringEnergyGoal)) {
            //~500
            textViewEnergy.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_yellow)));

        } else {
            //>500
            textViewEnergy.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_red)));

        }

        linearLayout.addView(imageViewEnergy);
        linearLayout.addView(textViewEnergy);

        // //Energy

        //Protein
        ImageView imageViewProtein = new ImageView(context);
        imageViewProtein.setLayoutParams(imageParams);
        imageViewProtein.setImageResource(R.drawable.ic_protein);
        TextView textViewProtein = new TextView(context, null, R.style.Widget_TextViewSmallComponents);
        textViewProtein.setText(String.format(context.getResources().getString(R.string.format_g), stringProtein));

        //~300
        if (Double.parseDouble(stringProtein) * 8 < Double.parseDouble(stringProteinGoal)) {
            textViewProtein.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_green)));
        } else if (Double.parseDouble(stringProtein) * 4 < Double.parseDouble(stringProteinGoal)) {
            //~500
            textViewProtein.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_yellow)));

        } else {
            //>500
            textViewProtein.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_red)));

        }

        linearLayout.addView(imageViewProtein);
        linearLayout.addView(textViewProtein);

        // //Protein

        //Carbs
        ImageView imageViewCarbs = new ImageView(context);
        imageViewCarbs.setLayoutParams(imageParams);
        imageViewCarbs.setImageResource(R.drawable.ic_carbs);
        TextView textViewCarbs = new TextView(context, null, R.style.Widget_TextViewSmallComponents);
        textViewCarbs.setText(String.format(context.getResources().getString(R.string.format_g), stringCarbs));

        //~300
        if (Double.parseDouble(stringCarbs) * 8 < Double.parseDouble(stringCarbsGoal)) {
            textViewCarbs.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_green)));
        } else if (Double.parseDouble(stringCarbs) * 4 < Double.parseDouble(stringCarbsGoal)) {
            //~500
            textViewCarbs.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_yellow)));

        } else {
            //>500
            textViewCarbs.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_red)));

        }

        linearLayout.addView(imageViewCarbs);
        linearLayout.addView(textViewCarbs);

        // //Carbs

        //Fat
        ImageView imageViewFat = new ImageView(context);
        imageViewFat.setLayoutParams(imageParams);
        imageViewFat.setImageResource(R.drawable.ic_fat);
        TextView textViewFat = new TextView(context, null, R.style.Widget_TextViewSmallComponents);
        textViewFat.setText(String.format(context.getResources().getString(R.string.format_g), stringFat));

        //~300
        if (Double.parseDouble(stringFat) * 8 < Double.parseDouble(stringFatGoal)) {
            textViewFat.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_green)));
        } else if (Double.parseDouble(stringFat) * 4 < Double.parseDouble(stringFatGoal)) {
            //~500
            textViewFat.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_yellow)));

        } else {
            //>500
            textViewFat.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_red)));

        }

        linearLayout.addView(imageViewFat);
        linearLayout.addView(textViewFat);

        // //Fat

        return linearLayout;
    }
}

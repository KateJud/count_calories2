package com.example.calorycounter.helpers;

import android.app.Activity;

import com.example.calorycounter.MainActivity;

public class ConvertClass {

    public static void changeTitle(Activity activity, String title) {
        ((MainActivity)activity).getSupportActionBar().setTitle(title);
    }

    /* Convert ------------------------------------------------------------------------------------ */

    public static long convertCmToFeetInchesFEET(String stringHeightCm) {

        double heightCm = Double.parseDouble(stringHeightCm);
        return Math.round((heightCm / 2.54) / 12);
    }

    public static  long convertCmToFeetInchesINCHES(String stringHeightCm) {
        double heightCm = Double.parseDouble(stringHeightCm);
        double heightInchesTotal = heightCm / 2.54;
        double heightFeet = heightInchesTotal - 12 * convertCmToFeetInchesFEET(stringHeightCm);
        return Math.round(heightFeet);
    }

    public static  long convertFeetInchesToCm(String stringHeightFeet, String stringHeightInches) {

        double heightFeet = Double.parseDouble(stringHeightFeet);
        double heightInches = Double.parseDouble(stringHeightInches);
        return Math.round(((heightFeet * 12) + heightInches) * 2.54);
    }

    public static  long convertKgToPounds(String stringKg) {
        return Math.round(Double.parseDouble(stringKg) / 0.45359237);
    }

    public static long convertPoundsToKg(String stringPounds) {
        return Math.round(Double.parseDouble(stringPounds) * 0.45359237);
    }
}

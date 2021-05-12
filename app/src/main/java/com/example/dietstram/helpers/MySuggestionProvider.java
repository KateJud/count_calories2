package com.example.dietstram.helpers;

import android.content.SearchRecentSuggestionsProvider;

public class MySuggestionProvider extends SearchRecentSuggestionsProvider {
    public static final String AUTHORITY =
        MySuggestionProvider.class.getName();
    public static final int MODE = DATABASE_MODE_QUERIES;

    public MySuggestionProvider() {

        System.out.println(AUTHORITY);
        setupSuggestions(AUTHORITY, MODE);
    }

}
package com.example.dietstram;

import android.content.SearchRecentSuggestionsProvider;

public class MySuggestionProvider extends SearchRecentSuggestionsProvider {
    public static final String AUTHORITY =
        MySuggestionProvider.class.getName();
    public final static int MODE = DATABASE_MODE_QUERIES;

    public MySuggestionProvider() {

        System.out.println(AUTHORITY);
        setupSuggestions(AUTHORITY, MODE);
    }

}
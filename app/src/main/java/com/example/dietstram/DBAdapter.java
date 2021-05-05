package com.example.dietstram;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBAdapter {

    /* 01 Variables ------------------------------------------------------------------------------- */
    public static final String DATABASE_NAME = "stramdiet";
    public static final int DATABASE_VERSION = 8;

    /* 02 Database Variables ---------------------------------------------------------------------- */
    private final Context context;
    private final DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    /* 03 Class DBAdapter ------------------------------------------------------------------------- */
    public DBAdapter(Context context) {
        this.context = context;
        DBHelper = new DatabaseHelper(context);
    }

    /* 04 DBHelper -------------------------------------------------------------------------------- */
    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            try {

                db.execSQL("CREATE TABLE IF NOT EXISTS goal (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "goal_id INTEGER, " +
                    "goal_current_weight INT," +
                    "goal_target_weight INT," +
                    "goal_i_want_to VARCHAR," +
                    "goal_weekly_goal VARCHAR," +
                    "goal_date DATE," +
                    "goal_energy_bmr INT," +
                    "goal_proteins_bmr INT," +
                    "goal_carbs_bmr INT," +
                    "goal_fat_bmr INT," +
                    "goal_energy_diet INT," +
                    "goal_proteins_diet INT," +
                    "goal_carbs_diet INT," +
                    "goal_fat_diet INT," +
                    "goal_energy_with_activity INT," +
                    "goal_proteins_with_activity INT," +
                    "goal_carbs_with_activity INT," +
                    "goal_fat_with_activity INT," +
                    "goal_energy_with_activity_and_diet INT," +
                    "goal_proteins_with_activity_and_diet INT," +
                    "goal_carbs_with_activity_and_diet INT," +
                    "goal_fat_with_activity_and_diet INT," +
                    "goal_notes VARCHAR" +
                    ");");

                db.execSQL("CREATE TABLE IF NOT EXISTS users (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "user_id INTEGER , " +
                    "user_email VARCHAR," +
                    "user_password VARCHAR," +
                    "user_salt VARCHAR," +
                    "user_alias VARCHAR," +
                    "user_dob DATE," +
                    "user_gender INT," +
                    "user_location VARCHAR," +
                    "user_height INT," +
                    "user_activity_level INT," +
                    "user_measurement VARCHAR," +
                    "user_last_seen TIME," +
                    "user_note VARCHAR" +
                    ");");

                db.execSQL("CREATE TABLE IF NOT EXISTS food_diary_cal_eaten (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "fdce_id INTEGER , " +
                    "fdce_date DATE," +
                    "fdce_meal_no INT," +
                    "fdce_eaten_energy INT," +
                    "fdce_eaten_proteins INT," +
                    "fdce_eaten_carbs INT," +
                    "fdce_eaten_fat INT" +
                    ");");

                db.execSQL("CREATE TABLE IF NOT EXISTS food_diary_sum (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "fd_sum_id INTEGER , " +
                    "fd_sum_date DATE," +
                    "fd_sum_meal_no INT," +
                    "fd_sum_energy INT," +
                    "fd_sum_proteins INT," +
                    "fd_sum_carbs INT," +
                    "fd_sum_fat INT" +
                    ");");

                db.execSQL("CREATE TABLE IF NOT EXISTS food_diary (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "fd_id INTEGER , " +
                    "fd_date DATE," +
                    "fd_meal_number INT," +
                    "fd_food_id INT," +
                    "fd_serving_size_gram DOUBLE," +
                    "fd_serving_size_gram_measurement VARCHAR,"+
                    "fd_serving_size_pcs DOUBLE ,"+
                    "fd_serving_size_pcs_measurement VARCHAR ,"+
                    "fd_energy_calculated DOUBLE," +
                    "fd_protein_calculated DOUBLE," +
                    "fd_carbohydrates_calculated DOUBLE," +
                    "fd_fat_calculated DOUBLE," +
                    "fd_fat_meal_id INT"
                    + ");");

                db.execSQL("CREATE TABLE IF NOT EXISTS categories (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "category_id INTEGER , " +
                    " category_name VARCHAR," +
                    " category_parent_id INT," +
                    " category_icon VARCHAR," +
                    " category_note VARCHAR" + ");");

                db.execSQL("CREATE TABLE IF NOT EXISTS food (" +
                    " _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " food_id INTEGER , " +
                    " food_name VARCHAR," +
                    " food_manufactor_name VARCHAR," +
                    " food_description VARCHAR," +
                    " food_serving_size_gram DOUBLE," +
                    " food_serving_size_gram_measurement VARCHAR," +
                    " food_serving_size_pcs DOUBLE," +
                    " food_serving_size_pcs_measurement VARCHAR," +
                    " food_energy DOUBLE," +
                    " food_protein DOUBLE," +
                    " food_carbohydrates DOUBLE," +
                    " food_fat DOUBLE," +
                    " food_energy_calculated DOUBLE," +
                    " food_protein_calculated DOUBLE," +
                    " food_carbohydrates_calculated DOUBLE," +
                    " food_fat_calculated DOUBLE," +
                    " food_user_id INT," +
                    " food_barcode VARCHAR," +
                    " food_category_id INT," +
                    " food_thumb VARCHAR," +
                    " food_image_a VARCHAR," +
                    " food_image_b VARCHAR," +
                    " food_image_c VARCHAR," +
                    " food_last_used DATA," +
                    " food_notes VARCHAR" +
                    ");");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            //! All tables that are going to be dropped need to be listed here
            db.execSQL("DROP TABLE IF EXISTS goal");
            db.execSQL("DROP TABLE IF EXISTS users");
            db.execSQL("DROP TABLE IF EXISTS food_diary_cal_eaten");
            db.execSQL("DROP TABLE IF EXISTS food_diary_sum");
            db.execSQL("DROP TABLE IF EXISTS food_diary");
            db.execSQL("DROP TABLE IF EXISTS categories");
            db.execSQL("DROP TABLE IF EXISTS food");
            onCreate(db);

            String TAG = "Tag";
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                + newVersion + " ,which will destroy ald data");
        }//end onUpgrade
    }//DatabaseHelper

    /* 05 Open database --------------------------------------------------------------------------- */
    public DBAdapter open() {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    /* 06 Close database -------------------------------------------------------------------------- */
    public void close() {
        DBHelper.close();
    }

    /* 07 Insert data ----------------------------------------------------------------------------- */
    public void insert(String table, String fields, String values) {
        db.execSQL("INSERT INTO " + table + "(" + fields + ") VALUES (" + values + ")");
    }


    /* 08 Quote smart ----------------------------------------------------------------------------- */
    public String quoteSmart(String value) {
        //Is numeric?
        boolean isNumeric = false;
        try {
            double myDouble = Double.parseDouble(value);
            isNumeric = true;
        } catch (NumberFormatException nfe) {
            System.out.printf("Could not parse " + nfe);
        }
        if (!isNumeric) {
            //Escape special characters in a string for use ia an SQL statement
            if (value != null && value.length() > 0) {
                value = value.replace("\\", "\\\\");
                value = value.replace("'", "\\0");
                value = value.replace("\0", "\\n");
                value = value.replace("\r", "\\r");
                value = value.replace("\"", "\\\"");
                value = value.replace("\\x1a", "\\z");
            }
        }
        value = "'" + value + "'";
        return value;
    }

    public double quoteSmart(double value) {
        return value;
    }

    public int quoteSmart(int value) {
        return value;
    }

    public long quoteSmart(long value) {
        return value;
    }

    /* 09 Count ----------------------------------------------------------------------------------- */

    public int count(String table) {
        try {

            Cursor mCount = db.rawQuery("SELECT COUNT (*) FROM " + table + "", null);
            mCount.moveToFirst();
            int count = mCount.getInt(0);
            mCount.close();
            return count;
        } catch (SQLException e) {
            return -1;
        }

    }

    /* 10 Select ---------------------------------------------------------------------------------- */
    public Cursor selectPrimaryKey(String table, String primaryKey, long rowId, String[] fields)
        throws SQLException {

        Cursor mCursor = db.query(table, fields, primaryKey + "-" + rowId,
            null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    /* 11 Update ---------------------------------------------------------------------------------- */
    public boolean update(String table, String primaryKey, long rowId, String field, String value) {
        //Remove \' \'
        value = value.substring(1, value.length() - 1);

        ContentValues args = new ContentValues();
        args.put(field, value);

        return db.update(table, args, primaryKey + "=" + rowId, null) > 0;
    }

    public boolean update(String table, String primaryKey, long rowId, String field, int value) {

        ContentValues args = new ContentValues();
        args.put(field, value);

        return db.update(table, args, primaryKey + "=" + rowId, null) > 0;
    }

    public boolean update(String table, String primaryKey, long rowId, String field, double value) {

        ContentValues args = new ContentValues();
        args.put(field, value);

        return db.update(table, args, primaryKey + "=" + rowId, null) > 0;
    }

    public boolean update(String table, String primaryKey, long rowId, String[] fields, String[] values) {

        ContentValues args = new ContentValues();
        for (int i = 0; i < fields.length; i++) {
            values[i] = values[i].substring(1, values[i].length() - 1);
            args.put(fields[i], values[i]);
        }


        return db.update(table, args, primaryKey + "=" + rowId, null) > 0;
    }

    /* 12 Select ---------------------------------------------------------------------------------- */

    public Cursor select(String table, String[] fields)
        throws SQLException {

        Cursor mCursor = db.query(table, fields, null,
            null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }
    //Select all where (String)
    public Cursor select(String table, String[] fields, String whereClause, String whereCondition)
        throws SQLException {
        Cursor mCursor = db.query(table, fields, whereClause + "=" + whereCondition,
            null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    //Select all where (long)
    public Cursor select(String table, String[] fields, String whereClause, long whereCondition)
        throws SQLException {

        Cursor mCursor = db.query(table, fields, whereClause + "=" + whereCondition,
            null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    //Select all where (String) And Or
    public Cursor select(String table, String[] fields, String[] whereClause, String[] whereCondition,String[] whereAndOr)
        throws SQLException {

        StringBuilder where= new StringBuilder();
        for (int i = 0; i < whereClause.length; i++) {

            if(where.length() == 0){
                where = new StringBuilder(whereClause[i] + "=" + whereCondition[i]);
            }else {
                where.append(" ").append(whereAndOr[i-1]).append(" ").append(whereClause[i]).append("=").append(whereCondition[i]);
            }
        }


            Cursor mCursor = db.query(table, fields, where.toString(),
            null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    //Select with order
    public Cursor select(String table, String[] fields, String whereClause, String whereCondition, String orderBy, String smth)
        throws SQLException {

        Cursor mCursor;
        if (whereClause.isEmpty()) {
            mCursor = db.query(table, fields, null,
                null, null, null, orderBy + " " + smth);
        } else {
            mCursor = db.query(table, fields, whereClause + "=" + whereCondition,
                null, null, null, orderBy + " " + smth);
        }
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    /* 13 Delete ---------------------------------------------------------------------------------- */
    public int delete(String table, String primaryKey, long rowId) {
        return db.delete(table, primaryKey + "=" + rowId, null);
    }
}

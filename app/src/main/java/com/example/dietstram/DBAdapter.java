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
  public static final int DATABASE_VERSION = 2;

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
            "goal_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
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
            "user_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "user_email VARCHAR," +
            "user_password VARCHAR," +
            "user_salt VARCHAR," +
            "user_alias VARCHAR," +
            "user_dob DATE," +
            "user_gender INT," +
            "user_location VARCHAR," +
            "user_height INT," +
            "user_activity_level INT," +
//            "user_weight INT," +
            "user_measurement VARCHAR," +
            "user_last_seen TIME," +
            "user_note VARCHAR" +
            ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS food_diary_cal_eaten (" +
            "cal_eaten_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "cal_eaten_date DATE," +
            "cal_meal_no INT," +
            "cal_eaten_energy INT," +
            "cal_eaten_proteins INT," +
            "cal_eaten_carbs INT," +
            "cal_eaten_fat INT" +
            ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS food_diary (" +
            "fd_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "fd_date DATE," +
            "fd_meal_number INT," +
            "fd_food_id INT," +
            "fd_searving_size DOUBLE," +
            "fd_serving_mesurment VARCHAR," +
            "fd_energy_calculated DOUBLE," +
            "fd_protein_calculated DOUBLE," +
            "fd_carbohidrates_calculated DOUBLE," +
            "fd_fat_calculated DOUBLE," +
            "fd_user_id INT"
            + ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS categories (" +
            "category_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " category_name VARCHAR," +
            " category_parent_id INT," +
            " category_icon VARCHAR," +
            " category_note VARCHAR" + ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS food (" +
            " food_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " food_name VARCHAR," +
            " food_manufactor_name VARCHAR," +
            " food_serving_size DOUBLE," +
            " food_serving_mesurment VARCHAR," +
            " food_serving_name_number DOUBLE," +
            " food_serving_name_word VARCHAR," +
            " food_energy DOUBLE," +
            " food_protein DOUBLE," +
            " food_carbohidrates DOUBLE," +
            " food_fat DOUBLE," +
            " food_energy_calculated DOUBLE," +
            " food_protein_calculated DOUBLE," +
            " food_carbohidrates_calculated DOUBLE," +
            " food_fat_calculated DOUBLE," +
            " food_user_id INT," +
            " food_barcode VARCHAR," +
            " food_category_id INT," +
            " food_thumb VARCHAR," +
            " food_image_a VARCHAR," +
            " food_image_b VARCHAR," +
            " food_image_c VARCHAR," +
            " food_note VARCHAR" +
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

  /* 12 Select ---------------------------------------------------------------------------------- */
//  public Cursor select(String table, String[] fields, String column, String value)
//      throws SQLException {
//
//    //TODO SELECT
//    Cursor mCursor = db.query(table, fields, column+" = ?",
//        new String[]{value}, null, null, null);
//    if (mCursor != null) {
//      mCursor.moveToFirst();
//    }
//    return mCursor;
//
//  }
  public Cursor select(String table, String[] fields, String whereClause,String whereCondition)
      throws SQLException {

    //TODO SELECT
    Cursor mCursor = db.query(table, fields, whereClause+"="+whereCondition,
        null, null, null, null);
    if (mCursor != null) {
      mCursor.moveToFirst();
    }
    return mCursor;

  }

  public Cursor select(String table, String[] fields, String whereClause,long whereCondition)
      throws SQLException {

    //TODO SELECT
    Cursor mCursor = db.query(table, fields, whereClause+"="+whereCondition,
        null, null, null, null);
    if (mCursor != null) {
      mCursor.moveToFirst();
    }
    return mCursor;

  }

  //Select with order
  public Cursor select(String table, String[] fields, String whereClause,String whereCondition,String orderBy,String smth)
      throws SQLException {

    //TODO SELECT
    Cursor mCursor = db.query(table, fields, whereClause+"="+whereCondition,
        null, null, null, orderBy+" "+smth);
    if (mCursor != null) {
      mCursor.moveToFirst();
    }
    return mCursor;

  }

}

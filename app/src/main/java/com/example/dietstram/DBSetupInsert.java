package com.example.dietstram;

import android.content.Context;


public class DBSetupInsert {

  /* -------------------------------------------------------------------------------------------- */
  /*                                                                                              */
  /*                                        Variables                                             */
  /*                                                                                              */
  /* -------------------------------------------------------------------------------------------- */


  private final Context context;

  /* Public class -----------------------------------------------------*/
  public DBSetupInsert(Context context) {
    this.context = context;
  }

  /* Set up Insert to Categories -------------------------------------*/
  // To insert food to Category table
  public void setupInsertToCategories(String values) {
    DBAdapter db = new DBAdapter(context);
    db.open();
    db.insert("categories", "category_id, " +
        " category_name ," +
        " category_parent_id ," +
        " category_icon ," +
        " category_note ", values);
    db.close();
  }

  public void insertAllCategories() {
    setupInsertToCategories("NULL, 'name', 12,'icon', 'note'");
  }

  /* Set up Insert to Food -------------------------------------------*/
  // To insert food to food table
  public void setupInsertToFood(String values) {

    DBAdapter db = new DBAdapter(context);
    db.open();
    db.insert("food", "food_id," +
        " food_name," +
        " food_manufactor_name ," +
        " food_serving_size ," +
        " food_serving_mesurment ," +
        " food_serving_name_number," +
        " food_serving_name_word ," +
        " food_energy ," +
        " food_proteins ," +
        " food_carbohidrates ," +
        " food_fat ," +
        " food_energy_calculated ," +
        " food_proteins_calculated ," +
        " food_carbohidrates_calculated ," +
        " food_fat_calculated," +
        " food_user_id," +
        " food_barcode," +
        " food_category_id," +
        " food_thumb," +
        " food_image_a," +
        " food_image_b ," +
        " food_image_c ," +
        " food_note ", values);
    db.close();

  }

  public void insertAllFood() {
    setupInsertToFood(
        "NULL, 'Ham', 'Glide', 12,'ee',13,'serv_name',1111,111,10,12,123,123,23,123,1,'barcode',2,'thumb','a.jpg','b.jpg','c.jpg','note'");
  }

}

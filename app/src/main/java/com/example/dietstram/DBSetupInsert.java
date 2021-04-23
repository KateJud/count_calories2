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
    db.insert("categories", "_id, " +
        " category_name ," +
        " category_parent_id ," +
        " category_icon ," +
        " category_note ", values);
    db.close();
  }

  public void insertAllCategories() {
    //setupInsertToCategories("NULL, 'name', 12,'icon', 'note'");

    setupInsertToCategories("NULL, 'Bread', 0,'', NULL");
    setupInsertToCategories("NULL, 'Bread', 1,'', NULL");
    setupInsertToCategories("NULL, 'Cereals', 1,'', NULL");
    setupInsertToCategories("NULL, 'Frozen bread and roles', 1,'', NULL");
    setupInsertToCategories("NULL, 'Crispbread', 1,'', NULL");

    setupInsertToCategories("NULL, 'Dessert and baking', 0,'', NULL");
    setupInsertToCategories("NULL, 'Baking', 4,'', NULL");
    setupInsertToCategories("NULL, 'Biscuit', 4,'', NULL");


    setupInsertToCategories("NULL, 'Drinks', 0,'', NULL");
    setupInsertToCategories("NULL, 'Soda', 9,'', NULL");

    setupInsertToCategories("NULL, 'Fruit and vegetables', 0,'', NULL");
    setupInsertToCategories("NULL, 'Frozen fruits and vegetables', 12,'', NULL");
    setupInsertToCategories("NULL, 'Fruit', 12,'', NULL");
    setupInsertToCategories("NULL, 'Vegetables', 12,'', NULL");
    setupInsertToCategories("NULL, 'Canned fruit and vegetables', 12,'', NULL");

    setupInsertToCategories("NULL, 'Health', 0,'', NULL");
    setupInsertToCategories("NULL, 'Meal substitutes', 16,'', NULL");
    setupInsertToCategories("NULL, 'Protein bars', 16,'', NULL");
    setupInsertToCategories("NULL, 'Protein powder', 16,'', NULL");

    setupInsertToCategories("NULL, 'Meat, chicken and fish', 0,'', NULL");
    setupInsertToCategories("NULL, 'Meat', 20,'', NULL");
    setupInsertToCategories("NULL, 'Chicken', 20,'', NULL");
    setupInsertToCategories("NULL, 'Seafood', 20,'', NULL");

    setupInsertToCategories("NULL, 'Diary and eggs', 0,'', NULL");
    setupInsertToCategories("NULL, 'Eggs', 24,'', NULL");
    setupInsertToCategories("NULL, 'Cream and sour cream', 24,'', NULL");
    setupInsertToCategories("NULL, 'Yogurt', 24,'', NULL");

    setupInsertToCategories("NULL, 'Dinner', 0,'', NULL");
    setupInsertToCategories("NULL, 'Ready dinner dishes', 28,'', NULL");
    setupInsertToCategories("NULL, 'Pizza', 28,'', NULL");
    setupInsertToCategories("NULL, 'Noodle', 28,'', NULL");
    setupInsertToCategories("NULL, 'Pasta', 28,'', NULL");
    setupInsertToCategories("NULL, 'Rice', 28,'', NULL");
    setupInsertToCategories("NULL, 'Taco', 28,'', NULL");

    setupInsertToCategories("NULL, 'Cheese', 0,'', NULL");
    setupInsertToCategories("NULL, 'Cream cheese', 35,'', NULL");

    setupInsertToCategories("NULL, 'On bread', 0,'', NULL");
    setupInsertToCategories("NULL, 'Cold meats', 37,'', NULL");
    setupInsertToCategories("NULL, 'Sweet spreads', 37,'', NULL");
    setupInsertToCategories("NULL, 'Jam', 37,'', NULL");

    setupInsertToCategories("NULL, 'Snacks', 0,'', NULL");
    setupInsertToCategories("NULL, 'Nuts', 41,'', NULL");
    setupInsertToCategories("NULL, 'Potato chips', 0,'', NULL");

  }

  /* Set up Insert to Food -------------------------------------------*/
  // To insert food to food table
  public void setupInsertToFood(String values) {

    DBAdapter db = new DBAdapter(context);
    db.open();
    db.insert("food", "_id," +
        " food_name," +
        " food_manufactor_name," +
        " food_description," +
        " food_serving_size ," +
        " food_serving_mesurment ," +
        " food_serving_name_number," +
        " food_serving_name_word ," +
        " food_energy ," +
        " food_protein," +
        " food_carbohidrates ," +
        " food_fat ," +
        " food_energy_calculated," +
        " food_protein_calculated," +
        " food_carbohidrates_calculated ," +
        " food_fat_calculated ," +
        " food_user_id," +
        " food_barcode ," +
        " food_category_id ," +
        " food_thumb," +
        " food_image_a," +
        " food_image_b ," +
        " food_image_c, " +
        " food_last_used, " +
        " food_notes" , values);
    db.close();

  }

  public void insertAllFood() {
//    setupInsertToFood(
//        "NULL, 'Ham', 'Glide', 12,'ee',13,'serv_name',1111,111,10,12,123,123,23,123,1,'barcode',2,'thumb','a.jpg','b.jpg','c.jpg','note'");
    setupInsertToFood(  " NULL, 'ice-cream', 'manufacture_name', 'description','12.2', 'serving_mesurment', '13.3', 'serving_name_word', '220', '5', '67', '10', '180', '2', '63', '7', '1', 'barcode', '2', 'thumb ', 'image_a' , 'image_b','image_c ', '2017-11-20', 'food_notes'");

  }

}

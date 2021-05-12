package com.example.dietstram.database;

import android.content.Context;

import com.example.dietstram.database.DBAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


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
    setupInsertToCategories("NULL, 'Baking', 6,'', NULL");
    setupInsertToCategories("NULL, 'Biscuit', 6,'', NULL");


    setupInsertToCategories("NULL, 'Drinks', 0,'', NULL");
    setupInsertToCategories("NULL, 'Soda', 9,'', NULL");

    setupInsertToCategories("NULL, 'Fruit and vegetables', 0,'', NULL");
    setupInsertToCategories("NULL, 'Frozen fruits and vegetables', 11,'', NULL");
    setupInsertToCategories("NULL, 'Fruit', 11,'', NULL");
    setupInsertToCategories("NULL, 'Vegetables', 11,'', NULL");
    setupInsertToCategories("NULL, 'Canned fruit and vegetables', 11,'', NULL");

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
        " food_serving_size_gram,"+
        " food_serving_size_gram_measurement,"+
        " food_serving_size_pcs,"+
        " food_serving_size_pcs_measurement,"+
        " food_energy ," +
        " food_protein," +
        " food_carbohydrates ," +
        " food_fat ," +
        " food_energy_calculated," +
        " food_protein_calculated," +
        " food_carbohydrates_calculated ," +
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
// =========FOODS BREAD ============
    setupInsertToFood(  " NULL, 'White Bread', '', 'Bread','100', 'g', '1', 'portion', ' 266', '7.64', '50.61', '3.29', ' 266', '7.64', '50.61', '3.29', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Whole Wheat Bread', '', 'Bread','100', 'g', '1', 'portion', ' 259', '9.13', '47.14', '4.11', ' 259', '9.13', '47.14', '4.11', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Bread', '', 'Bread','100', 'g', '1', 'portion', ' 266', '7.64', '50.61', '3.29', ' 266', '7.64', '50.61', '3.29', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Italian Bread', '', 'Bread','100', 'g', '1', 'portion', ' 271', '8.80', '50.00', '3.50', ' 271', '8.80', '50.00', '3.50', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baguette', '', 'Bread','100', 'g', '1', 'portion', ' 274', '8.80', '51.90', '3.00', ' 274', '8.80', '51.90', '3.00', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sour Dough Bread', '', 'Bread','100', 'g', '1', 'portion', ' 274', '8.80', '51.90', '3.00', ' 274', '8.80', '51.90', '3.00', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Multigrain Bread', '', 'Bread','100', 'g', '1', 'portion', ' 251', '10.00', '46.40', '3.80', ' 251', '10.00', '46.40', '3.80', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Whole Wheat Bread', '', 'Bread','100', 'g', '1', 'portion', ' 278', '8.40', '51.40', '5.40', ' 278', '8.40', '51.40', '5.40', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dinner Rolls', '', 'Bread','100', 'g', '1', 'portion', ' 300', '8.40', '50.40', '7.30', ' 300', '8.40', '50.40', '7.30', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted White Bread', '', 'Bread','100', 'g', '1', 'portion', ' 293', '9.00', '54.40', '4.00', ' 293', '9.00', '54.40', '4.00', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rye Bread', '', 'Bread','100', 'g', '1', 'portion', ' 259', '8.50', '48.30', '3.30', ' 259', '8.50', '48.30', '3.30', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'White Bread (Home Recipe or Bakery)', '', 'Bread','100', 'g', '1', 'portion', ' 285', '7.84', '49.54', '5.73', ' 285', '7.84', '49.54', '5.73', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'White Bread', '', 'Bread','100', 'g', '1', 'portion', ' 266', '7.64', '50.61', '3.29', ' 266', '7.64', '50.61', '3.29', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ciabatta', '', 'Bread','100', 'g', '1', 'portion', ' 271', '8.80', '50.00', '3.50', ' 271', '8.80', '50.00', '3.50', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Bread', '', 'Bread','100', 'g', '1', 'portion', ' 293', '9.00', '54.40', '4.00', ' 293', '9.00', '54.40', '4.00', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pita Bread', '', 'Bread','100', 'g', '1', 'portion', ' 275', '9.10', '55.70', '1.20', ' 275', '9.10', '55.70', '1.20', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Wheat Bread (Reduced Calorie)', '', 'Bread','100', 'g', '1', 'portion', ' 198', '9.10', '43.60', '2.30', ' 198', '9.10', '43.60', '2.30', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Marble Rye and Pumpernickel Bread', '', 'Bread','100', 'g', '1', 'portion', ' 254', '8.60', '47.90', '3.20', ' 254', '8.60', '47.90', '3.20', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Zucchini Bread', '', 'Bread','719', 'g', '1', 'portion', ' 2688', '37.74', '338.98', '134.63', ' 2688', '37.74', '338.98', '134.63', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted 100% Whole Wheat Bread', '', 'Bread','100', 'g', '1', 'portion', ' 277', '10.90', '51.70', '4.80', ' 277', '10.90', '51.70', '4.80', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'French Rolls', '', 'Bread','100', 'g', '1', 'portion', ' 277', '8.60', '50.20', '4.30', ' 277', '8.60', '50.20', '4.30', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Hamburger or Hotdog Rolls', '', 'Bread','100', 'g', '1', 'portion', ' 279', '9.50', '49.45', '4.33', ' 279', '9.50', '49.45', '4.33', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Potato Bread', '', 'Bread','100', 'g', '1', 'portion', ' 266', '7.64', '50.61', '3.29', ' 266', '7.64', '50.61', '3.29', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Reduced Calorie High Fiber Italian Bread', '', 'Bread','99', 'g', '1', 'portion', ' 210', '7.79', '41.82', '3.05', ' 210', '7.79', '41.82', '3.05', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Whole Wheat Bread', '', 'Bread','100', 'g', '1', 'portion', ' 282', '9.95', '51.32', '4.42', ' 282', '9.95', '51.32', '4.42', '1', 'barcode', '2', '', '' , '',' ', '', ''");
// =========FOODS CEREALS ============
    setupInsertToFood(  " NULL, 'Cereal', '', 'Cereals','100', 'g', '1', 'portion', ' 376', '7.24', '83.02', '3.38', ' 376', '7.24', '83.02', '3.38', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Corn Flakes', '', 'Cereals','100', 'g', '1', 'portion', ' 360', '6.70', '86.70', '0.10', ' 360', '6.70', '86.70', '0.10', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oats Cereal (Instant, Prepared with Water, Fortified)', '', 'Cereals','100', 'g', '1', 'portion', ' 55', '2.32', '9.59', '0.91', ' 55', '2.32', '9.59', '0.91', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'All-Bran Plus', '', 'Cereals','1 servin', 'g', '1', 'portion', ' 100', '2.00', '11.00', '0.50', ' 100', '2.00', '11.00', '0.50', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oats Cereal (Without Salt, Cooked with Water, Unenriched)', '', 'Cereals','100', 'g', '1', 'portion', ' 63', '2.60', '10.80', '1.00', ' 63', '2.60', '10.80', '1.00', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rice Crisps Cereal', '', 'Cereals','100', 'g', '1', 'portion', ' 381', '6.45', '86.04', '1.27', ' 381', '6.45', '86.04', '1.27', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Bran Flakes', '', 'Cereals','100', 'g', '1', 'portion', ' 320', '9.40', '80.40', '2.20', ' 320', '9.40', '80.40', '2.20', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cereal', '', 'Cereals','1 servin', 'g', '1', 'portion', ' 170', '6.00', '6.00', '15.00', ' 170', '6.00', '6.00', '15.00', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Instant Cream Of Wheat Cereals', '', 'Cereals','100', 'g', '1', 'portion', ' 366', '10.60', '75.50', '1.40', ' 366', '10.60', '75.50', '1.40', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Milk \\0N Cereal Bar', '', 'Cereals','100', 'g', '1', 'portion', ' 413', '6.47', '72.05', '10.98', ' 413', '6.47', '72.05', '10.98', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Cream Of Rice Cereals', '', 'Cereals','100', 'g', '1', 'portion', ' 370', '6.30', '82.40', '0.50', ' 370', '6.30', '82.40', '0.50', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chocolate Flavored Rings Cereal (Presweetened)', '', 'Cereals','100', 'g', '1', 'portion', ' 415', '4.80', '81.90', '8.80', ' 415', '4.80', '81.90', '8.80', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Regular Cream Of Wheat Cereals', '', 'Cereals','100', 'g', '1', 'portion', ' 370', '10.50', '76.50', '1.50', ' 370', '10.50', '76.50', '1.50', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Puffed Rice Cereal (Fortified)', '', 'Cereals','100', 'g', '1', 'portion', ' 402', '6.30', '89.80', '0.50', ' 402', '6.30', '89.80', '0.50', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Quick Cream Of Wheat Cereals', '', 'Cereals','100', 'g', '1', 'portion', ' 361', '10.20', '75.00', '1.30', ' 361', '10.20', '75.00', '1.30', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Granola Cereal', '', 'Cereals','100', 'g', '1', 'portion', ' 490', '14.87', '52.95', '24.36', ' 490', '14.87', '52.95', '24.36', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Raisin and Almond Crunch Cereal', '', 'Cereals','1 servin', 'g', '1', 'portion', ' 188', '10.40', '26.90', '4.30', ' 188', '10.40', '26.90', '4.30', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baby Food Jarred Cereal', '', 'Cereals','100', 'g', '1', 'portion', ' 78', '1.24', '16.90', '0.54', ' 78', '1.24', '16.90', '0.54', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Puffed Wheat Cereal (Presweetened)', '', 'Cereals','100', 'g', '1', 'portion', ' 398', '5.50', '90.90', '1.40', ' 398', '5.50', '90.90', '1.40', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Shredded Wheat Cereal (Presweetened)', '', 'Cereals','100', 'g', '1', 'portion', ' 352', '7.80', '83.80', '1.90', ' 352', '7.80', '83.80', '1.90', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Quick or Instant Cream Of Wheat', '', 'Cereals','265', 'g', '1', 'portion', ' 117', '3.29', '24.12', '0.42', ' 117', '3.29', '24.12', '0.42', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Quick Cream Of Wheat', '', 'Cereals','265', 'g', '1', 'portion', ' 117', '3.29', '24.12', '0.42', ' 117', '3.29', '24.12', '0.42', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Puffed Rice Cereal Fruit Flavored (Presweetened)', '', 'Cereals','100', 'g', '1', 'portion', ' 401', '3.60', '87.90', '3.90', ' 401', '3.60', '87.90', '3.90', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cream Of Wheat made with Milk', '', 'Cereals','353', 'g', '1', 'portion', ' 307', '15.87', '41.92', '8.14', ' 307', '15.87', '41.92', '8.14', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'White Chocolate with Cereal', '', 'Cereals','100', 'g', '1', 'portion', ' 516', '5.94', '63.18', '27.46', ' 516', '5.94', '63.18', '27.46', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chex Cereal', '', 'Cereals','100', 'g', '1', 'portion', ' 367', '7.01', '84.98', '1.28', ' 367', '7.01', '84.98', '1.28', '1', 'barcode', '3', '', '' , '',' ', '', ''");
// =========FOODS FROZEN BREAD AND ROLES ============
    setupInsertToFood(  " NULL, 'Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 266', '7.64', '50.61', '3.29', ' 266', '7.64', '50.61', '3.29', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Black Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 250', '8.70', '47.50', '3.10', ' 250', '8.70', '47.50', '3.10', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Barley Bread', '', 'Frozen bread and roles','1526', 'g', '1', 'portion', ' 4302', '129.07', '834.36', '49.89', ' 4302', '129.07', '834.36', '49.89', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Buckwheat Bread', '', 'Frozen bread and roles','1366', 'g', '1', 'portion', ' 3633', '118.67', '677.21', '52.99', ' 3633', '118.67', '677.21', '52.99', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soy Bread', '', 'Frozen bread and roles','1402', 'g', '1', 'portion', ' 3714', '179.83', '628.91', '53.12', ' 3714', '179.83', '628.91', '53.12', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Keto Bread', '', 'Frozen bread and roles','936', 'g', '1', 'portion', ' 2724', '117.87', '66.66', '234.23', ' 2724', '117.87', '66.66', '234.23', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Mosticolli with Meatballs with Sauce and Bread (Frozen Meal)', '', 'Frozen bread and roles','308', 'g', '1', 'portion', ' 412', '25.04', '44.20', '14.55', ' 412', '25.04', '44.20', '14.55', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pita Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 275', '9.10', '55.70', '1.20', ' 275', '9.10', '55.70', '1.20', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cinnamon Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 266', '7.64', '50.61', '3.29', ' 266', '7.64', '50.61', '3.29', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Garlic Bread', '', 'Frozen bread and roles','116', 'g', '1', 'portion', ' 383', '8.99', '52.92', '14.83', ' 383', '8.99', '52.92', '14.83', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Raisin Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 274', '7.90', '52.30', '4.40', ' 274', '7.90', '52.30', '4.40', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetable Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 255', '7.73', '47.70', '3.60', ' 255', '7.73', '47.70', '3.60', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Bread Pudding', '', 'Frozen bread and roles','822', 'g', '1', 'portion', ' 1258', '43.32', '191.18', '38.96', ' 1258', '43.32', '191.18', '38.96', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Carrot Bread', '', 'Frozen bread and roles','1028', 'g', '1', 'portion', ' 2435', '39.85', '551.89', '13.65', ' 2435', '39.85', '551.89', '13.65', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cloud Bread', '', 'Frozen bread and roles','382', 'g', '1', 'portion', ' 457', '28.56', '4.26', '35.57', ' 457', '28.56', '4.26', '35.57', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soul Bread', '', 'Frozen bread and roles','1183', 'g', '1', 'portion', ' 5050', '252.43', '41.08', '451.08', ' 5050', '252.43', '41.08', '451.08', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oatmeal Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 269', '8.40', '48.50', '4.40', ' 269', '8.40', '48.50', '4.40', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cuban Bread', '', 'Frozen bread and roles','7729', 'g', '1', 'portion', ' 21410', '678.64', '4017.72', '251.98', ' 21410', '678.64', '4017.72', '251.98', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Batter Bread', '', 'Frozen bread and roles','670', 'g', '1', 'portion', ' 1863', '54.75', '308.93', '43.16', ' 1863', '54.75', '308.93', '43.16', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Onion Bread', '', 'Frozen bread and roles','107', 'g', '1', 'portion', ' 269', '7.70', '51.32', '3.30', ' 269', '7.70', '51.32', '3.30', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sesame Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 271', '8.80', '50.00', '3.50', ' 271', '8.80', '50.00', '3.50', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, '100% Whole Wheat Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 246', '9.70', '46.10', '4.20', ' 246', '9.70', '46.10', '4.20', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Pumpernickel Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 275', '9.56', '52.20', '3.41', ' 275', '9.56', '52.20', '3.41', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Multigrain Bread with Raisins', '', 'Frozen bread and roles','823', 'g', '1', 'portion', ' 2058', '68.06', '413.89', '22.72', ' 2058', '68.06', '413.89', '22.72', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Low Gluten Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 267', '9.78', '47.80', '5.06', ' 267', '9.78', '47.80', '5.06', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit and Nut Bread', '', 'Frozen bread and roles','959', 'g', '1', 'portion', ' 3713', '55.55', '505.98', '171.92', ' 3713', '55.55', '505.98', '171.92', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cassava Bread Casabe', '', 'Frozen bread and roles','381', 'g', '1', 'portion', ' 1139', '9.68', '271.35', '1.98', ' 1139', '9.68', '271.35', '1.98', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pumpernickel Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 250', '8.70', '47.50', '3.10', ' 250', '8.70', '47.50', '3.10', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Wheat Germ Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 261', '9.60', '48.30', '2.90', ' 261', '9.60', '48.30', '2.90', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oat Bran Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 262', '11.56', '44.22', '4.89', ' 262', '11.56', '44.22', '4.89', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Armenian Grecian Italian Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 271', '8.80', '50.00', '3.50', ' 271', '8.80', '50.00', '3.50', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pita with Fruit Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 278', '8.56', '58.00', '1.16', ' 278', '8.56', '58.00', '1.16', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Cheese Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 298', '9.80', '51.74', '5.46', ' 298', '9.80', '51.74', '5.46', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Challah Egg Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 283', '9.50', '47.80', '6.00', ' 283', '9.50', '47.80', '6.00', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fiber Added White Bread', '', 'Frozen bread and roles','99', 'g', '1', 'portion', ' 214', '6.74', '50.16', '2.72', ' 214', '6.74', '50.16', '2.72', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'High Protein Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 245', '12.10', '43.80', '2.20', ' 245', '12.10', '43.80', '2.20', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Potato Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 292', '8.40', '55.62', '3.62', ' 292', '8.40', '55.62', '3.62', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Raisin Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 297', '8.60', '56.90', '4.80', ' 297', '8.60', '56.90', '4.80', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Sour Dough Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 298', '9.60', '56.40', '3.30', ' 298', '9.60', '56.40', '3.30', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fried Dough Bread', '', 'Frozen bread and roles','1324', 'g', '1', 'portion', ' 4940', '90.46', '593.61', '242.37', ' 4940', '90.46', '593.61', '242.37', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Spanish Coffee Bread', '', 'Frozen bread and roles','178', 'g', '1', 'portion', ' 612', '13.53', '103.74', '15.52', ' 612', '13.53', '103.74', '15.52', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soft Bread Stick', '', 'Frozen bread and roles','352', 'g', '1', 'portion', ' 1239', '34.63', '203.33', '30.40', ' 1239', '34.63', '203.33', '30.40', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sprouted Wheat Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 260', '9.10', '47.20', '4.10', ' 260', '9.10', '47.20', '4.10', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Whole Wheat Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 259', '9.13', '47.14', '4.11', ' 259', '9.13', '47.14', '4.11', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Black Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 275', '9.56', '52.20', '3.41', ' 275', '9.56', '52.20', '3.41', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Soy Bread', '', 'Frozen bread and roles','1402', 'g', '1', 'portion', ' 4135', '199.87', '698.85', '59.01', ' 4135', '199.87', '698.85', '59.01', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Sunflower Meal Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 300', '10.76', '49.89', '6.33', ' 300', '10.76', '49.89', '6.33', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Bread without Nuts', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 323', '4.29', '54.56', '10.31', ' 323', '4.29', '54.56', '10.31', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Irish Soda Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 289', '6.57', '56.09', '4.96', ' 289', '6.57', '56.09', '4.96', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Sesame Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 271', '8.80', '50.00', '3.50', ' 271', '8.80', '50.00', '3.50', '1', 'barcode', '4', '', '' , '',' ', '', ''");
// =========FOODS CRISPBREAD ============
    setupInsertToFood(  " NULL, 'Low Sodium Rye Crispbread', '', 'Crispbread','100', 'g', '1', 'portion', ' 366', '7.90', '82.20', '1.30', ' 366', '7.90', '82.20', '1.30', '1', 'barcode', '5', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Extra Crispy Wheat or Rye Crispbread', '', 'Crispbread','100', 'g', '1', 'portion', ' 397', '10.71', '74.26', '6.43', ' 397', '10.71', '74.26', '6.43', '1', 'barcode', '5', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'No Added Fat Wheat Crispbread', '', 'Crispbread','747', 'g', '1', 'portion', ' 3011', '84.65', '632.33', '8.07', ' 3011', '84.65', '632.33', '8.07', '1', 'barcode', '5', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Low Sodium Wheat Crispbread', '', 'Crispbread','745', 'g', '1', 'portion', ' 3009', '84.70', '632.29', '8.05', ' 3009', '84.70', '632.29', '8.05', '1', 'barcode', '5', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'No Added Fat Rye Crispbread', '', 'Crispbread','100', 'g', '1', 'portion', ' 366', '7.90', '82.20', '1.30', ' 366', '7.90', '82.20', '1.30', '1', 'barcode', '5', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rye Crispbread', '', 'Crispbread','100', 'g', '1', 'portion', ' 366', '7.90', '82.20', '1.30', ' 366', '7.90', '82.20', '1.30', '1', 'barcode', '5', '', '' , '',' ', '', ''");
// =========FOODS BAKING ============
    setupInsertToFood(  " NULL, 'Baking Powder or Buttermilk Biscuit (from Mix)', '', 'Baking','201', 'g', '1', 'portion', ' 652', '14.45', '93.86', '23.67', ' 652', '14.45', '93.86', '23.67', '1', 'barcode', '7', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Chocolate Liquid', '', 'Baking','100', 'g', '1', 'portion', ' 472', '12.10', '33.90', '47.70', ' 472', '12.10', '33.90', '47.70', '1', 'barcode', '7', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Soda', '', 'Baking','100', 'g', '1', 'portion', ' 0', '0.00', '0.00', '0.00', ' 0', '0.00', '0.00', '0.00', '1', 'barcode', '7', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Powder or Buttermilk Biscuit (Refrigerated Dough or Home Recipe)', '', 'Baking','100', 'g', '1', 'portion', ' 348', '6.77', '46.81', '14.82', ' 348', '6.77', '46.81', '14.82', '1', 'barcode', '7', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Chocolate Squares', '', 'Baking','100', 'g', '1', 'portion', ' 501', '12.90', '29.84', '52.31', ' 501', '12.90', '29.84', '52.31', '1', 'barcode', '7', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Powder or Buttermilk Biscuit (from Refrigerated Dough)', '', 'Baking','100', 'g', '1', 'portion', ' 349', '6.70', '47.50', '14.70', ' 349', '6.70', '47.50', '14.70', '1', 'barcode', '7', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Powder (Low Sodium)', '', 'Baking','100', 'g', '1', 'portion', ' 97', '0.10', '46.90', '0.40', ' 97', '0.10', '46.90', '0.40', '1', 'barcode', '7', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Chocolate Mexican Squares', '', 'Baking','100', 'g', '1', 'portion', ' 426', '3.64', '77.41', '15.59', ' 426', '3.64', '77.41', '15.59', '1', 'barcode', '7', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Powder or Buttermilk Biscuit (Commercially Baked)', '', 'Baking','100', 'g', '1', 'portion', ' 365', '6.20', '48.50', '16.50', ' 365', '6.20', '48.50', '16.50', '1', 'barcode', '7', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Powder or Buttermilk Biscuit (Home Recipe)', '', 'Baking','100', 'g', '1', 'portion', ' 354', '6.99', '44.58', '16.33', ' 354', '6.99', '44.58', '16.33', '1', 'barcode', '7', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Powder (Sodium Aluminum Sulfate, Double Acting)', '', 'Baking','100', 'g', '1', 'portion', ' 53', '0.00', '27.70', '0.00', ' 53', '0.00', '27.70', '0.00', '1', 'barcode', '7', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Powder (Straight Phosphate, Double Acting)', '', 'Baking','100', 'g', '1', 'portion', ' 51', '0.10', '24.10', '0.00', ' 51', '0.10', '24.10', '0.00', '1', 'barcode', '7', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Lowfat Baking Powder or Buttermilk Biscuit (from Refrigerated Dough)', '', 'Baking','100', 'g', '1', 'portion', ' 300', '7.80', '55.40', '5.20', ' 300', '7.80', '55.40', '5.20', '1', 'barcode', '7', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Cocoa', '', 'Baking','1 servin', 'g', '1', 'portion', ' 15', '1.00', '1.00', '0.50', ' 15', '1.00', '1.00', '0.50', '1', 'barcode', '7', '', '' , '',' ', '', ''");
// =========FOODS BISCUIT ============
    setupInsertToFood(  " NULL, 'Plain or Buttermilk Biscuits', '', 'Biscuit','100', 'g', '1', 'portion', ' 353', '7.00', '44.60', '16.30', ' 353', '7.00', '44.60', '16.30', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Powder or Buttermilk Biscuit (Home Recipe)', '', 'Biscuit','100', 'g', '1', 'portion', ' 354', '6.99', '44.58', '16.33', ' 354', '6.99', '44.58', '16.33', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Plain or Buttermilk Biscuits (Commercial)', '', 'Biscuit','100', 'g', '1', 'portion', ' 365', '6.20', '48.50', '16.50', ' 365', '6.20', '48.50', '16.50', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Whole Wheat Biscuit', '', 'Biscuit','479', 'g', '1', 'portion', ' 1489', '46.31', '221.37', '55.46', ' 1489', '46.31', '221.37', '55.46', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Bacon, Egg & Cheese Biscuit (Regular)', '', 'Biscuit','1 servin', 'g', '1', 'portion', ' 450', '13.00', '40.00', '24.00', ' 450', '13.00', '40.00', '24.00', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Biscuit (Regular)', '', 'Biscuit','1 servin', 'g', '1', 'portion', ' 260', '5.00', '33.00', '12.00', ' 260', '5.00', '33.00', '12.00', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Powder or Buttermilk Biscuit (from Refrigerated Dough)', '', 'Biscuit','100', 'g', '1', 'portion', ' 349', '6.70', '47.50', '14.70', ' 349', '6.70', '47.50', '14.70', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Plain or Buttermilk Biscuits (Dry Mix, Prepared)', '', 'Biscuit','100', 'g', '1', 'portion', ' 335', '7.30', '48.40', '12.10', ' 335', '7.30', '48.40', '12.10', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Biscuit (Large)', '', 'Biscuit','1 servin', 'g', '1', 'portion', ' 320', '5.00', '39.00', '16.00', ' 320', '5.00', '39.00', '16.00', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Powder or Buttermilk Biscuit (Refrigerated Dough or Home Recipe)', '', 'Biscuit','100', 'g', '1', 'portion', ' 348', '6.77', '46.81', '14.82', ' 348', '6.77', '46.81', '14.82', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ham On Biscuit', '', 'Biscuit','106', 'g', '1', 'portion', ' 363', '12.56', '41.08', '17.28', ' 363', '12.56', '41.08', '17.28', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fried Biscuit Dough', '', 'Biscuit','100', 'g', '1', 'portion', ' 335', '6.50', '46.21', '14.08', ' 335', '6.50', '46.21', '14.08', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Plain or Buttermilk Biscuit Dough (Higher Fat)', '', 'Biscuit','100', 'g', '1', 'portion', ' 318', '6.20', '43.70', '13.50', ' 318', '6.20', '43.70', '13.50', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Plain or Buttermilk Biscuit Dough (Lower Fat)', '', 'Biscuit','100', 'g', '1', 'portion', ' 257', '6.70', '47.60', '4.50', ' 257', '6.70', '47.60', '4.50', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pizza Biscuit Bake', '', 'Biscuit','1 servin', 'g', '1', 'portion', ' 460', '19.00', '39.00', '26.00', ' 460', '19.00', '39.00', '26.00', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pocky Chocolate Cream Covered Biscuit Snacks', '', 'Biscuit','1 packa', 'g', '1', 'portion', ' 200', '4.00', '27.00', '8.00', ' 200', '4.00', '27.00', '8.00', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Biscuit Dough', '', 'Biscuit','100', 'g', '1', 'portion', ' 257', '6.70', '47.60', '4.50', ' 257', '6.70', '47.60', '4.50', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Biscuit with Gravy', '', 'Biscuit','100', 'g', '1', 'portion', ' 230', '5.59', '19.89', '14.32', ' 230', '5.59', '19.89', '14.32', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chik Biscuit', '', 'Biscuit','1 servin', 'g', '1', 'portion', ' 360', '13.00', '40.00', '15.00', ' 360', '13.00', '40.00', '15.00', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Shortcake Biscuit with Fruit', '', 'Biscuit','65', 'g', '1', 'portion', ' 146', '2.42', '23.10', '5.33', ' 146', '2.42', '23.10', '5.33', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg and Steak on Biscuit', '', 'Biscuit','100', 'g', '1', 'portion', ' 302', '11.05', '28.18', '16.15', ' 302', '11.05', '28.18', '16.15', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg and Ham on Biscuit', '', 'Biscuit','138', 'g', '1', 'portion', ' 331', '14.68', '25.27', '19.43', ' 331', '14.68', '25.27', '19.43', '1', 'barcode', '8', '', '' , '',' ', '', ''");
// =========FOODS SODA ============
    setupInsertToFood(  " NULL, 'Soda', '', 'Soda','100', 'g', '1', 'portion', ' 38', '0.07', '9.77', '0.01', ' 38', '0.07', '9.77', '0.01', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soft Drink', '', 'Soda','100', 'g', '1', 'portion', ' 38', '0.07', '9.78', '0.02', ' 38', '0.07', '9.78', '0.02', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Mountain Dew (16 oz)', '', 'Soda','1 servin', 'g', '1', 'portion', ' 170', '0.00', '44.00', '0.00', ' 170', '0.00', '44.00', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola Soda (with Caffeine)', '', 'Soda','100', 'g', '1', 'portion', ' 37', '0.07', '9.56', '0.02', ' 37', '0.07', '9.56', '0.02', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Root Beer', '', 'Soda','100', 'g', '1', 'portion', ' 41', '0.00', '10.60', '0.00', ' 41', '0.00', '10.60', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola Soft Drink with Higher Caffeine', '', 'Soda','100', 'g', '1', 'portion', ' 41', '0.00', '10.58', '0.00', ' 41', '0.00', '10.58', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dr Pepper (Medium)', '', 'Soda','1 servin', 'g', '1', 'portion', ' 180', '0.00', '48.00', '0.00', ' 180', '0.00', '48.00', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola Soft Drink', '', 'Soda','100', 'g', '1', 'portion', ' 37', '0.07', '9.56', '0.02', ' 37', '0.07', '9.56', '0.02', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Lemon-Lime Soda (with Caffeine)', '', 'Soda','100', 'g', '1', 'portion', ' 41', '0.09', '10.42', '0.00', ' 41', '0.09', '10.42', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola Soft Drink Decaffeinated', '', 'Soda','100', 'g', '1', 'portion', ' 41', '0.00', '10.58', '0.00', ' 41', '0.00', '10.58', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sugar Free Decaffeinated Pepper-Type Soft Drink', '', 'Soda','100', 'g', '1', 'portion', ' 1', '0.12', '0.15', '0.00', ' 1', '0.12', '0.15', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola Soda (with Higher Caffeine)', '', 'Soda','100', 'g', '1', 'portion', ' 41', '0.00', '10.58', '0.00', ' 41', '0.00', '10.58', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cream Soda', '', 'Soda','100', 'g', '1', 'portion', ' 51', '0.00', '13.30', '0.00', ' 51', '0.00', '13.30', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soda (Other Than Cola or Pepper, Without Caffeine, with Sodium Saccharin)', '', 'Soda','100', 'g', '1', 'portion', ' 0', '0.00', '0.10', '0.00', ' 0', '0.00', '0.10', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Punch (made with Fruit Juice and Soda)', '', 'Soda','100', 'g', '1', 'portion', ' 44', '0.18', '10.82', '0.06', ' 44', '0.18', '10.82', '0.06', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola or Pepper Soda (with Caffeine, with Aspartame)', '', 'Soda','100', 'g', '1', 'portion', ' 1', '0.12', '0.15', '0.00', ' 1', '0.12', '0.15', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Diet Soda', '', 'Soda','101', 'g', '1', 'portion', ' 1', '0.11', '0.24', '0.02', ' 1', '0.11', '0.24', '0.02', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola or Pepper Soda (Low Calorie with Sodium Saccharin, Contains Caffeine)', '', 'Soda','100', 'g', '1', 'portion', ' 0', '0.00', '0.10', '0.00', ' 0', '0.00', '0.10', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Blood Orange Soda', '', 'Soda','1 servin', 'g', '1', 'portion', ' 110', '0.00', '28.00', '0.00', ' 110', '0.00', '28.00', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sugar Free Chocolate Flavored Soda', '', 'Soda','100', 'g', '1', 'portion', ' 2', '0.11', '0.29', '0.03', ' 2', '0.11', '0.29', '0.03', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chocolate Ice Cream Soda', '', 'Soda','334', 'g', '1', 'portion', ' 291', '3.34', '50.93', '9.70', ' 291', '3.34', '50.93', '9.70', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Grape Soda', '', 'Soda','100', 'g', '1', 'portion', ' 43', '0.00', '11.20', '0.00', ' 43', '0.00', '11.20', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ice Cream Soda (Flavors Other Than Chocolate)', '', 'Soda','334', 'g', '1', 'portion', ' 278', '3.08', '46.88', '9.70', ' 278', '3.08', '46.88', '9.70', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Club Soda', '', 'Soda','100', 'g', '1', 'portion', ' 0', '0.00', '0.00', '0.00', ' 0', '0.00', '0.00', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola or Pepper Soda (with Caffeine, with Aspartame, Low Calorie)', '', 'Soda','100', 'g', '1', 'portion', ' 0', '0.10', '0.00', '0.00', ' 0', '0.10', '0.00', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Irish Soda Bread', '', 'Soda','100', 'g', '1', 'portion', ' 289', '6.57', '56.09', '4.96', ' 289', '6.57', '56.09', '4.96', '1', 'barcode', '10', '', '' , '',' ', '', ''");
// =========FOODS FROZEN FRUITS AND VEGETABLES ============
    setupInsertToFood(  " NULL, 'Turkey with Gravy, Dressing, Vegetable and Fruit (Diet Frozen Meal)', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 112', '6.91', '18.16', '1.80', ' 112', '6.91', '18.16', '1.80', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cheese Filled Ravioli with Vegetable and Fruit (Frozen Meal)', '', 'Frozen fruits and vegetables','99', 'g', '1', 'portion', ' 102', '2.67', '17.24', '3.08', ' 102', '2.67', '17.24', '3.08', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Upside Down Cake (All Fruits)', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 319', '3.45', '50.65', '11.97', ' 319', '3.45', '50.65', '11.97', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fun Fruits Creme Supremes', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 475', '3.68', '69.33', '21.04', ' 475', '3.68', '69.33', '21.04', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Salad (without Citrus Fruits)', '', 'Frozen fruits and vegetables','90', 'g', '1', 'portion', ' 59', '0.62', '14.25', '0.77', ' 59', '0.62', '14.25', '0.77', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Salad with Pudding (Excluding Citrus Fruits)', '', 'Frozen fruits and vegetables','509', 'g', '1', 'portion', ' 448', '8.35', '95.64', '4.73', ' 448', '8.35', '95.64', '4.73', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Cocktail or Mix (Excluding Citrus Fruits)', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 55', '0.70', '14.15', '0.20', ' 55', '0.70', '14.15', '0.20', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baby Food Strained Garden Vegetables Mixed Vegetables', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 34', '1.75', '7.42', '0.35', ' 34', '1.75', '7.42', '0.35', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken in Soy-Based Sauce, Rice and Vegetables (Frozen Meal)', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 109', '6.72', '18.03', '0.87', ' 109', '6.72', '18.03', '0.87', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Shrimp and Vegetables in Sauce with Noodles (Diet Frozen Meal)', '', 'Frozen fruits and vegetables','314', 'g', '1', 'portion', ' 305', '17.09', '42.41', '5.53', ' 305', '17.09', '42.41', '5.53', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Scrambled Egg (Cholesterol-Free Frozen Mixture with Vegetables)', '', 'Frozen fruits and vegetables','135', 'g', '1', 'portion', ' 97', '12.51', '3.49', '3.40', ' 97', '12.51', '3.49', '3.40', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetables in Pastry', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 308', '6.60', '20.93', '22.98', ' 308', '6.60', '20.93', '22.98', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Stir Fried Vegetables', '', 'Frozen fruits and vegetables','1649', 'g', '1', 'portion', ' 1242', '75.12', '89.35', '70.29', ' 1242', '75.12', '89.35', '70.29', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baby Food Garden Vegetables Mixed Vegetables', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 35', '1.63', '7.68', '0.37', ' 35', '1.63', '7.68', '0.37', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef, Potatoes and Vegetables (Mixture)', '', 'Frozen fruits and vegetables','841', 'g', '1', 'portion', ' 942', '101.21', '80.68', '22.29', ' 942', '101.21', '80.68', '22.29', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pork, Potatoes and Vegetables (Mixture)', '', 'Frozen fruits and vegetables','347', 'g', '1', 'portion', ' 406', '28.28', '41.24', '14.17', ' 406', '28.28', '41.24', '14.17', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef Shish Kabob with Vegetables', '', 'Frozen fruits and vegetables','285', 'g', '1', 'portion', ' 248', '33.11', '11.79', '7.28', ' 248', '33.11', '11.79', '7.28', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetables and Cheese in Pastry', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 317', '8.07', '19.40', '23.84', ' 317', '8.07', '19.40', '23.84', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Lasagna with Vegetables', '', 'Frozen fruits and vegetables','3487', 'g', '1', 'portion', ' 4498', '239.91', '599.77', '133.21', ' 4498', '239.91', '599.77', '133.21', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Creamed Macaroni with Vegetables', '', 'Frozen fruits and vegetables','746', 'g', '1', 'portion', ' 918', '30.59', '124.30', '33.57', ' 918', '30.59', '124.30', '33.57', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cottage Cheese (with Vegetables)', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 95', '10.90', '3.00', '4.20', ' 95', '10.90', '3.00', '4.20', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Linguini with Vegetables and Seafood in White Wine Sauce (Diet Frozen Meal)', '', 'Frozen fruits and vegetables','269', 'g', '1', 'portion', ' 312', '22.86', '29.75', '10.93', ' 312', '22.86', '29.75', '10.93', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ham and Vegetables (Mixture)', '', 'Frozen fruits and vegetables','1820', 'g', '1', 'portion', ' 2458', '208.98', '56.07', '155.28', ' 2458', '208.98', '56.07', '155.28', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Gelatin Salad with Vegetables', '', 'Frozen fruits and vegetables','689', 'g', '1', 'portion', ' 351', '7.65', '83.52', '0.21', ' 351', '7.65', '83.52', '0.21', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sushi with Vegetables', '', 'Frozen fruits and vegetables','2110', 'g', '1', 'portion', ' 3060', '65.00', '668.56', '5.91', ' 3060', '65.00', '668.56', '5.91', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rice with Vegetables', '', 'Frozen fruits and vegetables','162', 'g', '1', 'portion', ' 161', '4.12', '31.06', '2.22', ' 161', '4.12', '31.06', '2.22', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Hawaiian Style Pickled Vegetables', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 35', '1.03', '6.87', '0.37', ' 35', '1.03', '6.87', '0.37', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Lettuce Salad with Assorted Vegetables', '', 'Frozen fruits and vegetables','149', 'g', '1', 'portion', ' 22', '1.11', '4.69', '0.22', ' 22', '1.11', '4.69', '0.22', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fajita with Chicken and Vegetables', '', 'Frozen fruits and vegetables','137', 'g', '1', 'portion', ' 217', '12.11', '25.58', '7.46', ' 217', '12.11', '25.58', '7.46', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef, Noodles and Vegetables (Mixture)', '', 'Frozen fruits and vegetables','920', 'g', '1', 'portion', ' 1169', '111.64', '113.02', '28.62', ' 1169', '111.64', '113.02', '28.62', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Frozen Cherries', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 46', '0.92', '11.02', '0.44', ' 46', '0.92', '11.02', '0.44', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef, Rice and Vegetables Soup (Mixture)', '', 'Frozen fruits and vegetables','1465', 'g', '1', 'portion', ' 1978', '117.81', '174.38', '86.75', ' 1978', '117.81', '174.38', '86.75', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rabbit Stew with Potatoes and Vegetables', '', 'Frozen fruits and vegetables','4372', 'g', '1', 'portion', ' 2755', '303.88', '198.07', '79.14', ' 2755', '303.88', '198.07', '79.14', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken or Turkey Pate with Vegetables (Diet)', '', 'Frozen fruits and vegetables','2590', 'g', '1', 'portion', ' 3885', '738.15', '4.66', '78.22', ' 3885', '738.15', '4.66', '78.22', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Burrito with Eggs, Sausage, Cheese and Vegetables', '', 'Frozen fruits and vegetables','110', 'g', '1', 'portion', ' 270', '10.34', '20.80', '16.05', ' 270', '10.34', '20.80', '16.05', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cooked Vegetables (Fat Added in Cooking)', '', 'Frozen fruits and vegetables','188', 'g', '1', 'portion', ' 152', '5.22', '23.91', '3.98', ' 152', '5.22', '23.91', '3.98', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken and Vegetables in Cream or White Sauce (Diet Frozen Meal)', '', 'Frozen fruits and vegetables','254', 'g', '1', 'portion', ' 244', '26.76', '15.20', '8.03', ' 244', '26.76', '15.20', '8.03', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken and Vegetables Au Gratin with Rice-Vegetable Mixture (Diet Frozen Entree)', '', 'Frozen fruits and vegetables','255', 'g', '1', 'portion', ' 316', '28.94', '19.42', '13.09', ' 316', '28.94', '19.42', '13.09', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef, Rice and Vegetables (Mixture)', '', 'Frozen fruits and vegetables','916', 'g', '1', 'portion', ' 1145', '105.66', '121.51', '22.91', ' 1145', '105.66', '121.51', '22.91', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pizza with Beans and Vegetables', '', 'Frozen fruits and vegetables','866', 'g', '1', 'portion', ' 2027', '80.72', '255.59', '76.05', ' 2027', '80.72', '255.59', '76.05', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Frozen Rhubarb', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 116', '0.39', '31.20', '0.05', ' 116', '0.39', '31.20', '0.05', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Frozen Daiquiri', '', 'Frozen fruits and vegetables','216', 'g', '1', 'portion', ' 183', '0.13', '15.70', '0.15', ' 183', '0.13', '15.70', '0.15', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Frozen Dinner', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 159', '8.72', '11.14', '8.75', ' 159', '8.72', '11.14', '8.75', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Frozen Peach', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 94', '0.63', '23.98', '0.13', ' 94', '0.63', '23.98', '0.13', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Frozen Blackberries', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 64', '1.18', '15.67', '0.43', ' 64', '1.18', '15.67', '0.43', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Frozen Blueberries', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 51', '0.42', '12.17', '0.64', ' 51', '0.42', '12.17', '0.64', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Hawaiian Style Pork and Vegetables (Mixture)', '', 'Frozen fruits and vegetables','1155', 'g', '1', 'portion', ' 1028', '64.79', '90.55', '48.62', ' 1028', '64.79', '90.55', '48.62', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken or Turkey and Vegetables (Mixture)', '', 'Frozen fruits and vegetables','1307', 'g', '1', 'portion', ' 1228', '139.02', '100.61', '31.62', ' 1228', '139.02', '100.61', '31.62', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Julienne Salad (Meat, Cheese, Eggs, Vegetables)', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 96', '9.13', '2.33', '5.52', ' 96', '9.13', '2.33', '5.52', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat, Poultry or Fish, Vegetables Sandwich Wrap', '', 'Frozen fruits and vegetables','265', 'g', '1', 'portion', ' 603', '32.67', '61.60', '24.28', ' 603', '32.67', '61.60', '24.28', '1', 'barcode', '12', '', '' , '',' ', '', ''");
// =========FOODS FRUIT	 ============
    setupInsertToFood(  " NULL, 'Strawberries', '', 'Fruit	','100', 'g', '1', 'portion', ' 32', '0.67', '7.68', '0.30', ' 32', '0.67', '7.68', '0.30', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Blueberries', '', 'Fruit	','100', 'g', '1', 'portion', ' 57', '0.74', '14.49', '0.33', ' 57', '0.74', '14.49', '0.33', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Melon Medley', '', 'Fruit	','1 servin', 'g', '1', 'portion', ' 45', '1.00', '12.00', '0.00', ' 45', '1.00', '12.00', '0.00', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Bananas', '', 'Fruit	','100', 'g', '1', 'portion', ' 89', '1.09', '22.84', '0.33', ' 89', '1.09', '22.84', '0.33', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pineapple', '', 'Fruit	','100', 'g', '1', 'portion', ' 48', '0.54', '12.63', '0.12', ' 48', '0.54', '12.63', '0.12', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Apples', '', 'Fruit	','100', 'g', '1', 'portion', ' 52', '0.26', '13.81', '0.17', ' 52', '0.26', '13.81', '0.17', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cantaloupe Melons', '', 'Fruit	','100', 'g', '1', 'portion', ' 34', '0.84', '8.16', '0.19', ' 34', '0.84', '8.16', '0.19', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Raspberries', '', 'Fruit	','100', 'g', '1', 'portion', ' 52', '1.20', '11.94', '0.65', ' 52', '1.20', '11.94', '0.65', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Grapes (American Type, Slip Skin)', '', 'Fruit	','100', 'g', '1', 'portion', ' 67', '0.63', '17.15', '0.35', ' 67', '0.63', '17.15', '0.35', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oranges', '', 'Fruit	','100', 'g', '1', 'portion', ' 47', '0.94', '11.75', '0.12', ' 47', '0.94', '11.75', '0.12', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Blackberries', '', 'Fruit	','100', 'g', '1', 'portion', ' 43', '1.39', '9.61', '0.49', ' 43', '1.39', '9.61', '0.49', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Watermelon', '', 'Fruit	','100', 'g', '1', 'portion', ' 30', '0.61', '7.55', '0.15', ' 30', '0.61', '7.55', '0.15', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Grapes', '', 'Fruit	','100', 'g', '1', 'portion', ' 69', '0.72', '18.10', '0.16', ' 69', '0.72', '18.10', '0.16', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Tangerines (Mandarin Oranges)', '', 'Fruit	','100', 'g', '1', 'portion', ' 53', '0.81', '13.34', '0.31', ' 53', '0.81', '13.34', '0.31', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pears', '', 'Fruit	','100', 'g', '1', 'portion', ' 58', '0.38', '15.46', '0.12', ' 58', '0.38', '15.46', '0.12', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Plums', '', 'Fruit	','100', 'g', '1', 'portion', ' 46', '0.70', '11.42', '0.28', ' 46', '0.70', '11.42', '0.28', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Honeydew Melons', '', 'Fruit	','100', 'g', '1', 'portion', ' 36', '0.54', '9.09', '0.14', ' 36', '0.54', '9.09', '0.14', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Florida Pink and Red Grapefruit', '', 'Fruit	','100', 'g', '1', 'portion', ' 30', '0.55', '7.50', '0.10', ' 30', '0.55', '7.50', '0.10', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Mangos', '', 'Fruit	','100', 'g', '1', 'portion', ' 65', '0.51', '17.00', '0.27', ' 65', '0.51', '17.00', '0.27', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Navels Oranges', '', 'Fruit	','100', 'g', '1', 'portion', ' 49', '0.91', '12.54', '0.15', ' 49', '0.91', '12.54', '0.15', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pineapple (Traditional Varieties)', '', 'Fruit	','100', 'g', '1', 'portion', ' 45', '0.55', '11.82', '0.13', ' 45', '0.55', '11.82', '0.13', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Tropical Fruit Salad (Pineapple Papaya Banana and Guava, Solids and Liquids, Heavy Syrup, Canned)', '', 'Fruit	','100', 'g', '1', 'portion', ' 86', '0.41', '22.36', '0.10', ' 86', '0.41', '22.36', '0.10', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sapodilla', '', 'Fruit	','100', 'g', '1', 'portion', ' 83', '0.44', '19.96', '1.10', ' 83', '0.44', '19.96', '1.10', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Apricots (Solids and Liquids with Skin, Water Pack, Canned)', '', 'Fruit	','100', 'g', '1', 'portion', ' 27', '0.71', '6.39', '0.16', ' 27', '0.71', '6.39', '0.16', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chinese Gooseberries (Kiwi Fruit)', '', 'Fruit	','100', 'g', '1', 'portion', ' 61', '1.14', '14.66', '0.52', ' 61', '1.14', '14.66', '0.52', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Figs', '', 'Fruit	','100', 'g', '1', 'portion', ' 74', '0.75', '19.18', '0.30', ' 74', '0.75', '19.18', '0.30', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Grape Leaves', '', 'Fruit	','100', 'g', '1', 'portion', ' 93', '5.60', '17.31', '2.12', ' 93', '5.60', '17.31', '2.12', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Japanese Persimmons', '', 'Fruit	','100', 'g', '1', 'portion', ' 70', '0.58', '18.59', '0.19', ' 70', '0.58', '18.59', '0.19', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cooked Nectarine', '', 'Fruit	','1008', 'g', '1', 'portion', ' 927', '7.56', '233.39', '2.32', ' 927', '7.56', '233.39', '2.32', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Quinces', '', 'Fruit	','100', 'g', '1', 'portion', ' 57', '0.40', '15.30', '0.10', ' 57', '0.40', '15.30', '0.10', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Red Raspberries', '', 'Fruit	','100', 'g', '1', 'portion', ' 52', '1.20', '11.94', '0.65', ' 52', '1.20', '11.94', '0.65', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Blackberries (Solids and Liquids, Heavy Syrup, Canned)', '', 'Fruit	','100', 'g', '1', 'portion', ' 92', '1.31', '23.10', '0.14', ' 92', '1.31', '23.10', '0.14', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Jujube', '', 'Fruit	','100', 'g', '1', 'portion', ' 79', '1.20', '20.23', '0.20', ' 79', '1.20', '20.23', '0.20', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Strawberries (Solids and Liquids, Heavy Syrup Pack, Canned)', '', 'Fruit	','100', 'g', '1', 'portion', ' 92', '0.56', '23.53', '0.26', ' 92', '0.56', '23.53', '0.26', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Passion-Fruit (Granadilla, Purple)', '', 'Fruit	','100', 'g', '1', 'portion', ' 97', '2.20', '23.38', '0.70', ' 97', '2.20', '23.38', '0.70', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dried Prunes (Without Added Sugar, Stewed)', '', 'Fruit	','100', 'g', '1', 'portion', ' 107', '0.96', '28.08', '0.16', ' 107', '0.96', '28.08', '0.16', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Kiwi Fruit', '', 'Fruit	','100', 'g', '1', 'portion', ' 61', '1.14', '14.66', '0.52', ' 61', '1.14', '14.66', '0.52', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Gala Apples', '', 'Fruit	','99', 'g', '1', 'portion', ' 51', '0.26', '13.67', '0.17', ' 51', '0.26', '13.67', '0.17', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Waxgourd (Chinese Preserving Melon)', '', 'Fruit	','100', 'g', '1', 'portion', ' 13', '0.40', '3.00', '0.20', ' 13', '0.40', '3.00', '0.20', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Red Delicious Apples', '', 'Fruit	','101', 'g', '1', 'portion', ' 53', '0.26', '13.95', '0.17', ' 53', '0.26', '13.95', '0.17', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Peaches', '', 'Fruit	','100', 'g', '1', 'portion', ' 39', '0.91', '9.54', '0.25', ' 39', '0.91', '9.54', '0.25', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Grapefruit (Pink and Red and White)', '', 'Fruit	','100', 'g', '1', 'portion', ' 32', '0.63', '8.08', '0.10', ' 32', '0.63', '8.08', '0.10', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dried Japanese Persimmons', '', 'Fruit	','100', 'g', '1', 'portion', ' 274', '1.38', '73.43', '0.59', ' 274', '1.38', '73.43', '0.59', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Plums (Solids and Liquids, Water Pack, Canned)', '', 'Fruit	','100', 'g', '1', 'portion', ' 41', '0.39', '11.03', '0.01', ' 41', '0.39', '11.03', '0.01', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Peaches (Solids and Liquids, Water Pack, Canned)', '', 'Fruit	','100', 'g', '1', 'portion', ' 24', '0.44', '6.11', '0.06', ' 24', '0.44', '6.11', '0.06', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Apple Slices', '', 'Fruit	','1 servin', 'g', '1', 'portion', ' 35', '0.00', '9.00', '0.00', ' 35', '0.00', '9.00', '0.00', '1', 'barcode', '13', '', '' , '',' ', '', ''");
// =========FOODS VEGETABLES ============
    setupInsertToFood(  " NULL, 'Cooked Vegetables (from Fresh, Fat Not Added in Cooking)', '', 'Vegetables','169', 'g', '1', 'portion', ' 84', '5.85', '18.79', '0.27', ' 84', '5.85', '18.79', '0.27', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cooked Vegetable Combination with Soy-Based Sauce', '', 'Vegetables','441', 'g', '1', 'portion', ' 273', '13.48', '58.11', '1.50', ' 273', '13.48', '58.11', '1.50', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Mixed Vegetables (Frozen)', '', 'Vegetables','100', 'g', '1', 'portion', ' 64', '3.33', '13.46', '0.52', ' 64', '3.33', '13.46', '0.52', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cooked Mixed Vegetables (Corn, Lima Beans, Peas, Green Beans and Carrots, Canned)', '', 'Vegetables','169', 'g', '1', 'portion', ' 113', '4.23', '15.18', '4.13', ' 113', '4.23', '15.18', '4.13', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Carrots', '', 'Vegetables','100', 'g', '1', 'portion', ' 41', '0.93', '9.58', '0.24', ' 41', '0.93', '9.58', '0.24', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Green Peppers', '', 'Vegetables','100', 'g', '1', 'portion', ' 20', '0.86', '4.64', '0.17', ' 20', '0.86', '4.64', '0.17', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Zucchini', '', 'Vegetables','100', 'g', '1', 'portion', ' 16', '1.21', '3.35', '0.18', ' 16', '1.21', '3.35', '0.18', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Broccoli', '', 'Vegetables','100', 'g', '1', 'portion', ' 34', '2.82', '6.64', '0.37', ' 34', '2.82', '6.64', '0.37', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Onions', '', 'Vegetables','100', 'g', '1', 'portion', ' 42', '0.92', '10.11', '0.08', ' 42', '0.92', '10.11', '0.08', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Tomatoes', '', 'Vegetables','100', 'g', '1', 'portion', ' 18', '0.88', '3.92', '0.20', ' 18', '0.88', '3.92', '0.20', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cooked Vegetable Combinations with Cheese Sauce (Including Carrots, Broccoli, and/or Dark-Green Leafy)', '', 'Vegetables','412', 'g', '1', 'portion', ' 296', '15.27', '41.58', '10.13', ' 296', '15.27', '41.58', '10.13', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cooked Carrots (from Fresh, Fat Added in Cooking)', '', 'Vegetables','161', 'g', '1', 'portion', ' 87', '1.19', '12.85', '3.99', ' 87', '1.19', '12.85', '3.99', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Mushrooms', '', 'Vegetables','100', 'g', '1', 'portion', ' 22', '3.09', '3.28', '0.34', ' 22', '3.09', '3.28', '0.34', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Lettuce', '', 'Vegetables','100', 'g', '1', 'portion', ' 14', '0.90', '2.97', '0.14', ' 14', '0.90', '2.97', '0.14', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cucumber (Peeled)', '', 'Vegetables','100', 'g', '1', 'portion', ' 12', '0.59', '2.16', '0.16', ' 12', '0.59', '2.16', '0.16', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chinese Cabbage (Bok-Choy, Pak-Choi)', '', 'Vegetables','100', 'g', '1', 'portion', ' 13', '1.50', '2.18', '0.20', ' 13', '1.50', '2.18', '0.20', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baby Zucchini', '', 'Vegetables','100', 'g', '1', 'portion', ' 21', '2.71', '3.11', '0.40', ' 21', '2.71', '3.11', '0.40', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Mixed Vegetables (Drained Solids, Canned)', '', 'Vegetables','100', 'g', '1', 'portion', ' 49', '2.59', '9.26', '0.25', ' 49', '2.59', '9.26', '0.25', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Summer Squash', '', 'Vegetables','100', 'g', '1', 'portion', ' 16', '1.21', '3.35', '0.18', ' 16', '1.21', '3.35', '0.18', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Grape Tomatoes', '', 'Vegetables','100', 'g', '1', 'portion', ' 18', '0.88', '3.92', '0.20', ' 18', '0.88', '3.92', '0.20', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Winter Squash', '', 'Vegetables','100', 'g', '1', 'portion', ' 34', '0.95', '8.59', '0.13', ' 34', '0.95', '8.59', '0.13', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Radicchio', '', 'Vegetables','100', 'g', '1', 'portion', ' 23', '1.43', '4.48', '0.25', ' 23', '1.43', '4.48', '0.25', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Potato (Flesh and Skin)', '', 'Vegetables','100', 'g', '1', 'portion', ' 77', '2.02', '17.47', '0.09', ' 77', '2.02', '17.47', '0.09', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Mixed Vegetables (Corn, Lima Beans, Peas, Green Beans, Carrots) (No Salt Added, Canned)', '', 'Vegetables','100', 'g', '1', 'portion', ' 37', '1.40', '7.31', '0.20', ' 37', '1.40', '7.31', '0.20', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sweet Red Peppers', '', 'Vegetables','100', 'g', '1', 'portion', ' 26', '0.99', '6.03', '0.30', ' 26', '0.99', '6.03', '0.30', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Arugula (Rocket)', '', 'Vegetables','100', 'g', '1', 'portion', ' 25', '2.58', '3.65', '0.66', ' 25', '2.58', '3.65', '0.66', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sweet Potato', '', 'Vegetables','100', 'g', '1', 'portion', ' 86', '1.57', '20.12', '0.05', ' 86', '1.57', '20.12', '0.05', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Green Peas (Frozen)', '', 'Vegetables','100', 'g', '1', 'portion', ' 77', '5.21', '13.71', '0.37', ' 77', '5.21', '13.71', '0.37', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Celery', '', 'Vegetables','100', 'g', '1', 'portion', ' 14', '0.69', '2.97', '0.17', ' 14', '0.69', '2.97', '0.17', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Orange Tomatoes', '', 'Vegetables','100', 'g', '1', 'portion', ' 16', '1.16', '3.18', '0.19', ' 16', '1.16', '3.18', '0.19', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Broccoli Raab', '', 'Vegetables','100', 'g', '1', 'portion', ' 22', '3.17', '2.85', '0.49', ' 22', '3.17', '2.85', '0.49', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Arrowhead', '', 'Vegetables','100', 'g', '1', 'portion', ' 99', '5.33', '20.23', '0.29', ' 99', '5.33', '20.23', '0.29', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Green Leaf Lettuce', '', 'Vegetables','100', 'g', '1', 'portion', ' 15', '1.36', '2.79', '0.15', ' 15', '1.36', '2.79', '0.15', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Okra', '', 'Vegetables','100', 'g', '1', 'portion', ' 31', '2.00', '7.03', '0.10', ' 31', '2.00', '7.03', '0.10', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Bean Sprouts', '', 'Vegetables','100', 'g', '1', 'portion', ' 30', '3.04', '5.94', '0.18', ' 30', '3.04', '5.94', '0.18', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cooked Vegetable Combinations with Butter Sauce and Pasta', '', 'Vegetables','577', 'g', '1', 'portion', ' 675', '21.92', '104.30', '21.86', ' 675', '21.92', '104.30', '21.86', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Red Hot Chili Peppers', '', 'Vegetables','100', 'g', '1', 'portion', ' 40', '1.87', '8.81', '0.44', ' 40', '1.87', '8.81', '0.44', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dried Vegetable Mixture', '', 'Vegetables','551', 'g', '1', 'portion', ' 2043', '110.56', '310.04', '58.86', ' 2043', '110.56', '310.04', '58.86', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cooked Carrots', '', 'Vegetables','1 servin', 'g', '1', 'portion', ' 80', '1.00', '16.00', '1.00', ' 80', '1.00', '16.00', '1.00', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cooked Brussels Sprouts (from Frozen, Fat Added in Cooking)', '', 'Vegetables','161', 'g', '1', 'portion', ' 98', '5.66', '12.98', '4.31', ' 98', '5.66', '12.98', '4.31', '1', 'barcode', '14', '', '' , '',' ', '', ''");
// =========FOODS CANNED FRUIT AND VEGETABLES ============
    setupInsertToFood(  " NULL, 'Fruit Cocktail (Cooked or Canned)', '', 'Canned fruit and vegetables','175', 'g', '1', 'portion', ' 124', '0.74', '32.11', '0.16', ' 124', '0.74', '32.11', '0.16', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Cocktail Drained Solids (Cooked or Canned)', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 70', '0.47', '18.80', '0.10', ' 70', '0.47', '18.80', '0.10', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baby Food Strained Garden Vegetables Mixed Vegetables', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 34', '1.75', '7.42', '0.35', ' 34', '1.75', '7.42', '0.35', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Smoothie (made with Fruit or Fruit Juice only)', '', 'Canned fruit and vegetables','600', 'g', '1', 'portion', ' 372', '2.52', '95.77', '0.84', ' 372', '2.52', '95.77', '0.84', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Blintz', '', 'Canned fruit and vegetables','1746', 'g', '1', 'portion', ' 3073', '100.57', '431.43', '108.43', ' 3073', '100.57', '431.43', '108.43', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Waffle', '', 'Canned fruit and vegetables','93', 'g', '1', 'portion', ' 259', '5.96', '41.72', '7.67', ' 259', '5.96', '41.72', '7.67', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dried Fruit', '', 'Canned fruit and vegetables','500', 'g', '1', 'portion', ' 1260', '13.20', '332.90', '2.45', ' 1260', '13.20', '332.90', '2.45', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Dessert', '', 'Canned fruit and vegetables','1100', 'g', '1', 'portion', ' 1694', '31.78', '264.94', '68.85', ' 1694', '31.78', '264.94', '68.85', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Soup', '', 'Canned fruit and vegetables','874', 'g', '1', 'portion', ' 638', '4.72', '165.42', '0.70', ' 638', '4.72', '165.42', '0.70', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Juice', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 46', '0.41', '11.12', '0.11', ' 46', '0.41', '11.12', '0.11', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Whirls', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 393', '5.04', '87.48', '3.10', ' 393', '5.04', '87.48', '3.10', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Nectar', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 56', '0.37', '14.39', '0.09', ' 56', '0.37', '14.39', '0.09', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Sauce', '', 'Canned fruit and vegetables','396', 'g', '1', 'portion', ' 827', '1.15', '155.26', '24.94', ' 827', '1.15', '155.26', '24.94', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Leather', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 371', '0.10', '85.80', '3.00', ' 371', '0.10', '85.80', '3.00', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Cocktail Unsweetened in Water Pack (Cooked or Canned)', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 32', '0.42', '8.51', '0.05', ' 32', '0.42', '8.51', '0.05', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Cocktail in Heavy Syrup (Cooked or Canned)', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 73', '0.39', '18.91', '0.07', ' 73', '0.39', '18.91', '0.07', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetables in Pastry', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 308', '6.60', '20.93', '22.98', ' 308', '6.60', '20.93', '22.98', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Cocktail in Light Syrup (Cooked or Canned)', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 57', '0.40', '14.93', '0.07', ' 57', '0.40', '14.93', '0.07', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Stir Fried Vegetables', '', 'Canned fruit and vegetables','1649', 'g', '1', 'portion', ' 1242', '75.12', '89.35', '70.29', ' 1242', '75.12', '89.35', '70.29', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cooked Vegetables (from Canned, Fat Not Added in Cooking)', '', 'Canned fruit and vegetables','242', 'g', '1', 'portion', ' 46', '5.18', '5.95', '1.57', ' 46', '5.18', '5.95', '1.57', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baby Food Garden Vegetables Mixed Vegetables', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 35', '1.63', '7.68', '0.37', ' 35', '1.63', '7.68', '0.37', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Syrup', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 268', '0.03', '71.82', '0.12', ' 268', '0.03', '71.82', '0.12', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Ice', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 128', '0.40', '32.60', '0.00', ' 128', '0.40', '32.60', '0.00', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Diet Gelatin Dessert with Fruit and Vegetables (Sweetened with Low Calorie Sweetener)', '', 'Canned fruit and vegetables','842', 'g', '1', 'portion', ' 396', '8.00', '58.97', '20.05', ' 396', '8.00', '58.97', '20.05', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef, Potatoes and Vegetables (Mixture)', '', 'Canned fruit and vegetables','841', 'g', '1', 'portion', ' 942', '101.21', '80.68', '22.29', ' 942', '101.21', '80.68', '22.29', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pork, Potatoes and Vegetables (Mixture)', '', 'Canned fruit and vegetables','347', 'g', '1', 'portion', ' 406', '28.28', '41.24', '14.17', ' 406', '28.28', '41.24', '14.17', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef Shish Kabob with Vegetables', '', 'Canned fruit and vegetables','285', 'g', '1', 'portion', ' 248', '33.11', '11.79', '7.28', ' 248', '33.11', '11.79', '7.28', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetables and Cheese in Pastry', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 317', '8.07', '19.40', '23.84', ' 317', '8.07', '19.40', '23.84', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Lasagna with Vegetables', '', 'Canned fruit and vegetables','3487', 'g', '1', 'portion', ' 4498', '239.91', '599.77', '133.21', ' 4498', '239.91', '599.77', '133.21', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Creamed Macaroni with Vegetables', '', 'Canned fruit and vegetables','746', 'g', '1', 'portion', ' 918', '30.59', '124.30', '33.57', ' 918', '30.59', '124.30', '33.57', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cottage Cheese (with Vegetables)', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 95', '10.90', '3.00', '4.20', ' 95', '10.90', '3.00', '4.20', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pita with Fruit Bread', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 278', '8.56', '58.00', '1.16', ' 278', '8.56', '58.00', '1.16', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Scone with Fruit', '', 'Canned fruit and vegetables','522', 'g', '1', 'portion', ' 1838', '44.43', '261.75', '69.64', ' 1838', '44.43', '261.75', '69.64', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Bread without Nuts', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 323', '4.29', '54.56', '10.31', ' 323', '4.29', '54.56', '10.31', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Diet Cheesecake with Fruit', '', 'Canned fruit and vegetables','145', 'g', '1', 'portion', ' 310', '7.47', '43.37', '12.28', ' 310', '7.47', '43.37', '12.28', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Filled Crepe', '', 'Canned fruit and vegetables','1276', 'g', '1', 'portion', ' 2348', '58.57', '339.03', '88.94', ' 2348', '58.57', '339.03', '88.94', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Lowfat Fruit Variety Yogurt', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 102', '4.37', '19.05', '1.08', ' 102', '4.37', '19.05', '1.08', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dried Fruit Mixture', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 244', '2.19', '64.81', '0.44', ' 244', '2.19', '64.81', '0.44', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Cocktail or Mix', '', 'Canned fruit and vegetables','375', 'g', '1', 'portion', ' 199', '2.18', '51.94', '0.64', ' 199', '2.18', '51.94', '0.64', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Passion Fruit Nectar', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 67', '0.16', '17.44', '0.02', ' 67', '0.16', '17.44', '0.02', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baby Food Fruit', '', 'Canned fruit and vegetables','250', 'g', '1', 'portion', ' 140', '0.60', '37.75', '0.30', ' 140', '0.60', '37.75', '0.30', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soft Fruit Confections', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 390', '2.31', '73.81', '9.52', ' 390', '2.31', '73.81', '9.52', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Punch (Alcoholic)', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 64', '0.12', '6.77', '0.03', ' 64', '0.12', '6.77', '0.03', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Multigrain Muffin with Fruit', '', 'Canned fruit and vegetables','379', 'g', '1', 'portion', ' 980', '34.07', '177.54', '21.92', ' 980', '34.07', '177.54', '21.92', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cheesecake with Fruit', '', 'Canned fruit and vegetables','1768', 'g', '1', 'portion', ' 4827', '110.50', '581.66', '237.79', ' 4827', '110.50', '581.66', '237.79', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Gelatin Dessert with Fruit', '', 'Canned fruit and vegetables','869', 'g', '1', 'portion', ' 565', '9.39', '140.18', '0.78', ' 565', '9.39', '140.18', '0.78', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Shortcake Biscuit with Fruit', '', 'Canned fruit and vegetables','65', 'g', '1', 'portion', ' 146', '2.42', '23.10', '5.33', ' 146', '2.42', '23.10', '5.33', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sweet Tamale with Fruit', '', 'Canned fruit and vegetables','2399', 'g', '1', 'portion', ' 4822', '46.30', '746.52', '204.38', ' 4822', '46.30', '746.52', '204.38', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pancakes with Fruit', '', 'Canned fruit and vegetables','491', 'g', '1', 'portion', ' 933', '32.57', '130.98', '31.00', ' 933', '32.57', '130.98', '31.00', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Passion Fruit Juice', '', 'Canned fruit and vegetables','200', 'g', '1', 'portion', ' 102', '0.78', '27.20', '0.10', ' 102', '0.78', '27.20', '0.10', '1', 'barcode', '15', '', '' , '',' ', '', ''");
// =========FOODS MEAL SUBSTITUTES ============
    setupInsertToFood(  " NULL, 'Meat Substitute Type Sandwich Spread', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 149', '8.00', '9.00', '9.00', ' 149', '8.00', '9.00', '9.00', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fried Cereal and Vegetable Protein Meat Substitute', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 333', '11.58', '62.48', '6.51', ' 333', '11.58', '62.48', '6.51', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soybean Meal', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 436', '34.54', '35.19', '20.65', ' 436', '34.54', '35.19', '20.65', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Divan (Frozen Meal)', '', 'Meal substitutes','236', 'g', '1', 'portion', ' 359', '21.26', '15.77', '21.67', ' 359', '21.26', '15.77', '21.67', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fish Dinner (Frozen Meal)', '', 'Meal substitutes','93', 'g', '1', 'portion', ' 182', '11.82', '12.80', '9.35', ' 182', '11.82', '12.80', '9.35', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef Dinner (Frozen Meal)', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 148', '6.92', '11.66', '8.37', ' 148', '6.92', '11.66', '8.37', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Atole (Corn Meal Beverage)', '', 'Meal substitutes','1700', 'g', '1', 'portion', ' 1428', '28.90', '276.59', '26.01', ' 1428', '28.90', '276.59', '26.01', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Turkey Dinner (Frozen Meal)', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 155', '9.64', '13.17', '7.00', ' 155', '9.64', '13.17', '7.00', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Turkey Tetrazzini (Frozen Meal)', '', 'Meal substitutes','164', 'g', '1', 'portion', ' 230', '12.66', '20.61', '9.74', ' 230', '12.66', '20.61', '9.74', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Sunflower Meal Bread', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 300', '10.76', '49.89', '6.33', ' 300', '10.76', '49.89', '6.33', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Veal Lasagna (Diet Frozen Meal)', '', 'Meal substitutes','313', 'g', '1', 'portion', ' 282', '22.16', '32.11', '7.29', ' 282', '22.16', '32.11', '7.29', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'High Protein Meal Replacement Powder', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 288', '32.00', '54.50', '0.00', ' 288', '32.00', '54.50', '0.00', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Fajitas (Diet Frozen Meal)', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 122', '8.88', '15.88', '2.61', ' 122', '8.88', '15.88', '2.61', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Enchilada (Diet Frozen Meal)', '', 'Meal substitutes','240', 'g', '1', 'portion', ' 352', '26.43', '27.86', '15.25', ' 352', '26.43', '27.86', '15.25', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Burritos (Diet Frozen Meal)', '', 'Meal substitutes','142', 'g', '1', 'portion', ' 252', '13.34', '34.75', '6.37', ' 252', '13.34', '34.75', '6.37', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pancakes and Sausage (Frozen Meal)', '', 'Meal substitutes','168', 'g', '1', 'portion', ' 458', '15.18', '45.80', '23.48', ' 458', '15.18', '45.80', '23.48', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chopped Sirloin Dinner (Frozen Meal)', '', 'Meal substitutes','319', 'g', '1', 'portion', ' 500', '24.44', '42.93', '26.13', ' 500', '24.44', '42.93', '26.13', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef Enchilada Dinner (Frozen Meal)', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 124', '5.08', '16.64', '4.12', ' 124', '5.08', '16.64', '4.12', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Veal Parmigiana with Vegetable (Diet Frozen Meal)', '', 'Meal substitutes','266', 'g', '1', 'portion', ' 199', '21.01', '8.99', '8.91', ' 199', '21.01', '8.99', '8.91', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef with Potatoes (Frozen Meal, Large Meat)', '', 'Meal substitutes','303', 'g', '1', 'portion', ' 536', '34.58', '38.73', '28.59', ' 536', '34.58', '38.73', '28.59', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meal Replacement or Supplement with Soy', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 99', '3.49', '14.01', '3.25', ' 99', '3.49', '14.01', '3.25', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Spaghetti and Meatballs Dinner (Frozen Meal)', '', 'Meal substitutes','367', 'g', '1', 'portion', ' 410', '20.34', '54.35', '12.17', ' 410', '20.34', '54.35', '12.17', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Spaghetti with Meat Sauce (Diet Frozen Meal)', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 90', '5.05', '15.24', '1.01', ' 90', '5.05', '15.24', '1.01', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sole with Vegetable (Diet Frozen Meal)', '', 'Meal substitutes','215', 'g', '1', 'portion', ' 196', '30.02', '12.31', '2.54', ' 196', '30.02', '12.31', '2.54', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Cacciatore with Noodles (Diet Frozen Meal)', '', 'Meal substitutes','306', 'g', '1', 'portion', ' 315', '22.94', '33.40', '9.76', ' 315', '22.94', '33.40', '9.76', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Flounder with Chopped Broccoli (Diet Frozen Meal)', '', 'Meal substitutes','326', 'g', '1', 'portion', ' 225', '28.77', '17.42', '4.53', ' 225', '28.77', '17.42', '4.53', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Scallops with Potatoes and Vegetable (Frozen Meal)', '', 'Meal substitutes','243', 'g', '1', 'portion', ' 393', '26.83', '39.09', '16.49', ' 393', '26.83', '39.09', '16.49', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Shrimp with Potatoes and Vegetable (Frozen Meal)', '', 'Meal substitutes','242', 'g', '1', 'portion', ' 414', '28.49', '38.87', '18.34', ' 414', '28.49', '38.87', '18.34', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Stuffed Green Pepper (Diet Frozen Meal)', '', 'Meal substitutes','333', 'g', '1', 'portion', ' 290', '23.21', '30.47', '8.59', ' 290', '23.21', '30.47', '8.59', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Drink Meal Supplement or Replacement', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 70', '3.50', '10.90', '1.40', ' 70', '3.50', '10.90', '1.40', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetarian Stroganoff (with Meat Substitute)', '', 'Meal substitutes','1259', 'g', '1', 'portion', ' 2165', '108.74', '141.34', '132.15', ' 2165', '108.74', '141.34', '132.15', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Veal with Peppers in Sauce and Rice (Diet Frozen Meal)', '', 'Meal substitutes','368', 'g', '1', 'portion', ' 298', '26.44', '32.51', '7.36', ' 298', '26.44', '32.51', '7.36', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Macaroni with Veal, Cheese and Sauce (Diet Frozen Meal)', '', 'Meal substitutes','370', 'g', '1', 'portion', ' 385', '28.30', '44.97', '10.19', ' 385', '28.30', '44.97', '10.19', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Breaded Veal  with Spaghetti in Tomato Sauce (Frozen Meal)', '', 'Meal substitutes','223', 'g', '1', 'portion', ' 288', '14.20', '26.58', '13.97', ' 288', '14.20', '26.58', '13.97', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Swedish Meatballs in Sauce with Noodles (Frozen Meal)', '', 'Meal substitutes','281', 'g', '1', 'portion', ' 543', '31.43', '35.98', '29.18', ' 543', '31.43', '35.98', '29.18', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fried Chicken with Potatoes and Vegetable (Frozen Meal)', '', 'Meal substitutes','265', 'g', '1', 'portion', ' 448', '27.86', '28.12', '24.18', ' 448', '27.86', '28.12', '24.18', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken and Vegetable Entree with Noodles (Frozen Meal)', '', 'Meal substitutes','283', 'g', '1', 'portion', ' 286', '20.03', '37.74', '5.89', ' 286', '20.03', '37.74', '5.89', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken in Cream Sauce with Noodles and Vegetable (Frozen Meal)', '', 'Meal substitutes','334', 'g', '1', 'portion', ' 437', '30.33', '43.85', '14.72', ' 437', '30.33', '43.85', '14.72', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Scrambled Eggs, Bacon and Home Fried Potatoes (Frozen Meal)', '', 'Meal substitutes','98', 'g', '1', 'portion', ' 228', '11.49', '10.78', '15.49', ' 228', '11.49', '10.78', '15.49', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chopped Sirloin with Gravy, Mashed Potatoes and Vegetable (Frozen Meal)', '', 'Meal substitutes','314', 'g', '1', 'portion', ' 500', '24.45', '42.89', '26.14', ' 500', '24.45', '42.89', '26.14', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Salisbury Steak, Potatoes, Vegetable and Dessert (Diet Frozen Meal)', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 93', '4.79', '12.68', '2.80', ' 93', '4.79', '12.68', '2.80', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sliced Beef with Gravy, Potatoes and Vegetable (Frozen Meal)', '', 'Meal substitutes','318', 'g', '1', 'portion', ' 426', '25.54', '23.51', '23.57', ' 426', '25.54', '23.51', '23.57', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Breaded Chicken Patty or Nuggets, Potatoes and Vegetable (Frozen Meal)', '', 'Meal substitutes','191', 'g', '1', 'portion', ' 380', '20.40', '36.16', '19.73', ' 380', '20.40', '36.16', '19.73', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Breaded Chicken Parmigiana Patty with Vegetable (Diet Frozen Meal)', '', 'Meal substitutes','218', 'g', '1', 'portion', ' 296', '21.50', '14.34', '17.06', ' 296', '21.50', '14.34', '17.06', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Teriyaki Chicken with Rice and Vegetable (Diet Frozen Meal)', '', 'Meal substitutes','296', 'g', '1', 'portion', ' 308', '20.80', '46.14', '3.53', ' 308', '20.80', '46.14', '3.53', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken A La King with Rice (Frozen Meal)', '', 'Meal substitutes','399', 'g', '1', 'portion', ' 666', '29.05', '59.81', '33.84', ' 666', '29.05', '59.81', '33.84', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Kiev with Rice-Vegetable Mixture (Frozen Meal)', '', 'Meal substitutes','227', 'g', '1', 'portion', ' 504', '25.79', '30.82', '30.39', ' 504', '25.79', '30.82', '30.39', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oriental Chicken and Vegetable Entree with Rice (Frozen Meal)', '', 'Meal substitutes','272', 'g', '1', 'portion', ' 304', '18.73', '39.40', '8.01', ' 304', '18.73', '39.40', '8.01', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oriental Chicken and Vegetable Entree with Rice (Diet Frozen Meal)', '', 'Meal substitutes','255', 'g', '1', 'portion', ' 482', '32.28', '58.57', '14.33', ' 482', '32.28', '58.57', '14.33', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oriental Chicken and Vegetable Entree (Diet Frozen Meal)', '', 'Meal substitutes','255', 'g', '1', 'portion', ' 204', '17.42', '25.48', '4.08', ' 204', '17.42', '25.48', '4.08', '1', 'barcode', '17', '', '' , '',' ', '', ''");
// =========FOODS PROTEIN BARS ============
// =========FOODS PROTEIN POWDER ============
    setupInsertToFood(  " NULL, 'Protein Powder', '', 'Protein powder','100', 'g', '1', 'portion', ' 401', '31.00', '49.00', '9.00', ' 401', '31.00', '49.00', '9.00', '1', 'barcode', '19', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Protein Supplement Powder', '', 'Protein powder','100', 'g', '1', 'portion', ' 366', '29.40', '58.80', '1.50', ' 366', '29.40', '58.80', '1.50', '1', 'barcode', '19', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Hardcore Strength Whey Protein Chocolate', '', 'Protein powder','1 heapin', 'g', '1', 'portion', ' 130', '25.00', '3.50', '2.00', ' 130', '25.00', '3.50', '2.00', '1', 'barcode', '19', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Protein Meal Replacement Powder', '', 'Protein powder','100', 'g', '1', 'portion', ' 324', '17.60', '63.50', '0.40', ' 324', '17.60', '63.50', '0.40', '1', 'barcode', '19', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soy Protein Meal Replacement Powder', '', 'Protein powder','100', 'g', '1', 'portion', ' 337', '33.70', '47.20', '2.20', ' 337', '33.70', '47.20', '2.20', '1', 'barcode', '19', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soy Protein Isolate (Crude Protein Basis, Potassium Type)', '', 'Protein powder','100', 'g', '1', 'portion', ' 321', '88.32', '2.59', '0.53', ' 321', '88.32', '2.59', '0.53', '1', 'barcode', '19', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soy Protein Isolate', '', 'Protein powder','100', 'g', '1', 'portion', ' 338', '80.69', '7.36', '3.39', ' 338', '80.69', '7.36', '3.39', '1', 'barcode', '19', '', '' , '',' ', '', ''");
// =========FOODS MEAT ============
    setupInsertToFood(  " NULL, 'Meat', '', 'Meat','101', 'g', '1', 'portion', ' 289', '26.63', '0.00', '19.45', ' 289', '26.63', '0.00', '19.45', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat Loaf Made with Beef in Tomato-Based Sauce', '', 'Meat','1244', 'g', '1', 'portion', ' 2177', '165.79', '85.69', '126.36', ' 2177', '165.79', '85.69', '126.36', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat Loaf with Beef, Veal and Pork', '', 'Meat','1017', 'g', '1', 'portion', ' 1515', '180.91', '66.30', '53.08', ' 1515', '180.91', '66.30', '53.08', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatballs with Sauce (Mixture)', '', 'Meat','514', 'g', '1', 'portion', ' 971', '92.73', '1.34', '63.12', ' 971', '92.73', '1.34', '63.12', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco Meat', '', 'Meat','514', 'g', '1', 'portion', ' 895', '100.64', '2.80', '50.57', ' 895', '100.64', '2.80', '50.57', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat Loaf with Potatoes and Vegetable (Frozen Meal)', '', 'Meat','293', 'g', '1', 'portion', ' 384', '19.38', '28.26', '21.67', ' 384', '19.38', '28.26', '21.67', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Homestyle Beef Meatloaf', '', 'Meat','1 servin', 'g', '1', 'portion', ' 320', '30.00', '9.00', '18.00', ' 320', '30.00', '9.00', '18.00', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Chicken', '', 'Meat','100', 'g', '1', 'portion', ' 224', '23.64', '3.64', '12.73', ' 224', '23.64', '3.64', '12.73', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Vegetable and Cheese Filled Manicotti with Tomato Sauce', '', 'Meat','1716', 'g', '1', 'portion', ' 2419', '129.55', '260.13', '95.58', ' 2419', '129.55', '260.13', '95.58', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baby Food Meat', '', 'Meat','900', 'g', '1', 'portion', ' 1017', '125.82', '1.71', '52.20', ' 1017', '125.82', '1.71', '52.20', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Stuffed Tomato with Rice', '', 'Meat','270', 'g', '1', 'portion', ' 197', '4.37', '35.42', '4.81', ' 197', '4.37', '35.42', '4.81', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Fish Stick', '', 'Meat','100', 'g', '1', 'portion', ' 290', '23.00', '9.00', '18.00', ' 290', '23.00', '9.00', '18.00', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Spaghetti Sauce', '', 'Meat','100', 'g', '1', 'portion', ' 74', '1.95', '11.27', '2.38', ' 74', '1.95', '11.27', '2.38', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Lasagna with Meat (Canned)', '', 'Meat','109', 'g', '1', 'portion', ' 111', '5.38', '14.86', '3.35', ' 111', '5.38', '14.86', '3.35', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Thick Crust Pizza with Meat', '', 'Meat','1184', 'g', '1', 'portion', ' 3646', '134.93', '424.33', '152.93', ' 3646', '134.93', '424.33', '152.93', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Nachos with Cheese', '', 'Meat','99', 'g', '1', 'portion', ' 310', '7.81', '32.03', '17.39', ' 310', '7.81', '32.03', '17.39', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Thin Crust Pizza with Meat', '', 'Meat','850', 'g', '1', 'portion', ' 2490', '108.70', '229.89', '124.76', ' 2490', '108.70', '229.89', '124.76', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Burrito with Beans and Rice', '', 'Meat','86', 'g', '1', 'portion', ' 188', '5.65', '30.72', '4.60', ' 188', '5.65', '30.72', '4.60', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Thick Crust Pizza with Meat and Vegetables', '', 'Meat','1407', 'g', '1', 'portion', ' 3770', '138.55', '444.07', '158.11', ' 3770', '138.55', '444.07', '158.11', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Stewed Light or Dark Turkey Meat (Skin Eaten)', '', 'Meat','100', 'g', '1', 'portion', ' 172', '27.01', '0.00', '6.24', ' 172', '27.01', '0.00', '6.24', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Quesadilla with Cheese', '', 'Meat','142', 'g', '1', 'portion', ' 489', '19.98', '37.13', '28.72', ' 489', '19.98', '37.13', '28.72', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Italian Pie', '', 'Meat','1379', 'g', '1', 'portion', ' 3752', '149.54', '498.13', '127.46', ' 3752', '149.54', '498.13', '127.46', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat Loaf with Beef and Pork in Tomato-Based Sauce', '', 'Meat','1244', 'g', '1', 'portion', ' 1940', '173.75', '85.69', '97.26', ' 1940', '173.75', '85.69', '97.26', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Spinach Quiche', '', 'Meat','1296', 'g', '1', 'portion', ' 3096', '99.76', '151.46', '236.06', ' 3096', '99.76', '151.46', '236.06', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chocolate Shake (16 oz)', '', 'Meat','1 servin', 'g', '1', 'portion', ' 580', '12.00', '94.00', '14.00', ' 580', '12.00', '94.00', '14.00', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fresh Cut Cajun Fries (Regular)', '', 'Meat','1 servin', 'g', '1', 'portion', ' 780', '2.00', '25.00', '45.00', ' 780', '2.00', '25.00', '45.00', '1', 'barcode', '21', '', '' , '',' ', '', ''");
// =========FOODS CHICKEN ============
    setupInsertToFood(  " NULL, 'Chicken Breast', '', 'Chicken','101', 'g', '1', 'portion', ' 197', '29.80', '0.00', '7.79', ' 197', '29.80', '0.00', '7.79', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Skinless Chicken Breast', '', 'Chicken','100', 'g', '1', 'portion', ' 110', '23.09', '0.00', '1.24', ' 110', '23.09', '0.00', '1.24', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Thigh', '', 'Chicken','101', 'g', '1', 'portion', ' 247', '25.06', '0.00', '15.49', ' 247', '25.06', '0.00', '15.49', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Grilled Chicken', '', 'Chicken','101', 'g', '1', 'portion', ' 239', '27.30', '0.00', '13.60', ' 239', '27.30', '0.00', '13.60', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Drumstick', '', 'Chicken','101', 'g', '1', 'portion', ' 216', '27.03', '0.00', '11.15', ' 216', '27.03', '0.00', '11.15', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rotisserie Chicken', '', 'Chicken','101', 'g', '1', 'portion', ' 239', '27.30', '0.00', '13.60', ' 239', '27.30', '0.00', '13.60', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Meat (Stewing, Stewed, Cooked)', '', 'Chicken','100', 'g', '1', 'portion', ' 237', '30.42', '0.00', '11.89', ' 237', '30.42', '0.00', '11.89', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Roasted Broiled or Baked Chicken (Skin Not Eaten)', '', 'Chicken','101', 'g', '1', 'portion', ' 190', '28.93', '0.00', '7.41', ' 190', '28.93', '0.00', '7.41', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Thigh (Skin Not Eaten)', '', 'Chicken','101', 'g', '1', 'portion', ' 209', '25.94', '0.00', '10.88', ' 209', '25.94', '0.00', '10.88', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Wing', '', 'Chicken','101', 'g', '1', 'portion', ' 290', '26.86', '0.00', '19.46', ' 290', '26.86', '0.00', '19.46', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken', '', 'Chicken','101', 'g', '1', 'portion', ' 239', '27.30', '0.00', '13.60', ' 239', '27.30', '0.00', '13.60', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Thigh (Skin Eaten)', '', 'Chicken','101', 'g', '1', 'portion', ' 247', '25.06', '0.00', '15.49', ' 247', '25.06', '0.00', '15.49', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Boneless Skinless Chicken Breast', '', 'Chicken','1 servin', 'g', '1', 'portion', ' 110', '23.00', '0.00', '2.50', ' 110', '23.00', '0.00', '2.50', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Leg (Skin Eaten)', '', 'Chicken','101', 'g', '1', 'portion', ' 232', '25.96', '0.00', '13.46', ' 232', '25.96', '0.00', '13.46', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baked or Fried Coated Chicken with Skin (Skin/Coating Eaten)', '', 'Chicken','96', 'g', '1', 'portion', ' 279', '21.45', '9.59', '16.60', ' 279', '21.45', '9.59', '16.60', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baked or Fried Coated Chicken Breast Skinless (Coating Eaten)', '', 'Chicken','103', 'g', '1', 'portion', ' 241', '25.73', '9.97', '10.17', ' 241', '25.73', '9.97', '10.17', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Leg (Skin Not Eaten)', '', 'Chicken','101', 'g', '1', 'portion', ' 191', '27.03', '0.00', '8.43', ' 191', '27.03', '0.00', '8.43', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Breast (Skin Not Eaten)', '', 'Chicken','101', 'g', '1', 'portion', ' 165', '31.02', '0.00', '3.57', ' 165', '31.02', '0.00', '3.57', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Grilled Chicken (Skin Not Eaten)', '', 'Chicken','101', 'g', '1', 'portion', ' 190', '28.93', '0.00', '7.41', ' 190', '28.93', '0.00', '7.41', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Breast Tenderloins', '', 'Chicken','1 servin', 'g', '1', 'portion', ' 90', '22.00', '0.00', '0.00', ' 90', '22.00', '0.00', '0.00', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baked or Fried Coated Chicken Thigh Skinless (Coating Eaten)', '', 'Chicken','100', 'g', '1', 'portion', ' 254', '21.43', '10.14', '13.65', ' 254', '21.43', '10.14', '13.65', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Roasted Broiled or Baked Chicken Breast (Skin Eaten)', '', 'Chicken','101', 'g', '1', 'portion', ' 197', '29.80', '0.00', '7.79', ' 197', '29.80', '0.00', '7.79', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Stir Fry', '', 'Chicken','2284', 'g', '1', 'portion', ' 2569', '239.84', '89.35', '139.38', ' 2569', '239.84', '89.35', '139.38', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Meat (Roasting, Roasted, Cooked)', '', 'Chicken','100', 'g', '1', 'portion', ' 167', '25.01', '0.00', '6.63', ' 167', '25.01', '0.00', '6.63', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rotisserie Chicken (Skin Not Eaten)', '', 'Chicken','101', 'g', '1', 'portion', ' 190', '28.93', '0.00', '7.41', ' 190', '28.93', '0.00', '7.41', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken (Skin Eaten)', '', 'Chicken','101', 'g', '1', 'portion', ' 239', '27.30', '0.00', '13.60', ' 239', '27.30', '0.00', '13.60', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Drumstick (Skin Eaten)', '', 'Chicken','101', 'g', '1', 'portion', ' 216', '27.03', '0.00', '11.15', ' 216', '27.03', '0.00', '11.15', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Nuggets (8 Count)', '', 'Chicken','1 servin', 'g', '1', 'portion', ' 250', '27.00', '11.00', '11.00', ' 250', '27.00', '11.00', '11.00', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baked or Fried Coated Chicken Breast Skinless', '', 'Chicken','103', 'g', '1', 'portion', ' 241', '25.73', '9.97', '10.17', ' 241', '25.73', '9.97', '10.17', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken (Breaded and Fried)', '', 'Chicken','100', 'g', '1', 'portion', ' 297', '15.59', '16.32', '18.82', ' 297', '15.59', '16.32', '18.82', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baked or Fried Coated Chicken Breast with Skin', '', 'Chicken','99', 'g', '1', 'portion', ' 260', '24.34', '9.43', '13.20', ' 260', '24.34', '9.43', '13.20', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Roasted Broiled or Baked Chicken Breast (Skin Not Eaten)', '', 'Chicken','101', 'g', '1', 'portion', ' 165', '31.02', '0.00', '3.57', ' 165', '31.02', '0.00', '3.57', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken with Gravy (Mixture)', '', 'Chicken','87', 'g', '1', 'portion', ' 116', '13.16', '2.42', '5.70', ' 116', '13.16', '2.42', '5.70', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Breast (Skin Eaten)', '', 'Chicken','101', 'g', '1', 'portion', ' 197', '29.80', '0.00', '7.79', ' 197', '29.80', '0.00', '7.79', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baked or Fried Coated Chicken Leg with Skin (Skin/Coating Eaten)', '', 'Chicken','99', 'g', '1', 'portion', ' 271', '21.75', '8.66', '15.99', ' 271', '21.75', '8.66', '15.99', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fried Chicken Thigh No Coating (Skin Eaten)', '', 'Chicken','102', 'g', '1', 'portion', ' 259', '27.54', '0.00', '15.73', ' 259', '27.54', '0.00', '15.73', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Canned Chicken (Meat Only)', '', 'Chicken','100', 'g', '1', 'portion', ' 184', '25.30', '0.80', '8.10', ' 184', '25.30', '0.80', '8.10', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Roasted Broiled or Baked Chicken Thigh', '', 'Chicken','101', 'g', '1', 'portion', ' 247', '25.06', '0.00', '15.49', ' 247', '25.06', '0.00', '15.49', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Nuggets', '', 'Chicken','100', 'g', '1', 'portion', ' 297', '15.59', '16.32', '18.82', ' 297', '15.59', '16.32', '18.82', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken or Turkey Cordon Bleu', '', 'Chicken','395', 'g', '1', 'portion', ' 869', '76.53', '19.35', '50.07', ' 869', '76.53', '19.35', '50.07', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Marsala', '', 'Chicken','997', 'g', '1', 'portion', ' 2322', '152.46', '53.71', '147.38', ' 2322', '152.46', '53.71', '147.38', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken or Turkey and Rice with Cream Sauce (Mixture)', '', 'Chicken','1380', 'g', '1', 'portion', ' 1973', '121.69', '179.64', '83.06', ' 1973', '121.69', '179.64', '83.06', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baked or Fried Coated Chicken with Skin (Skin/Coating Not Eaten)', '', 'Chicken','104', 'g', '1', 'portion', ' 221', '31.92', '0.00', '9.52', ' 221', '31.92', '0.00', '9.52', '1', 'barcode', '22', '', '' , '',' ', '', ''");
// =========FOODS SEAFOOD ============
    setupInsertToFood(  " NULL, 'Shrimp', '', 'Seafood','101', 'g', '1', 'portion', ' 145', '27.82', '1.25', '2.37', ' 145', '27.82', '1.25', '2.37', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Crab', '', 'Seafood','101', 'g', '1', 'portion', ' 102', '20.20', '0.00', '1.78', ' 102', '20.20', '0.00', '1.78', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Shrimp', '', 'Seafood','100', 'g', '1', 'portion', ' 106', '20.31', '0.91', '1.73', ' 106', '20.31', '0.91', '1.73', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Scallops', '', 'Seafood','1086', 'g', '1', 'portion', ' 2358', '197.08', '113.97', '119.08', ' 2358', '197.08', '113.97', '119.08', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Mussels', '', 'Seafood','100', 'g', '1', 'portion', ' 86', '11.90', '3.69', '2.24', ' 86', '11.90', '3.69', '2.24', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Shrimp and Vegetables in Soy-Based Sauce (Including Carrots, Broccoli, and/or Dark-Green Leafy, No Potatoes, Mixture)', '', 'Seafood','814', 'g', '1', 'portion', ' 798', '72.05', '49.58', '34.68', ' 798', '72.05', '49.58', '34.68', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Lobster Newburg', '', 'Seafood','930', 'g', '1', 'portion', ' 2305', '112.76', '43.88', '187.40', ' 2305', '112.76', '43.88', '187.40', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chef\\0s Creations In a Bag (Full Portion)', '', 'Seafood','1 servin', 'g', '1', 'portion', ' 110', '10.00', '6.00', '5.00', ' 110', '10.00', '6.00', '5.00', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Steamed or Boiled Clams', '', 'Seafood','411', 'g', '1', 'portion', ' 379', '65.13', '13.12', '4.94', ' 379', '65.13', '13.12', '4.94', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Shellfish Mixture and Noodles in Tomato-Based Sauce (Mixture)', '', 'Seafood','742', 'g', '1', 'portion', ' 839', '47.79', '112.06', '21.45', ' 839', '47.79', '112.06', '21.45', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dungeness Crab (Cooked, Moist Heat)', '', 'Seafood','100', 'g', '1', 'portion', ' 110', '22.32', '0.95', '1.24', ' 110', '22.32', '0.95', '1.24', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Canned Shrimp', '', 'Seafood','100', 'g', '1', 'portion', ' 100', '20.42', '0.00', '1.36', ' 100', '20.42', '0.00', '1.36', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Steamed Clams', '', 'Seafood','1 servin', 'g', '1', 'portion', ' 430', '64.00', '10.00', '15.00', ' 430', '64.00', '10.00', '15.00', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baked Stuffed Shrimp', '', 'Seafood','1 servin', 'g', '1', 'portion', ' 570', '4.00', '46.00', '16.00', ' 570', '4.00', '46.00', '16.00', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Shrimp Lover’s Tuesday Coconut Shrimp Bites', '', 'Seafood','1 servin', 'g', '1', 'portion', ' 290', '13.00', '19.00', '18.00', ' 290', '13.00', '19.00', '18.00', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Blue Crab (Canned)', '', 'Seafood','100', 'g', '1', 'portion', ' 99', '20.52', '0.00', '1.23', ' 99', '20.52', '0.00', '1.23', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Blue Crab', '', 'Seafood','100', 'g', '1', 'portion', ' 87', '18.06', '0.04', '1.08', ' 87', '18.06', '0.04', '1.08', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Shrimp Lover’s Tuesday Fried Shrimp', '', 'Seafood','1 servin', 'g', '1', 'portion', ' 190', '14.00', '9.00', '11.00', ' 190', '14.00', '9.00', '11.00', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Calamari Fritti', '', 'Seafood','1 servin', 'g', '1', 'portion', ' 650', '23.00', '42.00', '43.00', ' 650', '23.00', '42.00', '43.00', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Popcorn Shrimp', '', 'Seafood','1 servin', 'g', '1', 'portion', ' 190', '8.00', '19.00', '9.00', ' 190', '8.00', '19.00', '9.00', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Clams (Mixed Species, Drained Solids, Canned)', '', 'Seafood','100', 'g', '1', 'portion', ' 148', '25.55', '5.13', '1.95', ' 148', '25.55', '5.13', '1.95', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cooked Clams', '', 'Seafood','1087', 'g', '1', 'portion', ' 1957', '161.35', '120.25', '87.31', ' 1957', '161.35', '120.25', '87.31', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Golden Fried Shrimp (Dinner)', '', 'Seafood','1 servin', 'g', '1', 'portion', ' 880', '41.00', '71.00', '48.00', ' 880', '41.00', '71.00', '48.00', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Canned Clam and Tomato Juice', '', 'Seafood','100', 'g', '1', 'portion', ' 48', '0.60', '10.95', '0.20', ' 48', '0.60', '10.95', '0.20', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Clam Strips (Sack)', '', 'Seafood','1 servin', 'g', '1', 'portion', ' 500', '16.00', '9.00', '44.00', ' 500', '16.00', '9.00', '44.00', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Lobster', '', 'Seafood','101', 'g', '1', 'portion', ' 98', '20.50', '1.28', '0.59', ' 98', '20.50', '1.28', '0.59', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Queen Crab', '', 'Seafood','100', 'g', '1', 'portion', ' 90', '18.50', '0.00', '1.18', ' 90', '18.50', '0.00', '1.18', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dried Squid', '', 'Seafood','100', 'g', '1', 'portion', ' 350', '59.24', '11.72', '5.25', ' 350', '59.24', '11.72', '5.25', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Clam Strips (Regular)', '', 'Seafood','1 servin', 'g', '1', 'portion', ' 250', '8.00', '5.00', '22.00', ' 250', '8.00', '5.00', '22.00', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Blue Crab (Cooked, Moist Heat)', '', 'Seafood','100', 'g', '1', 'portion', ' 102', '20.20', '0.00', '1.77', ' 102', '20.20', '0.00', '1.77', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Crab Cake', '', 'Seafood','552', 'g', '1', 'portion', ' 927', '122.67', '3.70', '44.03', ' 927', '122.67', '3.70', '44.03', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Peach-Bourbon BBQ Scallops', '', 'Seafood','1 servin', 'g', '1', 'portion', ' 430', '26.00', '24.00', '27.00', ' 430', '26.00', '24.00', '27.00', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Queen Crab (Cooked, Moist Heat)', '', 'Seafood','100', 'g', '1', 'portion', ' 115', '23.72', '0.00', '1.51', ' 115', '23.72', '0.00', '1.51', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Crab Cake Entrees', '', 'Seafood','100', 'g', '1', 'portion', ' 266', '18.75', '8.52', '17.25', ' 266', '18.75', '8.52', '17.25', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fried Breaded Squid', '', 'Seafood','1086', 'g', '1', 'portion', ' 2140', '191.22', '125.59', '91.59', ' 2140', '191.22', '125.59', '91.59', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Canned Crab', '', 'Seafood','100', 'g', '1', 'portion', ' 99', '20.52', '0.00', '1.23', ' 99', '20.52', '0.00', '1.23', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Canned Clams', '', 'Seafood','100', 'g', '1', 'portion', ' 92', '15.96', '3.21', '1.21', ' 92', '15.96', '3.21', '1.21', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Clams Casino', '', 'Seafood','451', 'g', '1', 'portion', ' 514', '35.93', '43.19', '22.00', ' 514', '35.93', '43.19', '22.00', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Shrimp and Clams in Tomato-Based Sauce with Noodles (Frozen Meal)', '', 'Seafood','321', 'g', '1', 'portion', ' 331', '25.32', '38.86', '8.06', ' 331', '25.32', '38.86', '8.06', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Smoked Clams in Oil', '', 'Seafood','101', 'g', '1', 'portion', ' 176', '14.28', '2.87', '11.69', ' 176', '14.28', '2.87', '11.69', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Clam (Mixed Species, Cooked, Breaded and Fried)', '', 'Seafood','100', 'g', '1', 'portion', ' 202', '14.24', '10.33', '11.15', ' 202', '14.24', '10.33', '11.15', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Broiled Baked Squid', '', 'Seafood','706', 'g', '1', 'portion', ' 967', '132.53', '26.69', '32.55', ' 967', '132.53', '26.69', '32.55', '1', 'barcode', '23', '', '' , '',' ', '', ''");
// =========FOODS EGGS ============
    setupInsertToFood(  " NULL, 'Egg', '', 'Eggs','100', 'g', '1', 'portion', ' 147', '12.58', '0.77', '9.94', ' 147', '12.58', '0.77', '9.94', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Scrambled Egg', '', 'Eggs','100', 'g', '1', 'portion', ' 212', '13.84', '2.08', '16.18', ' 212', '13.84', '2.08', '16.18', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fried Egg', '', 'Eggs','100', 'g', '1', 'portion', ' 201', '13.63', '0.88', '15.31', ' 201', '13.63', '0.88', '15.31', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Boiled Egg', '', 'Eggs','100', 'g', '1', 'portion', ' 155', '12.58', '1.12', '10.61', ' 155', '12.58', '1.12', '10.61', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Eggs', '', 'Eggs','1 e', 'g', '1', 'portion', ' 70', '6.00', '0.00', '5.00', ' 70', '6.00', '0.00', '5.00', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Large Grade A Eggs', '', 'Eggs','1 e', 'g', '1', 'portion', ' 60', '6.00', '0.00', '4.00', ' 60', '6.00', '0.00', '4.00', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fried Egg', '', 'Eggs','53', 'g', '1', 'portion', ' 102', '7.15', '0.49', '7.75', ' 102', '7.15', '0.49', '7.75', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg White', '', 'Eggs','100', 'g', '1', 'portion', ' 52', '10.90', '0.73', '0.17', ' 52', '10.90', '0.73', '0.17', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Medium Eggs', '', 'Eggs','1 e', 'g', '1', 'portion', ' 60', '6.00', '0.00', '4.00', ' 60', '6.00', '0.00', '4.00', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Extra Large Grade A Eggs', '', 'Eggs','1 e', 'g', '1', 'portion', ' 70', '7.00', '0.00', '4.50', ' 70', '7.00', '0.00', '4.50', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Hard-Boiled Egg', '', 'Eggs','100', 'g', '1', 'portion', ' 155', '12.58', '1.12', '10.61', ' 155', '12.58', '1.12', '10.61', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Scrambled Egg (Whole, Cooked)', '', 'Eggs','100', 'g', '1', 'portion', ' 166', '11.09', '2.20', '12.21', ' 166', '11.09', '2.20', '12.21', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Poached Egg', '', 'Eggs','100', 'g', '1', 'portion', ' 147', '12.58', '0.77', '9.94', ' 147', '12.58', '0.77', '9.94', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Omelet or Scrambled Egg with Cheese', '', 'Eggs','87', 'g', '1', 'portion', ' 162', '10.59', '2.58', '12.00', ' 162', '10.59', '2.58', '12.00', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fried Egg without Fat', '', 'Eggs','50', 'g', '1', 'portion', ' 84', '7.15', '0.44', '5.65', ' 84', '7.15', '0.44', '5.65', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Organic Brown Eggs (Large)', '', 'Eggs','1 e', 'g', '1', 'portion', ' 60', '6.00', '1.00', '4.00', ' 60', '6.00', '1.00', '4.00', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Eggs (Extra Large)', '', 'Eggs','1 e', 'g', '1', 'portion', ' 80', '7.00', '0.00', '5.00', ' 80', '7.00', '0.00', '5.00', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Omelet or Scrambled Egg', '', 'Eggs','68', 'g', '1', 'portion', ' 107', '7.47', '1.27', '7.83', ' 107', '7.47', '1.27', '7.83', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cooked Egg', '', 'Eggs','100', 'g', '1', 'portion', ' 169', '12.34', '1.28', '12.26', ' 169', '12.34', '1.28', '12.26', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg (Whole)', '', 'Eggs','100', 'g', '1', 'portion', ' 147', '12.58', '0.77', '9.94', ' 147', '12.58', '0.77', '9.94', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Eggs (Large)', '', 'Eggs','1 e', 'g', '1', 'portion', ' 70', '6.00', '0.00', '5.00', ' 70', '6.00', '0.00', '5.00', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Omelet or Scrambled Egg with Onions, Peppers, Tomatoes and Mushrooms', '', 'Eggs','156', 'g', '1', 'portion', ' 185', '8.67', '6.28', '14.25', ' 185', '8.67', '6.28', '14.25', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Omelet or Scrambled Egg with Cheese and Ham or Bacon', '', 'Eggs','101', 'g', '1', 'portion', ' 200', '13.94', '2.58', '14.62', ' 200', '13.94', '2.58', '14.62', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Omelet or Scrambled Egg with Vegetables', '', 'Eggs','89', 'g', '1', 'portion', ' 115', '7.85', '2.58', '7.97', ' 115', '7.85', '2.58', '7.97', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cooked Egg White', '', 'Eggs','100', 'g', '1', 'portion', ' 52', '10.90', '0.73', '0.17', ' 52', '10.90', '0.73', '0.17', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Brown Cage Free Eggs (Large)', '', 'Eggs','1 e', 'g', '1', 'portion', ' 70', '6.00', '0.00', '5.00', ' 70', '6.00', '0.00', '5.00', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Omelet or Scrambled Egg with Ham or Bacon', '', 'Eggs','101', 'g', '1', 'portion', ' 186', '14.35', '1.49', '13.17', ' 186', '14.35', '1.49', '13.17', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soft Boiled Egg', '', 'Eggs','100', 'g', '1', 'portion', ' 155', '12.58', '1.12', '10.61', ' 155', '12.58', '1.12', '10.61', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Omelet or Scrambled Egg with Cheese, Ham or Bacon and Tomatoes', '', 'Eggs','131', 'g', '1', 'portion', ' 206', '14.23', '3.88', '14.68', ' 206', '14.23', '3.88', '14.68', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Hard Boiled Eggs', '', 'Eggs','1 e', 'g', '1', 'portion', ' 70', '6.00', '0.00', '4.00', ' 70', '6.00', '0.00', '4.00', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Jumbo Grade A Eggs', '', 'Eggs','1 e', 'g', '1', 'portion', ' 90', '8.00', '0.00', '6.00', ' 90', '8.00', '0.00', '6.00', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baked Egg', '', 'Eggs','55', 'g', '1', 'portion', ' 119', '7.00', '0.53', '9.64', ' 119', '7.00', '0.53', '9.64', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Omelet or Scrambled Egg with Mushrooms', '', 'Eggs','92', 'g', '1', 'portion', ' 115', '8.04', '2.59', '7.99', ' 115', '8.04', '2.59', '7.99', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Scrambled Eggs', '', 'Eggs','2 e', 'g', '1', 'portion', ' 140', '13.00', '1.00', '9.00', ' 140', '13.00', '1.00', '9.00', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Scrambled Eggs', '', 'Eggs','4 e', 'g', '1', 'portion', ' 190', '12.00', '53.00', '13.00', ' 190', '12.00', '53.00', '13.00', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Organic Free Range Large Brown Eggs', '', 'Eggs','1 e', 'g', '1', 'portion', ' 70', '6.00', '0.00', '5.00', ' 70', '6.00', '0.00', '5.00', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Eggs', '', 'Eggs','2 e', 'g', '1', 'portion', ' 250', '13.00', '1.00', '21.00', ' 250', '13.00', '1.00', '21.00', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Omelet or Scrambled Egg with Fish', '', 'Eggs','85', 'g', '1', 'portion', ' 129', '10.24', '1.50', '8.73', ' 129', '10.24', '1.50', '8.73', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Scrambled Egg (2 Eggs)', '', 'Eggs','1 servin', 'g', '1', 'portion', ' 168', '13.00', '2.00', '11.00', ' 168', '13.00', '2.00', '11.00', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Grade AA Large Eggs', '', 'Eggs','1 e', 'g', '1', 'portion', ' 70', '6.00', '1.00', '4.50', ' 70', '6.00', '1.00', '4.50', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Omega 3 Fortified Eggs (Large)', '', 'Eggs','1 e', 'g', '1', 'portion', ' 70', '6.00', '1.00', '5.00', ' 70', '6.00', '1.00', '5.00', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Omelet or Scrambled Egg with Chili, Cheese, Tomatoes and Beans', '', 'Eggs','301', 'g', '1', 'portion', ' 458', '30.15', '11.09', '32.20', ' 458', '30.15', '11.09', '32.20', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Scrambled Egg (Cholesterol-Free Frozen Mixture)', '', 'Eggs','83', 'g', '1', 'portion', ' 136', '8.48', '3.39', '9.71', ' 136', '8.48', '3.39', '9.71', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Yolk (Sugared, Frozen)', '', 'Eggs','100', 'g', '1', 'portion', ' 307', '13.80', '10.80', '22.75', ' 307', '13.80', '10.80', '22.75', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Grade A Large Eggs', '', 'Eggs','1 e', 'g', '1', 'portion', ' 70', '6.00', '1.00', '4.50', ' 70', '6.00', '1.00', '4.50', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Scrambled Egg made from Dry Eggs', '', 'Eggs','112', 'g', '1', 'portion', ' 238', '10.36', '1.38', '21.14', ' 238', '10.36', '1.38', '21.14', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Yolk (Frozen)', '', 'Eggs','100', 'g', '1', 'portion', ' 303', '15.50', '1.15', '25.60', ' 303', '15.50', '1.15', '25.60', '1', 'barcode', '25', '', '' , '',' ', '', ''");
// =========FOODS CREAM AND SOUR CREAM ============
    setupInsertToFood(  " NULL, 'Sour Cream', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 214', '3.16', '4.27', '20.96', ' 214', '3.16', '4.27', '20.96', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sour Cream (Sour Dressing, Nonbutterfat)', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 178', '3.25', '4.68', '16.57', ' 178', '3.25', '4.68', '16.57', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Apple-Sour Cream Pie', '', 'Cream and sour cream','1103', 'g', '1', 'portion', ' 2283', '21.18', '329.36', '103.90', ' 2283', '21.18', '329.36', '103.90', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fat Free Sour Cream', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 74', '3.10', '15.60', '0.00', ' 74', '3.10', '15.60', '0.00', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sour Cream Spinach Dip', '', 'Cream and sour cream','891', 'g', '1', 'portion', ' 2308', '23.53', '57.13', '226.72', ' 2308', '23.53', '57.13', '226.72', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Light Sour Cream', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 136', '3.50', '7.10', '10.60', ' 136', '3.50', '7.10', '10.60', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sour Cream Dip', '', 'Cream and sour cream','499', 'g', '1', 'portion', ' 1103', '17.47', '43.16', '98.40', ' 1103', '17.47', '43.16', '98.40', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Raisin Sour Cream Pie', '', 'Cream and sour cream','628', 'g', '1', 'portion', ' 2268', '33.61', '216.33', '146.61', ' 2268', '33.61', '216.33', '146.61', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Reduced Calorie Sour Cream Dip', '', 'Cream and sour cream','523', 'g', '1', 'portion', ' 774', '17.15', '44.14', '60.04', ' 774', '17.15', '44.14', '60.04', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Gelatin Dessert with Sour Cream', '', 'Cream and sour cream','693', 'g', '1', 'portion', ' 666', '11.44', '83.21', '32.17', ' 666', '11.44', '83.21', '32.17', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Creamy Dressing (made with Sour Cream and/or Buttermilk and Oil)', '', 'Cream and sour cream','99', 'g', '1', 'portion', ' 482', '0.34', '4.72', '52.09', ' 482', '0.34', '4.72', '52.09', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cherry Pie made with Cream Cheese and Sour Cream', '', 'Cream and sour cream','1814', 'g', '1', 'portion', ' 5171', '62.42', '716.70', '240.77', ' 5171', '62.42', '716.70', '240.77', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Reduced Fat Sour Cream', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 181', '7.00', '7.00', '14.10', ' 181', '7.00', '7.00', '14.10', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Imitation Sour Cream (Nondairy)', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 208', '2.40', '6.63', '19.52', ' 208', '2.40', '6.63', '19.52', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sour Cream', '', 'Cream and sour cream','1 servin', 'g', '1', 'portion', ' 60', '1.00', '2.00', '5.00', ' 60', '1.00', '2.00', '5.00', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sour Cream', '', 'Cream and sour cream','1 servin', 'g', '1', 'portion', ' 57', '1.00', '2.00', '6.00', ' 57', '1.00', '2.00', '6.00', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sour Cream', '', 'Cream and sour cream','1 servin', 'g', '1', 'portion', ' 60', '3.00', '3.00', '4.00', ' 60', '3.00', '3.00', '4.00', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sour Cream (Fat Free)', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 74', '3.10', '15.60', '0.00', ' 74', '3.10', '15.60', '0.00', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Gelatin Dessert with Fruit and Sour Cream', '', 'Cream and sour cream','1984', 'g', '1', 'portion', ' 2143', '27.97', '431.29', '49.99', ' 2143', '27.97', '431.29', '49.99', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sour Cream (Cultured)', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 214', '3.16', '4.27', '20.96', ' 214', '3.16', '4.27', '20.96', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sour Cream (Light)', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 136', '3.50', '7.10', '10.60', ' 136', '3.50', '7.10', '10.60', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Imitation Sour Cream (Cultured)', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 208', '2.40', '6.63', '19.52', ' 208', '2.40', '6.63', '19.52', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sour Cream', '', 'Cream and sour cream','1 servin', 'g', '1', 'portion', ' 60', '1.00', '1.00', '5.00', ' 60', '1.00', '1.00', '5.00', '1', 'barcode', '26', '', '' , '',' ', '', ''");
// =========FOODS YOGURT ============
    setupInsertToFood(  " NULL, 'Plain Yogurt', '', 'Yogurt','100', 'g', '1', 'portion', ' 63', '5.25', '7.04', '1.55', ' 63', '5.25', '7.04', '1.55', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Yogurt', '', 'Yogurt','100', 'g', '1', 'portion', ' 99', '3.98', '18.64', '1.15', ' 99', '3.98', '18.64', '1.15', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vanilla Yogurt (Lowfat)', '', 'Yogurt','100', 'g', '1', 'portion', ' 85', '4.93', '13.80', '1.25', ' 85', '4.93', '13.80', '1.25', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Whole Milk Plain Yogurt', '', 'Yogurt','100', 'g', '1', 'portion', ' 61', '3.47', '4.66', '3.25', ' 61', '3.47', '4.66', '3.25', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Light & Fit Yogurt - Peach (4 oz)', '', 'Yogurt','1 servin', 'g', '1', 'portion', ' 60', '3.00', '10.00', '0.00', ' 60', '3.00', '10.00', '0.00', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Lowfat Plain Yogurt', '', 'Yogurt','100', 'g', '1', 'portion', ' 63', '5.25', '7.04', '1.55', ' 63', '5.25', '7.04', '1.55', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Whole Milk Vanilla, Lemon or Coffee Flavor Yogurt', '', 'Yogurt','102', 'g', '1', 'portion', ' 103', '4.94', '13.80', '3.24', ' 103', '4.94', '13.80', '3.24', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Lowfat Fruit Variety Yogurt', '', 'Yogurt','100', 'g', '1', 'portion', ' 102', '4.37', '19.05', '1.08', ' 102', '4.37', '19.05', '1.08', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Plain Yogurt (Whole Milk)', '', 'Yogurt','100', 'g', '1', 'portion', ' 61', '3.47', '4.66', '3.25', ' 61', '3.47', '4.66', '3.25', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Plain Yogurt (Lowfat)', '', 'Yogurt','100', 'g', '1', 'portion', ' 63', '5.25', '7.04', '1.55', ' 63', '5.25', '7.04', '1.55', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Organic Strawberry 2% Yogurt', '', 'Yogurt','1 servin', 'g', '1', 'portion', ' 170', '6.00', '25.00', '4.00', ' 170', '6.00', '25.00', '4.00', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Yogurt (Lowfat with Low Calorie Sweetener)', '', 'Yogurt','100', 'g', '1', 'portion', ' 105', '4.86', '18.60', '1.41', ' 105', '4.86', '18.60', '1.41', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Nonfat Fruit Variety Yogurt', '', 'Yogurt','100', 'g', '1', 'portion', ' 94', '4.40', '19.00', '0.20', ' 94', '4.40', '19.00', '0.20', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Yogurt Chips', '', 'Yogurt','100', 'g', '1', 'portion', ' 524', '10.32', '55.20', '28.70', ' 524', '10.32', '55.20', '28.70', '1', 'barcode', '27', '', '' , '',' ', '', ''");
// =========FOODS READY DINNER DISHES ============
    setupInsertToFood(  " NULL, 'Turkey Dinner (Frozen Meal)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 155', '9.64', '13.17', '7.00', ' 155', '9.64', '13.17', '7.00', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Frozen Dinner', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 159', '8.72', '11.14', '8.75', ' 159', '8.72', '11.14', '8.75', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Eat Cereal', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 376', '7.24', '83.02', '3.38', ' 376', '7.24', '83.02', '3.38', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chopped Sirloin Dinner (Frozen Meal)', '', 'Ready dinner dishes','319', 'g', '1', 'portion', ' 500', '24.44', '42.93', '26.13', ' 500', '24.44', '42.93', '26.13', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef Enchilada Dinner (Frozen Meal)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 124', '5.08', '16.64', '4.12', ' 124', '5.08', '16.64', '4.12', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fish Dinner (Frozen Meal)', '', 'Ready dinner dishes','93', 'g', '1', 'portion', ' 182', '11.82', '12.80', '9.35', ' 182', '11.82', '12.80', '9.35', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Potato Only From Puerto Rican Mixed Dishes', '', 'Ready dinner dishes','157', 'g', '1', 'portion', ' 133', '2.67', '31.22', '0.16', ' 133', '2.67', '31.22', '0.16', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef Dinner (Frozen Meal)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 148', '6.92', '11.66', '8.37', ' 148', '6.92', '11.66', '8.37', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chocolate Ready-to-Drink Soy Milk', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 49', '2.75', '5.81', '1.91', ' 49', '2.75', '5.81', '1.91', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Drink Meal Supplement or Replacement', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 70', '3.50', '10.90', '1.40', ' 70', '3.50', '10.90', '1.40', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Drink Soy Milk', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 42', '3.22', '3.65', '1.66', ' 42', '3.22', '3.65', '1.66', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Spaghetti and Meatballs Dinner (Frozen Meal)', '', 'Ready dinner dishes','367', 'g', '1', 'portion', ' 410', '20.34', '54.35', '12.17', ' 410', '20.34', '54.35', '12.17', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Feed Infant Formula (America\\0s Store Brand, with Iron)', '', 'Ready dinner dishes','61', 'g', '1', 'portion', ' 40', '0.90', '4.18', '2.17', ' 40', '0.90', '4.18', '2.17', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Serve Reduced Sodium Chicken Rice Soup (Canned)', '', 'Ready dinner dishes','596', 'g', '1', 'portion', ' 143', '5.96', '20.26', '4.77', ' 143', '5.96', '20.26', '4.77', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetable Soup (Prepared with Water or Ready-to-Serve)', '', 'Ready dinner dishes','586', 'g', '1', 'portion', ' 199', '7.21', '31.88', '4.63', ' 199', '7.21', '31.88', '4.63', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Eat Low Calorie Chocolate Pudding with Artificial Sweetener', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 83', '3.35', '15.28', '0.89', ' 83', '3.35', '15.28', '0.89', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Serve Low Sodium Tomato Soup (Canned)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 35', '0.80', '7.30', '0.80', ' 35', '0.80', '7.30', '0.80', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetable Bean Soup (Prepared with Water or Ready-to-Serve)', '', 'Ready dinner dishes','586', 'g', '1', 'portion', ' 205', '10.37', '27.31', '6.09', ' 205', '10.37', '27.31', '6.09', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Serve Reduced Sodium Minestrone Soup (Canned)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 50', '2.00', '9.00', '0.80', ' 50', '2.00', '9.00', '0.80', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Serve Reduced Sodium Split Pea and Ham Soup (with Water, Canned)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 68', '4.00', '11.40', '0.70', ' 68', '4.00', '11.40', '0.70', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Eat Low Calorie Pudding with Artificial Sweetener (Flavors Other Than Chocolate)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 78', '2.70', '16.11', '0.65', ' 78', '2.70', '16.11', '0.65', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Serve Reduced Sodium Split Pea Soup (with Water, Canned)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 71', '3.85', '11.83', '0.92', ' 71', '3.85', '11.83', '0.92', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Serve Low Sodium Vegetable Soup (Prepared with Water, Canned)', '', 'Ready dinner dishes','596', 'g', '1', 'portion', ' 191', '6.56', '36.12', '2.68', ' 191', '6.56', '36.12', '2.68', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetable Chicken or Turkey Soup (Prepared with Water or Ready-to-Serve)', '', 'Ready dinner dishes','586', 'g', '1', 'portion', ' 182', '8.15', '20.98', '7.15', ' 182', '8.15', '20.98', '7.15', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetable Chicken Rice Soup (Prepared with Water or Ready-to-Serve)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 28', '1.48', '3.26', '0.98', ' 28', '1.48', '3.26', '0.98', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetable Chicken Noodle Soup (Prepared with Water or Ready-to-Serve)', '', 'Ready dinner dishes','586', 'g', '1', 'portion', ' 170', '8.26', '19.46', '6.33', ' 170', '8.26', '19.46', '6.33', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Serve Reduced Sodium Bean and Ham Soup (with Water, Canned )', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 74', '4.19', '13.66', '1.03', ' 74', '4.19', '13.66', '1.03', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Dinner (Frozen Meal)', '', 'Ready dinner dishes','282', 'g', '1', 'portion', ' 493', '28.13', '37.89', '24.98', ' 493', '28.13', '37.89', '24.98', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beans and Franks (Frozen Dinner)', '', 'Ready dinner dishes','311', 'g', '1', 'portion', ' 480', '16.35', '67.42', '17.19', ' 480', '16.35', '67.42', '17.19', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Veal Dinner (Frozen Meal)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 129', '6.36', '11.91', '6.26', ' 129', '6.36', '11.91', '6.26', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Eat Chocolate Pudding', '', 'Ready dinner dishes','587', 'g', '1', 'portion', ' 628', '18.61', '111.35', '11.86', ' 628', '18.61', '111.35', '11.86', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baby Food Chicken Noodle Dinner', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 60', '2.53', '8.94', '1.62', ' 60', '2.53', '8.94', '1.62', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Salisbury Steak Dinner (Frozen Meal)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 148', '6.92', '11.66', '8.37', ' 148', '6.92', '11.66', '8.37', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat Loaf Dinner (Frozen Meal)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 131', '6.62', '9.65', '7.40', ' 131', '6.62', '9.65', '7.40', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Serve Reduced Sodium Chicken Noodle Soup (Canned)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 35', '3.46', '3.66', '0.95', ' 35', '3.46', '3.66', '0.95', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Eat Corned Beef (Canned)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 250', '27.10', '0.00', '14.93', ' 250', '27.10', '0.00', '14.93', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'High Protein Ready-to-Drink Meal Supplement or Replacement (with Milk)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 94', '5.70', '13.00', '2.20', ' 94', '5.70', '13.00', '2.20', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Reduced Sodium Vegetable Noodle Soup (Prepared with Water or Ready-to-Serve, Canned)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 40', '1.62', '8.62', '0.46', ' 40', '1.62', '8.62', '0.46', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Eat Pudding (Flavors Other Than Chocolate)', '', 'Ready dinner dishes','559', 'g', '1', 'portion', ' 570', '15.76', '104.42', '9.78', ' 570', '15.76', '104.42', '9.78', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Serve Low Sodium Chicken Noodle Soup (Canned)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 31', '1.70', '4.58', '1.00', ' 31', '1.70', '4.58', '1.00', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dinner Rolls', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 300', '8.40', '50.40', '7.30', ' 300', '8.40', '50.40', '7.30', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetable Beef Soup with Rice (Prepared with Water or Ready-to-Serve)', '', 'Ready dinner dishes','264', 'g', '1', 'portion', ' 103', '6.12', '15.75', '1.95', ' 103', '6.12', '15.75', '1.95', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Salsa (Ready to Serve)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 27', '1.54', '6.26', '0.16', ' 27', '1.54', '6.26', '0.16', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Whole Wheat Dinner Rolls', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 266', '8.70', '51.10', '4.70', ' 266', '8.70', '51.10', '4.70', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Plain Dinner Rolls (with Low Fat 2% Milk)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 316', '8.50', '53.40', '7.30', ' 316', '8.50', '53.40', '7.30', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oat Bran Dinner Rolls', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 236', '9.50', '40.20', '4.60', ' 236', '9.50', '40.20', '4.60', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rye Dinner Rolls', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 286', '10.30', '53.10', '3.40', ' 286', '10.30', '53.10', '3.40', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Wheat Dinner Rolls', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 273', '8.60', '46.00', '6.30', ' 273', '8.60', '46.00', '6.30', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Dinner Rolls', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 307', '9.50', '52.00', '6.40', ' 307', '9.50', '52.00', '6.40', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Crispy Brown Rice Cereal Ready-to-Eat', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 388', '7.10', '86.00', '3.50', ' 388', '7.10', '86.00', '3.50', '1', 'barcode', '29', '', '' , '',' ', '', ''");
// =========FOODS PIZZA ============
    setupInsertToFood(  " NULL, 'Cheese Pizza', '', 'Pizza','100', 'g', '1', 'portion', ' 276', '12.33', '30.33', '11.74', ' 276', '12.33', '30.33', '11.74', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pizza with Meat', '', 'Pizza','100', 'g', '1', 'portion', ' 301', '12.09', '31.45', '13.80', ' 301', '12.09', '31.45', '13.80', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pizza with Meat and Vegetables', '', 'Pizza','100', 'g', '1', 'portion', ' 256', '10.16', '27.42', '11.68', ' 256', '10.16', '27.42', '11.68', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, '14\" Pepperoni Pizza', '', 'Pizza','100', 'g', '1', 'portion', ' 276', '12.33', '31.46', '11.23', ' 276', '12.33', '31.46', '11.23', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Thin Crust Cheese Pizza', '', 'Pizza','100', 'g', '1', 'portion', ' 281', '12.50', '29.45', '12.53', ' 281', '12.50', '29.45', '12.53', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cheese Pizza with Vegetables', '', 'Pizza','100', 'g', '1', 'portion', ' 230', '8.89', '29.46', '8.52', ' 230', '8.89', '29.46', '8.52', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Thin Crust Pizza with Meat', '', 'Pizza','850', 'g', '1', 'portion', ' 2490', '108.70', '229.89', '124.76', ' 2490', '108.70', '229.89', '124.76', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Thin Crust Cheese Pizza with Vegetables', '', 'Pizza','974', 'g', '1', 'portion', ' 2074', '88.02', '245.85', '83.15', ' 2074', '88.02', '245.85', '83.15', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Thick Crust Pizza with Meat', '', 'Pizza','1184', 'g', '1', 'portion', ' 3646', '134.93', '424.33', '152.93', ' 3646', '134.93', '424.33', '152.93', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, '14\" Cheese Pizza', '', 'Pizza','100', 'g', '1', 'portion', ' 264', '11.91', '32.58', '9.51', ' 264', '11.91', '32.58', '9.51', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, '14\" Meat and Vegetable Pizza', '', 'Pizza','100', 'g', '1', 'portion', ' 244', '11.02', '25.38', '10.90', ' 244', '11.02', '25.38', '10.90', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Thin Crust Pizza with Meat and Vegetables', '', 'Pizza','1073', 'g', '1', 'portion', ' 2618', '112.33', '249.66', '129.93', ' 2618', '112.33', '249.66', '129.93', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Margherita Pizza', '', 'Pizza','1529', 'g', '1', 'portion', ' 4205', '147.26', '707.30', '80.50', ' 4205', '147.26', '707.30', '80.50', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Thick Crust Cheese Pizza', '', 'Pizza','100', 'g', '1', 'portion', ' 270', '12.07', '31.65', '10.55', ' 270', '12.07', '31.65', '10.55', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Thick Crust Cheese Pizza with Vegetables', '', 'Pizza','1307', 'g', '1', 'portion', ' 3229', '114.27', '440.20', '111.26', ' 3229', '114.27', '440.20', '111.26', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, '14\" Cheese Pizza (Thin Crust)', '', 'Pizza','100', 'g', '1', 'portion', ' 304', '14.17', '26.54', '15.68', ' 304', '14.17', '26.54', '15.68', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Thick Crust Pizza with Meat and Vegetables', '', 'Pizza','1407', 'g', '1', 'portion', ' 3770', '138.55', '444.07', '158.11', ' 3770', '138.55', '444.07', '158.11', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, '14\" Pepperoni Pizza (Thick Crust)', '', 'Pizza','100', 'g', '1', 'portion', ' 284', '12.43', '30.40', '12.49', ' 284', '12.43', '30.40', '12.49', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat and Vegetable Pizza (Frozen, Cooked)', '', 'Pizza','100', 'g', '1', 'portion', ' 276', '11.28', '25.14', '14.43', ' 276', '11.28', '25.14', '14.43', '1', 'barcode', '30', '', '' , '',' ', '', ''");
// =========FOODS NOODLE ============
    setupInsertToFood(  " NULL, 'Noodles', '', 'Noodle','101', 'g', '1', 'portion', ' 138', '4.54', '25.16', '2.07', ' 138', '4.54', '25.16', '2.07', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Noodles (Fat Added in Cooking)', '', 'Noodle','165', 'g', '1', 'portion', ' 261', '7.26', '40.25', '7.85', ' 261', '7.26', '40.25', '7.85', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rice Noodles (Cooked)', '', 'Noodle','100', 'g', '1', 'portion', ' 109', '0.91', '24.90', '0.20', ' 109', '0.91', '24.90', '0.20', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Noodles (Enriched, Cooked)', '', 'Noodle','100', 'g', '1', 'portion', ' 138', '4.54', '25.16', '2.07', ' 138', '4.54', '25.16', '2.07', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Macaroni or Noodles with Cheese and Tuna', '', 'Noodle','1102', 'g', '1', 'portion', ' 1852', '121.12', '135.12', '90.15', ' 1852', '121.12', '135.12', '90.15', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Noodle Soup (Home Recipe)', '', 'Noodle','2355', 'g', '1', 'portion', ' 1248', '174.04', '67.59', '26.61', ' 1248', '174.04', '67.59', '26.61', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Macaroni or Noodles with Cheese and Chicken or Turkey', '', 'Noodle','100', 'g', '1', 'portion', ' 197', '12.78', '16.09', '8.73', ' 197', '12.78', '16.09', '8.73', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Chow Fun Noodles with Vegetables', '', 'Noodle','8102', 'g', '1', 'portion', ' 8588', '188.77', '1685.12', '114.23', ' 8588', '188.77', '1685.12', '114.23', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Japanese Pan Noodles (Regular)', '', 'Noodle','1 servin', 'g', '1', 'portion', ' 620', '13.00', '110.00', '15.00', ' 620', '13.00', '110.00', '15.00', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chow Mein Chinese Noodles', '', 'Noodle','100', 'g', '1', 'portion', ' 527', '8.38', '57.54', '30.76', ' 527', '8.38', '57.54', '30.76', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Turkey Noodle Soup (Home Recipe)', '', 'Noodle','2355', 'g', '1', 'portion', ' 1437', '203.24', '77.72', '28.73', ' 1437', '203.24', '77.72', '28.73', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Noodle Pudding with Milk', '', 'Noodle','1065', 'g', '1', 'portion', ' 2898', '63.50', '409.98', '115.92', ' 2898', '63.50', '409.98', '115.92', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Flavored Pasta', '', 'Noodle','636', 'g', '1', 'portion', ' 725', '23.59', '91.68', '28.93', ' 725', '23.59', '91.68', '28.93', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Spinach Egg Noodles (Enriched, Cooked)', '', 'Noodle','100', 'g', '1', 'portion', ' 132', '5.04', '24.25', '1.57', ' 132', '5.04', '24.25', '1.57', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Noodle Soup with Fish Ball, Shrimp and Dark Green Leafy Vegetable', '', 'Noodle','847', 'g', '1', 'portion', ' 610', '39.81', '59.89', '22.11', ' 610', '39.81', '59.89', '22.11', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chunky Style Chicken Noodle Soup', '', 'Noodle','100', 'g', '1', 'portion', ' 73', '5.30', '7.10', '2.50', ' 73', '5.30', '7.10', '2.50', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Whole Wheat Lasagna Noodles with Meat', '', 'Noodle','3294', 'g', '1', 'portion', ' 4941', '320.83', '505.94', '197.63', ' 4941', '320.83', '505.94', '197.63', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oriental Style Instant Noodles', '', 'Noodle','1 ba', 'g', '1', 'portion', ' 290', '6.00', '38.00', '12.00', ' 290', '6.00', '38.00', '12.00', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Instant Noodle Soup', '', 'Noodle','188', 'g', '1', 'portion', ' 36', '1.69', '5.73', '0.66', ' 36', '1.69', '5.73', '0.66', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Spinach Egg Noodles (Enriched)', '', 'Noodle','100', 'g', '1', 'portion', ' 382', '14.61', '70.32', '4.55', ' 382', '14.61', '70.32', '4.55', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Somen Japanese Noodles (Cooked)', '', 'Noodle','100', 'g', '1', 'portion', ' 131', '4.00', '27.54', '0.18', ' 131', '4.00', '27.54', '0.18', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cream of Tomato Noodle Soup', '', 'Noodle','100', 'g', '1', 'portion', ' 75', '2.75', '11.25', '2.37', ' 75', '2.75', '11.25', '2.37', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Side Chicken Noodle Soup', '', 'Noodle','1 servin', 'g', '1', 'portion', ' 120', '13.00', '11.00', '3.50', ' 120', '13.00', '11.00', '3.50', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Whole Wheat Lasagna Noodles', '', 'Noodle','2954', 'g', '1', 'portion', ' 3869', '222.71', '505.67', '125.83', ' 3869', '222.71', '505.67', '125.83', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Noodles with Vegetables in Tomato-Based Sauce (Diet Frozen Meal)', '', 'Noodle','100', 'g', '1', 'portion', ' 67', '3.56', '10.57', '1.50', ' 67', '3.56', '10.57', '1.50', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chow Fun Rice Noodles (Fat Added in Cooking)', '', 'Noodle','347', 'g', '1', 'portion', ' 448', '5.86', '78.92', '11.31', ' 448', '5.86', '78.92', '11.31', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Whole Wheat Spaghetti Noodles with Tomato Sauce', '', 'Noodle','265', 'g', '1', 'portion', ' 265', '9.91', '51.25', '3.74', ' 265', '9.91', '51.25', '3.74', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Macaroni or Noodles with Cheese (Boxed Mix with Cheese Sauce)', '', 'Noodle','794', 'g', '1', 'portion', ' 1412', '55.86', '198.53', '42.37', ' 1412', '55.86', '198.53', '42.37', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Noodle Soup (Undiluted, Canned)', '', 'Noodle','100', 'g', '1', 'portion', ' 53', '2.59', '6.03', '1.94', ' 53', '2.59', '6.03', '1.94', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chunky Style Beef Noodle Soup', '', 'Noodle','1665', 'g', '1', 'portion', ' 1049', '105.42', '90.27', '27.98', ' 1049', '105.42', '90.27', '27.98', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Long Rice Noodles (Fat Added in Cooking)', '', 'Noodle','103', 'g', '1', 'portion', ' 111', '0.04', '20.67', '3.08', ' 111', '0.04', '20.67', '3.08', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetable Noodle Soup (Home Recipe)', '', 'Noodle','1376', 'g', '1', 'portion', ' 688', '27.80', '85.73', '29.17', ' 688', '27.80', '85.73', '29.17', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef Noodle Soup (Undiluted, Canned)', '', 'Noodle','100', 'g', '1', 'portion', ' 67', '3.85', '7.16', '2.46', ' 67', '3.85', '7.16', '2.46', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chow Fun Noodles with Meat and Vegetables', '', 'Noodle','1566', 'g', '1', 'portion', ' 1973', '98.67', '222.39', '74.55', ' 1973', '98.67', '222.39', '74.55', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chinese Noodles (Mung Beans) (Cellophane or Long Rice)', '', 'Noodle','100', 'g', '1', 'portion', ' 351', '0.16', '86.09', '0.06', ' 351', '0.16', '86.09', '0.06', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ramen Noodle Soup - Pork Flavor', '', 'Noodle','1/2 block noodles with seasonin', 'g', '1', 'portion', ' 190', '5.00', '25.00', '7.00', ' 190', '5.00', '25.00', '7.00', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Egg Noodles', '', 'Noodle','100', 'g', '1', 'portion', ' 384', '14.16', '71.27', '4.44', ' 384', '14.16', '71.27', '4.44', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Noodles (with Added Salt, Cooked)', '', 'Noodle','100', 'g', '1', 'portion', ' 138', '4.54', '25.16', '2.07', ' 138', '4.54', '25.16', '2.07', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Japanese Pan Noodles with Chicken (Regular)', '', 'Noodle','1 servin', 'g', '1', 'portion', ' 810', '39.00', '125.00', '19.00', ' 810', '39.00', '125.00', '19.00', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Noodle Pudding', '', 'Noodle','619', 'g', '1', 'portion', ' 1295', '36.80', '192.29', '45.35', ' 1295', '36.80', '192.29', '45.35', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cream of Chicken Noodle Soup', '', 'Noodle','595', 'g', '1', 'portion', ' 309', '17.49', '31.95', '11.72', ' 309', '17.49', '31.95', '11.72', '1', 'barcode', '31', '', '' , '',' ', '', ''");
// =========FOODS PASTA ============
    setupInsertToFood(  " NULL, 'Penne', '', 'Pasta','101', 'g', '1', 'portion', ' 158', '5.80', '30.86', '0.93', ' 158', '5.80', '30.86', '0.93', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Spaghetti', '', 'Pasta','101', 'g', '1', 'portion', ' 158', '5.80', '30.86', '0.93', ' 158', '5.80', '30.86', '0.93', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rotini', '', 'Pasta','101', 'g', '1', 'portion', ' 158', '5.80', '30.86', '0.93', ' 158', '5.80', '30.86', '0.93', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pasta with Meat Sauce', '', 'Pasta','1274', 'g', '1', 'portion', ' 1643', '101.03', '166.51', '65.23', ' 1643', '101.03', '166.51', '65.23', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Pasta with Tomato Sauce', '', 'Pasta','2068', 'g', '1', 'portion', ' 1716', '63.06', '346.54', '9.72', ' 1716', '63.06', '346.54', '9.72', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fresh Pasta (Cooked)', '', 'Pasta','100', 'g', '1', 'portion', ' 131', '5.15', '24.93', '1.05', ' 131', '5.15', '24.93', '1.05', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Macaroni', '', 'Pasta','101', 'g', '1', 'portion', ' 158', '5.80', '30.86', '0.93', ' 158', '5.80', '30.86', '0.93', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fettuccine', '', 'Pasta','101', 'g', '1', 'portion', ' 158', '5.80', '30.86', '0.93', ' 158', '5.80', '30.86', '0.93', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pasta with Cheese and Meat Sauce', '', 'Pasta','835', 'g', '1', 'portion', ' 1244', '68.14', '108.39', '58.62', ' 1244', '68.14', '108.39', '58.62', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pasta with Vegetables', '', 'Pasta','149', 'g', '1', 'portion', ' 186', '6.72', '34.67', '2.21', ' 186', '6.72', '34.67', '2.21', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fettuccine Alfredo', '', 'Pasta','373', 'g', '1', 'portion', ' 774', '30.31', '89.78', '32.00', ' 774', '30.31', '89.78', '32.00', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rigatoni', '', 'Pasta','101', 'g', '1', 'portion', ' 158', '5.80', '30.86', '0.93', ' 158', '5.80', '30.86', '0.93', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Pasta with Cheese and Tomato Sauce', '', 'Pasta','2124', 'g', '1', 'portion', ' 1954', '78.17', '347.30', '29.74', ' 1954', '78.17', '347.30', '29.74', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Linguine', '', 'Pasta','101', 'g', '1', 'portion', ' 158', '5.80', '30.86', '0.93', ' 158', '5.80', '30.86', '0.93', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Whole Wheat Spaghetti', '', 'Pasta','101', 'g', '1', 'portion', ' 124', '5.33', '26.54', '0.54', ' 124', '5.33', '26.54', '0.54', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Macaroni (Cooked)', '', 'Pasta','100', 'g', '1', 'portion', ' 158', '5.80', '30.86', '0.93', ' 158', '5.80', '30.86', '0.93', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pasta with Pesto Sauce', '', 'Pasta','526', 'g', '1', 'portion', ' 1656', '48.58', '123.51', '110.58', ' 1656', '48.58', '123.51', '110.58', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pasta (Made with Egg, Cooked)', '', 'Pasta','100', 'g', '1', 'portion', ' 130', '5.28', '23.54', '1.74', ' 130', '5.28', '23.54', '1.74', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Spaghetti with Tomato Sauce and Vegetables', '', 'Pasta','296', 'g', '1', 'portion', ' 299', '10.55', '54.75', '4.68', ' 299', '10.55', '54.75', '4.68', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Potato Gnocchi', '', 'Pasta','658', 'g', '1', 'portion', ' 876', '15.54', '112.20', '41.09', ' 876', '15.54', '112.20', '41.09', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Macaroni or Noodles with Cheese', '', 'Pasta','1440', 'g', '1', 'portion', ' 2922', '114.31', '308.95', '135.33', ' 2922', '114.31', '308.95', '135.33', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Lasagna', '', 'Pasta','2954', 'g', '1', 'portion', ' 4342', '229.21', '566.52', '131.44', ' 4342', '229.21', '566.52', '131.44', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Whole Wheat Pasta', '', 'Pasta','100', 'g', '1', 'portion', ' 348', '14.63', '75.03', '1.40', ' 348', '14.63', '75.03', '1.40', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Whole Wheat Macaroni (Fat Not Added in Cooking)', '', 'Pasta','101', 'g', '1', 'portion', ' 124', '5.33', '26.54', '0.54', ' 124', '5.33', '26.54', '0.54', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Low Fat Grilled Chicken Pasta', '', 'Pasta','1 servin', 'g', '1', 'portion', ' 875', '64.00', '134.00', '9.00', ' 875', '64.00', '134.00', '9.00', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Whole Wheat Spaghetti (Cooked)', '', 'Pasta','100', 'g', '1', 'portion', ' 124', '5.33', '26.54', '0.54', ' 124', '5.33', '26.54', '0.54', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Flavored Pasta', '', 'Pasta','636', 'g', '1', 'portion', ' 725', '23.59', '91.68', '28.93', ' 725', '23.59', '91.68', '28.93', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cheese Ravioli with Basil Tomato Sauce', '', 'Pasta','1 packa', 'g', '1', 'portion', ' 220', '11.00', '30.00', '7.00', ' 220', '11.00', '30.00', '7.00', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Spinach Macaroni', '', 'Pasta','275', 'g', '1', 'portion', ' 371', '13.35', '74.80', '1.57', ' 371', '13.35', '74.80', '1.57', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Low Fat Garlic Chicken Pasta', '', 'Pasta','1 servin', 'g', '1', 'portion', ' 530', '34.00', '76.00', '10.50', ' 530', '34.00', '76.00', '10.50', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Spaghetti (Without Added Salt, Cooked)', '', 'Pasta','100', 'g', '1', 'portion', ' 158', '5.80', '30.86', '0.93', ' 158', '5.80', '30.86', '0.93', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Spaghetti with Meatballs (Canned)', '', 'Pasta','100', 'g', '1', 'portion', ' 107', '4.17', '11.11', '5.10', ' 107', '4.17', '11.11', '5.10', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Whole Wheat Pasta with Tomato Sauce', '', 'Pasta','3549', 'g', '1', 'portion', ' 3690', '144.42', '756.19', '44.36', ' 3690', '144.42', '756.19', '44.36', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cheese Manicotti', '', 'Pasta','1 servin', 'g', '1', 'portion', ' 270', '13.00', '30.00', '11.00', ' 270', '13.00', '30.00', '11.00', '1', 'barcode', '32', '', '' , '',' ', '', ''");
// =========FOODS RICE ============
    setupInsertToFood(  " NULL, 'White Rice', '', 'Rice','160', 'g', '1', 'portion', ' 206', '4.24', '44.50', '0.45', ' 206', '4.24', '44.50', '0.45', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Brown Rice', '', 'Rice','197', 'g', '1', 'portion', ' 216', '5.03', '44.76', '1.75', ' 216', '5.03', '44.76', '1.75', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cooked Rice', '', 'Rice','100', 'g', '1', 'portion', ' 135', '2.64', '27.64', '1.07', ' 135', '2.64', '27.64', '1.07', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Spanish Rice', '', 'Rice','883', 'g', '1', 'portion', ' 768', '16.95', '147.80', '13.24', ' 768', '16.95', '147.80', '13.24', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rice with Vegetables', '', 'Rice','162', 'g', '1', 'portion', ' 161', '4.12', '31.06', '2.22', ' 161', '4.12', '31.06', '2.22', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Yellow Rice', '', 'Rice','630', 'g', '1', 'portion', ' 598', '11.90', '131.37', '1.07', ' 598', '11.90', '131.37', '1.07', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'White Rice (Long-Grain, Cooked)', '', 'Rice','100', 'g', '1', 'portion', ' 130', '2.69', '28.17', '0.28', ' 130', '2.69', '28.17', '0.28', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Flavored Rice Mixture', '', 'Rice','907', 'g', '1', 'portion', ' 1152', '17.59', '183.80', '36.54', ' 1152', '17.59', '183.80', '36.54', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Mexican Rice', '', 'Rice','918', 'g', '1', 'portion', ' 753', '12.64', '107.93', '31.64', ' 753', '12.64', '107.93', '31.64', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Brown and Wild Rice', '', 'Rice','725', 'g', '1', 'portion', ' 820', '17.05', '145.45', '18.93', ' 820', '17.05', '145.45', '18.93', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fried Rice', '', 'Rice','1023', 'g', '1', 'portion', ' 1719', '64.45', '215.44', '63.73', ' 1719', '64.45', '215.44', '63.73', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rice Pilaf', '', 'Rice','812', 'g', '1', 'portion', ' 1016', '16.82', '175.24', '26.32', ' 1016', '16.82', '175.24', '26.32', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Instant White Rice', '', 'Rice','167', 'g', '1', 'portion', ' 193', '3.60', '41.41', '0.83', ' 193', '3.60', '41.41', '0.83', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'White Rice (Medium-Grain, Cooked)', '', 'Rice','100', 'g', '1', 'portion', ' 130', '2.38', '28.59', '0.21', ' 130', '2.38', '28.59', '0.21', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Steamed Rice', '', 'Rice','166', 'g', '1', 'portion', ' 214', '4.44', '46.48', '0.46', ' 214', '4.44', '46.48', '0.46', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Yellow Rice (Fat Added in Cooking)', '', 'Rice','644', 'g', '1', 'portion', ' 708', '11.98', '131.67', '13.39', ' 708', '11.98', '131.67', '13.39', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rice with Beans', '', 'Rice','358', 'g', '1', 'portion', ' 588', '21.71', '89.79', '15.98', ' 588', '21.71', '89.79', '15.98', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rice (Fat Added in Cooking)', '', 'Rice','164', 'g', '1', 'portion', ' 238', '4.25', '44.61', '4.17', ' 238', '4.25', '44.61', '4.17', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rice with Milk', '', 'Rice','923', 'g', '1', 'portion', ' 1311', '46.98', '229.64', '20.03', ' 1311', '46.98', '229.64', '20.03', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'White and Wild Rice', '', 'Rice','725', 'g', '1', 'portion', ' 812', '15.74', '149.72', '15.38', ' 812', '15.74', '149.72', '15.38', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Instant White Rice (Fat Added in Cooking)', '', 'Rice','171', 'g', '1', 'portion', ' 226', '3.61', '41.51', '4.56', ' 226', '3.61', '41.51', '4.56', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chinese Fried Rice', '', 'Rice','1023', 'g', '1', 'portion', ' 1546', '58.03', '193.87', '57.38', ' 1546', '58.03', '193.87', '57.38', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Brown Rice (Fat Added in Cooking)', '', 'Rice','201', 'g', '1', 'portion', ' 250', '5.03', '44.87', '5.47', ' 250', '5.03', '44.87', '5.47', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Puerto Rican Style Stewed Rice (Arroz Quisado)', '', 'Rice','1088', 'g', '1', 'portion', ' 2350', '42.87', '350.92', '82.26', ' 2350', '42.87', '350.92', '82.26', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Puffed Rice', '', 'Rice','100', 'g', '1', 'portion', ' 383', '7.00', '87.77', '0.90', ' 383', '7.00', '87.77', '0.90', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'White Rice (Long-Grain, with Salt, Enriched, Cooked)', '', 'Rice','100', 'g', '1', 'portion', ' 130', '2.69', '28.17', '0.28', ' 130', '2.69', '28.17', '0.28', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Brown and Wild Rice (Fat Added in Cooking)', '', 'Rice','725', 'g', '1', 'portion', ' 820', '17.05', '145.45', '18.93', ' 820', '17.05', '145.45', '18.93', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Brown Rice (Medium-Grain)', '', 'Rice','100', 'g', '1', 'portion', ' 362', '7.50', '76.17', '2.68', ' 362', '7.50', '76.17', '2.68', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pork Fried Rice', '', 'Rice','1011', 'g', '1', 'portion', ' 1708', '60.96', '214.11', '65.71', ' 1708', '60.96', '214.11', '65.71', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'White Rice (Medium-Grain, Enriched)', '', 'Rice','100', 'g', '1', 'portion', ' 360', '6.61', '79.34', '0.58', ' 360', '6.61', '79.34', '0.58', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Instant Brown Rice (Fat Added in Cooking)', '', 'Rice','201', 'g', '1', 'portion', ' 250', '5.03', '44.87', '5.47', ' 250', '5.03', '44.87', '5.47', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'White Rice (Short-Grain, Cooked)', '', 'Rice','100', 'g', '1', 'portion', ' 130', '2.36', '28.73', '0.19', ' 130', '2.36', '28.73', '0.19', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dirty Rice', '', 'Rice','1170', 'g', '1', 'portion', ' 1719', '66.20', '225.16', '57.20', ' 1719', '66.20', '225.16', '57.20', '1', 'barcode', '33', '', '' , '',' ', '', ''");
// =========FOODS TACO ============
    setupInsertToFood(  " NULL, 'Taco or Tostada with Beef, Cheese and Lettuce', '', 'Taco','78', 'g', '1', 'portion', ' 221', '10.88', '16.20', '12.65', ' 221', '10.88', '16.20', '12.65', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soft Taco with Beef, Cheese, Lettuce, Tomato and Sour Cream', '', 'Taco','100', 'g', '1', 'portion', ' 246', '11.87', '19.37', '13.23', ' 246', '11.87', '19.37', '13.23', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco or Tostada with Beef, Cheese, Lettuce, Tomato and Salsa', '', 'Taco','76', 'g', '1', 'portion', ' 158', '8.83', '10.01', '9.36', ' 158', '8.83', '10.01', '9.36', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soft Taco with Beef, Cheese and Lettuce', '', 'Taco','71', 'g', '1', 'portion', ' 199', '10.44', '18.26', '9.03', ' 199', '10.44', '18.26', '9.03', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco or Tostada with Beef, Lettuce, Tomato and Salsa', '', 'Taco','69', 'g', '1', 'portion', ' 130', '7.07', '9.92', '7.03', ' 130', '7.07', '9.92', '7.03', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco or Tostada with Chicken, Cheese, Lettuce, Tomato and Salsa', '', 'Taco','80', 'g', '1', 'portion', ' 145', '10.28', '10.01', '7.16', ' 145', '10.28', '10.01', '7.16', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soft Taco with Beef, Cheese, Lettuce, Tomato and Salsa', '', 'Taco','102', 'g', '1', 'portion', ' 220', '11.66', '19.73', '10.25', ' 220', '11.66', '19.73', '10.25', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco Meat', '', 'Taco','514', 'g', '1', 'portion', ' 895', '100.64', '2.80', '50.57', ' 895', '100.64', '2.80', '50.57', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco or Tostada with Chicken or Turkey, Lettuce, Tomato and Salsa', '', 'Taco','73', 'g', '1', 'portion', ' 116', '8.53', '9.92', '4.83', ' 116', '8.53', '9.92', '4.83', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco', '', 'Taco','100', 'g', '1', 'portion', ' 216', '12.08', '15.63', '12.02', ' 216', '12.08', '15.63', '12.02', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soft Taco with Chicken, Cheese and Lettuce', '', 'Taco','128', 'g', '1', 'portion', ' 247', '22.08', '18.70', '8.76', ' 247', '22.08', '18.70', '8.76', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco or Tostada with Beans, Cheese, Meat, Lettuce, Tomato and Salsa', '', 'Taco','86', 'g', '1', 'portion', ' 156', '8.41', '12.99', '8.13', ' 156', '8.41', '12.99', '8.13', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco Shells (Baked)', '', 'Taco','100', 'g', '1', 'portion', ' 468', '7.20', '62.40', '22.60', ' 468', '7.20', '62.40', '22.60', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef Taco with Cheese, Tomato and Taco Sauce', '', 'Taco','68', 'g', '1', 'portion', ' 124', '8.94', '4.16', '7.56', ' 124', '8.94', '4.16', '7.56', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco or Tostada with Fish, Lettuce, Tomato and Salsa', '', 'Taco','77', 'g', '1', 'portion', ' 99', '7.50', '9.92', '3.45', ' 99', '7.50', '9.92', '3.45', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco Salad', '', 'Taco','100', 'g', '1', 'portion', ' 141', '6.68', '11.91', '7.46', ' 141', '6.68', '11.91', '7.46', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Taco or Tostada with Beans, Lettuce, Tomato and Salsa', '', 'Taco','94', 'g', '1', 'portion', ' 138', '4.34', '18.85', '5.53', ' 138', '4.34', '18.85', '5.53', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco Bake', '', 'Taco','1589', 'g', '1', 'portion', ' 2783', '163.03', '148.22', '174.90', ' 2783', '163.03', '148.22', '174.90', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Complete Meals - Cheesy Beef Taco', '', 'Taco','1/5 packa', 'g', '1', 'portion', ' 220', '6.00', '35.00', '4.50', ' 220', '6.00', '35.00', '4.50', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Crispy Chicken Crisper Tacos', '', 'Taco','1 servin', 'g', '1', 'portion', ' 1500', '59.00', '151.00', '74.00', ' 1500', '59.00', '151.00', '74.00', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Taco or Tostada with Beans and Cheese, Lettuce, Tomato and Salsa', '', 'Taco','101', 'g', '1', 'portion', ' 166', '6.10', '18.94', '7.88', ' 166', '6.10', '18.94', '7.88', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco Salad', '', 'Taco','1 servin', 'g', '1', 'portion', ' 833', '33.00', '55.00', '56.00', ' 833', '33.00', '55.00', '56.00', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco or Tostada Salad with Beef, Beans and Cheese in Fried Flour Tortilla', '', 'Taco','278', 'g', '1', 'portion', ' 484', '21.71', '33.50', '29.89', ' 484', '21.71', '33.50', '29.89', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco Shells (Without Added Salt, Baked)', '', 'Taco','100', 'g', '1', 'portion', ' 468', '7.20', '62.40', '22.60', ' 468', '7.20', '62.40', '22.60', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco Meat', '', 'Taco','1 servin', 'g', '1', 'portion', ' 200', '13.00', '2.00', '13.00', ' 200', '13.00', '2.00', '13.00', '1', 'barcode', '34', '', '' , '',' ', '', ''");
// =========FOODS CREAM CHEESE ============
    setupInsertToFood(  " NULL, 'Cream Cheese', '', 'Cream cheese','100', 'g', '1', 'portion', ' 349', '7.55', '2.66', '34.87', ' 349', '7.55', '2.66', '34.87', '1', 'barcode', '36', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Light or Lite Cream Cheese', '', 'Cream cheese','100', 'g', '1', 'portion', ' 231', '10.60', '7.00', '17.60', ' 231', '10.60', '7.00', '17.60', '1', 'barcode', '36', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cream Cheese', '', 'Cream cheese','100', 'g', '1', 'portion', ' 349', '7.55', '2.66', '34.87', ' 349', '7.55', '2.66', '34.87', '1', 'barcode', '36', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Regular Cream Cheese  Spread', '', 'Cream cheese','100', 'g', '1', 'portion', ' 295', '7.10', '3.50', '28.60', ' 295', '7.10', '3.50', '28.60', '1', 'barcode', '36', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Nonfat or Fat Free Processed Cream Cheese', '', 'Cream cheese','100', 'g', '1', 'portion', ' 96', '14.41', '5.80', '1.36', ' 96', '14.41', '5.80', '1.36', '1', 'barcode', '36', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Reduced Fat Vegetable Cream Cheese', '', 'Cream cheese','1 servin', 'g', '1', 'portion', ' 60', '1.00', '3.00', '5.00', ' 60', '1.00', '3.00', '5.00', '1', 'barcode', '36', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cream Cheese Dip', '', 'Cream cheese','216', 'g', '1', 'portion', ' 766', '13.55', '7.42', '77.19', ' 766', '13.55', '7.42', '77.19', '1', 'barcode', '36', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Reduced Fat Hazelnut Cream Cheese Spread', '', 'Cream cheese','1 servin', 'g', '1', 'portion', ' 140', '5.00', '6.00', '11.00', ' 140', '5.00', '6.00', '11.00', '1', 'barcode', '36', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Garden Vegetable Cream Cheese', '', 'Cream cheese','1 servin', 'g', '1', 'portion', ' 170', '2.00', '4.00', '15.00', ' 170', '2.00', '4.00', '15.00', '1', 'barcode', '36', '', '' , '',' ', '', ''");
// =========FOODS COLD MEATS ============
    setupInsertToFood(  " NULL, 'Homemade-Style Spaghetti Sauce with combination of Meats', '', 'Cold meats','503', 'g', '1', 'portion', ' 574', '35.19', '38.56', '33.22', ' 574', '35.19', '38.56', '33.22', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sausage (Not Cold Cut)', '', 'Cold meats','100', 'g', '1', 'portion', ' 339', '19.43', '0.00', '28.36', ' 339', '19.43', '0.00', '28.36', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cold Cut', '', 'Cold meats','100', 'g', '1', 'portion', ' 208', '14.63', '3.60', '14.66', ' 208', '14.63', '3.60', '14.66', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Puerto Rican Style Stewed Variety Meats (Gandinga)', '', 'Cold meats','1710', 'g', '1', 'portion', ' 1710', '238.67', '71.81', '50.78', ' 1710', '238.67', '71.81', '50.78', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola with Chocolate Flavor', '', 'Cold meats','100', 'g', '1', 'portion', ' 37', '0.07', '9.56', '0.02', ' 37', '0.07', '9.56', '0.02', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rum and Cola', '', 'Cold meats','212', 'g', '1', 'portion', ' 155', '0.17', '15.39', '0.11', ' 155', '0.17', '15.39', '0.11', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baked or Broiled Cod', '', 'Cold meats','972', 'g', '1', 'portion', ' 1186', '203.22', '3.99', '34.89', ' 1186', '203.22', '3.99', '34.89', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola with Fruit or Vanilla Flavor', '', 'Cold meats','100', 'g', '1', 'portion', ' 37', '0.07', '9.56', '0.02', ' 37', '0.07', '9.56', '0.02', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat with Gravy', '', 'Cold meats','90', 'g', '1', 'portion', ' 109', '14.99', '2.59', '3.85', ' 109', '14.99', '2.59', '3.85', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef or Meat Gravy', '', 'Cold meats','100', 'g', '1', 'portion', ' 53', '3.75', '4.81', '2.36', ' 53', '3.75', '4.81', '2.36', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Refried Beans with Meat', '', 'Cold meats','460', 'g', '1', 'portion', ' 888', '35.60', '74.80', '50.60', ' 888', '35.60', '74.80', '50.60', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Tamale with Meat', '', 'Cold meats','2004', 'g', '1', 'portion', ' 4029', '175.38', '316.88', '230.70', ' 4029', '175.38', '316.88', '230.70', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat Filled Pupusa', '', 'Cold meats','2162', 'g', '1', 'portion', ' 3935', '177.28', '538.54', '126.26', ' 3935', '177.28', '538.54', '126.26', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Italian Pie with Meat', '', 'Cold meats','1418', 'g', '1', 'portion', ' 4197', '158.24', '513.86', '164.76', ' 4197', '158.24', '513.86', '164.76', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat and Cheese Turnover', '', 'Cold meats','415', 'g', '1', 'portion', ' 1549', '47.59', '106.89', '102.61', ' 1549', '47.59', '106.89', '102.61', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat and Vegetable Turnover', '', 'Cold meats','490', 'g', '1', 'portion', ' 1495', '52.40', '112.63', '92.29', ' 1495', '52.40', '112.63', '92.29', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat Filled Ravioli', '', 'Cold meats','438', 'g', '1', 'portion', ' 836', '55.09', '76.02', '32.53', ' 836', '55.09', '76.02', '32.53', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat Filled Tortellini', '', 'Cold meats','436', 'g', '1', 'portion', ' 841', '55.09', '75.66', '33.34', ' 841', '55.09', '75.66', '33.34', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pasta with Meat Sauce', '', 'Cold meats','1274', 'g', '1', 'portion', ' 1643', '101.03', '166.51', '65.23', ' 1643', '101.03', '166.51', '65.23', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Light Turkey Meat (Skin Eaten)', '', 'Cold meats','100', 'g', '1', 'portion', ' 197', '28.57', '0.00', '8.34', ' 197', '28.57', '0.00', '8.34', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat with Tomato-Based Sauce (Mixture)', '', 'Cold meats','298', 'g', '1', 'portion', ' 435', '39.43', '18.79', '21.30', ' 435', '39.43', '18.79', '21.30', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat Loaf Made with Venison/Deer', '', 'Cold meats','1017', 'g', '1', 'portion', ' 1678', '192.20', '62.85', '68.13', ' 1678', '192.20', '62.85', '68.13', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fat Free Beef or Meat Gravy', '', 'Cold meats','1061', 'g', '1', 'portion', ' 435', '10.61', '70.27', '12.42', ' 435', '10.61', '70.27', '12.42', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dim Sum (Meat Filled Egg Roll-Type)', '', 'Cold meats','100', 'g', '1', 'portion', ' 112', '11.55', '9.56', '2.64', ' 112', '11.55', '9.56', '2.64', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Quiche with Meat, Poultry or Fish', '', 'Cold meats','927', 'g', '1', 'portion', ' 2744', '79.83', '132.02', '211.66', ' 2744', '79.83', '132.02', '211.66', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Lower in Fat Meat and Cheese Turnover', '', 'Cold meats','100', 'g', '1', 'portion', ' 228', '10.42', '33.26', '5.56', ' 228', '10.42', '33.26', '5.56', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Whole Wheat Lasagna Noodles with Meat', '', 'Cold meats','3294', 'g', '1', 'portion', ' 4941', '320.83', '505.94', '197.63', ' 4941', '320.83', '505.94', '197.63', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cheese Filled Stuffed Shells with Meat Sauce', '', 'Cold meats','1705', 'g', '1', 'portion', ' 2762', '159.58', '261.02', '119.00', ' 2762', '159.58', '261.02', '119.00', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat Filled Tortellini with Tomato Sauce', '', 'Cold meats','1136', 'g', '1', 'portion', ' 1557', '76.37', '182.39', '57.62', ' 1557', '76.37', '182.39', '57.62', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat Filled Tortellini with Tomato Sauce (Canned)', '', 'Cold meats','100', 'g', '1', 'portion', ' 91', '3.58', '15.24', '1.90', ' 91', '3.58', '15.24', '1.90', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef Stew Meat (Lean and Fat Eaten)', '', 'Cold meats','101', 'g', '1', 'portion', ' 306', '28.64', '0.00', '20.31', ' 306', '28.64', '0.00', '20.31', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baked or Fried Breaded Light Turkey Meat', '', 'Cold meats','100', 'g', '1', 'portion', ' 222', '26.72', '6.40', '9.11', ' 222', '26.72', '6.40', '9.11', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Roasted Light Turkey Meat (Skin Not Eaten)', '', 'Cold meats','100', 'g', '1', 'portion', ' 157', '29.91', '0.00', '3.22', ' 157', '29.91', '0.00', '3.22', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Roasted Light Turkey Meat (Skin Eaten)', '', 'Cold meats','100', 'g', '1', 'portion', ' 197', '28.57', '0.00', '8.34', ' 197', '28.57', '0.00', '8.34', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Whole Wheat Pasta with Meat Sauce', '', 'Cold meats','3889', 'g', '1', 'portion', ' 4628', '234.88', '756.35', '105.00', ' 4628', '234.88', '756.35', '105.00', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Macaroni or Pasta Salad with Crab Meat', '', 'Cold meats','746', 'g', '1', 'portion', ' 1402', '44.76', '148.23', '70.35', ' 1402', '44.76', '148.23', '70.35', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Stuffed Pepper with Rice and Meat', '', 'Cold meats','1369', 'g', '1', 'portion', ' 1916', '108.25', '114.82', '110.16', ' 1916', '108.25', '114.82', '110.16', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cod', '', 'Cold meats','1086', 'g', '1', 'portion', ' 2292', '208.60', '89.63', '117.77', ' 2292', '208.60', '89.63', '117.77', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Puerto Rican Style Beef Stew, Meat with Gravy', '', 'Cold meats','1112', 'g', '1', 'portion', ' 1858', '159.40', '12.35', '126.36', ' 1858', '159.40', '12.35', '126.36', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Hamburger with 1/4 Lb Meat on Bun', '', 'Cold meats','127', 'g', '1', 'portion', ' 372', '23.09', '25.72', '18.80', ' 372', '23.09', '25.72', '18.80', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Steamed Dumpling (Filled with Meat Poultry or Seafood)', '', 'Cold meats','819', 'g', '1', 'portion', ' 918', '94.63', '78.32', '21.63', ' 918', '94.63', '78.32', '21.63', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fried Battered Light or Dark Turkey Meat (Skin Eaten)', '', 'Cold meats','100', 'g', '1', 'portion', ' 283', '14.00', '15.70', '18.00', ' 283', '14.00', '15.70', '18.00', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Yat Ga Mein with Meat, Fish or Poultry', '', 'Cold meats','933', 'g', '1', 'portion', ' 1139', '65.34', '113.50', '45.08', ' 1139', '65.34', '113.50', '45.08', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat, Poultry or Fish, Vegetables and Rice Wrap Sandwich', '', 'Cold meats','446', 'g', '1', 'portion', ' 829', '41.81', '104.13', '26.43', ' 829', '41.81', '104.13', '26.43', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Puerto Rican Style Stuffed Pot Roast (Larded Meat) (Carne Mechada Con Papas Boliche)', '', 'Cold meats','2659', 'g', '1', 'portion', ' 9387', '643.55', '207.96', '648.07', ' 9387', '643.55', '207.96', '648.07', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cheeseburger with 1/4 Lb Meat and Mushrooms in Sauce on Bun', '', 'Cold meats','226', 'g', '1', 'portion', ' 520', '30.74', '32.28', '29.18', ' 520', '30.74', '32.28', '29.18', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Salisbury Steak with Gravy, Potatoes, Vegetable and Dessert (Frozen Meal, Large Meat)', '', 'Cold meats','475', 'g', '1', 'portion', ' 793', '52.94', '68.04', '35.47', ' 793', '52.94', '68.04', '35.47', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Puerto Rican Style Stuffed Cabbage with Meat (Repollo Relleno Con Carne)', '', 'Cold meats','1544', 'g', '1', 'portion', ' 3459', '171.55', '120.28', '261.26', ' 3459', '171.55', '120.28', '261.26', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Reduced Fat and Sodium Lasagna with Cheese and Meat Sauce (Diet Frozen Meal)', '', 'Cold meats','104', 'g', '1', 'portion', ' 120', '6.51', '17.04', '2.92', ' 120', '6.51', '17.04', '2.92', '1', 'barcode', '38', '', '' , '',' ', '', ''");
// =========FOODS SWEET SPREADS ============
    setupInsertToFood(  " NULL, 'Sweet Island Classics Kona Coffee Glazed, Milk Chocolate and Milk Chocolate Toffee Macadamias', '', 'Sweet spreads','1 servin', 'g', '1', 'portion', ' 240', '3.00', '20.00', '18.00', ' 240', '3.00', '20.00', '18.00', '1', 'barcode', '39', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dark Chocolate Chip Crepes with Pork Sausage and Sweet Potato Hash', '', 'Sweet spreads','1 packa', 'g', '1', 'portion', ' 340', '20.00', '31.00', '15.00', ' 340', '20.00', '31.00', '15.00', '1', 'barcode', '39', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Turkey Breast Medallions in a Cranberry Relish with Sweet Potato Casserole', '', 'Sweet spreads','1 packa', 'g', '1', 'portion', ' 460', '19.00', '64.00', '14.00', ' 460', '19.00', '64.00', '14.00', '1', 'barcode', '39', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Red Pepper Coulis Chicken w/ Broccoli Mash & Sweet Potato Provencal (Standard)', '', 'Sweet spreads','1 servin', 'g', '1', 'portion', ' 449', '51.00', '40.00', '14.00', ' 449', '51.00', '40.00', '14.00', '1', 'barcode', '39', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Signature Sautes - Herb Saute Honey Roasted Turkey Breast & Roasted Sweet Potatoes', '', 'Sweet spreads','1/2 packa', 'g', '1', 'portion', ' 340', '20.00', '32.00', '15.00', ' 340', '20.00', '32.00', '15.00', '1', 'barcode', '39', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sweet and Spicy Chunk Light Tuna in Oil with Peppers', '', 'Sweet spreads','1 servin', 'g', '1', 'portion', ' 90', '5.00', '6.00', '5.00', ' 90', '5.00', '6.00', '5.00', '1', 'barcode', '39', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Athlete BBQ Mango Shredded Beef with Roasted Sweet Potatoes (Medium)', '', 'Sweet spreads','1 packa', 'g', '1', 'portion', ' 490', '42.00', '45.00', '16.00', ' 490', '42.00', '45.00', '16.00', '1', 'barcode', '39', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Braised Beef Panang Curry with Jasmine Rice and Sweet Peas', '', 'Sweet spreads','1 servin', 'g', '1', 'portion', ' 920', '36.00', '81.00', '49.00', ' 920', '36.00', '81.00', '49.00', '1', 'barcode', '39', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Raisin Bran Sweet Raisins, Perfectly Balanced with Tasty Bran Flakes', '', 'Sweet spreads','1 servin', 'g', '1', 'portion', ' 180', '5.00', '46.00', '1.50', ' 180', '5.00', '46.00', '1.50', '1', 'barcode', '39', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Super Ostrim Beef, Ostrich & Vegetable Protein Nuggets - Sweet Pepper', '', 'Sweet spreads','1 packa', 'g', '1', 'portion', ' 230', '40.00', '8.00', '4.00', ' 230', '40.00', '8.00', '4.00', '1', 'barcode', '39', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Nekot Cookies Sweet \\0n Creamy Peanut Butter (4 cookies)', '', 'Sweet spreads','1 packa', 'g', '1', 'portion', ' 160', '3.00', '22.00', '7.00', ' 160', '3.00', '22.00', '7.00', '1', 'barcode', '39', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Mini Cinnamon Sweet Potato Pancakes with Apple Cinnamon Compote', '', 'Sweet spreads','1 packa', 'g', '1', 'portion', ' 285', '19.00', '32.00', '9.00', ' 285', '19.00', '32.00', '9.00', '1', 'barcode', '39', '', '' , '',' ', '', ''");
// =========FOODS JAM ============
    setupInsertToFood(  " NULL, 'Jam Preserves', '', 'Jam','100', 'g', '1', 'portion', ' 260', '0.54', '66.63', '0.14', ' 260', '0.54', '66.63', '0.14', '1', 'barcode', '40', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Jams and Preserves', '', 'Jam','100', 'g', '1', 'portion', ' 278', '0.37', '68.86', '0.07', ' 278', '0.37', '68.86', '0.07', '1', 'barcode', '40', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Reduced Sugar Jelly', '', 'Jam','100', 'g', '1', 'portion', ' 179', '0.30', '46.10', '0.03', ' 179', '0.30', '46.10', '0.03', '1', 'barcode', '40', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ham', '', 'Jam','1 servin', 'g', '1', 'portion', ' 100', '18.00', '0.00', '4.00', ' 100', '18.00', '0.00', '4.00', '1', 'barcode', '40', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Orange Marmalade', '', 'Jam','100', 'g', '1', 'portion', ' 246', '0.30', '66.30', '0.00', ' 246', '0.30', '66.30', '0.00', '1', 'barcode', '40', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Jambalaya with Meat and Rice', '', 'Jam','2232', 'g', '1', 'portion', ' 3594', '238.86', '207.83', '193.99', ' 3594', '238.86', '207.83', '193.99', '1', 'barcode', '40', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Marmalade', '', 'Jam','100', 'g', '1', 'portion', ' 246', '0.30', '66.30', '0.00', ' 246', '0.30', '66.30', '0.00', '1', 'barcode', '40', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Jelly (All Flavors)', '', 'Jam','100', 'g', '1', 'portion', ' 266', '0.15', '69.95', '0.02', ' 266', '0.15', '69.95', '0.02', '1', 'barcode', '40', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Strawberry Preserves', '', 'Jam','1 servin', 'g', '1', 'portion', ' 35', '0.00', '9.00', '0.00', ' 35', '0.00', '9.00', '0.00', '1', 'barcode', '40', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Grape Jam', '', 'Jam','1 servin', 'g', '1', 'portion', ' 35', '0.00', '9.00', '0.00', ' 35', '0.00', '9.00', '0.00', '1', 'barcode', '40', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ham', '', 'Jam','1 servin', 'g', '1', 'portion', ' 70', '10.00', '1.00', '3.00', ' 70', '10.00', '1.00', '3.00', '1', 'barcode', '40', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Strawberry Jam', '', 'Jam','1 packa', 'g', '1', 'portion', ' 40', '0.00', '10.00', '0.00', ' 40', '0.00', '10.00', '0.00', '1', 'barcode', '40', '', '' , '',' ', '', ''");
// =========FOODS NUTS ============
    setupInsertToFood(  " NULL, 'Walnuts', '', 'Nuts','100', 'g', '1', 'portion', ' 654', '15.23', '13.71', '65.21', ' 654', '15.23', '13.71', '65.21', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Natural Walnuts & Almonds', '', 'Nuts','1 packa', 'g', '1', 'portion', ' 100', '3.00', '3.00', '9.00', ' 100', '3.00', '3.00', '9.00', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Almonds', '', 'Nuts','100', 'g', '1', 'portion', ' 578', '21.26', '19.74', '50.64', ' 578', '21.26', '19.74', '50.64', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cashew Nuts', '', 'Nuts','100', 'g', '1', 'portion', ' 553', '18.22', '30.19', '43.85', ' 553', '18.22', '30.19', '43.85', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pistachio Nuts', '', 'Nuts','100', 'g', '1', 'portion', ' 557', '20.61', '27.97', '44.44', ' 557', '20.61', '27.97', '44.44', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Peanuts', '', 'Nuts','100', 'g', '1', 'portion', ' 599', '28.03', '15.26', '52.50', ' 599', '28.03', '15.26', '52.50', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Almonds', '', 'Nuts','100', 'g', '1', 'portion', ' 578', '21.26', '19.74', '50.64', ' 578', '21.26', '19.74', '50.64', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Hazelnuts Filberts', '', 'Nuts','100', 'g', '1', 'portion', ' 628', '14.95', '16.70', '60.75', ' 628', '14.95', '16.70', '60.75', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pecan Nuts', '', 'Nuts','100', 'g', '1', 'portion', ' 691', '9.17', '13.86', '71.97', ' 691', '9.17', '13.86', '71.97', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Mixed Nuts', '', 'Nuts','100', 'g', '1', 'portion', ' 617', '16.51', '21.58', '56.30', ' 617', '16.51', '21.58', '56.30', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Nut Mixture with Seeds', '', 'Nuts','100', 'g', '1', 'portion', ' 520', '18.93', '38.02', '35.47', ' 520', '18.93', '38.02', '35.47', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pistachio Nuts', '', 'Nuts','100', 'g', '1', 'portion', ' 569', '21.35', '27.00', '45.97', ' 569', '21.35', '27.00', '45.97', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Roasted Mixed Nuts with Peanuts', '', 'Nuts','100', 'g', '1', 'portion', ' 617', '16.76', '21.41', '56.33', ' 617', '16.76', '21.41', '56.33', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Macadamia Nuts', '', 'Nuts','100', 'g', '1', 'portion', ' 718', '7.91', '13.82', '75.77', ' 718', '7.91', '13.82', '75.77', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'NUT-rition Lightly Salted Cashews, Peanuts, Almonds, Pecans & Hazelnuts', '', 'Nuts','1 packa', 'g', '1', 'portion', ' 260', '9.00', '8.00', '23.00', ' 260', '9.00', '8.00', '23.00', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Roasted Mixed Nuts', '', 'Nuts','100', 'g', '1', 'portion', ' 615', '15.52', '22.27', '56.17', ' 615', '15.52', '22.27', '56.17', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Brazil Nuts', '', 'Nuts','100', 'g', '1', 'portion', ' 656', '14.32', '12.27', '66.43', ' 656', '14.32', '12.27', '66.43', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dried Chinese Chestnuts', '', 'Nuts','100', 'g', '1', 'portion', ' 363', '6.82', '79.76', '1.81', ' 363', '6.82', '79.76', '1.81', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Unblanched Dried Brazilnuts', '', 'Nuts','100', 'g', '1', 'portion', ' 656', '14.32', '12.27', '66.43', ' 656', '14.32', '12.27', '66.43', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dried Ginkgo Nuts', '', 'Nuts','100', 'g', '1', 'portion', ' 348', '10.35', '72.45', '2.00', ' 348', '10.35', '72.45', '2.00', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Roasted Almonds (with Salt Added)', '', 'Nuts','100', 'g', '1', 'portion', ' 597', '22.09', '19.29', '52.83', ' 597', '22.09', '19.29', '52.83', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dried Black Walnuts', '', 'Nuts','100', 'g', '1', 'portion', ' 618', '24.06', '9.91', '59.00', ' 618', '24.06', '9.91', '59.00', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Roasted Macadamia Nuts (with Salt Added)', '', 'Nuts','100', 'g', '1', 'portion', ' 716', '7.79', '12.83', '76.08', ' 716', '7.79', '12.83', '76.08', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Carob Coated Nuts', '', 'Nuts','100', 'g', '1', 'portion', ' 557', '16.01', '37.16', '40.65', ' 557', '16.01', '37.16', '40.65', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Roasted Cashew Nuts', '', 'Nuts','100', 'g', '1', 'portion', ' 574', '15.31', '32.69', '46.35', ' 574', '15.31', '32.69', '46.35', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dried Hickorynuts', '', 'Nuts','100', 'g', '1', 'portion', ' 657', '12.72', '18.25', '64.37', ' 657', '12.72', '18.25', '64.37', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Roasted Macadamia Nuts (Without Salt Added)', '', 'Nuts','100', 'g', '1', 'portion', ' 718', '7.79', '13.38', '76.08', ' 718', '7.79', '13.38', '76.08', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Virginia Peanuts', '', 'Nuts','100', 'g', '1', 'portion', ' 563', '25.19', '16.54', '48.75', ' 563', '25.19', '16.54', '48.75', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Honey Roasted Peanuts', '', 'Nuts','165', 'g', '1', 'portion', ' 927', '40.42', '39.43', '75.61', ' 927', '40.42', '39.43', '75.61', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dried European Chestnuts (Peeled)', '', 'Nuts','100', 'g', '1', 'portion', ' 369', '5.01', '78.43', '3.91', ' 369', '5.01', '78.43', '3.91', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ginkgo Nuts', '', 'Nuts','100', 'g', '1', 'portion', ' 182', '4.32', '37.60', '1.68', ' 182', '4.32', '37.60', '1.68', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Roasted Pistachio Nuts (Without Salt Added)', '', 'Nuts','100', 'g', '1', 'portion', ' 571', '21.35', '27.65', '45.97', ' 571', '21.35', '27.65', '45.97', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oil Roasted Pecan Nuts (Without Salt Added)', '', 'Nuts','100', 'g', '1', 'portion', ' 715', '9.20', '13.01', '75.23', ' 715', '9.20', '13.01', '75.23', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sugar Coated Peanuts', '', 'Nuts','100', 'g', '1', 'portion', ' 522', '15.50', '47.40', '33.70', ' 522', '15.50', '47.40', '33.70', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit & Dry Roasted Nuts', '', 'Nuts','1/2 packa', 'g', '1', 'portion', ' 200', '3.75', '20.00', '11.25', ' 200', '3.75', '20.00', '11.25', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dried Japanese Chestnuts', '', 'Nuts','100', 'g', '1', 'portion', ' 360', '5.25', '81.43', '1.24', ' 360', '5.25', '81.43', '1.24', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oil Roasted Cashew Nuts (with Salt Added)', '', 'Nuts','100', 'g', '1', 'portion', ' 581', '16.84', '30.16', '47.77', ' 581', '16.84', '30.16', '47.77', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Roasted Mixed Nuts (with Peanuts, with Salt Added)', '', 'Nuts','100', 'g', '1', 'portion', ' 594', '17.30', '25.35', '51.45', ' 594', '17.30', '25.35', '51.45', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oil Roasted Mixed Nuts (Without Peanuts, with Salt Added)', '', 'Nuts','100', 'g', '1', 'portion', ' 615', '15.52', '22.27', '56.17', ' 615', '15.52', '22.27', '56.17', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Japanese Chestnuts', '', 'Nuts','100', 'g', '1', 'portion', ' 154', '2.25', '34.91', '0.53', ' 154', '2.25', '34.91', '0.53', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oil Roasted Cashew Nuts (Without Salt Added)', '', 'Nuts','100', 'g', '1', 'portion', ' 580', '16.84', '29.87', '47.77', ' 580', '16.84', '29.87', '47.77', '1', 'barcode', '42', '', '' , '',' ', '', ''");



  }


  public void insertAllMealName() {
    //захожу -- читаю из бд вещи в зависимости от даты + если ? (сегодняшней даты нет то вставляю по умолчанию ЗОБ) устанавливаю ЗавтракОбедУжин

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String currentData = dateFormat.format(Calendar.getInstance().getTime());

    setupInsertToMeal("NULL,'"+currentData+"' ,'Breakfast'");
    setupInsertToMeal("NULL,'"+currentData+"' ,'Lunch'");
    setupInsertToMeal("NULL,'"+currentData+"' ,'Dinner'");
    setupInsertToMeal("NULL,'"+currentData+"' ,'Snacks'");


  }

  public void setupInsertToMeal( String values) {
    DBAdapter db = new DBAdapter(context);
    db.open();
    db.insert("meal", "_id," +
        "meal_date ," +
        "meal_name "  , values);
    db.close();
  }

}

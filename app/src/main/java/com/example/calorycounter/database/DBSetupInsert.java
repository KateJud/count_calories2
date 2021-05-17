package com.example.calorycounter.database;

import android.content.Context;

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
    setupInsertToFood(  " NULL, 'Toasted 100% Whole Wheat Bread', '', 'Bread','100', 'g', '1', 'portion', ' 277', '10.90', '51.70', '4.80', ' 277', '10.90', '51.70', '4.80', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'French Rolls', '', 'Bread','100', 'g', '1', 'portion', ' 277', '8.60', '50.20', '4.30', ' 277', '8.60', '50.20', '4.30', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Hamburger or Hotdog Rolls', '', 'Bread','100', 'g', '1', 'portion', ' 279', '9.50', '49.45', '4.33', ' 279', '9.50', '49.45', '4.33', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Potato Bread', '', 'Bread','100', 'g', '1', 'portion', ' 266', '7.64', '50.61', '3.29', ' 266', '7.64', '50.61', '3.29', '1', 'barcode', '2', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Whole Wheat Bread', '', 'Bread','100', 'g', '1', 'portion', ' 282', '9.95', '51.32', '4.42', ' 282', '9.95', '51.32', '4.42', '1', 'barcode', '2', '', '' , '',' ', '', ''");
// =========FOODS CEREALS ============
    setupInsertToFood(  " NULL, 'Cereal', '', 'Cereals','100', 'g', '1', 'portion', ' 376', '7.24', '83.02', '3.38', ' 376', '7.24', '83.02', '3.38', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Corn Flakes', '', 'Cereals','100', 'g', '1', 'portion', ' 360', '6.70', '86.70', '0.10', ' 360', '6.70', '86.70', '0.10', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oats Cereal (Instant, Prepared with Water, Fortified)', '', 'Cereals','100', 'g', '1', 'portion', ' 55', '2.32', '9.59', '0.91', ' 55', '2.32', '9.59', '0.91', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oats Cereal (Without Salt, Cooked with Water, Unenriched)', '', 'Cereals','100', 'g', '1', 'portion', ' 63', '2.60', '10.80', '1.00', ' 63', '2.60', '10.80', '1.00', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rice Crisps Cereal', '', 'Cereals','100', 'g', '1', 'portion', ' 381', '6.45', '86.04', '1.27', ' 381', '6.45', '86.04', '1.27', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Bran Flakes', '', 'Cereals','100', 'g', '1', 'portion', ' 320', '9.40', '80.40', '2.20', ' 320', '9.40', '80.40', '2.20', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Instant Cream Of Wheat Cereals', '', 'Cereals','100', 'g', '1', 'portion', ' 366', '10.60', '75.50', '1.40', ' 366', '10.60', '75.50', '1.40', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Milk \\0N Cereal Bar', '', 'Cereals','100', 'g', '1', 'portion', ' 413', '6.47', '72.05', '10.98', ' 413', '6.47', '72.05', '10.98', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Cream Of Rice Cereals', '', 'Cereals','100', 'g', '1', 'portion', ' 370', '6.30', '82.40', '0.50', ' 370', '6.30', '82.40', '0.50', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chocolate Flavored Rings Cereal (Presweetened)', '', 'Cereals','100', 'g', '1', 'portion', ' 415', '4.80', '81.90', '8.80', ' 415', '4.80', '81.90', '8.80', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Regular Cream Of Wheat Cereals', '', 'Cereals','100', 'g', '1', 'portion', ' 370', '10.50', '76.50', '1.50', ' 370', '10.50', '76.50', '1.50', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Puffed Rice Cereal (Fortified)', '', 'Cereals','100', 'g', '1', 'portion', ' 402', '6.30', '89.80', '0.50', ' 402', '6.30', '89.80', '0.50', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Quick Cream Of Wheat Cereals', '', 'Cereals','100', 'g', '1', 'portion', ' 361', '10.20', '75.00', '1.30', ' 361', '10.20', '75.00', '1.30', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Granola Cereal', '', 'Cereals','100', 'g', '1', 'portion', ' 490', '14.87', '52.95', '24.36', ' 490', '14.87', '52.95', '24.36', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baby Food Jarred Cereal', '', 'Cereals','100', 'g', '1', 'portion', ' 78', '1.24', '16.90', '0.54', ' 78', '1.24', '16.90', '0.54', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Puffed Wheat Cereal (Presweetened)', '', 'Cereals','100', 'g', '1', 'portion', ' 398', '5.50', '90.90', '1.40', ' 398', '5.50', '90.90', '1.40', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Shredded Wheat Cereal (Presweetened)', '', 'Cereals','100', 'g', '1', 'portion', ' 352', '7.80', '83.80', '1.90', ' 352', '7.80', '83.80', '1.90', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Puffed Rice Cereal Fruit Flavored (Presweetened)', '', 'Cereals','100', 'g', '1', 'portion', ' 401', '3.60', '87.90', '3.90', ' 401', '3.60', '87.90', '3.90', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'White Chocolate with Cereal', '', 'Cereals','100', 'g', '1', 'portion', ' 516', '5.94', '63.18', '27.46', ' 516', '5.94', '63.18', '27.46', '1', 'barcode', '3', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chex Cereal', '', 'Cereals','100', 'g', '1', 'portion', ' 367', '7.01', '84.98', '1.28', ' 367', '7.01', '84.98', '1.28', '1', 'barcode', '3', '', '' , '',' ', '', ''");
// =========FOODS FROZEN BREAD AND ROLES ============
    setupInsertToFood(  " NULL, 'Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 266', '7.64', '50.61', '3.29', ' 266', '7.64', '50.61', '3.29', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Black Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 250', '8.70', '47.50', '3.10', ' 250', '8.70', '47.50', '3.10', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pita Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 275', '9.10', '55.70', '1.20', ' 275', '9.10', '55.70', '1.20', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cinnamon Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 266', '7.64', '50.61', '3.29', ' 266', '7.64', '50.61', '3.29', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Raisin Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 274', '7.90', '52.30', '4.40', ' 274', '7.90', '52.30', '4.40', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetable Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 255', '7.73', '47.70', '3.60', ' 255', '7.73', '47.70', '3.60', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oatmeal Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 269', '8.40', '48.50', '4.40', ' 269', '8.40', '48.50', '4.40', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sesame Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 271', '8.80', '50.00', '3.50', ' 271', '8.80', '50.00', '3.50', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, '100% Whole Wheat Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 246', '9.70', '46.10', '4.20', ' 246', '9.70', '46.10', '4.20', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Pumpernickel Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 275', '9.56', '52.20', '3.41', ' 275', '9.56', '52.20', '3.41', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Low Gluten Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 267', '9.78', '47.80', '5.06', ' 267', '9.78', '47.80', '5.06', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pumpernickel Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 250', '8.70', '47.50', '3.10', ' 250', '8.70', '47.50', '3.10', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Wheat Germ Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 261', '9.60', '48.30', '2.90', ' 261', '9.60', '48.30', '2.90', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oat Bran Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 262', '11.56', '44.22', '4.89', ' 262', '11.56', '44.22', '4.89', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Armenian Grecian Italian Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 271', '8.80', '50.00', '3.50', ' 271', '8.80', '50.00', '3.50', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pita with Fruit Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 278', '8.56', '58.00', '1.16', ' 278', '8.56', '58.00', '1.16', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Cheese Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 298', '9.80', '51.74', '5.46', ' 298', '9.80', '51.74', '5.46', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Challah Egg Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 283', '9.50', '47.80', '6.00', ' 283', '9.50', '47.80', '6.00', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'High Protein Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 245', '12.10', '43.80', '2.20', ' 245', '12.10', '43.80', '2.20', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Potato Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 292', '8.40', '55.62', '3.62', ' 292', '8.40', '55.62', '3.62', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Raisin Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 297', '8.60', '56.90', '4.80', ' 297', '8.60', '56.90', '4.80', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Sour Dough Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 298', '9.60', '56.40', '3.30', ' 298', '9.60', '56.40', '3.30', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sprouted Wheat Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 260', '9.10', '47.20', '4.10', ' 260', '9.10', '47.20', '4.10', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Whole Wheat Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 259', '9.13', '47.14', '4.11', ' 259', '9.13', '47.14', '4.11', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Black Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 275', '9.56', '52.20', '3.41', ' 275', '9.56', '52.20', '3.41', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Sunflower Meal Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 300', '10.76', '49.89', '6.33', ' 300', '10.76', '49.89', '6.33', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Bread without Nuts', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 323', '4.29', '54.56', '10.31', ' 323', '4.29', '54.56', '10.31', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Irish Soda Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 289', '6.57', '56.09', '4.96', ' 289', '6.57', '56.09', '4.96', '1', 'barcode', '4', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Sesame Bread', '', 'Frozen bread and roles','100', 'g', '1', 'portion', ' 271', '8.80', '50.00', '3.50', ' 271', '8.80', '50.00', '3.50', '1', 'barcode', '4', '', '' , '',' ', '', ''");
// =========FOODS CRISPBREAD ============
    setupInsertToFood(  " NULL, 'Low Sodium Rye Crispbread', '', 'Crispbread','100', 'g', '1', 'portion', ' 366', '7.90', '82.20', '1.30', ' 366', '7.90', '82.20', '1.30', '1', 'barcode', '5', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Extra Crispy Wheat or Rye Crispbread', '', 'Crispbread','100', 'g', '1', 'portion', ' 397', '10.71', '74.26', '6.43', ' 397', '10.71', '74.26', '6.43', '1', 'barcode', '5', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'No Added Fat Rye Crispbread', '', 'Crispbread','100', 'g', '1', 'portion', ' 366', '7.90', '82.20', '1.30', ' 366', '7.90', '82.20', '1.30', '1', 'barcode', '5', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Rye Crispbread', '', 'Crispbread','100', 'g', '1', 'portion', ' 366', '7.90', '82.20', '1.30', ' 366', '7.90', '82.20', '1.30', '1', 'barcode', '5', '', '' , '',' ', '', ''");
// =========FOODS BAKING ============
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
// =========FOODS BISCUIT ============
    setupInsertToFood(  " NULL, 'Plain or Buttermilk Biscuits', '', 'Biscuit','100', 'g', '1', 'portion', ' 353', '7.00', '44.60', '16.30', ' 353', '7.00', '44.60', '16.30', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Powder or Buttermilk Biscuit (Home Recipe)', '', 'Biscuit','100', 'g', '1', 'portion', ' 354', '6.99', '44.58', '16.33', ' 354', '6.99', '44.58', '16.33', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Plain or Buttermilk Biscuits (Commercial)', '', 'Biscuit','100', 'g', '1', 'portion', ' 365', '6.20', '48.50', '16.50', ' 365', '6.20', '48.50', '16.50', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Powder or Buttermilk Biscuit (from Refrigerated Dough)', '', 'Biscuit','100', 'g', '1', 'portion', ' 349', '6.70', '47.50', '14.70', ' 349', '6.70', '47.50', '14.70', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Plain or Buttermilk Biscuits (Dry Mix, Prepared)', '', 'Biscuit','100', 'g', '1', 'portion', ' 335', '7.30', '48.40', '12.10', ' 335', '7.30', '48.40', '12.10', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baking Powder or Buttermilk Biscuit (Refrigerated Dough or Home Recipe)', '', 'Biscuit','100', 'g', '1', 'portion', ' 348', '6.77', '46.81', '14.82', ' 348', '6.77', '46.81', '14.82', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fried Biscuit Dough', '', 'Biscuit','100', 'g', '1', 'portion', ' 335', '6.50', '46.21', '14.08', ' 335', '6.50', '46.21', '14.08', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Plain or Buttermilk Biscuit Dough (Higher Fat)', '', 'Biscuit','100', 'g', '1', 'portion', ' 318', '6.20', '43.70', '13.50', ' 318', '6.20', '43.70', '13.50', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Plain or Buttermilk Biscuit Dough (Lower Fat)', '', 'Biscuit','100', 'g', '1', 'portion', ' 257', '6.70', '47.60', '4.50', ' 257', '6.70', '47.60', '4.50', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Biscuit Dough', '', 'Biscuit','100', 'g', '1', 'portion', ' 257', '6.70', '47.60', '4.50', ' 257', '6.70', '47.60', '4.50', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Biscuit with Gravy', '', 'Biscuit','100', 'g', '1', 'portion', ' 230', '5.59', '19.89', '14.32', ' 230', '5.59', '19.89', '14.32', '1', 'barcode', '8', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg and Steak on Biscuit', '', 'Biscuit','100', 'g', '1', 'portion', ' 302', '11.05', '28.18', '16.15', ' 302', '11.05', '28.18', '16.15', '1', 'barcode', '8', '', '' , '',' ', '', ''");
// =========FOODS SODA ============
    setupInsertToFood(  " NULL, 'Soda', '', 'Soda','100', 'g', '1', 'portion', ' 38', '0.07', '9.77', '0.01', ' 38', '0.07', '9.77', '0.01', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soft Drink', '', 'Soda','100', 'g', '1', 'portion', ' 38', '0.07', '9.78', '0.02', ' 38', '0.07', '9.78', '0.02', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola Soda (with Caffeine)', '', 'Soda','100', 'g', '1', 'portion', ' 37', '0.07', '9.56', '0.02', ' 37', '0.07', '9.56', '0.02', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Root Beer', '', 'Soda','100', 'g', '1', 'portion', ' 41', '0.00', '10.60', '0.00', ' 41', '0.00', '10.60', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola Soft Drink with Higher Caffeine', '', 'Soda','100', 'g', '1', 'portion', ' 41', '0.00', '10.58', '0.00', ' 41', '0.00', '10.58', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola Soft Drink', '', 'Soda','100', 'g', '1', 'portion', ' 37', '0.07', '9.56', '0.02', ' 37', '0.07', '9.56', '0.02', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Lemon-Lime Soda (with Caffeine)', '', 'Soda','100', 'g', '1', 'portion', ' 41', '0.09', '10.42', '0.00', ' 41', '0.09', '10.42', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola Soft Drink Decaffeinated', '', 'Soda','100', 'g', '1', 'portion', ' 41', '0.00', '10.58', '0.00', ' 41', '0.00', '10.58', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sugar Free Decaffeinated Pepper-Type Soft Drink', '', 'Soda','100', 'g', '1', 'portion', ' 1', '0.12', '0.15', '0.00', ' 1', '0.12', '0.15', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola Soda (with Higher Caffeine)', '', 'Soda','100', 'g', '1', 'portion', ' 41', '0.00', '10.58', '0.00', ' 41', '0.00', '10.58', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cream Soda', '', 'Soda','100', 'g', '1', 'portion', ' 51', '0.00', '13.30', '0.00', ' 51', '0.00', '13.30', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soda (Other Than Cola or Pepper, Without Caffeine, with Sodium Saccharin)', '', 'Soda','100', 'g', '1', 'portion', ' 0', '0.00', '0.10', '0.00', ' 0', '0.00', '0.10', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Punch (made with Fruit Juice and Soda)', '', 'Soda','100', 'g', '1', 'portion', ' 44', '0.18', '10.82', '0.06', ' 44', '0.18', '10.82', '0.06', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola or Pepper Soda (with Caffeine, with Aspartame)', '', 'Soda','100', 'g', '1', 'portion', ' 1', '0.12', '0.15', '0.00', ' 1', '0.12', '0.15', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola or Pepper Soda (Low Calorie with Sodium Saccharin, Contains Caffeine)', '', 'Soda','100', 'g', '1', 'portion', ' 0', '0.00', '0.10', '0.00', ' 0', '0.00', '0.10', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sugar Free Chocolate Flavored Soda', '', 'Soda','100', 'g', '1', 'portion', ' 2', '0.11', '0.29', '0.03', ' 2', '0.11', '0.29', '0.03', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Grape Soda', '', 'Soda','100', 'g', '1', 'portion', ' 43', '0.00', '11.20', '0.00', ' 43', '0.00', '11.20', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Club Soda', '', 'Soda','100', 'g', '1', 'portion', ' 0', '0.00', '0.00', '0.00', ' 0', '0.00', '0.00', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola or Pepper Soda (with Caffeine, with Aspartame, Low Calorie)', '', 'Soda','100', 'g', '1', 'portion', ' 0', '0.10', '0.00', '0.00', ' 0', '0.10', '0.00', '0.00', '1', 'barcode', '10', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Irish Soda Bread', '', 'Soda','100', 'g', '1', 'portion', ' 289', '6.57', '56.09', '4.96', ' 289', '6.57', '56.09', '4.96', '1', 'barcode', '10', '', '' , '',' ', '', ''");
// =========FOODS FROZEN FRUITS AND VEGETABLES ============
    setupInsertToFood(  " NULL, 'Turkey with Gravy, Dressing, Vegetable and Fruit (Diet Frozen Meal)', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 112', '6.91', '18.16', '1.80', ' 112', '6.91', '18.16', '1.80', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Upside Down Cake (All Fruits)', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 319', '3.45', '50.65', '11.97', ' 319', '3.45', '50.65', '11.97', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fun Fruits Creme Supremes', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 475', '3.68', '69.33', '21.04', ' 475', '3.68', '69.33', '21.04', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Cocktail or Mix (Excluding Citrus Fruits)', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 55', '0.70', '14.15', '0.20', ' 55', '0.70', '14.15', '0.20', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baby Food Strained Garden Vegetables Mixed Vegetables', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 34', '1.75', '7.42', '0.35', ' 34', '1.75', '7.42', '0.35', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken in Soy-Based Sauce, Rice and Vegetables (Frozen Meal)', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 109', '6.72', '18.03', '0.87', ' 109', '6.72', '18.03', '0.87', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetables in Pastry', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 308', '6.60', '20.93', '22.98', ' 308', '6.60', '20.93', '22.98', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baby Food Garden Vegetables Mixed Vegetables', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 35', '1.63', '7.68', '0.37', ' 35', '1.63', '7.68', '0.37', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetables and Cheese in Pastry', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 317', '8.07', '19.40', '23.84', ' 317', '8.07', '19.40', '23.84', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cottage Cheese (with Vegetables)', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 95', '10.90', '3.00', '4.20', ' 95', '10.90', '3.00', '4.20', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Hawaiian Style Pickled Vegetables', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 35', '1.03', '6.87', '0.37', ' 35', '1.03', '6.87', '0.37', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Frozen Cherries', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 46', '0.92', '11.02', '0.44', ' 46', '0.92', '11.02', '0.44', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Frozen Rhubarb', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 116', '0.39', '31.20', '0.05', ' 116', '0.39', '31.20', '0.05', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Frozen Dinner', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 159', '8.72', '11.14', '8.75', ' 159', '8.72', '11.14', '8.75', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Frozen Peach', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 94', '0.63', '23.98', '0.13', ' 94', '0.63', '23.98', '0.13', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Frozen Blackberries', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 64', '1.18', '15.67', '0.43', ' 64', '1.18', '15.67', '0.43', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Frozen Blueberries', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 51', '0.42', '12.17', '0.64', ' 51', '0.42', '12.17', '0.64', '1', 'barcode', '12', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Julienne Salad (Meat, Cheese, Eggs, Vegetables)', '', 'Frozen fruits and vegetables','100', 'g', '1', 'portion', ' 96', '9.13', '2.33', '5.52', ' 96', '9.13', '2.33', '5.52', '1', 'barcode', '12', '', '' , '',' ', '', ''");
// =========FOODS FRUIT	 ============
    setupInsertToFood(  " NULL, 'Strawberries', '', 'Fruit	','100', 'g', '1', 'portion', ' 32', '0.67', '7.68', '0.30', ' 32', '0.67', '7.68', '0.30', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Blueberries', '', 'Fruit	','100', 'g', '1', 'portion', ' 57', '0.74', '14.49', '0.33', ' 57', '0.74', '14.49', '0.33', '1', 'barcode', '13', '', '' , '',' ', '', ''");
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
    setupInsertToFood(  " NULL, 'Quinces', '', 'Fruit	','100', 'g', '1', 'portion', ' 57', '0.40', '15.30', '0.10', ' 57', '0.40', '15.30', '0.10', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Red Raspberries', '', 'Fruit	','100', 'g', '1', 'portion', ' 52', '1.20', '11.94', '0.65', ' 52', '1.20', '11.94', '0.65', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Blackberries (Solids and Liquids, Heavy Syrup, Canned)', '', 'Fruit	','100', 'g', '1', 'portion', ' 92', '1.31', '23.10', '0.14', ' 92', '1.31', '23.10', '0.14', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Jujube', '', 'Fruit	','100', 'g', '1', 'portion', ' 79', '1.20', '20.23', '0.20', ' 79', '1.20', '20.23', '0.20', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Strawberries (Solids and Liquids, Heavy Syrup Pack, Canned)', '', 'Fruit	','100', 'g', '1', 'portion', ' 92', '0.56', '23.53', '0.26', ' 92', '0.56', '23.53', '0.26', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Passion-Fruit (Granadilla, Purple)', '', 'Fruit	','100', 'g', '1', 'portion', ' 97', '2.20', '23.38', '0.70', ' 97', '2.20', '23.38', '0.70', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dried Prunes (Without Added Sugar, Stewed)', '', 'Fruit	','100', 'g', '1', 'portion', ' 107', '0.96', '28.08', '0.16', ' 107', '0.96', '28.08', '0.16', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Kiwi Fruit', '', 'Fruit	','100', 'g', '1', 'portion', ' 61', '1.14', '14.66', '0.52', ' 61', '1.14', '14.66', '0.52', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Waxgourd (Chinese Preserving Melon)', '', 'Fruit	','100', 'g', '1', 'portion', ' 13', '0.40', '3.00', '0.20', ' 13', '0.40', '3.00', '0.20', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Peaches', '', 'Fruit	','100', 'g', '1', 'portion', ' 39', '0.91', '9.54', '0.25', ' 39', '0.91', '9.54', '0.25', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Grapefruit (Pink and Red and White)', '', 'Fruit	','100', 'g', '1', 'portion', ' 32', '0.63', '8.08', '0.10', ' 32', '0.63', '8.08', '0.10', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dried Japanese Persimmons', '', 'Fruit	','100', 'g', '1', 'portion', ' 274', '1.38', '73.43', '0.59', ' 274', '1.38', '73.43', '0.59', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Plums (Solids and Liquids, Water Pack, Canned)', '', 'Fruit	','100', 'g', '1', 'portion', ' 41', '0.39', '11.03', '0.01', ' 41', '0.39', '11.03', '0.01', '1', 'barcode', '13', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Peaches (Solids and Liquids, Water Pack, Canned)', '', 'Fruit	','100', 'g', '1', 'portion', ' 24', '0.44', '6.11', '0.06', ' 24', '0.44', '6.11', '0.06', '1', 'barcode', '13', '', '' , '',' ', '', ''");
// =========FOODS VEGETABLES ============
    setupInsertToFood(  " NULL, 'Mixed Vegetables (Frozen)', '', 'Vegetables','100', 'g', '1', 'portion', ' 64', '3.33', '13.46', '0.52', ' 64', '3.33', '13.46', '0.52', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Carrots', '', 'Vegetables','100', 'g', '1', 'portion', ' 41', '0.93', '9.58', '0.24', ' 41', '0.93', '9.58', '0.24', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Green Peppers', '', 'Vegetables','100', 'g', '1', 'portion', ' 20', '0.86', '4.64', '0.17', ' 20', '0.86', '4.64', '0.17', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Zucchini', '', 'Vegetables','100', 'g', '1', 'portion', ' 16', '1.21', '3.35', '0.18', ' 16', '1.21', '3.35', '0.18', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Broccoli', '', 'Vegetables','100', 'g', '1', 'portion', ' 34', '2.82', '6.64', '0.37', ' 34', '2.82', '6.64', '0.37', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Onions', '', 'Vegetables','100', 'g', '1', 'portion', ' 42', '0.92', '10.11', '0.08', ' 42', '0.92', '10.11', '0.08', '1', 'barcode', '14', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Tomatoes', '', 'Vegetables','100', 'g', '1', 'portion', ' 18', '0.88', '3.92', '0.20', ' 18', '0.88', '3.92', '0.20', '1', 'barcode', '14', '', '' , '',' ', '', ''");
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
    setupInsertToFood(  " NULL, 'Red Hot Chili Peppers', '', 'Vegetables','100', 'g', '1', 'portion', ' 40', '1.87', '8.81', '0.44', ' 40', '1.87', '8.81', '0.44', '1', 'barcode', '14', '', '' , '',' ', '', ''");
// =========FOODS CANNED FRUIT AND VEGETABLES ============
    setupInsertToFood(  " NULL, 'Fruit Cocktail Drained Solids (Cooked or Canned)', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 70', '0.47', '18.80', '0.10', ' 70', '0.47', '18.80', '0.10', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baby Food Strained Garden Vegetables Mixed Vegetables', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 34', '1.75', '7.42', '0.35', ' 34', '1.75', '7.42', '0.35', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Juice', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 46', '0.41', '11.12', '0.11', ' 46', '0.41', '11.12', '0.11', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Whirls', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 393', '5.04', '87.48', '3.10', ' 393', '5.04', '87.48', '3.10', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Nectar', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 56', '0.37', '14.39', '0.09', ' 56', '0.37', '14.39', '0.09', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Leather', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 371', '0.10', '85.80', '3.00', ' 371', '0.10', '85.80', '3.00', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Cocktail Unsweetened in Water Pack (Cooked or Canned)', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 32', '0.42', '8.51', '0.05', ' 32', '0.42', '8.51', '0.05', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Cocktail in Heavy Syrup (Cooked or Canned)', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 73', '0.39', '18.91', '0.07', ' 73', '0.39', '18.91', '0.07', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetables in Pastry', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 308', '6.60', '20.93', '22.98', ' 308', '6.60', '20.93', '22.98', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Cocktail in Light Syrup (Cooked or Canned)', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 57', '0.40', '14.93', '0.07', ' 57', '0.40', '14.93', '0.07', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baby Food Garden Vegetables Mixed Vegetables', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 35', '1.63', '7.68', '0.37', ' 35', '1.63', '7.68', '0.37', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Syrup', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 268', '0.03', '71.82', '0.12', ' 268', '0.03', '71.82', '0.12', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Ice', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 128', '0.40', '32.60', '0.00', ' 128', '0.40', '32.60', '0.00', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetables and Cheese in Pastry', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 317', '8.07', '19.40', '23.84', ' 317', '8.07', '19.40', '23.84', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cottage Cheese (with Vegetables)', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 95', '10.90', '3.00', '4.20', ' 95', '10.90', '3.00', '4.20', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pita with Fruit Bread', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 278', '8.56', '58.00', '1.16', ' 278', '8.56', '58.00', '1.16', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Bread without Nuts', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 323', '4.29', '54.56', '10.31', ' 323', '4.29', '54.56', '10.31', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Lowfat Fruit Variety Yogurt', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 102', '4.37', '19.05', '1.08', ' 102', '4.37', '19.05', '1.08', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dried Fruit Mixture', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 244', '2.19', '64.81', '0.44', ' 244', '2.19', '64.81', '0.44', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Passion Fruit Nectar', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 67', '0.16', '17.44', '0.02', ' 67', '0.16', '17.44', '0.02', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soft Fruit Confections', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 390', '2.31', '73.81', '9.52', ' 390', '2.31', '73.81', '9.52', '1', 'barcode', '15', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Punch (Alcoholic)', '', 'Canned fruit and vegetables','100', 'g', '1', 'portion', ' 64', '0.12', '6.77', '0.03', ' 64', '0.12', '6.77', '0.03', '1', 'barcode', '15', '', '' , '',' ', '', ''");
// =========FOODS MEAL SUBSTITUTES ============
    setupInsertToFood(  " NULL, 'Meat Substitute Type Sandwich Spread', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 149', '8.00', '9.00', '9.00', ' 149', '8.00', '9.00', '9.00', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fried Cereal and Vegetable Protein Meat Substitute', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 333', '11.58', '62.48', '6.51', ' 333', '11.58', '62.48', '6.51', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soybean Meal', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 436', '34.54', '35.19', '20.65', ' 436', '34.54', '35.19', '20.65', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef Dinner (Frozen Meal)', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 148', '6.92', '11.66', '8.37', ' 148', '6.92', '11.66', '8.37', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Turkey Dinner (Frozen Meal)', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 155', '9.64', '13.17', '7.00', ' 155', '9.64', '13.17', '7.00', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Toasted Sunflower Meal Bread', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 300', '10.76', '49.89', '6.33', ' 300', '10.76', '49.89', '6.33', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'High Protein Meal Replacement Powder', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 288', '32.00', '54.50', '0.00', ' 288', '32.00', '54.50', '0.00', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Fajitas (Diet Frozen Meal)', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 122', '8.88', '15.88', '2.61', ' 122', '8.88', '15.88', '2.61', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef Enchilada Dinner (Frozen Meal)', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 124', '5.08', '16.64', '4.12', ' 124', '5.08', '16.64', '4.12', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meal Replacement or Supplement with Soy', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 99', '3.49', '14.01', '3.25', ' 99', '3.49', '14.01', '3.25', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Spaghetti with Meat Sauce (Diet Frozen Meal)', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 90', '5.05', '15.24', '1.01', ' 90', '5.05', '15.24', '1.01', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Drink Meal Supplement or Replacement', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 70', '3.50', '10.90', '1.40', ' 70', '3.50', '10.90', '1.40', '1', 'barcode', '17', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Salisbury Steak, Potatoes, Vegetable and Dessert (Diet Frozen Meal)', '', 'Meal substitutes','100', 'g', '1', 'portion', ' 93', '4.79', '12.68', '2.80', ' 93', '4.79', '12.68', '2.80', '1', 'barcode', '17', '', '' , '',' ', '', ''");
// =========FOODS PROTEIN BARS ============
// =========FOODS PROTEIN POWDER ============
    setupInsertToFood(  " NULL, 'Protein Powder', '', 'Protein powder','100', 'g', '1', 'portion', ' 401', '31.00', '49.00', '9.00', ' 401', '31.00', '49.00', '9.00', '1', 'barcode', '19', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Protein Supplement Powder', '', 'Protein powder','100', 'g', '1', 'portion', ' 366', '29.40', '58.80', '1.50', ' 366', '29.40', '58.80', '1.50', '1', 'barcode', '19', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Protein Meal Replacement Powder', '', 'Protein powder','100', 'g', '1', 'portion', ' 324', '17.60', '63.50', '0.40', ' 324', '17.60', '63.50', '0.40', '1', 'barcode', '19', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soy Protein Meal Replacement Powder', '', 'Protein powder','100', 'g', '1', 'portion', ' 337', '33.70', '47.20', '2.20', ' 337', '33.70', '47.20', '2.20', '1', 'barcode', '19', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soy Protein Isolate (Crude Protein Basis, Potassium Type)', '', 'Protein powder','100', 'g', '1', 'portion', ' 321', '88.32', '2.59', '0.53', ' 321', '88.32', '2.59', '0.53', '1', 'barcode', '19', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soy Protein Isolate', '', 'Protein powder','100', 'g', '1', 'portion', ' 338', '80.69', '7.36', '3.39', ' 338', '80.69', '7.36', '3.39', '1', 'barcode', '19', '', '' , '',' ', '', ''");
// =========FOODS MEAT ============
    setupInsertToFood(  " NULL, 'Meatless Chicken', '', 'Meat','100', 'g', '1', 'portion', ' 224', '23.64', '3.64', '12.73', ' 224', '23.64', '3.64', '12.73', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Fish Stick', '', 'Meat','100', 'g', '1', 'portion', ' 290', '23.00', '9.00', '18.00', ' 290', '23.00', '9.00', '18.00', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meatless Spaghetti Sauce', '', 'Meat','100', 'g', '1', 'portion', ' 74', '1.95', '11.27', '2.38', ' 74', '1.95', '11.27', '2.38', '1', 'barcode', '21', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Stewed Light or Dark Turkey Meat (Skin Eaten)', '', 'Meat','100', 'g', '1', 'portion', ' 172', '27.01', '0.00', '6.24', ' 172', '27.01', '0.00', '6.24', '1', 'barcode', '21', '', '' , '',' ', '', ''");
// =========FOODS CHICKEN ============
    setupInsertToFood(  " NULL, 'Skinless Chicken Breast', '', 'Chicken','100', 'g', '1', 'portion', ' 110', '23.09', '0.00', '1.24', ' 110', '23.09', '0.00', '1.24', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Meat (Stewing, Stewed, Cooked)', '', 'Chicken','100', 'g', '1', 'portion', ' 237', '30.42', '0.00', '11.89', ' 237', '30.42', '0.00', '11.89', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baked or Fried Coated Chicken Thigh Skinless (Coating Eaten)', '', 'Chicken','100', 'g', '1', 'portion', ' 254', '21.43', '10.14', '13.65', ' 254', '21.43', '10.14', '13.65', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Meat (Roasting, Roasted, Cooked)', '', 'Chicken','100', 'g', '1', 'portion', ' 167', '25.01', '0.00', '6.63', ' 167', '25.01', '0.00', '6.63', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken (Breaded and Fried)', '', 'Chicken','100', 'g', '1', 'portion', ' 297', '15.59', '16.32', '18.82', ' 297', '15.59', '16.32', '18.82', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Canned Chicken (Meat Only)', '', 'Chicken','100', 'g', '1', 'portion', ' 184', '25.30', '0.80', '8.10', ' 184', '25.30', '0.80', '8.10', '1', 'barcode', '22', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Nuggets', '', 'Chicken','100', 'g', '1', 'portion', ' 297', '15.59', '16.32', '18.82', ' 297', '15.59', '16.32', '18.82', '1', 'barcode', '22', '', '' , '',' ', '', ''");
// =========FOODS SEAFOOD ============
    setupInsertToFood(  " NULL, 'Shrimp', '', 'Seafood','100', 'g', '1', 'portion', ' 106', '20.31', '0.91', '1.73', ' 106', '20.31', '0.91', '1.73', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Mussels', '', 'Seafood','100', 'g', '1', 'portion', ' 86', '11.90', '3.69', '2.24', ' 86', '11.90', '3.69', '2.24', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dungeness Crab (Cooked, Moist Heat)', '', 'Seafood','100', 'g', '1', 'portion', ' 110', '22.32', '0.95', '1.24', ' 110', '22.32', '0.95', '1.24', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Canned Shrimp', '', 'Seafood','100', 'g', '1', 'portion', ' 100', '20.42', '0.00', '1.36', ' 100', '20.42', '0.00', '1.36', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Blue Crab (Canned)', '', 'Seafood','100', 'g', '1', 'portion', ' 99', '20.52', '0.00', '1.23', ' 99', '20.52', '0.00', '1.23', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Blue Crab', '', 'Seafood','100', 'g', '1', 'portion', ' 87', '18.06', '0.04', '1.08', ' 87', '18.06', '0.04', '1.08', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Clams (Mixed Species, Drained Solids, Canned)', '', 'Seafood','100', 'g', '1', 'portion', ' 148', '25.55', '5.13', '1.95', ' 148', '25.55', '5.13', '1.95', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Canned Clam and Tomato Juice', '', 'Seafood','100', 'g', '1', 'portion', ' 48', '0.60', '10.95', '0.20', ' 48', '0.60', '10.95', '0.20', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Queen Crab', '', 'Seafood','100', 'g', '1', 'portion', ' 90', '18.50', '0.00', '1.18', ' 90', '18.50', '0.00', '1.18', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dried Squid', '', 'Seafood','100', 'g', '1', 'portion', ' 350', '59.24', '11.72', '5.25', ' 350', '59.24', '11.72', '5.25', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Blue Crab (Cooked, Moist Heat)', '', 'Seafood','100', 'g', '1', 'portion', ' 102', '20.20', '0.00', '1.77', ' 102', '20.20', '0.00', '1.77', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Queen Crab (Cooked, Moist Heat)', '', 'Seafood','100', 'g', '1', 'portion', ' 115', '23.72', '0.00', '1.51', ' 115', '23.72', '0.00', '1.51', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Crab Cake Entrees', '', 'Seafood','100', 'g', '1', 'portion', ' 266', '18.75', '8.52', '17.25', ' 266', '18.75', '8.52', '17.25', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Canned Crab', '', 'Seafood','100', 'g', '1', 'portion', ' 99', '20.52', '0.00', '1.23', ' 99', '20.52', '0.00', '1.23', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Canned Clams', '', 'Seafood','100', 'g', '1', 'portion', ' 92', '15.96', '3.21', '1.21', ' 92', '15.96', '3.21', '1.21', '1', 'barcode', '23', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Clam (Mixed Species, Cooked, Breaded and Fried)', '', 'Seafood','100', 'g', '1', 'portion', ' 202', '14.24', '10.33', '11.15', ' 202', '14.24', '10.33', '11.15', '1', 'barcode', '23', '', '' , '',' ', '', ''");
// =========FOODS EGGS ============
    setupInsertToFood(  " NULL, 'Egg', '', 'Eggs','100', 'g', '1', 'portion', ' 147', '12.58', '0.77', '9.94', ' 147', '12.58', '0.77', '9.94', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Scrambled Egg', '', 'Eggs','100', 'g', '1', 'portion', ' 212', '13.84', '2.08', '16.18', ' 212', '13.84', '2.08', '16.18', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fried Egg', '', 'Eggs','100', 'g', '1', 'portion', ' 201', '13.63', '0.88', '15.31', ' 201', '13.63', '0.88', '15.31', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Boiled Egg', '', 'Eggs','100', 'g', '1', 'portion', ' 155', '12.58', '1.12', '10.61', ' 155', '12.58', '1.12', '10.61', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg White', '', 'Eggs','100', 'g', '1', 'portion', ' 52', '10.90', '0.73', '0.17', ' 52', '10.90', '0.73', '0.17', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Hard-Boiled Egg', '', 'Eggs','100', 'g', '1', 'portion', ' 155', '12.58', '1.12', '10.61', ' 155', '12.58', '1.12', '10.61', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Scrambled Egg (Whole, Cooked)', '', 'Eggs','100', 'g', '1', 'portion', ' 166', '11.09', '2.20', '12.21', ' 166', '11.09', '2.20', '12.21', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Poached Egg', '', 'Eggs','100', 'g', '1', 'portion', ' 147', '12.58', '0.77', '9.94', ' 147', '12.58', '0.77', '9.94', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cooked Egg', '', 'Eggs','100', 'g', '1', 'portion', ' 169', '12.34', '1.28', '12.26', ' 169', '12.34', '1.28', '12.26', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg (Whole)', '', 'Eggs','100', 'g', '1', 'portion', ' 147', '12.58', '0.77', '9.94', ' 147', '12.58', '0.77', '9.94', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cooked Egg White', '', 'Eggs','100', 'g', '1', 'portion', ' 52', '10.90', '0.73', '0.17', ' 52', '10.90', '0.73', '0.17', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Soft Boiled Egg', '', 'Eggs','100', 'g', '1', 'portion', ' 155', '12.58', '1.12', '10.61', ' 155', '12.58', '1.12', '10.61', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Yolk (Sugared, Frozen)', '', 'Eggs','100', 'g', '1', 'portion', ' 307', '13.80', '10.80', '22.75', ' 307', '13.80', '10.80', '22.75', '1', 'barcode', '25', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Yolk (Frozen)', '', 'Eggs','100', 'g', '1', 'portion', ' 303', '15.50', '1.15', '25.60', ' 303', '15.50', '1.15', '25.60', '1', 'barcode', '25', '', '' , '',' ', '', ''");
// =========FOODS CREAM AND SOUR CREAM ============
    setupInsertToFood(  " NULL, 'Sour Cream', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 214', '3.16', '4.27', '20.96', ' 214', '3.16', '4.27', '20.96', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sour Cream (Sour Dressing, Nonbutterfat)', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 178', '3.25', '4.68', '16.57', ' 178', '3.25', '4.68', '16.57', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fat Free Sour Cream', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 74', '3.10', '15.60', '0.00', ' 74', '3.10', '15.60', '0.00', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Light Sour Cream', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 136', '3.50', '7.10', '10.60', ' 136', '3.50', '7.10', '10.60', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Reduced Fat Sour Cream', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 181', '7.00', '7.00', '14.10', ' 181', '7.00', '7.00', '14.10', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Imitation Sour Cream (Nondairy)', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 208', '2.40', '6.63', '19.52', ' 208', '2.40', '6.63', '19.52', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sour Cream (Fat Free)', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 74', '3.10', '15.60', '0.00', ' 74', '3.10', '15.60', '0.00', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sour Cream (Cultured)', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 214', '3.16', '4.27', '20.96', ' 214', '3.16', '4.27', '20.96', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sour Cream (Light)', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 136', '3.50', '7.10', '10.60', ' 136', '3.50', '7.10', '10.60', '1', 'barcode', '26', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Imitation Sour Cream (Cultured)', '', 'Cream and sour cream','100', 'g', '1', 'portion', ' 208', '2.40', '6.63', '19.52', ' 208', '2.40', '6.63', '19.52', '1', 'barcode', '26', '', '' , '',' ', '', ''");
// =========FOODS YOGURT ============
    setupInsertToFood(  " NULL, 'Plain Yogurt', '', 'Yogurt','100', 'g', '1', 'portion', ' 63', '5.25', '7.04', '1.55', ' 63', '5.25', '7.04', '1.55', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Yogurt', '', 'Yogurt','100', 'g', '1', 'portion', ' 99', '3.98', '18.64', '1.15', ' 99', '3.98', '18.64', '1.15', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vanilla Yogurt (Lowfat)', '', 'Yogurt','100', 'g', '1', 'portion', ' 85', '4.93', '13.80', '1.25', ' 85', '4.93', '13.80', '1.25', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Whole Milk Plain Yogurt', '', 'Yogurt','100', 'g', '1', 'portion', ' 61', '3.47', '4.66', '3.25', ' 61', '3.47', '4.66', '3.25', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Lowfat Plain Yogurt', '', 'Yogurt','100', 'g', '1', 'portion', ' 63', '5.25', '7.04', '1.55', ' 63', '5.25', '7.04', '1.55', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Lowfat Fruit Variety Yogurt', '', 'Yogurt','100', 'g', '1', 'portion', ' 102', '4.37', '19.05', '1.08', ' 102', '4.37', '19.05', '1.08', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Plain Yogurt (Whole Milk)', '', 'Yogurt','100', 'g', '1', 'portion', ' 61', '3.47', '4.66', '3.25', ' 61', '3.47', '4.66', '3.25', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Plain Yogurt (Lowfat)', '', 'Yogurt','100', 'g', '1', 'portion', ' 63', '5.25', '7.04', '1.55', ' 63', '5.25', '7.04', '1.55', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fruit Yogurt (Lowfat with Low Calorie Sweetener)', '', 'Yogurt','100', 'g', '1', 'portion', ' 105', '4.86', '18.60', '1.41', ' 105', '4.86', '18.60', '1.41', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Nonfat Fruit Variety Yogurt', '', 'Yogurt','100', 'g', '1', 'portion', ' 94', '4.40', '19.00', '0.20', ' 94', '4.40', '19.00', '0.20', '1', 'barcode', '27', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Yogurt Chips', '', 'Yogurt','100', 'g', '1', 'portion', ' 524', '10.32', '55.20', '28.70', ' 524', '10.32', '55.20', '28.70', '1', 'barcode', '27', '', '' , '',' ', '', ''");
// =========FOODS READY DINNER DISHES ============
    setupInsertToFood(  " NULL, 'Turkey Dinner (Frozen Meal)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 155', '9.64', '13.17', '7.00', ' 155', '9.64', '13.17', '7.00', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Frozen Dinner', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 159', '8.72', '11.14', '8.75', ' 159', '8.72', '11.14', '8.75', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Eat Cereal', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 376', '7.24', '83.02', '3.38', ' 376', '7.24', '83.02', '3.38', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef Enchilada Dinner (Frozen Meal)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 124', '5.08', '16.64', '4.12', ' 124', '5.08', '16.64', '4.12', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef Dinner (Frozen Meal)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 148', '6.92', '11.66', '8.37', ' 148', '6.92', '11.66', '8.37', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chocolate Ready-to-Drink Soy Milk', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 49', '2.75', '5.81', '1.91', ' 49', '2.75', '5.81', '1.91', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Drink Meal Supplement or Replacement', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 70', '3.50', '10.90', '1.40', ' 70', '3.50', '10.90', '1.40', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Drink Soy Milk', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 42', '3.22', '3.65', '1.66', ' 42', '3.22', '3.65', '1.66', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Eat Low Calorie Chocolate Pudding with Artificial Sweetener', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 83', '3.35', '15.28', '0.89', ' 83', '3.35', '15.28', '0.89', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Serve Low Sodium Tomato Soup (Canned)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 35', '0.80', '7.30', '0.80', ' 35', '0.80', '7.30', '0.80', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Serve Reduced Sodium Minestrone Soup (Canned)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 50', '2.00', '9.00', '0.80', ' 50', '2.00', '9.00', '0.80', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Serve Reduced Sodium Split Pea and Ham Soup (with Water, Canned)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 68', '4.00', '11.40', '0.70', ' 68', '4.00', '11.40', '0.70', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Eat Low Calorie Pudding with Artificial Sweetener (Flavors Other Than Chocolate)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 78', '2.70', '16.11', '0.65', ' 78', '2.70', '16.11', '0.65', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Serve Reduced Sodium Split Pea Soup (with Water, Canned)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 71', '3.85', '11.83', '0.92', ' 71', '3.85', '11.83', '0.92', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Vegetable Chicken Rice Soup (Prepared with Water or Ready-to-Serve)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 28', '1.48', '3.26', '0.98', ' 28', '1.48', '3.26', '0.98', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Serve Reduced Sodium Bean and Ham Soup (with Water, Canned )', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 74', '4.19', '13.66', '1.03', ' 74', '4.19', '13.66', '1.03', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Veal Dinner (Frozen Meal)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 129', '6.36', '11.91', '6.26', ' 129', '6.36', '11.91', '6.26', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baby Food Chicken Noodle Dinner', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 60', '2.53', '8.94', '1.62', ' 60', '2.53', '8.94', '1.62', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Salisbury Steak Dinner (Frozen Meal)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 148', '6.92', '11.66', '8.37', ' 148', '6.92', '11.66', '8.37', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat Loaf Dinner (Frozen Meal)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 131', '6.62', '9.65', '7.40', ' 131', '6.62', '9.65', '7.40', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Serve Reduced Sodium Chicken Noodle Soup (Canned)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 35', '3.46', '3.66', '0.95', ' 35', '3.46', '3.66', '0.95', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Eat Corned Beef (Canned)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 250', '27.10', '0.00', '14.93', ' 250', '27.10', '0.00', '14.93', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'High Protein Ready-to-Drink Meal Supplement or Replacement (with Milk)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 94', '5.70', '13.00', '2.20', ' 94', '5.70', '13.00', '2.20', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Reduced Sodium Vegetable Noodle Soup (Prepared with Water or Ready-to-Serve, Canned)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 40', '1.62', '8.62', '0.46', ' 40', '1.62', '8.62', '0.46', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ready-to-Serve Low Sodium Chicken Noodle Soup (Canned)', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 31', '1.70', '4.58', '1.00', ' 31', '1.70', '4.58', '1.00', '1', 'barcode', '29', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dinner Rolls', '', 'Ready dinner dishes','100', 'g', '1', 'portion', ' 300', '8.40', '50.40', '7.30', ' 300', '8.40', '50.40', '7.30', '1', 'barcode', '29', '', '' , '',' ', '', ''");
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
    setupInsertToFood(  " NULL, '14\" Cheese Pizza', '', 'Pizza','100', 'g', '1', 'portion', ' 264', '11.91', '32.58', '9.51', ' 264', '11.91', '32.58', '9.51', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, '14\" Meat and Vegetable Pizza', '', 'Pizza','100', 'g', '1', 'portion', ' 244', '11.02', '25.38', '10.90', ' 244', '11.02', '25.38', '10.90', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Thick Crust Cheese Pizza', '', 'Pizza','100', 'g', '1', 'portion', ' 270', '12.07', '31.65', '10.55', ' 270', '12.07', '31.65', '10.55', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, '14\" Cheese Pizza (Thin Crust)', '', 'Pizza','100', 'g', '1', 'portion', ' 304', '14.17', '26.54', '15.68', ' 304', '14.17', '26.54', '15.68', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, '14\" Pepperoni Pizza (Thick Crust)', '', 'Pizza','100', 'g', '1', 'portion', ' 284', '12.43', '30.40', '12.49', ' 284', '12.43', '30.40', '12.49', '1', 'barcode', '30', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat and Vegetable Pizza (Frozen, Cooked)', '', 'Pizza','100', 'g', '1', 'portion', ' 276', '11.28', '25.14', '14.43', ' 276', '11.28', '25.14', '14.43', '1', 'barcode', '30', '', '' , '',' ', '', ''");
// =========FOODS NOODLE ============
    setupInsertToFood(  " NULL, 'Rice Noodles (Cooked)', '', 'Noodle','100', 'g', '1', 'portion', ' 109', '0.91', '24.90', '0.20', ' 109', '0.91', '24.90', '0.20', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Noodles (Enriched, Cooked)', '', 'Noodle','100', 'g', '1', 'portion', ' 138', '4.54', '25.16', '2.07', ' 138', '4.54', '25.16', '2.07', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Macaroni or Noodles with Cheese and Chicken or Turkey', '', 'Noodle','100', 'g', '1', 'portion', ' 197', '12.78', '16.09', '8.73', ' 197', '12.78', '16.09', '8.73', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chow Mein Chinese Noodles', '', 'Noodle','100', 'g', '1', 'portion', ' 527', '8.38', '57.54', '30.76', ' 527', '8.38', '57.54', '30.76', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Spinach Egg Noodles (Enriched, Cooked)', '', 'Noodle','100', 'g', '1', 'portion', ' 132', '5.04', '24.25', '1.57', ' 132', '5.04', '24.25', '1.57', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chunky Style Chicken Noodle Soup', '', 'Noodle','100', 'g', '1', 'portion', ' 73', '5.30', '7.10', '2.50', ' 73', '5.30', '7.10', '2.50', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Spinach Egg Noodles (Enriched)', '', 'Noodle','100', 'g', '1', 'portion', ' 382', '14.61', '70.32', '4.55', ' 382', '14.61', '70.32', '4.55', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Somen Japanese Noodles (Cooked)', '', 'Noodle','100', 'g', '1', 'portion', ' 131', '4.00', '27.54', '0.18', ' 131', '4.00', '27.54', '0.18', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cream of Tomato Noodle Soup', '', 'Noodle','100', 'g', '1', 'portion', ' 75', '2.75', '11.25', '2.37', ' 75', '2.75', '11.25', '2.37', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Noodles with Vegetables in Tomato-Based Sauce (Diet Frozen Meal)', '', 'Noodle','100', 'g', '1', 'portion', ' 67', '3.56', '10.57', '1.50', ' 67', '3.56', '10.57', '1.50', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chicken Noodle Soup (Undiluted, Canned)', '', 'Noodle','100', 'g', '1', 'portion', ' 53', '2.59', '6.03', '1.94', ' 53', '2.59', '6.03', '1.94', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef Noodle Soup (Undiluted, Canned)', '', 'Noodle','100', 'g', '1', 'portion', ' 67', '3.85', '7.16', '2.46', ' 67', '3.85', '7.16', '2.46', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Chinese Noodles (Mung Beans) (Cellophane or Long Rice)', '', 'Noodle','100', 'g', '1', 'portion', ' 351', '0.16', '86.09', '0.06', ' 351', '0.16', '86.09', '0.06', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Egg Noodles', '', 'Noodle','100', 'g', '1', 'portion', ' 384', '14.16', '71.27', '4.44', ' 384', '14.16', '71.27', '4.44', '1', 'barcode', '31', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Egg Noodles (with Added Salt, Cooked)', '', 'Noodle','100', 'g', '1', 'portion', ' 138', '4.54', '25.16', '2.07', ' 138', '4.54', '25.16', '2.07', '1', 'barcode', '31', '', '' , '',' ', '', ''");
// =========FOODS PASTA ============
    setupInsertToFood(  " NULL, 'Fresh Pasta (Cooked)', '', 'Pasta','100', 'g', '1', 'portion', ' 131', '5.15', '24.93', '1.05', ' 131', '5.15', '24.93', '1.05', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Macaroni (Cooked)', '', 'Pasta','100', 'g', '1', 'portion', ' 158', '5.80', '30.86', '0.93', ' 158', '5.80', '30.86', '0.93', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Pasta (Made with Egg, Cooked)', '', 'Pasta','100', 'g', '1', 'portion', ' 130', '5.28', '23.54', '1.74', ' 130', '5.28', '23.54', '1.74', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Whole Wheat Pasta', '', 'Pasta','100', 'g', '1', 'portion', ' 348', '14.63', '75.03', '1.40', ' 348', '14.63', '75.03', '1.40', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Whole Wheat Spaghetti (Cooked)', '', 'Pasta','100', 'g', '1', 'portion', ' 124', '5.33', '26.54', '0.54', ' 124', '5.33', '26.54', '0.54', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Spaghetti (Without Added Salt, Cooked)', '', 'Pasta','100', 'g', '1', 'portion', ' 158', '5.80', '30.86', '0.93', ' 158', '5.80', '30.86', '0.93', '1', 'barcode', '32', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Spaghetti with Meatballs (Canned)', '', 'Pasta','100', 'g', '1', 'portion', ' 107', '4.17', '11.11', '5.10', ' 107', '4.17', '11.11', '5.10', '1', 'barcode', '32', '', '' , '',' ', '', ''");
// =========FOODS RICE ============
    setupInsertToFood(  " NULL, 'Cooked Rice', '', 'Rice','100', 'g', '1', 'portion', ' 135', '2.64', '27.64', '1.07', ' 135', '2.64', '27.64', '1.07', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'White Rice (Long-Grain, Cooked)', '', 'Rice','100', 'g', '1', 'portion', ' 130', '2.69', '28.17', '0.28', ' 130', '2.69', '28.17', '0.28', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'White Rice (Medium-Grain, Cooked)', '', 'Rice','100', 'g', '1', 'portion', ' 130', '2.38', '28.59', '0.21', ' 130', '2.38', '28.59', '0.21', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Puffed Rice', '', 'Rice','100', 'g', '1', 'portion', ' 383', '7.00', '87.77', '0.90', ' 383', '7.00', '87.77', '0.90', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'White Rice (Long-Grain, with Salt, Enriched, Cooked)', '', 'Rice','100', 'g', '1', 'portion', ' 130', '2.69', '28.17', '0.28', ' 130', '2.69', '28.17', '0.28', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Brown Rice (Medium-Grain)', '', 'Rice','100', 'g', '1', 'portion', ' 362', '7.50', '76.17', '2.68', ' 362', '7.50', '76.17', '2.68', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'White Rice (Medium-Grain, Enriched)', '', 'Rice','100', 'g', '1', 'portion', ' 360', '6.61', '79.34', '0.58', ' 360', '6.61', '79.34', '0.58', '1', 'barcode', '33', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'White Rice (Short-Grain, Cooked)', '', 'Rice','100', 'g', '1', 'portion', ' 130', '2.36', '28.73', '0.19', ' 130', '2.36', '28.73', '0.19', '1', 'barcode', '33', '', '' , '',' ', '', ''");
// =========FOODS TACO ============
    setupInsertToFood(  " NULL, 'Soft Taco with Beef, Cheese, Lettuce, Tomato and Sour Cream', '', 'Taco','100', 'g', '1', 'portion', ' 246', '11.87', '19.37', '13.23', ' 246', '11.87', '19.37', '13.23', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco', '', 'Taco','100', 'g', '1', 'portion', ' 216', '12.08', '15.63', '12.02', ' 216', '12.08', '15.63', '12.02', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco Shells (Baked)', '', 'Taco','100', 'g', '1', 'portion', ' 468', '7.20', '62.40', '22.60', ' 468', '7.20', '62.40', '22.60', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco Salad', '', 'Taco','100', 'g', '1', 'portion', ' 141', '6.68', '11.91', '7.46', ' 141', '6.68', '11.91', '7.46', '1', 'barcode', '34', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Taco Shells (Without Added Salt, Baked)', '', 'Taco','100', 'g', '1', 'portion', ' 468', '7.20', '62.40', '22.60', ' 468', '7.20', '62.40', '22.60', '1', 'barcode', '34', '', '' , '',' ', '', ''");
// =========FOODS CREAM CHEESE ============
    setupInsertToFood(  " NULL, 'Cream Cheese', '', 'Cream cheese','100', 'g', '1', 'portion', ' 349', '7.55', '2.66', '34.87', ' 349', '7.55', '2.66', '34.87', '1', 'barcode', '36', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Light or Lite Cream Cheese', '', 'Cream cheese','100', 'g', '1', 'portion', ' 231', '10.60', '7.00', '17.60', ' 231', '10.60', '7.00', '17.60', '1', 'barcode', '36', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cream Cheese', '', 'Cream cheese','100', 'g', '1', 'portion', ' 349', '7.55', '2.66', '34.87', ' 349', '7.55', '2.66', '34.87', '1', 'barcode', '36', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Regular Cream Cheese  Spread', '', 'Cream cheese','100', 'g', '1', 'portion', ' 295', '7.10', '3.50', '28.60', ' 295', '7.10', '3.50', '28.60', '1', 'barcode', '36', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Nonfat or Fat Free Processed Cream Cheese', '', 'Cream cheese','100', 'g', '1', 'portion', ' 96', '14.41', '5.80', '1.36', ' 96', '14.41', '5.80', '1.36', '1', 'barcode', '36', '', '' , '',' ', '', ''");
// =========FOODS COLD MEATS ============
    setupInsertToFood(  " NULL, 'Sausage (Not Cold Cut)', '', 'Cold meats','100', 'g', '1', 'portion', ' 339', '19.43', '0.00', '28.36', ' 339', '19.43', '0.00', '28.36', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cold Cut', '', 'Cold meats','100', 'g', '1', 'portion', ' 208', '14.63', '3.60', '14.66', ' 208', '14.63', '3.60', '14.66', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola with Chocolate Flavor', '', 'Cold meats','100', 'g', '1', 'portion', ' 37', '0.07', '9.56', '0.02', ' 37', '0.07', '9.56', '0.02', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Cola with Fruit or Vanilla Flavor', '', 'Cold meats','100', 'g', '1', 'portion', ' 37', '0.07', '9.56', '0.02', ' 37', '0.07', '9.56', '0.02', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Beef or Meat Gravy', '', 'Cold meats','100', 'g', '1', 'portion', ' 53', '3.75', '4.81', '2.36', ' 53', '3.75', '4.81', '2.36', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Light Turkey Meat (Skin Eaten)', '', 'Cold meats','100', 'g', '1', 'portion', ' 197', '28.57', '0.00', '8.34', ' 197', '28.57', '0.00', '8.34', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dim Sum (Meat Filled Egg Roll-Type)', '', 'Cold meats','100', 'g', '1', 'portion', ' 112', '11.55', '9.56', '2.64', ' 112', '11.55', '9.56', '2.64', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Lower in Fat Meat and Cheese Turnover', '', 'Cold meats','100', 'g', '1', 'portion', ' 228', '10.42', '33.26', '5.56', ' 228', '10.42', '33.26', '5.56', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Meat Filled Tortellini with Tomato Sauce (Canned)', '', 'Cold meats','100', 'g', '1', 'portion', ' 91', '3.58', '15.24', '1.90', ' 91', '3.58', '15.24', '1.90', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Baked or Fried Breaded Light Turkey Meat', '', 'Cold meats','100', 'g', '1', 'portion', ' 222', '26.72', '6.40', '9.11', ' 222', '26.72', '6.40', '9.11', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Roasted Light Turkey Meat (Skin Not Eaten)', '', 'Cold meats','100', 'g', '1', 'portion', ' 157', '29.91', '0.00', '3.22', ' 157', '29.91', '0.00', '3.22', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Roasted Light Turkey Meat (Skin Eaten)', '', 'Cold meats','100', 'g', '1', 'portion', ' 197', '28.57', '0.00', '8.34', ' 197', '28.57', '0.00', '8.34', '1', 'barcode', '38', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Fried Battered Light or Dark Turkey Meat (Skin Eaten)', '', 'Cold meats','100', 'g', '1', 'portion', ' 283', '14.00', '15.70', '18.00', ' 283', '14.00', '15.70', '18.00', '1', 'barcode', '38', '', '' , '',' ', '', ''");
// =========FOODS SWEET SPREADS ============
// =========FOODS JAM ============
    setupInsertToFood(  " NULL, 'Jam Preserves', '', 'Jam','100', 'g', '1', 'portion', ' 260', '0.54', '66.63', '0.14', ' 260', '0.54', '66.63', '0.14', '1', 'barcode', '40', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Jams and Preserves', '', 'Jam','100', 'g', '1', 'portion', ' 278', '0.37', '68.86', '0.07', ' 278', '0.37', '68.86', '0.07', '1', 'barcode', '40', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Reduced Sugar Jelly', '', 'Jam','100', 'g', '1', 'portion', ' 179', '0.30', '46.10', '0.03', ' 179', '0.30', '46.10', '0.03', '1', 'barcode', '40', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Orange Marmalade', '', 'Jam','100', 'g', '1', 'portion', ' 246', '0.30', '66.30', '0.00', ' 246', '0.30', '66.30', '0.00', '1', 'barcode', '40', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Marmalade', '', 'Jam','100', 'g', '1', 'portion', ' 246', '0.30', '66.30', '0.00', ' 246', '0.30', '66.30', '0.00', '1', 'barcode', '40', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Jelly (All Flavors)', '', 'Jam','100', 'g', '1', 'portion', ' 266', '0.15', '69.95', '0.02', ' 266', '0.15', '69.95', '0.02', '1', 'barcode', '40', '', '' , '',' ', '', ''");
// =========FOODS NUTS ============
    setupInsertToFood(  " NULL, 'Walnuts', '', 'Nuts','100', 'g', '1', 'portion', ' 654', '15.23', '13.71', '65.21', ' 654', '15.23', '13.71', '65.21', '1', 'barcode', '42', '', '' , '',' ', '', ''");
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
    setupInsertToFood(  " NULL, 'Dried European Chestnuts (Peeled)', '', 'Nuts','100', 'g', '1', 'portion', ' 369', '5.01', '78.43', '3.91', ' 369', '5.01', '78.43', '3.91', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Ginkgo Nuts', '', 'Nuts','100', 'g', '1', 'portion', ' 182', '4.32', '37.60', '1.68', ' 182', '4.32', '37.60', '1.68', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Dry Roasted Pistachio Nuts (Without Salt Added)', '', 'Nuts','100', 'g', '1', 'portion', ' 571', '21.35', '27.65', '45.97', ' 571', '21.35', '27.65', '45.97', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Oil Roasted Pecan Nuts (Without Salt Added)', '', 'Nuts','100', 'g', '1', 'portion', ' 715', '9.20', '13.01', '75.23', ' 715', '9.20', '13.01', '75.23', '1', 'barcode', '42', '', '' , '',' ', '', ''");
    setupInsertToFood(  " NULL, 'Sugar Coated Peanuts', '', 'Nuts','100', 'g', '1', 'portion', ' 522', '15.50', '47.40', '33.70', ' 522', '15.50', '47.40', '33.70', '1', 'barcode', '42', '', '' , '',' ', '', ''");
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

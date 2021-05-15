package com.example.dietstram.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.dietstram.IOnBackPressed;
import com.example.dietstram.database.DBAdapter;
import com.example.dietstram.database.DBSetupInsert;
import com.example.dietstram.database.Idioms;
import com.example.dietstram.MainActivity;
import com.example.dietstram.R;
import com.example.dietstram.ui.addfood.AddFoodToDiaryFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.example.dietstram.helpers.ConvertClass.changeTitle;

public class HomeFragment extends Fragment implements IOnBackPressed {

    //Holding variables
    private String currentData;

    /* Fields */
    private View mainView;
    /*My fields*/
    Cursor listCursor;
    Cursor listCursorFood;

    /* ProgressBar */
    ProgressBar progressBarEnergy;
    ProgressBar progressBarProtein;
    ProgressBar progressBarCarbs;
    ProgressBar progressBarFat;


    /* TextView */
    TextView textViewFoodName;//.findViewById(R.id.textViewFoodName);
    TextView textViewFoodManufactureName;//.findViewById(R.id.textViewManufacture);
    TextView textViewFoodAbout;//.findViewById(R.id.textViewFoodAbout);
    TextView textViewDescription;//.findViewById(R.id.textViewFoodDescription);

    TextView textViewFoodEnergyPerHundred;//.findViewById(R.id.textViewFoodEnergyPerHundred);
    TextView textViewFoodProteinsPerHundred;//.findViewById(R.id.textViewFoodProteinsPerHundred);
    TextView textViewFoodCarbsPerHundred;//.findViewById(R.id.textViewFoodCarbsPerHundred);
    TextView textViewFoodFatPerHundred;//.findViewById(R.id.textViewFoodFatPerHundred);

    TextView textViewFoodEnergyPerN;//.findViewById(R.id.textViewFoodEnergyPerN);
    TextView textViewFoodProteinsPerN;//.findViewById(R.id.textViewFoodProteinsPerN);
    TextView textViewFoodCarbsPerN;//.findViewById(R.id.textViewFoodCarbsPerN);
    TextView textViewFoodFatPerN;//.findViewById(R.id.textViewFoodFatPerN);


    /* EditText */
    EditText editTextPortionSizePCS;
    EditText editTextPortionSizeGram;


    /* --------------------------------------------------- */


    /* My fields */
    Cursor listCategoryCursor;
    int error;

    /* Action buttons */
    MenuItem menuItemEdit;
    MenuItem menuItemDelete;

    /* Holder on buttons on toolbar */
    private String currentCategoryId;
    private String currentCategoryName;

    private String currentFoodId;
    private String currentFoodName;
    String currentFdId;

    private String currentMealNumber;

    private String currentPortionSizePCS;
    private String currentPortionSizeGram;
    private boolean lockPortionSizePCS = false;
    private boolean lockPortionSizeGram = false;

    @Override
    public boolean onBackPressed() {
        return true;
    }


    private void setAllWidgets() {

        //Progress bar
        progressBarEnergy = getView().findViewById(R.id.progressBarEnergy);
        progressBarProtein = getView().findViewById(R.id.progressBarProtein);
        progressBarCarbs = getView().findViewById(R.id.progressBarCarbs);
        progressBarFat = getView().findViewById(R.id.progressBarFat);


        textViewFoodName = getView().findViewById(R.id.textViewFoodName);
        textViewFoodManufactureName = getView().findViewById(R.id.textViewManufacture);
        textViewFoodAbout = getView().findViewById(R.id.textViewFoodAbout);
        textViewDescription = getView().findViewById(R.id.textViewFoodDescription);
        //Values from table
        textViewFoodEnergyPerHundred = getView().findViewById(R.id.textViewFoodEnergyPerHundred);
        textViewFoodProteinsPerHundred = getView().findViewById(R.id.textViewFoodProteinsPerHundred);
        textViewFoodCarbsPerHundred = getView().findViewById(R.id.textViewFoodCarbsPerHundred);
        textViewFoodFatPerHundred = getView().findViewById(R.id.textViewFoodFatPerHundred);

        textViewFoodEnergyPerN = getView().findViewById(R.id.textViewFoodEnergyPerN);
        textViewFoodProteinsPerN = getView().findViewById(R.id.textViewFoodProteinsPerN);
        textViewFoodCarbsPerN = getView().findViewById(R.id.textViewFoodCarbsPerN);
        textViewFoodFatPerN = getView().findViewById(R.id.textViewFoodFatPerN);

        editTextPortionSizePCS = getActivity().findViewById(R.id.editTextPortionSizePCS);
        editTextPortionSizeGram = getActivity().findViewById(R.id.editTextPortionSizeGram);


    }


    private DBAdapter getDbAdapter() {
        DBAdapter db = new DBAdapter(getActivity());
        db.open();
        return db;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Set title */
        changeTitle(getActivity(), "Home");

    }

    private void setHi() {
        TextView textViewHi = getActivity().findViewById(R.id.textViewHi);
        String[] fields = {"user_nickname"};
        DBAdapter db = getDbAdapter();
        Cursor cursor = db.select("users", fields, "_id", db.quoteSmart(MainActivity.USER_ID));
        if (cursor.getCount() != 0) {
            String userName = cursor.getString(0);
            Idioms idioms = new Idioms();
            textViewHi.setText(String.format(getActivity().getString(R.string.hi), userName, idioms.currentIdiom));
        }
        db.close();

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        mainView = inflater.inflate(R.layout.fragment_home, container, false);

        return mainView;
    }

    private MenuItem menuItemAddFood;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        //Inflate menu
        ((MainActivity) getActivity()).getMenuInflater().inflate(R.menu.menu_home, menu);

        //Assign variables
        menuItemAddFood = menu.findItem(R.id.action_add_food);
        menuItemAddFood.setVisible(true);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add_food) {
            addFoodTODiarySelectMealNumber();
        }

        return super.onOptionsItemSelected(item);
    }

    private void addFoodTODiarySelectMealNumber() {
        changeLayout(R.layout.fragment_home_select_meal_number);

        DBAdapter db = getDbAdapter();
        String[] fieldsMeal = {"_id," +
            "meal_name"};
        Cursor c = db.select("meal", fieldsMeal, "meal_date", db.quoteSmart(currentData));
        db.close();

        TableLayout tableLayoutMain = getActivity().findViewById(R.id.tableViewMealNames);
        for (int i = 0; i < c.getCount(); i++) {

            final String mealId = c.getString(0);

            TableRow tableRowMealName = new TableRow(getActivity());

            /* Name */
            TableRow.LayoutParams textNameParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 8f);
            TextView textViewMealName = new TextView(new ContextThemeWrapper(getActivity(), R.style.Widget_TextViewBig), null, 0);
            textViewMealName.setText(c.getString(1));
            tableRowMealName.addView(textViewMealName, textNameParams);

            textViewMealName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addFood(Integer.parseInt(mealId));
                }
            });


            tableLayoutMain.addView(tableRowMealName);

            /* Blue line */
            View view = new View(getActivity());
            TableRow.LayoutParams viewParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);

            viewParams.height = 2;

            view.setBackground(ContextCompat.getDrawable(getActivity(), R.color.light_blue));
            tableLayoutMain.addView(view, viewParams);

            c.moveToNext();
        }

    }

    /* Change layout ----------------------------------------- */
    private void changeLayout(int id) {
        /*  Change layout */
        setMainView(id);
    }

    private void setMainView(int id) {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mainView = inflater.inflate(id, null);
        ViewGroup rootView = (ViewGroup) getView();
        rootView.removeAllViews();
        rootView.addView(mainView);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setAllWidgets();
        setHi();
        initializeHome();
        setHasOptionsMenu(true);
    }

    private void initializeHome() {

        /* Database */
        DBAdapter db = getDbAdapter();

        /*Find data*/
        //Date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        currentData = dateFormat.format(Calendar.getInstance().getTime());
        String fdDataSQL = db.quoteSmart(currentData);

        writeAllMealNames();

        //Calculate of eaten calories today
        calculateNumberOfCalEatenToday();

        Button buttonAddMeal = getActivity().findViewById(R.id.buttonAddMeal);
        buttonAddMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMealName();
            }
        });

    }

    private void addMealName() {

        changeLayout(R.layout.fragment_add_meal_name);
        hideError();
        final EditText editTextAddMealName = getActivity().findViewById(R.id.editTextAddMealName);

        Button buttonCancel = getActivity().findViewById(R.id.buttonCancel);
        Button buttonSubmit = getActivity().findViewById(R.id.buttonSubmit);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartFragmentHome();
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextAddMealName.getText().toString().isEmpty()) {
                    DBSetupInsert setupInsert = new DBSetupInsert(getActivity());
                    setupInsert.setupInsertToMeal("NULL,'" + currentData + "', '" + editTextAddMealName.getText().toString() + "'");
                    restartFragmentHome();
                } else {
                    showError();
                }
            }
        });

    }

    private void showError() {
        /* ImageView -------------------------------------------------------------------------------- */
        ImageView imageViewError = getActivity().findViewById(R.id.imageViewError);
        TextView textViewErrorMessage = getActivity().findViewById(R.id.textViewErrorMessage);
        textViewErrorMessage.setText(R.string.meal_name_error);
        textViewErrorMessage.setVisibility(View.VISIBLE);
        imageViewError.setVisibility(View.VISIBLE);
    }

    private void hideError() {
        /* ImageView -------------------------------------------------------------------------------- */
        ImageView imageViewError = getActivity().findViewById(R.id.imageViewError);
        TextView textViewErrorMessage = getActivity().findViewById(R.id.textViewErrorMessage);
        textViewErrorMessage.setVisibility(View.GONE);
        imageViewError.setVisibility(View.GONE);
    }

    private void writeAllMealNames() {
        DBAdapter db = getDbAdapter();
        String[] fieldsMeal = {"_id," +
            "meal_name"};
        Cursor c = db.select("meal", fieldsMeal, "meal_date", db.quoteSmart(currentData));
        db.close();

        TableLayout tableLayoutMain = getActivity().findViewById(R.id.tableLayoutHomeMain);
        for (int i = 0; i < c.getCount(); i++) {

            final String mealId = c.getString(0);

            //Zero row (Grey Line View)
            View view = new View(getActivity());
            TableRow.LayoutParams viewParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);

            viewParams.height = 40;
            view.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.bg_all));
            tableLayoutMain.addView(view, viewParams);

            /* Header : Row [Name+ button] + Row [LinearLayout] */
            final TableLayout tableLayoutHeaderStyle = new TableLayout(getActivity());
            tableLayoutHeaderStyle.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.bg_meal_table));


            //First Row
            TableRow tableRowMealName = new TableRow(getActivity());

            /* Button */
            TableRow.LayoutParams buttonParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
            ImageButton buttonAdd = new ImageButton(new ContextThemeWrapper(getActivity(), R.style.Widget_MyButtonAdd), null, 0);
            buttonAdd.setImageResource(R.drawable.ic_menu_action_add);
            buttonAdd.setForegroundGravity(Gravity.CENTER_VERTICAL);
            tableRowMealName.addView(buttonAdd, buttonParams);
            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    addFood(Integer.parseInt(mealId));
                    calculateNumberOfCalEatenToday();
                }
            });


            /* Name */
            TableRow.LayoutParams textNameParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 7f);
            TextView textViewMealName = new TextView(new ContextThemeWrapper(getActivity(), R.style.Widget_TextViewBig), null, 0);
            textViewMealName.setText(c.getString(1));
            textViewMealName.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    createAlertDialog(Integer.parseInt(mealId));
                    return true;
                }
            });
            tableRowMealName.addView(textViewMealName, textNameParams);
            // //First Row

            //Second Row -- components total
            TableRow.LayoutParams linearLayoutParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
            linearLayoutParams.setMarginStart(100);
            LinearLayout linearLayoutSubLine = new LinearLayout(getContext());
            linearLayoutSubLine.setLayoutParams(linearLayoutParams);

            //Add table rows
            tableLayoutHeaderStyle.addView(tableRowMealName);
            tableLayoutHeaderStyle.addView(linearLayoutSubLine, linearLayoutParams);
            //  tableLayoutHeaderStyle.addView(tableLayoutSubHeader);

//todo убрать при переходе на другой layout

            /* Sub table layout */
            final TableLayout tableLayoutSub = new TableLayout(getActivity());
            tableLayoutSub.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.bf_meal_sub_table));
            updateTableItems(mealId, tableLayoutSub, linearLayoutSubLine);

            /* Button popUp  */
            TableRow.LayoutParams buttonMoreLessParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
            final ImageButton buttonMoreLess = new ImageButton(new ContextThemeWrapper(getActivity(), R.style.Widget_MyButtonAdd), null, 0);
            buttonMoreLess.setImageResource(R.drawable.ic_down);
            buttonMoreLess.setForegroundGravity(Gravity.BOTTOM);
            tableRowMealName.addView(buttonMoreLess, buttonMoreLessParams);
            final boolean[] showFlag = {false};
            final PopupWindow popupWindow = new PopupWindow(getActivity());

            buttonMoreLess.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showFlag[0] = !showFlag[0];
                    if (showFlag[0]) {
                        showPopup(popupWindow, tableLayoutSub, tableLayoutHeaderStyle, buttonMoreLess);
                        buttonMoreLess.setImageResource(R.drawable.ic_up);

                    } else {
                        buttonMoreLess.setImageResource(R.drawable.ic_down);
                        popupWindow.dismiss();
                    }
                }
            });


            //tableLayoutHeader.addView(tableLayoutSub);

            //Очередной заполненный Meal
            tableLayoutMain.addView(tableLayoutHeaderStyle);

            //Sub  push to popUp
            //tableLayoutMain.addView(tableLayoutSub);
            c.moveToNext();
        }
    }

    @Override
    public void onDetach() {

        super.onDetach();
    }

    // The method that displays the popup.
    private void showPopup(final PopupWindow popupWindow, TableLayout tableLayoutSub, TableLayout tableLayoutHeader, final ImageButton buttonMoreLess) {

        //((ViewGroup) tableLayoutSub.getParent()).removeView(tableLayoutSub);
        popupWindow.setContentView(tableLayoutSub);
        tableLayoutSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonMoreLess.setImageResource(R.drawable.ic_down);
                popupWindow.dismiss();
            }
        });
        popupWindow.showAsDropDown(tableLayoutHeader);

    }


    private void createAlertDialog(final int mealId) {
        String button1String = "Delete";
        String button2String = "Cancel";

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Delete");  // заголовок
        builder.setMessage("Do you want to delete this meal item?"); // сообщение
        builder.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                DBAdapter db = getDbAdapter();
                db.delete("meal", "_id", mealId);
                db.close();

                Toast.makeText(getActivity(), "Deleted", Toast.LENGTH_LONG)
                    .show();
                restartFragmentHome();
            }
        });
        builder.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.setCancelable(true);
        builder.show();

    }

    private void calculateNumberOfCalEatenToday() {
        DBAdapter db = getDbAdapter();

        String currentDateSQL = db.quoteSmart(currentData);

        //Select
        String[] fieldsFdSum = new String[]{
            "_id ",
            "fd_sum_date ",
            "fd_sum_energy ",
            "fd_sum_protein ",
            "fd_sum_carbs ",
            "fd_sum_fat "
        };

        //Выбираем сегодняшнюю сумму
        Cursor cursorFdSum = db.select("food_diary_sum", fieldsFdSum, "fd_sum_date", db.quoteSmart(currentData));

        int fdceEatenEnergy = 0;
        int fdceEatenProteins = 0;
        int fdceEatenCarbs = 0;
        int fdceEatenFat = 0;

        //Считаем сумму через food_diary
        String[] fieldsFDCE = {
            "fdce_eaten_energy ",
            "fdce_eaten_protein ",
            "fdce_eaten_carbs ",
            "fdce_eaten_fat "};
        Cursor cursorFdce = db.select("food_diary_cal_eaten", fieldsFDCE, "fdce_date", currentDateSQL);
        for (int i = 0; i < cursorFdce.getCount(); i++) {
            fdceEatenEnergy += Integer.parseInt(cursorFdce.getString(0));
            fdceEatenProteins += Integer.parseInt(cursorFdce.getString(1));
            fdceEatenCarbs += Integer.parseInt(cursorFdce.getString(2));
            fdceEatenFat += Integer.parseInt(cursorFdce.getString(3));
            cursorFdce.moveToNext();
        }


        //Если еще ничего нет то заполянем
        if (cursorFdSum.getCount() == 0) {
            //Insert database
            String insertFields = "_id ," +
                "fd_sum_date ," +
                "fd_sum_energy ," +
                "fd_sum_protein ," +
                "fd_sum_carbs ," +
                "fd_sum_fat ";
            String insertValues = "NULL," +
                db.quoteSmart(currentData) + "," +
                db.quoteSmart(fdceEatenEnergy) + "," +
                db.quoteSmart(fdceEatenProteins) + "," +
                db.quoteSmart(fdceEatenCarbs) + " ," +
                db.quoteSmart(fdceEatenFat);

            db.insert("food_diary_sum", insertFields, insertValues);

        } else {
            // Update

            String[] updateFields = {"fd_sum_energy ",
                "fd_sum_protein ",
                "fd_sum_carbs ",
                "fd_sum_fat "};
            String[] updateValues = {db.quoteSmart("" + fdceEatenEnergy),
                db.quoteSmart("" + fdceEatenProteins),
                db.quoteSmart("" + fdceEatenCarbs),
                db.quoteSmart("" + fdceEatenFat)};

            long id = Long.parseLong(cursorFdSum.getString(0));

            db.update("food_diary_sum", "_id", id, updateFields, updateValues);

        }
        /* Update head table */
        updateUpperTable();

        db.close();
    }


    private void moveToAddFoodToDiaryLayout(int mealNumber) {

        Class<AddFoodToDiaryFragment> fragmentClass = AddFoodToDiaryFragment.class;


        Bundle bundle = new Bundle();
        bundle.putString("mealNumber", String.valueOf(mealNumber));
        bundle.putString("currentFoodId", "");
        bundle.putString("action", "");
        Fragment fragment = null;
        try {
            fragment = fragmentClass.newInstance();

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        //Need to pass meal number
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).addToBackStack(null).commit();
    }


    /* Update Table */
    private void updateTableItems(String mealNumber, TableLayout tableLayout, LinearLayout linearLayoutSubLineTotal) {

        DBAdapter db = getDbAdapter();

        String currentDateSQL = db.quoteSmart(currentData);
        String mealNoSql = db.quoteSmart(mealNumber);

        //Select
        String[] fieldsFdce = new String[]{
            "_id ",
            "fdce_date ",
            "fdce_meal_no ",
            "fdce_eaten_energy ",
            "fdce_eaten_protein ",
            "fdce_eaten_carbs ",
            "fdce_eaten_fat "
        };
        String[] fdceWhereClause = {"fdce_date",
            "fdce_meal_no"};
        String[] fdceWhereCondition = {currentDateSQL,
            mealNoSql};
        String[] fdceWhereAndOr = {" AND "};


        Cursor cursorFdce;
        cursorFdce = db.select("food_diary_cal_eaten", fieldsFdce, fdceWhereClause, fdceWhereCondition, fdceWhereAndOr);

        if (cursorFdce.getCount() == 0) {
            String insertFields = "_id ," +
                "fdce_date ," +
                "fdce_meal_no ," +
                "fdce_eaten_energy ," +
                "fdce_eaten_protein ," +
                "fdce_eaten_carbs ," +
                "fdce_eaten_fat ";
            String insertValues = "Null," +
                db.quoteSmart(currentData) + "," +
                db.quoteSmart(mealNumber) + "," +
                "'0' ," +
                "'0' ," +
                "'0' ," +
                "'0' ";
            db.insert("food_diary_cal_eaten", insertFields, insertValues);
            cursorFdce = db.select("food_diary_cal_eaten", fieldsFdce, fdceWhereClause, fdceWhereCondition, fdceWhereAndOr);
        }
        String fdceId = cursorFdce.getString(0);

        String[] fieldsFd = {"_id ",
            "fd_food_id ",
            "fd_serving_size_gram ",
            "fd_serving_size_gram_measurement ",
            "fd_serving_size_pcs  ",
            "fd_serving_size_pcs_measurement  ",
            "fd_energy_calculated ",
            "fd_protein_calculated ",
            "fd_carbohydrates_calculated ",
            "fd_fat_calculated ",
        };

        String[] fdWhereClause = {"fd_date",
            "fd_meal_number"};
        String[] fdWhereCondition = {currentDateSQL,
            mealNoSql};
        String[] fdWhereAndOr = {" AND "};


        Cursor cursorFd = db.select("food_diary", fieldsFd, fdWhereClause, fdWhereCondition, fdWhereAndOr);


        String[] fieldsFood = {"_id ",
            " food_name",
            " food_manufactor_name",
            " food_serving_size_gram",
            " food_serving_size_gram_measurement",
            " food_serving_size_pcs",
            " food_serving_size_pcs_measurement",
            " food_energy_calculated ",
        };
        Cursor cursorFood;

        //Ready variables for sum

        double fdceEatenEnergy = 0;
        double fdceEatenProteins = 0;
        double fdceEatenCarbs = 0;
        double fdceEatenFat = 0;

        //Loop through cursor
        for (int i = 0; i < cursorFd.getCount(); i++) {
            //Variables from food_diary
            String fdId = cursorFd.getString(1);

            String fdEnergyCalculated = cursorFd.getString(6);
            String fdProteinCalculated = cursorFd.getString(7);
            String fdCarbsCalculated = cursorFd.getString(8);
            String fdFatCalculated = cursorFd.getString(9);

            //food name
            cursorFood = db.select("food", fieldsFood, "_id", db.quoteSmart(fdId));
            final String foodName = cursorFood.getString(1);
            String foodManufacture = cursorFood.getString(2);


            TableRow tableRow = new TableRow(getActivity());
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));

            //TextView Name
            TableRow.LayoutParams params = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
            final TextView textViewName = new TextView(new ContextThemeWrapper(getActivity(), R.style.Widget_TextViewSimple), null, 0);
            textViewName.setText(foodName);
            tableRow.addView(textViewName, params);

            LinearLayout linearLayoutSubLineFood = getSubLine(getContext(), fdEnergyCalculated, fdProteinCalculated, fdCarbsCalculated, fdFatCalculated);


            tableLayout.addView(tableRow);
            tableLayout.addView(linearLayoutSubLineFood);


            tableRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rowOnClickEditDeleteLine(foodName);
                }
            });


            //Sum fields
            fdceEatenEnergy += Integer.parseInt(fdEnergyCalculated);
            fdceEatenProteins += Integer.parseInt(fdProteinCalculated);
            fdceEatenCarbs += Integer.parseInt(fdCarbsCalculated);
            fdceEatenFat += Integer.parseInt(fdFatCalculated);

            cursorFd.moveToNext();
        }

        /* Total Fat,Protein,Carbs */
        TableRow.LayoutParams linearLayoutParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
        linearLayoutParams.setMarginStart(30);
        linearLayoutSubLineTotal.addView(getSubLine(getContext(), String.valueOf(fdceEatenEnergy), String.valueOf(fdceEatenProteins), String.valueOf(fdceEatenCarbs), String.valueOf(fdceEatenFat)), linearLayoutParams);

        if (!fdceId.equals("-1")) {
            //Update fdce_table
            String[] updateFields = {"fdce_eaten_energy ",
                "fdce_eaten_protein ",
                "fdce_eaten_carbs ",
                "fdce_eaten_fat "};
            String[] updateValues = {db.quoteSmart("" + fdceEatenEnergy),
                db.quoteSmart("" + fdceEatenProteins),
                db.quoteSmart("" + fdceEatenCarbs),
                db.quoteSmart("" + fdceEatenFat)};
            db.update("food_diary_cal_eaten", "_id", Long.parseLong(fdceId), updateFields, updateValues);
        }

        db.close();
    }


    /* Add food ------------------------------------ */
    private void addFood(int mealNumber) {

        moveToAddFoodToDiaryLayout(mealNumber);
    }

    /* 0000000000000000000000000000000000000000000000000000000000000000000000000000000000000 */
    private void onClickEditFdLineSubmit() {

        //we want to edit food
        int error = 0;
        DBAdapter db = getDbAdapter();
        long fdId = Long.parseLong(currentFdId);

        //Get food info
        String[] fields = {
            " food_serving_size_gram",
            " food_energy",
            " food_protein",
            " food_carbohydrates",
            " food_fat "
        };

        String currentIdSQL = db.quoteSmart(currentFoodId);
        Cursor foodCursor = db.select("food", fields, "_id", currentIdSQL);

        //Convert cursor to string
        double foodServingSizeGramOld = Double.parseDouble(foodCursor.getString(0));

        double foodEnergy = Double.parseDouble(foodCursor.getString(1));
        double foodProteins = Double.parseDouble(foodCursor.getString(2));
        double foodCarbohydrates = Double.parseDouble(foodCursor.getString(3));
        double foodFat = Double.parseDouble(foodCursor.getString(4));


        //Update fd serving size gpcs
        double servingSizePCS = Double.parseDouble(editTextPortionSizePCS.getText().toString());
        db.update("food_diary", "_id", fdId, "fd_serving_size_pcs", db.quoteSmart(servingSizePCS));


        //Update fd serving size gram
        EditText editText = getActivity().findViewById(R.id.editTextPortionSizeGram);
        double servingSizeGram = Double.parseDouble(editText.getText().toString());
        db.update("food_diary", "_id", fdId, "fd_serving_size_gram", db.quoteSmart(servingSizeGram));

        //Energy calculated
        double fdEnergyCalculated = Math.round((foodEnergy * servingSizeGram) / 100);
        String fdEnergyCalculatedSQL = db.quoteSmart("" + fdEnergyCalculated);
        db.update("food_diary", "_id", fdId, "fd_energy_calculated", fdEnergyCalculatedSQL);

        //Proteins calculated
        double fdProteinCalculated = Math.round((foodProteins * servingSizeGram) / 100);
        String fdProteinCalculatedSQL = db.quoteSmart("" + fdProteinCalculated);
        db.update("food_diary", "_id", fdId, "fd_protein_calculated", fdProteinCalculatedSQL);

        //Carbohydrates calculated
        double fdCarbohydratesCalculated = Math.round((foodCarbohydrates * servingSizeGram) / 100);
        String fdCarbohydratesCalculatedSQL = db.quoteSmart("" + fdCarbohydratesCalculated);
        db.update("food_diary", "_id", fdId, "fd_carbohydrates_calculated", fdCarbohydratesCalculatedSQL);


        //Fat calculated
        double fdFatCalculated = Math.round((foodFat * servingSizeGram) / 100);
        String fdFatCalculatedSQL = db.quoteSmart("" + fdFatCalculated);
        db.update("food_diary", "_id", fdId, "fd_fat_calculated", fdFatCalculatedSQL);

        db.close();
        Toast.makeText(getActivity(), "Saved " + currentFoodName, Toast.LENGTH_SHORT).show();

        restartFragmentHome();
    }


    private void onClickDeleteFdLineSubmit() {
        DBAdapter db = getDbAdapter();
        long fdId = Long.parseLong(currentFdId);

        db.delete("food_diary", "_id", fdId);
        db.close();

        Toast.makeText(getActivity(), "Deleted " + currentFoodName, Toast.LENGTH_SHORT).show();

        restartFragmentHome();

    }

    private void restartFragmentHome() {

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, new HomeFragment(), HomeFragment.class.getName()).addToBackStack(null).commit();
    }


    private void rowOnClickEditDeleteLine(String stringTableRowTextName) {

        //show edit button
        DBAdapter db = getDbAdapter();
        changeLayout(R.layout.fragment_home_edit_or_delete);
        setAllWidgets();

        String[] fieldsFd = {"_id ",
            "fd_food_id",
            "fd_serving_size_gram ",
            "fd_serving_size_gram_measurement ",
            "fd_serving_size_pcs  ",
            "fd_serving_size_pcs_measurement  ",
            "fd_energy_calculated ",
            "fd_protein_calculated ",
            "fd_carbohydrates_calculated ",
            "fd_fat_calculated "
        };

        //Сегодняшняя еда
        Cursor cursorFd = db.select("food_diary", fieldsFd, "fd_date", db.quoteSmart(currentData));
        String stringFdId = cursorFd.getString(0);

        /* Get data from database */
        String[] fieldsFood = new String[]{"_id",
            " food_name",
            " food_manufactor_name",
            " food_energy ",
            " food_protein ",
            " food_carbohydrates ",
            " food_fat ",
            " food_energy_calculated ",
            " food_protein_calculated ",
            " food_carbohydrates_calculated ",
            " food_fat_calculated ",
        };

        //Convert Cursor to strings
        String foodId = "";
        String name = "";
        String manufactureName = "";
        String energy = "";
        String protein = "";
        String carbohydrates = "";
        String fat = "";
        String energyCalculated = "";
        String proteinCalculated = "";
        String carbohydratesCalculated = "";
        String fatCalculated = "";

        String servingSizeGram = "";
        String servingSizeGramMeasurement = "";
        String servingSizePcs = "";
        String servingSizePCSMeasurement = "";

        Cursor cursorFood;

        for (int i = 0; i < cursorFd.getCount(); i++) {

            stringFdId = cursorFd.getString(0);
            foodId = cursorFd.getString(1);
            servingSizeGram = cursorFd.getString(2);
            servingSizeGramMeasurement = cursorFd.getString(3);
            servingSizePcs = cursorFd.getString(4);
            servingSizePCSMeasurement = cursorFd.getString(5);
            energyCalculated = cursorFd.getString(6);

            cursorFood = db.select("food", fieldsFood, "_id", db.quoteSmart(foodId));
            foodId = cursorFood.getString(0);
            name = cursorFood.getString(1);
            manufactureName = cursorFood.getString(2);
            energy = cursorFood.getString(3);
            protein = cursorFood.getString(4);
            carbohydrates = cursorFood.getString(5);
            fat = cursorFood.getString(6);
            energyCalculated = String.valueOf(Math.round(Double.parseDouble(servingSizePcs) * Double.parseDouble(energy)));
            proteinCalculated = String.valueOf(Math.round(Double.parseDouble(servingSizePcs) * Double.parseDouble(protein)));
            carbohydratesCalculated = String.valueOf(Math.round(Double.parseDouble(servingSizePcs) * Double.parseDouble(carbohydrates)));
            fatCalculated = String.valueOf(Math.round(Double.parseDouble(servingSizePcs) * Double.parseDouble(fat)));

            String subLine = manufactureName + ", " +
                servingSizeGram + " " +
                servingSizeGramMeasurement + ", " +
                servingSizePcs + " " +
                servingSizePCSMeasurement;

            if (stringTableRowTextName.equals(name)) {
                break;
            } else if (stringTableRowTextName.equals(subLine)) {
                break;
            }
            cursorFd.moveToNext();
        }


        db.close();


        //Show fields
        currentFoodName = name;
        currentFoodId = foodId;
        currentFdId = stringFdId;

        //textViewFoodName
        TextView textViewFoodName = getActivity().findViewById(R.id.textViewFoodName);
        textViewFoodName.setText(name);

        //textViewFoodManufactureName
        TextView textViewFoodManufactureName = getActivity().findViewById(R.id.textViewFoodManufactureName);
        textViewFoodManufactureName.setText(manufactureName);


        //editTextServingSizePcs
        EditText editTextServingSizePcs = getActivity().findViewById(R.id.editTextPortionSizePCS);
        editTextServingSizePcs.setText(servingSizePcs);

        //textViewServingSizePcsMeasurement
        TextView textViewServingSizePcsMeasurement = getActivity().findViewById(R.id.textViewServingSizePcsMeasurement);
        textViewServingSizePcsMeasurement.setText(servingSizePCSMeasurement);

        //editTextServingSizeGram
        EditText editTextServingSizeGram = getActivity().findViewById(R.id.editTextPortionSizeGram);
        editTextServingSizeGram.setText(servingSizeGram);


        //textViewServingSizeMeasurement
        TextView textViewServingSizeMeasurement = getActivity().findViewById(R.id.textViewServingSizeMeasurement);
        textViewServingSizeMeasurement.setText(servingSizeGramMeasurement);


        //Values from table
        textViewFoodEnergyPerHundred.setText(energy);
        textViewFoodProteinsPerHundred.setText(protein);
        textViewFoodCarbsPerHundred.setText(carbohydrates);
        textViewFoodFatPerHundred.setText(fat);

        textViewFoodEnergyPerN.setText(energyCalculated);
        textViewFoodProteinsPerN.setText(proteinCalculated);
        textViewFoodCarbsPerN.setText(carbohydratesCalculated);
        textViewFoodFatPerN.setText(fatCalculated);

        /* Listener for editTextPortionSizePCS */
        editTextPortionSizePCS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                editPortionSizePCSOnChanged();
            }
        });

        editTextPortionSizePCS.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String lock = "portionSizePCS";
                    releaseLock(lock);
                }

            }
        });

        /* Listener for editTextPortionSizeGram */
        editTextPortionSizeGram.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                editPortionSizeGramOnChanged();

            }
        });
        editTextPortionSizeGram.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                } else {
                    String lock = "portionSizeGram";
                    releaseLock(lock);
                }

            }
        });


        //Submit Button
        Button buttonSubmitEdit = getActivity().findViewById(R.id.buttonSubmitEdit);
        buttonSubmitEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickEditFdLineSubmit();
            }
        });

        //Submit Button
        Button buttonSubmitDelete = getActivity().findViewById(R.id.buttonSubmitDelete);
        buttonSubmitDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDeleteFdLineSubmit();
            }
        });

    }

    private void releaseLock(String lock) {
        if (lock.equals("portionSizeGram")) {
            lockPortionSizeGram = false;
        } else {
            lockPortionSizePCS = false;
        }

    }

    public void editPortionSizePCSOnChanged() {

        if (!lockPortionSizeGram) {
            lockPortionSizePCS = true;
            //GetValue of pcs
            // editTextPortionSizePCS;
            String portionSizePCS = editTextPortionSizePCS.getText().toString();

            //GetValue of gram
            //editTextPortionSizeGram;
            String portionSizeGram = editTextPortionSizeGram.getText().toString();

            if (portionSizeGram.equals(currentPortionSizePCS) && portionSizeGram.equals(currentPortionSizeGram)) {
                return;
            }
            if (portionSizePCS.isEmpty()) {
                editTextPortionSizeGram.setText("");

            } else {
                double doublePortionSizePCS = Double.parseDouble(portionSizePCS);


                // Calculate how much n portion size is in gram
                /* Get data fro database */
                String[] fields = new String[]{
                    "_id",
                    "food_serving_size_gram",
                    "food_serving_size_gram_measurement",
                    "food_serving_size_pcs",
                    "food_serving_size_pcs_measurement",
                    " food_energy_calculated ",
                    " food_protein_calculated ",
                    " food_carbohydrates_calculated ",
                    " food_fat_calculated ",
                };

                DBAdapter db = getDbAdapter();
                String currentIdSQL = db.quoteSmart(currentFoodId);
                Cursor foodCursor = db.select("food", fields, "_id", currentIdSQL);

                //Convert Cursor to strings
                String servingSize = foodCursor.getString(1);
                String servingMeasurement = foodCursor.getString(2);
                String servingNameNumber = foodCursor.getString(3);
                String servingNameWord = foodCursor.getString(4);


                // Have changed pcs
                // Update gram

                //200 u -1
                //x -----2
                double doublePortionSizeGram = Math.round(doublePortionSizePCS * Double.parseDouble(servingSize) / Double.parseDouble(servingNameNumber));
                editTextPortionSizeGram.setText(String.format(getActivity().getString(R.string.format_double), doublePortionSizeGram));
                updateTablePerN(foodCursor, servingSize, doublePortionSizeGram);


                db.close();


                //Per meal: 1000 kal -120 г
                // x kal -10
                //
            }
        }
    }

    private void updateTablePerN(Cursor foodCursor, String servingSize, double doublePortionSizeGram) {
        //energy, size gram
        //new energy= energyOld*newSize/oldSize
        String energyOld = foodCursor.getString(5);
        String proteinOld = foodCursor.getString(6);
        String carbsOld = foodCursor.getString(7);
        String fatOld = foodCursor.getString(8);


        double koeff = doublePortionSizeGram / Double.parseDouble(servingSize);
        double energyNew = Double.parseDouble(energyOld) * koeff;
        double proteinNew = Double.parseDouble(proteinOld) * koeff;
        double carbsNew = Double.parseDouble(carbsOld) * koeff;
        double fatNew = Double.parseDouble(fatOld) * koeff;


        //String.format(getActivity().getString(R.string.format_double), doublePortionSizePCS)
        textViewFoodEnergyPerN.setText(String.format(getActivity().getString(R.string.format_double), energyNew));
        textViewFoodProteinsPerN.setText(String.format(getActivity().getString(R.string.format_double), proteinNew));
        textViewFoodCarbsPerN.setText(String.format(getActivity().getString(R.string.format_double), carbsNew));
        textViewFoodFatPerN.setText(String.format(getActivity().getString(R.string.format_double), fatNew));
    }

    public void editPortionSizeGramOnChanged() {


        if (!lockPortionSizePCS) {
            lockPortionSizeGram = true;

            //GetValue of pcs
            // editTextPortionSizePCS;
            String portionSizePCS = editTextPortionSizePCS.getText().toString();

            //GetValue of gram
            //editTextPortionSizeGram;
            String portionSizeGram = editTextPortionSizeGram.getText().toString();
            //check not to loop
            if (portionSizeGram.equals(currentPortionSizePCS) && portionSizeGram.equals(currentPortionSizeGram)) {
                return;
            }

            if (portionSizeGram.isEmpty()) {
                editTextPortionSizePCS.setText("");

            } else {

                double doublePortionSizeGram = Double.parseDouble(portionSizeGram);


                // Calculate how much n portion size is in gram
                /* Get data fro database */
                String[] fields = new String[]{
                    "_id",
                    "food_serving_size_gram",
                    "food_serving_size_gram_measurement",
                    "food_serving_size_pcs",
                    "food_serving_size_pcs_measurement",
                    " food_energy_calculated ",
                    " food_protein_calculated ",
                    " food_carbohydrates_calculated ",
                    " food_fat_calculated "
                };

                DBAdapter db = getDbAdapter();
                String currentIdSQL = db.quoteSmart(currentFoodId);
                Cursor foodCursor = db.select("food", fields, "_id", currentIdSQL);

                //Convert Cursor to strings
                String servingSize = foodCursor.getString(1);
                String servingMeasurement = foodCursor.getString(2);
                String servingNameNumber = foodCursor.getString(3);
                String servingNameWord = foodCursor.getString(4);


                // Have changed pcs
                // Update gram
                double doublePortionSizePCS = Math.round(doublePortionSizeGram * Double.parseDouble(servingNameNumber) / Double.parseDouble(servingSize));
                editTextPortionSizePCS.setText(String.format(getActivity().getString(R.string.format_double), doublePortionSizePCS));


                updateTablePerN(foodCursor, servingSize, doublePortionSizeGram);

                db.close();

            }
        }
    }


    LinearLayout getSubLine(Context context, String stringEnergy, String stringProtein, String stringCarbs, String stringFat) {

        DBAdapter db = new DBAdapter(context);
        db.open();

        LinearLayout linearLayout = new LinearLayout(context);

        String[] fieldsGoal = {
            "goal_energy_with_activity_and_diet",
            "goal_energy_with_activity_and_diet",
            "goal_energy_with_activity_and_diet",
            "goal_energy_with_activity_and_diet",
        };
        Cursor cursorGoal = db.select("goal", fieldsGoal, "_id", 1);

        if (cursorGoal.getCount() != 0) {
            String stringEnergyGoal = cursorGoal.getString(0);
            String stringProteinGoal = cursorGoal.getString(1);
            String stringCarbsGoal = cursorGoal.getString(2);
            String stringFatGoal = cursorGoal.getString(3);
            db.close();


            LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            imageParams.height = 70;
            imageParams.width = 70;

            //Energy
            ImageView imageViewEnergy = new ImageView(context);
            imageViewEnergy.setLayoutParams(imageParams);
            imageViewEnergy.setImageResource(R.drawable.ic_energy);
            TextView textViewEnergy = new TextView(context, null, R.style.Widget_TextViewSmallComponents);
            textViewEnergy.setText(String.format(context.getResources().getString(R.string.format_kcal), stringEnergy));

            if (Double.parseDouble(stringEnergy) < Double.parseDouble(stringEnergyGoal)*0.17) {
                textViewEnergy.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_green)));
            } else if (Double.parseDouble(stringEnergy)  < Double.parseDouble(stringEnergyGoal)*0.3) {

                textViewEnergy.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_yellow)));

            } else {

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
            if (Double.parseDouble(stringProtein) < Double.parseDouble(stringProteinGoal)*0.17) {
                textViewProtein.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_green)));
            } else if (Double.parseDouble(stringProtein)  < Double.parseDouble(stringProteinGoal)*0.3) {
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
            if (Double.parseDouble(stringCarbs)  < Double.parseDouble(stringCarbsGoal)*0.17) {
                textViewCarbs.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_green)));
            } else if (Double.parseDouble(stringCarbs) < Double.parseDouble(stringCarbsGoal)*0.3) {
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
            if (Double.parseDouble(stringFat)  < Double.parseDouble(stringFatGoal)*0.17) {
                textViewFat.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_green)));
            } else if (Double.parseDouble(stringFat)  < Double.parseDouble(stringFatGoal)*0.3) {
                //~500
                textViewFat.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_yellow)));

            } else {
                //>500
                textViewFat.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.my_red)));

            }

            linearLayout.addView(imageViewFat);
            linearLayout.addView(textViewFat);
            // //Fat

            /* Blue line */
            View view = new View(getActivity());
            LinearLayout.LayoutParams viewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);

            viewParams.height = 2;

            view.setBackground(ContextCompat.getDrawable(getActivity(), R.color.light_green));
            linearLayout.addView(view, viewParams);

        } else {
            db.close();
        }
        return linearLayout;
    }

    void updateUpperTable() {

        DBAdapter db = getDbAdapter();
        String[] fieldsGoal = {
            "goal_energy_with_activity_and_diet",
            "goal_protein_with_activity_and_diet",
            "goal_carbs_with_activity_and_diet",
            "goal_fat_with_activity_and_diet",
        };
        Cursor cursorGoal = db.select("goal", fieldsGoal, "_id", 1);
        if (cursorGoal.getCount() != 0) {
            String stringGoalEnergy = cursorGoal.getString(0);
            String stringGoalProtein = cursorGoal.getString(1);
            String stringGoalCarbs = cursorGoal.getString(2);
            String stringGoalFat = cursorGoal.getString(3);


            String[] fieldsSum = {
                "fd_sum_energy",
                "fd_sum_protein",
                "fd_sum_carbs",
                "fd_sum_fat",
            };
            Cursor cursorSum = db.select("food_diary_sum", fieldsSum, "fd_sum_date", db.quoteSmart(currentData));
            String stringEatenEnergy = cursorSum.getString(0);
            String stringEatenProtein = cursorSum.getString(1);
            String stringEatenCarbs = cursorSum.getString(2);
            String stringEatenFat = cursorSum.getString(3);


            progressBarEnergy.setMax(Integer.parseInt(stringGoalEnergy));
            progressBarEnergy.setProgress(Integer.parseInt(stringEatenEnergy));
            double energyLeft = Double.parseDouble(stringGoalEnergy) - Double.parseDouble(stringEatenEnergy);
            if (energyLeft > 30) {
                progressBarEnergy.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.my_green)));
            } else if (energyLeft > -100) {
                progressBarEnergy.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.my_yellow)));
            } else {
                progressBarEnergy.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.my_red)));
            }

            progressBarProtein.setMax(Integer.parseInt(stringGoalProtein));
            progressBarProtein.setProgress(Integer.parseInt(stringEatenProtein));
            double proteinLeft = Double.parseDouble(stringGoalProtein) - Double.parseDouble(stringEatenProtein);
            if (proteinLeft > 10) {
                progressBarProtein.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.my_green)));
            } else if (proteinLeft > -10) {
                progressBarProtein.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.my_yellow)));
            } else {
                progressBarProtein.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.my_red)));
            }

            progressBarCarbs.setMax(Integer.parseInt(stringGoalCarbs));
            progressBarCarbs.setProgress(Integer.parseInt(stringEatenCarbs));
            double carbsLeft = Double.parseDouble(stringGoalCarbs) - Double.parseDouble(stringEatenCarbs);
            if (carbsLeft > 10) {
                progressBarCarbs.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.my_green)));
            } else if (carbsLeft > -10) {
                progressBarCarbs.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.my_yellow)));
            } else {
                progressBarCarbs.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.my_red)));
            }

            progressBarFat.setMax(Integer.parseInt(stringGoalFat));
            progressBarFat.setProgress(Integer.parseInt(stringEatenFat));
            double fatLeft = Double.parseDouble(stringGoalFat) - Double.parseDouble(stringEatenFat);
            if (fatLeft > 10) {
                progressBarFat.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.my_green)));
            } else if (fatLeft > -10) {
                progressBarFat.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.my_yellow)));
            } else {
                progressBarFat.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.my_red)));
            }


            TextView textViewProgressEnergy = getView().findViewById(R.id.textViewProgressEnergy);
            TextView textViewProgressProtein = getView().findViewById(R.id.textViewProgressProtein);
            TextView textViewProgressCarbs = getView().findViewById(R.id.textViewProgressCarbs);
            TextView textViewProgressFat = getView().findViewById(R.id.textViewProgressFat);

            textViewProgressEnergy.setText(String.format(getActivity().getResources().getString(R.string.format_progress_kcal), stringEatenEnergy, stringGoalEnergy));
            textViewProgressProtein.setText(String.format(getActivity().getResources().getString(R.string.format_progress_g), stringEatenProtein, stringGoalProtein));
            textViewProgressCarbs.setText(String.format(getActivity().getResources().getString(R.string.format_progress_g), stringEatenCarbs, stringGoalCarbs));
            textViewProgressFat.setText(String.format(getActivity().getResources().getString(R.string.format_progress_g), stringEatenFat, stringGoalFat));


        }
        db.close();

    }

}
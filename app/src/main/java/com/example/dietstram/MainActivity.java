package com.example.dietstram;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.Toast;

import com.example.dietstram.database.DBAdapter;
import com.example.dietstram.database.DBSetupInsert;
import com.example.dietstram.ui.categories.CategoriesFragment;
import com.example.dietstram.ui.food.FoodFragment;
import com.example.dietstram.ui.goal.GoalFragment;
import com.example.dietstram.ui.home.HomeFragment;
import com.example.dietstram.ui.profile.ProfileFragment;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

   public static String USER_ID;

    @Override public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

        //Toast.makeText(this,"back",Toast.LENGTH_LONG).show();
    }


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Tool bar */
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Set title
        toolbar.setTitle("Fragment activity");


        /* Initialize fragment */
        Fragment fragment = null;
        Class<HomeFragment> fragmentClass = HomeFragment.class;

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).addToBackStack(null).commit();




        /* Navigation */
        //Bottom
        BottomNavigationView navView = findViewById(R.id.bottom_nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //NavigationView
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //ActionBarDrawerToggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Navigation items
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        /* ---------------------------------------------------------------------- */

        /* Stetho*/
        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder()
            .addNetworkInterceptor(new StethoInterceptor())
            .build();

        /* Database */
        DBAdapter db = new DBAdapter(this);
        db.open();

        /* Setup for food */
        setFoodAndCategories(db);

        /* Setup for MealName */
        setMealNames(db);

        int numRows;
        /* Check if there is user table */
        //Count rows in user table
        numRows = db.count("users_in");
        Intent i;

        if (numRows < 1) {
            i = new Intent(MainActivity.this, RegistrationActivity.class);
            startActivity(i);
        } else{
            String[] fieldsUserI = {
                "users_i_id"
            };
        Cursor cursorUserI = db.select("users_in", fieldsUserI);
        USER_ID = cursorUserI.getString(0);
    }
        /*Close*/
        db.close();

    }

    private void setMealNames(DBAdapter db) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentData = dateFormat.format(Calendar.getInstance().getTime());
        Cursor c = db.select("meal",new String[] {"_id"},"meal_date",db.quoteSmart(currentData));
        if(c.getCount()==0) {
            DBSetupInsert setupInsert = new DBSetupInsert(this);
            setupInsert.insertAllMealName();
        }
    }

    private void setFoodAndCategories(DBAdapter db) {
        //Count rows in food
        int numRows = db.count("categories");
        if (numRows < 1) {
            DBSetupInsert setupInsert = new DBSetupInsert(this);
            setupInsert.insertAllFood();
            setupInsert.insertAllCategories();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //  getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
            || super.onSupportNavigateUp();
    }

//@Override
//  void onFragmentInteraction(Uri uri){
//
//  }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {  @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        Fragment fragment = null;
        Class fragmentClass = null;

        //Menu item
        if (id == R.id.nav_home) {
            fragmentClass = HomeFragment.class;

        } else if (id == R.id.nav_profile) {
            fragmentClass = ProfileFragment.class;

        } else if (id == R.id.nav_categories) {
            fragmentClass = CategoriesFragment.class;

        } else if (id == R.id.nav_food) {
            fragmentClass = FoodFragment.class;

        }else if (id == R.id.nav_goal) {
            fragmentClass = GoalFragment.class;

        }

        //Try add item fragment
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Try to show that content
        FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).addToBackStack(null).commit();
        } catch (Exception e) {
            e.printStackTrace();
            //Toast.makeText(this, "Error: " + e.toString(), Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;

    }};


        @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        Fragment fragment = null;
        Class fragmentClass = null;

        //Menu item
        if (id == R.id.nav_home) {
            fragmentClass = HomeFragment.class;

        } else if (id == R.id.nav_profile) {
            fragmentClass = ProfileFragment.class;

        } else if (id == R.id.nav_categories) {
            fragmentClass = CategoriesFragment.class;

        } else if (id == R.id.nav_food) {
            fragmentClass = FoodFragment.class;

        }else if (id == R.id.nav_goal) {
            fragmentClass = GoalFragment.class;

        }

        //Try add item fragment
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Try to show that content
        FragmentManager fragmentManager = getSupportFragmentManager();
        try {
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).addToBackStack(null).commit();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.toString(), Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;

    }

}
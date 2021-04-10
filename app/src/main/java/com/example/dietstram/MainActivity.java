package com.example.dietstram;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.Toast;

import com.example.dietstram.ui.food.FoodFragment;
import com.example.dietstram.ui.goal.GoalFragment;
import com.example.dietstram.ui.home.HomeFragment;
import com.example.dietstram.ui.profile.ProfileFragment;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
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

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity
  //  implements NavigationView.OnNavigationItemSelectedListener
    {


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Tool bar */
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Set title
        toolbar.setTitle("My live");

        /* Setting button  */
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        /***********************************8*/

        /* Navigation */
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        /* Navigation items */
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
            R.id.nav_home, R.id.nav_profile, R.id.nav_goal,R.id.nav_categories,R.id.nav_food)
            .setDrawerLayout(drawer)
            .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        /* Initialize fragment */
//        Fragment fragment = null;
//        Class fragmentClass = HomeFragment.class;
//
//        try {
//            fragment  =(Fragment) fragmentClass.newInstance();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        FragmentManager fragmentManager=getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.flContent,fragment).commit();




        /* Navigation */
        //DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //ActionBarDrawerToggle

        /* Navigation items */

        //NavigationView navigationView = findViewById(R.id.nav_view);
        // *** navigationView. setNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//            R.id.nav_home, R.id.nav_profile, R.id.nav_goal,R.id.nav_categories,R.id.nav_food)
//            .setDrawerLayout(drawer)
//            .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);

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
        //Count rows in food
        int numRows = db.count("food");

//        if (numRows < 1) {
//            DBSetupInsert setupInsert = new DBSetupInsert(this);
//            setupInsert.insertAllFood();
//            setupInsert.insertAllCategories();
//        }

        DBSetupInsert setupInsert = new DBSetupInsert(this);
        //setupInsert.setupInsertToFood();

        /* Check if there is user table */
        //Count rows in user table
        numRows = db.count("users");
        if (numRows < 1) {
            Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
        }

        /*Close*/
        db.close();
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

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        int id = menuItem.getGroupId();
//
//        Fragment fragment = null;
//        Class fragmentClass = null;
//
//        //Menu item
//        if (id == R.id.nav_home) {
//            fragmentClass = HomeFragment.class;
//
//        } else if (id == R.id.nav_gallery) {
//        fragmentClass = ProfileFragment.class;
//
//      } else if (id == R.id.nav_categories) {
//          fragmentClass = GoalFragment.class;
//
//        } else if (id == R.id.nav_food) {
//          fragmentClass = FoodFragment.class;
//
//        }
//
//        //Try add item fragment
//        try {
//            fragment=(Fragment)fragmentClass.newInstance();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//        //Try to show that content
//        FragmentManager fragmentManager=getSupportFragmentManager();
//        try {
//            fragmentManager.beginTransaction().replace(R.id.flContent,fragment);
//        }catch (Exception e){
//            e.printStackTrace();
//            Toast.makeText(this,"Error: "+e.toString(),Toast.LENGTH_LONG).show();
//        }
//
//        DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//
//        return true;
//
//    }
}
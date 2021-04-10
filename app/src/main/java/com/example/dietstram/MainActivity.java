package com.example.dietstram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

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

    /* Navigation */
    DrawerLayout drawer = findViewById(R.id.drawer_layout);

    /* Navigation items */
    NavigationView navigationView = findViewById(R.id.nav_view);
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    mAppBarConfiguration = new AppBarConfiguration.Builder(
        R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
        .setDrawerLayout(drawer)
        .build();
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
    NavigationUI.setupWithNavController(navigationView, navController);

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
}
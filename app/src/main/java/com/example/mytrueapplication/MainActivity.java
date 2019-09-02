package com.example.mytrueapplication;


import android.content.Intent;
import android.os.Bundle;

import com.example.mytrueapplication.ui.offerte.OfferteFragment;
import com.example.mytrueapplication.ui.preferiti.PreferitiFragment;
import com.example.mytrueapplication.ui.supermercati.SupermercatiFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    // Definizione degli oggetti

    private DrawerLayout mDrawerLayout = null;
    private ActionBarDrawerToggle mToggle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // CODICE GOOGLE
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer);



        //loading the default fragment
        loadFragment(new OfferteFragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(this);



        navigation.setSelectedItemId(R.id.navigation_offerte);


        /*
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_offerte, R.id.navigation_preferiti, R.id.navigation_supermercati)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        */




        //NOSTRO CODICE

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);

    }


    //CODICE NOSTRO

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_offerte:
                fragment = new OfferteFragment();
                getSupportActionBar().setTitle("Offerte");
                break;

            case R.id.navigation_supermercati:
                fragment = new SupermercatiFragment();
                getSupportActionBar().setTitle("Supermercati");
                break;

            case R.id.navigation_preferiti:
                fragment = new PreferitiFragment();
                getSupportActionBar().setTitle("Preferiti");
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    // crea la nostra top toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_princ, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

















































    /*
    private SearchView mSearchView;
    private TextView mTextMessage;
    private DrawerLayout mDrawerLayout = null;
    private ActionBarDrawerToggle mToggle = null;

    private Button mButton = null;
    private View view_sup = null;
    private View view_off= null;
    private View view_pref = null;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_supermercati:
                    mSearchView.setQueryHint("Cerca supermercato");
                    getSupportActionBar().setTitle("Supermercati");

                    return true;
                case R.id.navigation_offerte:
                    mSearchView.setQueryHint("Cerca prodotto");
                    getSupportActionBar().setTitle("Offerte");


                    return true;
                case R.id.navigation_preferiti:
                    mSearchView.setQueryHint("Cerca preferito");
                    getSupportActionBar().setTitle("Preferiti");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.drawer);


        BottomNavigationView navView = findViewById(R.id.nav_view);



        mSearchView = findViewById(R.id.ricerca);


        mButton = findViewById(R.id.ciao); */
        /*mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.layout_prova);
            }
        });*/



/*
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.navigation_offerte); */





        /*Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);*/





/*


        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


*/


/*


        getSupportActionBar().setElevation(0);





    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_princ, menu);


        return true;
    }

    */
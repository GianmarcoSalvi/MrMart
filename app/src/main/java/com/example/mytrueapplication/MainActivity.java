package com.example.mytrueapplication;


import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;

import android.widget.SearchView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {




    private SearchView mSearchView;
    private TextView mTextMessage;
    private DrawerLayout mDrawerLayout = null;
    private ActionBarDrawerToggle mToggle = null;


    private View view_sup = null;
    private View view_off= null;
    private View view_pref = null;










    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_supermercati:
                    mSearchView.setQueryHint("Supermercati");

                    getSupportActionBar().setTitle("Supermercati");

                    return true;
                case R.id.navigation_offerte:
                    mSearchView.setQueryHint("Offerte");
                    getSupportActionBar().setTitle("Offerte");


                    return true;
                case R.id.navigation_preferiti:
                    mSearchView.setQueryHint("Preferiti");
                    getSupportActionBar().setTitle("Preferiti");
                    return true;
            }
            return false;
        }
    };



    private Button mButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.drawer);


        BottomNavigationView navView = findViewById(R.id.nav_view);

        mSearchView = findViewById(R.id.ricerca);



        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.navigation_offerte);





        /*Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);*/


        mButton = (Button) findViewById(R.id.button1);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), attivita2.class);
                startActivity(i);
            }
        });

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);






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
    

}
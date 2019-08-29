package com.example.mytrueapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class attivita2 extends AppCompatActivity {

    Button mButton = null;
    ImageButton m2Button = null;
    Toolbar mToolbar = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attivita2);

        /*
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); */

        mButton = findViewById(R.id.button2);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MainActivity.class);
                startActivity(i);

            }
        });

        m2Button = (ImageButton)findViewById(R.id.backButton);
        m2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m2Button.setEnabled(true); //come faccio a far capire all'utente che lo ha cliccato?

                Intent i = new Intent(view.getContext(), MainActivity.class);
                startActivity(i);

            }
        });




       // getActionBar().setTitle("Supermercati");



    }



    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);


        return true;


    }



}

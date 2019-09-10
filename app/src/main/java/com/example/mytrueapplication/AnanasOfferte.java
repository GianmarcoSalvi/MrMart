package com.example.mytrueapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ClipData;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class AnanasOfferte extends AppCompatActivity {

    ToggleButton mtoggleButton = null;
    TextView tv = null;
    ImageButton button_minus = null;
    ImageButton button_plus = null;
    int num1;
    String tvValue;


    ImageButton add_cart = null;
    MenuItem cart_item = null;
    String cart_item_value_string;
    double totale_carrello_double;
    String totale_carrello_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ananas_offerte);


        //Gestisco i bottoni + e - e il numero tra essi compreso

        tv = findViewById(R.id.numero);
        button_minus = findViewById(R.id.button_minus);
        button_plus = findViewById(R.id.button_plus);
        tvValue = tv.getText().toString();


        if (!tvValue.equals("")) {
            num1 = Integer.parseInt(tvValue);
        }


        //Gestisco bottone meno
        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1 > 1)
                    num1 = num1 - 1;
                else
                    num1 = num1;
                tvValue = Integer.toString(num1);
                tv.setText(tvValue);
            }
        });



        //Gestisco bottone più
        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1 < 10)
                    num1 = num1 + 1;
                else
                    num1 = num1;
                tvValue = Integer.toString(num1);
                tv.setText(tvValue);
            }
        });




        //Gestisco icona preferiti
        mtoggleButton = (ToggleButton) findViewById(R.id.myStarButton);
        mtoggleButton.setChecked(false);
        mtoggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.star_grey));
        mtoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    mtoggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.star_yellow));
                else
                    mtoggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.star_grey));
            }
        });
    }




    // crea la nostra top toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_prodotto, menu);


        //Gestisco il prezzo del carrello al click su aggiungi al carrello
        add_cart = findViewById(R.id.add_cart_button);
        cart_item = menu.findItem(R.id.prezzo_cart_prodotto);


        add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cart_item_value_string = cart_item.getTitle().toString();
                totale_carrello_string = cart_item_value_string.substring(2);
                totale_carrello_double = Double.parseDouble(totale_carrello_string);
                totale_carrello_double = totale_carrello_double + (num1*0.99);
                totale_carrello_string = Double.toString(totale_carrello_double);
                cart_item_value_string = "€ ".concat(totale_carrello_string).substring(0,6);
                cart_item.setTitle(cart_item_value_string);
            }
        });

        return true;

    }


    // tasto back nuova activity
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}

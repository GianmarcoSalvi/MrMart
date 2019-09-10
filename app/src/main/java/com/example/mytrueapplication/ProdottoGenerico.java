package com.example.mytrueapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ProdottoGenerico extends AppCompatActivity {

    int supermercato_int;
    ImageView supermercato_card = null;

    int immagine_prodotto_int;
    ImageView immagine_prodotto_card = null;

    String titolo_string;
    TextView titolo_card = null;

    int prezzo_vecchio_int;
    TextView prezzo_vecchio_card = null;

    String prezzo_nuovo_string;
    TextView prezzo_nuovo_card = null;

    int sconto_int;
    ImageView sconto_card = null;

    String descrizione_string;
    TextView descrizione_card = null;




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

    String prezzo_value_string;
    TextView prezzo_nuovo_testo = null;
    String prezzo_singolo_string;
    double prezzo_singolo_double;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodotto_generico);



        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        supermercato_int = getIntent().getIntExtra("Supermercato", -1);
        supermercato_card = findViewById(R.id.supermercato_card);
        supermercato_card.setImageResource(supermercato_int);

        immagine_prodotto_int = getIntent().getIntExtra("Immagine", -1);
        immagine_prodotto_card = findViewById(R.id.immagine_prodotto_card);
        immagine_prodotto_card.setImageResource(immagine_prodotto_int);

        titolo_string = getIntent().getStringExtra("Titolo");
        titolo_card = findViewById(R.id.titolo_card);
        titolo_card.setText(titolo_string);

        prezzo_vecchio_int = getIntent().getIntExtra("PrezzoVecchio", -1);
        if(prezzo_vecchio_int != -1) {
            prezzo_vecchio_card = findViewById(R.id.prezzo_vecchio_card);
            prezzo_vecchio_card.setText(prezzo_vecchio_int);
        }

        prezzo_nuovo_string = getIntent().getStringExtra("PrezzoNuovo");
        prezzo_nuovo_card = findViewById(R.id.prezzo_nuovo_card);
        prezzo_nuovo_card.setText(prezzo_nuovo_string);


        sconto_int = getIntent().getIntExtra("Sconto", -1);
        if(sconto_int != -1) {
            sconto_card = findViewById(R.id.sconto_card);
            sconto_card.setImageResource(sconto_int);
        }

        descrizione_string = getIntent().getStringExtra("Descrizione");
        descrizione_card = findViewById(R.id.descrizione_card);
        descrizione_card.setText(descrizione_string);



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
        prezzo_nuovo_testo = findViewById(R.id.prezzo_nuovo_card);
        prezzo_value_string = (String)prezzo_nuovo_testo.getText();



        add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //RENDERE IL PREZZO SEMORE VARIABILE A SECONDA DEL PRODOTTO
                cart_item_value_string = cart_item.getTitle().toString();
                totale_carrello_string = cart_item_value_string.substring(2);
                totale_carrello_double = Double.parseDouble(totale_carrello_string);

                prezzo_singolo_string = prezzo_value_string.substring(1,5);
                prezzo_singolo_double = Double.parseDouble(prezzo_singolo_string);

                totale_carrello_double = totale_carrello_double + (num1*prezzo_singolo_double);
                totale_carrello_string = Double.toString(totale_carrello_double);
                cart_item_value_string = "€ ".concat(totale_carrello_string);

                if(cart_item_value_string.length() > 6)
                    cart_item_value_string = cart_item_value_string.substring(0,6);
                else if (cart_item_value_string.length() < 6)
                    cart_item_value_string = cart_item_value_string.concat("0");

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



    //Rendo il prezzo per il carrello una variabile accessibile da tutte le activity
    public String getPriceCart()
    {
        return cart_item_value_string;
    }

    public void setPriceCart(String priceCart)
    {
        this.cart_item_value_string = priceCart;
    }
}

package com.example.mytrueapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CatergorieSupermercati extends AppCompatActivity implements View.OnClickListener{


    CardView mCardViewFrutta = null;

    String supermercato_scelto;




    int[] immagini_frutta_elite = {R.drawable.ananas, R.drawable.arancia, R.drawable.banana, R.drawable.bergamotto, R.drawable.cocomero};
    String[] titoli_frutta_elite = {"Ananas Tropicale", "Arancia Sanguinello", "Banana Chiquita", "Bergamotto calabrese", "Cocomero"};
    int[] supermercati_frutta_elite = {R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite};
    int[] prezzi_old_frutta_elite = {R.string.prezzoAnanas, -1, -1, -1, -1};
    String[] prezzi_new_frutta_elite = {"€0.99", "€0.45/kg", "€0.80/kg", "€3.99/kg", "€0.30/kg"};
    int[] sconti_frutta_elite = {R.drawable.sconto50, -1 , -1, -1, -1};
    String[] descrizioni_frutta_elite = {"d1", "d2", "d3", "d4", "d5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catergorie_supermercati);


        //Setto la label dell'app bar in base al supermercato scelto
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        supermercato_scelto = getIntent().getStringExtra("SupermercatoScelto");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(supermercato_scelto);



        findIdAndSetListener(mCardViewFrutta, R.id.frutta_elite);

    }




    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.frutta_elite:
                createLayoutCategoria(view,immagini_frutta_elite, titoli_frutta_elite, supermercati_frutta_elite, prezzi_old_frutta_elite, prezzi_new_frutta_elite, sconti_frutta_elite, descrizioni_frutta_elite);
                break;

            default:
                break;
        }
    }


    // crea la nostra top toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.ricerca_cart_prezzo, menu);
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


    public void findIdAndSetListener(CardView card, int id_card)
    {
        card = findViewById(id_card);
        card.setOnClickListener(this);
    }


    public void createLayoutCategoria(View view, int[] immagini, String[] titoli, int[] nomi_sup, int[] prezzi_old, String[] prezzi_new, int[] sconti, String[] descrizioni)
    {
        Bundle mBundle = new Bundle();
        mBundle.putIntArray("Immagini", immagini);
        mBundle.putStringArray("Titoli", titoli);
        mBundle.putIntArray("NomiSup", nomi_sup);
        mBundle.putIntArray("PrezziOld", prezzi_old);
        mBundle.putStringArray("PrezziNew", prezzi_new);
        mBundle.putIntArray("Sconti", sconti);
        mBundle.putStringArray("Descrizioni", descrizioni);
        Intent intent = new Intent(view.getContext(), CategoriaGenerica.class);
        intent.putExtras(mBundle);
        startActivity(intent);



    }
}




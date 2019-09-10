package com.example.mytrueapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class FruttaElite extends AppCompatActivity implements View.OnClickListener{




    CardView mCardViewAnanas = null;
    CardView mCardViewArancia = null;
    CardView mCardViewBanana = null;
    CardView mCardViewBergamotto = null;
    CardView mCardViewCocomero = null;
    CardView mCardViewFragole = null;
    CardView mCardViewKiwi = null;
    CardView mCardViewLimone = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutta_elite);



        //Passa all'activity figlia banana_elite
        mCardViewAnanas = findViewById(R.id.ananas_elite);
        mCardViewAnanas.setOnClickListener(this);

        mCardViewArancia = findViewById(R.id.arancia_elite);
        mCardViewArancia.setOnClickListener(this);

        mCardViewBanana = findViewById(R.id.banana_elite);
        mCardViewBanana.setOnClickListener(this);

        mCardViewBergamotto = findViewById(R.id.bergamotto_elite);
        mCardViewBergamotto.setOnClickListener(this);

        mCardViewCocomero = findViewById(R.id.cocomero_elite);
        mCardViewCocomero.setOnClickListener(this);

        mCardViewFragole = findViewById(R.id.fragole_elite);
        mCardViewFragole.setOnClickListener(this);

        mCardViewKiwi = findViewById(R.id.kiwi_elite);
        mCardViewKiwi.setOnClickListener(this);

        mCardViewLimone = findViewById(R.id.limone_elite);
        mCardViewLimone.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.ananas_elite:
                Intent intent_ananas = new Intent(view.getContext(), BananaElite.class);
                intent_ananas.putExtra("Supermercato", R.drawable.elite);
                intent_ananas.putExtra("Immagine", R.drawable.ananas);
                intent_ananas.putExtra("Titolo", "Ananas tropicale");
                intent_ananas.putExtra("PrezzoVecchio", R.string.prezzoAnanas);
                intent_ananas.putExtra("PrezzoNuovo", "€0,99");
                intent_ananas.putExtra("Sconto", R.drawable.sconto50);
                intent_ananas.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_ananas);
                break;

            case R.id.arancia_elite:
                Intent intent_arancia = new Intent(view.getContext(), BananaElite.class);
                intent_arancia.putExtra("Supermercato", R.drawable.elite);
                intent_arancia.putExtra("Immagine", R.drawable.arancia);
                intent_arancia.putExtra("Titolo", "Arancia sanguinello");
                intent_arancia.putExtra("PrezzoNuovo", "€0,45/kg");
                intent_arancia.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_arancia);
                break;

            case R.id.banana_elite:
                Intent intent_banana = new Intent(view.getContext(), BananaElite.class);
                intent_banana.putExtra("Supermercato", R.drawable.elite);
                intent_banana.putExtra("Immagine", R.drawable.banana);
                intent_banana.putExtra("Titolo", "Banana chiquita");
                intent_banana.putExtra("PrezzoNuovo", "€0,80/kg");
                intent_banana.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_banana);
                break;

            case R.id.bergamotto_elite:
                Intent intent_bergamotto = new Intent(view.getContext(), BananaElite.class);
                intent_bergamotto.putExtra("Supermercato", R.drawable.elite);
                intent_bergamotto.putExtra("Immagine", R.drawable.bergamotto);
                intent_bergamotto.putExtra("Titolo", "Bergamotto calabrese");
                intent_bergamotto.putExtra("PrezzoNuovo", "€3,99/kg");
                intent_bergamotto.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_bergamotto);
                break;

            case R.id.cocomero_elite:
                Intent intent_cocomero = new Intent(view.getContext(), BananaElite.class);
                intent_cocomero.putExtra("Supermercato", R.drawable.elite);
                intent_cocomero.putExtra("Immagine", R.drawable.cocomero);
                intent_cocomero.putExtra("Titolo", "Cocomero");
                intent_cocomero.putExtra("PrezzoNuovo", "€0,30/kg");
                intent_cocomero.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_cocomero);
                break;

            case R.id.fragole_elite:
                Intent intent_fragole = new Intent(view.getContext(), BananaElite.class);
                intent_fragole.putExtra("Supermercato", R.drawable.elite);
                intent_fragole.putExtra("Immagine", R.drawable.fragole);
                intent_fragole.putExtra("Titolo", "Fragole Melinda");
                intent_fragole.putExtra("PrezzoNuovo", "€4,99/kg");
                intent_fragole.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_fragole);
                break;

            case R.id.kiwi_elite:
                Intent intent_kiwi = new Intent(view.getContext(), BananaElite.class);
                intent_kiwi.putExtra("Supermercato", R.drawable.elite);
                intent_kiwi.putExtra("Immagine", R.drawable.kiwi);
                intent_kiwi.putExtra("Titolo", "Kiwi");
                intent_kiwi.putExtra("PrezzoNuovo", "€2,99/kg");
                intent_kiwi.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_kiwi);
                break;

            case R.id.limone_elite:
                Intent intent_limone = new Intent(view.getContext(), BananaElite.class);
                intent_limone.putExtra("Supermercato", R.drawable.elite);
                intent_limone.putExtra("Immagine", R.drawable.limone);
                intent_limone.putExtra("Titolo", "Limone");
                intent_limone.putExtra("PrezzoNuovo", "€0,99/kg");
                intent_limone.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_limone);
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




}

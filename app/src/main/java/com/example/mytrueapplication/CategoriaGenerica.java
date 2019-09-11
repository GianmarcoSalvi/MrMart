package com.example.mytrueapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoriaGenerica extends AppCompatActivity implements View.OnClickListener{




    CardView mCardView1 = null;
    CardView mCardView2 = null;
    CardView mCardView3 = null;
    CardView mCardView4 = null;
    CardView mCardView5 = null;


    CardView mCardViewFragole = null;
    CardView mCardViewKiwi = null;
    CardView mCardViewLimone = null;


    ImageView immagine_card = null;
    TextView titolo_card = null;
    ImageView nome_sup_card = null;
    TextView prezzo_old_card = null;
    TextView prezzo_new_card = null;
    ImageView sconto_card = null;


    //Creo gli array che contengono gli id che mi servono (tutti tranne descrizione che serve solo nela pag prodotto)
    int[] idImmagini = {R.id.immagine_card_categoria_1, R.id.immagine_card_categoria_2, R.id.immagine_card_categoria_3, R.id.immagine_card_categoria_4, R.id.immagine_card_categoria_5};
    int[] idTitoli = {R.id.titolo_card_categoria_1, R.id.titolo_card_categoria_2, R.id.titolo_card_categoria_3, R.id.titolo_card_categoria_4, R.id.titolo_card_categoria_5};
    int[] idNomiSup = {R.id.nome_sup_card_categoria_1, R.id.nome_sup_card_categoria_2, R.id.nome_sup_card_categoria_3, R.id.nome_sup_card_categoria_4, R.id.nome_sup_card_categoria_5};
    int[] idPrezziOld = {R.id.prezzo_old_card_categoria_1, R.id.prezzo_old_card_categoria_2, R.id.prezzo_old_card_categoria_3, R.id.prezzo_old_card_categoria_4, R.id.prezzo_old_card_categoria_5};
    int[] idPrezziNew = {R.id.prezzo_new_card_categoria_1, R.id.prezzo_new_card_categoria_2, R.id.prezzo_new_card_categoria_3, R.id.prezzo_new_card_categoria_4, R.id.prezzo_new_card_categoria_5};
    int[] idSconti = {R.id.sconto_card_categoria_1, R.id.sconto_card_categoria_2, R.id.sconto_card_categoria_3, R.id.sconto_card_categoria_4, R.id.sconto_card_categoria_5};




    //Dichiaro gli array che mi passa l'activity precedente

    int[] immagini;
    String[] titoli;
    int[] supermercati;
    int[] prezzi_old;
    String[] prezzi_new;
    int[] sconti;
    String[] descrizioni;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_generica);


        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        immagini = extras.getIntArray("Immagini");
        titoli = extras.getStringArray("Titoli");
        supermercati = extras.getIntArray("NomiSup");
        prezzi_old = extras.getIntArray("PrezziOld");
        prezzi_new = extras.getStringArray("PrezziNew");
        sconti = extras.getIntArray("Sconti");
        descrizioni = extras.getStringArray("Descrizioni");


        int confine = immagini.length;  //confine varia a seconda di quante card ho nel layout


        //Riempie il layout con le informazioni delle cards
        for(int i = 0; i<confine; i++)
        {
            immagine_card = findViewById(idImmagini[i]);
            immagine_card.setImageResource(immagini[i]);

            titolo_card = findViewById(idTitoli[i]);
            titolo_card.setText(titoli[i]);

            nome_sup_card = findViewById(idNomiSup[i]);
            nome_sup_card.setImageResource(supermercati[i]);

            prezzo_old_card = findViewById(idPrezziOld[i]);
            if(prezzi_old[i] != -1)
                prezzo_old_card.setText(prezzi_old[i]);

            prezzo_new_card = findViewById(idPrezziNew[i]);
            prezzo_new_card.setText(prezzi_new[i]);

            sconto_card = findViewById(idSconti[i]);
            if(sconti[i] != -1)
                sconto_card.setImageResource(sconti[i]);



        }










        //Trova l'id e setta il listener per la card
        findIdAndSetListener(mCardView1, R.id.card_categoria_1);

        findIdAndSetListener(mCardView2, R.id.card_categoria_2);

        findIdAndSetListener(mCardView3, R.id.card_categoria_3);

        findIdAndSetListener(mCardView4, R.id.card_categoria_4);

        findIdAndSetListener(mCardView5, R.id.card_categoria_5);

        /*

        findIdAndSetListener(mCardViewFragole, R.id.fragole_elite);

        findIdAndSetListener(mCardViewKiwi, R.id.kiwi_elite);

        findIdAndSetListener(mCardViewLimone, R.id.limone_elite);


         */


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.card_categoria_1:
                createCard(view, supermercati[0], immagini[0], titoli[0], prezzi_old[0], prezzi_new[0], sconti[0], descrizioni[0]);
                break;

            case R.id.card_categoria_2:
                createCard(view, supermercati[1], immagini[1], titoli[1], prezzi_old[1], prezzi_new[1], sconti[1], descrizioni[1]);
                break;

            case R.id.card_categoria_3:
                createCard(view, supermercati[2], immagini[2], titoli[2], prezzi_old[2], prezzi_new[2], sconti[2], descrizioni[2]);
                break;

            case R.id.card_categoria_4:
                createCard(view, supermercati[3], immagini[3], titoli[3], prezzi_old[3], prezzi_new[3], sconti[3], descrizioni[3]);
                break;

            case R.id.card_categoria_5:
                createCard(view, supermercati[4], immagini[4], titoli[4], prezzi_old[4], prezzi_new[4], sconti[4], descrizioni[4]);
                break;

                /*

            case R.id.fragole_elite:
                createCard(view, R.drawable.elite, R.drawable.fragole, "Fragole Melinda", -1, "€4.99/kg", -1, "Ananas tropicale" );
                break;

            case R.id.kiwi_elite:
                createCard(view, R.drawable.elite, R.drawable.kiwi, "Kiwi", -1, "€2.99/kg", -1, "Descrizione kiwi");
                break;

            case R.id.limone_elite:
                createCard(view, R.drawable.elite, R.drawable.limone,"Limone", -1,"€0.99/kg", -1, "Ananas tropicale");
                break;


                 */

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

    public void createCard(View view, int imgSup, int imgProd, String titPro, int prezzoOld,String prezzoNew, int sconto, String descr)
    {
        Intent intent = new Intent(view.getContext(), ProdottoGenerico.class);
        intent.putExtra("Supermercato", imgSup);
        intent.putExtra("Immagine", imgProd);
        intent.putExtra("Titolo", titPro);
        intent.putExtra("PrezzoVecchio", prezzoOld);
        intent.putExtra("PrezzoNuovo", prezzoNew);
        intent.putExtra("Sconto", sconto);
        intent.putExtra("Descrizione", descr);
        startActivity(intent);

    }




}

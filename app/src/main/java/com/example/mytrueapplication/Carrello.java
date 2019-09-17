/*
package com.example.mytrueapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Carrello extends AppCompatActivity {


    TextView textViewProdottiAggiunti = null;
    TextView textViewQuantitaAggiunte = null;
    ArrayList<Integer> immaginiAggiunte;
    ArrayList<String> prodottiAggiunti;
    ArrayList<Integer> supermercatiAggiunti;
    ArrayList<String> prezziAggiunti;
    ArrayList<Integer> quantitaAggiunte;


    CardView cardViewDinamica = null;
    View separatore = null;
    Context context;
    LinearLayout linearLayoutCarrello;
    LinearLayout linearInterno1;
    LinearLayout linearInterno2;

    ImageView immagineCard = null;
    TextView titoloCard = null;
    ImageView supermercatoCard = null;
    TextView prezzoCard = null;
    TextView quantitaCard = null;
    ImageButton bottoneMeno = null;
    ImageButton bottonePiu = null;

    int layout_id;
    Bundle bundleSave = new Bundle();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_carrello);

        if (savedInstanceState != null) {
            Toast.makeText(getApplicationContext(), "ciao chicco", Toast.LENGTH_LONG).show();
            layout_id = savedInstanceState.getInt("LayoutCarrelloId");
            setContentView(layout_id);

        }
        else {
            setContentView(R.layout.activity_carrello);
        }




        Bundle extras = getIntent().getExtras();

        if(extras != null) {

            immaginiAggiunte = extras.getIntegerArrayList("ImmaginiAggiunte");
            prodottiAggiunti = extras.getStringArrayList("ProdottiAggiunti");
            supermercatiAggiunti = extras.getIntegerArrayList("SupermercatiAggiunti");
            prezziAggiunti = extras.getStringArrayList("PrezziAggiunti");
            quantitaAggiunte = extras.getIntegerArrayList("QuantitaAggiunte");


            context = getApplicationContext();
            linearLayoutCarrello = (LinearLayout) findViewById(R.id.linear_layout_carrello);


            Toast toast;
            for (int i = 0; i < prodottiAggiunti.size(); i++) {
                createCardViewProgrammatically(i,immaginiAggiunte.get(i), prodottiAggiunti.get(i), supermercatiAggiunti.get(i), prezziAggiunti.get(i), Integer.toString(quantitaAggiunte.get(i)));
            }


        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putInt("LayoutCarrelloId",R.id.linear_layout_carrello);

    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        String myStringProdotti = savedInstanceState.getString("SalvaProdotti");
        String myStringQuantita = savedInstanceState.getString("SalvaQauntita");
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
                onSaveInstanceState(bundleSave);
                finish();
                break;
        }
        return true;
    }



    public void createCardViewProgrammatically(final int indice, int immagine, String titolo, int supermercato, String prezzo, String quantita) {

        titoloCard = new TextView(context);
        titoloCard.setText(titolo);
        titoloCard.setGravity(Gravity.CENTER);
        TextViewCompat.setAutoSizeTextTypeWithDefaults(titoloCard, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        LinearLayout.LayoutParams paramsTitolo = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0);
        paramsTitolo.weight = 0.4f;
        titoloCard.setLayoutParams(paramsTitolo);

        supermercatoCard = new ImageView(context);
        supermercatoCard.setImageResource(supermercato);
        LinearLayout.LayoutParams paramsSupermercato = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0);
        paramsSupermercato.weight = 0.2f;
        supermercatoCard.setLayoutParams(paramsSupermercato);

        prezzoCard = new TextView(context);
        prezzoCard.setText(prezzo);
        prezzoCard.setGravity(Gravity.CENTER);
        TextViewCompat.setAutoSizeTextTypeWithDefaults(prezzoCard, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        LinearLayout.LayoutParams paramsPrezzo = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0);
        paramsPrezzo.weight = 0.4f;
        prezzoCard.setLayoutParams(paramsPrezzo);


        linearInterno2 = new LinearLayout(context);
        linearInterno2.setOrientation(linearInterno2.VERTICAL);
        linearInterno2.setWeightSum(1.0f);
        LinearLayout.LayoutParams paramsLinear2 = new LinearLayout.LayoutParams(0 , ViewGroup.LayoutParams.MATCH_PARENT);
        paramsLinear2.weight = 0.4f;
        paramsLinear2.setMargins(40,40,40,40);
        linearInterno2.setLayoutParams(paramsLinear2);

        linearInterno2.addView(titoloCard);
        linearInterno2.addView(supermercatoCard);
        linearInterno2.addView(prezzoCard);


        immagineCard = new ImageView(context);
        immagineCard.setImageResource(immagine);
        immagineCard.setBackgroundResource(R.drawable.border_image);
        LinearLayout.LayoutParams paramsImmagine = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        paramsImmagine.weight = 0.3f;
        immagineCard.setLayoutParams(paramsImmagine);


        quantitaCard = new TextView(context);
        quantitaCard.setText(quantita);
        quantitaCard.setMaxLines(1);
        TextViewCompat.setAutoSizeTextTypeWithDefaults(quantitaCard, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        LinearLayout.LayoutParams paramsQuantita = new LinearLayout.LayoutParams(0, 200);
        paramsQuantita.weight = 0.1f;
        paramsQuantita.gravity = Gravity.CENTER;
        quantitaCard.setLayoutParams(paramsQuantita);

        bottoneMeno = new ImageButton(context);
        bottoneMeno.setImageResource(R.drawable.ic_minus);
        LinearLayout.LayoutParams paramsBottoneMeno = new LinearLayout.LayoutParams(0, 200);
        paramsBottoneMeno.weight = 0.1f;
        paramsBottoneMeno.gravity = Gravity.CENTER;
        bottoneMeno.setLayoutParams(paramsBottoneMeno);

        bottoneMeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt((String)quantitaCard.getText()) > 1)
                quantitaCard.setText(String.valueOf(Integer.parseInt((String)quantitaCard.getText()) - 1));
                else {
                    //Cancella la card
                    linearLayoutCarrello.removeViewInLayout(cardViewDinamica);
                    linearLayoutCarrello.removeViewInLayout(separatore);

                    //Quando faccio back e poi torno sull carrello mi ritrovo l'item, non va bene

                }


            }
        });


        bottonePiu = new ImageButton(context);
        bottonePiu.setImageResource(R.drawable.ic_plus);
        LinearLayout.LayoutParams paramsBottonePiu = new LinearLayout.LayoutParams(0, 200);
        paramsBottonePiu.weight = 0.1f;
        paramsBottonePiu.gravity = Gravity.CENTER;
        bottonePiu.setLayoutParams(paramsBottonePiu);

        bottonePiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantitaCard.setText(String.valueOf(Integer.parseInt((String)quantitaCard.getText()) + 1));
            }
        });


        linearInterno1 = new LinearLayout(context);
        linearInterno1.setOrientation(linearInterno1.HORIZONTAL);
        linearInterno1.setWeightSum(1.0f);
        LinearLayout.LayoutParams paramsLinear1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        paramsLinear1.setMargins(40, 40, 40, 40);
        linearInterno1.setLayoutParams(paramsLinear1);


        linearInterno1.addView(immagineCard);
        linearInterno1.addView(linearInterno2);
        linearInterno1.addView(quantitaCard);
        linearInterno1.addView(bottoneMeno);
        linearInterno1.addView(bottonePiu);


        cardViewDinamica = new CardView(context);
        ViewGroup.LayoutParams paramsCard = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,600);
        cardViewDinamica.setLayoutParams(paramsCard);

        cardViewDinamica.addView(linearInterno1);

        separatore = new View(context);
        separatore.setBackgroundResource(R.color.colorPrimary);
        ViewGroup.LayoutParams paramsSeparatore = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 5);
        separatore.setLayoutParams(paramsSeparatore);


        linearLayoutCarrello.addView(cardViewDinamica);
        linearLayoutCarrello.addView(separatore);



    }

}


 */

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
    CardView mCardViewVerdura = null;
    CardView mCardViewSalumiFormaggi = null;
    CardView mCardViewAlimentari = null;
    CardView mCardViewBevande = null;
    CardView mCardViewProdottiCasa = null;
    CardView mCardViewIgienePersonale = null;
    CardView mCardViewAltro = null;

    String supermercato_scelto;






    int[] immagini_frutta_elite = {R.drawable.ananas, R.drawable.arancia, R.drawable.banana, R.drawable.bergamotto, R.drawable.cocomero};
    String[] titoli_frutta_elite = {"Ananas Tropicale", "Arancia Sanguinello", "Banana Chiquita", "Bergamotto calabrese", "Cocomero"};
    int[] supermercati_frutta_elite = {R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite};
    int[] prezzi_old_frutta_elite = {-1, -1, -1, -1, -1};
    String[] prezzi_new_frutta_elite = {"€0.99/pz", "€0.45/kg", "€0.80/kg", "€3.99/kg", "€2.90/pz"};
    int[] sconti_frutta_elite = {-1, -1 , -1, -1, -1};
    String[] descrizioni_frutta_elite = {"d1", "d2", "d3", "d4", "d5"};



    int[] immagini_verdura_elite = {R.drawable.cavolo_romano, R.drawable.fagiolini, R.drawable.finocchio_campano, R.drawable.lattuga_romana, R.drawable.melanzana};
    String[] titoli_verdura_elite = {"Cavolo romano", "Fagiolini verdi", "Finocchio campano", "Lattuga romana", "Melanzana ovale nera"};
    int[] supermercati_verdura_elite = {R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite};
    int[] prezzi_old_verdura_elite = {-1, -1, -1, -1, -1};
    String[] prezzi_new_verdura_elite = {"€0.75/kg", "€1.19/kg", "€0.39/kg", "€0.50/kg", "€0.99/kg"};
    int[] sconti_verdura_elite = {-1, -1 , -1, -1, -1};
    String[] descrizioni_verdura_elite = {"d1", "d2", "d3", "d4", "d5"};


    int[] immagini_salumi_formaggi_elite = {R.drawable.bresaola_negroni, R.drawable.mortadella_rovagnati, R.drawable.mozzarella, R.drawable.parmigiano_ferrari, R.drawable.prosciutto_cotto};
    String[] titoli_salumi_formaggi_elite = {"Bresaola Negroni", "Mortadella Rovagnati", "Mozzarella Vallelata", "Parmigiano Reggiano", "Prosciutto cotto Rovagnati"};
    int[] supermercati_salumi_formaggi_elite = {R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite};
    int[] prezzi_old_salumi_formaggi_elite = {-1, -1, -1, -1, -1};
    String[] prezzi_new_salumi_formaggi_elite = {"€2.49", "€2.79", "€4.19", "€2.99", "€1.09"};
    int[] sconti_salumi_formaggi_elite = {-1, -1 , -1, -1, -1};
    String[] descrizioni_salumi_formaggi_elite = {"d1", "d2", "d3", "d4", "d5"};



    int[] immagini_alimentari_elite = {R.drawable.cereali, R.drawable.cotoletta_amadori, R.drawable.fagioli, R.drawable.nutella_ferrero, R.drawable.pasta_barilla};
    String[] titoli_alimentari_elite = {"Cereali Cheerios", "Cotoletta Amadori", "Fagioli in scatola", "Nutella Ferrero", "Pasta Barilla"};
    int[] supermercati_alimentari_elite = {R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite};
    int[] prezzi_old_alimentari_elite = {-1, -1, -1, -1, -1};
    String[] prezzi_new_alimentari_elite = {"€2.99", "€3.90", "€0.66", "€3.29", "€2.30"};
    int[] sconti_alimentari_elite = {-1, -1 , -1, -1, -1};
    String[] descrizioni_alimentari_elite = {"d1", "d2", "d3", "d4", "d5"};


    int[] immagini_bevande_elite = {R.drawable.acqua_lete, R.drawable.amaro_montenegro, R.drawable.coca_cola, R.drawable.fanta, R.drawable.latte_centrale};
    String[] titoli_bevande_elite = {"Acqua minerale naturale Lete", "Amaro Montenegro", "Coca cola in lattina", "Fanta in bottiglia", "Latte della Centrale"};
    int[] supermercati_bevande_elite = {R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite};
    int[] prezzi_old_bevande_elite = {-1, -1, -1, -1, -1};
    String[] prezzi_new_bevande_elite = {"€2.49", "€14.50", "€0.69", "€1.50", "€1.10"};
    int[] sconti_bevande_elite = {-1, -1 , -1, -1, -1};
    String[] descrizioni_bevande_elite = {"d1", "d2", "d3", "d4", "d5"};



    int[] immagini_prodotti_casa_elite = {R.drawable.carta_igienica_regina, R.drawable.omino_bianco, R.drawable.fazzoletti_tempo, R.drawable.pellicola_forno_cuki, R.drawable.spugna_piatti_spontex};
    String[] titoli_prodotti_casa_elite = {"Carta igienica Regina", "Detersivo Omino Bianco", "Fazzoletti Tempo", "Pellicola forno Cuki", "Spugna Spontex"};
    int[] supermercati_prodotti_casa_elite = {R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite};
    int[] prezzi_old_prodotti_casa_elite = {-1, -1, -1, -1, -1};
    String[] prezzi_new_prodotti_casa_elite = {"€2.90", "€3.99", "€1.49", "€1.09", "€1.90"};
    int[] sconti_prodotti_casa_elite = {-1, -1 , -1, -1, -1};
    String[] descrizioni_prodotti_casa_elite = {"d1", "d2", "d3", "d4", "d5"};



    int[] immagini_igiene_personale_elite = {R.drawable.dentifricio_mentadent, R.drawable.deodorante_dove, R.drawable.lamette_gillette, R.drawable.sapone_neutro_roberts, R.drawable.shampoo_garnier};
    String[] titoli_igiene_personale_elite = {"Dentifricio Mentadent", "Deodorante Dove", "Lamette Gillette", "Sapone Neutro Roberts", "Shampoo Garnier"};
    int[] supermercati_igiene_personale_elite = {R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite};
    int[] prezzi_old_igiene_personale_elite = {-1, -1, -1, -1, -1};
    String[] prezzi_new_igiene_personale_elite = {"€0.99", "€1.89", "€3.49", "€1.65", "€3.09"};
    int[] sconti_igiene_personale_elite = {-1, -1 , -1, -1, -1};
    String[] descrizioni_igiene_personale_elite = {"d1", "d2", "d3", "d4", "d5"};



    int[] immagini_altro_elite = {R.drawable.batterie_duracell, R.drawable.cibo_gatti_yarrah, R.drawable.cibo_per_cani, R.drawable.pannolini_pampers, R.drawable.spray_autan};
    String[] titoli_altro_elite = {"Batterie Duracell", "Cibo per gatti", "Croccantini per cani", "Pannolini Pampers", "Spray antizanzare"};
    int[] supermercati_altro_elite = {R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite, R.drawable.elite};
    int[] prezzi_old_altro_elite = {-1, -1, -1, -1, -1};
    String[] prezzi_new_altro_elite = {"€7.90", "€32.39", "€14.99", "€9.70", "€4.49"};
    int[] sconti_altro_elite = {-1, -1 , -1, -1, -1};
    String[] descrizioni_altro_elite = {"d1", "d2", "d3", "d4", "d5"};

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



        findIdAndSetListener(mCardViewFrutta, R.id.frutta_card);
        findIdAndSetListener(mCardViewVerdura, R.id.verdura_card);
        findIdAndSetListener(mCardViewSalumiFormaggi, R.id.salumi_formaggi_card);
        findIdAndSetListener(mCardViewAlimentari, R.id.alimentari_card);
        findIdAndSetListener(mCardViewBevande, R.id.bevande_card);
        findIdAndSetListener(mCardViewProdottiCasa, R.id.prodotti_casa_card);
        findIdAndSetListener(mCardViewIgienePersonale, R.id.igiene_personale_card);
        findIdAndSetListener(mCardViewAltro, R.id.altro_card);

    }




    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.frutta_card:
                createLayoutCategoria(view,immagini_frutta_elite, titoli_frutta_elite, supermercati_frutta_elite, prezzi_old_frutta_elite, prezzi_new_frutta_elite, sconti_frutta_elite, descrizioni_frutta_elite, "Frutta");
                break;

            case R.id.verdura_card:
                createLayoutCategoria(view,immagini_verdura_elite, titoli_verdura_elite, supermercati_verdura_elite, prezzi_old_verdura_elite, prezzi_new_verdura_elite, sconti_verdura_elite, descrizioni_verdura_elite, "Verdura");
                break;

            case R.id.salumi_formaggi_card:
                createLayoutCategoria(view,immagini_salumi_formaggi_elite, titoli_salumi_formaggi_elite, supermercati_salumi_formaggi_elite, prezzi_old_salumi_formaggi_elite, prezzi_new_salumi_formaggi_elite, sconti_salumi_formaggi_elite, descrizioni_salumi_formaggi_elite, "Salumi e Formaggi");
                break;

            case R.id.alimentari_card:
                createLayoutCategoria(view,immagini_alimentari_elite, titoli_alimentari_elite, supermercati_alimentari_elite, prezzi_old_alimentari_elite, prezzi_new_alimentari_elite, sconti_alimentari_elite, descrizioni_alimentari_elite, "Alimentari");
                break;

            case R.id.bevande_card:
                createLayoutCategoria(view,immagini_bevande_elite, titoli_bevande_elite, supermercati_bevande_elite, prezzi_old_bevande_elite, prezzi_new_bevande_elite, sconti_bevande_elite, descrizioni_bevande_elite, "Bevande");
                break;

            case R.id.prodotti_casa_card:
                createLayoutCategoria(view,immagini_prodotti_casa_elite, titoli_prodotti_casa_elite, supermercati_prodotti_casa_elite, prezzi_old_prodotti_casa_elite, prezzi_new_prodotti_casa_elite, sconti_prodotti_casa_elite, descrizioni_prodotti_casa_elite, "Prodotti per la casa");
                break;

            case R.id.igiene_personale_card:
                createLayoutCategoria(view,immagini_igiene_personale_elite, titoli_igiene_personale_elite, supermercati_igiene_personale_elite, prezzi_old_igiene_personale_elite, prezzi_new_igiene_personale_elite, sconti_igiene_personale_elite, descrizioni_igiene_personale_elite, "Igiene personale");
                break;

            case R.id.altro_card:
                createLayoutCategoria(view,immagini_altro_elite, titoli_altro_elite, supermercati_altro_elite, prezzi_old_altro_elite, prezzi_new_altro_elite, sconti_altro_elite, descrizioni_altro_elite, "Altro");
                break;

            default:
                break;
        }
    }


    // crea la nostra top toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.ricerca_cart_prezzo, menu);

        /*

        //Imposto il prezzo del carrello alla variabile singleton
        MenuItem price_cart = menu.findItem(R.id.prezzo_cart_barra2);
        if(SingletonPriceCart.getInstance().getValue() != null)
        price_cart.setTitle(SingletonPriceCart.getInstance().getValue());


         */

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


    public void createLayoutCategoria(View view, int[] immagini, String[] titoli, int[] nomi_sup, int[] prezzi_old, String[] prezzi_new, int[] sconti, String[] descrizioni, String categoriaScelta)
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
        intent.putExtra("CategoriaScelta", categoriaScelta);
        intent.putExtra("SupermercatoScelto", supermercato_scelto);
        startActivity(intent);



    }
}




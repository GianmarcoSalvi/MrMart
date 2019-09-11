package com.example.mytrueapplication.ui.offerte;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mytrueapplication.ProdottoGenerico;
import com.example.mytrueapplication.R;


public class OfferteFragment extends Fragment implements View.OnClickListener{

    private OfferteViewModel offerteViewModel;
    private CardView mCardView = null;
    private SearchView mSearchView = null;




    CardView mCardViewAcqua = null;
    CardView mCardViewAnanas = null;
    CardView mCardViewCereali = null;
    CardView mCardViewFagioli = null;
    CardView mCardViewMelanzana = null;
    CardView mCardViewVino = null;
    CardView mCardViewCroccantini = null;
    CardView mCardViewTenerone = null;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        offerteViewModel =
                ViewModelProviders.of(this).get(OfferteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_offerte, container, false);


        /*final TextView textView = root.findViewById(R.id.text_offerte);
        offerteViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/




        //Trovo id e setto listener della card per fare on Click
        mCardViewAcqua = root.findViewById(R.id.acqua_offerte);
        mCardViewAcqua.setOnClickListener(this);

        mCardViewAnanas = root.findViewById(R.id.ananas_offerte);
        mCardViewAnanas.setOnClickListener(this);

        mCardViewCereali = root.findViewById(R.id.cereali_offerte);
        mCardViewCereali.setOnClickListener(this);

        mCardViewFagioli = root.findViewById(R.id.fagioli_offerte);
        mCardViewFagioli.setOnClickListener(this);

        mCardViewMelanzana = root.findViewById(R.id.melanzana_offerte);
        mCardViewMelanzana.setOnClickListener(this);

        mCardViewVino = root.findViewById(R.id.vino_offerte);
        mCardViewVino.setOnClickListener(this);

        /*

        mCardViewCroccantini = root.findViewById(R.id.croccantini_offerte);
        mCardViewCroccantini.setOnClickListener(this);

        mCardViewTenerone = root.findViewById(R.id.tenerone_offerte);
        mCardViewTenerone.setOnClickListener(this);


         */





        //searchview
        mSearchView = root.findViewById(R.id.search_view);
        mSearchView.setQueryHint("Cerca prodotto");

        return root;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.acqua_offerte:
                createCard(view, R.drawable.conad, R.drawable.acqua_lete, "Acqua minerale naturale Lete", R.string.prezzoAcqua, "€1.99", R.drawable.sconto20, "Ananas tropicale");
                break;

            case R.id.ananas_offerte:
                createCard(view, R.drawable.elite, R.drawable.ananas, "Ananas tropicale", R.string.prezzoAnanas,"€0.99", R.drawable.sconto50, "Ananas tropicale");
                break;

            case R.id.cereali_offerte:
                createCard(view, R.drawable.carrefour, R.drawable.cereali, "Cereali Cheerios", R.string.prezzoCereali, "€1.79", R.drawable.sconto40, "Ananas tropicale");
                break;

            case R.id.fagioli_offerte:
                createCard(view, R.drawable.elite, R.drawable.fagioli, "Fagioli in scatola", R.string.prezzoFagioli, "€0.66", R.drawable.sconto33, "Ananas tropicale");
                break;

            case R.id.melanzana_offerte:
                createCard(view, R.drawable.conad, R.drawable.melanzana, "Melanzana", R.string.prezzoMelanzana, "€0.89/Kg", R.drawable.sconto10, "Ananas tropicale");
                break;

            case R.id.vino_offerte:
                createCard(view, R.drawable.carrefour, R.drawable.vino, "Vino rosso Chianti D.O.P.", R.string.prezzoVino, "€3.99", R.drawable.sconto50, "Ananas tropicale");
                break;

            /*
            case R.id.croccantini_offerte:
                Intent intent_croccantini = new Intent(view.getContext(), ProdottoGenerico.class);
                intent_croccantini.putExtra("Supermercato", R.drawable.elite);
                intent_croccantini.putExtra("Immagine", R.drawable.cibo_per_cani);
                intent_croccantini.putExtra("Titolo", "Croccantini per cani");
                intent_croccantini.putExtra("PrezzoVecchio", R.string.prezzoCani);
                intent_croccantini.putExtra("PrezzoNuovo", "€14.99");
                intent_croccantini.putExtra("Sconto", R.drawable.sconto40);
                intent_croccantini.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_croccantini);
                break;

            case R.id.tenerone_offerte:
                Intent intent_tenerone = new Intent(view.getContext(), ProdottoGenerico.class);
                intent_tenerone.putExtra("Supermercato", R.drawable.carrefour);
                intent_tenerone.putExtra("Immagine", R.drawable.tenerone);
                intent_tenerone.putExtra("Titolo", "Teneroni di prosciutto cotto");
                intent_tenerone.putExtra("PrezzoVecchio", R.string.prezzoTenerone);
                intent_tenerone.putExtra("PrezzoNuovo", "€1.99");
                intent_tenerone.putExtra("Sconto", R.drawable.sconto33);
                intent_tenerone.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_tenerone);
                break;

             */

            default:
                break;
        }

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

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




        //Passa all'activity figlia prodotto_generico
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

        mCardViewCroccantini = root.findViewById(R.id.croccantini_offerte);
        mCardViewCroccantini.setOnClickListener(this);

        mCardViewTenerone = root.findViewById(R.id.tenerone_offerte);
        mCardViewTenerone.setOnClickListener(this);






        mSearchView = root.findViewById(R.id.search_view);
        mSearchView.setQueryHint("Cerca prodotto");

        return root;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.acqua_offerte:
                Intent intent_acqua = new Intent(view.getContext(), ProdottoGenerico.class);
                intent_acqua.putExtra("Supermercato", R.drawable.conad);
                intent_acqua.putExtra("Immagine", R.drawable.acqua_lete);
                intent_acqua.putExtra("Titolo", "Acqua minerale naturale Lete");
                intent_acqua.putExtra("PrezzoVecchio", R.string.prezzoAcqua);
                intent_acqua.putExtra("PrezzoNuovo", "€1.99");
                intent_acqua.putExtra("Sconto", R.drawable.sconto20);
                intent_acqua.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_acqua);
                break;

            case R.id.ananas_offerte:
                Intent intent_ananas = new Intent(view.getContext(), ProdottoGenerico.class);
                intent_ananas.putExtra("Supermercato", R.drawable.elite);
                intent_ananas.putExtra("Immagine", R.drawable.ananas);
                intent_ananas.putExtra("Titolo", "Ananas tropicale");
                intent_ananas.putExtra("PrezzoVecchio", R.string.prezzoAnanas);
                intent_ananas.putExtra("PrezzoNuovo", "€0.99");
                intent_ananas.putExtra("Sconto", R.drawable.sconto50);
                intent_ananas.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_ananas);
                break;

            case R.id.cereali_offerte:
                Intent intent_cereali = new Intent(view.getContext(), ProdottoGenerico.class);
                intent_cereali.putExtra("Supermercato", R.drawable.carrefour);
                intent_cereali.putExtra("Immagine", R.drawable.cereali);
                intent_cereali.putExtra("Titolo", "Cereali Cheerios");
                intent_cereali.putExtra("PrezzoVecchio", R.string.prezzoCereali);
                intent_cereali.putExtra("PrezzoNuovo", "€1.79");
                intent_cereali.putExtra("Sconto", R.drawable.sconto40);
                intent_cereali.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_cereali);
                break;

            case R.id.fagioli_offerte:
                Intent intent_fagioli = new Intent(view.getContext(), ProdottoGenerico.class);
                intent_fagioli.putExtra("Supermercato", R.drawable.elite);
                intent_fagioli.putExtra("Immagine", R.drawable.fagioli);
                intent_fagioli.putExtra("Titolo", "Fagioli in scatola");
                intent_fagioli.putExtra("PrezzoVecchio", R.string.prezzoFagioli);
                intent_fagioli.putExtra("PrezzoNuovo", "€0.66");
                intent_fagioli.putExtra("Sconto", R.drawable.sconto33);
                intent_fagioli.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_fagioli);
                break;

            case R.id.melanzana_offerte:
                Intent intent_melanzana = new Intent(view.getContext(), ProdottoGenerico.class);
                intent_melanzana.putExtra("Supermercato", R.drawable.conad);
                intent_melanzana.putExtra("Immagine", R.drawable.melanzana);
                intent_melanzana.putExtra("Titolo", "Melanzana");
                intent_melanzana.putExtra("PrezzoVecchio", R.string.prezzoMelanzana);
                intent_melanzana.putExtra("PrezzoNuovo", "€0.89/Kg");
                intent_melanzana.putExtra("Sconto", R.drawable.sconto10);
                intent_melanzana.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_melanzana);
                break;

            case R.id.vino_offerte:
                Intent intent_vino = new Intent(view.getContext(), ProdottoGenerico.class);
                intent_vino.putExtra("Supermercato", R.drawable.carrefour);
                intent_vino.putExtra("Immagine", R.drawable.vino);
                intent_vino.putExtra("Titolo", "Vino rosso Chianti D.O.P.");
                intent_vino.putExtra("PrezzoVecchio", R.string.prezzoVino);
                intent_vino.putExtra("PrezzoNuovo", "€3.99");
                intent_vino.putExtra("Sconto", R.drawable.sconto50);
                intent_vino.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_vino);
                break;

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

            default:
                break;
        }

    }
}

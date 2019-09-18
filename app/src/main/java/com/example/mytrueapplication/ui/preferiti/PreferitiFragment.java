package com.example.mytrueapplication.ui.preferiti;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mytrueapplication.ProdottoGenerico;
import com.example.mytrueapplication.R;

public class PreferitiFragment extends Fragment implements View.OnClickListener{

    private PreferitiViewModel preferitiViewModel;
    private SearchView mSearchView = null;



    CardView mCardViewAcqua = null;
    CardView mCardViewBanana = null;
    CardView mCardViewCroccantini = null;
    CardView mCardViewDetersivo = null;
    CardView mCardViewProsciuttoCotto = null;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        preferitiViewModel =
                ViewModelProviders.of(this).get(PreferitiViewModel.class);
        View root = inflater.inflate(R.layout.fragment_preferiti, container, false);
        /*
        final TextView textView = root.findViewById(R.id.text_preferiti);
        preferitiViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        */



        //Trovo id e setto listener della card per fare on Click
        mCardViewAcqua = root.findViewById(R.id.acqua_preferiti);
        mCardViewAcqua.setOnClickListener(this);

        mCardViewBanana = root.findViewById(R.id.banana_preferiti);
        mCardViewBanana.setOnClickListener(this);

        mCardViewCroccantini = root.findViewById(R.id.croccantini_preferiti);
        mCardViewCroccantini.setOnClickListener(this);

        mCardViewDetersivo = root.findViewById(R.id.detersivo_preferiti);
        mCardViewDetersivo.setOnClickListener(this);

        mCardViewProsciuttoCotto = root.findViewById(R.id.prosciutto_cotto_preferiti);
        mCardViewProsciuttoCotto.setOnClickListener(this);





        //searchview
        mSearchView = root.findViewById(R.id.search_view);
        mSearchView.setQueryHint("Cerca preferito");


        return root;
    }



    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.acqua_preferiti:
                createCard(view, R.drawable.conad, R.drawable.acqua_lete, "Acqua minerale naturale Lete", R.string.prezzoAcqua, "€1.99", R.drawable.sconto20,  R.string.descrizioneAcqua);
                break;

            case R.id.banana_preferiti:
                createCard(view, R.drawable.elite, R.drawable.banana, "Banana Chiquita", -1, "€0.80/kg", -1,  R.string.descrizioneBanana);
                break;

            case R.id.croccantini_preferiti:
                createCard(view, R.drawable.elite, R.drawable.cibo_per_cani,"Croccantini per cani", R.string.prezzoCani, "€14.99", R.drawable.sconto40, R.string.descrizioneCani);
                break;

            case R.id.detersivo_preferiti:
                createCard(view, R.drawable.pam, R.drawable.omino_bianco, "Detersivo Omino Bianco", -1,"€3.99", -1, R.string.descrizioneDetersivo);
                break;

            case R.id.prosciutto_cotto_preferiti:
                createCard(view, R.drawable.coop, R.drawable.prosciutto_cotto, "Prosciutto cotto Rovagnati", -1, "€1.09", -1, R.string.descrizioneProsciutto);
                break;



            default:
                break;
        }

    }



    public void createCard(View view, int imgSup, int imgProd, String titPro, int prezzoOld,String prezzoNew, int sconto, int descr)
    {
        Intent intent = new Intent(view.getContext(), ProdottoGenerico.class);
        intent.putExtra("Supermercato", imgSup);
        intent.putExtra("Immagine", imgProd);
        intent.putExtra("Titolo", titPro);
        intent.putExtra("PrezzoVecchio", prezzoOld);
        intent.putExtra("PrezzoNuovo", prezzoNew);
        intent.putExtra("Sconto", sconto);
        intent.putExtra("Descrizione", descr);

        intent.putExtra("ActivityName", "PreferitiFragment");
        startActivity(intent);

    }
}

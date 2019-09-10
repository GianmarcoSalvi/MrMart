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
    CardView mCardViewUova = null;


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





        //Passa all'activity figlia prodotto_generico
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

        mCardViewUova = root.findViewById(R.id.uova_preferiti);
        mCardViewUova.setOnClickListener(this);




        //searchview
        mSearchView = root.findViewById(R.id.search_view);
        mSearchView.setQueryHint("Cerca preferito");
        return root;
    }



    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.acqua_preferiti:
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


            case R.id.banana_preferiti:
                Intent intent_banana = new Intent(view.getContext(), ProdottoGenerico.class);
                intent_banana.putExtra("Supermercato", R.drawable.elite);
                intent_banana.putExtra("Immagine", R.drawable.banana);
                intent_banana.putExtra("Titolo", "Banana Chiquita");
                intent_banana.putExtra("PrezzoNuovo", "€0.80/kg");
                intent_banana.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_banana);
                break;


            case R.id.croccantini_preferiti:
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

            case R.id.detersivo_preferiti:
                Intent intent_detersivo = new Intent(view.getContext(), ProdottoGenerico.class);
                intent_detersivo.putExtra("Supermercato", R.drawable.pam);
                intent_detersivo.putExtra("Immagine", R.drawable.omino_bianco);
                intent_detersivo.putExtra("Titolo", "Detersivo Omino Bianco");
                intent_detersivo.putExtra("PrezzoNuovo", "€3.99");
                intent_detersivo.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_detersivo);
                break;

            case R.id.prosciutto_cotto_preferiti:
                Intent intent_prosciutto = new Intent(view.getContext(), ProdottoGenerico.class);
                intent_prosciutto.putExtra("Supermercato", R.drawable.coop);
                intent_prosciutto.putExtra("Immagine", R.drawable.prosciutto_cotto);
                intent_prosciutto.putExtra("Titolo", "Prosciutto cotto Rovagnati");
                intent_prosciutto.putExtra("PrezzoNuovo", "€1.09");
                intent_prosciutto.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_prosciutto);
                break;

            case R.id.uova_preferiti:
                Intent intent_uova = new Intent(view.getContext(), ProdottoGenerico.class);
                intent_uova.putExtra("Supermercato", R.drawable.carrefour);
                intent_uova.putExtra("Immagine", R.drawable.uova);
                intent_uova.putExtra("Titolo", "Uova bio 6 pz");
                intent_uova.putExtra("PrezzoNuovo", "€1.59");
                intent_uova.putExtra("Descrizione", "Ananas tropicale");
                startActivity(intent_uova);
                break;


            default:
                break;
        }

    }
}

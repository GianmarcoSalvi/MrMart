package com.example.mytrueapplication.ui.supermercati;

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

import com.example.mytrueapplication.R;
import com.example.mytrueapplication.CatergorieSupermercati;

public class SupermercatiFragment extends Fragment implements View.OnClickListener{

    private SupermercatiViewModel supermercatiViewModel;
    private SearchView mSearchView;


    private CardView mCardViewElite;
    private CardView mCardViewPam;
    private CardView mCardViewSimply;
    private CardView mCardViewCarrefour;
    private CardView mCardViewCoop;
    private CardView mCardViewConad;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        supermercatiViewModel =
                ViewModelProviders.of(this).get(SupermercatiViewModel.class);
        View root = inflater.inflate(R.layout.fragment_supermercati, container, false);

        /*
        final TextView textView = root.findViewById(R.id.text_supermercati);
        supermercatiViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
         */


        //Trovo id e setto listener della card per fare on Click

        mCardViewElite = root.findViewById(R.id.supermercato_elite);
        mCardViewElite.setOnClickListener(this);

        mCardViewPam = root.findViewById(R.id.supermercato_pam);
        mCardViewPam.setOnClickListener(this);

        mCardViewSimply = root.findViewById(R.id.supermercato_simply);
        mCardViewSimply.setOnClickListener(this);

        mCardViewCarrefour = root.findViewById(R.id.supermercato_carrefour);
        mCardViewCarrefour.setOnClickListener(this);

        mCardViewCoop = root.findViewById(R.id.supermercato_coop);
        mCardViewCoop.setOnClickListener(this);

        mCardViewConad = root.findViewById(R.id.supermercato_conad);
        mCardViewConad.setOnClickListener(this);


        //searchview
        mSearchView = root.findViewById(R.id.search_view);
        mSearchView.setQueryHint("Cerca supermercato");


        return root;

    }



    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.supermercato_elite:
                startNewActivity("Elite");
                break;

            case R.id.supermercato_pam:
                startNewActivity("Pam");
                break;

            case R.id.supermercato_simply:
                startNewActivity("Simply");
                break;

            case R.id.supermercato_carrefour:
                startNewActivity("Carrefour");
                break;

            case R.id.supermercato_coop:
                startNewActivity("Coop");
                break;

            case R.id.supermercato_conad:
                startNewActivity("Conad");
                break;

            default:
                break;
        }

    }

    public void startNewActivity(String supermercatoScelto)
    {
        Intent intent = new Intent(getContext(), CatergorieSupermercati.class);
        intent.putExtra("SupermercatoScelto", supermercatoScelto);
        startActivity(intent);
    }


}

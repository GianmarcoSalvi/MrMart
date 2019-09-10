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

import com.example.mytrueapplication.AnanasOfferte;
import com.example.mytrueapplication.FruttaElite;
import com.example.mytrueapplication.R;


public class OfferteFragment extends Fragment {

    private OfferteViewModel offerteViewModel;
    private CardView mCardView = null;
    private SearchView mSearchView = null;

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


        //Passa all'activity figlia ananas_offerte
        mCardView = root.findViewById(R.id.ananas_offerte);
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), AnanasOfferte.class);
                startActivity(intent);
            }
        });


        mSearchView = root.findViewById(R.id.search_view);
        mSearchView.setQueryHint("Cerca prodotto");

        return root;
    }
}

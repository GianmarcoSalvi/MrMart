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

public class SupermercatiFragment extends Fragment {

    private SupermercatiViewModel supermercatiViewModel;
    private SearchView mSearchView;
    private CardView mCardView;

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
        //searchview
        mSearchView = root.findViewById(R.id.search_view);
        mSearchView.setQueryHint("Cerca supermercato");

        //setting new activity from card click

        mCardView = root.findViewById(R.id.elite);
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), CatergorieSupermercati.class);
                startActivity(intent);
            }
        });

        return root;
    }

}

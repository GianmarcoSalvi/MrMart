package com.example.mytrueapplication.ui.offerte;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mytrueapplication.R;


public class OfferteFragment extends Fragment {

    private OfferteViewModel offerteViewModel;

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

        return root;
    }
}

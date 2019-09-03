package com.example.mytrueapplication.ui.preferiti;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mytrueapplication.R;

public class PreferitiFragment extends Fragment {
    private PreferitiViewModel preferitiViewModel;
    private SearchView mSearchView = null;

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

        //searchview
        mSearchView = root.findViewById(R.id.search_view);
        mSearchView.setQueryHint("Cerca preferito");
        return root;
    }
}

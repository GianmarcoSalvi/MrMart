package com.example.mytrueapplication.ui.supermercati;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SupermercatiViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public SupermercatiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is supermercati fragment");

    }



    public LiveData<String> getText() {
        return mText;
    }
}

package com.example.mytrueapplication.ui.offerte;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OfferteViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OfferteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is offerte fragment");
    }
    public LiveData<String> getText() {
        return mText;
    }

}

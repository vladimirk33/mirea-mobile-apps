package com.mirea.kateninva.fragmentmanagerapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShareViewModel extends ViewModel {
    private final MutableLiveData<String> selectedItem = new MutableLiveData<>();

    public void setSomeValue(String item) {
        selectedItem.setValue(item);
    }

    public LiveData<String> getSomeValue() {
        return selectedItem;
    }
}

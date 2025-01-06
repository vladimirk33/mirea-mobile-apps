package com.mirea.kateninva.drinkproject.viewModels;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class AuthActivityViewModelFactory implements ViewModelProvider.Factory {

    private final Context context;

    public AuthActivityViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AuthActivityViewModel(context);
    }

}

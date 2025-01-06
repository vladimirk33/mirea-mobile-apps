package com.mirea.kateninva.drinkproject.viewModels;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mirea.kateninva.data.apiWork.RemoteDataSource;
import com.mirea.kateninva.data.repository.DrinkRepositoryImpl;
import com.mirea.kateninva.domain.ApiCallback;
import com.mirea.kateninva.domain.models.Drink;
import com.mirea.kateninva.domain.usecases.drink.GetRandomDrinkUseCase;

import java.util.List;

public class DrinkListsFragmentViewModel extends ViewModel {

    private GetRandomDrinkUseCase getRandomDrinkUseCase;

    private RemoteDataSource remoteDataSource;

    private MutableLiveData<List<Drink>> randomDrink = new MutableLiveData<>();
    private MediatorLiveData<List<Drink>> drinkLiveData = new MediatorLiveData<>();

    private final Context context;

    public DrinkListsFragmentViewModel(Context context) {
        this.context = context;

        remoteDataSource = new RemoteDataSource();
        DrinkRepositoryImpl drinkRepository = new DrinkRepositoryImpl(remoteDataSource);

        getRandomDrinkUseCase = new GetRandomDrinkUseCase(drinkRepository);

        drinkLiveData.addSource(randomDrink, randomDrink -> {
            getDrinkLiveDataRandom(randomDrink);
        });
    }

    private void getDrinkLiveDataRandom(List<Drink> drink) {
        drinkLiveData.setValue(drink);
    }

    public void getRandomDrink() {
        getRandomDrinkUseCase.execute(new ApiCallback<List<Drink>>() {
            @Override
            public void onSuccess(List<Drink> result) {
                randomDrink.setValue(result);
                System.out.println("Request");
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public MediatorLiveData<List<Drink>> getDrinkLiveData() {
        return drinkLiveData;
    }

}

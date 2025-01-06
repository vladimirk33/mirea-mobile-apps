package com.mirea.kateninva.data.apiWork;

import androidx.annotation.NonNull;

import com.mirea.kateninva.domain.ApiCallback;
import com.mirea.kateninva.domain.models.Drink;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {

    private static final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/";
    private final DrinksApi drinksApi;

    public RemoteDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        drinksApi = retrofit.create(DrinksApi.class);
    }

    public void getRandomDrinks(ApiCallback<List<Drink>> apiCallback) {
        List<Drink> drinksList = new ArrayList<>();
        AtomicInteger completedRequests = new AtomicInteger(0);

        for (int i = 0; i < 10; i++) {
            drinksApi.getRandomDrink().enqueue(new Callback<DrinksResponse>() {
                @Override
                public void onResponse(@NonNull Call<DrinksResponse> call, @NonNull retrofit2.Response<DrinksResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        synchronized (drinksList) {
                            drinksList.addAll(response.body().getDrinks()); // Добавляем полученные напитки в общий список
                        }
                    }

                    if (completedRequests.incrementAndGet() == 10) {
                        apiCallback.onSuccess(drinksList);
                    }
                }

                @Override
                public void onFailure(@NonNull Call<DrinksResponse> call, @NonNull Throwable t) {
                    if (completedRequests.incrementAndGet() == 10) {
                        apiCallback.onSuccess(drinksList);
                    }
                }
            });
        }
    }
}

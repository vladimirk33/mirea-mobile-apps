package com.mirea.kateninva.data.repository;

import com.mirea.kateninva.data.apiWork.RemoteDataSource;
import com.mirea.kateninva.domain.ApiCallback;
import com.mirea.kateninva.domain.models.Drink;
import com.mirea.kateninva.domain.models.User;
import com.mirea.kateninva.domain.repository.DrinkRepository;

import java.util.List;

public class DrinkRepositoryImpl implements DrinkRepository {

    private User currentUser;
    private RemoteDataSource remoteDataSource;

    public DrinkRepositoryImpl(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public Drink[] getAll() {
        return new Drink[] { Drink.getTestDrink() };
    }

    public Drink[] getFavourites() {
        return new Drink[] { Drink.getTestDrink() };
    }

    @Override
    public boolean addFavourite(Drink drink) {
        return false;
    }

    public boolean deleteFromFavourites(int id) {
        return true;
    }

    @Override
    public Drink getDrink(int id) {
        return Drink.getTestDrink();
    }

    @Override
    public void getRandomDrinks(ApiCallback<List<Drink>> apiCallback) {
        remoteDataSource.getRandomDrinks(apiCallback);
    }

}

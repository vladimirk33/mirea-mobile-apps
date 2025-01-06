package com.mirea.kateninva.domain.repository;

import com.mirea.kateninva.domain.ApiCallback;
import com.mirea.kateninva.domain.models.Drink;

import java.util.List;

public interface DrinkRepository {

    public Drink[] getAll();

    public Drink[] getFavourites();

    public boolean addFavourite(Drink drink);

    public boolean deleteFromFavourites(int id);

    public Drink getDrink(int id);

    public void getRandomDrinks(ApiCallback<List<Drink>> apiCallback);
}

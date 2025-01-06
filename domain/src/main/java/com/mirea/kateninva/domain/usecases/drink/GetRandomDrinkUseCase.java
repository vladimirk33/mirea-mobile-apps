package com.mirea.kateninva.domain.usecases.drink;

import com.mirea.kateninva.domain.ApiCallback;
import com.mirea.kateninva.domain.models.Drink;
import com.mirea.kateninva.domain.repository.DrinkRepository;

import java.util.List;

public class GetRandomDrinkUseCase {

    private DrinkRepository drinkRepository;

    public GetRandomDrinkUseCase(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public void execute(ApiCallback<List<Drink>> apiCallback) {
        drinkRepository.getRandomDrinks(apiCallback);
    }

}

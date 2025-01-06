package com.mirea.kateninva.domain.usecases;

import com.mirea.kateninva.domain.models.Drink;
import com.mirea.kateninva.domain.repository.DrinkRepository;

public class AddDrinkToFavouritesUseCase {

    private DrinkRepository drinkRepository;

    public AddDrinkToFavouritesUseCase(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public boolean execute() {
        return drinkRepository.addFavourite(Drink.getTestDrink());
    }

}

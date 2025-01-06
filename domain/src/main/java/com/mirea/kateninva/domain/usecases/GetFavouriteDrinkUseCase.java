package com.mirea.kateninva.domain.usecases;

import com.mirea.kateninva.domain.models.Drink;
import com.mirea.kateninva.domain.repository.DrinkRepository;

public class GetFavouriteDrinkUseCase {

    private DrinkRepository drinkRepository;

    public GetFavouriteDrinkUseCase(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public Drink[] execute() {
        return drinkRepository.getFavourites();
    }

}

package com.mirea.kateninva.domain.usecases;

import com.mirea.kateninva.domain.repository.DrinkRepository;

public class DeleteDrinkFromFavouritesUseCase {

    private DrinkRepository drinkRepository;

    public DeleteDrinkFromFavouritesUseCase(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public boolean execute() {
        return drinkRepository.deleteFromFavourites(1);
    }

}

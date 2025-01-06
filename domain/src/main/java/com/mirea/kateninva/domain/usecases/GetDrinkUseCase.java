package com.mirea.kateninva.domain.usecases;

import com.mirea.kateninva.domain.models.Drink;
import com.mirea.kateninva.domain.repository.DrinkRepository;

public class GetDrinkUseCase {

    private DrinkRepository drinkRepository;

    public GetDrinkUseCase(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public Drink execute() {
        return drinkRepository.getDrink(1);
    }

}

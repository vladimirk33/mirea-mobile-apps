package com.mirea.kateninva.domain.usecases;

import com.mirea.kateninva.domain.models.Drink;
import com.mirea.kateninva.domain.repository.DrinkRepository;

public class GetAllDrinkUseCase {

    private DrinkRepository drinkRepository;

    public GetAllDrinkUseCase(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public Drink[] execute() {
        return drinkRepository.getAll();
    }

}

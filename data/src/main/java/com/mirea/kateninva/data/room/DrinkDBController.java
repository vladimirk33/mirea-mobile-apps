package com.mirea.kateninva.data.room;

import com.mirea.kateninva.data.room.models.Drink;

public interface DrinkDBController {

    public void getDrink();
    public void addDrink(Drink drink);
    public void removeDrink(String title);

}

package com.mirea.kateninva.data.room;

import android.content.Context;

import androidx.room.Room;

import com.mirea.kateninva.data.room.models.Drink;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RoomDrinkDBController implements DrinkDBController {

    private DrinkDB drinkDB;
    private Context context;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public RoomDrinkDBController(Context context) {
        this.context = context;

        drinkDB = Room.databaseBuilder(context, DrinkDB.class, "DrinkDB")
                .build();
    }

    @Override
    public void getDrink() {
        executorService.execute(() -> drinkDB.getDrinkDAO().getAllDrinks());
    }

    @Override
    public void addDrink(Drink drink) {
        executorService.execute(() -> drinkDB.getDrinkDAO().addDrink(drink));
    }

    @Override
    public void removeDrink(String title) {
        executorService.execute(() -> drinkDB.getDrinkDAO().removeDrink(title));
    }

}

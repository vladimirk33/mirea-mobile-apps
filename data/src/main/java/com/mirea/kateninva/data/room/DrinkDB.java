package com.mirea.kateninva.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.mirea.kateninva.data.room.models.Drink;

@Database(entities = {Drink.class}, version = 1)
public abstract class DrinkDB extends RoomDatabase {

    public abstract DrinkDAO getDrinkDAO();

}

package com.mirea.kateninva.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.mirea.kateninva.data.room.models.Drink;

import java.util.List;

@Dao
public interface DrinkDAO {

    @Query("select * from drink")
    public List<Drink> getAllDrinks();

    @Query("select * from drink where title==:title")
    public List<Drink> getDrinkByTitle(String title);

    @Insert
    public void addDrink(Drink drink);

    @Update
    public void changeDrink(Drink drink);

    @Query("delete from drink where title==:title")
    public void removeDrink(String title);

    @Query("delete from drink")
    public void clear();

}

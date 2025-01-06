package com.mirea.kateninva.data.data.storage;


import com.mirea.kateninva.data.data.storage.models.Movie;

public interface MovieStorage {

    public Movie get();
    public boolean save(Movie movie);

}

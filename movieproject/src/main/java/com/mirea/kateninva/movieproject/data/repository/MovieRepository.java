package com.mirea.kateninva.movieproject.data.repository;

import android.content.Context;

import com.mirea.kateninva.movieproject.domain.models.Movie;

public class MovieRepository {
    public boolean saveMovie(Movie movie) {
        return true;
    }

    public Movie getMovie() {
        return new Movie(1,"Doctor Strange");
    }
}

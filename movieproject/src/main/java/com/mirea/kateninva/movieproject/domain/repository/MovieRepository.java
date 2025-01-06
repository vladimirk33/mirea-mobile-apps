package com.mirea.kateninva.movieproject.domain.repository;

import android.content.Context;

import com.mirea.kateninva.movieproject.domain.models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);
    public Movie getMovie();
}
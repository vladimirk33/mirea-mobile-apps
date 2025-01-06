package com.mirea.kateninva.domain.domain.repository;


import com.mirea.kateninva.domain.domain.models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);

    public Movie getMovie();
}
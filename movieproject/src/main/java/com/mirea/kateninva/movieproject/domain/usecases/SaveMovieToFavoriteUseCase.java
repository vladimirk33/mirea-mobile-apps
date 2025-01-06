package com.mirea.kateninva.movieproject.domain.usecases;


import android.content.Context;

import com.mirea.kateninva.movieproject.domain.models.Movie;
import com.mirea.kateninva.movieproject.domain.repository.MovieRepository;

public class SaveMovieToFavoriteUseCase {
    private MovieRepository movieRepository;

    public SaveMovieToFavoriteUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public boolean execute(Movie movie){
        return movieRepository.saveMovie(movie);
    }
}
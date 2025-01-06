package com.mirea.kateninva.movieproject.domain.usecases;

import android.content.Context;

import com.mirea.kateninva.movieproject.domain.models.Movie;
import com.mirea.kateninva.movieproject.domain.repository.MovieRepository;

public class GetFavoriteFilmUseCase {
    private MovieRepository movieRepository;

    public GetFavoriteFilmUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public Movie execute() {
        return movieRepository.getMovie();
    }
}

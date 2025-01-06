package com.mirea.kateninva.domain.domain.usecases;


import com.mirea.kateninva.domain.domain.repository.MovieRepository;
import com.mirea.kateninva.domain.domain.models.Movie;

public class GetFavoriteFilmUseCase {
    private MovieRepository movieRepository;

    public GetFavoriteFilmUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public Movie execute() {
        return movieRepository.getMovie();
    }
}

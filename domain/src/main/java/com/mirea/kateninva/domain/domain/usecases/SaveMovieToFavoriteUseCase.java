package com.mirea.kateninva.domain.domain.usecases;



import com.mirea.kateninva.domain.domain.repository.MovieRepository;
import com.mirea.kateninva.domain.domain.models.Movie;

public class SaveMovieToFavoriteUseCase {
    private MovieRepository movieRepository;

    public SaveMovieToFavoriteUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public boolean execute(Movie movie){
        return movieRepository.saveMovie(movie);
    }
}
package com.mirea.kateninva.data.data;

import com.mirea.kateninva.data.data.storage.MovieStorage;
import com.mirea.kateninva.data.data.storage.models.Movie;
import com.mirea.kateninva.domain.domain.repository.MovieRepository;

import java.time.LocalDate;

public class MovieRepositoryImpl implements MovieRepository {

    private MovieStorage movieStorage;

    public MovieRepositoryImpl(MovieStorage movieStorage) {
        this.movieStorage = movieStorage;
    }

    @Override
    public boolean saveMovie(com.mirea.kateninva.domain.domain.models.Movie movie) {
        return movieStorage.save(mapToStorage(movie));
    }

    @Override
    public com.mirea.kateninva.domain.domain.models.Movie getMovie() {
        return mapToDomain(movieStorage.get());
    }

    private Movie mapToStorage(com.mirea.kateninva.domain.domain.models.Movie movie){
        String name = movie.getName();
        return new Movie(2, name, LocalDate.now().toString());
    }

    private com.mirea.kateninva.domain.domain.models.Movie mapToDomain(Movie movie) {
        return new com.mirea.kateninva.domain.domain.models.Movie(movie.getId(), movie.getName());
    }

}
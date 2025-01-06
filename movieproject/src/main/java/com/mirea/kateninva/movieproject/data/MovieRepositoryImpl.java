package com.mirea.kateninva.movieproject.data;

import static android.app.PendingIntent.getActivity;

import static java.security.AccessController.getContext;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.mirea.kateninva.movieproject.domain.models.Movie;
import com.mirea.kateninva.movieproject.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {

    private Context context;

    public MovieRepositoryImpl(Context iContext) {
        context = iContext;
    }

    @Override
    public boolean saveMovie(Movie movie) {
        SharedPreferences sharedPref = context.getSharedPreferences("films_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("FAV_FILM", movie.getName());
        editor.apply();

        return true;
    }

    @Override
    public Movie getMovie() {
        SharedPreferences sharedPref = context.getSharedPreferences("films_data", Context.MODE_PRIVATE);
        String filmName = sharedPref.getString("FAV_FILM", "Game of throne");

        return new Movie(1, filmName);
    }
}
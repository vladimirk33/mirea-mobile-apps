package com.mirea.kateninva.data.data.storage.sharedprefs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.mirea.kateninva.data.data.storage.MovieStorage;
import com.mirea.kateninva.data.data.storage.models.Movie;

import java.time.LocalDate;

public class SharedPrefMovieStorage implements MovieStorage {

    private static final String SHARED_PREFS_NAME = "films_data";
    private static final String KEY = "FAV_FILM";
    private static final String DATE_KEY = "movie_date";
    private static final String ID_KEY = "movie_id";

    private Context context;
    private SharedPreferences sharedPreferences;

    public SharedPrefMovieStorage(Context iContext) {
        context = iContext;
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public Movie get() {
        String movieName = sharedPreferences.getString(KEY, "Game of throne");
        String movieDate = sharedPreferences.getString(DATE_KEY, String.valueOf(LocalDate.now()));
        int movieId = sharedPreferences.getInt(ID_KEY, -1);

        return new Movie(movieId, movieName, movieDate);
    }

    @Override
    public boolean save(Movie movie) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY, movie.getName());
        editor.putString(DATE_KEY, String.valueOf(LocalDate.now()));
        editor.putInt(ID_KEY, 1);
        editor.apply();

        return false;
    }

}

package com.mirea.kateninva.movieproject.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mirea.kateninva.data.data.MovieRepositoryImpl;
import com.mirea.kateninva.data.data.storage.MovieStorage;
import com.mirea.kateninva.data.data.storage.sharedprefs.SharedPrefMovieStorage;
import com.mirea.kateninva.domain.domain.repository.MovieRepository;
import com.mirea.kateninva.movieproject.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText text = findViewById(R.id.edit_field);
        TextView textView = findViewById(R.id.fav_film_text);

        MovieStorage sharedPrefMovieStorage = new SharedPrefMovieStorage(this);
        MovieRepository movieRepository = new MovieRepositoryImpl(sharedPrefMovieStorage);
        findViewById(R.id.save_button).setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Boolean result = new
                          com.mirea.kateninva.domain.domain.usecases.SaveMovieToFavoriteUseCase(movieRepository).execute(new com.mirea.kateninva.domain.domain.models.Movie(2,
                          text.getText().toString()));
                  textView.setText(String.format("Save result %s", result));
              }
        });

        findViewById(R.id.show_button).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 com.mirea.kateninva.domain.domain.models.Movie moview = new com.mirea.kateninva.domain.domain.usecases.GetFavoriteFilmUseCase(movieRepository).execute();
                 textView.setText(String.format("Save result %s", moview.getName()));
             }
        });
    }
}
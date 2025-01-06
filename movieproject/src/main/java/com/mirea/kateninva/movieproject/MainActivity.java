package com.mirea.kateninva.movieproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mirea.kateninva.movieproject.data.MovieRepositoryImpl;
import com.mirea.kateninva.movieproject.domain.repository.MovieRepository;
import com.mirea.kateninva.movieproject.domain.usecases.GetFavoriteFilmUseCase;
import com.mirea.kateninva.movieproject.domain.models.Movie;
import com.mirea.kateninva.movieproject.domain.usecases.SaveMovieToFavoriteUseCase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText text = findViewById(R.id.edit_field);
        TextView textView = findViewById(R.id.fav_film_text);

        MovieRepository movieRepository = new MovieRepositoryImpl(getApplicationContext());
        findViewById(R.id.save_button).setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Boolean result = new
                          SaveMovieToFavoriteUseCase(movieRepository).execute(new Movie(2,
                          text.getText().toString()));
                  textView.setText(String.format("Save result %s", result));
              }
        });

        findViewById(R.id.show_button).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Movie moview = new GetFavoriteFilmUseCase(movieRepository).execute();
                 textView.setText(String.format("Save result %s", moview.getName()));
             }
        });
    }
}
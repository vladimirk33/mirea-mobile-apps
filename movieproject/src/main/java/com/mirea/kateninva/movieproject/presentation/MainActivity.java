package com.mirea.kateninva.movieproject.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mirea.kateninva.data.data.MovieRepositoryImpl;
import com.mirea.kateninva.data.data.storage.MovieStorage;
import com.mirea.kateninva.data.data.storage.sharedprefs.SharedPrefMovieStorage;
import com.mirea.kateninva.domain.domain.models.Movie;
import com.mirea.kateninva.domain.domain.repository.MovieRepository;
import com.mirea.kateninva.movieproject.R;

//import java.util.Observer;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this, new ViewModelFactory(this)).get(MainViewModel.class);

        EditText text = findViewById(R.id.edit_field);
        TextView textView = findViewById(R.id.fav_film_text);

        viewModel.getFavoriteMovie().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(String.format("Save result: %s", s));
            }
        });

        findViewById(R.id.save_button).setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  viewModel.setText(new Movie(2, text.getText().toString()));
              }
        });

        findViewById(R.id.show_button).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 viewModel.getText();
             }
        });
    }
    
}
package ru.mirea.kateninva.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText group;
    private EditText number;
    private EditText film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group = findViewById(R.id.groupEditField);
        number = findViewById(R.id.numberEditField);
        film = findViewById(R.id.filmEditField);

        SharedPreferences sharedPref = getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
        group.setText(sharedPref.getString("GROUP", ""));
        number.setText(String.valueOf(sharedPref.getInt("NUMBER", 0)));
        film.setText(sharedPref.getString("FILM", ""));
    }

    public void onSaveClicked(View view) {
        SharedPreferences sharedPref = getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor	= sharedPref.edit();
        editor.putString("GROUP", group.getText().toString());
        editor.putInt("NUMBER", Integer.parseInt(number.getText().toString()));
        editor.putString("FILM", film.getText().toString());
        editor.apply();
    }
}
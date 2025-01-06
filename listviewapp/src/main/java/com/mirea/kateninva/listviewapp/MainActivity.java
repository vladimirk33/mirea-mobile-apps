package com.mirea.kateninva.listviewapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.ListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        List<String> titles = generateRealBookTitles(30);
        ListView listView = findViewById(R.id.content_list);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, titles);
        listView.setAdapter(arrayAdapter);
    }

    private static List<String> generateRealBookTitles(int numTitles) {
        List<String> titles = new ArrayList<>();
        String[] realTitles = {
                "Анна Каренина",
                "Братья Карамазовы",
                "Отцы и дети",
                "Мёртвые души",
                "Избранные рассказы",
                "Архипелаг ГУЛАГ",
                "Мастер и Маргарита",
                "Двенадцать стульев",
                "Алые паруса",
                "Доктор Живаго",
                "Generation 'П'",
                "Казус Кукоцкого",
                "Ночной дозор",
                "Зулейха открывает глаза",
                "День опричника",
                "Сто лет одиночества",
                "1984",
                "Три товарища",
                "Унесённые ветром",
                "Великий Гэтсби",
                "Так говорил Заратустра",
                "Искусство любить",
                "Думай медленно... решай быстро",
                "Сказать жизни 'Да'",
                "Sapiens. Краткая история человечества",
                "Основание",
                "451 градус по Фаренгейту",
                "Мечтают ли андроиды об электроовцах?",
                "Пикник на обочине",
                "Двадцать тысяч льё под водой"
        };

        Collections.shuffle(Arrays.asList(realTitles));
        titles.addAll(Arrays.asList(realTitles).subList(0, Math.min(numTitles, realTitles.length)));

        return titles;
    }
}
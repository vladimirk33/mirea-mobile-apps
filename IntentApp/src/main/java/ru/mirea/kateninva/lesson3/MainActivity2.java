package ru.mirea.kateninva.lesson3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tv = findViewById(R.id.textView);
        Intent intent = getIntent();
        String dateString = intent.getStringExtra("date");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String time = DateTimeFormatter.ofPattern("HH:mm").format(dateTime);

        tv.setText(String.format("КВАДРАТ ЗНАЧЕНИЯ " + "МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ %d, а текущее " + "время %s", (int) Math.pow(9, 2), time));
    }
}
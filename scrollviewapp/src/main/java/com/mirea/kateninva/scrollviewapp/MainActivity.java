package com.mirea.kateninva.scrollviewapp;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        generateSequence();
    }

    private void generateSequence() {
        LinearLayout scrollView = findViewById(R.id.wrapper);

        BigInteger lastNum = new BigInteger("1");
        for (int i = 0; i < 100; i++){
            View view = getLayoutInflater().inflate(R.layout.item, null, false);
            TextView text = (TextView)view.findViewById(R.id.text_view);
            text.setText(String.format("%d Элемент %d", i + 1, lastNum));
            lastNum = lastNum.multiply(new BigInteger("2"));

            scrollView.addView(view);
        }
    }
}
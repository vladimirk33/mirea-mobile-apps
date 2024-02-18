package ru.mirea.kateninva.buttonclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textViewStudent;
    private Button btnWhoAmI;
    private Button btnItIsNotMe;
    private CheckBox checkBoxUseless;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewStudent = findViewById(R.id.tvOut);
        btnWhoAmI = findViewById(R.id.btnWhoAmI);
        btnItIsNotMe = findViewById(R.id.btnItIsNotMe);
        checkBoxUseless = findViewById(R.id.checkBoxUseless);

        btnWhoAmI.setOnClickListener(v -> {
            textViewStudent.setText("Мой номер по списку №7 (возможно, 6)");
            changeCheckBoxStatus(checkBoxUseless);
        });
    }

    private void changeCheckBoxStatus(CheckBox cb) {
        cb.setChecked(!cb.isChecked());
    }

    public void onBtnItIsNotMeClick(View view) {
        textViewStudent.setText("Это не я сделал!");
        Toast.makeText(this, "Это не я сделал!", Toast.LENGTH_SHORT).show();
        changeCheckBoxStatus(checkBoxUseless);
    }
}
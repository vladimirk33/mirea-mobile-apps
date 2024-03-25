package ru.mirea.kateninva.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ShareActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        editText = findViewById(R.id.editText);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            editText.setText(String.format(extras.getString(MainActivity.KEY)));
        }
    }

    public void sendToMain(View view) {
        String content = editText.getText().toString();

        Intent data = new Intent();
        if (content.length() >= 1) {
            data.putExtra(MainActivity.USER_MESSAGE, content);
            setResult(Activity.RESULT_OK, data);
        } else {
            setResult(Activity.RESULT_CANCELED, data);
        }
        finish();
    }
}
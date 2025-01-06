package com.mirea.kateninva.resultapifragmentapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements FragmentListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().setFragmentResultListener(
                "requestKey",
                this,
                (requestKey, bundle) -> {
                    String result = bundle.getString("key");
                    Log.d(BottomSheetFragment.class.getSimpleName(), "I'm	MainActivity	" + result);
                }
        );

    }

    @Override
    public void sendResult(String message) {
        Log.d(MainActivity.class.getSimpleName(),"message:	"	+	message);
    }
}
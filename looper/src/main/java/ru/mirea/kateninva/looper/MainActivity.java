package ru.mirea.kateninva.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import ru.mirea.kateninva.looper.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle	savedInstanceState)	{
        super.onCreate(savedInstanceState);
        binding	= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Handler mainThreadHandler =	new	Handler(Looper.getMainLooper())	{
            @Override
            public	void handleMessage(Message msg)	{
                Log.d(MainActivity.class.getSimpleName(),	"Task	execute.	This	is	result:	"	+	msg.getData().getString("result"));
            }
        };
        MyLooper myLooper =	new	MyLooper(mainThreadHandler);
        myLooper.start();

        binding.editTextMirea.setText("Мой номер по списку № 09");
        binding.btn.setOnClickListener(view -> {
            Message	msg	=	Message.obtain();
            Bundle	bundle	=	new	Bundle();
            bundle.putString("KEY",	binding.editTextAge.getText().toString() + " лет, профессия " + binding.editTextWork.getText().toString());
            msg.setData(bundle);
            myLooper.mHandler.sendMessage(msg);
        });
    }
}
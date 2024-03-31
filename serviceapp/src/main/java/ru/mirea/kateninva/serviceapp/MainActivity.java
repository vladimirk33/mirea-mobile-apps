package ru.mirea.kateninva.serviceapp;

import static android.Manifest.permission.FOREGROUND_SERVICE;
import static android.Manifest.permission.POST_NOTIFICATIONS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import ru.mirea.kateninva.serviceapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private	int	PermissionCode	=	200;

    boolean musicPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding	= ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        if	(ContextCompat.checkSelfPermission(this,	POST_NOTIFICATIONS)	==	PackageManager.PERMISSION_GRANTED)	{
            Log.d(MainActivity.class.getSimpleName().toString(),	"Разрешения получены");
        }	else	{
            Log.d(MainActivity.class.getSimpleName().toString(),	"Нет разрешений!");
            ActivityCompat.requestPermissions(this,	new	String[]{POST_NOTIFICATIONS,	FOREGROUND_SERVICE},	PermissionCode);
        }


        binding.pauseButton.setOnClickListener(new	View.OnClickListener()	{
            @Override
            public	void	onClick(View	v)	{
                if (musicPlaying) {
                    stopService(
                            new	Intent(MainActivity.this,	PlayerService.class));
                } else {
                    Intent serviceIntent	=	new	Intent(MainActivity.this,	PlayerService.class);
                    ContextCompat.startForegroundService(MainActivity.this,	serviceIntent);
                }

                musicPlaying = !musicPlaying;
                binding.pauseButton.setImageDrawable(musicPlaying ?
                        getResources().getDrawable(R.drawable.pause)
                        : getResources().getDrawable(R.drawable.play));
            }
        });
    }
}
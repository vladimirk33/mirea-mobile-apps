package ru.mirea.kateninva.mireaproject;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class BGWorker extends Worker {
    static final String TAG = "BGWorker";
    public BGWorker(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
    }

    @Override
    public Result doWork() {
        long currentTimeMillis = System.currentTimeMillis();
        String time = getTimeString(currentTimeMillis);

        Log.d(TAG,"Current Time: " + time);

        scheduleNextUpdate();
        return Result.success();
    }

    private void scheduleNextUpdate() {
        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(BGWorker.class)
                .setInitialDelay(1, TimeUnit.SECONDS)
                .build();
        WorkManager.getInstance(getApplicationContext()).enqueue(workRequest);
    }

    private String getTimeString(long currentTimeMillis) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date(currentTimeMillis));
    }
}
package ru.mirea.kateninva.yandexdriver;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;

public class App extends Application {
    private final String MAPKIT_API_KEY = "407052fa-fcbc-418f-bcfe-9274f051e6ae";
    @Override
    public void onCreate() {
        super.onCreate();

        // Set the api key before calling initialize on MapKitFactory.
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
    }
}

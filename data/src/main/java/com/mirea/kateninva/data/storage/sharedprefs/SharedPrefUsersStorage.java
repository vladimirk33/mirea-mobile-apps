package com.mirea.kateninva.data.storage.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.mirea.kateninva.data.storage.UsersStorage;
import com.mirea.kateninva.data.storage.models.User;

import java.util.Date;

public class SharedPrefUsersStorage implements UsersStorage {

    private static final String SHARED_PREFS_NAME = "users_data";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_USER_EMAIL = "user_email";
    private static final String KEY_USER_PASSWORD = "user_password";
    private final SharedPreferences sharedPreferences;

    public SharedPrefUsersStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public User getUser() {
        String id = sharedPreferences.getString(KEY_USER_ID, "0");
        String name = sharedPreferences.getString(KEY_USER_NAME, "");
        String email = sharedPreferences.getString(KEY_USER_EMAIL, "");
        String password = sharedPreferences.getString(KEY_USER_PASSWORD, "");

        return new User(id, name, email, password, new Date());
    }

    @Override
    public boolean saveUser(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER_ID, user.getId());
        editor.putString(KEY_USER_NAME, user.getUserName());
        editor.putString(KEY_USER_EMAIL, user.getEmail());
        editor.apply();

        return true;
    }
}

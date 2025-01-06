package com.mirea.kateninva.data.storage;

import com.mirea.kateninva.data.storage.models.User;

public interface UsersStorage {

    public User getUser();
    public boolean saveUser(User user);

}

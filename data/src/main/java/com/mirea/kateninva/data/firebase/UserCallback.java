package com.mirea.kateninva.data.firebase;

import com.mirea.kateninva.domain.models.User;

public interface UserCallback {

    public void onSuccess(User user);
    public void onFailure(Exception e);

}

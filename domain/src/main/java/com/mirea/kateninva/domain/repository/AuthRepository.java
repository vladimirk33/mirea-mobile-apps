package com.mirea.kateninva.domain.repository;

import com.mirea.kateninva.domain.AuthorizationCallback;
import com.mirea.kateninva.domain.UserCallback;
import com.mirea.kateninva.domain.models.User;

public interface AuthRepository {

    public void signIn(String email, String password, AuthorizationCallback authCallback);
    public void register(String username, String email, String password, AuthorizationCallback authCallback);

    public boolean hasUserLogged();
    public void signOut();
    public void getUserInfo(String userId, UserCallback userCallback);
    public String getActiveUserId();

}

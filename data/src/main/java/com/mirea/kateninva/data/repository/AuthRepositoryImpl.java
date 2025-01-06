package com.mirea.kateninva.data.repository;

import com.google.android.gms.tasks.Task;
import com.mirea.kateninva.data.firebase.AuthController;
import com.mirea.kateninva.domain.AuthorizationCallback;
import com.mirea.kateninva.domain.UserCallback;
import com.mirea.kateninva.domain.models.User;
import com.mirea.kateninva.domain.repository.AuthRepository;

public class AuthRepositoryImpl implements AuthRepository {

    private final AuthController authController;

    public AuthRepositoryImpl(AuthController authController) {
        this.authController = authController;
    }

    @Override
    public void signIn(String email, String password, AuthorizationCallback authCallback) {
        authController.signIn(email, password, new AuthorizationCallbackAdapter(authCallback));
    }

    @Override
    public void register(String username, String email, String password, AuthorizationCallback authCallback) {
        authController.signUp(username, email, password, new AuthorizationCallbackAdapter(authCallback));
    }

    @Override
    public boolean hasUserLogged() {
        return authController.hasUserLogged();
    }

    @Override
    public void signOut() {
        authController.signOut();
    }

    @Override
    public void getUserInfo(String userId, UserCallback userCallback) {
        authController.getUserInfo(userId, new UserCallbackAdapter(userCallback));
    }

    @Override
    public String getActiveUserId() {
        return authController.getActiveUserId();
    }

    private static class AuthorizationCallbackAdapter implements com.mirea.kateninva.data.firebase.AuthorizationCallback {

        private final AuthorizationCallback authCallback;

        public AuthorizationCallbackAdapter(AuthorizationCallback authCallback) {
            this.authCallback = authCallback;
        }

        @Override
        public void onSuccess() {
            authCallback.onSuccess();
        }

        @Override
        public void onFailure() {
            authCallback.onFailure();
        }
    }

    private static class UserCallbackAdapter implements com.mirea.kateninva.data.firebase.UserCallback {

        private final UserCallback userCallback;

        public UserCallbackAdapter(UserCallback userCallback) {
            this.userCallback = userCallback;
        }

        @Override
        public void onSuccess(User user) {
            userCallback.onSuccess(user);
        }

        @Override
        public void onFailure(Exception e) {
            userCallback.onFailure(e);
        }

    }

}

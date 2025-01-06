package com.mirea.kateninva.domain.usecases.auth;

import com.mirea.kateninva.domain.AuthorizationCallback;
import com.mirea.kateninva.domain.repository.AuthRepository;

public class SignInUseCase {

    private AuthRepository authRepository;

    public SignInUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void execute(String email, String password, AuthorizationCallback authCallback) {
        authRepository.signIn(email, password, authCallback);
    }

}

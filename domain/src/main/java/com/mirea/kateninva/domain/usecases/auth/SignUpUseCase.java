package com.mirea.kateninva.domain.usecases.auth;

import com.mirea.kateninva.domain.AuthorizationCallback;
import com.mirea.kateninva.domain.repository.AuthRepository;

public class SignUpUseCase {

    private AuthRepository authRepository;

    public SignUpUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void execute(String name, String email, String password, AuthorizationCallback authCallback) {
        authRepository.register(name, email, password, authCallback);
    }

}

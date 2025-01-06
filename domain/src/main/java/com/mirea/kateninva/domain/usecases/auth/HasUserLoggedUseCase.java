package com.mirea.kateninva.domain.usecases.auth;

import com.mirea.kateninva.domain.repository.AuthRepository;

public class HasUserLoggedUseCase {

    private AuthRepository authRepository;

    public HasUserLoggedUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public boolean execute() {
        return authRepository.hasUserLogged();
    }

}

package com.mirea.kateninva.domain.usecases.auth;

import com.mirea.kateninva.domain.repository.AuthRepository;

public class LogOutUseCase {

    private AuthRepository authRepository;

    public LogOutUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void execute() {
        authRepository.signOut();
    }

}

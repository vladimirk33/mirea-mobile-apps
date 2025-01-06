package com.mirea.kateninva.domain.usecases;

import com.mirea.kateninva.domain.repository.AuthRepository;

public class GetActiveUserIdUseCase {

    private AuthRepository authRepository;

    public GetActiveUserIdUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public String execute() {
        return authRepository.getActiveUserId();
    }

}

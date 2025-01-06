package com.mirea.kateninva.domain.usecases;

import com.mirea.kateninva.domain.UserCallback;
import com.mirea.kateninva.domain.repository.AuthRepository;

public class GetUserInfoUseCase {

    private AuthRepository authRepository;

    public GetUserInfoUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void execute(String userId, UserCallback userCallback) {
        authRepository.getUserInfo(userId, userCallback);
    }

}

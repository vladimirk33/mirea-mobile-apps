package com.mirea.kateninva.domain.usecases;

import com.mirea.kateninva.domain.models.User;
import com.mirea.kateninva.domain.repository.UsersRepository;

public class GetAllUsersUseCase {

    private UsersRepository usersRepository;

    public GetAllUsersUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User[] execute() {
        return usersRepository.getAllUsers();
    }

}

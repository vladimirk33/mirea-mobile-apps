package com.mirea.kateninva.domain.usecases;

import com.mirea.kateninva.domain.models.User;
import com.mirea.kateninva.domain.repository.UsersRepository;

public class GetRecommendedUsers {

    private UsersRepository usersRepository;

    public GetRecommendedUsers(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User[] execute() {
        return usersRepository.getRecommendedUsers();
    }

}

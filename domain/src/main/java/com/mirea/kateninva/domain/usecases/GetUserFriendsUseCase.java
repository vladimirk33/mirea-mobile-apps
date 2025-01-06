package com.mirea.kateninva.domain.usecases;

import com.mirea.kateninva.domain.models.User;
import com.mirea.kateninva.domain.repository.UsersRepository;

public class GetUserFriendsUseCase {

    private UsersRepository usersRepository;

    public GetUserFriendsUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User[] execute() {
        return usersRepository.getUserFriends("test_username");
    }

}

package com.mirea.kateninva.domain.usecases;

import com.mirea.kateninva.domain.repository.UsersRepository;

public class AddFriendUseCase {

    private UsersRepository usersRepository;

    public AddFriendUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public boolean execute() {
        return usersRepository.addFriend("Test");
    }

}

package com.mirea.kateninva.data.repository;

import com.mirea.kateninva.data.storage.UsersStorage;
import com.mirea.kateninva.domain.models.User;
import com.mirea.kateninva.domain.repository.UsersRepository;

public class UsersRepositoryImpl implements UsersRepository {

    private UsersStorage usersStorage;

    public UsersRepositoryImpl(UsersStorage usersStorage) {
        this.usersStorage = usersStorage;
    }


    public User getUserInfo(String username) {
        return User.getTestUser();
    }

    public User[] getUserFriends(String username) {
        return new User[] { User.getTestUser() };
    }

    public boolean addFriend(String username) {
        return true;
    }

    public boolean deleteFriend(String username) {
        return true;
    }

    public User[] getAllUsers() {
        return new User[] { User.getTestUser() };
    }

    public User[] getRecommendedUsers() {
        return new User[] {User.getTestUser() };
    }

}

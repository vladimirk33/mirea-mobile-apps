package com.mirea.kateninva.domain.repository;

import com.mirea.kateninva.domain.models.User;

public interface UsersRepository {

    public User getUserInfo(String username);

    public User[] getUserFriends(String username);

    public boolean addFriend(String username);

    public boolean deleteFriend(String username);

    public User[] getAllUsers();

    public User[] getRecommendedUsers();

}

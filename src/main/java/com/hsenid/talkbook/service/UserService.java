package com.hsenid.talkbook.service;

import com.hsenid.talkbook.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    List<User> getAllUsers();

    void updateUser(User user, int userId);

    void deleteUser(int userId);
}

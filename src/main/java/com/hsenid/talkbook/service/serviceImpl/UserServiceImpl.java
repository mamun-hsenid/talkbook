package com.hsenid.talkbook.service.serviceImpl;

import com.hsenid.talkbook.repository.UserRepository;
import com.hsenid.talkbook.service.UserService;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public void createUser(String username, String email) {
        userRepository.createUser(username, email);
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

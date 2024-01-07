package com.hsenid.talkbook.service.serviceImpl;

import com.hsenid.talkbook.model.User;
import com.hsenid.talkbook.repository.UserRepository;
import com.hsenid.talkbook.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.createUser(user);
        logger.info("User created with id: [{}], username: [{}], email: [{}], password: [{}] " + user.getUserId(), user.getUsername(), user.getEmail(), user.getEmail());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public void updateUser(User user, int userId){
        userRepository.updateUser(user, userId);
    }

    @Override
    public void deleteUser(int userId){
        userRepository.deleteUser(userId);
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

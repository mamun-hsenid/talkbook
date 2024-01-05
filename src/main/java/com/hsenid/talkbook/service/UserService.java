package com.hsenid.talkbook.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public void createUser(String username, String email);
}

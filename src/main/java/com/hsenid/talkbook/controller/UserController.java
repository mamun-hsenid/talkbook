package com.hsenid.talkbook.controller;

import com.hsenid.talkbook.model.User;
import com.hsenid.talkbook.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value ="/api/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok("User created successfully");
    }

    @GetMapping(value = "/get-all-users")
    public ResponseEntity<? extends List> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PutMapping(value = "/update-user/{userId}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody User user, @PathVariable int userId) {
        user.setUserId(userId);
        userService.updateUser(user, userId);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/delete-user/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User with user_id : ["+userId+"] deleted successfully");
    }
}

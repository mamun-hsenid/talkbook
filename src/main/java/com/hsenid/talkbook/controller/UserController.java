package com.hsenid.talkbook.controller;

import com.hsenid.talkbook.model.User;
import com.hsenid.talkbook.service.UserService;
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

    @RequestMapping(value = "/add/user", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok("User created ");
    }

    @GetMapping(value = "/users")
    public ResponseEntity<? extends List> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PutMapping(value = "/user-update/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable int id) {
        userService.updateUser(user, id);
        return ResponseEntity.ok("user password updated");
    }

    @RequestMapping(value = "/user-delete/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("user deleted");
    }
}

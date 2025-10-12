package com.texstre.celebclothing.controller;

import com.texstre.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.texstre.api.UsersApi;

@RestController
public class UserController implements UsersApi {

    @Override
    public ResponseEntity<Void> createUser(User user) {
        System.out.println("Create User API called");
        return UsersApi.super.createUser(user);
    }

    @Override
    public ResponseEntity<User> getUserById() {
        System.out.println("getUserById API called");
        return UsersApi.super.getUserById();
    }
}

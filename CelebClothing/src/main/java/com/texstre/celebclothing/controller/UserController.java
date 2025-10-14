package com.texstre.celebclothing.controller;

import com.texstre.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.texstre.api.UsersApi;

@RestController
public class UserController implements UsersApi {

    @Override
    public ResponseEntity<Void> createUser(UserDTO user) {
        System.out.println("Create User API called with USER " + user.toString());

        return UsersApi.super.createUser(user);
    }

    @Override
    public ResponseEntity<UserDTO> getUserById() {
        System.out.println("getUserById API called");
        return UsersApi.super.getUserById();
    }
}

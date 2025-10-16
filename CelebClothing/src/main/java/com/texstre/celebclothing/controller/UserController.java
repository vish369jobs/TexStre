package com.texstre.celebclothing.controller;

import com.texstre.celebclothing.repository.UserDetailsRepository;
import com.texstre.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.texstre.api.UsersApi;

@RestController
public class UserController implements UsersApi {
    @Autowired
    private UserDetailsRepository userRepo;

    @Override
    public ResponseEntity<Void> createUser(UserDTO user) {
        System.out.println("Create User API called with USER " + user.toString());

        return UsersApi.super.createUser(user);
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(Integer userId) {
        System.out.println("getUserById API called");
        System.out.println("UserDetails = " + userRepo.findById(userId).toString());
        return UsersApi.super.getUserById(userId);
    }
}

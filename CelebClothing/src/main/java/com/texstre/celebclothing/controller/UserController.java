package com.texstre.celebclothing.controller;

import com.texstre.celebclothing.entity.UserDetails;
import com.texstre.celebclothing.repository.UserDetailsRepository;
import com.texstre.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.texstre.api.UsersApi;

import java.net.HttpURLConnection;
import java.util.Optional;

@RestController
public class UserController implements UsersApi {
    @Autowired
    private UserDetailsRepository userRepo;

    @Override
    public ResponseEntity<Void> createUser(UserDTO user) {
        System.out.println("Create User API called with USER " + user.toString());
        UserDetails usr = new UserDetails();
        usr.setContactNum(user.getContactNum());
        userRepo.save(usr);
        return new ResponseEntity<>(HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<UserDTO> fetchUserByPhoneNum(Integer phoneNum) {
        System.out.println("fetchUserByPhoneNum API called");
        System.out.println("UserDetails = " + userRepo.findOneByContactNum(phoneNum).toString());
        return UsersApi.super.fetchUserByPhoneNum(phoneNum);
    }

    @Override
    public ResponseEntity<Void> updateUser(UserDTO updUser) {
        System.out.println("updateUser API called");

        Optional<UserDetails> usr = userRepo.findOneByContactNum(updUser.getContactNum());
        if(usr.isPresent()) {
            usr.get().setUserName(updUser.getName());
            usr.get().setGender(updUser.getGender());
            userRepo.save(usr.get());
            return new ResponseEntity<>(HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(HttpURLConnection.HTTP_NO_CONTENT));

    }
}

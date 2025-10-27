package com.texstre.celebclothing.controller;

import com.texstre.celebclothing.service.UserService;
import com.texstre.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.texstre.api.UsersApi;

import java.net.HttpURLConnection;

@RestController
public class UserController implements UsersApi {
    @Autowired
    UserService usrService;

    @Override
    public ResponseEntity<Void> createUser(UserDTO user) {
        System.out.println("Create User API called with USER " + user.toString());
        usrService.addUser(user);
        return new ResponseEntity<>(HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<UserDTO> fetchUserByPhoneNum(Integer phoneNum) {
        System.out.println("fetchUserByPhoneNum API called");
        return new ResponseEntity<>(usrService.getUserByPhone(phoneNum), HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<Void> updateUser(UserDTO updUser) {
        System.out.println("updateUser API called");
        System.out.println(usrService.updateUser(updUser));
        return new ResponseEntity<>(HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));

//        return new ResponseEntity<>(HttpStatusCode.valueOf(HttpURLConnection.HTTP_NO_CONTENT));

    }
}

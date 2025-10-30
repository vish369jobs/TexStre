package com.texstre.celebclothing.controller;

import com.texstre.celebclothing.service.UserService;
import com.texstre.model.ApiResponseDTO;
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
        usrService.addUser(user);
        return new ResponseEntity<>(HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> fetchUserByPhoneNum(Integer phoneNum) {
        ApiResponseDTO resp = new ApiResponseDTO();
        resp.setData(usrService.getUserByPhone(phoneNum));
        resp.setHttpCode(HttpURLConnection.HTTP_OK);
        // Overwrite the http code , when there is NO DATA
        if(resp.getData() == null) {
            resp.setHttpCode(HttpURLConnection.HTTP_NO_CONTENT);
        }
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<Void> updateUser(UserDTO updUser) {
        ApiResponseDTO resp = new ApiResponseDTO();
        System.out.println(usrService.updateUser(updUser));
        //return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));

        return new ResponseEntity<>(HttpStatusCode.valueOf(HttpURLConnection.HTTP_NO_CONTENT));

    }
}

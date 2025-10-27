package com.texstre.celebclothing.service;

import com.texstre.celebclothing.entity.UserDetails;
import com.texstre.celebclothing.repository.UserDetailsRepository;
import com.texstre.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDetailsRepository userRepo;

    public void addUser(UserDTO usr) {
        UserDetails usrDetails = UserDetails.builder()
                .userName(usr.getName())
                .gender(usr.getGender())
                .contactNum(usr.getContactNum())
                .build();
        userRepo.save(usrDetails);
    }

    public String getUserByPhone(Integer phoneNum) {
        return userRepo.findOneByContactNum(phoneNum).toString();
    }

    public String updateUser(UserDTO updUsr) {
        Optional<UserDetails> usr = userRepo.findOneByContactNum(updUsr.getContactNum());
        if(usr.isPresent()) {
            usr.get().setUserName(updUsr.getName());
            usr.get().setGender(updUsr.getGender());
            userRepo.save(usr.get());
        }
        return "Success";
    }
}

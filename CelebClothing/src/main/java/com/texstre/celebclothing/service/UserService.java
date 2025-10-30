package com.texstre.celebclothing.service;

import com.texstre.celebclothing.entity.UserDetails;
import com.texstre.celebclothing.repository.UserDetailsRepository;
import com.texstre.celebclothing.util.UserMapper;
import com.texstre.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDetailsRepository userRepo;

    @Autowired
    private UserMapper userMapper;

    public void addUser(UserDTO usr) {
        UserDetails usrDetails = UserDetails.builder()
                .userName(usr.getName())
                .gender(usr.getGender())
                .contactNum(usr.getContactNum())
                .build();
        userRepo.save(usrDetails);
    }

    public void createUserByPhone(Integer phoneNum) {
        // Create a NEW User, if the provided phone number does not exist
        if(userRepo.findOneByContactNum(phoneNum).isEmpty()) {
            UserDetails usrDetails = UserDetails.builder()
                    .contactNum(phoneNum)
                    .build();
            userRepo.save(usrDetails);
        }
    }

    public UserDTO getUserByPhone(Integer phoneNum) {
        return userMapper.userDetailsToUserDTO(userRepo.findOneByContactNum(phoneNum).orElse(null));
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

package com.texstre.celebclothing.service;

import com.texstre.celebclothing.entity.UserDetails;
import com.texstre.celebclothing.repository.UserDetailsRepository;
import com.texstre.celebclothing.util.NullAwareBeanUtilsBean;
import com.texstre.celebclothing.util.UserMapper;
import com.texstre.model.UserDTO;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
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

    public void createUserByPhone(String phoneNum) {
        // Create a NEW User, if the provided phone number does not exist
        if(userRepo.findOneByContactNum(phoneNum).isEmpty()) {
            UserDetails usrDetails = UserDetails.builder()
                    .contactNum(phoneNum)
                    .build();
            userRepo.save(usrDetails);
        }
    }

    public UserDTO getUserByPhone(String phoneNum) {
        return userMapper.userDetailsToUserDTO(userRepo.findOneByContactNum(phoneNum).orElse(null));
    }

    @Transactional
    public UserDetails updateUser(UserDTO updatableUsr) {
        Optional<UserDetails> existingUsr = userRepo.findOneByContactNum(updatableUsr.getContactNum());
        if(existingUsr.isPresent()) {
            BeanUtilsBean nullAwareBeanUtils = new NullAwareBeanUtilsBean();
            try {
                UserDetails updUsrEntity = existingUsr.get();
                // Not allowing updation of User ID
                updatableUsr.setUserId(null);
                nullAwareBeanUtils.copyProperties(updUsrEntity, userMapper.userDTOToUserDetails(updatableUsr));
                return userRepo.save(updUsrEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}

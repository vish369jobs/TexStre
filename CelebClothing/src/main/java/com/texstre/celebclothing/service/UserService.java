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

    @Transactional
    public UserDetails updateUser(UserDTO updUsr) {
        Optional<UserDetails> usr = userRepo.findOneByContactNum(updUsr.getContactNum());
        if(usr.isPresent()) {
            BeanUtilsBean nullAwareBeanUtils = new NullAwareBeanUtilsBean();
            try {
                UserDetails updUsrEntity = userMapper.userDTOToUserDetails(updUsr);
                nullAwareBeanUtils.copyProperties(updUsrEntity, usr.get());
                return userRepo.save(updUsrEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}

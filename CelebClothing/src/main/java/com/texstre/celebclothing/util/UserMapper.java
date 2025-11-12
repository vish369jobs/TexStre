package com.texstre.celebclothing.util;

import com.texstre.celebclothing.entity.UserDetails;
import com.texstre.model.UserDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // "spring" for Spring integration
public interface UserMapper{

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Method for Entity to DTO conversion
    @BeanMapping(ignoreByDefault = true) // Ignore all fields by default
    @Mapping(target = "userId", source = "idUserDetails")
    @Mapping(target = "contactNum", source = "contactNum")
    @Mapping(target = "email", source = "emailId")
    @Mapping(target = "gender", source = "gender")
    @Mapping(target = "profilePicURL", source = "profilePicUrl")
    @Mapping(target = "name", source = "userName")
    @Mapping(target = "userType", source = "userType")
    UserDTO UserDetailsToUserDTO(UserDetails user);

    // Method for DTO to Entity conversion
    @BeanMapping(ignoreByDefault = true) // Ignore all fields by default
    @Mapping(target = "idUserDetails", source = "userId")
    @Mapping(target = "contactNum", source = "contactNum")
    @Mapping(target = "emailId", source = "email")
    @Mapping(target = "gender", source = "gender")
    @Mapping(target = "profilePicUrl", source = "profilePicURL")
    @Mapping(target = "userName", source = "name")
    @Mapping(target = "userType", source = "userType")
    UserDetails UserDTOToUserDetails(UserDTO userDto);
}

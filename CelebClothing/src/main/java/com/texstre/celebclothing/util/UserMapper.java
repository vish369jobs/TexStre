package com.texstre.celebclothing.util;

import com.texstre.celebclothing.entity.UserDetails;
import com.texstre.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // "spring" for Spring integration
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Method for Entity to DTO conversion
    @Mapping(target = "contactNum", source = "contactNum")
    @Mapping(target = "name", source = "userName")
    @Mapping(target = "gender", source = "gender")
    UserDTO userDetailsToUserDTO(UserDetails user);

    // Method for DTO to Entity conversion
    @Mapping(target = "contactNum", source = "contactNum")
    @Mapping(target = "userName", source = "name")
    @Mapping(target = "gender", source = "gender")
    UserDetails userDTOToUserDetails(UserDTO userDto);
}

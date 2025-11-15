package com.texstre.celebclothing.util;

import com.texstre.celebclothing.entity.DeliveryAddress;
import com.texstre.model.DeliveryAddressDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // "spring" for Spring integration
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    // Method for Entity to DTO conversion
    @BeanMapping(ignoreByDefault = true) // Ignore all fields by default
    @Mapping(target = "addressId", source = "addressId")
    @Mapping(target = "userId", source = "linkedUsrId")
    @Mapping(target = "contactName", source = "contactName")
    @Mapping(target = "contactNum", source = "contactNum")
    @Mapping(target = "addressLine1", source = "addressLine1")
    @Mapping(target = "addressLine2", source = "addressLine2")
    @Mapping(target = "city", source = "city")
    @Mapping(target = "state", source = "state")
    @Mapping(target = "pinCode", source = "pinCode")
    @Mapping(target = "country", source = "country")
    DeliveryAddressDTO deliveryAddressToDeliveryAddressDTO(DeliveryAddress delivAddr);

    // Method for DTO to Entity conversion
    @BeanMapping(ignoreByDefault = true) // Ignore all fields by default
    @Mapping(target = "addressId", source = "addressId")
    @Mapping(target = "linkedUsrId", source = "userId")
    @Mapping(target = "contactName", source = "contactName")
    @Mapping(target = "contactNum", source = "contactNum")
    @Mapping(target = "addressLine1", source = "addressLine1")
    @Mapping(target = "addressLine2", source = "addressLine2")
    @Mapping(target = "city", source = "city")
    @Mapping(target = "state", source = "state")
    @Mapping(target = "pinCode", source = "pinCode")
    @Mapping(target = "country", source = "country")
    DeliveryAddress deliveryAddressDTOToDeliveryAddress(DeliveryAddressDTO addressDto);
}

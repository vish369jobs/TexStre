package com.texstre.celebclothing.service;

import com.texstre.celebclothing.entity.DeliveryAddress;
import com.texstre.celebclothing.repository.AddressRepository;
import com.texstre.model.DeliveryAddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepo;

    public void addDeliveryAddress(DeliveryAddressDTO delAddressDTO) {
        DeliveryAddress deliveryAdd = DeliveryAddress.builder()
                .linkedUsrId(delAddressDTO.getUserId())
                .contactName(delAddressDTO.getContactName())
                .contactNum(delAddressDTO.getContactNum())
                .addressLine1(delAddressDTO.getAddressLine1())
                .addressLine2(delAddressDTO.getAddressLine2())
                .city(delAddressDTO.getCity())
                .state(delAddressDTO.getState())
                .pinCode(delAddressDTO.getPinCode())
                .country(delAddressDTO.getCountry())
                .build();
        addressRepo.save(deliveryAdd);
    }

    public List<DeliveryAddress> getAllDeliveryAddresses(String userId) {
        return addressRepo.findByLinkedUsrId(userId);
    }

    public void removeDeliveryAddress(Long addressId) {
        addressRepo.deleteById(addressId);
    }

    public DeliveryAddress getDeliveryAddressById(Long addressId) {
        return addressRepo.findById(addressId).orElse(null);
    }
}


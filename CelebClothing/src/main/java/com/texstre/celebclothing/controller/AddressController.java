package com.texstre.celebclothing.controller;

import com.texstre.api.AddressesApi;
import com.texstre.celebclothing.entity.DeliveryAddress;
import com.texstre.celebclothing.service.AddressService;
import com.texstre.model.DeliveryAddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController implements AddressesApi {
    @Autowired
    AddressService addressService;

    @Override
    public ResponseEntity<Void> createDeliveryAddress(DeliveryAddressDTO deliveryAddressDTO) {
        addressService.addDeliveryAddress(deliveryAddressDTO);
        return null;
    }

    @Override
    public ResponseEntity<List<DeliveryAddressDTO>> fetchAddressesByUserId(Integer userId) {
        List<DeliveryAddress> delAddresses = addressService.getAllDeliveryAddresses(userId.toString());
        System.out.println(delAddresses.toString());
        return null;
    }
}

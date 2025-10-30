package com.texstre.celebclothing.controller;

import com.texstre.api.AddressesApi;
import com.texstre.celebclothing.entity.DeliveryAddress;
import com.texstre.celebclothing.service.AddressService;
import com.texstre.model.ApiResponseDTO;
import com.texstre.model.DeliveryAddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
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
    public ResponseEntity<ApiResponseDTO> fetchAddressesByUserId(Integer userId) {
        ApiResponseDTO resp = new ApiResponseDTO();
        resp.setHttpCode(HttpURLConnection.HTTP_OK);
        List<DeliveryAddress> delAddresses = addressService.getAllDeliveryAddresses(userId.toString());
        if(delAddresses.isEmpty()) {
            resp.setHttpCode(HttpURLConnection.HTTP_NO_CONTENT);
        }
        resp.setData(delAddresses);

        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }
}

package com.texstre.celebclothing.controller;

import com.texstre.api.LegalApi;
import com.texstre.api.OrdersApi;
import com.texstre.celebclothing.service.AddressService;
import com.texstre.celebclothing.service.OrderService;
import com.texstre.model.ApiResponseDTO;
import com.texstre.model.OrderDetailsDTO;
import com.texstre.model.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

@RestController
public class OrderController implements OrdersApi {
    @Autowired
    OrderService orderService;

    @Override
    public ResponseEntity<ApiResponseDTO> addProductToCart(OrderItemDTO orderItemDTO) {
        return OrdersApi.super.addProductToCart(orderItemDTO);
    }

    @Override
    public ResponseEntity<ApiResponseDTO> createNewOrder(OrderDetailsDTO ordDetails) {
        ApiResponseDTO resp = new ApiResponseDTO();
        orderService.createOrder(ordDetails);
        resp.setHttpCode(HttpURLConnection.HTTP_CREATED);
        resp.setMessage("Order Created Successfully");
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }
}

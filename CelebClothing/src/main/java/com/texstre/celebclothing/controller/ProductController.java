package com.texstre.celebclothing.controller;

import com.texstre.api.ProductsApi;
import com.texstre.celebclothing.entity.ProductDetails;
import com.texstre.celebclothing.repository.ProductDetailsRepository;
import com.texstre.celebclothing.service.ProductService;
import com.texstre.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;

@RestController
public class ProductController implements ProductsApi {
   @Autowired
    ProductService prodService;

    @Override
    public ResponseEntity<Void> createProduct(ProductDTO productDTO) {
        prodService.addProduct(productDTO);
        return new ResponseEntity<>(HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }
}

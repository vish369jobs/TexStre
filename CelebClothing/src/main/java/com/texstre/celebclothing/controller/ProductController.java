package com.texstre.celebclothing.controller;

import com.texstre.api.ProductsApi;
import com.texstre.celebclothing.entity.ProductDetails;
import com.texstre.celebclothing.repository.ProductDetailsRepository;
import com.texstre.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;

@RestController
public class ProductController implements ProductsApi {
    @Autowired
    private ProductDetailsRepository productRepo;

    @Override
    public ResponseEntity<Void> createProduct(ProductDTO productDTO) {
        ProductDetails prodItem = new ProductDetails();
        prodItem.setProductName(productDTO.getProductName());
        prodItem.setFabric(productDTO.getFabric());
        prodItem.setProductPrice(productDTO.getPrice());
        productRepo.save(prodItem);
        return new ResponseEntity<>(HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }
}

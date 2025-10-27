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
        ProductDetails prodItem = ProductDetails.builder()
                .productName(productDTO.getProductName())
                .basePrice(productDTO.getBasePrice())
                .sellingPrice(productDTO.getSellPrice())
                .discountedPrice(productDTO.getDiscPrice())
                .discPercent(productDTO.getDiscPercent())
                .build();
        productRepo.save(prodItem);
        return new ResponseEntity<>(HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }
}

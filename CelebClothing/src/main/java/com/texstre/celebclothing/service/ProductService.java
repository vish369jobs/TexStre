package com.texstre.celebclothing.service;

import com.texstre.celebclothing.entity.ProductDetails;
import com.texstre.celebclothing.repository.ProductDetailsRepository;
import com.texstre.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductDetailsRepository productRepo;

    public void addProduct(ProductDTO productDTO) {
        ProductDetails prodItem = ProductDetails.builder()
                .productName(productDTO.getProductName())
                .fabric(productDTO.getFabric())
                .basePrice(productDTO.getBasePrice())
                .sellingPrice(productDTO.getSellPrice())
                .discountedPrice(productDTO.getDiscPrice())
                .discPercent(productDTO.getDiscPercent())
                .build();
        productRepo.save(prodItem);
    }

}

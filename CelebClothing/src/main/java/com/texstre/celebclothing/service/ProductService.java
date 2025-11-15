package com.texstre.celebclothing.service;

import com.texstre.celebclothing.entity.BotiqDetails;
import com.texstre.celebclothing.entity.ProductDetails;
import com.texstre.celebclothing.repository.ProductDetailsRepository;
import com.texstre.celebclothing.util.ProductDetailsMapper;
import com.texstre.model.BotiQDTO;
import com.texstre.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDetailsRepository productRepo;

    @Autowired
    private ProductDetailsMapper prodDetailsMapper;

    public void addProduct(ProductDTO productDTO) {
        ProductDetails prodItem = ProductDetails.builder()
                .productName(productDTO.getProductName())
                .productSize(productDTO.getProductSize())
                .productColour(productDTO.getProductColour())
                .fabric(productDTO.getFabric())
                .prodShortDesc(productDTO.getShortDesc())
                .prodLongDesc(productDTO.getLongDesc())
                .basePrice(productDTO.getBasePrice())
                .sellingPrice(productDTO.getSellPrice())
                .discountedPrice(productDTO.getDiscPrice())
                .discPercent(productDTO.getDiscPercent())
                .prodAvgRating(productDTO.getAvgRating())
                .build();
        productRepo.save(prodItem);
    }

    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> productsList = new ArrayList<>();
        for(ProductDetails prodDetail : productRepo.findAll()) {
            productsList.add(prodDetailsMapper.ProductDetailsToProductDTO(prodDetail));
        }
        return productsList;
    }

    public ProductDTO getProductDetailsById(Long productId) {
        return prodDetailsMapper.ProductDetailsToProductDTO(productRepo.findById(productId).orElse(null));
    }
}

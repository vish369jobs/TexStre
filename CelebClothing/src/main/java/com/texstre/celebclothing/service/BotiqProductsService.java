package com.texstre.celebclothing.service;

import com.texstre.celebclothing.entity.BotiqProducts;
import com.texstre.celebclothing.entity.ProductRatingsReviews;
import com.texstre.celebclothing.repository.BotiqProductsRepository;
import com.texstre.celebclothing.repository.RatingReviewRepository;
import com.texstre.celebclothing.util.RatingsReviewsMapper;
import com.texstre.model.BotiqProductDTO;
import com.texstre.model.RatingReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotiqProductsService {
    @Autowired
    private BotiqProductsRepository botiqProductsRepo;

    public void addProductToBoutique(BotiqProductDTO botiqProductDTO) {
        BotiqProducts prod = BotiqProducts.builder()
                .botiqId(botiqProductDTO.getBotiqId())
                .productId(botiqProductDTO.getProductId())
                .productCategory(botiqProductDTO.getProdCategory())
                .build();
        botiqProductsRepo.save(prod);
    }

    public void removeProductFromBoutique(Long botiqProdId) {
        botiqProductsRepo.deleteById(botiqProdId);
    }

    public List<BotiqProductDTO> getAllProductsFromBoutique(Long botiqId) {
        return null;
    }

}
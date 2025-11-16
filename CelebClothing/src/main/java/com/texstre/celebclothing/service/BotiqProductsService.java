package com.texstre.celebclothing.service;

import com.texstre.celebclothing.entity.BotiqProducts;
import com.texstre.celebclothing.repository.BotiqProductsRepository;
import com.texstre.celebclothing.util.BotiqProductsMapper;
import com.texstre.model.BotiqProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BotiqProductsService {
    @Autowired
    private BotiqProductsRepository botiqProductsRepo;

    @Autowired
    private BotiqProductsMapper botiqProdMapper;

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
        List<BotiqProductDTO> botiqProducts = new ArrayList<>();
        List<BotiqProducts> prodsList = botiqProductsRepo.findByBotiqId(botiqId);
        for( BotiqProducts prod : prodsList) {
            botiqProducts.add(botiqProdMapper.BotiqProductsToBotiqProductDTO(prod));
        }
        return botiqProducts;
    }

}
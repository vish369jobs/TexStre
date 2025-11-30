package com.texstre.celebclothing.controller;

import com.texstre.api.BotiqProductsApi;
import com.texstre.celebclothing.service.BotiqProductsService;
import com.texstre.model.ApiResponseDTO;
import com.texstre.model.BotiqProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;

@RestController
public class BotiqProductsController implements BotiqProductsApi {
    @Autowired
    BotiqProductsService botiqProdService;

    @Override
    public ResponseEntity<ApiResponseDTO> addProdToBotiq(BotiqProductDTO botiqProductDTO) {
        ApiResponseDTO resp = new ApiResponseDTO();
        botiqProdService.addProductToBoutique(botiqProductDTO);
        resp.setHttpCode(HttpURLConnection.HTTP_CREATED);
        resp.setMessage("Product Added to Boutique Successfully");
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> fetchAllProductsFromBotiq(Long botiqId) {
        ApiResponseDTO resp = new ApiResponseDTO();
        resp.setData(botiqProdService.getAllProductsFromBoutique(botiqId));
        resp.setHttpCode(HttpURLConnection.HTTP_OK);
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> fetchBotiqProductsByCategory(Long botiqId, String category) {
        ApiResponseDTO resp = new ApiResponseDTO();
        resp.setData(botiqProdService.getBoutiqueProductsByCat(botiqId, category));
        resp.setHttpCode(HttpURLConnection.HTTP_OK);
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> removeProductFrmBotiq(Long botiqProductId) {
        ApiResponseDTO resp = new ApiResponseDTO();
        botiqProdService.removeProductFromBoutique(botiqProductId);
        resp.setHttpCode(HttpURLConnection.HTTP_NO_CONTENT);
        resp.setMessage("Product Removed from Boutique Successfully");
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }
}
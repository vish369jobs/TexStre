package com.texstre.celebclothing.controller;

import com.texstre.api.ProductsApi;
import com.texstre.celebclothing.entity.ProductDetails;
import com.texstre.celebclothing.repository.ProductDetailsRepository;
import com.texstre.celebclothing.service.ProductService;
import com.texstre.model.ApiResponseDTO;
import com.texstre.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
import java.util.List;

@RestController
public class ProductController implements ProductsApi {
   @Autowired
    ProductService prodService;

    @Override
    public ResponseEntity<Void> createProduct(ProductDTO productDTO) {
        prodService.addProduct(productDTO);
        return new ResponseEntity<>(HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> fetchAllProducts() {
        ApiResponseDTO resp = new ApiResponseDTO();
        resp.setData(prodService.getAllProducts());
        resp.setHttpCode(HttpURLConnection.HTTP_OK);
        // Overwrite the http code , when there is NO DATA
        if(resp.getData() == null) {
            resp.setHttpCode(HttpURLConnection.HTTP_NO_CONTENT);
        }
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> fetchProductById(Long productId) {
        ApiResponseDTO resp = new ApiResponseDTO();
        resp.setData(prodService.getProductDetailsById(productId));
        resp.setHttpCode(HttpURLConnection.HTTP_OK);
        // Overwrite the http code , when there is NO DATA
        if(resp.getData() == null) {
            resp.setHttpCode(HttpURLConnection.HTTP_NO_CONTENT);
        }
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

}

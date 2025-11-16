package com.texstre.celebclothing.controller;

import com.texstre.api.RateReviewApi;
import com.texstre.celebclothing.service.RatingReviewService;
import com.texstre.model.ApiResponseDTO;
import com.texstre.model.RatingReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;

@RestController
public class RatingReviewController implements RateReviewApi {
    @Autowired
    RatingReviewService rateReviewService;

    @Override
    public ResponseEntity<ApiResponseDTO> createRating(RatingReviewDTO ratingReviewDTO) {
        ApiResponseDTO resp = new ApiResponseDTO();
        rateReviewService.addProductRating(ratingReviewDTO);
        resp.setHttpCode(HttpURLConnection.HTTP_CREATED);
        resp.setMessage("Product Rating Added Successfully");
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> createReview(RatingReviewDTO ratingReviewDTO) {
        ApiResponseDTO resp = new ApiResponseDTO();
        rateReviewService.addProductReview(ratingReviewDTO);
        resp.setHttpCode(HttpURLConnection.HTTP_CREATED);
        resp.setMessage("Product Review Added Successfully");
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> fetchRatingsReviewsByProduct(Long productId) {
        ApiResponseDTO resp = new ApiResponseDTO();
        resp.setData(rateReviewService.getProductRatingsAndReviews(productId));
        resp.setHttpCode(HttpURLConnection.HTTP_OK);
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }
}
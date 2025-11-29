package com.texstre.celebclothing.service;

import com.texstre.celebclothing.entity.ProductRatingsReviews;
import com.texstre.celebclothing.repository.RatingReviewRepository;
import com.texstre.celebclothing.util.RatingsReviewsMapper;
import com.texstre.model.RatingReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingReviewService {
    @Autowired
    private RatingReviewRepository ratingReviewRepo;

    @Autowired
    private RatingsReviewsMapper ratingsReviewsMapper;

    public void addProductRating(RatingReviewDTO productRatingReviewDTO) {
        ProductRatingsReviews prodRating = ProductRatingsReviews.builder()
                .productId(productRatingReviewDTO.getProductId())
                .productRating(productRatingReviewDTO.getRating())
                .createdBy(productRatingReviewDTO.getCreatedById())
                .build();
        ratingReviewRepo.save(prodRating);
    }

    public void addProductReview(RatingReviewDTO productRatingReviewDTO) {
        ProductRatingsReviews prodReview = ProductRatingsReviews.builder()
                .productId(productRatingReviewDTO.getProductId())
                .productReview(productRatingReviewDTO.getReview())
                .createdBy(productRatingReviewDTO.getCreatedById())
                .build();
        ratingReviewRepo.save(prodReview);
    }

    public List<RatingReviewDTO> getProductRatingsAndReviews(Long productId) {
        List<RatingReviewDTO> ratingsReviews = new ArrayList<>();
        List<ProductRatingsReviews> prodRatingsReviews = ratingReviewRepo.findByProductId(productId);
        for( ProductRatingsReviews rateReview : prodRatingsReviews) {
            ratingsReviews.add(ratingsReviewsMapper.ProductRatingsReviewsToRatingReviewDTO(rateReview));
        }
        return ratingsReviews;
    }

}
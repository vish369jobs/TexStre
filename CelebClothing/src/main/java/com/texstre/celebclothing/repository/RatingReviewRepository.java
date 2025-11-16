package com.texstre.celebclothing.repository;

import com.texstre.celebclothing.entity.BotiqProducts;
import com.texstre.celebclothing.entity.ProductRatingsReviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingReviewRepository extends JpaRepository<ProductRatingsReviews, Long> {
    List<ProductRatingsReviews> findByProductId(Long productId);
}
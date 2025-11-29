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
public class UserWishlistService {
    @Autowired
    private RatingReviewRepository ratingReviewRepo;

    @Autowired
    private RatingsReviewsMapper ratingsReviewsMapper;


}
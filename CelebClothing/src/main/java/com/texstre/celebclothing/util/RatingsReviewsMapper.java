package com.texstre.celebclothing.util;

import com.texstre.celebclothing.entity.ProductRatingsReviews;
import com.texstre.model.RatingReviewDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // "spring" for Spring integration
public interface RatingsReviewsMapper {

    RatingsReviewsMapper INSTANCE = Mappers.getMapper(RatingsReviewsMapper.class);

    // Method for Entity to DTO conversion
    @BeanMapping(ignoreByDefault = true) // Ignore all fields by default
    @Mapping(target = "ratingReviewId", source = "ratingReviewId")
    @Mapping(target = "productId", source = "productId")
    @Mapping(target = "rating", source = "productRating")
    @Mapping(target = "review", source = "productReview")
    //@Mapping(target = "createDateTime", source = "createdAt")
    @Mapping(target = "createdById", source = "createdBy")
    RatingReviewDTO ProductRatingsReviewsToRatingReviewDTO(ProductRatingsReviews prodRatingsReviews);

    // Method for DTO to Entity conversion
    @BeanMapping(ignoreByDefault = true) // Ignore all fields by default
    @Mapping(target = "ratingReviewId", source = "ratingReviewId")
    @Mapping(target = "productId", source = "productId")
    @Mapping(target = "productRating", source = "rating")
    @Mapping(target = "productReview", source = "review")
    // @Mapping(target = "createdAt", source = "createDateTime")
    @Mapping(target = "createdBy", source = "createdById")
    ProductRatingsReviews RatingReviewDTOToProductRatingsReviews(RatingReviewDTO userDto);
}
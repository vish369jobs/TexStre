package com.texstre.celebclothing.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="product_rating_reviews")
public class ProductRatingReviews {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_rating_review")
    private Long ratingReviewId;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_rating")
    private Long productRating;
    @Column(name = "product_review")
    private String productReview;
    @NotNull
    @Column(name = "is_valid", nullable=false)
    @ColumnDefault("1")
    private boolean isValid;
}


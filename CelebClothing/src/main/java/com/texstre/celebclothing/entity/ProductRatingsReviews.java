package com.texstre.celebclothing.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="product_ratings_reviews")
public class ProductRatingsReviews {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_rating_review")
    private Long ratingReviewId;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_rating")
    private Float productRating;
    @Column(name = "product_review")
    private String productReview;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private String createdAt;
    @Column(name = "created_by")
    private Long createdBy;
    @NotNull
    @Column(name = "is_valid", nullable=false)
    @ColumnDefault("1")
    private boolean isValid;
}


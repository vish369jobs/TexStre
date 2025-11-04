package com.texstre.celebclothing.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="boutique_details")
public class BoutiqueDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "botiq_id")
    private Long botiqId;
    @Column(name = "botiq_name")
    private String botiqName;
    @Column(name = "botiq_rating")
    private Float botiqRating;
    @Column(name = "botiq_followers_cnt")
    private Long botiqFollowersCnt;
    @Column(name = "botiq_products_cnt")
    private Long botiqProductsCnt;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    @NotNull
    @Column(name = "is_valid", nullable=false)
    @ColumnDefault("1")
    private boolean isValid;
}


package com.texstre.celebclothing.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="user_wishlist_products")
public class UserWishlistProducts {
    @Id
    @Column(name = "user_wishlist_id")
    private Long usrWishlistId;
    @Column(name = "product_id")
    private Long productId;
    @NotNull
    @Column(name = "is_wishlisted", nullable=false)
    @ColumnDefault("1")
    private boolean isWishlisted;
}


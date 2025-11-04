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
@Table(name="user_wishlists")
public class UserWishlists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_wishlist_id")
    private Long usrWishlistId;
    @Column(name = "linked_user_id")
    private String linkedUserId;
    @Column(name = "wishlist_name")
    private String wishListName;
    @NotNull
    @Column(name = "is_valid", nullable=false)
    @ColumnDefault("1")
    private boolean isValid;
}


package com.texstre.celebclothing.repository;

import com.texstre.celebclothing.entity.UserWishlistItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserWishlistItemsRepository extends JpaRepository<UserWishlistItems, Long> {
    List<UserWishlistItems> findAllByUsrWishlistId(Long wishlistId);
}

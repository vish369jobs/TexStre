package com.texstre.celebclothing.repository;

import com.texstre.celebclothing.entity.UserWishlistItems;
import com.texstre.celebclothing.entity.UserWishlists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWishlistItemsRepository extends JpaRepository<UserWishlistItems, Long> {

}

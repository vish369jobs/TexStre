package com.texstre.celebclothing.service;

import com.texstre.celebclothing.entity.BotiqFollowers;
import com.texstre.celebclothing.entity.ProductRatingsReviews;
import com.texstre.celebclothing.entity.UserWishlistItems;
import com.texstre.celebclothing.entity.UserWishlists;
import com.texstre.celebclothing.repository.RatingReviewRepository;
import com.texstre.celebclothing.repository.UserWishlistItemsRepository;
import com.texstre.celebclothing.repository.UserWishlistRepository;
import com.texstre.celebclothing.util.RatingsReviewsMapper;
import com.texstre.model.BotiqFollowerDTO;
import com.texstre.model.RatingReviewDTO;
import com.texstre.model.WishlistDTO;
import com.texstre.model.WishlistItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserWishlistService {
    @Autowired
    private UserWishlistRepository wishlistRepo;

    @Autowired
    private UserWishlistItemsRepository wishlistItemsRepo;

    public void addUserWishlist(WishlistDTO userWishlist) {
        UserWishlists usrWishlist = UserWishlists.builder()
                .linkedUserId(userWishlist.getUserId())
                .wishListName(userWishlist.getWishlistName())
                .isValid(Boolean.TRUE)
                .build();
        wishlistRepo.save(usrWishlist);
    }

    public void addUserWishlistItem(WishlistItemDTO userWishlistItem) {
        UserWishlistItems usrWishlistItem = UserWishlistItems.builder()
                .usrWishlistId(userWishlistItem.getWishlistId())
                .productId(userWishlistItem.getProductId())
                .isWishlisted(Boolean.TRUE)
                .build();
        wishlistItemsRepo.save(usrWishlistItem);
    }
}
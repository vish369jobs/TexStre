package com.texstre.celebclothing.controller;

import com.texstre.api.BotiqFollowersApi;
import com.texstre.api.WishlistApi;
import com.texstre.celebclothing.service.BotiqFollowersService;
import com.texstre.celebclothing.service.UserWishlistService;
import com.texstre.model.ApiResponseDTO;
import com.texstre.model.WishlistDTO;
import com.texstre.model.WishlistItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserWishlistController implements WishlistApi {
    @Autowired
    UserWishlistService userWishlistService;

    @Override
    public ResponseEntity<ApiResponseDTO> addWishlistItem(WishlistItemDTO wishlistItemDTO) {
        return WishlistApi.super.addWishlistItem(wishlistItemDTO);
    }

    @Override
    public ResponseEntity<ApiResponseDTO> createWishlist(WishlistDTO wishlistDTO) {
        return WishlistApi.super.createWishlist(wishlistDTO);
    }

    @Override
    public ResponseEntity<ApiResponseDTO> fetchWishlistItems(Long wishlistId) {
        return WishlistApi.super.fetchWishlistItems(wishlistId);
    }

    @Override
    public ResponseEntity<ApiResponseDTO> removeWishlistItem(WishlistItemDTO wishlistItemDTO) {
        return WishlistApi.super.removeWishlistItem(wishlistItemDTO);
    }
}

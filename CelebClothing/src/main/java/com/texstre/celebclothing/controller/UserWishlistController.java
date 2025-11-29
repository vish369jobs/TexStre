package com.texstre.celebclothing.controller;

import com.texstre.api.BotiqFollowersApi;
import com.texstre.api.WishlistApi;
import com.texstre.celebclothing.service.BotiqFollowersService;
import com.texstre.celebclothing.service.UserWishlistService;
import com.texstre.model.ApiResponseDTO;
import com.texstre.model.WishlistDTO;
import com.texstre.model.WishlistItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;

@RestController
public class UserWishlistController implements WishlistApi {
    @Autowired
    UserWishlistService userWishlistService;

    @Override
    public ResponseEntity<ApiResponseDTO> createWishlist(WishlistDTO userWishlist) {
        ApiResponseDTO resp = new ApiResponseDTO();
        userWishlistService.addUserWishlist(userWishlist);
        resp.setHttpCode(HttpURLConnection.HTTP_CREATED);
        resp.setMessage("User Wishlist Added Successfully");
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> addWishlistItem(WishlistItemDTO wishlistItem) {
        ApiResponseDTO resp = new ApiResponseDTO();
        userWishlistService.addUserWishlistItem(wishlistItem);
        resp.setHttpCode(HttpURLConnection.HTTP_CREATED);
        resp.setMessage("Wishlist Item Added Successfully");
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> removeWishlistItem(WishlistItemDTO wishlistItemDTO) {
        return WishlistApi.super.removeWishlistItem(wishlistItemDTO);
    }

    @Override
    public ResponseEntity<ApiResponseDTO> fetchWishlistItems(Long wishlistId) {
        return WishlistApi.super.fetchWishlistItems(wishlistId);
    }

}

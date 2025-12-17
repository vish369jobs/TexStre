package com.texstre.celebclothing.controller;

import com.texstre.api.BotiqFollowersApi;
import com.texstre.api.WishlistApi;
import com.texstre.celebclothing.entity.UserWishlists;
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
import java.util.Optional;

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
        userWishlistService.addWishlistItem(wishlistItem);
        resp.setHttpCode(HttpURLConnection.HTTP_CREATED);
        resp.setMessage("Wishlist Item Added Successfully");
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> addDefaultWishlistItem(Long userId, WishlistItemDTO wishlistItem) {
        ApiResponseDTO resp = new ApiResponseDTO();

        // Create a DEFAULT Wishlist, to which the items needs to be added - IF NOT PRESENT
        WishlistDTO defaultUsrWishlist = new WishlistDTO();
        defaultUsrWishlist.setUserId(userId);
        defaultUsrWishlist.setWishlistName("DefaultWL_" + userId);
        userWishlistService.addUserWishlist(defaultUsrWishlist);

        Optional<UserWishlists> defWishList = userWishlistService.fetchWishlistDetails(userId, "DefaultWL_" + userId);
        if(defWishList.isPresent()) {
            wishlistItem.setWishlistId(defWishList.get().getUsrWishlistId());
            userWishlistService.addWishlistItem(wishlistItem);
            resp.setHttpCode(HttpURLConnection.HTTP_CREATED);
            resp.setMessage("DEFAULT Wishlist Item Added Successfully");
        }

        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> removeWishlistItem(Long wishlistItemId) {
        ApiResponseDTO resp = new ApiResponseDTO();
        userWishlistService.removeWishlistItem(wishlistItemId);
        resp.setHttpCode(HttpURLConnection.HTTP_CREATED);
        resp.setMessage("Wishlist Item Removed Successfully");
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

    @Override
    public ResponseEntity<ApiResponseDTO> fetchWishlistItems(Long wishlistId) {
        ApiResponseDTO resp = new ApiResponseDTO();
        resp.setData(userWishlistService.getWishlistItems(wishlistId));
        resp.setHttpCode(HttpURLConnection.HTTP_CREATED);
        return new ResponseEntity<>(resp, HttpStatusCode.valueOf(HttpURLConnection.HTTP_OK));
    }

}

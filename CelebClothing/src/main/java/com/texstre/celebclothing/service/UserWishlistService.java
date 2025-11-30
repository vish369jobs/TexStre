package com.texstre.celebclothing.service;

import com.texstre.celebclothing.entity.UserWishlistItems;
import com.texstre.celebclothing.entity.UserWishlists;
import com.texstre.celebclothing.repository.UserWishlistItemsRepository;
import com.texstre.celebclothing.repository.UserWishlistRepository;
import com.texstre.celebclothing.util.UserWishlistItemsMapper;
import com.texstre.model.WishlistDTO;
import com.texstre.model.WishlistItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserWishlistService {
    @Autowired
    private UserWishlistRepository wishlistRepo;

    @Autowired
    private UserWishlistItemsRepository wishlistItemsRepo;

    @Autowired
    private UserWishlistItemsMapper wishlistItemsMapper;

    public void addUserWishlist(WishlistDTO userWishlist) {
        UserWishlists usrWishlist = UserWishlists.builder()
                .linkedUserId(userWishlist.getUserId())
                .wishListName(userWishlist.getWishlistName())
                .isValid(Boolean.TRUE)
                .build();
        wishlistRepo.save(usrWishlist);
    }

    public void addWishlistItem(WishlistItemDTO userWishlistItem) {
        UserWishlistItems usrWishlistItem = UserWishlistItems.builder()
                .usrWishlistId(userWishlistItem.getWishlistId())
                .productId(userWishlistItem.getProductId())
                .isItemWishlisted(Boolean.TRUE)
                .build();
        wishlistItemsRepo.save(usrWishlistItem);
    }

    public void removeWishlistItem(Long userWishlistItemId) {
        Optional<UserWishlistItems> usrWishlistItem = wishlistItemsRepo.findById(userWishlistItemId);
        if(usrWishlistItem.isPresent()) {
            usrWishlistItem.get().setItemWishlisted(Boolean.FALSE);
            wishlistItemsRepo.save(usrWishlistItem.get());
        }
    }

    public List<WishlistItemDTO> getWishlistItems(Long wishlistId) {
        List<UserWishlistItems> wishListItems = wishlistItemsRepo.findAllByUsrWishlistId(wishlistId);
        List<WishlistItemDTO> usrWishlistItems = new ArrayList<>();
        for(UserWishlistItems wli : wishListItems) {
            usrWishlistItems.add(wishlistItemsMapper.usrWishlistItemsToWishlistItemsDTO(wli));
        }
        return usrWishlistItems;
    }
}
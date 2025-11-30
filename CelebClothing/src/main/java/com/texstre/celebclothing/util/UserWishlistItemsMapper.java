package com.texstre.celebclothing.util;

import com.texstre.celebclothing.entity.UserWishlistItems;
import com.texstre.model.WishlistItemDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // "spring" for Spring integration
public interface UserWishlistItemsMapper {

    UserWishlistItemsMapper INSTANCE = Mappers.getMapper(UserWishlistItemsMapper.class);

    // Method for Entity to DTO conversion
    @BeanMapping(ignoreByDefault = true) // Ignore all fields by default
    @Mapping(target = "wishlistItemId", source = "usrWishlistItemId")
    @Mapping(target = "wishlistId", source = "usrWishlistId")
    @Mapping(target = "productId", source = "productId")
    //@Mapping(target = "isItemWishlisted", source = "isItemWishlisted")
    WishlistItemDTO usrWishlistItemsToWishlistItemsDTO(UserWishlistItems wlItems);

    // Method for DTO to Entity conversion
    @BeanMapping(ignoreByDefault = true) // Ignore all fields by default
    @Mapping(target = "usrWishlistItemId", source = "wishlistItemId")
    @Mapping(target = "usrWishlistId", source = "wishlistId")
    @Mapping(target = "productId", source = "productId")
    @Mapping(target = "isItemWishlisted", source = "isItemWishlisted")
    UserWishlistItems wishlistItemsDTOToUsrWishlistItems(WishlistItemDTO wlItems);
}

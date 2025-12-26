package com.texstre.celebclothing.util;

import com.texstre.celebclothing.entity.ProductDetails;
import com.texstre.model.ProductDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // "spring" for Spring integration
public interface ProductDetailsMapper {

    ProductDetailsMapper INSTANCE = Mappers.getMapper(ProductDetailsMapper.class);

    // Method for Entity to DTO conversion
    @BeanMapping(ignoreByDefault = true) // Ignore all fields by default
    @Mapping(target = "productId", source = "productId")
    @Mapping(target = "productName", source = "productName")
    @Mapping(target = "availableSizes", source = "availableSizes")
    @Mapping(target = "availableColors", source = "availableColors")
    @Mapping(target = "fabric", source = "fabric")
    @Mapping(target = "shortDesc", source = "prodShortDesc")
    @Mapping(target = "longDesc", source = "prodLongDesc")
    @Mapping(target = "basePrice", source = "basePrice")
    @Mapping(target = "sellPrice", source = "sellingPrice")
    @Mapping(target = "discPrice", source = "discountedPrice")
    @Mapping(target = "discPercent", source = "discPercent")
    @Mapping(target = "avgRating", source = "prodAvgRating")
    ProductDTO ProductDetailsToProductDTO(ProductDetails prodDet);

    // Method for DTO to Entity conversion
    @BeanMapping(ignoreByDefault = true) // Ignore all fields by default
    @Mapping(target = "productId", source = "productId")
    @Mapping(target = "productName", source = "productName")
    @Mapping(target = "availableSizes", source = "availableSizes")
    @Mapping(target = "availableColors", source = "availableColors")
    @Mapping(target = "fabric", source = "fabric")
    @Mapping(target = "prodShortDesc", source = "shortDesc")
    @Mapping(target = "prodLongDesc", source = "longDesc")
    @Mapping(target = "basePrice", source = "basePrice")
    @Mapping(target = "sellingPrice", source = "sellPrice")
    @Mapping(target = "discountedPrice", source = "discPrice")
    @Mapping(target = "discPercent", source = "discPercent")
    @Mapping(target = "prodAvgRating", source = "avgRating")
    ProductDetails ProductDTOToProductDetails(ProductDTO userDto);
}

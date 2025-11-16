package com.texstre.celebclothing.util;

import com.texstre.celebclothing.entity.BotiqDetails;
import com.texstre.celebclothing.entity.BotiqProducts;
import com.texstre.model.BotiQDTO;
import com.texstre.model.BotiqProductDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // "spring" for Spring integration
public interface BotiqProductsMapper {

    BotiqProductsMapper INSTANCE = Mappers.getMapper(BotiqProductsMapper.class);

    // Method for Entity to DTO conversion
    @BeanMapping(ignoreByDefault = true) // Ignore all fields by default
    @Mapping(target = "botiqProdId", source = "botiqProdId")
    @Mapping(target = "botiqId", source = "botiqId")
    @Mapping(target = "productId", source = "productId")
    @Mapping(target = "prodCategory", source = "productCategory")
    BotiqProductDTO BotiqProductsToBotiqProductDTO(BotiqProducts botiq);

    // Method for DTO to Entity conversion
    @BeanMapping(ignoreByDefault = true) // Ignore all fields by default
    @Mapping(target = "botiqProdId", source = "botiqProdId")
    @Mapping(target = "botiqId", source = "botiqId")
    @Mapping(target = "productId", source = "productId")
    @Mapping(target = "productCategory", source = "prodCategory")
    BotiqProducts BotiqProductDTOToBotiqProducts(BotiqProductDTO userDto);
}

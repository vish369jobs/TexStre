package com.texstre.celebclothing.util;

import com.texstre.celebclothing.entity.BotiqDetails;
import com.texstre.model.BotiQDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // "spring" for Spring integration
public interface BotiqDetailsMapper {

    BotiqDetailsMapper INSTANCE = Mappers.getMapper(BotiqDetailsMapper.class);

    // Method for Entity to DTO conversion
    @BeanMapping(ignoreByDefault = true) // Ignore all fields by default
    @Mapping(target = "botiqId", source = "botiqId")
    @Mapping(target = "botiqName", source = "botiqName")
    @Mapping(target = "botiqBannerImg", source = "botiqBannerImg")
    @Mapping(target = "botiqRating", source = "botiqRating")
    @Mapping(target = "botiqFollowersCnt", source = "botiqFollowersCnt")
    @Mapping(target = "botiqProductsCnt", source = "botiqProductsCnt")
    BotiQDTO BotiqDetailsToBotiQDTO(BotiqDetails botiq);

    // Method for DTO to Entity conversion
    @BeanMapping(ignoreByDefault = true) // Ignore all fields by default
    @Mapping(target = "botiqId", source = "botiqId")
    @Mapping(target = "botiqName", source = "botiqName")
    @Mapping(target = "botiqBannerImg", source = "botiqBannerImg")
    @Mapping(target = "botiqRating", source = "botiqRating")
    @Mapping(target = "botiqFollowersCnt", source = "botiqFollowersCnt")
    @Mapping(target = "botiqProductsCnt", source = "botiqProductsCnt")
    BotiqDetails BotiQDTOToBotiqDetails(BotiQDTO userDto);
}

package com.train.app.model.mapper;


import com.train.app.model.dto.TResultDto;
import com.train.app.model.dto.TravelResult;
import com.train.app.service.TravelService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TravelService.class)
public interface TResultMapper {
    @Mapping(source = "travelId", target = "travel")
    TravelResult toEntity(TResultDto dto);
}

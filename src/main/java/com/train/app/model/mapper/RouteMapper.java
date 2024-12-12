package com.train.app.model.mapper;


import com.train.app.model.dto.RouteDto;
import com.train.app.model.entity.Route;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RouteMapper {
    RouteDto toDto(Route route);
}

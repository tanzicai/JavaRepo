package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.BaseDto;
import com.tanzicai.caimusic.entity.BaseEntity;
import org.mapstruct.MappingTarget;

public interface MapperInterface<Entity extends BaseEntity, Dto extends BaseDto> {
    Dto toDto(Entity entity);

    Entity toEntity(Dto dto);

    Entity updateEntity(@MappingTarget Entity entity, Dto dto);
}

package com.tanzicai.caimusic.service;

import com.tanzicai.caimusic.dto.BaseDto;
import com.tanzicai.caimusic.entity.BaseEntity;
import com.tanzicai.caimusic.exception.ExceptionType;
import com.tanzicai.caimusic.mapper.MapperInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralService<Entity extends BaseEntity, Dto extends BaseDto> {
    JpaRepository<Entity, String> getRepository();

    MapperInterface<Entity, Dto> getMapper();

    ExceptionType getNotFoundExceptionType();

    Dto create(Dto dto);

    Dto get(String id);

    Dto update(String id, Dto dto);

    void delete(String id);
}

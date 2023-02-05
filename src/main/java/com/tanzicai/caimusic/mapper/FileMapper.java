package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.FileDto;
import com.tanzicai.caimusic.dto.FileUploadRequest;
import com.tanzicai.caimusic.entity.File;
import com.tanzicai.caimusic.vo.FileVo;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(FileMapperDecorator.class)
public interface FileMapper {
    File createEntity(FileUploadRequest fileUploadRequest);

    FileVo toVo(FileDto fileDto);

    FileDto toDto(File file);

    File toEntity(FileDto fileDto);
}

package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.FileUploadDto;
import com.tanzicai.caimusic.vo.FileUploadVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileUploadMapper {
    FileUploadVo toVo(FileUploadDto fileUploadDto);
}

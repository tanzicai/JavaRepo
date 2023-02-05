package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.AlbumCreateRequest;
import com.tanzicai.caimusic.dto.AlbumDto;
import com.tanzicai.caimusic.dto.AlbumUpdateRequest;
import com.tanzicai.caimusic.entity.Album;
import com.tanzicai.caimusic.vo.AlbumVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {FileMapper.class, ArtistMapper.class, MusicMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AlbumMapper extends MapperInterface<Album, AlbumDto> {

    @Mapping(source = "coverId", target = "cover.id")
    @Mapping(source = "artistIds", target = "artists")
    AlbumDto toDto(AlbumCreateRequest albumCreateRequest);

    @Mapping(source = "coverId", target = "cover.id")
    @Mapping(source = "artistIds", target = "artists")
    AlbumDto toDto(AlbumUpdateRequest albumUpdateRequest);


    AlbumVo toVo(AlbumDto albumDto);
}

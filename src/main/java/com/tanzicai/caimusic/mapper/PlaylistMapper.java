package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.PlaylistCreateRequest;
import com.tanzicai.caimusic.dto.PlaylistDto;
import com.tanzicai.caimusic.entity.Playlist;
import com.tanzicai.caimusic.vo.PlaylistVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {FileMapper.class}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PlaylistMapper extends MapperInterface<Playlist, PlaylistDto> {

    @Mapping(source = "coverId", target = "cover.id")
    PlaylistDto toDto(PlaylistCreateRequest playlistCreateRequest);

    PlaylistVo toVo(PlaylistDto playlistDto);
}

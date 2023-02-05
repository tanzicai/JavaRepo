package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.ArtistCreateRequest;
import com.tanzicai.caimusic.dto.ArtistDto;
import com.tanzicai.caimusic.dto.ArtistUpdateRequest;
import com.tanzicai.caimusic.entity.Artist;
import com.tanzicai.caimusic.vo.ArtistVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {FileMapper.class, MusicMapper.class}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ArtistMapper extends MapperInterface<Artist, ArtistDto> {

    @Mapping(source = "photoId", target = "photo.id")
    ArtistDto toDto(ArtistCreateRequest artistCreateRequest);

    ArtistDto toDto(ArtistUpdateRequest artistUpdateRequest);

    ArtistVo toVo(ArtistDto artistDto);
}

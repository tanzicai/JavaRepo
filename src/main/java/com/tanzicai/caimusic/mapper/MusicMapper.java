package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.ArtistDto;
import com.tanzicai.caimusic.dto.MusicCreateRequest;
import com.tanzicai.caimusic.dto.MusicDto;
import com.tanzicai.caimusic.dto.MusicUpdateRequest;
import com.tanzicai.caimusic.entity.Music;
import com.tanzicai.caimusic.vo.MusicVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        uses = {FileMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface MusicMapper extends MapperInterface<Music, MusicDto> {
    @Mapping(source = "fileId", target = "file.id")
    @Mapping(target = "artistList", source = "artistIds")
    MusicDto toDto(MusicCreateRequest musicCreateRequest);

    @Mapping(source = "fileId", target = "file.id")
    @Mapping(target = "artistList", source = "artistIds")
    MusicDto toDto(MusicUpdateRequest musicUpdateRequest);

    MusicVo toVo(MusicDto musicDto);


    default List<ArtistDto> mapArtistList(List<String> artistIds) {
        List<ArtistDto> artistList = new ArrayList<ArtistDto>();
        for (String id : artistIds) {
            ArtistDto artistDto = new ArtistDto();
            artistDto.setId(id);
            artistList.add(artistDto);
        }
        return artistList;
    }
}

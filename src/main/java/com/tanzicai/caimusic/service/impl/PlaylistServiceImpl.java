package com.tanzicai.caimusic.service.impl;

import com.tanzicai.caimusic.dto.PlaylistDto;
import com.tanzicai.caimusic.dto.PlaylistSearchFilter;
import com.tanzicai.caimusic.entity.Playlist;
import com.tanzicai.caimusic.exception.ExceptionType;
import com.tanzicai.caimusic.mapper.MapperInterface;
import com.tanzicai.caimusic.mapper.PlaylistMapper;
import com.tanzicai.caimusic.repository.PlaylistRepository;
import com.tanzicai.caimusic.repository.specs.PlaylistSpecification;
import com.tanzicai.caimusic.repository.specs.SearchCriteria;
import com.tanzicai.caimusic.repository.specs.SearchOperation;
import com.tanzicai.caimusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaylistServiceImpl extends TraceableGeneralServiceImpl<Playlist, PlaylistDto> implements PlaylistService {

    private PlaylistRepository repository;

    private PlaylistMapper mapper;

    @Override
    public Page<PlaylistDto> search(PlaylistSearchFilter playlistSearchFilter) {
        PlaylistSpecification specs = new PlaylistSpecification();
        specs.add(new SearchCriteria("name", playlistSearchFilter.getName(), SearchOperation.MATCH));
        if (playlistSearchFilter.getRecommended() != null) {
            specs.add(new SearchCriteria("recommended", playlistSearchFilter.getRecommended(), SearchOperation.EQUAL));
        }

        if (playlistSearchFilter.getSpecial() != null) {
            specs.add(new SearchCriteria("special", playlistSearchFilter.getSpecial(), SearchOperation.EQUAL));
        }
        
        return repository.findAll(specs, playlistSearchFilter.toPageable()).map(mapper::toDto);
    }

    @Override
    public PlaylistDto recommend(String id, Integer recommendFactor) {
        Playlist playlist = getEntity(id);
        playlist.setRecommended(true);
        playlist.setRecommendFactor(recommendFactor);
        return mapper.toDto(repository.save(playlist));
    }

    @Override
    public PlaylistDto cancelRecommendation(String id) {
        Playlist playlist = getEntity(id);
        playlist.setRecommended(false);
        playlist.setRecommendFactor(0);
        return mapper.toDto(repository.save(playlist));
    }

    @Override
    public PlaylistDto makeSpecial(String id) {
        Playlist playlist = getEntity(id);
        playlist.setSpecial(true);
        return mapper.toDto(repository.save(playlist));
    }

    @Override
    public PlaylistDto cancelSpecial(String id) {
        Playlist playlist = getEntity(id);
        playlist.setSpecial(false);
        return mapper.toDto(repository.save(playlist));
    }

    @Override
    public JpaRepository<Playlist, String> getRepository() {
        return repository;
    }

    @Override
    public MapperInterface<Playlist, PlaylistDto> getMapper() {
        return mapper;
    }

    @Override
    public ExceptionType getNotFoundExceptionType() {
        return ExceptionType.PLAYLIST_NOT_FOUND;
    }

    @Autowired
    public void setRepository(PlaylistRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(PlaylistMapper mapper) {
        this.mapper = mapper;
    }
}

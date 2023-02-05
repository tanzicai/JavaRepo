package com.tanzicai.caimusic.service.impl;

import com.tanzicai.caimusic.dto.ArtistDto;
import com.tanzicai.caimusic.dto.ArtistSearchFilter;
import com.tanzicai.caimusic.entity.Artist;
import com.tanzicai.caimusic.exception.ExceptionType;
import com.tanzicai.caimusic.mapper.ArtistMapper;
import com.tanzicai.caimusic.mapper.MapperInterface;
import com.tanzicai.caimusic.repository.ArtistRepository;
import com.tanzicai.caimusic.repository.specs.ArtistSpecification;
import com.tanzicai.caimusic.repository.specs.SearchCriteria;
import com.tanzicai.caimusic.repository.specs.SearchOperation;
import com.tanzicai.caimusic.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArtistServiceImpl extends TraceableGeneralServiceImpl<Artist, ArtistDto> implements ArtistService {

    private ArtistMapper mapper;

    private ArtistRepository repository;

    @Override
    public List<ArtistDto> list() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<ArtistDto> search(ArtistSearchFilter artistSearchFilter) {
        ArtistSpecification specs = new ArtistSpecification();
        specs.add(new SearchCriteria("name", artistSearchFilter.getName(), SearchOperation.MATCH));
        if (artistSearchFilter.getRecommended() != null) {
            specs.add(new SearchCriteria("recommended", artistSearchFilter.getRecommended(), SearchOperation.EQUAL));
        }
        return repository.findAll(specs, artistSearchFilter.toPageable()).map(mapper::toDto);
    }

    @Override
    public ArtistDto recommend(String id, Integer recommendFactor) {
        Artist artist = getEntity(id);
        artist.setRecommended(true);
        artist.setRecommendFactor(recommendFactor);
        return mapper.toDto(repository.save(artist));
    }

    @Override
    public ArtistDto cancelRecommendation(String id) {
        Artist artist = getEntity(id);
        artist.setRecommended(false);
        artist.setRecommendFactor(0);
        return mapper.toDto(repository.save(artist));
    }

    @Autowired
    public void setRepository(ArtistRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(ArtistMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public JpaRepository<Artist, String> getRepository() {
        return repository;
    }

    @Override
    public MapperInterface<Artist, ArtistDto> getMapper() {
        return mapper;
    }

    @Override
    public ExceptionType getNotFoundExceptionType() {
        return ExceptionType.ARTIST_NOT_FOUND;
    }
}

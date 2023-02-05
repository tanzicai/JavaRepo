package com.tanzicai.caimusic.service;


import com.tanzicai.caimusic.dto.ArtistDto;
import com.tanzicai.caimusic.dto.ArtistSearchFilter;
import com.tanzicai.caimusic.entity.Artist;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ArtistService extends GeneralService<Artist, ArtistDto> {
    List<ArtistDto> list();

    Page<ArtistDto> search(ArtistSearchFilter artistSearchFilter);

    ArtistDto recommend(String id, Integer recommendFactor);

    ArtistDto cancelRecommendation(String id);
}

package com.tanzicai.caimusic.service;

import com.tanzicai.caimusic.dto.AlbumDto;
import com.tanzicai.caimusic.dto.AlbumSearchFilter;
import com.tanzicai.caimusic.entity.Album;
import org.springframework.data.domain.Page;

public interface AlbumService extends GeneralService<Album, AlbumDto> {
    Page<AlbumDto> search(AlbumSearchFilter albumSearchFilter);

    AlbumDto recommend(String id, Integer recommendFactor);

    AlbumDto cancelRecommendation(String id);
}

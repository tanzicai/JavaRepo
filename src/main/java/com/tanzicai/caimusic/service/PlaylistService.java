package com.tanzicai.caimusic.service;

import com.tanzicai.caimusic.dto.PlaylistDto;
import com.tanzicai.caimusic.dto.PlaylistSearchFilter;
import com.tanzicai.caimusic.entity.Playlist;
import org.springframework.data.domain.Page;

public interface PlaylistService extends GeneralService<Playlist, PlaylistDto> {
    Page<PlaylistDto> search(PlaylistSearchFilter playlistSearchFilter);

    PlaylistDto recommend(String id, Integer recommendFactor);

    PlaylistDto cancelRecommendation(String id);

    PlaylistDto makeSpecial(String id);

    PlaylistDto cancelSpecial(String id);
}

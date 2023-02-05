package com.tanzicai.caimusic.service;

import com.tanzicai.caimusic.dto.MusicDto;
import com.tanzicai.caimusic.dto.MusicSearchFilter;
import com.tanzicai.caimusic.entity.Music;
import org.springframework.data.domain.Page;

public interface MusicService extends GeneralService<Music, MusicDto> {

    Page<MusicDto> search(MusicSearchFilter musicSearchRequest);

    void publish(String id);

    void close(String id);
}

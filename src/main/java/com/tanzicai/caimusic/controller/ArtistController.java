package com.tanzicai.caimusic.controller;

import com.tanzicai.caimusic.dto.ArtistCreateRequest;
import com.tanzicai.caimusic.dto.ArtistSearchFilter;
import com.tanzicai.caimusic.dto.ArtistUpdateRequest;
import com.tanzicai.caimusic.dto.RecommendRequest;
import com.tanzicai.caimusic.mapper.ArtistMapper;
import com.tanzicai.caimusic.service.ArtistService;
import com.tanzicai.caimusic.vo.ArtistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    ArtistService artistService;

    ArtistMapper artistMapper;

    @PostMapping
    public ArtistVo create(@Validated @RequestBody ArtistCreateRequest artistCreateRequest) {
        return artistMapper.toVo(artistService.create(artistMapper.toDto(artistCreateRequest)));
    }

    @PostMapping("/{id}")
    public ArtistVo update(@PathVariable String id, @Validated @RequestBody ArtistUpdateRequest artistUpdateRequest) {
        return artistMapper.toVo(artistService.update(id, artistMapper.toDto(artistUpdateRequest)));
    }

    @GetMapping
    public Page<ArtistVo> search(@Validated ArtistSearchFilter artistSearchFilter) {
        return artistService.search(artistSearchFilter).map(artistMapper::toVo);
    }

    @PostMapping("/{id}/recommend")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ArtistVo recommend(@PathVariable String id, @Validated @RequestBody RecommendRequest recommendRequest) {
        return artistMapper.toVo(artistService.recommend(id, recommendRequest.getRecommendFactor()));
    }

    @PostMapping("/{id}/cancel_recommendation")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ArtistVo cancelRecommendation(@PathVariable String id) {
        return artistMapper.toVo(artistService.cancelRecommendation(id));
    }


    @Autowired
    public void setArtistService(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Autowired
    public void setArtistMapper(ArtistMapper artistMapper) {
        this.artistMapper = artistMapper;
    }
}

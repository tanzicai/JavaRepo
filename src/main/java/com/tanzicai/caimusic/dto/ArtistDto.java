package com.tanzicai.caimusic.dto;

import com.tanzicai.caimusic.enums.GeneralStatus;
import lombok.Data;

import java.util.List;

@Data
public class ArtistDto extends TraceableBaseDto {
    private String name;

    private String remark;

    private FileDto photo;

    private List<MusicDto> musicDtoList;

    private GeneralStatus status;

    private Boolean recommended;

    private Integer recommendFactor;
}

package com.tanzicai.caimusic.vo;

import com.tanzicai.caimusic.enums.PlayListStatus;
import lombok.Data;

import java.util.List;

@Data
public class PlaylistVo extends BaseVo {

    private String name;

    private String description;

    private FileVo cover;

    private PlayListStatus status;

    private List<MusicVo> musicList;

    private Boolean recommended;

    private Integer recommendFactor;

    private Boolean special;
}

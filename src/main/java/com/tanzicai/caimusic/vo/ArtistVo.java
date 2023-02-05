package com.tanzicai.caimusic.vo;

import com.tanzicai.caimusic.enums.GeneralStatus;
import lombok.Data;

import java.util.List;

@Data
public class ArtistVo extends BaseVo {
    private String name;

    private String remark;

    private FileVo photo;

    private List<MusicVo> musicDtoList;

    private GeneralStatus status;

    private Boolean recommended;

    private Integer recommendFactor;
}

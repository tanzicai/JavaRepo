package com.tanzicai.caimusic.dto;

import lombok.Data;

@Data
public class ArtistSearchFilter extends BaseSearchFilter {
    private String name = "";

    private Boolean recommended;
}

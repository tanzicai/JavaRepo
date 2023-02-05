package com.tanzicai.caimusic.dto;

import com.tanzicai.caimusic.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingDto {
    private String bucket;

    private String region;

    private Storage storage;
}

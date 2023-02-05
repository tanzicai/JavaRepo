package com.tanzicai.caimusic.vo;

import com.tanzicai.caimusic.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingVo {
    private String bucket;

    private String region;

    private Storage storage;
}

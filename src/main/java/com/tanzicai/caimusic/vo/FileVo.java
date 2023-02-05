package com.tanzicai.caimusic.vo;

import com.tanzicai.caimusic.enums.FileStatus;
import com.tanzicai.caimusic.enums.FileType;
import com.tanzicai.caimusic.enums.Storage;
import lombok.Data;

@Data
public class FileVo extends BaseVo {
    private String name;

    private String key;

    private String uri;

    private Storage storage;

    private String ext;

    private Long size;

    private FileType type;

    private FileStatus status;
}

package com.tanzicai.caimusic.service;

import com.tanzicai.caimusic.dto.FileDto;
import com.tanzicai.caimusic.dto.FileUploadDto;
import com.tanzicai.caimusic.dto.FileUploadRequest;
import com.tanzicai.caimusic.entity.File;
import com.tanzicai.caimusic.enums.Storage;

import java.io.IOException;

public interface FileService {
    FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException;

    FileDto finishUpload(String id);

    Storage getDefaultStorage();

    File getFileEntity(String id);
}

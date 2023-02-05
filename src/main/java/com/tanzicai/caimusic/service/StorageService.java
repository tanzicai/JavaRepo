package com.tanzicai.caimusic.service;

import com.tanzicai.caimusic.dto.FileUploadDto;

import java.io.IOException;

public interface StorageService {
    FileUploadDto initFileUpload() throws IOException;

    String getFileUri(String fileKey);
}

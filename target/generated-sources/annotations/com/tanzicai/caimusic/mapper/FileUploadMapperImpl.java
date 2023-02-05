package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.FileUploadDto;
import com.tanzicai.caimusic.vo.FileUploadVo;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-17T23:58:07+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (International Business Machines Corporation)"
)
@Component
public class FileUploadMapperImpl implements FileUploadMapper {

    @Override
    public FileUploadVo toVo(FileUploadDto fileUploadDto) {
        if ( fileUploadDto == null ) {
            return null;
        }

        FileUploadVo fileUploadVo = new FileUploadVo();

        fileUploadVo.setSecretId( fileUploadDto.getSecretId() );
        fileUploadVo.setSecretKey( fileUploadDto.getSecretKey() );
        fileUploadVo.setSessionToken( fileUploadDto.getSessionToken() );
        fileUploadVo.setKey( fileUploadDto.getKey() );
        fileUploadVo.setFileId( fileUploadDto.getFileId() );
        fileUploadVo.setStartTime( fileUploadDto.getStartTime() );
        fileUploadVo.setExpiredTime( fileUploadDto.getExpiredTime() );

        return fileUploadVo;
    }
}

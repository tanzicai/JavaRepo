package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.FileDto;
import com.tanzicai.caimusic.dto.FileUploadRequest;
import com.tanzicai.caimusic.entity.File;
import com.tanzicai.caimusic.vo.FileVo;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-17T23:58:08+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (International Business Machines Corporation)"
)
@Component
@Qualifier("delegate")
public class FileMapperImpl_ implements FileMapper {

    @Override
    public File createEntity(FileUploadRequest fileUploadRequest) {
        if ( fileUploadRequest == null ) {
            return null;
        }

        File file = new File();

        file.setName( fileUploadRequest.getName() );
        file.setKey( fileUploadRequest.getKey() );
        file.setExt( fileUploadRequest.getExt() );
        if ( fileUploadRequest.getSize() != null ) {
            file.setSize( fileUploadRequest.getSize().intValue() );
        }

        return file;
    }

    @Override
    public FileVo toVo(FileDto fileDto) {
        if ( fileDto == null ) {
            return null;
        }

        FileVo fileVo = new FileVo();

        fileVo.setId( fileDto.getId() );
        fileVo.setCreatedTime( fileDto.getCreatedTime() );
        fileVo.setUpdatedTime( fileDto.getUpdatedTime() );
        fileVo.setName( fileDto.getName() );
        fileVo.setKey( fileDto.getKey() );
        fileVo.setUri( fileDto.getUri() );
        fileVo.setStorage( fileDto.getStorage() );
        fileVo.setExt( fileDto.getExt() );
        fileVo.setSize( fileDto.getSize() );
        fileVo.setType( fileDto.getType() );
        fileVo.setStatus( fileDto.getStatus() );

        return fileVo;
    }

    @Override
    public FileDto toDto(File file) {
        if ( file == null ) {
            return null;
        }

        FileDto fileDto = new FileDto();

        fileDto.setId( file.getId() );
        fileDto.setName( file.getName() );
        fileDto.setKey( file.getKey() );
        fileDto.setExt( file.getExt() );
        if ( file.getSize() != null ) {
            fileDto.setSize( file.getSize().longValue() );
        }
        fileDto.setType( file.getType() );
        fileDto.setStorage( file.getStorage() );
        fileDto.setStatus( file.getStatus() );
        fileDto.setCreatedTime( file.getCreatedTime() );
        fileDto.setUpdatedTime( file.getUpdatedTime() );

        return fileDto;
    }

    @Override
    public File toEntity(FileDto fileDto) {
        if ( fileDto == null ) {
            return null;
        }

        File file = new File();

        file.setId( fileDto.getId() );
        file.setCreatedTime( fileDto.getCreatedTime() );
        file.setUpdatedTime( fileDto.getUpdatedTime() );
        file.setName( fileDto.getName() );
        file.setKey( fileDto.getKey() );
        file.setExt( fileDto.getExt() );
        if ( fileDto.getSize() != null ) {
            file.setSize( fileDto.getSize().intValue() );
        }
        file.setType( fileDto.getType() );
        file.setStorage( fileDto.getStorage() );
        file.setStatus( fileDto.getStatus() );

        return file;
    }
}

package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.FileDto;
import com.tanzicai.caimusic.dto.FileUploadRequest;
import com.tanzicai.caimusic.entity.File;
import com.tanzicai.caimusic.vo.FileVo;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-17T23:58:08+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (International Business Machines Corporation)"
)
@Component
@Primary
public class FileMapperImpl extends FileMapperDecorator implements FileMapper {

    @Autowired
    @Qualifier("delegate")
    private FileMapper delegate;

    @Override
    public File createEntity(FileUploadRequest fileUploadRequest)  {
        return delegate.createEntity( fileUploadRequest );
    }

    @Override
    public FileVo toVo(FileDto fileDto)  {
        return delegate.toVo( fileDto );
    }

    @Override
    public File toEntity(FileDto fileDto)  {
        return delegate.toEntity( fileDto );
    }
}

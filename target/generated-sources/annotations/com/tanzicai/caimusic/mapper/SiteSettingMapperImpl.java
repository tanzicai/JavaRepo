package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.SiteSettingDto;
import com.tanzicai.caimusic.vo.SiteSettingVo;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-17T23:58:08+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (International Business Machines Corporation)"
)
@Component
public class SiteSettingMapperImpl implements SiteSettingMapper {

    @Override
    public SiteSettingVo toVo(SiteSettingDto siteSettingDto) {
        if ( siteSettingDto == null ) {
            return null;
        }

        SiteSettingVo siteSettingVo = new SiteSettingVo();

        siteSettingVo.setBucket( siteSettingDto.getBucket() );
        siteSettingVo.setRegion( siteSettingDto.getRegion() );
        siteSettingVo.setStorage( siteSettingDto.getStorage() );

        return siteSettingVo;
    }
}

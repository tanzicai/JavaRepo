package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.SiteSettingDto;
import com.tanzicai.caimusic.vo.SiteSettingVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SiteSettingMapper {
    SiteSettingVo toVo(SiteSettingDto siteSettingDto);
}

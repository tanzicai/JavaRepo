package com.tanzicai.caimusic.dto;

import lombok.Data;

@Data
public class TraceableBaseDto extends BaseDto {
    private UserDto createdBy;

    private UserDto updatedBy;
}

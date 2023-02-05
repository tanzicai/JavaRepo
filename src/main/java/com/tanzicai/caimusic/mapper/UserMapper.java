package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.UserCreateRequest;
import com.tanzicai.caimusic.dto.UserDto;
import com.tanzicai.caimusic.dto.UserUpdateRequest;
import com.tanzicai.caimusic.entity.User;
import com.tanzicai.caimusic.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserDto toDto(User user);

  UserVo toVo(UserDto userDto);

  User createEntity(UserCreateRequest userCreateRequest);

  User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}

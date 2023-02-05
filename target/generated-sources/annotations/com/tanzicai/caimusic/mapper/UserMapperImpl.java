package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.RoleDto;
import com.tanzicai.caimusic.dto.UserCreateRequest;
import com.tanzicai.caimusic.dto.UserDto;
import com.tanzicai.caimusic.dto.UserUpdateRequest;
import com.tanzicai.caimusic.entity.Role;
import com.tanzicai.caimusic.entity.User;
import com.tanzicai.caimusic.enums.Gender;
import com.tanzicai.caimusic.vo.RoleVo;
import com.tanzicai.caimusic.vo.UserVo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-17T23:58:07+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (International Business Machines Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUsername( user.getUsername() );
        userDto.setNickname( user.getNickname() );
        userDto.setRoles( roleListToRoleDtoList( user.getRoles() ) );
        userDto.setGender( user.getGender() );
        userDto.setLocked( user.getLocked() );
        userDto.setEnabled( user.getEnabled() );
        userDto.setLastLoginIp( user.getLastLoginIp() );
        userDto.setLastLoginTime( user.getLastLoginTime() );

        return userDto;
    }

    @Override
    public UserVo toVo(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserVo userVo = new UserVo();

        userVo.setId( userDto.getId() );
        userVo.setUsername( userDto.getUsername() );
        userVo.setNickname( userDto.getNickname() );
        userVo.setGender( userDto.getGender() );
        userVo.setLocked( userDto.getLocked() );
        userVo.setEnabled( userDto.getEnabled() );
        userVo.setRoles( roleDtoListToRoleVoList( userDto.getRoles() ) );

        return userVo;
    }

    @Override
    public User createEntity(UserCreateRequest userCreateRequest) {
        if ( userCreateRequest == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userCreateRequest.getUsername() );
        user.setNickname( userCreateRequest.getNickname() );
        user.setPassword( userCreateRequest.getPassword() );
        user.setGender( userCreateRequest.getGender() );

        return user;
    }

    @Override
    public User updateEntity(User user, UserUpdateRequest userUpdateRequest) {
        if ( userUpdateRequest == null ) {
            return null;
        }

        user.setUsername( userUpdateRequest.getUsername() );
        user.setNickname( userUpdateRequest.getNickname() );
        if ( userUpdateRequest.getGender() != null ) {
            user.setGender( Enum.valueOf( Gender.class, userUpdateRequest.getGender() ) );
        }
        else {
            user.setGender( null );
        }

        return user;
    }

    protected RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        roleDto.setName( role.getName() );
        roleDto.setTitle( role.getTitle() );

        return roleDto;
    }

    protected List<RoleDto> roleListToRoleDtoList(List<Role> list) {
        if ( list == null ) {
            return null;
        }

        List<RoleDto> list1 = new ArrayList<RoleDto>( list.size() );
        for ( Role role : list ) {
            list1.add( roleToRoleDto( role ) );
        }

        return list1;
    }

    protected RoleVo roleDtoToRoleVo(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        RoleVo roleVo = new RoleVo();

        roleVo.setId( roleDto.getId() );
        roleVo.setName( roleDto.getName() );
        roleVo.setTitle( roleDto.getTitle() );

        return roleVo;
    }

    protected List<RoleVo> roleDtoListToRoleVoList(List<RoleDto> list) {
        if ( list == null ) {
            return null;
        }

        List<RoleVo> list1 = new ArrayList<RoleVo>( list.size() );
        for ( RoleDto roleDto : list ) {
            list1.add( roleDtoToRoleVo( roleDto ) );
        }

        return list1;
    }
}

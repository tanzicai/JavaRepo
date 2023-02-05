package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.ArtistCreateRequest;
import com.tanzicai.caimusic.dto.ArtistDto;
import com.tanzicai.caimusic.dto.ArtistUpdateRequest;
import com.tanzicai.caimusic.dto.FileDto;
import com.tanzicai.caimusic.dto.MusicDto;
import com.tanzicai.caimusic.dto.RoleDto;
import com.tanzicai.caimusic.dto.UserDto;
import com.tanzicai.caimusic.entity.Artist;
import com.tanzicai.caimusic.entity.Role;
import com.tanzicai.caimusic.entity.User;
import com.tanzicai.caimusic.vo.ArtistVo;
import com.tanzicai.caimusic.vo.MusicVo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-17T23:58:07+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (International Business Machines Corporation)"
)
@Component
public class ArtistMapperImpl implements ArtistMapper {

    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private MusicMapper musicMapper;

    @Override
    public ArtistDto toDto(Artist entity) {
        if ( entity == null ) {
            return null;
        }

        ArtistDto artistDto = new ArtistDto();

        if ( entity.getId() != null ) {
            artistDto.setId( entity.getId() );
        }
        if ( entity.getCreatedTime() != null ) {
            artistDto.setCreatedTime( entity.getCreatedTime() );
        }
        if ( entity.getUpdatedTime() != null ) {
            artistDto.setUpdatedTime( entity.getUpdatedTime() );
        }
        if ( entity.getCreatedBy() != null ) {
            artistDto.setCreatedBy( userToUserDto( entity.getCreatedBy() ) );
        }
        if ( entity.getUpdatedBy() != null ) {
            artistDto.setUpdatedBy( userToUserDto( entity.getUpdatedBy() ) );
        }
        if ( entity.getName() != null ) {
            artistDto.setName( entity.getName() );
        }
        if ( entity.getRemark() != null ) {
            artistDto.setRemark( entity.getRemark() );
        }
        if ( entity.getPhoto() != null ) {
            artistDto.setPhoto( fileMapper.toDto( entity.getPhoto() ) );
        }
        if ( entity.getStatus() != null ) {
            artistDto.setStatus( entity.getStatus() );
        }
        if ( entity.getRecommended() != null ) {
            artistDto.setRecommended( entity.getRecommended() );
        }
        if ( entity.getRecommendFactor() != null ) {
            artistDto.setRecommendFactor( entity.getRecommendFactor() );
        }

        return artistDto;
    }

    @Override
    public Artist toEntity(ArtistDto dto) {
        if ( dto == null ) {
            return null;
        }

        Artist artist = new Artist();

        if ( dto.getId() != null ) {
            artist.setId( dto.getId() );
        }
        if ( dto.getCreatedTime() != null ) {
            artist.setCreatedTime( dto.getCreatedTime() );
        }
        if ( dto.getUpdatedTime() != null ) {
            artist.setUpdatedTime( dto.getUpdatedTime() );
        }
        if ( dto.getCreatedBy() != null ) {
            artist.setCreatedBy( userDtoToUser( dto.getCreatedBy() ) );
        }
        if ( dto.getUpdatedBy() != null ) {
            artist.setUpdatedBy( userDtoToUser( dto.getUpdatedBy() ) );
        }
        if ( dto.getName() != null ) {
            artist.setName( dto.getName() );
        }
        if ( dto.getRemark() != null ) {
            artist.setRemark( dto.getRemark() );
        }
        if ( dto.getPhoto() != null ) {
            artist.setPhoto( fileMapper.toEntity( dto.getPhoto() ) );
        }
        if ( dto.getStatus() != null ) {
            artist.setStatus( dto.getStatus() );
        }
        if ( dto.getRecommended() != null ) {
            artist.setRecommended( dto.getRecommended() );
        }
        if ( dto.getRecommendFactor() != null ) {
            artist.setRecommendFactor( dto.getRecommendFactor() );
        }

        return artist;
    }

    @Override
    public Artist updateEntity(Artist entity, ArtistDto dto) {
        if ( dto == null ) {
            return null;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getCreatedTime() != null ) {
            entity.setCreatedTime( dto.getCreatedTime() );
        }
        if ( dto.getUpdatedTime() != null ) {
            entity.setUpdatedTime( dto.getUpdatedTime() );
        }
        if ( dto.getCreatedBy() != null ) {
            if ( entity.getCreatedBy() == null ) {
                entity.setCreatedBy( new User() );
            }
            userDtoToUser1( dto.getCreatedBy(), entity.getCreatedBy() );
        }
        if ( dto.getUpdatedBy() != null ) {
            if ( entity.getUpdatedBy() == null ) {
                entity.setUpdatedBy( new User() );
            }
            userDtoToUser1( dto.getUpdatedBy(), entity.getUpdatedBy() );
        }
        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getRemark() != null ) {
            entity.setRemark( dto.getRemark() );
        }
        if ( dto.getPhoto() != null ) {
            entity.setPhoto( fileMapper.toEntity( dto.getPhoto() ) );
        }
        if ( dto.getStatus() != null ) {
            entity.setStatus( dto.getStatus() );
        }
        if ( dto.getRecommended() != null ) {
            entity.setRecommended( dto.getRecommended() );
        }
        if ( dto.getRecommendFactor() != null ) {
            entity.setRecommendFactor( dto.getRecommendFactor() );
        }

        return entity;
    }

    @Override
    public ArtistDto toDto(ArtistCreateRequest artistCreateRequest) {
        if ( artistCreateRequest == null ) {
            return null;
        }

        ArtistDto artistDto = new ArtistDto();

        artistDto.setPhoto( artistCreateRequestToFileDto( artistCreateRequest ) );
        if ( artistCreateRequest.getName() != null ) {
            artistDto.setName( artistCreateRequest.getName() );
        }
        if ( artistCreateRequest.getRemark() != null ) {
            artistDto.setRemark( artistCreateRequest.getRemark() );
        }

        return artistDto;
    }

    @Override
    public ArtistDto toDto(ArtistUpdateRequest artistUpdateRequest) {
        if ( artistUpdateRequest == null ) {
            return null;
        }

        ArtistDto artistDto = new ArtistDto();

        if ( artistUpdateRequest.getName() != null ) {
            artistDto.setName( artistUpdateRequest.getName() );
        }
        if ( artistUpdateRequest.getRemark() != null ) {
            artistDto.setRemark( artistUpdateRequest.getRemark() );
        }

        return artistDto;
    }

    @Override
    public ArtistVo toVo(ArtistDto artistDto) {
        if ( artistDto == null ) {
            return null;
        }

        ArtistVo artistVo = new ArtistVo();

        if ( artistDto.getId() != null ) {
            artistVo.setId( artistDto.getId() );
        }
        if ( artistDto.getCreatedTime() != null ) {
            artistVo.setCreatedTime( artistDto.getCreatedTime() );
        }
        if ( artistDto.getUpdatedTime() != null ) {
            artistVo.setUpdatedTime( artistDto.getUpdatedTime() );
        }
        if ( artistDto.getName() != null ) {
            artistVo.setName( artistDto.getName() );
        }
        if ( artistDto.getRemark() != null ) {
            artistVo.setRemark( artistDto.getRemark() );
        }
        if ( artistDto.getPhoto() != null ) {
            artistVo.setPhoto( fileMapper.toVo( artistDto.getPhoto() ) );
        }
        List<MusicVo> list = musicDtoListToMusicVoList( artistDto.getMusicDtoList() );
        if ( list != null ) {
            artistVo.setMusicDtoList( list );
        }
        if ( artistDto.getStatus() != null ) {
            artistVo.setStatus( artistDto.getStatus() );
        }
        if ( artistDto.getRecommended() != null ) {
            artistVo.setRecommended( artistDto.getRecommended() );
        }
        if ( artistDto.getRecommendFactor() != null ) {
            artistVo.setRecommendFactor( artistDto.getRecommendFactor() );
        }

        return artistVo;
    }

    protected RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        if ( role.getId() != null ) {
            roleDto.setId( role.getId() );
        }
        if ( role.getName() != null ) {
            roleDto.setName( role.getName() );
        }
        if ( role.getTitle() != null ) {
            roleDto.setTitle( role.getTitle() );
        }

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

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        if ( user.getId() != null ) {
            userDto.setId( user.getId() );
        }
        if ( user.getUsername() != null ) {
            userDto.setUsername( user.getUsername() );
        }
        if ( user.getNickname() != null ) {
            userDto.setNickname( user.getNickname() );
        }
        List<RoleDto> list = roleListToRoleDtoList( user.getRoles() );
        if ( list != null ) {
            userDto.setRoles( list );
        }
        if ( user.getGender() != null ) {
            userDto.setGender( user.getGender() );
        }
        if ( user.getLocked() != null ) {
            userDto.setLocked( user.getLocked() );
        }
        if ( user.getEnabled() != null ) {
            userDto.setEnabled( user.getEnabled() );
        }
        if ( user.getLastLoginIp() != null ) {
            userDto.setLastLoginIp( user.getLastLoginIp() );
        }
        if ( user.getLastLoginTime() != null ) {
            userDto.setLastLoginTime( user.getLastLoginTime() );
        }

        return userDto;
    }

    protected Role roleDtoToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        if ( roleDto.getId() != null ) {
            role.setId( roleDto.getId() );
        }
        if ( roleDto.getName() != null ) {
            role.setName( roleDto.getName() );
        }
        if ( roleDto.getTitle() != null ) {
            role.setTitle( roleDto.getTitle() );
        }

        return role;
    }

    protected List<Role> roleDtoListToRoleList(List<RoleDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Role> list1 = new ArrayList<Role>( list.size() );
        for ( RoleDto roleDto : list ) {
            list1.add( roleDtoToRole( roleDto ) );
        }

        return list1;
    }

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        if ( userDto.getId() != null ) {
            user.setId( userDto.getId() );
        }
        if ( userDto.getUsername() != null ) {
            user.setUsername( userDto.getUsername() );
        }
        if ( userDto.getNickname() != null ) {
            user.setNickname( userDto.getNickname() );
        }
        List<Role> list = roleDtoListToRoleList( userDto.getRoles() );
        if ( list != null ) {
            user.setRoles( list );
        }
        if ( userDto.getGender() != null ) {
            user.setGender( userDto.getGender() );
        }
        if ( userDto.getLocked() != null ) {
            user.setLocked( userDto.getLocked() );
        }
        if ( userDto.getEnabled() != null ) {
            user.setEnabled( userDto.getEnabled() );
        }
        if ( userDto.getLastLoginIp() != null ) {
            user.setLastLoginIp( userDto.getLastLoginIp() );
        }
        if ( userDto.getLastLoginTime() != null ) {
            user.setLastLoginTime( userDto.getLastLoginTime() );
        }

        return user;
    }

    protected void userDtoToUser1(UserDto userDto, User mappingTarget) {
        if ( userDto == null ) {
            return;
        }

        if ( userDto.getId() != null ) {
            mappingTarget.setId( userDto.getId() );
        }
        if ( userDto.getUsername() != null ) {
            mappingTarget.setUsername( userDto.getUsername() );
        }
        if ( userDto.getNickname() != null ) {
            mappingTarget.setNickname( userDto.getNickname() );
        }
        if ( mappingTarget.getRoles() != null ) {
            List<Role> list = roleDtoListToRoleList( userDto.getRoles() );
            if ( list != null ) {
                mappingTarget.getRoles().clear();
                mappingTarget.getRoles().addAll( list );
            }
        }
        else {
            List<Role> list = roleDtoListToRoleList( userDto.getRoles() );
            if ( list != null ) {
                mappingTarget.setRoles( list );
            }
        }
        if ( userDto.getGender() != null ) {
            mappingTarget.setGender( userDto.getGender() );
        }
        if ( userDto.getLocked() != null ) {
            mappingTarget.setLocked( userDto.getLocked() );
        }
        if ( userDto.getEnabled() != null ) {
            mappingTarget.setEnabled( userDto.getEnabled() );
        }
        if ( userDto.getLastLoginIp() != null ) {
            mappingTarget.setLastLoginIp( userDto.getLastLoginIp() );
        }
        if ( userDto.getLastLoginTime() != null ) {
            mappingTarget.setLastLoginTime( userDto.getLastLoginTime() );
        }
    }

    protected FileDto artistCreateRequestToFileDto(ArtistCreateRequest artistCreateRequest) {
        if ( artistCreateRequest == null ) {
            return null;
        }

        FileDto fileDto = new FileDto();

        if ( artistCreateRequest.getPhotoId() != null ) {
            fileDto.setId( artistCreateRequest.getPhotoId() );
        }

        return fileDto;
    }

    protected List<MusicVo> musicDtoListToMusicVoList(List<MusicDto> list) {
        if ( list == null ) {
            return null;
        }

        List<MusicVo> list1 = new ArrayList<MusicVo>( list.size() );
        for ( MusicDto musicDto : list ) {
            list1.add( musicMapper.toVo( musicDto ) );
        }

        return list1;
    }
}

package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.AlbumCreateRequest;
import com.tanzicai.caimusic.dto.AlbumDto;
import com.tanzicai.caimusic.dto.AlbumUpdateRequest;
import com.tanzicai.caimusic.dto.ArtistDto;
import com.tanzicai.caimusic.dto.FileDto;
import com.tanzicai.caimusic.dto.MusicDto;
import com.tanzicai.caimusic.dto.RoleDto;
import com.tanzicai.caimusic.dto.UserDto;
import com.tanzicai.caimusic.entity.Album;
import com.tanzicai.caimusic.entity.Artist;
import com.tanzicai.caimusic.entity.Music;
import com.tanzicai.caimusic.entity.Role;
import com.tanzicai.caimusic.entity.User;
import com.tanzicai.caimusic.vo.AlbumVo;
import com.tanzicai.caimusic.vo.ArtistVo;
import com.tanzicai.caimusic.vo.MusicVo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-17T23:58:08+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (International Business Machines Corporation)"
)
@Component
public class AlbumMapperImpl implements AlbumMapper {

    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private ArtistMapper artistMapper;
    @Autowired
    private MusicMapper musicMapper;

    @Override
    public AlbumDto toDto(Album entity) {
        if ( entity == null ) {
            return null;
        }

        AlbumDto albumDto = new AlbumDto();

        if ( entity.getId() != null ) {
            albumDto.setId( entity.getId() );
        }
        if ( entity.getCreatedTime() != null ) {
            albumDto.setCreatedTime( entity.getCreatedTime() );
        }
        if ( entity.getUpdatedTime() != null ) {
            albumDto.setUpdatedTime( entity.getUpdatedTime() );
        }
        if ( entity.getCreatedBy() != null ) {
            albumDto.setCreatedBy( userToUserDto( entity.getCreatedBy() ) );
        }
        if ( entity.getUpdatedBy() != null ) {
            albumDto.setUpdatedBy( userToUserDto( entity.getUpdatedBy() ) );
        }
        if ( entity.getName() != null ) {
            albumDto.setName( entity.getName() );
        }
        if ( entity.getDescription() != null ) {
            albumDto.setDescription( entity.getDescription() );
        }
        if ( entity.getCover() != null ) {
            albumDto.setCover( fileMapper.toDto( entity.getCover() ) );
        }
        if ( entity.getStatus() != null ) {
            albumDto.setStatus( entity.getStatus() );
        }
        if ( entity.getRecommended() != null ) {
            albumDto.setRecommended( entity.getRecommended() );
        }
        if ( entity.getRecommendFactor() != null ) {
            albumDto.setRecommendFactor( entity.getRecommendFactor() );
        }
        List<ArtistDto> list = artistListToArtistDtoList( entity.getArtists() );
        if ( list != null ) {
            albumDto.setArtists( list );
        }
        List<MusicDto> list1 = musicListToMusicDtoList( entity.getMusicList() );
        if ( list1 != null ) {
            albumDto.setMusicList( list1 );
        }

        return albumDto;
    }

    @Override
    public Album toEntity(AlbumDto dto) {
        if ( dto == null ) {
            return null;
        }

        Album album = new Album();

        if ( dto.getId() != null ) {
            album.setId( dto.getId() );
        }
        if ( dto.getCreatedTime() != null ) {
            album.setCreatedTime( dto.getCreatedTime() );
        }
        if ( dto.getUpdatedTime() != null ) {
            album.setUpdatedTime( dto.getUpdatedTime() );
        }
        if ( dto.getCreatedBy() != null ) {
            album.setCreatedBy( userDtoToUser( dto.getCreatedBy() ) );
        }
        if ( dto.getUpdatedBy() != null ) {
            album.setUpdatedBy( userDtoToUser( dto.getUpdatedBy() ) );
        }
        if ( dto.getName() != null ) {
            album.setName( dto.getName() );
        }
        if ( dto.getDescription() != null ) {
            album.setDescription( dto.getDescription() );
        }
        if ( dto.getStatus() != null ) {
            album.setStatus( dto.getStatus() );
        }
        if ( dto.getRecommended() != null ) {
            album.setRecommended( dto.getRecommended() );
        }
        if ( dto.getRecommendFactor() != null ) {
            album.setRecommendFactor( dto.getRecommendFactor() );
        }
        if ( dto.getCover() != null ) {
            album.setCover( fileMapper.toEntity( dto.getCover() ) );
        }
        List<Artist> list = artistDtoListToArtistList( dto.getArtists() );
        if ( list != null ) {
            album.setArtists( list );
        }
        List<Music> list1 = musicDtoListToMusicList( dto.getMusicList() );
        if ( list1 != null ) {
            album.setMusicList( list1 );
        }

        return album;
    }

    @Override
    public Album updateEntity(Album entity, AlbumDto dto) {
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
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
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
        if ( dto.getCover() != null ) {
            entity.setCover( fileMapper.toEntity( dto.getCover() ) );
        }
        if ( entity.getArtists() != null ) {
            List<Artist> list = artistDtoListToArtistList( dto.getArtists() );
            if ( list != null ) {
                entity.getArtists().clear();
                entity.getArtists().addAll( list );
            }
        }
        else {
            List<Artist> list = artistDtoListToArtistList( dto.getArtists() );
            if ( list != null ) {
                entity.setArtists( list );
            }
        }
        if ( entity.getMusicList() != null ) {
            List<Music> list1 = musicDtoListToMusicList( dto.getMusicList() );
            if ( list1 != null ) {
                entity.getMusicList().clear();
                entity.getMusicList().addAll( list1 );
            }
        }
        else {
            List<Music> list1 = musicDtoListToMusicList( dto.getMusicList() );
            if ( list1 != null ) {
                entity.setMusicList( list1 );
            }
        }

        return entity;
    }

    @Override
    public AlbumDto toDto(AlbumCreateRequest albumCreateRequest) {
        if ( albumCreateRequest == null ) {
            return null;
        }

        AlbumDto albumDto = new AlbumDto();

        albumDto.setCover( albumCreateRequestToFileDto( albumCreateRequest ) );
        List<ArtistDto> list = musicMapper.mapArtistList( albumCreateRequest.getArtistIds() );
        if ( list != null ) {
            albumDto.setArtists( list );
        }
        if ( albumCreateRequest.getName() != null ) {
            albumDto.setName( albumCreateRequest.getName() );
        }
        if ( albumCreateRequest.getDescription() != null ) {
            albumDto.setDescription( albumCreateRequest.getDescription() );
        }

        return albumDto;
    }

    @Override
    public AlbumDto toDto(AlbumUpdateRequest albumUpdateRequest) {
        if ( albumUpdateRequest == null ) {
            return null;
        }

        AlbumDto albumDto = new AlbumDto();

        albumDto.setCover( albumUpdateRequestToFileDto( albumUpdateRequest ) );
        List<ArtistDto> list = musicMapper.mapArtistList( albumUpdateRequest.getArtistIds() );
        if ( list != null ) {
            albumDto.setArtists( list );
        }
        if ( albumUpdateRequest.getName() != null ) {
            albumDto.setName( albumUpdateRequest.getName() );
        }
        if ( albumUpdateRequest.getDescription() != null ) {
            albumDto.setDescription( albumUpdateRequest.getDescription() );
        }

        return albumDto;
    }

    @Override
    public AlbumVo toVo(AlbumDto albumDto) {
        if ( albumDto == null ) {
            return null;
        }

        AlbumVo albumVo = new AlbumVo();

        if ( albumDto.getId() != null ) {
            albumVo.setId( albumDto.getId() );
        }
        if ( albumDto.getCreatedTime() != null ) {
            albumVo.setCreatedTime( albumDto.getCreatedTime() );
        }
        if ( albumDto.getUpdatedTime() != null ) {
            albumVo.setUpdatedTime( albumDto.getUpdatedTime() );
        }
        if ( albumDto.getName() != null ) {
            albumVo.setName( albumDto.getName() );
        }
        if ( albumDto.getDescription() != null ) {
            albumVo.setDescription( albumDto.getDescription() );
        }
        if ( albumDto.getCover() != null ) {
            albumVo.setCover( fileMapper.toVo( albumDto.getCover() ) );
        }
        if ( albumDto.getStatus() != null ) {
            albumVo.setStatus( albumDto.getStatus() );
        }
        if ( albumDto.getRecommended() != null ) {
            albumVo.setRecommended( albumDto.getRecommended() );
        }
        if ( albumDto.getRecommendFactor() != null ) {
            albumVo.setRecommendFactor( albumDto.getRecommendFactor() );
        }
        List<ArtistVo> list = artistDtoListToArtistVoList( albumDto.getArtists() );
        if ( list != null ) {
            albumVo.setArtists( list );
        }
        List<MusicVo> list1 = musicDtoListToMusicVoList( albumDto.getMusicList() );
        if ( list1 != null ) {
            albumVo.setMusicList( list1 );
        }

        return albumVo;
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

    protected List<ArtistDto> artistListToArtistDtoList(List<Artist> list) {
        if ( list == null ) {
            return null;
        }

        List<ArtistDto> list1 = new ArrayList<ArtistDto>( list.size() );
        for ( Artist artist : list ) {
            list1.add( artistMapper.toDto( artist ) );
        }

        return list1;
    }

    protected List<MusicDto> musicListToMusicDtoList(List<Music> list) {
        if ( list == null ) {
            return null;
        }

        List<MusicDto> list1 = new ArrayList<MusicDto>( list.size() );
        for ( Music music : list ) {
            list1.add( musicMapper.toDto( music ) );
        }

        return list1;
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

    protected List<Artist> artistDtoListToArtistList(List<ArtistDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Artist> list1 = new ArrayList<Artist>( list.size() );
        for ( ArtistDto artistDto : list ) {
            list1.add( artistMapper.toEntity( artistDto ) );
        }

        return list1;
    }

    protected List<Music> musicDtoListToMusicList(List<MusicDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Music> list1 = new ArrayList<Music>( list.size() );
        for ( MusicDto musicDto : list ) {
            list1.add( musicMapper.toEntity( musicDto ) );
        }

        return list1;
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

    protected FileDto albumCreateRequestToFileDto(AlbumCreateRequest albumCreateRequest) {
        if ( albumCreateRequest == null ) {
            return null;
        }

        FileDto fileDto = new FileDto();

        if ( albumCreateRequest.getCoverId() != null ) {
            fileDto.setId( albumCreateRequest.getCoverId() );
        }

        return fileDto;
    }

    protected FileDto albumUpdateRequestToFileDto(AlbumUpdateRequest albumUpdateRequest) {
        if ( albumUpdateRequest == null ) {
            return null;
        }

        FileDto fileDto = new FileDto();

        if ( albumUpdateRequest.getCoverId() != null ) {
            fileDto.setId( albumUpdateRequest.getCoverId() );
        }

        return fileDto;
    }

    protected List<ArtistVo> artistDtoListToArtistVoList(List<ArtistDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ArtistVo> list1 = new ArrayList<ArtistVo>( list.size() );
        for ( ArtistDto artistDto : list ) {
            list1.add( artistMapper.toVo( artistDto ) );
        }

        return list1;
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

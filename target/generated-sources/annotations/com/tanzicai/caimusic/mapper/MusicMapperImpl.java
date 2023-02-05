package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.ArtistDto;
import com.tanzicai.caimusic.dto.FileDto;
import com.tanzicai.caimusic.dto.MusicCreateRequest;
import com.tanzicai.caimusic.dto.MusicDto;
import com.tanzicai.caimusic.dto.MusicUpdateRequest;
import com.tanzicai.caimusic.dto.RoleDto;
import com.tanzicai.caimusic.dto.UserDto;
import com.tanzicai.caimusic.entity.Artist;
import com.tanzicai.caimusic.entity.Music;
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
    date = "2022-06-17T23:58:08+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (International Business Machines Corporation)"
)
@Component
public class MusicMapperImpl implements MusicMapper {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public MusicDto toDto(Music entity) {
        if ( entity == null ) {
            return null;
        }

        MusicDto musicDto = new MusicDto();

        if ( entity.getId() != null ) {
            musicDto.setId( entity.getId() );
        }
        if ( entity.getCreatedTime() != null ) {
            musicDto.setCreatedTime( entity.getCreatedTime() );
        }
        if ( entity.getUpdatedTime() != null ) {
            musicDto.setUpdatedTime( entity.getUpdatedTime() );
        }
        if ( entity.getName() != null ) {
            musicDto.setName( entity.getName() );
        }
        if ( entity.getStatus() != null ) {
            musicDto.setStatus( entity.getStatus() );
        }
        if ( entity.getDescription() != null ) {
            musicDto.setDescription( entity.getDescription() );
        }
        if ( entity.getFile() != null ) {
            musicDto.setFile( fileMapper.toDto( entity.getFile() ) );
        }
        List<ArtistDto> list = artistListToArtistDtoList( entity.getArtistList() );
        if ( list != null ) {
            musicDto.setArtistList( list );
        }

        return musicDto;
    }

    @Override
    public Music toEntity(MusicDto dto) {
        if ( dto == null ) {
            return null;
        }

        Music music = new Music();

        if ( dto.getId() != null ) {
            music.setId( dto.getId() );
        }
        if ( dto.getCreatedTime() != null ) {
            music.setCreatedTime( dto.getCreatedTime() );
        }
        if ( dto.getUpdatedTime() != null ) {
            music.setUpdatedTime( dto.getUpdatedTime() );
        }
        if ( dto.getName() != null ) {
            music.setName( dto.getName() );
        }
        if ( dto.getStatus() != null ) {
            music.setStatus( dto.getStatus() );
        }
        List<Artist> list = artistDtoListToArtistList( dto.getArtistList() );
        if ( list != null ) {
            music.setArtistList( list );
        }
        if ( dto.getDescription() != null ) {
            music.setDescription( dto.getDescription() );
        }
        if ( dto.getFile() != null ) {
            music.setFile( fileMapper.toEntity( dto.getFile() ) );
        }

        return music;
    }

    @Override
    public Music updateEntity(Music entity, MusicDto dto) {
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
        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getStatus() != null ) {
            entity.setStatus( dto.getStatus() );
        }
        if ( entity.getArtistList() != null ) {
            List<Artist> list = artistDtoListToArtistList( dto.getArtistList() );
            if ( list != null ) {
                entity.getArtistList().clear();
                entity.getArtistList().addAll( list );
            }
        }
        else {
            List<Artist> list = artistDtoListToArtistList( dto.getArtistList() );
            if ( list != null ) {
                entity.setArtistList( list );
            }
        }
        if ( dto.getDescription() != null ) {
            entity.setDescription( dto.getDescription() );
        }
        if ( dto.getFile() != null ) {
            entity.setFile( fileMapper.toEntity( dto.getFile() ) );
        }

        return entity;
    }

    @Override
    public MusicDto toDto(MusicCreateRequest musicCreateRequest) {
        if ( musicCreateRequest == null ) {
            return null;
        }

        MusicDto musicDto = new MusicDto();

        musicDto.setFile( musicCreateRequestToFileDto( musicCreateRequest ) );
        List<ArtistDto> list = mapArtistList( musicCreateRequest.getArtistIds() );
        if ( list != null ) {
            musicDto.setArtistList( list );
        }
        if ( musicCreateRequest.getName() != null ) {
            musicDto.setName( musicCreateRequest.getName() );
        }
        if ( musicCreateRequest.getDescription() != null ) {
            musicDto.setDescription( musicCreateRequest.getDescription() );
        }

        return musicDto;
    }

    @Override
    public MusicDto toDto(MusicUpdateRequest musicUpdateRequest) {
        if ( musicUpdateRequest == null ) {
            return null;
        }

        MusicDto musicDto = new MusicDto();

        musicDto.setFile( musicUpdateRequestToFileDto( musicUpdateRequest ) );
        List<ArtistDto> list = mapArtistList( musicUpdateRequest.getArtistIds() );
        if ( list != null ) {
            musicDto.setArtistList( list );
        }
        if ( musicUpdateRequest.getName() != null ) {
            musicDto.setName( musicUpdateRequest.getName() );
        }
        if ( musicUpdateRequest.getDescription() != null ) {
            musicDto.setDescription( musicUpdateRequest.getDescription() );
        }

        return musicDto;
    }

    @Override
    public MusicVo toVo(MusicDto musicDto) {
        if ( musicDto == null ) {
            return null;
        }

        MusicVo musicVo = new MusicVo();

        if ( musicDto.getId() != null ) {
            musicVo.setId( musicDto.getId() );
        }
        if ( musicDto.getCreatedTime() != null ) {
            musicVo.setCreatedTime( musicDto.getCreatedTime() );
        }
        if ( musicDto.getUpdatedTime() != null ) {
            musicVo.setUpdatedTime( musicDto.getUpdatedTime() );
        }
        if ( musicDto.getName() != null ) {
            musicVo.setName( musicDto.getName() );
        }
        if ( musicDto.getStatus() != null ) {
            musicVo.setStatus( musicDto.getStatus() );
        }
        if ( musicDto.getDescription() != null ) {
            musicVo.setDescription( musicDto.getDescription() );
        }
        if ( musicDto.getFile() != null ) {
            musicVo.setFile( fileMapper.toVo( musicDto.getFile() ) );
        }
        List<ArtistVo> list = artistDtoListToArtistVoList( musicDto.getArtistList() );
        if ( list != null ) {
            musicVo.setArtistList( list );
        }

        return musicVo;
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

    protected ArtistDto artistToArtistDto(Artist artist) {
        if ( artist == null ) {
            return null;
        }

        ArtistDto artistDto = new ArtistDto();

        if ( artist.getId() != null ) {
            artistDto.setId( artist.getId() );
        }
        if ( artist.getCreatedTime() != null ) {
            artistDto.setCreatedTime( artist.getCreatedTime() );
        }
        if ( artist.getUpdatedTime() != null ) {
            artistDto.setUpdatedTime( artist.getUpdatedTime() );
        }
        if ( artist.getCreatedBy() != null ) {
            artistDto.setCreatedBy( userToUserDto( artist.getCreatedBy() ) );
        }
        if ( artist.getUpdatedBy() != null ) {
            artistDto.setUpdatedBy( userToUserDto( artist.getUpdatedBy() ) );
        }
        if ( artist.getName() != null ) {
            artistDto.setName( artist.getName() );
        }
        if ( artist.getRemark() != null ) {
            artistDto.setRemark( artist.getRemark() );
        }
        if ( artist.getPhoto() != null ) {
            artistDto.setPhoto( fileMapper.toDto( artist.getPhoto() ) );
        }
        if ( artist.getStatus() != null ) {
            artistDto.setStatus( artist.getStatus() );
        }
        if ( artist.getRecommended() != null ) {
            artistDto.setRecommended( artist.getRecommended() );
        }
        if ( artist.getRecommendFactor() != null ) {
            artistDto.setRecommendFactor( artist.getRecommendFactor() );
        }

        return artistDto;
    }

    protected List<ArtistDto> artistListToArtistDtoList(List<Artist> list) {
        if ( list == null ) {
            return null;
        }

        List<ArtistDto> list1 = new ArrayList<ArtistDto>( list.size() );
        for ( Artist artist : list ) {
            list1.add( artistToArtistDto( artist ) );
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

    protected Artist artistDtoToArtist(ArtistDto artistDto) {
        if ( artistDto == null ) {
            return null;
        }

        Artist artist = new Artist();

        if ( artistDto.getId() != null ) {
            artist.setId( artistDto.getId() );
        }
        if ( artistDto.getCreatedTime() != null ) {
            artist.setCreatedTime( artistDto.getCreatedTime() );
        }
        if ( artistDto.getUpdatedTime() != null ) {
            artist.setUpdatedTime( artistDto.getUpdatedTime() );
        }
        if ( artistDto.getCreatedBy() != null ) {
            artist.setCreatedBy( userDtoToUser( artistDto.getCreatedBy() ) );
        }
        if ( artistDto.getUpdatedBy() != null ) {
            artist.setUpdatedBy( userDtoToUser( artistDto.getUpdatedBy() ) );
        }
        if ( artistDto.getName() != null ) {
            artist.setName( artistDto.getName() );
        }
        if ( artistDto.getRemark() != null ) {
            artist.setRemark( artistDto.getRemark() );
        }
        if ( artistDto.getPhoto() != null ) {
            artist.setPhoto( fileMapper.toEntity( artistDto.getPhoto() ) );
        }
        if ( artistDto.getStatus() != null ) {
            artist.setStatus( artistDto.getStatus() );
        }
        if ( artistDto.getRecommended() != null ) {
            artist.setRecommended( artistDto.getRecommended() );
        }
        if ( artistDto.getRecommendFactor() != null ) {
            artist.setRecommendFactor( artistDto.getRecommendFactor() );
        }

        return artist;
    }

    protected List<Artist> artistDtoListToArtistList(List<ArtistDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Artist> list1 = new ArrayList<Artist>( list.size() );
        for ( ArtistDto artistDto : list ) {
            list1.add( artistDtoToArtist( artistDto ) );
        }

        return list1;
    }

    protected FileDto musicCreateRequestToFileDto(MusicCreateRequest musicCreateRequest) {
        if ( musicCreateRequest == null ) {
            return null;
        }

        FileDto fileDto = new FileDto();

        if ( musicCreateRequest.getFileId() != null ) {
            fileDto.setId( musicCreateRequest.getFileId() );
        }

        return fileDto;
    }

    protected FileDto musicUpdateRequestToFileDto(MusicUpdateRequest musicUpdateRequest) {
        if ( musicUpdateRequest == null ) {
            return null;
        }

        FileDto fileDto = new FileDto();

        if ( musicUpdateRequest.getFileId() != null ) {
            fileDto.setId( musicUpdateRequest.getFileId() );
        }

        return fileDto;
    }

    protected List<MusicVo> musicDtoListToMusicVoList(List<MusicDto> list) {
        if ( list == null ) {
            return null;
        }

        List<MusicVo> list1 = new ArrayList<MusicVo>( list.size() );
        for ( MusicDto musicDto : list ) {
            list1.add( toVo( musicDto ) );
        }

        return list1;
    }

    protected ArtistVo artistDtoToArtistVo(ArtistDto artistDto) {
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

    protected List<ArtistVo> artistDtoListToArtistVoList(List<ArtistDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ArtistVo> list1 = new ArrayList<ArtistVo>( list.size() );
        for ( ArtistDto artistDto : list ) {
            list1.add( artistDtoToArtistVo( artistDto ) );
        }

        return list1;
    }
}

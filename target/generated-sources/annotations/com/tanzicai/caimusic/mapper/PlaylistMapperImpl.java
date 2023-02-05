package com.tanzicai.caimusic.mapper;

import com.tanzicai.caimusic.dto.ArtistDto;
import com.tanzicai.caimusic.dto.FileDto;
import com.tanzicai.caimusic.dto.MusicDto;
import com.tanzicai.caimusic.dto.PlaylistCreateRequest;
import com.tanzicai.caimusic.dto.PlaylistDto;
import com.tanzicai.caimusic.dto.RoleDto;
import com.tanzicai.caimusic.dto.UserDto;
import com.tanzicai.caimusic.entity.Artist;
import com.tanzicai.caimusic.entity.Music;
import com.tanzicai.caimusic.entity.Playlist;
import com.tanzicai.caimusic.entity.Role;
import com.tanzicai.caimusic.entity.User;
import com.tanzicai.caimusic.vo.ArtistVo;
import com.tanzicai.caimusic.vo.MusicVo;
import com.tanzicai.caimusic.vo.PlaylistVo;
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
public class PlaylistMapperImpl implements PlaylistMapper {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public PlaylistDto toDto(Playlist entity) {
        if ( entity == null ) {
            return null;
        }

        PlaylistDto playlistDto = new PlaylistDto();

        if ( entity.getId() != null ) {
            playlistDto.setId( entity.getId() );
        }
        if ( entity.getCreatedTime() != null ) {
            playlistDto.setCreatedTime( entity.getCreatedTime() );
        }
        if ( entity.getUpdatedTime() != null ) {
            playlistDto.setUpdatedTime( entity.getUpdatedTime() );
        }
        if ( entity.getCreatedBy() != null ) {
            playlistDto.setCreatedBy( userToUserDto( entity.getCreatedBy() ) );
        }
        if ( entity.getUpdatedBy() != null ) {
            playlistDto.setUpdatedBy( userToUserDto( entity.getUpdatedBy() ) );
        }
        if ( entity.getName() != null ) {
            playlistDto.setName( entity.getName() );
        }
        if ( entity.getDescription() != null ) {
            playlistDto.setDescription( entity.getDescription() );
        }
        if ( entity.getCover() != null ) {
            playlistDto.setCover( fileMapper.toDto( entity.getCover() ) );
        }
        if ( entity.getStatus() != null ) {
            playlistDto.setStatus( entity.getStatus() );
        }
        List<MusicDto> list = musicListToMusicDtoList( entity.getMusicList() );
        if ( list != null ) {
            playlistDto.setMusicList( list );
        }
        if ( entity.getRecommended() != null ) {
            playlistDto.setRecommended( entity.getRecommended() );
        }
        if ( entity.getRecommendFactor() != null ) {
            playlistDto.setRecommendFactor( entity.getRecommendFactor() );
        }
        if ( entity.getSpecial() != null ) {
            playlistDto.setSpecial( entity.getSpecial() );
        }

        return playlistDto;
    }

    @Override
    public Playlist toEntity(PlaylistDto dto) {
        if ( dto == null ) {
            return null;
        }

        Playlist playlist = new Playlist();

        if ( dto.getId() != null ) {
            playlist.setId( dto.getId() );
        }
        if ( dto.getCreatedTime() != null ) {
            playlist.setCreatedTime( dto.getCreatedTime() );
        }
        if ( dto.getUpdatedTime() != null ) {
            playlist.setUpdatedTime( dto.getUpdatedTime() );
        }
        if ( dto.getCreatedBy() != null ) {
            playlist.setCreatedBy( userDtoToUser( dto.getCreatedBy() ) );
        }
        if ( dto.getUpdatedBy() != null ) {
            playlist.setUpdatedBy( userDtoToUser( dto.getUpdatedBy() ) );
        }
        if ( dto.getName() != null ) {
            playlist.setName( dto.getName() );
        }
        if ( dto.getDescription() != null ) {
            playlist.setDescription( dto.getDescription() );
        }
        if ( dto.getCover() != null ) {
            playlist.setCover( fileMapper.toEntity( dto.getCover() ) );
        }
        if ( dto.getStatus() != null ) {
            playlist.setStatus( dto.getStatus() );
        }
        List<Music> list = musicDtoListToMusicList( dto.getMusicList() );
        if ( list != null ) {
            playlist.setMusicList( list );
        }
        if ( dto.getRecommended() != null ) {
            playlist.setRecommended( dto.getRecommended() );
        }
        if ( dto.getRecommendFactor() != null ) {
            playlist.setRecommendFactor( dto.getRecommendFactor() );
        }
        if ( dto.getSpecial() != null ) {
            playlist.setSpecial( dto.getSpecial() );
        }

        return playlist;
    }

    @Override
    public Playlist updateEntity(Playlist entity, PlaylistDto dto) {
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
        if ( dto.getCover() != null ) {
            entity.setCover( fileMapper.toEntity( dto.getCover() ) );
        }
        if ( dto.getStatus() != null ) {
            entity.setStatus( dto.getStatus() );
        }
        if ( entity.getMusicList() != null ) {
            List<Music> list = musicDtoListToMusicList( dto.getMusicList() );
            if ( list != null ) {
                entity.getMusicList().clear();
                entity.getMusicList().addAll( list );
            }
        }
        else {
            List<Music> list = musicDtoListToMusicList( dto.getMusicList() );
            if ( list != null ) {
                entity.setMusicList( list );
            }
        }
        if ( dto.getRecommended() != null ) {
            entity.setRecommended( dto.getRecommended() );
        }
        if ( dto.getRecommendFactor() != null ) {
            entity.setRecommendFactor( dto.getRecommendFactor() );
        }
        if ( dto.getSpecial() != null ) {
            entity.setSpecial( dto.getSpecial() );
        }

        return entity;
    }

    @Override
    public PlaylistDto toDto(PlaylistCreateRequest playlistCreateRequest) {
        if ( playlistCreateRequest == null ) {
            return null;
        }

        PlaylistDto playlistDto = new PlaylistDto();

        playlistDto.setCover( playlistCreateRequestToFileDto( playlistCreateRequest ) );
        if ( playlistCreateRequest.getName() != null ) {
            playlistDto.setName( playlistCreateRequest.getName() );
        }
        if ( playlistCreateRequest.getDescription() != null ) {
            playlistDto.setDescription( playlistCreateRequest.getDescription() );
        }

        return playlistDto;
    }

    @Override
    public PlaylistVo toVo(PlaylistDto playlistDto) {
        if ( playlistDto == null ) {
            return null;
        }

        PlaylistVo playlistVo = new PlaylistVo();

        if ( playlistDto.getId() != null ) {
            playlistVo.setId( playlistDto.getId() );
        }
        if ( playlistDto.getCreatedTime() != null ) {
            playlistVo.setCreatedTime( playlistDto.getCreatedTime() );
        }
        if ( playlistDto.getUpdatedTime() != null ) {
            playlistVo.setUpdatedTime( playlistDto.getUpdatedTime() );
        }
        if ( playlistDto.getName() != null ) {
            playlistVo.setName( playlistDto.getName() );
        }
        if ( playlistDto.getDescription() != null ) {
            playlistVo.setDescription( playlistDto.getDescription() );
        }
        if ( playlistDto.getCover() != null ) {
            playlistVo.setCover( fileMapper.toVo( playlistDto.getCover() ) );
        }
        if ( playlistDto.getStatus() != null ) {
            playlistVo.setStatus( playlistDto.getStatus() );
        }
        List<MusicVo> list = musicDtoListToMusicVoList( playlistDto.getMusicList() );
        if ( list != null ) {
            playlistVo.setMusicList( list );
        }
        if ( playlistDto.getRecommended() != null ) {
            playlistVo.setRecommended( playlistDto.getRecommended() );
        }
        if ( playlistDto.getRecommendFactor() != null ) {
            playlistVo.setRecommendFactor( playlistDto.getRecommendFactor() );
        }
        if ( playlistDto.getSpecial() != null ) {
            playlistVo.setSpecial( playlistDto.getSpecial() );
        }

        return playlistVo;
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

    protected MusicDto musicToMusicDto(Music music) {
        if ( music == null ) {
            return null;
        }

        MusicDto musicDto = new MusicDto();

        if ( music.getId() != null ) {
            musicDto.setId( music.getId() );
        }
        if ( music.getCreatedTime() != null ) {
            musicDto.setCreatedTime( music.getCreatedTime() );
        }
        if ( music.getUpdatedTime() != null ) {
            musicDto.setUpdatedTime( music.getUpdatedTime() );
        }
        if ( music.getName() != null ) {
            musicDto.setName( music.getName() );
        }
        if ( music.getStatus() != null ) {
            musicDto.setStatus( music.getStatus() );
        }
        if ( music.getDescription() != null ) {
            musicDto.setDescription( music.getDescription() );
        }
        if ( music.getFile() != null ) {
            musicDto.setFile( fileMapper.toDto( music.getFile() ) );
        }
        List<ArtistDto> list = artistListToArtistDtoList( music.getArtistList() );
        if ( list != null ) {
            musicDto.setArtistList( list );
        }

        return musicDto;
    }

    protected List<MusicDto> musicListToMusicDtoList(List<Music> list) {
        if ( list == null ) {
            return null;
        }

        List<MusicDto> list1 = new ArrayList<MusicDto>( list.size() );
        for ( Music music : list ) {
            list1.add( musicToMusicDto( music ) );
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

    protected Music musicDtoToMusic(MusicDto musicDto) {
        if ( musicDto == null ) {
            return null;
        }

        Music music = new Music();

        if ( musicDto.getId() != null ) {
            music.setId( musicDto.getId() );
        }
        if ( musicDto.getCreatedTime() != null ) {
            music.setCreatedTime( musicDto.getCreatedTime() );
        }
        if ( musicDto.getUpdatedTime() != null ) {
            music.setUpdatedTime( musicDto.getUpdatedTime() );
        }
        if ( musicDto.getName() != null ) {
            music.setName( musicDto.getName() );
        }
        if ( musicDto.getStatus() != null ) {
            music.setStatus( musicDto.getStatus() );
        }
        List<Artist> list = artistDtoListToArtistList( musicDto.getArtistList() );
        if ( list != null ) {
            music.setArtistList( list );
        }
        if ( musicDto.getDescription() != null ) {
            music.setDescription( musicDto.getDescription() );
        }
        if ( musicDto.getFile() != null ) {
            music.setFile( fileMapper.toEntity( musicDto.getFile() ) );
        }

        return music;
    }

    protected List<Music> musicDtoListToMusicList(List<MusicDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Music> list1 = new ArrayList<Music>( list.size() );
        for ( MusicDto musicDto : list ) {
            list1.add( musicDtoToMusic( musicDto ) );
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

    protected FileDto playlistCreateRequestToFileDto(PlaylistCreateRequest playlistCreateRequest) {
        if ( playlistCreateRequest == null ) {
            return null;
        }

        FileDto fileDto = new FileDto();

        if ( playlistCreateRequest.getCoverId() != null ) {
            fileDto.setId( playlistCreateRequest.getCoverId() );
        }

        return fileDto;
    }

    protected List<MusicVo> musicDtoListToMusicVoList(List<MusicDto> list) {
        if ( list == null ) {
            return null;
        }

        List<MusicVo> list1 = new ArrayList<MusicVo>( list.size() );
        for ( MusicDto musicDto : list ) {
            list1.add( musicDtoToMusicVo( musicDto ) );
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

    protected MusicVo musicDtoToMusicVo(MusicDto musicDto) {
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
}

package com.tanzicai.caimusic.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tanzicai.caimusic.config.SecurityConfig;
import com.tanzicai.caimusic.dto.TokenCreateRequest;
import com.tanzicai.caimusic.dto.UserCreateRequest;
import com.tanzicai.caimusic.dto.UserDto;
import com.tanzicai.caimusic.dto.UserUpdateRequest;
import com.tanzicai.caimusic.entity.User;
import com.tanzicai.caimusic.exception.BizException;
import com.tanzicai.caimusic.exception.ExceptionType;
import com.tanzicai.caimusic.mapper.UserMapper;
import com.tanzicai.caimusic.repository.UserRepository;
import com.tanzicai.caimusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    UserRepository repository;

    UserMapper mapper;

    PasswordEncoder passwordEncoder;


    @Override
    public UserDto create(UserCreateRequest userCreateRequest) {
        checkUserName(userCreateRequest.getUsername());
        User user = mapper.createEntity(userCreateRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("********************");
        System.out.println(user.getPassword());
        System.out.println("********************");
        return mapper.toDto(repository.save(user));
    }

    @Override
    public UserDto get(String id) {
        return mapper.toDto(getById(id));
    }

    @Override
    public UserDto update(String id, UserUpdateRequest userUpdateRequest) {
        return mapper.toDto(repository.save(mapper.updateEntity(getById(id), userUpdateRequest)));
    }

    private User getById(String id) {
        Optional<User> user = repository.findById(id);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }

    @Override
    public void delete(String id) {
        repository.delete(getById(id));
    }

    @Override
    public Page<UserDto> search(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public User loadUserByUsername(String username) {
        return super.loadUserByUsername(username);
    }

    @Override
    public String createToken(TokenCreateRequest tokenCreateRequest) {
        User user = loadUserByUsername(tokenCreateRequest.getUsername());
        if (!passwordEncoder.matches(tokenCreateRequest.getPassword(), user.getPassword())) {
            throw new BizException(ExceptionType.USER_PASSWORD_NOT_MATCH);
        }
        if (!user.isEnabled()) {
            throw new BizException(ExceptionType.USER_NOT_ENABLED);
        }

        if (!user.isAccountNonLocked()) {
            throw new BizException(ExceptionType.USER_LOCKED);
        }

        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConfig.SECRET.getBytes()));
    }
    
    @Override
    public UserDto getCurrentUser() {
        return mapper.toDto(super.getCurrentUserEntity());
    }


    private void checkUserName(String username) {
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }


    @Autowired
    private void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    private void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    private void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}

package com.cognizant.eremenko.competiotionGame.service.impl;

import com.cognizant.eremenko.competiotionGame.api.dto.AuthenticationRequestDto;
import com.cognizant.eremenko.competiotionGame.api.dto.UserDto;
import com.cognizant.eremenko.competiotionGame.config.security.Role;
import com.cognizant.eremenko.competiotionGame.mapper.EntityDtoMapper;
import com.cognizant.eremenko.competiotionGame.model.User;
import com.cognizant.eremenko.competiotionGame.repository.UserRepository;
import com.cognizant.eremenko.competiotionGame.service.UserService;
import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final EntityDtoMapper mapper;
    private final PasswordEncoder encoder;

    @Override
    @Transactional
    public UserDto save(AuthenticationRequestDto dto) {
        Preconditions.checkArgument(repository.findByUsername(dto.getUsername()).isEmpty());
        User user = setUser(dto);
        return mapper.mapToDto(repository.save(user));
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(""));
    }

    @Override
    @Transactional
    public List<User> getTop(Pageable pageable) {
        return repository.findAllByOrderByScoreDesc(pageable);
    }

    private User setUser(AuthenticationRequestDto dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));
        User user = mapper.mapToEntity(dto);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        return user;
    }
}

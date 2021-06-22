package com.cognizant.eremenko.competiotionGame.service.impl;

import com.cognizant.eremenko.competiotionGame.api.dto.AuthenticationRequestDto;
import com.cognizant.eremenko.competiotionGame.api.dto.UserDto;
import com.cognizant.eremenko.competiotionGame.config.security.jwt.JwtUserDetailService;
import com.cognizant.eremenko.competiotionGame.config.security.jwt.JwtUtil;
import com.cognizant.eremenko.competiotionGame.constant.ResponseConstant;
import com.cognizant.eremenko.competiotionGame.service.AuthenticationService;
import com.cognizant.eremenko.competiotionGame.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final AuthenticationManager manager;
    private final JwtUtil jwtUtil;
    private final JwtUserDetailService jwtUserDetailService;

    @Override
    public UserDto register(AuthenticationRequestDto dto) {
        try {
            return userService.save(dto);
        } catch (IllegalArgumentException ex) {
            return getUserDto(ResponseConstant.USER_ALREADY_EXIST);
        }
    }

    @Override
    public String login(AuthenticationRequestDto dto) {
        String username = dto.getUsername();
        manager.authenticate(new UsernamePasswordAuthenticationToken(username, dto.getPassword()));
        UserDetails userDetails = jwtUserDetailService.loadUserByUsername(username);

        return jwtUtil.generateToken(userDetails);
    }

    private UserDto getUserDto(ResponseConstant constant) {
        UserDto dto = new UserDto();
        dto.setStatus(constant.getCode());
        dto.setMessage(constant.name());

        return dto;
    }
}

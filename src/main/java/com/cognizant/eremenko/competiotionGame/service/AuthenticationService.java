package com.cognizant.eremenko.competiotionGame.service;

import com.cognizant.eremenko.competiotionGame.api.dto.AuthenticationRequestDto;
import com.cognizant.eremenko.competiotionGame.api.dto.UserDto;

/**
 * The user authentication service
 *
 * @author Andrei Eremenko
 */
public interface AuthenticationService {

    /**
     * Registers new application users
     *
     * @param dto {@link AuthenticationRequestDto} contains user's credentials
     * @return a {@link UserDto} contains user info
     */
    UserDto register(AuthenticationRequestDto dto);

    /**
     * Authenticates a user
     *
     * @param dto {@link AuthenticationRequestDto} contains user's credentials
     * @return a JSON web token
     */
    String login(AuthenticationRequestDto dto);
}

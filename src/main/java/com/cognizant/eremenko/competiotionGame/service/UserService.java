package com.cognizant.eremenko.competiotionGame.service;

import com.cognizant.eremenko.competiotionGame.api.dto.AuthenticationRequestDto;
import com.cognizant.eremenko.competiotionGame.api.dto.UserDto;
import com.cognizant.eremenko.competiotionGame.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * The user service
 *
 * @author Andrei Eremenko
 */
public interface UserService {

    /**
     * Saves users.
     *
     * @param dto {@link AuthenticationRequestDto} contains user's credentials
     * @return a {@link UserDto} contains user info
     */
    UserDto save(AuthenticationRequestDto dto);

    /**
     * Returns a user payload
     *
     * @param username is username
     * @return a {@link User} is a user entity
     */
    User findByUsername(String username);

    /**
     * Returns a user list with max value of resolved tasks
     *
     * @param pageable {@link Pageable} sets users quantity
     * @return a list of a {@link User}
     */
    List<User> getTop(Pageable pageable);
}

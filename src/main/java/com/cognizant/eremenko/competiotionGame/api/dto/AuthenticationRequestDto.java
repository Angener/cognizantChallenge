package com.cognizant.eremenko.competiotionGame.api.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Represents a authentication request payload
 *
 * @author Andrei Eremenko
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationRequestDto {
    String username;
    String password;
}

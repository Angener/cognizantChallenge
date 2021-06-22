package com.cognizant.eremenko.competiotionGame.config.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * The set of the user roles
 *
 * @author Andrei Eremenko
 */
public enum Role implements GrantedAuthority {

    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}

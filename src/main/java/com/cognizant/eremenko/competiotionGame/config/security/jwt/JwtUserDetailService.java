package com.cognizant.eremenko.competiotionGame.config.security.jwt;

import com.cognizant.eremenko.competiotionGame.model.User;
import com.cognizant.eremenko.competiotionGame.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The security user service provider
 *
 * @author Andrei Eremenko
 */
@Service
@RequiredArgsConstructor
public class JwtUserDetailService implements UserDetailsService {

    private final UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = service.findByUsername(username);
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(), user.getRoles());
    }
}

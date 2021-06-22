package com.cognizant.eremenko.competiotionGame.api.controller;

import com.cognizant.eremenko.competiotionGame.api.dto.AuthenticationRequestDto;
import com.cognizant.eremenko.competiotionGame.api.dto.UserDto;
import com.cognizant.eremenko.competiotionGame.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The authentication controller
 *
 * @author Andrei Eremenko
 */
@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public UserDto register(@RequestBody AuthenticationRequestDto dto) {
        return service.register(dto);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthenticationRequestDto dto) {
        return service.login(dto);
    }
}

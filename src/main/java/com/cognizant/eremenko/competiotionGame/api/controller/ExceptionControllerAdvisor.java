package com.cognizant.eremenko.competiotionGame.api.controller;

import com.cognizant.eremenko.competiotionGame.constant.ResponseConstant;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * The global exception handler
 *
 * @author Andrei Eremenko
 */
@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<ErrorResponse> handleException(DisabledException ex) {
        logCause(UNAUTHORIZED, ex.getMessage());
        return getResponse(ResponseConstant.USER_DISABLED, UNAUTHORIZED);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleException(BadCredentialsException ex) {
        logCause(UNAUTHORIZED, ex.getMessage());
        return getResponse(ResponseConstant.INVALID_CREDENTIALS, UNAUTHORIZED);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(UsernameNotFoundException ex) {
        logCause(BAD_REQUEST, ex.getMessage());
        return getResponse(ResponseConstant.USERNAME_NOT_FOUND, BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleException(RuntimeException ex) {
        logCause(INTERNAL_SERVER_ERROR, ex.getMessage());
        return getResponse(ResponseConstant.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR);
    }

    private void logCause(HttpStatus status, String message) {
        log.error("Status: " + status + " " + message);
    }

    private ResponseEntity<ErrorResponse> getResponse(ResponseConstant constant, HttpStatus status) {
        ErrorResponse error = ErrorResponse.builder()
                .timestamp(LocalDateTime.now().format(ISO_DATE_TIME))
                .status(constant.getCode())
                .message(constant.name())
                .build();
        return new ResponseEntity<>(error, status);
    }

    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    private static class ErrorResponse {
        String timestamp;
        String status;
        String message;
    }
}

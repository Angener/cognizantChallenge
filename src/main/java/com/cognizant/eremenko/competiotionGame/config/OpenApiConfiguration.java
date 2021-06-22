package com.cognizant.eremenko.competiotionGame.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

/**
 * The SWAGGER configuration
 *
 * @author Andrei Eremenko
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "Competition game", version = "${competition-game.version}"))
@SecurityScheme(
        name = OpenApiConfiguration.BEARER_AUTH_SECURITY_SCHEME_NAME,
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class OpenApiConfiguration {
    public static final String BEARER_AUTH_SECURITY_SCHEME_NAME = "bearerAuth";
}

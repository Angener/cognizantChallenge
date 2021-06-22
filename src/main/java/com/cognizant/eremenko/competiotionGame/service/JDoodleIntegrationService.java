package com.cognizant.eremenko.competiotionGame.service;

import com.cognizant.eremenko.competiotionGame.service.dto.JDoodleCompileRequestDto;
import com.cognizant.eremenko.competiotionGame.service.dto.JDoodleCompileResponseDto;

/**
 * Represents the JDoodle integration adapter
 *
 * @author Andrei Eremenko
 */
public interface JDoodleIntegrationService {

    /**
     * Exchanges of a data with the external service
     *
     * @param dto {@link JDoodleCompileRequestDto} contains the request data
     * @return {@link JDoodleCompileResponseDto} represents a payload from the external service
     */
    JDoodleCompileResponseDto compileScript(JDoodleCompileRequestDto dto);
}

package com.cognizant.eremenko.competiotionGame.service;

import com.cognizant.eremenko.competiotionGame.api.dto.UserReportDto;

import java.util.List;

/**
 * The statistics service
 *
 * @author Andrei Eremenko
 */
public interface StatisticsService {

    /**
     * Returns a top user list
     *
     * @return {@link UserReportDto} is a list of user payload
     */
    List<UserReportDto> getTop();
}

package com.cognizant.eremenko.competiotionGame.api.controller;

import com.cognizant.eremenko.competiotionGame.api.dto.UserReportDto;
import com.cognizant.eremenko.competiotionGame.service.StatisticsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The statistics controller
 *
 * @author Andrei Eremenko
 */
@RestController
@RequestMapping("/top")
@RequiredArgsConstructor
public class StatisticController {

    private final StatisticsService service;

    @GetMapping
    @Operation(summary = "Returns top 3 users with the resolved task names")
    public List<UserReportDto> getTop() {
        return service.getTop();
    }
}

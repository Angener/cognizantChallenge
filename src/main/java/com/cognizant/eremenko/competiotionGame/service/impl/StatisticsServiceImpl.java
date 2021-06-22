package com.cognizant.eremenko.competiotionGame.service.impl;

import com.cognizant.eremenko.competiotionGame.api.dto.UserReportDto;
import com.cognizant.eremenko.competiotionGame.model.Task;
import com.cognizant.eremenko.competiotionGame.service.StatisticsService;
import com.cognizant.eremenko.competiotionGame.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private static final int STATISTICS_OUTPUT_QUANTITY = 3;

    private final UserService userService;

    @Override
    @Transactional
    public List<UserReportDto> getTop() {
        Pageable pageable = Pageable.ofSize(STATISTICS_OUTPUT_QUANTITY);
        List<UserReportDto> rep = new ArrayList<>();

        userService.getTop(pageable).forEach(user -> {
                    UserReportDto dto = new UserReportDto();
                    dto.setUsername(user.getUsername());
                    dto.setScore(user.getScore());
                    dto.setResolvedTasks(user.getTasks().stream().map(Task::getName).collect(Collectors.toList()));
                    rep.add(dto);
                });
        return rep;
    }
}

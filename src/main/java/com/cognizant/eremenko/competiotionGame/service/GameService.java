package com.cognizant.eremenko.competiotionGame.service;

import com.cognizant.eremenko.competiotionGame.api.dto.TaskDto;
import com.cognizant.eremenko.competiotionGame.api.dto.TaskSolutionRequestDto;
import com.cognizant.eremenko.competiotionGame.api.dto.TaskSolutionResponseDto;

import java.util.List;

/**
 * Represents the main application logic.
 *
 * @author Andrei Eremenko
 */
public interface GameService {

    /**
     * Returns all application tasks.
     *
     * @return the list of {@link TaskDto}
     */
    List<TaskDto> findAllTasks();

    /**
     * Accepts a script, checks a solution and returns the result
     *
     * @param dto {@link TaskSolutionRequestDto} contains a solution script, user and task info
     * @return {@link TaskSolutionRequestDto} is represent the script result
     */
    TaskSolutionResponseDto resolveTask(TaskSolutionRequestDto dto);
}

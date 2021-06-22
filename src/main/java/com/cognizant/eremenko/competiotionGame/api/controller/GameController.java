package com.cognizant.eremenko.competiotionGame.api.controller;

import com.cognizant.eremenko.competiotionGame.api.dto.TaskDto;
import com.cognizant.eremenko.competiotionGame.api.dto.TaskSolutionRequestDto;
import com.cognizant.eremenko.competiotionGame.api.dto.TaskSolutionResponseDto;
import com.cognizant.eremenko.competiotionGame.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The game controller
 *
 * @author Andrei Eremenko
 */
@RestController
@RequestMapping("/challenge")
@RequiredArgsConstructor
public class GameController {

    private final GameService service;

    @GetMapping("/tasks")
    @Operation(summary = "Returns all actual tasks")
    public List<TaskDto> getTasks() {
        return service.findAllTasks();
    }

    @PostMapping
    @Operation(summary = "Compiles a program script and checks solution")
    public TaskSolutionResponseDto resolveTask(@RequestBody TaskSolutionRequestDto dto) {
        return service.resolveTask(dto);
    }
}

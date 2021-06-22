package com.cognizant.eremenko.competiotionGame.service.impl;

import com.cognizant.eremenko.competiotionGame.api.dto.TaskDto;
import com.cognizant.eremenko.competiotionGame.api.dto.TaskSolutionRequestDto;
import com.cognizant.eremenko.competiotionGame.api.dto.TaskSolutionResponseDto;
import com.cognizant.eremenko.competiotionGame.constant.ResponseConstant;
import com.cognizant.eremenko.competiotionGame.constant.ScriptConstant;
import com.cognizant.eremenko.competiotionGame.mapper.EntityDtoMapper;
import com.cognizant.eremenko.competiotionGame.model.Task;
import com.cognizant.eremenko.competiotionGame.model.User;
import com.cognizant.eremenko.competiotionGame.repository.TaskRepository;
import com.cognizant.eremenko.competiotionGame.repository.UserRepository;
import com.cognizant.eremenko.competiotionGame.service.GameService;
import com.cognizant.eremenko.competiotionGame.service.JDoodleIntegrationService;
import com.cognizant.eremenko.competiotionGame.service.UserService;
import com.cognizant.eremenko.competiotionGame.service.dto.JDoodleCompileRequestDto;
import com.cognizant.eremenko.competiotionGame.util.ScriptBuilder;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@SuppressWarnings({"java:S3864", "java:S6212"})
public class GameServiceImpl implements GameService {
    private final JDoodleIntegrationService integrationService;
    private final UserService userService;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final EntityDtoMapper mapper;

    @Override
    @Transactional
    public List<TaskDto> findAllTasks() {
        return taskRepository.findAll().stream()
                .map(mapper::mapToDto)
                .peek(this::setInitialScript)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TaskSolutionResponseDto resolveTask(TaskSolutionRequestDto dto) {
        Task task = taskRepository.findById(dto.getTaskName()).orElse(new Task());

        if (StringUtils.isBlank(task.getName())) {
            return setResponse(ResponseConstant.TASK_NOT_FOUND);
        } else if (isSolutionIncorrect(task, dto)) {
            return setResponse(ResponseConstant.INCORRECT_SOLUTION_PROVIDED);
        } else {

            User user = userService.findByUsername(dto.getUsername());
            Set<Task> userResolvedTask = user.getTasks();
            userResolvedTask.add(task);

            //TODO: maybe ambigouse
            user.setTasks(userResolvedTask);
            user.setScore(userResolvedTask.size());

            userRepository.save(user);



            return setResponse(ResponseConstant.SOLUTION_IS_CORRECT);
        }
    }

    private void setInitialScript(TaskDto dto) {
        dto.setInitialScript(ScriptBuilder.build(ScriptConstant.valueOf(dto.getName().toUpperCase())));
    }

    private boolean isSolutionIncorrect(Task task, TaskSolutionRequestDto dto) {
        ScriptConstant taskParameters = ScriptConstant.valueOf(task.getName().toUpperCase());
        String userScript = dto.getScript();

        return task.getTestCases().stream()
                .anyMatch(testCase -> {
                    JDoodleCompileRequestDto request = new JDoodleCompileRequestDto();
                    request.setScript(ScriptBuilder.build(taskParameters, testCase.getInputData(), userScript));
                    return !integrationService.compileScript(request).getOutput().equals(testCase.getOutputData());
                });
    }

    private TaskSolutionResponseDto setResponse(ResponseConstant constant) {
        TaskSolutionResponseDto response = new TaskSolutionResponseDto();
        response.setStatusCode(constant.getCode());
        response.setMessage(constant.name());

        return response;
    }
}

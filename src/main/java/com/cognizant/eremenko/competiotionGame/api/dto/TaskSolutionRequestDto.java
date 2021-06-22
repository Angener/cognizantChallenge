package com.cognizant.eremenko.competiotionGame.api.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


/**
 * Represents a task solution request payload
 *
 * @author Andrei Eremenko
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskSolutionRequestDto {
    String username;
    String taskName;
    String script;
}

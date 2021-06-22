package com.cognizant.eremenko.competiotionGame.api.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Represents a task solution response payload
 *
 * @author Andrei Eremenko
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskSolutionResponseDto {
    String statusCode;
    String message;
}

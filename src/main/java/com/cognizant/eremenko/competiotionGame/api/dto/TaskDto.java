package com.cognizant.eremenko.competiotionGame.api.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Represents a task payload
 *
 * @author Andrei Eremenko
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDto {
    String name;
    String description;
    String initialScript;
}

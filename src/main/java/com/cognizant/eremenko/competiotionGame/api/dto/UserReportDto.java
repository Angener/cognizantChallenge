package com.cognizant.eremenko.competiotionGame.api.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Represents a user report payload
 *
 * @author Andrei Eremenko
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserReportDto {
    String username;
    long score;
    List<String> resolvedTasks;
}

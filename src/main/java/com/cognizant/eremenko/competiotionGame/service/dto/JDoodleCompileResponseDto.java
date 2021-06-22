package com.cognizant.eremenko.competiotionGame.service.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JDoodleCompileResponseDto {
    String output;
    String statusCode;
    String usedMemory;
    String usedCpu;
    String error;
}

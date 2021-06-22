package com.cognizant.eremenko.competiotionGame.service.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JDoodleCompileRequestDto {
    String clientId;
    String clientSecret;
    String script;
    String stdin;
    String language;
    String versionIndex;
}

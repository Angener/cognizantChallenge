package com.cognizant.eremenko.competiotionGame.service.impl;

import com.cognizant.eremenko.competiotionGame.service.JDoodleIntegrationService;
import com.cognizant.eremenko.competiotionGame.service.dto.JDoodleCompileRequestDto;
import com.cognizant.eremenko.competiotionGame.service.dto.JDoodleCompileResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class JDoodleIntegrationServiceImpl implements JDoodleIntegrationService {
    private final RestTemplate restTemplate;

    @Autowired
    public JDoodleIntegrationServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Value("${jdoodle.clientId}")
    private String clientId;
    @Value("${jdoodle.clientSecret}")
    private String clientSecret;
    @Value("${jdoodle.language}")
    private String language;
    @Value("${jdoodle.version}")
    private String versionIndex;
    @Value("${jdoodle.rest.compiler-api-endpoint}")
    private String endpoint;

    @Override
    public JDoodleCompileResponseDto compileScript(JDoodleCompileRequestDto dto) {
        setCredentials(dto);
        RequestEntity<JDoodleCompileRequestDto> request = setRequest(dto);

        return getResponse(request);
    }

    private void setCredentials(JDoodleCompileRequestDto dto) {
        dto.setClientId(clientId);
        dto.setClientSecret(clientSecret);
        dto.setLanguage(language);
        dto.setVersionIndex(versionIndex);
    }

    private RequestEntity<JDoodleCompileRequestDto> setRequest(JDoodleCompileRequestDto dto) {
        return RequestEntity
                .post(URI.create(endpoint))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto);
    }

    private JDoodleCompileResponseDto getResponse(RequestEntity<JDoodleCompileRequestDto> request) {
        return restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                request,
                JDoodleCompileResponseDto.class
        ).getBody();
    }
}

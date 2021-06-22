package com.cognizant.eremenko.competiotionGame.mapper;

import com.cognizant.eremenko.competiotionGame.api.dto.AuthenticationRequestDto;
import com.cognizant.eremenko.competiotionGame.api.dto.TaskDto;
import com.cognizant.eremenko.competiotionGame.api.dto.TaskSolutionResponseDto;
import com.cognizant.eremenko.competiotionGame.api.dto.UserDto;
import com.cognizant.eremenko.competiotionGame.api.dto.UserReportDto;
import com.cognizant.eremenko.competiotionGame.model.Task;
import com.cognizant.eremenko.competiotionGame.model.User;
import com.cognizant.eremenko.competiotionGame.service.dto.JDoodleCompileResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * The mapper for exchange payloads between a database and the application
 *
 * @author Andrei Eremenko
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntityDtoMapper {

    /**
     * Maps a task entity to a dto
     *
     * @param entity {@link Task}
     * @return {@link TaskDto}
     */
    TaskDto mapToDto(Task entity);

    @Mapping(target = "message", source = "error")
    TaskSolutionResponseDto mapToDto(JDoodleCompileResponseDto dto);

    /**
     * Maps a user entity to a dto
     *
     * @param entity {@link User}
     * @return {@link UserDto}
     */
    UserDto mapToDto(User entity);

    /**
     * Maps a user entity to a dto
     *
     * @param entity {@link User}
     * @return {@link UserReportDto}
     */
    UserReportDto mapToReportDto(User entity);

    /**
     * Maps a dto task payload to the entity
     *
     * @param dto {@link TaskDto}
     * @return {@link Task}
     */
    Task mapToEntity(TaskDto dto);

    /**
     * Maps a dto user payload to the entity
     *
     * @param dto {@link UserDto}
     * @return {@link User}
     */
    User mapToEntity(AuthenticationRequestDto dto);
}

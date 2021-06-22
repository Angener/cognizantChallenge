package com.cognizant.eremenko.competiotionGame.constant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * The list of the API response statuses
 *
 * @author Andrei Eremenko
 */
@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ResponseConstant {

    SOLUTION_IS_CORRECT("10001"),

    TASK_NOT_FOUND("20001"),
    INCORRECT_SOLUTION_PROVIDED("20002"),

    USER_ALREADY_EXIST("30001"),
    USERNAME_NOT_FOUND("30002"),
    INVALID_CREDENTIALS("30003"),
    USER_DISABLED("30004"),

    INTERNAL_SERVER_ERROR("500001");

    String code;
}

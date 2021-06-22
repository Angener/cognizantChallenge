package com.cognizant.eremenko.competiotionGame.util;

import com.cognizant.eremenko.competiotionGame.constant.ScriptConstant;
import org.apache.commons.text.StringSubstitutor;

import static com.cognizant.eremenko.competiotionGame.constant.ScriptConstant.INITIAL_SCRIPT;
import static com.cognizant.eremenko.competiotionGame.constant.ScriptConstant.USER_SCRIPT;

import java.util.HashMap;
import java.util.Map;

public final class ScriptBuilder {

    public static String build(ScriptConstant constant, String argument, String script) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("name", constant.getName());
        parameters.put("argument", argument);
        parameters.put("script", script);
        parameters.put("returnType", constant.getReturnType());
        parameters.put("inputArgument", constant.getInputArgument());

        return substituteString(parameters, INITIAL_SCRIPT);
    }

    public static String build(ScriptConstant constant) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("name", constant.getName());
        parameters.put("returnType", constant.getReturnType());
        parameters.put("inputArgument", constant.getInputArgument());

        return substituteString(parameters, USER_SCRIPT);
    }

    private static String substituteString(Map<String, String> parameters, String target) {
        return new StringSubstitutor(parameters).replace(target);
    }

    private ScriptBuilder() {
    }
}
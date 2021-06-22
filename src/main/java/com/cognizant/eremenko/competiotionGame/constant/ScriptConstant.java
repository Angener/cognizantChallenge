package com.cognizant.eremenko.competiotionGame.constant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * 
 *
 * @author Andrei Eremenko
 */
@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ScriptConstant {

    FACTORIAL("Factorial", "long", "int number");

    String name;
    String returnType;
    String inputArgument;

    public static final String INITIAL_SCRIPT = "public class ${name} { public static void main(String[] args) " +
            "{ System.out.print(get${name}(${argument})); } ${script}}\n";
    public static final String USER_SCRIPT = "public static ${returnType} get${name}(${inputArgument}){ // place your code here... }";

}

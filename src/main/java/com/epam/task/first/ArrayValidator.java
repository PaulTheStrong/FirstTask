package com.epam.task.first;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayValidator {

    public static final Pattern validStringPattern = Pattern.compile("(-?(0|([1-9][0-9]*)) +)*-?(0|([1-9][0-9]*))");

    public boolean validate(String line) {
        Matcher validStringMatcher = validStringPattern.matcher(line);
        return validStringMatcher.matches();
    }
}

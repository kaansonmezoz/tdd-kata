package com.sonmezoz.kaan.kata.tdd.case1;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class StringCalculator {
    private final String COMMA_OR_NEWLINE_REGEX = ",|\n";

    public int add(String numbers) {
        if (StringUtils.isEmpty(numbers)) {
            return 0;
        }

        return add(split(numbers));
    }

    private String[] split(String numbers) {
        return numbers.split(COMMA_OR_NEWLINE_REGEX);
    }

    private int add(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }
}

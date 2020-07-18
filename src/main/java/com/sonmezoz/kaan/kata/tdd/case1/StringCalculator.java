package com.sonmezoz.kaan.kata.tdd.case1;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class StringCalculator {
    private final String COMMA_OR_NEWLINE = "[,\n]";

    public int add(String numbers) {
        if (StringUtils.isEmpty(numbers)) {
            return 0;
        }

        String delimiter = COMMA_OR_NEWLINE;

        if (hasCustomDelimiter(numbers)) {
            delimiter = extractDelimiter(numbers);
            numbers = extractNumbers(numbers);
        }

        return add(split(numbers, delimiter));
    }

    private String extractNumbers(String numbers) {
        return numbers.split("\n")[1];
    }

    private String extractDelimiter(String numbers) {
        return numbers.split("\n")[0].substring(2);
    }

    private boolean hasCustomDelimiter(String numbers) {
        return numbers.startsWith("//");
    }


    private String[] split(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }

    private int add(String[] numbers) {
        int[] array = mapTo(numbers);
        Arrays.stream(array).filter(i -> i < 0).findFirst().ifPresent((i) -> {  throw new NegativeNumberException(i); });

        return Arrays.stream(array).sum();
    }

    private int[] mapTo(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
    }
}

package com.sonmezoz.kaan.kata.tdd.case1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Numbers {
    private static final String COMMA_OR_NEWLINE = "[,\n]";

    private int[] values;

    Numbers(String numbers) {
        String delimiter = COMMA_OR_NEWLINE;

        if (hasCustomDelimiter(numbers)) {
            delimiter = extractDelimiter(numbers);
            numbers = extractNumbers(numbers);
        }

        this.values = mapTo(numbers, delimiter);
    }

    private boolean hasCustomDelimiter(String numbers) {
        return numbers.startsWith("//");
    }

    private String extractDelimiter(String numbers) {
        return numbers.split("\n")[0].substring(2);
    }

    private String extractNumbers(String numbers) {
        return numbers.split("\n")[1];
    }

    private int[] mapTo(String numbers, String delimiter) {
        return Arrays.stream(numbers.split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    boolean containsNegativeNumbers() {
        return Arrays.stream(values).anyMatch( v -> v < 0);
    }

    List<Integer> getNegativeNumbers() {
        return Arrays.stream(values)
                .filter(n -> n < 0)
                .boxed()
                .collect(Collectors.toList());
    }

    int sum() {
        return Arrays.stream(values).sum();
    }
}

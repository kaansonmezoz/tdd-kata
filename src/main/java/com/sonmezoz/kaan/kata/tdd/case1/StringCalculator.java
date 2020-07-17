package com.sonmezoz.kaan.kata.tdd.case1;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (StringUtils.isEmpty(numbers)) {
            return 0;
        }

        return add(numbers.split(","));
    }

    private int add(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }
}

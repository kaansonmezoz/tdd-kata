package com.sonmezoz.kaan.kata.tdd.case1;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {
    public int add(String numbers) {
        if (StringUtils.isEmpty(numbers)) {
            return 0;
        }

        return add(numbers.split(","));
    }

    private int add(String[] numbers) {
        int total = Integer.parseInt(numbers[0]);

        if (numbers.length == 1) {
            return total;
        }

        total += Integer.parseInt(numbers[1]);
        if (numbers.length == 2) {
            return total;
        }

        return total + Integer.parseInt(numbers[2]);
    }
}

package com.sonmezoz.kaan.kata.tdd.case1;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {
    public int add(String numbers) {
        if (StringUtils.isEmpty(numbers)){
            return 0;
        }

        String[] numberArray = numbers.split(",");
        int total = Integer.parseInt(numberArray[0]);

        if (numberArray.length == 1) {
            return total;
        }

        total += Integer.parseInt(numberArray[1]);
        if (numberArray.length == 2) {
            return total;
        }

        return total + Integer.parseInt(numberArray[2]);
    }
}

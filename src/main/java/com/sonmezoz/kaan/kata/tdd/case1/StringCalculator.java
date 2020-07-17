package com.sonmezoz.kaan.kata.tdd.case1;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {
    public int add(String numbers) {
        if (StringUtils.isEmpty(numbers)){
            return 0;
        }

        String[] numberArray = numbers.split(",");

        if (numberArray.length == 1) {
            return Integer.parseInt(numberArray[0]);
        }

        return Integer.parseInt(numberArray[0]) + Integer.parseInt(numberArray[1]);
    }
}

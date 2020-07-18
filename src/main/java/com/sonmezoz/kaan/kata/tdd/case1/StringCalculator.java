package com.sonmezoz.kaan.kata.tdd.case1;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    public int add(String numbers) {
        if (StringUtils.isEmpty(numbers)) {
            return 0;
        }

        return add(new Numbers(numbers));
    }

    private int add(Numbers numbers) {
        numbers.getNegativeNumber().ifPresent((i) -> {  throw new NegativeNumberException(i); });
        return numbers.getNumbersStream().sum();
    }
}

package com.sonmezoz.kaan.kata.tdd.case1;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    public int sum(String numbers) {
        return StringUtils.isEmpty(numbers) ? 0 : sum(new Numbers(numbers));
    }

    private int sum(Numbers numbers) {
        if (numbers.containsNegative()){
            throw new NegativeNumberException(numbers.getNegatives());
        }

        return numbers.sum();
    }
}

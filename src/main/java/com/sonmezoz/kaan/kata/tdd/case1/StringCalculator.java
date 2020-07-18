package com.sonmezoz.kaan.kata.tdd.case1;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {
    private int calledCount;

    public StringCalculator() {
        this.calledCount = 0;
    }


    public int add(String numbers) {
        calledCount++;

        if(StringUtils.isEmpty(numbers)) {
            return 0;
        }

        int sum = sum(new Numbers(numbers));

        return Math.min(sum, 1000);
    }

    private int sum(Numbers numbers) {
        if (numbers.containsNegative()) {
            throw new NegativeNumberException(numbers.getNegatives());
        }

        return numbers.sum();
    }

    public int getCalledCount() {
        return calledCount;
    }
}

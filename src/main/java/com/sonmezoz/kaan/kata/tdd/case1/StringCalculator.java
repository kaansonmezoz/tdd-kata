package com.sonmezoz.kaan.kata.tdd.case1;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {
    private int calledCount;

    public StringCalculator() {
        this.calledCount = 0;
    }


    public int add(String numbers) {
        calledCount++;

        return StringUtils.isEmpty(numbers) ? 0 : sum(new Numbers(numbers));
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

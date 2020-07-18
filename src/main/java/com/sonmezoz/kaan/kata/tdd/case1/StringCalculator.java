package com.sonmezoz.kaan.kata.tdd.case1;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    public int sum(String numbers) {
        return StringUtils.isEmpty(numbers) ? 0 : sum(new Numbers(numbers));
    }

    private int sum(Numbers numbers) {
        numbers.getNegativeNumber().ifPresent((i) -> {  throw new NegativeNumberException(i); });
        return numbers.getNumbersStream().sum();
    }
}

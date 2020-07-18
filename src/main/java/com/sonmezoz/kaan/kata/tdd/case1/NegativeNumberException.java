package com.sonmezoz.kaan.kata.tdd.case1;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class NegativeNumberException extends IllegalArgumentException {
    private static final String MESSAGE_TEMPLATE = "negatives not allowed %s";

    NegativeNumberException(List<Integer> negativeNumbers) {
        super(String.format(MESSAGE_TEMPLATE, StringUtils.join(negativeNumbers, ",")));
    }
}

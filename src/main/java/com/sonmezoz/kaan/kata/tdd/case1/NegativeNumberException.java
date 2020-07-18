package com.sonmezoz.kaan.kata.tdd.case1;

public class NegativeNumberException extends IllegalArgumentException {
    private static final String MESSAGE_TEMPLATE = "negatives not allowed %d";

    NegativeNumberException(int negativeNumber) {
        super(String.format(MESSAGE_TEMPLATE, negativeNumber));
    }
}

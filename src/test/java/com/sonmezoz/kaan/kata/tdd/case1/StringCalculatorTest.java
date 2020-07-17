package com.sonmezoz.kaan.kata.tdd.case1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new StringCalculator();
    }


    // TODO: 17.07.2020 1) Given empty string as parameter When add() is called Then it should return 0 +
    // TODO: 17.07.2020 2) Given "1"  When add() is called Then it should return 1
    // TODO: 17.07.2020 3) Given "1,2" When add() is called Then it should return 3
    // TODO: 17.07.2020 4) Given "1,2,3" When add() is called Then it should return 6
    // TODO: 17.07.2020 5) Given unlimited amount of numbers When add() is called Then it should return sum of them
    // TODO: 17.07.2020 6) Given "1\n2,3" When add() is called Then it should return 6 and \n is seen as a delimiter 
    // TODO: 17.07.2020 7) Given //[delimiter]\n[numbers…] When add() is called Then it should split via given delimiter in the beginning and return the sum
    // TODO: 17.07.2020 “//;\n1;2” == 3  delimiter is ';'
    // TODO: 17.07.2020 8) Given negative numbers When add() is called Then it should throw an exception with message: “negatives not allowed [negative-number]"
    // TODO: 17.07.2020 9) Given multiple negative numbers When add() is called Then it should throw an exception and show all the values in the message
    // TODO: 17.07.2020 10) Given add() is called for multiple times, When getCalledCount() is invoked Then it should return how many times add() has been called
    // TODO: 17.07.2020 11) Given Numbers bigger than 1000 should be ignored. 
    // TODO: 17.07.2020 12) Delimiters can be of any length with the following format 
    // TODO: 17.07.2020 “//[delimiter]\n”
    // TODO: 17.07.2020 “//[***]\n1***2***3” = 6
    // TODO: 17.07.2020 13) Allow multiple delimeters like this
    // TODO: 17.07.2020 “//[delim1][delim2]\n”
    // TODO: 17.07.2020 “//[*][%]\n1*2%3” == 6
    // TODO: 17.07.2020 14) Make sure you can also handle multiple delimiters with length longer than one char
    // TODO: 17.07.2020 “//[**][%%]\n1**2%%3” == 6

    @Test
    public void add_shouldReturn_0_when_empty_string_passed() {
        // given
        String numbers = "";

        // when
        int actual = calculator.add(numbers);

        // then
        assertEquals(0, actual);
    }

    @Test
    public void add_shouldReturn_passed_number_when_only_1_number_is_passed() {
        // given
        String numbers = "1";
        int expected = Integer.parseInt(numbers);

        // when
        int actual = calculator.add(numbers);

        // then
        assertEquals(expected, actual);
    }
}

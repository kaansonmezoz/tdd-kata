package com.sonmezoz.kaan.kata.tdd.case1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new StringCalculator();
    }


    // TODO: 17.07.2020 1) Given empty string as parameter When add() is called Then it should return 0 +
    // TODO: 17.07.2020 2) Given "1"  When add() is called Then it should return 1 +
    // TODO: 17.07.2020 3) Given "1,2" When add() is called Then it should return 3 +
    // TODO: 17.07.2020 4) Given "1,2,3" When add() is called Then it should return 6 +
    // TODO: 17.07.2020 5) Given unlimited amount of numbers When add() is called Then it should return sum of them +
    // TODO: 17.07.2020 6) Given "1\n2,3" When add() is called Then it should return 6 and \n is seen as a delimiter +
    // TODO: 17.07.2020 7) Given //[delimiter]\n[numbers…] When add() is called Then it should split via given delimiter in the beginning and return the sum +
    // TODO: 17.07.2020 “//;\n1;2” == 3  delimiter is ';'
    // TODO: 17.07.2020 8) Given negative numbers When add() is called Then it should throw an exception with message: “negatives not allowed [negative-number]" +
    // TODO: 17.07.2020 9) Given multiple negative numbers When add() is called Then it should throw an exception and show all the values in the message +
    // TODO: 17.07.2020 10) Given add() is called for multiple times, When getCalledCount() is invoked Then it should return how many times add() has been called +
    // TODO: 17.07.2020 11) Given Numbers bigger than 1000 should be ignored. +
    // TODO: 17.07.2020 12) Delimiters can be of any length with the following format  +
    // TODO: 17.07.2020 “//[delimiter]\n”
    // TODO: 17.07.2020 “//[***]\n1***2***3” = 6 +
    // TODO: 17.07.2020 13) Allow multiple delimeters like this
    // TODO: 17.07.2020 “//[delim1][delim2]\n”
    // TODO: 17.07.2020 “//[*][%]\n1*2%3” == 6 +
    // TODO: 17.07.2020 14) Make sure you can also handle multiple delimiters with length longer than one char
    // TODO: 17.07.2020 “//[**][%%]\n1**2%%3” == 6

    @Test
    void add_shouldReturn_0_when_empty_string_passed() {
        // given
        String numbers = "";

        // when
        int actual = calculator.add(numbers);

        // then
        assertEquals(0, actual);
    }

    @Test
    void add_shouldReturn_passed_number_when_only_1_number_is_passed() {
        // given
        String numbers = "1";
        int expected = Integer.parseInt(numbers);

        // when
        int actual = calculator.add(numbers);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void add_shouldReturn_sum_of_two_numbers_when_two_numbers_passed_with_comma_delimiter() {
        // given
        String numbers = "1,2";
        int expected = 3;

        // when
        int actual = calculator.add(numbers);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void add_shouldReturn_sum_of_three_numbers_when_numbers_passed_with_comma_delimiter() {
        // given
        String numbers = "1,2,3";
        int expected = 6;

        // when
        int actual = calculator.add(numbers);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void add_shouldReturn_sum_of_all_numbers_when_unlimited_amount_of_numbers_passed_with_comma_delimiter() {
        // given
        int[] numbers = generateNumbers();
        int expected = sum(numbers);
        expected = expected > 1000 ? 1000 : expected;

        // when
        int actual = calculator.add(numbersToString(numbers, ","));

        // then
        assertEquals(expected, actual);
    }

    @Test
    void add_shouldReturn_sum_of_numbers_when_numbers_passed_with_comma_and_newline_delimiter() {
        // given
        String numbers = "1\n2,3";
        int expected = 6;

        // when
        int actual = calculator.add(numbers);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void add_shouldReturn_sum_of_numbers_when_numbers_passed_with_delimiter_char_at_the_beginning() {
        // given
        String numbers = "//;\n1;2";
        int expected = 3;

        // when
        int actual = calculator.add(numbers);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void add_shouldThrow_NegativeNumberException_message_with_negative_number() {
        // given
        String numbers = "1,2,3,4,-5,6,7,8";

        // when
        NegativeNumberException e = assertThrows(NegativeNumberException.class, () -> calculator.add(numbers));

        // then
        assertEquals("negatives not allowed -5", e.getMessage());
    }

    @Test
    void add_shouldThrow_NegativeNumberException_message_with_all_negative_numbers() {
        // given
        String numbers = "1,2,3,4,-5,-6,-7,8,9,10,-11";

        // when
        NegativeNumberException e = assertThrows(NegativeNumberException.class, () -> calculator.add(numbers));

        // then
        assertEquals("negatives not allowed -5,-6,-7,-11", e.getMessage());
    }

    @Test
    void getCalledCount_shouldReturn_how_many_times_add_has_been_invoked() {
        // given
        int count = ThreadLocalRandom.current().nextInt(0, 10000);

        // when
        IntStream.range(0, count).forEach(i -> calculator.add(""));

        // then
        assertEquals(count, calculator.getCalledCount());
    }

    @Test
    void add_shouldReturn_1000_when_sum_of_numbers_is_greater_than_1000() {
        // given
        String numbers = "1000,2000,3000";
        int expected = 1000;

        // when
        int actual = calculator.add(numbers);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void add_shouldReturn_sum_of_numbers_when_given_delimiter_can_be_any_length(){
        // given
        String numbers = "//[***]\n1***2***3";
        int expected = 6;

        // when
        int actual = calculator.add(numbers);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void add_shouldReturn_sum_of_numbers_when_given_multiple_delimiters_1_char_long(){
        // given
        String numbers = "//[*][%]\n1*2%3";
        int expected = 6;

        // when
        int actual = calculator.add(numbers);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void add_shouldReturn_sum_of_numbers_when_given_multiple_delimiters_with_unlimited_length(){
        // given
        String numbers = "//[**][%%]\n1**2%%3";
        int expected = 6;

        // when
        int actual = calculator.add(numbers);

        // then
        assertEquals(expected, actual);
    }


    private int[] generateNumbers() {
        int count = ThreadLocalRandom.current().nextInt(4, 100);
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = ThreadLocalRandom.current().nextInt(0, 1000);
        }

        return numbers;
    }

    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private String numbersToString(int[] numbers, String delimiter) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(delimiter));
    }
}

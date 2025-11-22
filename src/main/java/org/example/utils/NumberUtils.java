package org.example.utils;

import org.example.InvalidNumberException;

import java.util.ArrayList;
import java.util.List;

public class NumberUtils {
    private NumberUtils() {}

    public static List<Integer> parseNumbers(List<String> inputs) throws InvalidNumberException {
        List<Integer> result = new ArrayList<>();
        for(String input : inputs) {
            try {
                result.add(Integer.parseInt(input));
            } catch (NumberFormatException e) {
                throw new InvalidNumberException("Wrong Number : " + input + "'");
            }
        }
        return result;
    }

    public static List<Integer> validatePositive(List<Integer> numbers) throws InvalidNumberException {
        for(int num : numbers) {
            if(num < 0) {
                throw new InvalidNumberException("Negative numbers are not allowed! " , num);
            }
        }
        return numbers;
    }

    public static int validatePositive(int number) throws InvalidNumberException {
        if(number < 0) {
            throw new InvalidNumberException("Negative numbers are not allowed! " , number);
        }
        return number;
    }
}

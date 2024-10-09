package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {
    public static void main(String[] args) {
        String[] strings =
                {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

        // display original strings
        System.out.printf("Original strings: %s%n", Arrays.asList(strings));

        // strings in uppercase
        System.out.printf("strings in uppercase: %s%n",
                Arrays.stream(strings)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList()));

        // strings less than "n" (case insensitive) sorted ascending
        System.out.printf("strings less than n sorted ascending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER)
                        .collect(Collectors.toList()));

        // strings less than "n" sorted descending
        System.out.printf("strings less than n sorted descending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .collect(Collectors.toList()));

        // strings that start with a vowel
        System.out.printf("strings that start with a vowel: %s%n",
                Arrays.stream(strings)
                        .filter(s -> "aeiou".contains(s.toLowerCase().substring(0, 1)))
                        .collect(Collectors.toList()));

        // concatenate all strings into a single string, separated by a comma
        System.out.printf("all strings concatenated: %s%n",
                Arrays.stream(strings)
                        .collect(Collectors.joining(", ")));

        // count strings with more than 5 characters
        long count = Arrays.stream(strings)
                .filter(s -> s.length() > 5)
                .count();
        System.out.printf("number of strings with more than 5 characters: %d%n", count);
    }
}
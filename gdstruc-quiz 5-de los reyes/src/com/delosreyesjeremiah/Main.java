package com.delosreyesjeremiah;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int[] numbers = { 60, 33, 12, 64, 17, 105, -53 };

        System.out.println(primeIndexSearch(numbers, 105));
        System.out.println(primeIndexSearch(numbers, 12));
        System.out.println(primeIndexSearch(numbers, 60));
    }

    public static int primeIndexSearch(int[] input, int value) {
        // Store the prime indices of the inputted data to an array list
        ArrayList<Integer> primeIndices = new ArrayList<>();

        // Start evaluation at the value of 2 (0 and 1 are not prime numbers)
        for (int index = 2; index < input.length; index++) {
            boolean primeIndex = true;

            // 2 and 3 are the lowest prime numbers. No further evaluations are needed.
            if (index == 2 || index == 3) {
                primeIndices.add(index);
                continue;
            }

            // Evaluate if index is a prime number
            for (int divisor = 2; divisor < index; divisor++) {
                if (index % divisor == 0) {
                    primeIndex = false;
                    break;
                }
            }

            if (primeIndex) {
                primeIndices.add(index);
            }
        }

        // Search for a value match using only the prime indices of the inputted data
        // If found, return the prime index of the value. If not, return -1
        for (int i = 0; i < primeIndices.size(); i++) {
            if (input[primeIndices.get(i)] == value) {
                return primeIndices.get(i);
            }
        }

        return -1;
    }
}


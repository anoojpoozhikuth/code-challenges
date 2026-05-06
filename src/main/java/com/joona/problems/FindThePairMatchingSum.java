package com.joona.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * You are given an array of integers and a SUM. You need to identify whether the array contains any pairs that can add up to the value.
 * <p>
 * Instructions and assumptions
 * 1. Array of integers
 * 2. Integers can be positive , 0 or negative
 * 3. Elements can repeat.
 * 4. No order is guaranteed
 * <p>
 * Ex : [1,2,3,9] & SUM = 8. The answer is False ( no pairs adds to 8 )
 * Ex : [1,2,4,4] & SUM = 8. The answer is True ( we can find the pair 4 , 4 )
 */
public class FindThePairMatchingSum {
    public static void main(String[] args) {
//        method1();
        method2_usingHashSet();

    }

    public static boolean hasMatchingPair(ArrayList<Integer> numbers, int SUM) {
        if (numbers.isEmpty() || numbers.size() < 2) {
            System.out.println("Array has not enough elements");
            return false;
        }
        HashSet<Integer> seen = new HashSet<>();
        for (Integer number : numbers) {
            int complement = SUM - number;
            if (seen.contains(complement)) {
                System.out.println("Found matching pair : " + number + " & " + complement);
                return true;
            }
            seen.add(number);
        }
        System.out.println("NO pairs can match the SUM :  NO");
        return false;
    }

    private static void method2_usingHashSet() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the SUM : ");
        int SUM = sc.nextInt();
        System.out.println("Input the array elements one by one type done to stop : ");
        while (true) {
            String input = sc.next();
            try {
                int elementValue = Integer.parseInt(input);
                numbers.add(elementValue);

            } catch (NumberFormatException nfe) {
                System.out.println("Thanks for providing array elements : " + numbers);
                break;
            }
        }
        sc.close();
        hasMatchingPair(numbers, SUM);
    }
}

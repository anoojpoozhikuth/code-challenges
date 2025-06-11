package com.joona.utils;

import java.util.Scanner;


/**
 * Utility class for performing various operations on 2D arrays.
 * This class provides methods to handle common tasks such as
 * reading a 2D array from input and printing a 2D array.
 */
public class ArrayUtils {

    /**
     * Reads a 2D array from standard input.
     * First inputs M and N represent the number of rows and columns.
     * Then M lines follow, each containing N space-separated integers.
     *
     * @return A 2D array of integers.
     */
    public static int[][] readArrayFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide the array size in m x n format.   ");
        // Read dimensions of the array
        int row_count = scanner.nextInt();
        int column_count = scanner.nextInt();
        System.out.println("Input array size is " + row_count + " x " + column_count );
        int[][] array = new int[row_count][column_count];

        // Read array elements
        for (int i = 0; i < row_count; i++) {
            for (int j = 0; j < column_count; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        return array;
    }


    /**
     * Prints a 2D array to the standard output in a clear structured format.
     *
     * @param array The 2D array of integers to be printed.
     */
    public static void printArrayToConsole(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

}
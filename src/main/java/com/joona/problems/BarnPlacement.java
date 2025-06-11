package com.joona.problems;

import java.util.Scanner;

public class BarnPlacement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read dimensions of the farm
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline

        int[][] farm = new int[N][M];
        int[][] sum = new int[N + 1][M + 1]; // 2D prefix sum array

        // Read the farm grid and compute prefix sum
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine().trim();
            for (int j = 0; j < M; j++) {
                farm[i][j] = line.charAt(j) - '0';
                sum[i + 1][j + 1] = farm[i][j]
                        + sum[i][j + 1]
                        + sum[i + 1][j]
                        - sum[i][j]; // Inclusion-exclusion
            }
        }

        scanner.close();

        // Compute number of ways for all possible barn sizes
        for (int h = 1; h <= N; h++) {
            for (int w = 1; w <= M; w++) {
                int count = 0;

                // Slide the barn (h, w) across the grid
                for (int i = 0; i + h <= N; i++) {
                    for (int j = 0; j + w <= M; j++) {
                        // Compute sum of submatrix (i, j) to (i+h-1, j+w-1) using prefix sum
                        int total = sum[i + h][j + w]
                                - sum[i][j + w]
                                - sum[i + h][j]
                                + sum[i][j];

                        // If all cells in the submatrix are '1', count it
                        if (total == h * w) {
                            count++;
                        }
                    }
                }

                // Print the count for the barn size (h, w)
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }
}


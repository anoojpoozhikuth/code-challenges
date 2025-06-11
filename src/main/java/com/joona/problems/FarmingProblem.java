package com.joona.problems;

import static com.joona.utils.ArrayUtils.readArrayFromInput;

/**
 * The farmer decided to build a barn on his farm. But on his farm there are trees and other buildings, which he does not want to remove.
 * For simplicity, we represent the farm as a rectangular grid of height  and width . Each of the trees and buildings are located in one or more cells of the grid. The barn is a rectangle and should be built on the free cells of the grid.
 * Help the farmer to find out how many ways there are to place the barn, for all possible sizes of barns.
 * <p>
 * Input Format
 * The first line contains two integers  and  - the dimensions of the farm.
 * The next  lines contains description of the farm: each line contains  characters - 0 or 1 (1 means the cell is available/free for building the barn).
 * <p>
 * Output Format
 * Write  lines with  integers in each line. The  value in the  line must be equal to the number of ways to place a barn with height  and width  in the farm.
 * <p>
 * Constraints
 * 1 <= N,M <= 1024
 * <p>
 * Sample input
 * 3 3
 * 011
 * 110
 * 110
 * <p>
 * Sample Output
 * 6 3 0
 * 3 1 0
 * 1 0 0
 * <p>
 * Explanation
 * <p>
 * https://www.hackerrank.com/challenges/demidenko-farmer/problem
 **/

public class FarmingProblem {
    public static void main(String[] args) {
        int[][] farmArray = readArrayFromInput();
        int[][] outPutArray = new int[farmArray.length][farmArray[0].length];
        for (int i = 0; i < farmArray.length; i++) {
            for (int j = 0; j < farmArray[0].length; j++) {
                outPutArray[i][j] = 0;
            }

        }

    }
}

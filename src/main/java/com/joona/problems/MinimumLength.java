package com.joona.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * You are given two arrays 
 and 
, of length 
. You can select any subarray and then sort the elements in ascending order of that subarray for arrays 
 and 
.

Find the minimum length of the subarray you can choose to make 
 and 
 same after performing the operation. 
 and 
 are permutations of each other.

Input Format:

The first line contains an integer 
 denoting the number of test cases.
The first line of each test case contains an integer 
.
The next line of each test case contains 
 space-separated integers, elements of array 
.
The next line of each test case contains 
 space-separated integers, elements of array 
.
Output Format:

For each test case, print the minimum length of the subarray you can choose to make 
 and 
 same after performing the operation.
 */
public class MinimumLength {

    /**
     * The algorithm to solve the problem is as follows:
     * 1. We read the number of test cases T.   
     * 2. For each test case, we read the length of the arrays N and then read the two arrays A and B.
     * 3. We initialize two pointers, i and k, to the start and end of the arrays, respectively.
     * 4. We use a while loop to move the pointers towards the center of the arrays as long as the elements at those pointers are the same in both arrays.
     * 5. If the elements at pointer i are the same in both arrays, we increment i to move to the next element.
     * 6. If the elements at pointer k are the same in both arrays, we decrement k to move to the previous element.
     * 7. Once the while loop ends, the pointers i and k will indicate the boundaries of the subarray that needs to be sorted. The length of this subarray is calculated as (k - i + 1) and printed as the result for the test case.        
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] aStr = br.readLine().split(" ");
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(aStr[i]);
            }
            String[] bStr = br.readLine().split(" ");
            int[] B = new int[N];
            for (int i = 0; i < N; i++) {
                B[i] = Integer.parseInt(bStr[i]);
            }
            int i = 0;
            int k = N - 1;
            while (i < k && (A[i] == B[i] || A[k] == B[k])) {
                if (A[i] == B[i]) {
                    i++;
                }
                
                if (A[k] == B[k]) {
                    k--;
                }
            }
            System.out.println("\n minimum length of the subarray : "+((k - i) + 1));
        }
    }
    
}

package com.joona.problems;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, representing the number of elements in nums1
 * and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should not be returned by the function, but instead be
 * stored inside the array nums1. To accommodate this, nums1 has a length of m +
 * n, where the first m elements denote the elements that should be merged, and
 * the last n elements are set to 0 and should be ignored. nums2 has a length of
 * n.
 */

class MergeSortedArray {
    public static void main(String[] args) {
        System.err.println("Hello World");
        int[] nums1 = { 4, 5, 6, 0, 0, 0, 0 };
        int[] nums2 = { 1, 2, 3, 4 };
        int m = 3;
        int n = 4;
        merge(nums1, nums2, m, n);
    }

    static void merge(int[] nums1, int[] nums2, int m, int n) {
        int i = m - 1; // pointer for nums1 (processed elements)
        int j = n - 1; // pointer for nums2
        int k = m + n - 1; // pointer for nums1 (result position)

        // Compare elements from the end and place the larger one
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 has remaining elements, copy them
        // (no need to copy nums1 elements as they're already in place)
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        for (int index = 0; index < nums1.length; index++) {
            System.out.print(nums1[index] + " ");
        }
    }

}

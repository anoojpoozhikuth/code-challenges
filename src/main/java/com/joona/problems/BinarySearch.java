package com.joona.problems;

class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int index = binarySearch.search(nums, 9);
        System.out.println("Index is " + index);
    }

    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        // As it is a sroted array - checking the number is within the array range
        if (target > nums[rightIndex] || target < nums[leftIndex]) {
            return -1;
        }

        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (target > nums[midIndex]) {
                // search RHS
                leftIndex = midIndex + 1;

            } else if (target < nums[midIndex]) {
                // search LHS
                rightIndex = midIndex - 1;

            } else {
                // nums[midIndex] == target
                return midIndex;
            }
        }
        return -1;
    }
}
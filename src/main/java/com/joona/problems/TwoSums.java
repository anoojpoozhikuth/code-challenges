package com.joona.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum Problem
 * <p>
 * Given an array of integers "nums" and an integer "target", return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * <p>
 * Example 1:
 * ---------------
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * <p>
 * Example 2:
 * ------------
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * <p>
 * Example 3:
 * --------------
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * ===================
 * Constraints:
 * ====================
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */

public class TwoSums {

    /**
     * Finds two indices in the array such that the numbers at those indices add up to the target sum.
     *
     * <p><b>Approach:</b>
     * Uses a single-pass hash map to store the complement of each number (i.e., target - current number)
     * and its index. On each iteration, checks if the current number exists as a key in the map.
     * If it does, it means a matching pair has been found. Otherwise, stores the new complement.
     *
     * <p><b>Optimization:</b>
     * - Pre-loads the map with the complement of the first number to simplify the loop logic.
     * - Handles edge cases where the array has fewer than 2 elements.
     *
     * @param nums   the input array of integers
     * @param target the target sum to find
     * @return an array containing the two indices whose values add up to the target;
     *         returns [0, 0] if no valid pair exists or input is invalid
     */
    public int[] findThePairInedxMatchingSum(int[] nums, int target) {
        Map compMap = new HashMap<Integer, Integer>();
        int[] answer = new int[2];
        if (nums.length < 2) return answer;
        //Adding the first element's  complement number ( ie target - current number) to the map
        compMap.put((target - nums[0]), 0);
        for (int index = 1; index < nums.length; index++) {
            int currentNumber = nums[index];
            if (compMap.containsKey(currentNumber)) {
                answer[0] = (int) compMap.get(currentNumber);
                answer[1] = index;
                break;
            } else {
                int compNumber = target - currentNumber;
                compMap.put(compNumber, index);
            }
        }
        return answer;
    }
}
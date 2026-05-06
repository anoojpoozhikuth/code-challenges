package com.joona.problems;

/**
 * String Reversal Problem
 * <p>
 * Reverse a given string without using the standard reverse function.
 * Solve the problem in the most efficient way in terms of time and space complexity.
 * <p>
 * <p>
 * Example 1:
 * ---------------
 * <p>
 * Input: "hello"
 * Output: "olleh"
 * <p>
 * <p>
 * Example 2:
 * ---------------
 * <p>
 * Input: "Java"
 * Output: "avaJ"
 * <p>
 * <p>
 * Example 3:
 * ---------------
 * <p>
 * Input: "a"
 * Output: "a"
 * <p>
 * <p>
 * Example 4:
 * ---------------
 * <p>
 * Input: ""
 * Output: ""
 * <p>
 * ===================
 * Constraints:
 * ====================
 * 0 <= string length <= 10^6
 * The string can contain any printable ASCII characters
 * <p>
 * ===================
 * Complexity Analysis:
 * ====================
 * Time Complexity: O(n) - We iterate through each character exactly once
 * Space Complexity: O(n) - Required for the output string (Java strings are immutable)
 *                          Auxiliary space (excluding output): O(n) for the char array,
 *                          but the algorithm only uses a constant amount of extra space
 *                          for the two pointers.
 */
public class StringReversalProblem {

    /**
     * Reverses a string using a two-pointer approach.
     * <p>
     * <b>Approach:</b>
     * Converts the string to a character array and uses two pointers (left and right)
     * starting from opposite ends. Swaps characters at these pointers and moves them
     * towards the center until they meet. This is the most efficient approach as it:
     * - Uses only O(1) auxiliary space (two pointers)
     * - Makes a single pass with O(n) time complexity
     * - Avoids creating intermediate strings or using recursion
     * <p>
     *
     * @param str the string to be reversed
     * @return the reversed string, or the same string if it's null or empty
     */
    public String reverseString(String str) {
        // Handle null or empty strings
        if (str == null || str.isEmpty()) {
            return str;
        }

        // Convert string to character array for efficient manipulation
        char[] chars = str.toCharArray();

        // Use two-pointer approach for in-place reversal
        int left = 0;
        int right = chars.length - 1;

        // Swap characters from both ends moving towards the center
        while (left < right) {
            // Swap characters at left and right positions
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            // Move pointers towards center
            left++;
            right--;
        }

        // Convert char array back to string and return
        return new String(chars);
    }

   
}

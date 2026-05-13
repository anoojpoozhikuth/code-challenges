package com.joona.problems;

/*

You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.

 

Example 1:

Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
Example 2:

Input: letters = ["c","f","j"], target = "c"
Output: "f"
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
Example 3:

Input: letters = ["x","x","y","y"], target = "z"
Output: "x"
Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
 

Constraints:

2 <= letters.length <= 104
letters[i] is a lowercase English letter.
letters is sorted in non-decreasing order.
letters contains at least two different characters.
target is a lowercase English letter.
 */

public class BinarySearchSmalletLetter {
    public static void main(String[] args) {        
        BinarySearchSmalletLetter letterFinder = new BinarySearchSmalletLetter();
        char[] letters = { 'c','f','j' };
        // char[] letters = { 'a','d','h','k','o' };
        // char[] letters = {'e','e','e','e','e','e','n','n','n','n'};
        char target = 'd';
        System.out.println("Character is " + letterFinder.nextGreatestLetter(letters, target));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int leftIndex = 0;
        int rightIndex = letters.length - 1;
        char smallestChar = letters[leftIndex];
        if (target >= letters[rightIndex] || target < letters[leftIndex]) {
            return smallestChar;
        }

        while (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
             if (leftIndex == middleIndex ){
                if(target < letters [leftIndex] || target == letters[rightIndex]){
                    smallestChar = letters [leftIndex];
                }else {
                    smallestChar= letters[rightIndex];
                }
                break;
            }else if (target < letters[middleIndex]) {
                rightIndex = middleIndex;
            } else if (target >= letters[middleIndex] ) {
                leftIndex = middleIndex;
            } 
            
        }
        return smallestChar;
    }
}

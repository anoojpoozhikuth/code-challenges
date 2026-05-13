package com.joona.problems;

public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(120));
    }
    
     public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }else if (x >=0 && x<=9){
            return true;
        }
        // int revnum = reverseNumber(x);
        // return x == revnum;
        return twoPointerCheck(x);
    }

    private int reverseNumber(int x) {
        int revnum = 0;
        while (x > 0) {
            int digit = x % 10;
            revnum = (revnum * 10) + digit;
            x = x / 10;
        }
        return revnum;
    }

    private boolean twoPointerCheck(int x){
        char[] number = String.valueOf(x).toCharArray();
        for(int i=0,j=number.length-1; i<j; i++, j--){
            if(number[i] != number[j]){
                return false;
            }

        }
        return true;
    }
}

package com.joona.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StringReversalProblemTest {

    private StringReversalProblem stringReversal = new StringReversalProblem();

    // Tests for the primary efficient two-pointer approach
    @Test
    public void testReverseSimpleString() {
        String result = stringReversal.reverseString("hello");
        assertEquals("olleh", result);
    }

    @Test
    public void testReverseMixedCaseString() {
        String result = stringReversal.reverseString("Java");
        assertEquals("avaJ", result);
    }

    @Test
    public void testReverseSingleCharacter() {
        String result = stringReversal.reverseString("a");
        assertEquals("a", result);
    }

    @Test
    public void testReverseEmptyString() {
        String result = stringReversal.reverseString("");
        assertEquals("", result);
    }

    @Test
    public void testReverseNullString() {
        String result = stringReversal.reverseString(null);
        assertNull(result);
    }

    @Test
    public void testReversePalindromeString() {
        String result = stringReversal.reverseString("racecar");
        assertEquals("racecar", result);
    }

    @Test
    public void testReverseStringWithSpaces() {
        String result = stringReversal.reverseString("hello world");
        assertEquals("dlrow olleh", result);
    }

    @Test
    public void testReverseStringWithSpecialCharacters() {
        String result = stringReversal.reverseString("a!b@c#d$");
        assertEquals("$d#c@b!a", result);
    }

    @Test
    public void testReverseStringWithNumbers() {
        String result = stringReversal.reverseString("abc123");
        assertEquals("321cba", result);
    }

    @Test
    public void testReverseTwoCharacterString() {
        String result = stringReversal.reverseString("ab");
        assertEquals("ba", result);
    }

    @Test
    public void testReverseStringWithUnicodeCharacters() {
        String result = stringReversal.reverseString("café");
        assertEquals("éfac", result);
    }

    @Test
    public void testReverseLongString() {
        String longString = "The quick brown fox jumps over the lazy dog";
        String expected = "god yzal eht revo spmuj xof nworb kciuq ehT";
        String result = stringReversal.reverseString(longString);
        assertEquals(expected, result);
    }
   
}

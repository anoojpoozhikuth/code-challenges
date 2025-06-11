package com.joona.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumsTest {

    private TwoSums twoSums = new TwoSums();

    @Test
    public void testExample1() {
        int[] result = twoSums.findThePairInedxMatchingSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void testExample2() {
        int[] result = twoSums.findThePairInedxMatchingSum(new int[]{3, 2, 4}, 6);
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void testExample3() {
        int[] result = twoSums.findThePairInedxMatchingSum(new int[]{3, 3}, 6);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void testWhenArraySizeIsNotSufficient() {
        int[] result = twoSums.findThePairInedxMatchingSum(new int[]{5}, 6);
        assertArrayEquals(new int[2], result);
    }
}
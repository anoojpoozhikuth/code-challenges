package com.joona.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxDiffRemappingADigitTest {

    @Test
    void minMaxDifferenceTest1() {
        MaxDiffRemappingADigit remappingADigit = new MaxDiffRemappingADigit();
        int difference = remappingADigit.minMaxDifference(11891);

        assertEquals(99009, difference);

    }

    @Test
    void minMaxDifferenceTest2() {
        MaxDiffRemappingADigit remappingADigit = new MaxDiffRemappingADigit();
        int difference = remappingADigit.minMaxDifference(90);

        assertEquals(99, difference);
    }

    @Test
    void minMaxDifferenceTest3() {
        MaxDiffRemappingADigit remappingADigit = new MaxDiffRemappingADigit();
        int difference = remappingADigit.minMaxDifference(99999);

        assertEquals(99999, difference);
    }

    @Test
    void minMaxDifferenceTest4() {
        MaxDiffRemappingADigit remappingADigit = new MaxDiffRemappingADigit();
        int difference = remappingADigit.minMaxDifference(121);

        assertEquals(909, difference);
    }
}
package com.joona.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AddTwoNumbersLinkedListTest {

    @Test
    void testAddTwoNumbersSameLength() {
        ListNode l1 = buildList(2, 4, 3);
        ListNode l2 = buildList(5, 6, 4);

        ListNode result = AddTwoNumbersLinkedList.addTwoNumbers(l1, l2);

        assertListEquals(new int[]{7, 0, 9}, result);
    }

    @Test
    void testAddTwoNumbersDifferentLengths() {
        ListNode l1 = buildList(9, 9, 9);
        ListNode l2 = buildList(1);

        ListNode result = AddTwoNumbersLinkedList.addTwoNumbers(l1, l2);

        assertListEquals(new int[]{0, 0, 0, 1}, result);
    }

    @Test
    void testAddTwoNumbersWithZeroList() {
        ListNode l1 = buildList(0);
        ListNode l2 = buildList(7, 3);

        ListNode result = AddTwoNumbersLinkedList.addTwoNumbers(l1, l2);

        assertListEquals(new int[]{7, 3}, result);
    }

    @Test
    void testAddTwoNumbersCarryThroughMultipleDigits() {
        ListNode l1 = buildList(9, 9, 1);
        ListNode l2 = buildList(1, 0, 9);

        ListNode result = AddTwoNumbersLinkedList.addTwoNumbers(l1, l2);

        assertListEquals(new int[]{0, 0, 1, 1}, result);
    }

    @Test
    void testAddTwoNumbersSingleDigitWithCarry() {
        ListNode l1 = buildList(5);
        ListNode l2 = buildList(7);

        ListNode result = AddTwoNumbersLinkedList.addTwoNumbers(l1, l2);

        assertListEquals(new int[]{2, 1}, result);
    }

    private static ListNode buildList(int... values) {
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    private static void assertListEquals(int[] expected, ListNode actual) {
        int[] actualValues = new int[expected.length];
        int index = 0;
        while (actual != null && index < actualValues.length) {
            actualValues[index++] = actual.val;
            actual = actual.next;
        }
        assertArrayEquals(expected, actualValues);
    }
}

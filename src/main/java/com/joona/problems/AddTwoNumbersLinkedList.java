package com.joona.problems;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807 
 * Reverse of it will be 708
 * 
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbersLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode addedNode = addTwoNumbers(l1, l2);
        System.out.println("Sum is ");
        StringBuilder sb = new StringBuilder();
        while (addedNode != null) {
            sb.append(addedNode.val);
            addedNode = addedNode.next;
        }
        System.out.print(" " + sb.toString());

    }

    /**
    ## Intuition
    Add the two numbers digit by digit, just like manual addition from least significant digit to most significant digit. Use a carry value to track overflow from each digit sum, and keep traversing until both lists are exhausted and no carry remains.

    ## Approach
    Use a dummy head node to simplify building the result list. Maintain a current pointer for the result list and a carryForward value for the carry between digit additions.

    Loop while either l1 or l2 is non-null, or carryForward is non-zero.
    Start each iteration with sum = carryForward.
    If l1 exists, add l1.val and advance l1.
    If l2 exists, add l2.val and advance l2.
    Compute digit = sum % 10 and carryForward = sum / 10.
    Append a new node with digit to the result list and move current.
    At the end, return result.next to skip the dummy starting node.
    
    ## Complexity
    Time complexity: O(max(m, n))
    Space complexity: O(max(m, n))

     * @param l1
     * @param l2
     * @return
     */

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // The node we wll return after finding the result. Start with a dummy "0" value node.
        ListNode result = new ListNode(0);

        // Pointer or moving node starting at a dummy or 0 node called result.
        ListNode current = result;

        // During addition of digits, carry the "1" when value exceeds 10
        int carryForward = 0;

        // Iterate when the lists has nodes, or even when nodes are over there is  carryForward value
        while (l1 != null || l2 != null || carryForward != 0) {
            // Add any carry forwarded value from previous digit addition (eg: 4+6 = 10, 1
            // will be carried)
            int sum = carryForward;
            // Add the values from current l1 node and l2 node
            if (l1 != null) {
                sum = sum + l1.val; // Eg: sum = 0 + 4

                // Move to the next node in this linked list
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;// sum = 4 + 6

                // Move to the next node in this linked list
                l2 = l2.next;
            }
            int digit = sum % 10; // digit (to be added to result node) = 10%10 = 0
            carryForward = sum / 10; // carryForward (to next iteration/node) = 10/10 = 1
            // create the node containing value and point current node to that
            current.next = new ListNode(digit);
            // move the pointer(current) to the newly created node
            current = current.next;
        }
        // skip the initial dummy/0th node.
        return result.next;
    }

}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

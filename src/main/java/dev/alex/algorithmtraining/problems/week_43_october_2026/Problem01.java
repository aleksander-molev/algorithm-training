package dev.alex.algorithmtraining.problems.week_43_october_2026;

import dev.alex.algorithmtraining.model.ListNode;

public class Problem01 {
    /*
     * Remove the nth node counted from the end of an acyclic singly linked list
     * and return the resulting head. The last node has n = 1.
     * Reuse the remaining nodes and preserve their values and relative order.
     * Do not use an additional array or collection. Temporary helper nodes are allowed.
     * Constraints: 1 <= number of nodes <= 100000; 1 <= n <= number of nodes;
     * -1000000000 <= node.val <= 1000000000.
     * Examples:
     * [1, 2, 3, 4, 5], n = 2 -> [1, 2, 3, 5]  1 -> 2 -> 3
     * [7, 8, 9], n = 3 -> [8, 9]
     * [4, 5], n = 1 -> [4]
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode iter = head;
        ListNode reversed = new ListNode(0);
        ListNode reversedHead = reversed;

        while(iter != null) {
            ListNode tmp = iter;
            iter = iter.next;
            tmp.next = reversedHead == reversed ? null : reversed;
            reversed = tmp;
        }

        ListNode delIter = reversed;
        ListNode prev = null;
        for(int i = 0; i < n - 1; i++) {
            prev = delIter;
            delIter = delIter.next;
        }

        if (prev != null) {
            prev.next = delIter.next;
        } else {
            reversed = reversed.next;
        }

        if (reversed == null) {
            return reversed;
        }

        ListNode result = new ListNode(0);
        ListNode resultHead = result;
        while(reversed != null) {
            ListNode tmp = reversed;
            reversed = reversed.next;
            tmp.next = result == resultHead ? null : result;
            result = tmp;
        }

        return result;
    }

}

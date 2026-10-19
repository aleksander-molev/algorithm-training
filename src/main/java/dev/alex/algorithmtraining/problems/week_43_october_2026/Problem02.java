package dev.alex.algorithmtraining.problems.week_43_october_2026;

import dev.alex.algorithmtraining.model.ListNode;

public class Problem02 {
    /*
     * Swap each adjacent pair of nodes in an acyclic singly linked list and
     * return the resulting head. If the number of nodes is odd, leave the final
     * node in its original position. Change node links, not node values.
     * Reuse all input nodes. Do not use an additional array or collection.
     * Temporary helper nodes are allowed.
     * Constraints: 0 <= number of nodes <= 100000;
     * -1000000000 <= node.val <= 1000000000. Empty input returns null.
     * Examples:
     * [1, 2, 3, 4] -> [2, 1, 4, 3]
     * [5, 6, 7] -> [6, 5, 7]
     * [8, 9] -> [9, 8]
     */
    public ListNode swapPairs(ListNode head) {
        ListNode iter = head;
        ListNode prev = null;
        while(iter != null && iter.next != null) {
            ListNode pairStart = iter;
            iter = iter.next.next;
            ListNode pairFirst = swapNodes(prev, pairStart);
            if(prev == null) {
                head = pairFirst;
            }
            prev = pairFirst.next;
        }

        return head;
    }

    private ListNode swapNodes(ListNode prev, ListNode node) {
        ListNode next = node.next;
        if(next == null) {
            return node;
        }
        ListNode pairNext = next.next;
        next.next = node;
        node.next = pairNext;
        if(prev != null) {
            prev.next = next;
        }

        return next;
    }



}

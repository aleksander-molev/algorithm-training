package dev.alex.algorithmtraining.problems.week_43_october_2026;

public class Problem06 {
    /**
     * Rotate an acyclic singly linked list right by k positions and return its new head.
     * Moving right once moves the final node to the front. Reuse the original nodes,
     * preserve their values, and return an acyclic list. Do not use an additional
     * array or collection. Empty input returns null.
     * Constraints: 0 <= number of nodes <= 100000; 0 <= k <= 1000000000.
     * Examples:
     * [1, 2, 3, 4, 5], k=2 -> [4, 5, 1, 2, 3]
     * [2, 4, 6], k=4 -> [6, 2, 4]
     * [7, 8, 9], k=0 -> [7, 8, 9]
     */
    public ListNode rotateRight(ListNode head, int k) {
        if( head == null) {
            return head;
        }
        ListNode revers = null;
        int len = 0;
        // rotate 5 4 3 2 1
        while(head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = revers;
            revers = tmp;
            len++;
        }
        k = k % len;
        ListNode result = null;
        ListNode tail = null;
        ListNode resTail = null;
        int count = 0;
        while(revers != null) {
            if(count < k) {
                resTail = resTail == null ? revers : resTail;
                ListNode tr = revers;
                revers = revers.next;
                tr.next = result;
                result = tr;
            } else {
                ListNode tr = revers;
                revers = revers.next;
                tr.next = tail;
                tail = tr;
            }

            count++;
        }

        if(resTail == null) {
            return tail;
        }
        resTail.next = tail;

        return result;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

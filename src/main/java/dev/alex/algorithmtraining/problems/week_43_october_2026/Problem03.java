package dev.alex.algorithmtraining.problems.week_43_october_2026;

public class Problem03 {
    /*
     * Reorder an acyclic singly linked list so nodes originally at odd-numbered
     * positions come first, followed by nodes originally at even-numbered positions.
     * Positions start at 1 and refer to the original list, not to node values.
     * Preserve the original relative order within each group. Return the new head.
     * Reuse all input nodes without changing their values. Do not use an additional
     * array or collection. Temporary helper nodes are allowed.
     * Constraints: 0 <= number of nodes <= 100000;
     * -1000000000 <= node.val <= 1000000000. Empty input returns null.
     * Examples:
     * [1, 2, 3, 4, 5] -> [1, 3, 5, 2, 4]
     * [2, 1, 3, 5, 6, 4] -> [2, 3, 6, 1, 5, 4]
     * [4, 8, 2] -> [4, 2, 8]
     */
    public ListNode groupByPosition(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode oddHead = odd;
        ListNode even = new ListNode(0);
        ListNode evenHead = even;

        ListNode iter = head;
        int count = 1;
        while(iter != null) {
            odd.next = null;
            even.next = null;
            if(count++ % 2 == 1) {
                odd.next = iter;
                odd = odd.next;
            } else {
                even.next = iter;
                even = even.next;
            }

            iter = iter.next;
        }

        odd.next = evenHead.next;
        return oddHead.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

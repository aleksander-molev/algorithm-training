package dev.alex.algorithmtraining.problems.week_43_october_2026;

public class Problem07 {
    /**
     * Given an acyclic singly linked list sorted in nondecreasing order, remove
     * ALL nodes whose value occurs more than once. Return the remaining list in
     * its original order. Reuse surviving nodes and preserve their values.
     * Do not use an additional array or collection. Empty input returns null.
     * Constraints: 0 <= number of nodes <= 100000; -1000000000 <= val <= 1000000000.
     * Examples:
     * [1, 2, 3, 3, 4, 4, 5] -> [1, 2, 5]
     * [1, 1, 1, 2, 3] -> [2, 3]
     * [2, 2, 4, 4] -> []
     */

    public ListNode retainUnique(ListNode head) {

        /**
         * 1, 2, 3, 3, 4, 4, 5
         *
         * result listnode
         * link to copy
         * last added
         */

        ListNode res = new ListNode(0);
        ListNode resHead = res;
        ListNode copyPtr = res;
        ListNode lastAdded = null;

        while(head != null) {
            if(lastAdded == null) {
                lastAdded = head;
                res.next = lastAdded;
                res = res.next;
                head = head.next;
                continue;
            }
            if(lastAdded.val != head.val) {
                lastAdded = head;
                res.next = lastAdded;
                res = res.next;
                copyPtr = copyPtr.next;
            } else {
                while(head != null && lastAdded.val == head.val) {
                    head = head.next;
                }
                lastAdded = head;
                res = copyPtr;
                res.next = head;
                res = res.next;
                if(head == null) {
                    continue;
                }
            }
            head = head.next;
        }

        return resHead.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

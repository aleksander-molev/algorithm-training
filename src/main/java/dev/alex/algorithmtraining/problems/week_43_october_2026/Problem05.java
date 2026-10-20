package dev.alex.algorithmtraining.problems.week_43_october_2026;

public class Problem05 {
    /*
     * Reorder an acyclic singly linked list by alternating nodes from the
     * beginning and the end of its original order. For original nodes
     * L0, L1, ..., Ln, return L0 -> Ln -> L1 -> Ln-1 -> L2 -> ... .
     * Each original node must appear exactly once; return the resulting head.
     * Reuse all input nodes without changing their values. Do not use an additional
     * array or collection. Temporary helper nodes are allowed. Empty input returns null.
     * Constraints: 0 <= number of nodes <= 100000;
     * -1000000000 <= node.val <= 1000000000.
     * Examples:
     * [1, 2, 3, 4] -> [1, 4, 2, 3]
     * [1, 2, 3, 4, 5] -> [1, 5, 2, 4, 3]
     * [8, 3, 7, 2, 9, 4] -> [8, 4, 3, 9, 7, 2]
     */
    public ListNode reorder(ListNode head) {
        // get n
        // half list in reverse order
        // merge last part and first
        // revers list again

        ListNode start = head;

        // count n
        int n = 0;
        while(head != null) {
            head = head.next;
            n++;
        }

        // half revers list
        ListNode rev = null;
        int count = 0;
        head = start;
        int half = (int) Math.ceil((double)n / 2);
        while(count++ < half) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = rev;
            rev = tmp;
        }

        // merge both parts
        ListNode res = new ListNode(0);
        ListNode resHead = res;

        while(rev != null || head != null) {
            if(n % 2 == 0) {
                res.next = head;
                res = res.next;
                head = head.next;
                res.next = rev;
                rev = rev.next;
                res = res.next;
            } else {
                res.next = rev;
                res = res.next;
                rev = rev.next;
                res.next = head;
                res = res.next;
                head = head == null ? null : head.next;
            }
        }

        // reverse the list
        ListNode rr = null;
        res = resHead.next;
        while(res != null) {
            ListNode tmp = res;
            res = res.next;
            tmp.next = rr;
            rr = tmp;
        }

        return rr;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

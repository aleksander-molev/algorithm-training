package dev.alex.algorithmtraining.problems.week_43_october_2026;

public class Problem04 {
    /*
     * Reverse the nodes from position left through position right, inclusive,
     * in an acyclic singly linked list. Positions start at 1. Return the new head.
     * Nodes outside that section must remain in their original order.
     * Reuse all input nodes without changing their values. Do not use an additional
     * array or collection. Temporary helper nodes are allowed.
     * Constraints: 1 <= number of nodes <= 100000;
     * 1 <= left <= right <= number of nodes; -1000000000 <= node.val <= 1000000000.
     * Examples:
     * [1, 2, 3, 4, 5], left=2, right=4 -> [1, 4, 3, 2, 5]
     * [3, 6, 9, 12], left=1, right=3 -> [9, 6, 3, 12]
     * [5, 8, 11], left=2, right=2 -> [5, 8, 11]
     */
    public ListNode reverseSection(ListNode head, int left, int right) {
        ListNode rev = null;
        ListNode end = null;
        ListNode res = new ListNode(0);
        ListNode resHead = res;

        int count = 1;

        while (head != null) {
            while (left <= count && count <= right && head != null) {
                ListNode t = head;
                end = end == null ? t : end;
                head = head.next;
                t.next = rev;
                rev = t;
                count++;

                if(count > right) {
                    res.next = rev;
                    res = end;
                }
            }

            res.next = head;
            head = head != null ? head.next : null;
            res = res.next;
            count++;
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

package dev.alex.algorithmtraining.problems.week_43_october_2026;

public class Problem09 {
    /**
     * Return whether the values of an acyclic singly linked list read the same
     * forward and backward. Empty and singleton lists return true.
     * On return, every original node must have its original value and next link.
     * Do not use an additional array or collection, or recursion.
     * Constraints: 0 <= number of nodes <= 100000; -1000000000 <= val <= 1000000000.
     * Examples: [1,2,2,1] -> true; [1,2,3] -> false; [4,7,4] -> true.
     */
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;

        ListNode revs = null;
        ListNode headtail = null;
        ListNode mid = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
// 1  2  3  4  5
            ListNode tmp = slow;
            mid = slow.next;
            slow = slow.next;
            tmp.next = revs;
            revs = tmp;
        }
        headtail = mid;

        if(fast != null ) {
//            revs = revs.next;
            mid = mid.next;
        }

        ListNode forw = headtail;
        boolean res = true;
        while(revs != null) {
            if(revs.val != mid.val && res) {
                res =  false;
            }
            ListNode tmp = revs;
            revs = revs.next;
            tmp.next = forw;
            forw = tmp;
            mid = mid.next;
        }

//        tail.next = headtail;


        return res;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
    }
}

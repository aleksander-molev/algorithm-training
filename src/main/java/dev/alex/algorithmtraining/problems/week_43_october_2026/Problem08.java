package dev.alex.algorithmtraining.problems.week_43_october_2026;

public class Problem08 {
    /**
     * Given the heads of two acyclic singly linked lists, return the first node
     * shared by both lists, or null if no node is shared. Sharing means the SAME
     * node object, not equal values. Once lists share a node, they share its suffix.
     * Do not modify any node value or next reference. Do not use an additional
     * array or collection.
     * Constraints: each list contains 0 to 100000 nodes.
     * Examples (C names shared node objects):
     * A: 1 -> 2 -> C(8) -> 9; B: 3 -> C(8) -> 9; return C.
     * A: 4 -> C(7) -> 10; B: 5 -> 6 -> C(7) -> 10; return C.
     * A: 1 -> 2; B: 1 -> 2 (all distinct objects); return null.
     */
    public ListNode findIntersection(ListNode headA, ListNode headB) {
        ListNode iterA = headA;
        ListNode iterB = headB;
        int countA = 0;
        int countB = 0;

        while(iterA != null || iterB != null) {
            if(iterA != null) {
                countA++;
                iterA = iterA.next;
            } else {
                countB++;
                iterB = iterB.next;
            }
        }

        ListNode longest = countA >= countB ? headA : headB;
        ListNode shortest = countA < countB ? headA : headB;

        int diff = (countA - countB);
        diff = diff < 0 ? diff * -1 : diff;

        while(diff-- > 0) {
            longest = longest.next;
        }

        while(longest != shortest) {
            longest = longest.next;
            shortest = shortest.next;
        }

        return longest;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

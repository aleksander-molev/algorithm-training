package dev.alex.algorithmtraining.problems.week_44_october_2026;

import java.util.PriorityQueue;

public class Problem06 {
    /**
     * Merge all supplied acyclic singly linked lists into one nondecreasing list.
     * Each input list is already nondecreasing; lists share no node objects.
     * Reuse the original nodes, preserve their values, and terminate the result
     * with null. You may change next references. Do not flatten values into an
     * array/collection and sort them. Equal-valued nodes may appear in any order.
     * There are 0..10000 lists and at most 100000 nodes in total;
     * values are in [-1000000000, 1000000000]. A head may be null.
     * Example: [1,4,7], [2,5], [3,6] -> [1,2,3,4,5,6,7].
     */
    // result list, head of it
    // all head nodes put in PriorityQueue minHeap
    // until mean hip is not empty, take one apply to result
    // and put back with next element
    //  [ 10, 11]  [ 20, 30] [1,2,3]
    public ListNode mergeLists(ListNode[] heads) {
        ListNode result = new ListNode(0);
        ListNode resultHead = result;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((ln1, ln2) -> ln1.val - ln2.val);

        for(ListNode ln: heads) {
            if(ln == null) {
                continue;
            }
            pq.add(ln);
        }

        while(!pq.isEmpty()) {
            ListNode tmp = pq.peek().next;
            result.next = pq.remove();
            if(tmp != null)
                pq.add(tmp);
            result = result.next;
        }

        return resultHead.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
    }
}

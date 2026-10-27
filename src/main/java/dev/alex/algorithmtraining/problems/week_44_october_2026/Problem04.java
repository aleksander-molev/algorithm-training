package dev.alex.algorithmtraining.problems.week_44_october_2026;

import java.util.PriorityQueue;

public class Problem04 {
    /**
     * Values arrive one at a time in the order given by arrivals. Starting when k
     * values have arrived, report the kth largest value seen so far after each arrival.
     * Duplicates count separately. Return arrivals.length-k+1 answers. Leave arrivals unchanged.
     * Process arrivals from left to right without reading future values when producing an answer.
     * Constraints: 1 <= arrivals.length <= 100000; 1 <= k <= arrivals.length;
     * -1000000000 <= arrivals[i] <= 1000000000.
     * Examples: [4,5,8,2,10,9], k=3 -> [4,4,5,8];
     * [5,5,4,6], k=2 -> [5,5,5]; [3,1,7,6], k=2 -> [1,3,6].
     */
    public int[] ranks(int[] arrivals, int k) {
        // prepare result
        // min heap with k size
        // iterater over arrivals
        // if i >= k then add to resul[i - k] = heap.peek().val
        // if size of heap > k then remove heap.remove()

        int[] res = new int[arrivals.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0;
        for(int arr : arrivals) {
            pq.add(arr);
            if(pq.size() == k) {
                res[idx++] = pq.peek();
            } else if(pq.size() > k) {
                pq.remove();
                res[idx++] = pq.peek();
            }
        }

        return res;
    }
}

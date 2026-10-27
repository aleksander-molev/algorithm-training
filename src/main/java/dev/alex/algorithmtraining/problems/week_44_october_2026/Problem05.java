package dev.alex.algorithmtraining.problems.week_44_october_2026;

import java.util.PriorityQueue;

public class Problem05 {
    /**
     * Each row of rows is sorted in nondecreasing order. Rows can have different
     * lengths and can be empty. There is no ordering guarantee between rows.
     * Return the kth smallest value across all rows, counting duplicates separately.
     * Leave all input arrays unchanged.
     * Constraints: 1 <= rows.length <= 10000; total number of values N is 1..100000;
     * 1 <= k <= N; -1000000000 <= each value <= 1000000000.
     * Examples: [[1,4,7],[2,5],[3,6]], k=5 -> 5;
     * [[1,1,9],[],[1,3]], k=3 -> 1; [[-5,2],[0,8,10]], k=4 -> 8.
     */
    public int kthSmallest(int[][] rows, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            return n2 - n1;
        });
        for(int[] row : rows) {
            for(int val : row) {
                pq.add(val);
                if(pq.size() > k) {
                    pq.remove();
                }
            }
        }

        return pq.peek();
    }
}

package dev.alex.algorithmtraining.problems.week_44_october_2026;

import java.util.PriorityQueue;

public class Problem02 {
    /**
     * Each entry in gifts is the number of gifts in a pile. Perform exactly operations steps.
     * At each step, choose a pile with the largest current count and replace its count
     * with floor(sqrt(count)). If several piles tie, choose any one.
     * Return the total number of gifts remaining. Leave gifts unchanged.
     * Constraints: 1 <= gifts.length <= 100000; 1 <= gifts[i] <= 1000000000;
     * 0 <= operations <= 100000.
     * Examples: [25,64,9,4,100], operations=4 -> 29;
     * [16,9], operations=2 -> 7; [81,4], operations=1 -> 13.
     */
    public long remainingGifts(int[] gifts, int operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for(int n: gifts) {
            pq.add(n);
        }

        while( operations-- > 0) {
            pq.add((int)Math.floor(Math.sqrt(pq.remove())));
        }

        return pq.stream().mapToLong(Integer::longValue).sum();
    }
}

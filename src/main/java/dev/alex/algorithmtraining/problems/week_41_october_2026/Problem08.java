package dev.alex.algorithmtraining.problems.week_41_october_2026;

import java.util.HashMap;
import java.util.Map;

public class Problem08 {
    /*
     * Given two integer arrays a and b of equal length, return the maximum
     * length of a non-empty contiguous segment [left, right] for which
     * a[left] + ... + a[right] equals b[left] + ... + b[right].
     * Both segments must use the same left and right indices.
     * Return 0 if no such segment exists. Do not modify either array.
     *
     * Constraints:
     * - 0 <= a.length == b.length <= 100000
     * - 0 <= a[i], b[i] <= 1000000000
     *
     * Examples:
     * - a = [1, 2, 3, 4], b = [2, 1, 4, 5] returns 2.
     * - a = [1, 1, 1], b = [2, 2, 2] returns 0.
     * - a = [3, 1, 2], b = [1, 3, 2] returns 3.
     */
    public int longestEqualSumSegment(int[] a, int[] b) {
        Map<Long, Integer> idxByPs = new HashMap<>();
        long psA = 0;
        long psB = 0;
        int max = 0;
        idxByPs.put(0L, 0);
        for(int i = 0; i < a.length; i++) {
            psA += a[i];
            psB += b[i];
            long diff = psA - psB;
            if(idxByPs.containsKey(diff)) {
                max = Math.max(max, i - idxByPs.get(diff) + 1);
            } else {
                idxByPs.put(diff, i + 1);
            }
        }

        return max;
    }
}

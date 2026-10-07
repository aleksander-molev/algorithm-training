package dev.alex.algorithmtraining.problems.week_41_october_2026;

import java.util.HashMap;
import java.util.Map;

public class Problem07 {
    /*
     * Return the length of the longest non-empty contiguous subarray
     * containing equally many even and odd integers. Return 0 if none exists.
     * Zero is even; negative integers follow the usual even/odd definition.
     * Do not modify nums.
     *
     * Constraints:
     * - 0 <= nums.length <= 100000
     * - -1000000000 <= nums[i] <= 1000000000
     *
     * Examples:
     * - [2, 1, 4, 3, 6] returns 4.
     * - [1, 3, 5] returns 0.
     * - [2, 1, 3, 4, 6, 8] returns 4.
     */
    public int longestBalancedSubarray(int[] nums) {
        int ps = 0;
        Map<Integer, Integer> firstIdx = new HashMap<>();
        firstIdx.put(0, 0);

        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            ps += normalize(nums[i]);
            if(!firstIdx.containsKey(ps)) {
                firstIdx.put(ps, i + 1);
            } else {
                int fIdx = firstIdx.get(ps);
                max = Math.max(i + 1 - fIdx, max);
            }
        }

        return max;
    }

    private int normalize(int val) {
        return val % 2 == 0 ? 1 : -1;
    }
}

package dev.alex.algorithmtraining.problems.week_41_october_2026;

import java.util.HashMap;
import java.util.Map;

public class Problem01 {
    /*
     * Given an integer array nums and an integer k, return the length of the
     * longest non-empty contiguous subarray whose elements sum to k.
     * Return 0 if no such subarray exists. Do not modify nums.
     *
     * Constraints:
     * - 1 <= nums.length <= 100000
     * - -10000 <= nums[i] <= 10000
     * - -1000000000 <= k <= 1000000000
     *
     * Examples:
     * - nums = [1, -1, 5, -2, 3], k = 3 returns 4:
     *   the subarray [1, -1, 5, -2] sums to 3.
     * - nums = [-2, -1, 2, 1], k = 1 returns 2.
     * - nums = [2, 4], k = 3 returns 0.
     */
    public int maxSubArrayLen(int[] nums, int k) {
        int longest = 0;
        int [] pSum = new int[nums.length + 1];
        Map<Integer, Integer> idxByPSum = new HashMap<>();
        idxByPSum.put(0, 0);
        for(int i = 0; i < nums.length; i++) {
            pSum[i + 1] = pSum[i] + nums[i];
            if(!idxByPSum.containsKey(pSum[i + 1])) {
                idxByPSum.put(pSum[i + 1], i + 1);
            }

            int possiblePSumOfSubArray = pSum[i + 1] - k;
            if (idxByPSum.containsKey(possiblePSumOfSubArray)) {
                int start = idxByPSum.get(possiblePSumOfSubArray);
                longest = Math.max(i + 1 - start, longest);
            }
        }

        return longest;
    }
}

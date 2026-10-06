package dev.alex.algorithmtraining.problems.week_41_october_2026;

import java.util.HashMap;
import java.util.Map;

public class Problem03 {
    /*
     * Given an array nums containing only 0 and 1, return the number of
     * non-empty contiguous subarrays containing equally many zeros and ones.
     * Subarrays with different start or end indices count separately.
     * Do not modify nums.
     *
     * Constraints:
     * - 1 <= nums.length <= 100000
     * - nums[i] is 0 or 1
     *
     * Examples:
     * - [0, 1] returns 1.
     * - [0, 1, 0, 1] returns 4: three length-two subarrays
     *   and the whole array.
     * - [1, 1, 1] returns 0.
     */
    public long countBalancedSubarrays(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        Map<Integer, Integer> psCounts = new HashMap<>();
        psCounts.put(0, 0);


        int pSum = 0;
        long count = 0;
        for(int i = 0; i < nums.length; i++) {
            int add = nums[i] == 0 ? -1 : 1;
            pSum += add;

            if(psCounts.containsKey(pSum)) {
                int was = psCounts.get(pSum);
                int now = was + 1;
                count += now;

                psCounts.put(pSum, now);
            } else {
                psCounts.put(pSum, 0);
            }
        }

        return count;

    }
}

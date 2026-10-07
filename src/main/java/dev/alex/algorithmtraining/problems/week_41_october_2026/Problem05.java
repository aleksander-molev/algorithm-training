package dev.alex.algorithmtraining.problems.week_41_october_2026;

import java.util.HashMap;
import java.util.Map;

public class Problem05 {
    /*
     * Return the number of non-empty contiguous subarrays containing equally
     * many strictly positive and strictly negative values. Zeros count as
     * neither positive nor negative, but may be included in a subarray.
     * Subarrays with different start or end positions count separately.
     * Do not modify nums.
     *
     * Constraints:
     * - 0 <= nums.length <= 100000
     * - -1000000000 <= nums[i] <= 1000000000
     *
     * Examples:
     * - [1, -2, 3, -4] returns 4.
     * - [0, 2, -3, 0] returns 6.
     * - [2, 4] returns 0.
     */
    public long countBalancedSubarrays(int[] nums) {
        int ps = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        long count = 0;
        for(int curr: nums) {
            int add = Integer.compare(curr, 0);
            ps += add;

            int value = 0;
            if(map.containsKey(ps)) {
                int now = map.get(ps) + 1;
                count += now;
                value = now;
            } else {
                value =  ps == 0 ? 1 : 0;
            }
            map.put(ps, value);
        }

        return count;
    }
}

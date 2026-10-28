package dev.alex.algorithmtraining.problems.week_44_october_2026;

import java.util.HashMap;
import java.util.Map;

public class Problem08 {
    /**
     * Return the number of nonempty contiguous subarrays whose sum equals target.
     * Values may be negative, positive, or zero. Different index ranges count
     * separately. Do not modify nums.
     * 0 <= nums.length <= 100000; each value is in [-1000000000,1000000000];
     * target is in [-100000000000000,100000000000000]. Return a long count.
     * Examples: ([1,2,1,2], 3) -> 3; ([3,-1,-2,3], 3) -> 3;
     * ([2,2,2], 4) -> 2.
     */
    public long countSegments(int[] nums, long target) {
        long ps =  0;
        Map<Long, Long> prefixSums = new HashMap<>();
        prefixSums.put(ps, 1L);
        long res = 0L;
        for(int n : nums) {
            ps += n;
            long seek = ps - target;
            if(prefixSums.containsKey(seek)) {
                long exists = prefixSums.get(seek);
                res += exists;
            }

            prefixSums.put(ps, prefixSums.getOrDefault(ps, 0L) + 1);
        }

        return res;
    }
}

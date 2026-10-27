package dev.alex.algorithmtraining.problems.week_44_october_2026;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem01 {
    /**
     * Return the k values closest to target from nums, counting duplicates separately.
     * Rank values by absolute distance to target; ties prefer the smaller value.
     * Return the selected values in ascending numeric order. Leave nums unchanged.
     * Constraints: 1 <= nums.length <= 100000; 1 <= k <= nums.length;
     * -1000000000 <= nums[i], target <= 1000000000. nums is not necessarily sorted.
     * Examples: [8,1,5,3,9], target=6, k=3 -> [3,5,8];
     * [4,2,6,8], target=5, k=2 -> [4,6]; [7,7,2,10], target=8, k=3 -> [7,7,10].
     */
    public int[] closest(int[] nums, int target, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            if(distance(n1, target) == distance(n2, target)) {
                return n2 - n1;
            } else  {
                return distance(n2, target) - distance(n1, target);
            }
        });
        for(int n : nums) {
            pq.add(n);
            if(pq.size() > k) {
                pq.remove();
            }
        }
        int [] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = pq.remove();
        }

        Arrays.sort(res);
        return res;
    }
    private int distance(int val, int target) {
        return Math.abs(val - target);
    }
}

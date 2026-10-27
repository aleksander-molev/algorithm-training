package dev.alex.algorithmtraining.problems.week_44_october_2026;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem03 {
    /**
     * Return the k distinct values that occur most frequently in nums.
     * Rank by decreasing frequency; ties prefer the smaller value.
     * Return the answer in that same rank order. Leave nums unchanged.
     * Constraints: 1 <= nums.length <= 100000; -1000000000 <= nums[i] <= 1000000000;
     * 1 <= k <= number of distinct values in nums.
     * Examples: [1,1,1,2,2,3], k=2 -> [1,2];
     * [4,4,2,2,9], k=2 -> [2,4]; [5,5,5,1,1,2,2], k=2 -> [5,1].
     */
    public int[] mostFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            if (map.get(n1).equals(map.get(n2))) {
                return n2 - n1;
            }
            return map.get(n1) - map.get(n2);
        });

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry.getKey());
            if(pq.size() > k) {
                pq.remove();
            }
        }
        int[] res = new int[k];
        while(k-- > 0) {
            res[k] = pq.remove();
        }

        return res;
    }
}

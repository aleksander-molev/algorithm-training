package dev.alex.algorithmtraining.problems.week_44_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem03Test {
    @Test void example1() {
        assertArrayEquals(new int[]{1,2}, new Problem03().mostFrequent(new int[]{1,1,1,2,2,3}, 2));
    }
    @Test void example2() {
        assertArrayEquals(new int[]{2,4}, new Problem03().mostFrequent(new int[]{4,4,2,2,9}, 2));
    }
    @Test void example3() {
        assertArrayEquals(new int[]{5,1}, new Problem03().mostFrequent(new int[]{5,5,5,1,1,2,2}, 2));
    }
    @Test void equalFrequenciesAbove127() {
        int[] nums = new int[258];
        java.util.Arrays.fill(nums, 0, 129, 1);
        java.util.Arrays.fill(nums, 129, 258, 2);
        assertArrayEquals(new int[]{1,2}, new Problem03().mostFrequent(nums, 2));
    }

    @Test void zeroNegativeValuesAndInputPreservation() {
        int[] nums = {0,-2,0,-2,5,5,1000000000,-1000000000};
        int[] original = nums.clone();
        Problem03 solution = new Problem03();
        assertArrayEquals(new int[]{-2,0,5}, solution.mostFrequent(nums, 3));
        assertArrayEquals(original, nums);
        assertArrayEquals(new int[]{7}, solution.mostFrequent(new int[]{7,7,7}, 1));
    }
    @Test void randomizedRankOracle() {
        java.util.Random random = new java.util.Random(2603);
        for (int trial = 0; trial < 300; trial++) {
            int distinct = 1 + random.nextInt(12);
            java.util.List<Integer> values = new java.util.ArrayList<>();
            for (int i = 0; i < distinct; i++) {
                int frequency = 125 + random.nextInt(8);
                for (int j = 0; j < frequency; j++) values.add(i * 17 - 90);
            }
            java.util.Collections.shuffle(values, random);
            int[] nums = values.stream().mapToInt(Integer::intValue).toArray();
            for (int k = 1; k <= distinct; k++) verifyRank(nums, k);
        }
    }

    @Test void maximumSize() {
        int[] nums = new int[100000];
        for (int i = 0; i < nums.length; i++) nums[i] = i - 50000;
        verifyRank(nums, 1);
        verifyRank(nums, 50000);
        verifyRank(nums, 100000);
        java.util.Arrays.fill(nums, 0, 50000, -1000000000);
        java.util.Arrays.fill(nums, 50000, 100000, 1000000000);
        verifyRank(nums, 1);
        verifyRank(nums, 2);
    }

    private void verifyRank(int[] nums, int k) {
        int[] original = nums.clone();
        java.util.Map<Integer, Integer> counts = new java.util.TreeMap<>();
        for (int value : nums) counts.merge(value, 1, Integer::sum);
        int[] expected = counts.keySet().stream()
                .sorted(java.util.Comparator.<Integer>comparingInt(counts::get)
                        .reversed().thenComparingInt(Integer::intValue))
                .limit(k).mapToInt(Integer::intValue).toArray();
        assertArrayEquals(expected, new Problem03().mostFrequent(nums, k));
        assertArrayEquals(original, nums, "Input must remain unchanged");
    }
}

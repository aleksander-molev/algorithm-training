package dev.alex.algorithmtraining.problems.week_41_october_2026;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem02Test {
    private final Problem02 solution = new Problem02();

    @Test
    void exampleOne() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = solution.removeDuplicates(nums);
        assertEquals(5, k);
        assertArrayEquals(new int[]{1, 1, 2, 2, 3}, Arrays.copyOf(nums, k));
    }

    @Test
    void exampleTwo() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int k = solution.removeDuplicates(nums);
        assertEquals(7, k);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 3, 3}, Arrays.copyOf(nums, k));
    }

    @Test
    void emptyArray() {
        assertEquals(0, solution.removeDuplicates(new int[0]));
    }

    @Test
    void shortArraysAndLongRuns() {
        check(new int[]{7}, new int[]{7});
        check(new int[]{7, 7}, new int[]{7, 7});
        check(new int[]{1, 2}, new int[]{1, 2});
        check(new int[]{-3, -3, -3, -3, -1, -1, -1, 0, 2, 2, 2},
                new int[]{-3, -3, -1, -1, 0, 2, 2});
    }

    @Test
    void matchesIndependentFrequencyOracle() {
        java.util.Random random = new java.util.Random(42);
        for (int trial = 0; trial < 500; trial++) {
            int[] nums = new int[1 + random.nextInt(40)];
            for (int i = 0; i < nums.length; i++) nums[i] = random.nextInt(11) - 5;
            Arrays.sort(nums);
            java.util.Map<Integer, Integer> counts = new java.util.TreeMap<>();
            for (int value : nums) counts.merge(value, 1, Integer::sum);
            java.util.List<Integer> expected = new java.util.ArrayList<>();
            counts.forEach((value, count) -> {
                for (int i = 0; i < Math.min(2, count); i++) expected.add(value);
            });
            check(nums, expected.stream().mapToInt(Integer::intValue).toArray());
        }
    }

    private void check(int[] nums, int[] expected) {
        String input = Arrays.toString(nums);
        int k = solution.removeDuplicates(nums);
        assertEquals(expected.length, k, input);
        assertArrayEquals(expected, Arrays.copyOf(nums, k), input);
    }
}

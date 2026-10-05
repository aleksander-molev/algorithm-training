package dev.alex.algorithmtraining.problems.week_41_october_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Problem01Test {
    private final Problem01 solution = new Problem01();

    @Test
    void longestMatchingSubarray() {
        assertEquals(4, solution.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
    }

    @Test
    void mixedSignedValues() {
        assertEquals(2, solution.maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));
    }

    @Test
    void noMatchingSubarray() {
        assertEquals(0, solution.maxSubArrayLen(new int[]{2, 4}, 3));
    }

    @Test
    void repeatedSumsAndZeroTarget() {
        assertEquals(5, solution.maxSubArrayLen(new int[]{1, -1, 1, -1, 3}, 3));
        assertEquals(4, solution.maxSubArrayLen(new int[]{0, 0, 0, 0}, 0));
        assertEquals(0, solution.maxSubArrayLen(new int[]{1}, 0));
        assertEquals(1, solution.maxSubArrayLen(new int[]{-3}, -3));
    }

    @Test
    void maximumAllowedSumAndInputPreservation() {
        int[] nums = new int[100000];
        java.util.Arrays.fill(nums, 10000);
        int[] original = nums.clone();
        assertEquals(100000, solution.maxSubArrayLen(nums, 1000000000));
        assertEquals(0, solution.maxSubArrayLen(nums, -1000000000));
        assertArrayEquals(original, nums);
    }

    @Test
    void matchesBruteForceOnSmallSignedArrays() {
        java.util.Random random = new java.util.Random(41);
        for (int trial = 0; trial < 500; trial++) {
            int[] nums = new int[1 + random.nextInt(15)];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = random.nextInt(11) - 5;
            }
            int k = random.nextInt(21) - 10;
            int expected = 0;
            for (int start = 0; start < nums.length; start++) {
                int sum = 0;
                for (int end = start; end < nums.length; end++) {
                    sum += nums[end];
                    if (sum == k) expected = Math.max(expected, end - start + 1);
                }
            }
            int[] original = nums.clone();
            assertEquals(expected, solution.maxSubArrayLen(nums, k),
                    "nums=" + java.util.Arrays.toString(nums) + ", k=" + k);
            assertArrayEquals(original, nums);
        }
    }
}

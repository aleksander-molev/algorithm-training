package dev.alex.algorithmtraining.problems.week_41_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem05Test {
    private final Problem05 solution = new Problem05();

    @Test
    void alternatingSigns() {
        assertEquals(4L, solution.countBalancedSubarrays(new int[]{1, -2, 3, -4}));
    }

    @Test
    void zerosMayBeIncluded() {
        assertEquals(6L, solution.countBalancedSubarrays(new int[]{0, 2, -3, 0}));
    }

    @Test
    void onlyPositiveValues() {
        assertEquals(0L, solution.countBalancedSubarrays(new int[]{2, 4}));
    }

    @Test
    void boundariesAndLargeAnswer() {
        assertEquals(0L, solution.countBalancedSubarrays(new int[]{}));
        assertEquals(1L, solution.countBalancedSubarrays(new int[]{0}));
        assertEquals(0L, solution.countBalancedSubarrays(new int[]{-1}));
        assertEquals(5000050000L, solution.countBalancedSubarrays(new int[100000]));
    }

    @Test
    void agreesWithDirectCountingAndPreservesInput() {
        java.util.Random random = new java.util.Random(7);
        for (int trial = 0; trial < 500; trial++) {
            int[] nums = new int[random.nextInt(20)];
            for (int i = 0; i < nums.length; i++) nums[i] = random.nextInt(7) - 3;
            int[] original = nums.clone();
            long expected = 0;
            for (int start = 0; start < nums.length; start++) {
                int positives = 0;
                int negatives = 0;
                for (int end = start; end < nums.length; end++) {
                    if (nums[end] > 0) positives++;
                    if (nums[end] < 0) negatives++;
                    if (positives == negatives) expected++;
                }
            }
            assertEquals(expected, solution.countBalancedSubarrays(nums),
                    java.util.Arrays.toString(nums));
            org.junit.jupiter.api.Assertions.assertArrayEquals(original, nums);
        }
    }
}

package dev.alex.algorithmtraining.problems.week_41_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem03Test {
    private final Problem03 solution = new Problem03();

    @Test
    void oneBalancedPair() {
        assertEquals(1L, solution.countBalancedSubarrays(new int[]{0, 1}));
    }

    @Test
    void overlappingSubarrays() {
        assertEquals(4L, solution.countBalancedSubarrays(new int[]{0, 1, 0, 1}));
    }

    @Test
    void noBalancedSubarrays() {
        assertEquals(0L, solution.countBalancedSubarrays(new int[]{1, 1, 1}));
    }

    @Test
    void maximumAlternatingInput() {
        int[] nums = new int[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i % 2;
        }
        assertEquals(2500000000L, solution.countBalancedSubarrays(nums));
    }

    @Test
    void smallInputsMatchDirectCountingAndPreserveInput() {
        java.util.Random random = new java.util.Random(6);
        for (int trial = 0; trial < 500; trial++) {
            int[] nums = new int[1 + random.nextInt(20)];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = random.nextInt(2);
            }
            int[] original = nums.clone();
            long expected = 0;
            for (int start = 0; start < nums.length; start++) {
                int zeros = 0;
                int ones = 0;
                for (int end = start; end < nums.length; end++) {
                    if (nums[end] == 0) zeros++;
                    else ones++;
                    if (zeros == ones) expected++;
                }
            }
            assertEquals(expected, solution.countBalancedSubarrays(nums),
                    java.util.Arrays.toString(nums));
            org.junit.jupiter.api.Assertions.assertArrayEquals(original, nums);
        }
    }
}

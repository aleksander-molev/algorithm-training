package dev.alex.algorithmtraining.problems.week_41_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem07Test {
    private final Problem07 solution = new Problem07();

    @Test
    void alternatingParity() {
        assertEquals(4, solution.longestBalancedSubarray(new int[]{2, 1, 4, 3, 6}));
    }

    @Test
    void noBalancedSubarray() {
        assertEquals(0, solution.longestBalancedSubarray(new int[]{1, 3, 5}));
    }

    @Test
    void nonAlternatingParity() {
        assertEquals(4, solution.longestBalancedSubarray(new int[]{2, 1, 3, 4, 6, 8}));
    }

    @Test
    void boundariesAndSignedValues() {
        assertEquals(0, solution.longestBalancedSubarray(new int[]{}));
        assertEquals(0, solution.longestBalancedSubarray(new int[]{0}));
        assertEquals(2, solution.longestBalancedSubarray(new int[]{2, 1}));
        assertEquals(4, solution.longestBalancedSubarray(new int[]{0, -3, -2, 5}));
    }

    @Test
    void agreesWithDirectEnumerationAndPreservesInput() {
        java.util.Random random = new java.util.Random(7);
        for (int trial = 0; trial < 500; trial++) {
            int[] nums = new int[random.nextInt(20)];
            for (int i = 0; i < nums.length; i++) nums[i] = random.nextInt(11) - 5;
            int[] original = nums.clone();
            int expected = 0;
            for (int start = 0; start < nums.length; start++) {
                int even = 0;
                int odd = 0;
                for (int end = start; end < nums.length; end++) {
                    if (nums[end] % 2 == 0) even++; else odd++;
                    if (even == odd) expected = Math.max(expected, end - start + 1);
                }
            }
            assertEquals(expected, solution.longestBalancedSubarray(nums),
                    java.util.Arrays.toString(nums));
            org.junit.jupiter.api.Assertions.assertArrayEquals(original, nums);
        }
    }
}

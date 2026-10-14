package dev.alex.algorithmtraining.problems.week_42_october_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Problem04Test {
    @Test
    void matchesDirectCircularSearchAndPreservesInput() {
        java.util.Random random = new java.util.Random(44);
        Problem04 solution = new Problem04();
        for (int trial = 0; trial < 1000; trial++) {
            int[] nums = new int[random.nextInt(25)];
            for (int i = 0; i < nums.length; i++) nums[i] = random.nextInt(21) - 10;
            int[] original = nums.clone();
            int[] expected = new int[nums.length];
            java.util.Arrays.fill(expected, -1);
            for (int i = 0; i < nums.length; i++) {
                for (int offset = 1; offset < nums.length; offset++) {
                    int candidate = nums[(i + offset) % nums.length];
                    if (candidate > nums[i]) {
                        expected[i] = candidate;
                        break;
                    }
                }
            }
            assertArrayEquals(expected, solution.nextGreaterElements(nums),
                    java.util.Arrays.toString(nums));
            assertArrayEquals(original, nums);
        }
    }

    @Test
    void handlesSingletonAndExtremeValues() {
        Problem04 solution = new Problem04();
        assertArrayEquals(new int[]{-1}, solution.nextGreaterElements(new int[]{7}));
        assertArrayEquals(new int[]{1000000000, -1, 1000000000},
                solution.nextGreaterElements(new int[]{-1000000000, 1000000000, -1}));
    }

    @Test
    void handlesMaximumLengthSequences() {
        Problem04 solution = new Problem04();
        int[] nums = new int[100000];
        int[] expected = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
            expected[i] = i + 1;
        }
        expected[expected.length - 1] = -1;
        assertArrayEquals(expected, solution.nextGreaterElements(nums));
        for (int i = 0; i < nums.length; i++) nums[i] = nums.length - i;
        java.util.Arrays.fill(expected, nums.length);
        expected[0] = -1;
        assertArrayEquals(expected, solution.nextGreaterElements(nums));
        java.util.Arrays.fill(nums, 5);
        java.util.Arrays.fill(expected, -1);
        assertArrayEquals(expected, solution.nextGreaterElements(nums));
    }

    @Test
    void usesFirstGreaterValueRatherThanGlobalMaximum() {
        assertArrayEquals(new int[]{5, -1, 3},
                new Problem04().nextGreaterElements(new int[]{3, 5, 1}));
    }

    @Test
    void doesNotUseEqualValueAsAnswer() {
        assertArrayEquals(new int[]{-1, -1},
                new Problem04().nextGreaterElements(new int[]{2, 2}));
    }

    @Test
    void findsFirstGreaterValueAcrossBoundary() {
        assertArrayEquals(new int[]{-1, 4, 5, 5},
                new Problem04().nextGreaterElements(new int[]{5, 3, 4, 2}));
    }

    @Test
    void handlesEmptyInput() {
        assertArrayEquals(new int[]{},
                new Problem04().nextGreaterElements(new int[]{}));
    }
    @Test
    void findsGreaterValueAfterWrapping() {
        assertArrayEquals(new int[]{2, -1, 2},
                new Problem04().nextGreaterElements(new int[]{1, 2, 1}));
    }
    @Test
    void findsGreaterValueExtended() {
        assertArrayEquals(new int[]{7, 4, 7, 7, 7, -1, 6, 7},
                new Problem04().nextGreaterElements(new int[]{5, 1, 4, 4, 2, 7, 3, 6}));
    }

    @Test
    void returnsFirstGreaterValue() {
        assertArrayEquals(new int[]{-1, 2, 3},
                new Problem04().nextGreaterElements(new int[]{3, 1, 2}));
    }

    @Test
    void requiresStrictlyGreaterValue() {
        assertArrayEquals(new int[]{3, 3, -1},
                new Problem04().nextGreaterElements(new int[]{2, 2, 3}));
    }
}

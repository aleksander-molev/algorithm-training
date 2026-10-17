package dev.alex.algorithmtraining.problems.week_42_october_2026;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem08Test {
    @Test
    void matchesOriginalValueFrequencies() {
        java.util.Random random = new java.util.Random(48);
        Problem08 solution = new Problem08();
        for (int trial = 0; trial < 1000; trial++) {
            int[] nums = new int[random.nextInt(60)];
            for (int i = 0; i < nums.length; i++) nums[i] = random.nextInt(31) - 15;
            Arrays.sort(nums);
            int[] original = nums.clone();
            int[] expected = Arrays.stream(original).filter(value ->
                    Arrays.stream(original).filter(other -> other == value).count() == 1).toArray();
            int k = solution.retainUnique(nums);
            assertEquals(expected.length, k, Arrays.toString(original));
            assertArrayEquals(expected, Arrays.copyOf(nums, k), Arrays.toString(original));
        }
        int[] nums = {-1000000000, 0, 1000000000};
        assertEquals(3, solution.retainUnique(nums));
        assertArrayEquals(new int[]{-1000000000, 0, 1000000000}, nums);
        assertEquals(1, solution.retainUnique(new int[]{7}));
    }

    @Test
    void handlesMaximumLengthGroupsAndDistinctValues() {
        Problem08 solution = new Problem08();
        int[] nums = new int[100000];
        for (int i = 0; i < nums.length; i++) nums[i] = i;
        int[] original = nums.clone();
        assertEquals(nums.length, solution.retainUnique(nums));
        assertArrayEquals(original, nums);
        for (int i = 0; i < nums.length; i++) nums[i] = i / 2;
        assertEquals(0, solution.retainUnique(nums));
        Arrays.fill(nums, 5);
        assertEquals(0, solution.retainUnique(nums));
    }

    @Test
    void handlesEmptyInput() {
        assertEquals(0, new Problem08().retainUnique(new int[]{}));
    }

    @Test
    void removesEntireRepeatedGroups() {
        int[] nums = {1, 1, 2, 3, 3, 4};
        int k = new Problem08().retainUnique(nums);
        assertEquals(2, k);
        assertArrayEquals(new int[]{2, 4}, Arrays.copyOf(nums, k));
    }

    @Test
    void retainsDistinctValues() {
        int[] nums = {1, 2, 3};
        int k = new Problem08().retainUnique(nums);
        assertEquals(3, k);
        assertArrayEquals(new int[]{1, 2, 3}, Arrays.copyOf(nums, k));
    }

    @Test
    void removesAllValuesWhenEveryValueRepeats() {
        assertEquals(0, new Problem08().retainUnique(new int[]{2, 2, 2, 5, 5}));
    }
}

package dev.alex.algorithmtraining.problems.week_40_september_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem01Test {
    private final Problem01 solution = new Problem01();

    @Test
    void exampleOne() {
        assertEquals(6, solution.longestOnes(
                new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    @Test
    void exampleTwo() {
        assertEquals(4, solution.longestOnes(new int[]{1, 0, 1, 1, 0, 1}, 1));
    }

    @Test
    void noChangesAllowed() {
        assertEquals(2, solution.longestOnes(new int[]{0, 1, 1, 0, 1}, 0));
        assertEquals(0, solution.longestOnes(new int[]{0}, 0));
    }

    @Test
    void consecutiveZeros() {
        assertEquals(2, solution.longestOnes(new int[]{0, 0, 0, 0}, 2));
    }

    @Test
    void laterRunIsLongest() {
        int[] nums = {1, 0, 1, 0, 1, 1, 1};
        assertEquals(5, solution.longestOnes(nums, 1));
        org.junit.jupiter.api.Assertions.assertArrayEquals(
                new int[]{1, 0, 1, 0, 1, 1, 1}, nums);
    }
}

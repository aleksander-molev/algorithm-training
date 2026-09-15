package dev.alex.algorithmtraining.problems.week_38_september_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem02Test {
    private final Problem02 solution = new Problem02();

    @Test
    void removesRepeatedValues() {
        int[] nums = {3, 2, 2, 3};

        int length = solution.removeElement(nums, 3);

        assertEquals(2, length);
        assertArrayEquals(new int[]{2, 2}, java.util.Arrays.copyOf(nums, length));
    }

    @Test
    void retainsTheRemainingValuesInOrder() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};

        int length = solution.removeElement(nums, 2);

        assertEquals(5, length);
        assertArrayEquals(new int[]{0, 1, 3, 0, 4}, java.util.Arrays.copyOf(nums, length));
    }
}

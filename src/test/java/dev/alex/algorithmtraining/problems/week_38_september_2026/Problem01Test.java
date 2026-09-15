package dev.alex.algorithmtraining.problems.week_38_september_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Problem01Test {
    private final Problem01 solution = new Problem01();

    @Test
    void findsTheRangeWhenTheTargetOccursSeveralTimes() {
        assertArrayEquals(new int[]{3, 4}, solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    @Test
    void returnsMissingRangeWhenTheTargetIsAbsent() {
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }

    @Test
    void handlesOneElement() {
        assertArrayEquals(new int[]{0, 0}, solution.searchRange(new int[]{1}, 1));
    }
}

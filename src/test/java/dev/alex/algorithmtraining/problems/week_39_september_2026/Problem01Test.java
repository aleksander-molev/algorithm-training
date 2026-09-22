package dev.alex.algorithmtraining.problems.week_39_september_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem01Test {
    private final Problem01 solution = new Problem01();

    @Test
    void findsShortestQualifyingSubarray() {
        assertEquals(2, solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    @Test
    void acceptsOneElementSubarray() {
        assertEquals(1, solution.minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    @Test
    void returnsZeroWhenNoSubarrayQualifies() {
        assertEquals(0, solution.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    void updatesMinimumWhileShrinkingAnOversizedWindow() {
        assertEquals(3, solution.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}

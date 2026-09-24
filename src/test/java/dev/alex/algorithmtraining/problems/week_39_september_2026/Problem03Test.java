package dev.alex.algorithmtraining.problems.week_39_september_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem03Test {
    private final Problem03 solution = new Problem03();

    @Test
    void findsMinimumInRotatedArray() {
        assertEquals(1, solution.findMin(new int[]{3, 4, 5, 1, 2}));
    }

    @Test
    void findsMinimumInLargerRotation() {
        assertEquals(0, solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    @Test
    void acceptsUnrotatedArray() {
        assertEquals(11, solution.findMin(new int[]{11, 13, 15, 17}));
    }
}

package dev.alex.algorithmtraining.problems.week_41_october_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem04Test {
    private final Problem04 solution = new Problem04();

    @Test
    void findsTargetInRotatedArray() {
        assertEquals(4, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    @Test
    void absentTarget() {
        assertEquals(-1, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    @Test
    void findsTargetWithoutRotation() {
        assertEquals(2, solution.search(new int[]{1, 3, 5, 7}, 5));
    }
}

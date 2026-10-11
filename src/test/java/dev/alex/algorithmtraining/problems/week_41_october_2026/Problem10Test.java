package dev.alex.algorithmtraining.problems.week_41_october_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Problem10Test {
    @Test
    void handlesLargeHourTotalsAndPreservesInput() {
        int[] piles = new int[100000];
        java.util.Arrays.fill(piles, 1000000000);
        int[] original = piles.clone();
        Problem10 solution = new Problem10();
        assertEquals(100000, solution.minEatingSpeed(piles, 1000000000));
        assertArrayEquals(original, piles);
        assertEquals(1000000000, solution.minEatingSpeed(piles, 100000));
        assertEquals(1, solution.minEatingSpeed(new int[]{1}, 1));
        assertEquals(1, solution.minEatingSpeed(new int[]{1000000000}, 1000000000));
    }

    @Test
    void matchesDirectSpeedEnumeration() {
        java.util.Random random = new java.util.Random(10);
        Problem10 solution = new Problem10();
        for (int trial = 0; trial < 500; trial++) {
            int[] piles = new int[1 + random.nextInt(8)];
            for (int i = 0; i < piles.length; i++) piles[i] = 1 + random.nextInt(30);
            int h = piles.length + random.nextInt(60);
            int expected = 1;
            while (true) {
                long hours = 0;
                for (int pile : piles) hours += (pile + expected - 1L) / expected;
                if (hours <= h) break;
                expected++;
            }
            assertEquals(expected, solution.minEatingSpeed(piles, h));
        }
    }

    @Test
    void finishesWithinEightHours() {
        assertEquals(4, new Problem10().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    @Test
    void hasOneHourPerPile() {
        assertEquals(30, new Problem10().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
    }

    @Test
    void hasOneExtraHour() {
        assertEquals(23, new Problem10().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }
}

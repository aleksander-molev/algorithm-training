package dev.alex.algorithmtraining.problems.week_42_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem02Test {
    @Test
    void shipsIncreasingWeights() {
        assertEquals(6, new Problem02().shipWithinDays(new int[]{1, 2, 3, 4, 5}, 3));
    }

    @Test
    void preservesPackageOrder() {
        assertEquals(6, new Problem02().shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
    }

    @Test
    void shipsEverythingInOneDay() {
        assertEquals(6, new Problem02().shipWithinDays(new int[]{1, 2, 3}, 1));
    }
}

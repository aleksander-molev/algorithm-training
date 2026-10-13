package dev.alex.algorithmtraining.problems.week_42_october_2026;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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

    @Test
    void shipsSingleMinimumWeightPackage() {
        assertEquals(1, new Problem02().shipWithinDays(new int[]{1}, 1));
    }

    @Test
    void supportsCapacityAboveExampleRange() {
        assertEquals(19, new Problem02().shipWithinDays(new int[]{19}, 1));
    }

    @Test
    void allowsOnePackagePerDay() {
        assertEquals(3, new Problem02().shipWithinDays(new int[]{1, 2, 3}, 3));
    }

    @Test
    void shipsMultipleMaximumWeightPackagesInOneDay() {
        assertEquals(20000, new Problem02().shipWithinDays(new int[]{10000, 10000}, 1));
    }

    @Test
    void matchesDirectCapacityEnumerationAndPreservesInput() {
        Random random = new Random(42);
        Problem02 solution = new Problem02();
        for (int trial = 0; trial < 500; trial++) {
            int[] weights = new int[1 + random.nextInt(8)];
            for (int i = 0; i < weights.length; i++) {
                weights[i] = 1 + random.nextInt(20);
            }
            int days = 1 + random.nextInt(weights.length);
            int[] original = weights.clone();
            int expected = Arrays.stream(weights).max().orElseThrow();
            while (true) {
                int shipments = 1;
                int load = 0;
                for (int weight : weights) {
                    if (load + weight > expected) {
                        shipments++;
                        load = 0;
                    }
                    load += weight;
                }
                if (shipments <= days) break;
                expected++;
            }
            assertEquals(expected, solution.shipWithinDays(weights, days),
                    Arrays.toString(weights) + ", days=" + days);
            assertArrayEquals(original, weights);
        }
    }

    @Test
    void handlesMaximumInputAndCapacity() {
        int[] weights = new int[100000];
        Arrays.fill(weights, 10000);
        Problem02 solution = new Problem02();
        assertEquals(1000000000, solution.shipWithinDays(weights, 1));
        assertEquals(10000, solution.shipWithinDays(weights, weights.length));
    }
}

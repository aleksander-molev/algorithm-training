package dev.alex.algorithmtraining.problems.week_42_october_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Problem07Test {
    @Test
    void matchesDirectEnumerationAndPreservesInput() {
        java.util.Random random = new java.util.Random(47);
        Problem07 solution = new Problem07();
        for (int trial = 0; trial < 500; trial++) {
            int[] prices = new int[random.nextInt(40)];
            for (int i = 0; i < prices.length; i++) prices[i] = 1 + random.nextInt(20);
            int[] original = prices.clone();
            int[] expected = new int[prices.length];
            for (int i = 0; i < prices.length; i++) {
                int j = i;
                while (j >= 0 && prices[j] <= prices[i]) j--;
                expected[i] = i - j;
            }
            assertArrayEquals(expected, solution.calculateSpans(prices));
            assertArrayEquals(original, prices);
        }
        assertArrayEquals(new int[]{1}, solution.calculateSpans(new int[]{1000000000}));
    }

    @Test
    void handlesMaximumLengthSequences() {
        Problem07 solution = new Problem07();
        int[] prices = new int[100000];
        int[] expected = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = i + 1;
            expected[i] = i + 1;
        }
        assertArrayEquals(expected, solution.calculateSpans(prices));
        java.util.Arrays.fill(prices, 1000000000);
        assertArrayEquals(expected, solution.calculateSpans(prices));
        for (int i = 0; i < prices.length; i++) prices[i] = prices.length - i;
        java.util.Arrays.fill(expected, 1);
        assertArrayEquals(expected, solution.calculateSpans(prices));
    }

    @Test
    void calculatesSpansForMixedPrices() {
        assertArrayEquals(new int[]{1, 1, 1, 2, 1, 4, 6},
                new Problem07().calculateSpans(new int[]{100, 80, 60, 70, 60, 75, 85}));
    }

    @Test
    void includesEqualPrices() {
        assertArrayEquals(new int[]{1, 2, 3},
                new Problem07().calculateSpans(new int[]{30, 30, 40}));
    }

    @Test
    void handlesDecreasingPrices() {
        assertArrayEquals(new int[]{1, 1, 1},
                new Problem07().calculateSpans(new int[]{90, 70, 50}));
    }
}

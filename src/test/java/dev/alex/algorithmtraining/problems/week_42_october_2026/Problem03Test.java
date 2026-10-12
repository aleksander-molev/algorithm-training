package dev.alex.algorithmtraining.problems.week_42_october_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Problem03Test {
    @Test
    void handlesMaximumLengthPriceSequences() {
        Problem03 solution = new Problem03();
        int[] prices = new int[100000];
        for (int i = 0; i < prices.length; i++) prices[i] = i + 1;
        int[] original = prices.clone();
        assertArrayEquals(original, solution.finalPrices(prices));
        assertArrayEquals(original, prices);

        java.util.Arrays.fill(prices, 1000000000);
        int[] expected = new int[prices.length];
        expected[expected.length - 1] = 1000000000;
        assertArrayEquals(expected, solution.finalPrices(prices));
    }

    @Test
    void matchesFirstEligiblePriceEnumeration() {
        java.util.Random random = new java.util.Random(43);
        Problem03 solution = new Problem03();
        for (int trial = 0; trial < 500; trial++) {
            int[] prices = new int[random.nextInt(20)];
            for (int i = 0; i < prices.length; i++) prices[i] = 1 + random.nextInt(20);
            int[] original = prices.clone();
            int[] expected = prices.clone();
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[j] <= prices[i]) {
                        expected[i] -= prices[j];
                        break;
                    }
                }
            }
            assertArrayEquals(expected, solution.finalPrices(prices),
                    java.util.Arrays.toString(prices));
            assertArrayEquals(original, prices);
        }
    }

    @Test
    void handlesEmptyInputAndExtremePrices() {
        Problem03 solution = new Problem03();
        assertArrayEquals(new int[]{}, solution.finalPrices(new int[]{}));
        assertArrayEquals(new int[]{1000000000},
                solution.finalPrices(new int[]{1000000000}));
        assertArrayEquals(new int[]{0, 999999999, 1},
                solution.finalPrices(new int[]{1000000000, 1000000000, 1}));
    }

    @Test
    void appliesFirstEligibleDiscount() {
        assertArrayEquals(new int[]{4, 2, 4, 2, 3},
                new Problem03().finalPrices(new int[]{8, 4, 6, 2, 3}));
    }

    @Test
    void acceptsEqualPrice() {
        assertArrayEquals(new int[]{0, 5, 7},
                new Problem03().finalPrices(new int[]{5, 5, 7}));
    }

    @Test
    void leavesPricesWithoutDiscount() {
        assertArrayEquals(new int[]{1, 2, 3},
                new Problem03().finalPrices(new int[]{1, 2, 3}));
    }
}

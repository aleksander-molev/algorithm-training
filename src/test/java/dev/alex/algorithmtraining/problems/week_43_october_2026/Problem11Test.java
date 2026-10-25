package dev.alex.algorithmtraining.problems.week_43_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem11Test {
    @Test void example1() {
        assertArrayEquals(new int[]{1,1,1,2,1,4,6}, new Problem11().spans(new int[]{100,80,60,70,60,75,85}));
    }
    @Test void example2() {
        assertArrayEquals(new int[]{1,2,3}, new Problem11().spans(new int[]{10,20,30}));
    }
    @Test void example3() {
        assertArrayEquals(new int[]{1,1,1}, new Problem11().spans(new int[]{30,20,10}));
    }
    @Test void boundariesEqualityAndRepeatedCalls() {
        Problem11 solution = new Problem11();
        verify(solution, new int[]{}, new int[]{});
        verify(solution, new int[]{1000000000}, new int[]{1});
        verify(solution, new int[]{50,50,50}, new int[]{1,2,3});
        verify(solution, new int[]{20,100,30}, new int[]{1,2,1});
        verify(solution, new int[]{1000000000,1,1,1000000000}, new int[]{1,1,2,4});
    }

    @Test void exhaustiveSmallInputs() {
        Problem11 solution = new Problem11();
        for (int length = 0; length <= 8; length++) {
            int combinations = 1;
            for (int i = 0; i < length; i++) combinations *= 3;
            for (int code = 0; code < combinations; code++) {
                int[] prices = new int[length];
                int remaining = code;
                for (int i = 0; i < length; i++) {
                    prices[i] = 1 + remaining % 3;
                    remaining /= 3;
                }
                int[] expected = new int[length];
                for (int i = 0; i < length; i++) {
                    int j = i;
                    while (j >= 0 && prices[j] <= prices[i]) j--;
                    expected[i] = i - j;
                }
                verify(solution, prices, expected);
            }
        }
    }

    @Test void maximumSizeInputs() {
        Problem11 solution = new Problem11();
        int n = 100000;
        int[] ascending = new int[n], descending = new int[n], equal = new int[n];
        int[] growing = new int[n], ones = new int[n];
        for (int i = 0; i < n; i++) {
            ascending[i] = i + 1;
            descending[i] = n - i;
            equal[i] = 1000000000;
            growing[i] = i + 1;
            ones[i] = 1;
        }
        verify(solution, ascending, growing);
        verify(solution, descending, ones);
        verify(solution, equal, growing);
        descending[n-1] = 1000000000;
        ones[n-1] = n;
        verify(solution, descending, ones);
    }

    private void verify(Problem11 solution, int[] prices, int[] expected) {
        int[] original = prices.clone();
        int[] actual = solution.spans(prices);
        assertArrayEquals(expected, actual);
        assertArrayEquals(original, prices, "Input must be unchanged");
        assertNotSame(prices, actual);
    }
}

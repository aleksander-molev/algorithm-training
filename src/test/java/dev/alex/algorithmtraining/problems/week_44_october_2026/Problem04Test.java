package dev.alex.algorithmtraining.problems.week_44_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem04Test {
    @Test void example1() {
        assertArrayEquals(new int[]{4,4,5,8}, new Problem04().ranks(new int[]{4,5,8,2,10,9}, 3));
    }
    @Test void example2() {
        assertArrayEquals(new int[]{5,5,5}, new Problem04().ranks(new int[]{5,5,4,6}, 2));
    }
    @Test void example3() {
        assertArrayEquals(new int[]{1,3,6}, new Problem04().ranks(new int[]{3,1,7,6}, 2));
    }
    @Test void boundariesAndRepeatedCalls() {
        verify(new int[]{7}, 1);
        verify(new int[]{-1000000000,1000000000,-1000000000,0}, 1);
        verify(new int[]{9,2,7,4}, 4);
        verify(new int[]{5,5,5,5}, 2);
        verify(new int[]{9,8,7,6,5}, 3);
        verify(new int[]{1,2,3,4,5}, 3);
    }

    @Test void randomizedPrefixSortingOracle() {
        java.util.Random random = new java.util.Random(2704);
        for (int trial = 0; trial < 300; trial++) {
            int[] arrivals = new int[1 + random.nextInt(35)];
            for (int i = 0; i < arrivals.length; i++) arrivals[i] = random.nextInt(21) - 10;
            for (int k = 1; k <= arrivals.length; k++) verify(arrivals, k);
        }
    }

    @Test void maximumSize() {
        int n = 100000, k = 50000;
        int[] arrivals = new int[n];
        for (int i = 0; i < n; i++) arrivals[i] = i;
        int[] expected = new int[n-k+1];
        for (int i = 0; i < expected.length; i++) expected[i] = i;
        check(new Problem04(), arrivals, k, expected);
        for (int i = 0; i < n; i++) arrivals[i] = n-i;
        java.util.Arrays.fill(expected, n-k+1);
        check(new Problem04(), arrivals, k, expected);
        java.util.Arrays.fill(arrivals, -1000000000);
        java.util.Arrays.fill(expected, -1000000000);
        check(new Problem04(), arrivals, k, expected);
    }

    private void verify(int[] arrivals, int k) {
        int[] expected = new int[arrivals.length-k+1];
        for (int length = k; length <= arrivals.length; length++) {
            int[] prefix = java.util.Arrays.copyOf(arrivals, length);
            java.util.Arrays.sort(prefix);
            expected[length-k] = prefix[length-k];
        }
        Problem04 solution = new Problem04();
        check(solution, arrivals, k, expected);
        check(solution, arrivals, k, expected);
    }

    private void check(Problem04 solution, int[] arrivals, int k, int[] expected) {
        int[] original = arrivals.clone();
        int[] actual = solution.ranks(arrivals, k);
        assertArrayEquals(expected, actual);
        assertArrayEquals(original, arrivals, "Input must remain unchanged");
        assertNotSame(arrivals, actual);
    }
}

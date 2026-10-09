package dev.alex.algorithmtraining.problems.week_41_october_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem08Test {
    private final Problem08 solution = new Problem08();

    @Test
    void matchingPartOfArrays() {
        assertEquals(2, solution.longestEqualSumSegment(
                new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 5}));
    }

    @Test
    void noMatchingSegment() {
        assertEquals(0, solution.longestEqualSumSegment(
                new int[]{1, 1, 1}, new int[]{2, 2, 2}));
    }

    @Test
    void wholeArraysMatch() {
        assertEquals(3, solution.longestEqualSumSegment(
                new int[]{3, 1, 2}, new int[]{1, 3, 2}));
    }

    @Test
    void matchingSegmentStartsAfterZero() {
        assertEquals(2, solution.longestEqualSumSegment(
                new int[]{5, 1, 2}, new int[]{9, 2, 1}));
    }

    @Test
    void matchingSegmentTouchesNeitherEnd() {
        assertEquals(2, solution.longestEqualSumSegment(
                new int[]{5, 1, 2, 5}, new int[]{9, 2, 1, 9}));
    }

    @Test
    void matchingSegmentIsOffCenter() {
        assertEquals(2, solution.longestEqualSumSegment(
                new int[]{5, 1, 2, 5, 5}, new int[]{9, 2, 1, 9, 9}));
    }

    @Test
    void largeSumsDoNotCreateFalseEquality() {
        assertEquals(0, solution.longestEqualSumSegment(
                new int[]{1000000000, 1000000000, 1000000000, 1000000000, 294967296},
                new int[]{0, 0, 0, 0, 0}));
    }

    @Test
    void boundariesAndMaximumSize() {
        assertEquals(0, solution.longestEqualSumSegment(new int[]{}, new int[]{}));
        assertEquals(1, solution.longestEqualSumSegment(new int[]{0}, new int[]{0}));
        assertEquals(0, solution.longestEqualSumSegment(new int[]{1}, new int[]{0}));
        int[] a = new int[100000];
        int[] b = new int[100000];
        java.util.Arrays.fill(a, 0, 50000, 1000000000);
        java.util.Arrays.fill(b, 50000, 100000, 1000000000);
        assertEquals(100000, solution.longestEqualSumSegment(a, b));
    }

    @Test
    void agreesWithDirectEnumerationAndPreservesInputs() {
        java.util.Random random = new java.util.Random(8);
        for (int trial = 0; trial < 500; trial++) {
            int n = random.nextInt(20);
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = random.nextInt(6);
                b[i] = random.nextInt(6);
            }
            int[] originalA = a.clone();
            int[] originalB = b.clone();
            int expected = 0;
            for (int left = 0; left < n; left++) {
                long sumA = 0, sumB = 0;
                for (int right = left; right < n; right++) {
                    sumA += a[right];
                    sumB += b[right];
                    if (sumA == sumB) expected = Math.max(expected, right - left + 1);
                }
            }
            assertEquals(expected, solution.longestEqualSumSegment(a, b));
            org.junit.jupiter.api.Assertions.assertArrayEquals(originalA, a);
            org.junit.jupiter.api.Assertions.assertArrayEquals(originalB, b);
        }
    }
}

package dev.alex.algorithmtraining.problems.week_43_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem10Test {
    @Test void example1() {
        assertEquals(java.util.List.of(0,6), new Problem10().findStarts("cbaebabacd", "abc"));
    }
    @Test void example2() {
        assertEquals(java.util.List.of(0,1,2), new Problem10().findStarts("abab", "ab"));
    }
    @Test void example3() {
        assertEquals(java.util.List.of(), new Problem10().findStarts("abcdef", "gh"));
    }
    @Test void surplusCharacterAfterDifferentLeftCharacter() {
        assertTimeoutPreemptively(java.time.Duration.ofSeconds(2), () ->
            assertEquals(java.util.List.of(), new Problem10().findStarts("abbc", "abc")));
    }

    @Test void boundariesAndRepeatedPatternCharacters() {
        Problem10 solution = new Problem10();
        assertEquals(java.util.List.of(), solution.findStarts("", "a"));
        assertEquals(java.util.List.of(), solution.findStarts("ab", "abc"));
        assertEquals(java.util.List.of(0,1,2), solution.findStarts("aaaa", "aa"));
        assertEquals(java.util.List.of(1), solution.findStarts("baa", "aa"));
    }
    @Test void missingRequiredCharacterAfterSurplus() {
        assertEquals(java.util.List.of(), new Problem10().findStarts("aaba", "abc"));
    }

    @Test void referenceComparisons() {
        java.util.Random random = new java.util.Random(20261023);
        Problem10 solution = new Problem10();
        for (int trial = 0; trial < 2000; trial++) {
            StringBuilder source = new StringBuilder();
            StringBuilder pattern = new StringBuilder();
            int n = random.nextInt(20);
            int m = 1 + random.nextInt(6);
            for (int j = 0; j < n; j++) source.append((char) ('a' + random.nextInt(3)));
            for (int j = 0; j < m; j++) pattern.append((char) ('a' + random.nextInt(3)));
            String s = source.toString(), p = pattern.toString();
            java.util.List<Integer> expected = new java.util.ArrayList<>();
            char[] sortedPattern = p.toCharArray();
            java.util.Arrays.sort(sortedPattern);
            for (int start = 0; start + m <= n; start++) {
                char[] candidate = s.substring(start, start + m).toCharArray();
                java.util.Arrays.sort(candidate);
                if (java.util.Arrays.equals(sortedPattern, candidate)) expected.add(start);
            }
            assertEquals(expected, solution.findStarts(s, p), "s=" + s + ", p=" + p);
        }
    }
    @Test void maximumSizeInputs() {
        Problem10 solution = new Problem10();
        java.util.List<Integer> expected = new java.util.ArrayList<>();
        for (int i = 0; i <= 99900; i++) expected.add(i);
        assertEquals(expected, solution.findStarts("a".repeat(100000), "a".repeat(100)));
        String pattern = "a".repeat(100000);
        assertEquals(java.util.List.of(0), solution.findStarts(pattern, pattern));
        assertEquals(java.util.List.of(), solution.findStarts("z".repeat(100000), "abcdefghijklmnopqrstuvwxy"));
        assertEquals(java.util.List.of(), solution.findStarts("a".repeat(100000), "ab"));
    }
}

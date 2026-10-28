package dev.alex.algorithmtraining.problems.week_44_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem07Test {
    @Test void example1() { assertEquals(7, new Problem07().longestSegment("aabacbebebe", 3)); }
    @Test void example2() { assertEquals(3, new Problem07().longestSegment("aaabbb", 1)); }
    @Test void example3() { assertEquals(11, new Problem07().longestSegment("abcadcacacaca", 3)); }
    @Test void fewerDistinctThanRequired() {
        assertEquals(0, new Problem07().longestSegment("aaaa", 2));
    }
    @Test void boundariesAndRepeatedCalls() {
        var solution = new Problem07();
        assertEquals(0, solution.longestSegment("", 1));
        assertEquals(1, solution.longestSegment("a", 1));
        assertEquals(6, solution.longestSegment("abcabc", 3));
        assertEquals(3, solution.longestSegment("aaabbc", 1));
    }
    @Test void generatedAgainstEnumeration() {
        var random = new java.util.Random(2807);
        var solution = new Problem07();
        for (int trial = 0; trial < 500; trial++) {
            var text = new StringBuilder();
            for (int n = random.nextInt(20); n > 0; n--) text.append((char) ('a' + random.nextInt(5)));
            String s = text.toString();
            for (int k = 1; k <= 6; k++) {
                int expected = 0;
                for (int left = 0; left < s.length(); left++) {
                    var distinct = new java.util.HashSet<Character>();
                    for (int right = left; right < s.length(); right++) {
                        distinct.add(s.charAt(right));
                        if (distinct.size() == k) expected = Math.max(expected, right - left + 1);
                    }
                }
                assertEquals(expected, solution.longestSegment(s, k), "s=" + s + ", k=" + k);
            }
        }
    }
    @Test void maximumLengthInputs() {
        var solution = new Problem07();
        assertEquals(100000, solution.longestSegment("a".repeat(100000), 1));
        assertEquals(0, solution.longestSegment("a".repeat(100000), 2));
        String alternating = "ab".repeat(50000);
        assertEquals(100000, solution.longestSegment(alternating, 2));
        assertEquals(1, solution.longestSegment(alternating, 1));
        String alphabet = "abcdefghijklmnopqrstuvwxyz".repeat(3846) + "abcd";
        assertEquals(100000, solution.longestSegment(alphabet, 26));
        assertEquals(25, solution.longestSegment(alphabet, 25));
    }
}

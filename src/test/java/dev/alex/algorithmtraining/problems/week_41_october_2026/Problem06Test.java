package dev.alex.algorithmtraining.problems.week_41_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem06Test {
    private final Problem06 solution = new Problem06();

    @Test
    void repeatedCharacterWithinSubstring() {
        assertEquals(3, solution.longestSubstring("eceba", 2));
    }

    @Test
    void oneDistinctCharacter() {
        assertEquals(2, solution.longestSubstring("aa", 1));
    }

    @Test
    void longestSubstringAppearsLater() {
        assertEquals(4, solution.longestSubstring("abaccc", 2));
    }

    @Test
    void boundariesAndMaximumInput() {
        assertEquals(0, solution.longestSubstring("", 0));
        assertEquals(0, solution.longestSubstring("abc", 0));
        assertEquals(1, solution.longestSubstring("a", 1));
        assertEquals(5, solution.longestSubstring("abcba", 26));
        assertEquals(100000, solution.longestSubstring("a".repeat(100000), 1));
        assertEquals(2, solution.longestSubstring("abcde".repeat(20000), 2));
    }

    @Test
    void agreesWithDirectEnumeration() {
        java.util.Random random = new java.util.Random(6);
        for (int trial = 0; trial < 500; trial++) {
            StringBuilder text = new StringBuilder();
            int length = random.nextInt(25);
            for (int i = 0; i < length; i++) text.append((char) ('a' + random.nextInt(5)));
            String s = text.toString();
            int k = random.nextInt(7);
            int expected = 0;
            for (int start = 0; start < s.length(); start++) {
                java.util.Set<Character> distinct = new java.util.HashSet<>();
                for (int end = start; end < s.length(); end++) {
                    distinct.add(s.charAt(end));
                    if (distinct.size() <= k) expected = Math.max(expected, end - start + 1);
                }
            }
            assertEquals(expected, solution.longestSubstring(s, k), "s=" + s + ", k=" + k);
        }
    }
}

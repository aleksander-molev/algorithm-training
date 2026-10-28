package dev.alex.algorithmtraining.problems.week_44_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem09Test {
    @Test void example1() { check("abbaca", "ca"); }
    @Test void example2() { check("azxxzy", "ay"); }
    @Test void example3() { check("aabccba", "a"); }
    @Test void boundariesAndCascades() {
        check("", ""); check("a", "a"); check("aa", "");
        check("aaa", "a"); check("abba", ""); check("abccba", "");
        check("aab", "b"); check("abc", "abc");
    }
    @Test void exhaustiveShortInputs() {
        for (int length = 0, count = 1; length <= 8; length++, count *= 3) {
            for (int code = 0; code < count; code++) {
                var input = new StringBuilder();
                int value = code;
                for (int i = 0; i < length; i++, value /= 3) input.append((char) ('a' + value % 3));
                String expected = input.toString();
                boolean removed;
                do {
                    removed = false;
                    for (int i = 0; i + 1 < expected.length(); i++) {
                        if (expected.charAt(i) == expected.charAt(i + 1)) {
                            expected = expected.substring(0, i) + expected.substring(i + 2);
                            removed = true;
                            break;
                        }
                    }
                } while (removed);
                check(input.toString(), expected);
            }
        }
    }
    @Test void maximumLengthInputs() {
        check("a".repeat(100000), "");
        check("ab".repeat(50000), "ab".repeat(50000));
        check("ab".repeat(25000) + "ba".repeat(25000), "");
    }
    private void check(String input, String expected) {
        char[] chars = input.toCharArray();
        int length = new Problem09().removePairs(chars);
        assertEquals(expected.length(), length);
        assertEquals(expected, new String(chars, 0, length));
    }
}

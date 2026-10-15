package dev.alex.algorithmtraining.problems.week_42_october_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Problem06Test {
    @Test
    void matchesMinimumRemovalEnumeration() {
        java.util.Random random = new java.util.Random(46);
        Problem06 solution = new Problem06();
        for (int trial = 0; trial < 500; trial++) {
            StringBuilder input = new StringBuilder();
            int length = random.nextInt(13);
            for (int i = 0; i < length; i++) input.append("()ab".charAt(random.nextInt(4)));
            String s = input.toString();
            int bestLength = 0;
            for (int mask = 0; mask < (1 << length); mask++) {
                StringBuilder candidate = new StringBuilder();
                boolean keepsLetters = true;
                for (int i = 0; i < length; i++) {
                    char ch = s.charAt(i);
                    if ((mask & (1 << i)) != 0) candidate.append(ch);
                    else if (ch != '(' && ch != ')') keepsLetters = false;
                }
                if (keepsLetters && valid(candidate.toString())) {
                    bestLength = Math.max(bestLength, candidate.length());
                }
            }
            String actual = solution.minRemoveToMakeValid(s);
            assertTrue(valid(actual), s + " -> " + actual);
            assertEquals(bestLength, actual.length(), s);
            assertEquals(s.replace("(", "").replace(")", ""),
                    actual.replace("(", "").replace(")", ""), s);
            int pos = 0;
            for (int i = 0; i < s.length() && pos < actual.length(); i++) {
                if (s.charAt(i) == actual.charAt(pos)) pos++;
            }
            assertEquals(actual.length(), pos, s);
        }
    }

    @Test
    void handlesEmptyAndMaximumLengthInputs() {
        Problem06 solution = new Problem06();
        assertEquals("", solution.minRemoveToMakeValid(""));
        assertEquals("abc", solution.minRemoveToMakeValid("abc"));
        assertEquals("", solution.minRemoveToMakeValid("(".repeat(100000)));
        assertEquals("", solution.minRemoveToMakeValid(")".repeat(100000)));
        String nested = "(".repeat(50000) + ")".repeat(50000);
        assertEquals(nested, solution.minRemoveToMakeValid(nested));
        assertEquals("a".repeat(99998),
                solution.minRemoveToMakeValid(")" + "a".repeat(99998) + "("));
    }

    private boolean valid(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') balance++;
            if (s.charAt(i) == ')' && --balance < 0) return false;
        }
        return balance == 0;
    }

    @Test
    void removesBothKindsOfUnmatchedParentheses() {
        assertEquals("", new Problem06().minRemoveToMakeValid(")("));
    }

    @Test
    void preservesLettersAfterSkippingClosingParenthesis() {
        assertEquals("ab", new Problem06().minRemoveToMakeValid(")a(b"));
    }

    @Test
    void removesUnmatchedClosingParenthesis() {
        assertEquals("ab(c)d", new Problem06().minRemoveToMakeValid("a)b(c)d"));
    }

    @Test
    void removesUnmatchedOpeningParenthesis() {
        assertEquals("ab", new Problem06().minRemoveToMakeValid("(ab"));
    }

    @Test
    void preservesValidInput() {
        assertEquals("(a)(b)", new Problem06().minRemoveToMakeValid("(a)(b)"));
    }
}

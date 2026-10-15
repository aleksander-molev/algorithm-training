package dev.alex.algorithmtraining.problems.week_42_october_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem05Test {
    @Test
    void handlesEmptyPlainAndMultidigitInputs() {
        Problem05 solution = new Problem05();
        assertEquals("", solution.decodeString(""));
        assertEquals("abc", solution.decodeString("abc"));
        assertEquals("ab".repeat(12), solution.decodeString("12[ab]"));
        assertEquals("", solution.decodeString("100[]"));
        assertEquals("x", solution.decodeString("1[1[1[x]]]"));
    }

    @Test
    void matchesGeneratedNestedExpressions() {
        java.util.Random random = new java.util.Random(45);
        Problem05 solution = new Problem05();
        for (int trial = 0; trial < 500; trial++) {
            int outer = 1 + random.nextInt(15);
            int inner = 1 + random.nextInt(15);
            int tail = 1 + random.nextInt(15);
            String encoded = "xy" + outer + "[a" + inner + "[bc]d]" + tail + "[z]q";
            String expected = "xy" + ("a" + "bc".repeat(inner) + "d").repeat(outer)
                    + "z".repeat(tail) + "q";
            assertEquals(expected, solution.decodeString(encoded), encoded);
        }
    }

    @Test
    void handlesMaximumDecodedLength() {
        assertEquals("abcdefghij".repeat(10000),
                new Problem05().decodeString("100[100[abcdefghij]]"));
    }

    @Test
    void decodesAdjacentConstructions() {
        assertEquals("aaabcbc", new Problem05().decodeString("3[a]2[bc]"));
    }

    @Test
    void decodesNestedConstructions() {
        assertEquals("abbbabbb", new Problem05().decodeString("2[a3[b]]"));
    }

    @Test
    void preservesSurroundingLetters() {
        assertEquals("xyzzq", new Problem05().decodeString("xy2[z]q"));
    }
}

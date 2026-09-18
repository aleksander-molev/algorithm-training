package dev.alex.algorithmtraining.problems.week_38_september_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Problem03Test {
    private final Problem03 solution = new Problem03();

    @Test
    void acceptsMatchingInputs() {
        assertTrue(solution.isAnagram("anagram", "nagaram"));
    }

    @Test
    void rejectsMismatchedInputs() {
        assertFalse(solution.isAnagram("rat", "car"));
    }

    @Test
    void rejectsDifferentCharacterCounts() {
        assertFalse(solution.isAnagram("aacc", "ccca"));
    }
}

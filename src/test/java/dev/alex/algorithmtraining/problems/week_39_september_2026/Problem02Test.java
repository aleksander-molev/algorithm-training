package dev.alex.algorithmtraining.problems.week_39_september_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Problem02Test {
    private final Problem02 solution = new Problem02();

    @Test
    void constructsWhenEveryLetterIsAvailable() {
        assertTrue(solution.canConstruct("aa", "aab"));
    }

    @Test
    void rejectsUnavailableLetter() {
        assertFalse(solution.canConstruct("a", "b"));
    }

    @Test
    void rejectsUnavailableDuplicate() {
        assertFalse(solution.canConstruct("aa", "ab"));
    }
}

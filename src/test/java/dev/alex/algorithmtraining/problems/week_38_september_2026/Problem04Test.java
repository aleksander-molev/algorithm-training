package dev.alex.algorithmtraining.problems.week_38_september_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem04Test {
    private final Problem04 solution = new Problem04();

    @Test
    void returnsExpectedLengthForRepeatedCharacters() {
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void returnsOneWhenAllCharactersMatch() {
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void allowsCharactersBeforeAndAfterARepeat() {
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void handlesAnEmptyInput() {
        assertEquals(0, solution.lengthOfLongestSubstring(""));
    }

    @Test
    void keepsTheValidSuffixAfterARepeat() {
        assertEquals(3, solution.lengthOfLongestSubstring("dvdf"));
    }
}

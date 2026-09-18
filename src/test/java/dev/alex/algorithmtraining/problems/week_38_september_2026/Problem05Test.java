package dev.alex.algorithmtraining.problems.week_38_september_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem05Test {
    private final Problem05 solution = new Problem05();

    @Test
    void returnsExpectedValueForAnIntermediateTarget() {
        assertEquals('f', solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
    }

    @Test
    void skipsEqualValues() {
        assertEquals('f', solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
    }

    @Test
    void returnsTheFirstValueWhenNeeded() {
        assertEquals('c', solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
    }

    @Test
    void skipsAllEqualValues() {
        assertEquals('j', solution.nextGreatestLetter(new char[]{'c', 'f', 'f', 'j'}, 'f'));
    }
}

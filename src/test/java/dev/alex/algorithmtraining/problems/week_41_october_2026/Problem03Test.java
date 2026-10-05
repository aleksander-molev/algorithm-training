package dev.alex.algorithmtraining.problems.week_41_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem03Test {
    private final Problem03 solution = new Problem03();

    @Test
    void oneBalancedPair() {
        assertEquals(1L, solution.countBalancedSubarrays(new int[]{0, 1}));
    }

    @Test
    void overlappingSubarrays() {
        assertEquals(4L, solution.countBalancedSubarrays(new int[]{0, 1, 0, 1}));
    }

    @Test
    void noBalancedSubarrays() {
        assertEquals(0L, solution.countBalancedSubarrays(new int[]{1, 1, 1}));
    }
}

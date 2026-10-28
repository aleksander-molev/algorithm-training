package dev.alex.algorithmtraining.problems.week_44_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem08Test {
    @Test void example1() { assertEquals(3L, new Problem08().countSegments(new int[]{1,2,1,2}, 3)); }
    @Test void example2() { assertEquals(3L, new Problem08().countSegments(new int[]{3,-1,-2,3}, 3)); }
    @Test void example3() { assertEquals(2L, new Problem08().countSegments(new int[]{2,2,2}, 4)); }
    @Test void sameStartTwoEndings() {
        assertEquals(2L, new Problem08().countSegments(new int[]{1,0}, 1));
    }
    @Test void sameEndTwoStarts() {
        assertEquals(2L, new Problem08().countSegments(new int[]{0,1}, 1));
    }
    @Test void zeroAndLongCounts() {
        assertEquals(6L, new Problem08().countSegments(new int[]{0,0,0}, 0));
        assertEquals(5000050000L, new Problem08().countSegments(new int[100000], 0));
    }
    @Test void largePrefixSumAndEmptyInput() {
        assertEquals(0L, new Problem08().countSegments(new int[]{}, 0));
        assertEquals(1L, new Problem08().countSegments(new int[]{1000000000,1000000000,1000000000}, 3000000000L));
    }
    @Test void smallGeneratedInputs() {
        var random = new java.util.Random(2808);
        var solution = new Problem08();
        for (int trial = 0; trial < 500; trial++) {
            int[] nums = random.ints(random.nextInt(13), -4, 5).toArray();
            long target = random.nextInt(17) - 8;
            long expected = 0;
            for (int left = 0; left < nums.length; left++) {
                long sum = 0;
                for (int right = left; right < nums.length; right++) {
                    sum += nums[right];
                    if (sum == target) expected++;
                }
            }
            int[] copy = nums.clone();
            assertEquals(expected, solution.countSegments(nums, target),
                    "nums=" + java.util.Arrays.toString(nums) + ", target=" + target);
            assertArrayEquals(copy, nums);
        }
    }
}

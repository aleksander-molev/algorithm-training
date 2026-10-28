package dev.alex.algorithmtraining.problems.week_44_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem10Test {
    @Test void example1() { assertEquals(9, new Problem10().kthMissing(new int[]{2,3,4,7,11}, 5)); }
    @Test void example2() { assertEquals(6, new Problem10().kthMissing(new int[]{1,2,3,4}, 2)); }
    @Test void example3() { assertEquals(5, new Problem10().kthMissing(new int[]{1,3,6}, 3)); }
    @Test void boundaries() {
        var solution = new Problem10();
        assertEquals(1, solution.kthMissing(new int[]{}, 1));
        assertEquals(5, solution.kthMissing(new int[]{}, 5));
        assertEquals(1, solution.kthMissing(new int[]{2}, 1));
        assertEquals(3, solution.kthMissing(new int[]{2}, 2));
    }
    @Test void exhaustiveSmallArrays() {
        var solution = new Problem10();
        for (int mask = 0; mask < 256; mask++) {
            var values = new java.util.ArrayList<Integer>();
            for (int v = 1; v <= 8; v++) if ((mask & (1 << (v - 1))) != 0) values.add(v);
            int[] nums = values.stream().mapToInt(Integer::intValue).toArray();
            for (int k = 1; k <= 10; k++) {
                int remaining = k, expected = 0;
                while (remaining > 0) if (!values.contains(++expected)) remaining--;
                int[] copy = nums.clone();
                assertEquals(expected, solution.kthMissing(nums, k),
                        "nums=" + values + ", k=" + k);
                assertArrayEquals(copy, nums);
            }
        }
    }
    @Test void maximumArrayLength() {
        int[] nums = java.util.stream.IntStream.rangeClosed(1, 100000).toArray();
        assertEquals(100010, new Problem10().kthMissing(nums, 10));
    }
}

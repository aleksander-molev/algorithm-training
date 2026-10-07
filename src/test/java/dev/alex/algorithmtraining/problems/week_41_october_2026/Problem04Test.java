package dev.alex.algorithmtraining.problems.week_41_october_2026;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem04Test {
    private final Problem04 solution = new Problem04();

    @Test
    void findsTargetInRotatedArray() {
        assertEquals(4, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    @Test
    void absentTarget() {
        assertEquals(-1, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    @Test
    void findsTargetWithoutRotation() {
        assertEquals(2, solution.search(new int[]{1, 3, 5, 7}, 5));
    }

    @Test
    void allSmallRotationsAndTargets() {
        for (int length = 1; length <= 40; length++) {
            for (int shift = 0; shift < length; shift++) {
                int[] nums = new int[length];
                for (int i = 0; i < length; i++) {
                    nums[i] = 2 * ((i + shift) % length) - length;
                }
                int[] original = nums.clone();
                for (int target = -length - 1; target <= length; target++) {
                    int expected = -1;
                    for (int i = 0; i < length; i++) {
                        if (nums[i] == target) expected = i;
                    }
                    assertEquals(expected, solution.search(nums, target),
                            "length=" + length + ", shift=" + shift + ", target=" + target);
                    org.junit.jupiter.api.Assertions.assertArrayEquals(original, nums);
                }
            }
        }
    }

    @Test
    void maximumInputAndExtremeValues() {
        int[] nums = new int[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ((i + 71357) % nums.length) * 10000 - 500000000;
        }
        for (int index : new int[]{0, 1, 28642, 28643, 50000, 99999}) {
            assertEquals(index, solution.search(nums, nums[index]));
        }
        assertEquals(-1, solution.search(nums, 1000000000));
        assertEquals(-1, solution.search(nums, -1000000000));
        assertEquals(1, solution.search(new int[]{1000000000, -1000000000}, -1000000000));
        assertEquals(0, solution.search(new int[]{1000000000, -1000000000}, 1000000000));
    }
}

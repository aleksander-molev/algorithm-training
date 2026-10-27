package dev.alex.algorithmtraining.problems.week_44_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem01Test {
    @Test void example1() {
        assertArrayEquals(new int[]{3,5,8}, new Problem01().closest(new int[]{8,1,5,3,9}, 6, 3));
    }
    @Test void example2() {
        assertArrayEquals(new int[]{4,6}, new Problem01().closest(new int[]{4,2,6,8}, 5, 2));
    }
    @Test void example3() {
        assertArrayEquals(new int[]{7,7,10}, new Problem01().closest(new int[]{7,7,2,10}, 8, 3));
    }
    @Test void boundariesAndInputPreservation() {
        verify(new int[]{7}, 7, 1);
        verify(new int[]{4,4,4,4}, 4, 3);
        verify(new int[]{-1000000000,1000000000,0,-999999999,999999999}, 1000000000, 3);
        verify(new int[]{-1000000000,1000000000,0,-999999999,999999999}, -1000000000, 3);
        verify(new int[]{-5,5,-3,3,-1,1}, 0, 3);
        verify(new int[]{9,-2,4,4,1}, 3, 5);
    }

    @Test void randomizedSortingOracle() {
        java.util.Random random = new java.util.Random(26);
        for (int trial = 0; trial < 500; trial++) {
            int[] nums = new int[1 + random.nextInt(40)];
            for (int i = 0; i < nums.length; i++) nums[i] = random.nextInt(41) - 20;
            int target = random.nextInt(61) - 30;
            for (int k = 1; k <= nums.length; k++) verify(nums, target, k);
        }
    }

    @Test void maximumSize() {
        int[] nums = new int[100000];
        for (int i = 0; i < nums.length; i++) nums[i] = i - 50000;
        verify(nums, 0, 1);
        verify(nums, 0, 49999);
        verify(nums, 1000000000, nums.length);
    }

    private void verify(int[] nums, int target, int k) {
        int[] original = nums.clone();
        Integer[] ranked = java.util.Arrays.stream(nums).boxed().toArray(Integer[]::new);
        java.util.Arrays.sort(ranked, java.util.Comparator
                .comparingLong((Integer value) -> Math.abs((long) value - target))
                .thenComparingInt(Integer::intValue));
        int[] expected = java.util.Arrays.stream(ranked).limit(k).mapToInt(Integer::intValue).sorted().toArray();
        int[] actual = new Problem01().closest(nums, target, k);
        assertArrayEquals(expected, actual);
        assertArrayEquals(original, nums, "Input must remain unchanged");
        assertNotSame(nums, actual);
    }
}

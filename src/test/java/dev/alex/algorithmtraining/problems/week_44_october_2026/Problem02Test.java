package dev.alex.algorithmtraining.problems.week_44_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem02Test {
    @Test void example1() {
        assertEquals(29L, new Problem02().remainingGifts(new int[]{25,64,9,4,100}, 4));
    }
    @Test void example2() {
        assertEquals(7L, new Problem02().remainingGifts(new int[]{16,9}, 2));
    }
    @Test void example3() {
        assertEquals(13L, new Problem02().remainingGifts(new int[]{81,4}, 1));
    }
    @Test void boundariesAndSquareRoots() {
        verify(new int[]{1000000000}, 0, 1000000000L);
        verify(new int[]{1}, 100000, 1L);
        verify(new int[]{15}, 1, 3L);
        verify(new int[]{16}, 1, 4L);
        verify(new int[]{17}, 1, 4L);
        verify(new int[]{999950883}, 1, 31621L);
        verify(new int[]{999950884}, 1, 31622L);
        verify(new int[]{999950885}, 1, 31622L);
        verify(new int[]{1000000000}, 1, 31622L);
        verify(new int[]{16,16,16}, 2, 24L);
    }

    @Test void randomizedDirectSimulation() {
        java.util.Random random = new java.util.Random(2602);
        for (int trial = 0; trial < 500; trial++) {
            int[] gifts = new int[1 + random.nextInt(30)];
            for (int i = 0; i < gifts.length; i++) gifts[i] = 1 + random.nextInt(1000000000);
            int operations = random.nextInt(100);
            int[] reference = gifts.clone();
            for (int step = 0; step < operations; step++) {
                int largest = 0;
                for (int i = 1; i < reference.length; i++) {
                    if (reference[i] > reference[largest]) largest = i;
                }
                int value = reference[largest];
                int low = 0, high = 31623;
                while (low + 1 < high) {
                    int mid = low + (high - low) / 2;
                    if ((long) mid * mid <= value) low = mid;
                    else high = mid;
                }
                reference[largest] = low;
            }
            long expected = 0;
            for (int value : reference) expected += value;
            verify(gifts, operations, expected);
        }
    }

    @Test void maximumSizeAndLongTotal() {
        int[] gifts = new int[100000];
        java.util.Arrays.fill(gifts, 1000000000);
        verify(gifts, 0, 100000000000000L);
        verify(gifts, 100000, 3162200000L);
        java.util.Arrays.fill(gifts, 1);
        verify(gifts, 100000, 100000L);
    }

    private void verify(int[] gifts, int operations, long expected) {
        int[] original = gifts.clone();
        assertEquals(expected, new Problem02().remainingGifts(gifts, operations));
        assertArrayEquals(original, gifts, "Input must remain unchanged");
    }
}

package dev.alex.algorithmtraining.problems.week_44_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem05Test {
    @Test void example1() {
        assertEquals(5, new Problem05().kthSmallest(new int[][]{{1,4,7},{2,5},{3,6}}, 5));
    }
    @Test void example2() {
        assertEquals(1, new Problem05().kthSmallest(new int[][]{{1,1,9},{},{1,3}}, 3));
    }
    @Test void example3() {
        assertEquals(8, new Problem05().kthSmallest(new int[][]{{-5,2},{0,8,10}}, 4));
    }
    @Test void boundariesAndRepeatedCalls() {
        verify(new int[][]{{},{7},{}}, 1);
        verify(new int[][]{{-1000000000,0,1000000000}, {}, {-1000000000,1000000000}}, 1);
        verify(new int[][]{{-1000000000,0,1000000000}, {}, {-1000000000,1000000000}}, 5);
        verify(new int[][]{{2,2},{2},{},{2,2,2}}, 4);
    }

    @Test void randomizedFlattenedSortingOracle() {
        java.util.Random random = new java.util.Random(2705);
        for (int trial = 0; trial < 300; trial++) {
            int[][] rows = new int[1 + random.nextInt(12)][];
            int total = 0;
            for (int r = 0; r < rows.length; r++) {
                rows[r] = new int[random.nextInt(9)];
                for (int i = 0; i < rows[r].length; i++) rows[r][i] = random.nextInt(31)-15;
                java.util.Arrays.sort(rows[r]);
                total += rows[r].length;
            }
            if (total == 0) { rows[0] = new int[]{3}; total = 1; }
            for (int k = 1; k <= total; k++) verify(rows, k);
        }
    }

    @Test void maximumSizeAndManyEmptyRows() {
        int[][] rows = new int[10000][];
        for (int r = 0; r < rows.length; r++) {
            rows[r] = new int[10];
            for (int i = 0; i < 10; i++) rows[r][i] = i*10000+r-50000;
        }
        verify(rows, 1);
        verify(rows, 50000);
        verify(rows, 100000);
        for (int r = 0; r < rows.length; r++) rows[r] = new int[0];
        rows[9999] = new int[]{-2,0,7};
        verify(rows, 2);
    }

    private void verify(int[][] rows, int k) {
        int[][] original = java.util.Arrays.stream(rows).map(int[]::clone).toArray(int[][]::new);
        int[] sorted = java.util.Arrays.stream(rows).flatMapToInt(java.util.Arrays::stream).sorted().toArray();
        Problem05 solution = new Problem05();
        assertEquals(sorted[k-1], solution.kthSmallest(rows, k));
        assertEquals(sorted[k-1], solution.kthSmallest(rows, k));
        for (int r = 0; r < rows.length; r++) assertArrayEquals(original[r], rows[r]);
    }
}

package dev.alex.algorithmtraining.problems.week_44_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem12Test {
    @Test void example1() {
        assertArrayEquals(new int[][]{{1,2},{1,4},{1,6}}, new Problem12().smallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3));
    }
    @Test void example2() {
        assertArrayEquals(new int[][]{{1,1},{1,1},{1,2},{1,2}}, new Problem12().smallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 4));
    }
    @Test void example3() {
        assertArrayEquals(new int[][]{{-2,-1},{-2,4},{3,-1}}, new Problem12().smallestPairs(new int[]{-2,3}, new int[]{-1,4}, 3));
    }
    @Test void equalSumFourOrdersByOriginalIndices() {
        int[] a = {0, 1, 3, 5, 5};
        int[] b = {0, 3, 4};
        int[][] expected = {{0,0}, {1,0}, {0,3}, {3,0}, {0,4}, {1,3}};

        assertArrayEquals(expected, new Problem12().smallestPairs(a, b, 6));
    }
    @Test void equalSumsFollowIndexOrder() {
        assertArrayEquals(new int[][]{{1,1},{1,2},{2,1},{2,2}},
                new Problem12().smallestPairs(new int[]{1,2}, new int[]{1,2}, 4));
    }
    @Test void equalSumsOutsideIntegerCache() {
        assertArrayEquals(new int[][]{{1000,1000},{1000,1001},{1001,1000},{1001,1001}},
                new Problem12().smallestPairs(new int[]{1000,1001}, new int[]{1000,1001}, 4));
    }
    @Test void equalSumFourOrdersByOriginalIndicesWithLargerValues() {
        int[] a = {1000, 1001, 1003, 1005, 1005};
        int[] b = {1000, 1003, 1004};
        int[][] expected = {{1000,1000}, {1001,1000}, {1000,1003},
                {1003,1000}, {1000,1004}, {1001,1003}};

        assertArrayEquals(expected, new Problem12().smallestPairs(a, b, 6));
    }
    @Test void smallSortedPairsOracle() {
        java.util.Random random = new java.util.Random(3012);
        for (int trial = 0; trial < 300; trial++) {
            int[] a = random.ints(2 + random.nextInt(4), 0, 6).sorted().toArray();
            int[] b = random.ints(2 + random.nextInt(4), 0, 6).sorted().toArray();
            java.util.List<int[]> indices = new java.util.ArrayList<>();
            for (int i = 0; i < a.length; i++)
                for (int j = 0; j < b.length; j++) indices.add(new int[]{i,j});
            indices.sort(java.util.Comparator.<int[]>comparingLong(p -> (long)a[p[0]] + b[p[1]])
                    .thenComparingInt(p -> p[0]).thenComparingInt(p -> p[1]));
            int k = Math.min(6, indices.size());
            int[][] expected = new int[k][2];
            for (int i = 0; i < k; i++) {
                int[] pair = indices.get(i);
                expected[i] = new int[]{a[pair[0]], b[pair[1]]};
            }
            int[][] actual = new Problem12().smallestPairs(a, b, k);
            assertArrayEquals(expected, actual, "a=" + java.util.Arrays.toString(a)
                    + ", b=" + java.util.Arrays.toString(b) + ", k=" + k
                    + ", actual=" + java.util.Arrays.deepToString(actual)
                    + ", expected=" + java.util.Arrays.deepToString(expected));
        }
    }
}

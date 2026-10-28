package dev.alex.algorithmtraining.problems.week_44_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem06Test {
    @Test void example1() { check(new int[][]{{1,4,7},{2,5},{3,6}}, new int[]{1,2,3,4,5,6,7}); }
    @Test void example2() { check(new int[][]{{1,3},{1,2},{2,4}}, new int[]{1,1,2,2,3,4}); }
    @Test void example3() { check(new int[][]{{-3,0},{-2,5}}, new int[]{-3,-2,0,5}); }
    @Test void nullableHeads() {
        check(new int[][]{{1,3},{},{2,4}}, new int[]{1,2,3,4});
    }
    @Test void emptyInputs() {
        check(new int[][]{}, new int[]{});
        check(new int[][]{{},{}}, new int[]{});
    }
    @Test void generatedNonemptyLists() {
        var random = new java.util.Random(2806);
        for (int trial = 0; trial < 300; trial++) {
            int[][] lists = new int[1 + random.nextInt(20)][];
            var original = new java.util.IdentityHashMap<Problem06.ListNode, Integer>();
        for (int i = 0; i < lists.length; i++) {
                lists[i] = new int[1 + random.nextInt(20)];
                for (int j = 0; j < lists[i].length; j++) lists[i][j] = random.nextInt(41) - 20;
                java.util.Arrays.sort(lists[i]);
            }
            int[] expected = java.util.Arrays.stream(lists).flatMapToInt(java.util.Arrays::stream).sorted().toArray();
            check(lists, expected);
        }
    }
    @Test void largeAndExtremeValues() {
        int[][] lists = new int[10000][10];
        for (int i = 0; i < lists.length; i++)
            for (int j = 0; j < 10; j++) lists[i][j] = j * 10000 + i;
        check(lists, java.util.stream.IntStream.range(0, 100000).toArray());
        check(new int[][]{{-1000000000,1000000000},{-1000000000,0,1000000000}},
                new int[]{-1000000000,-1000000000,0,1000000000,1000000000});
    }
    private void check(int[][] lists, int[] expected) {
        Problem06.ListNode[] heads = new Problem06.ListNode[lists.length];
        var original = new java.util.IdentityHashMap<Problem06.ListNode, Integer>();
        for (int i = 0; i < lists.length; i++) {
            Problem06.ListNode tail = null;
            for (int value : lists[i]) {
                var node = new Problem06.ListNode(value);
                original.put(node, value);
                if (tail == null) heads[i] = node; else tail.next = node;
                tail = node;
            }
        }
        var node = new Problem06().mergeLists(heads);
        for (int value : expected) {
            assertNotNull(node);
            assertEquals(value, node.val);
            assertEquals(Integer.valueOf(value), original.remove(node), "Must reuse each original node once");
            node = node.next;
        }
        assertNull(node);
        assertTrue(original.isEmpty());
    }
}

package dev.alex.algorithmtraining.problems.week_43_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem03Test {
    @Test
    void emptyAndSingleton() {
        Problem03 solution = new Problem03();
        assertNull(solution.groupByPosition(null));
        Problem03.ListNode only = new Problem03.ListNode(7);
        assertSame(only, solution.groupByPosition(only));
        assertEquals(7, only.val);
        assertNull(only.next);
    }

    @Test
    void variedLengthsPreserveStableGroupsAndOriginalNodes() {
        Problem03 solution = new Problem03();
        for (int length = 2; length <= 100; length++) {
            verifyGrouping(solution, length);
        }
    }

    @Test
    void maximumOddAndEvenLengths() {
        Problem03 solution = new Problem03();
        verifyGrouping(solution, 99999);
        verifyGrouping(solution, 100000);
    }

    private void verifyGrouping(Problem03 solution, int length) {
        Problem03.ListNode[] nodes = new Problem03.ListNode[length];
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            values[i] = switch (i % 4) {
                case 0 -> -1000000000;
                case 1 -> 1000000000;
                default -> 7;
            };
            nodes[i] = new Problem03.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem03.ListNode result = solution.groupByPosition(nodes[0]);
        for (int parity = 0; parity < 2; parity++) {
            for (int i = parity; i < length; i += 2) {
                assertSame(nodes[i], result, "length=" + length + ", original index=" + i);
                assertEquals(values[i], result.val);
                result = result.next;
            }
        }
        assertNull(result, "Output must contain exactly the original nodes and terminate");
    }

    @Test
    void example1() {
        int[] values = new int[] {1, 2, 3, 4, 5};
        Problem03.ListNode[] nodes = new Problem03.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem03.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem03.ListNode result = new Problem03().groupByPosition(nodes[0]);
        int[] order = new int[] {0, 2, 4, 1, 3};
        for (int index : order) {
            assertSame(nodes[index], result, "Expected the original node in the required position");
            assertEquals(values[index], result.val, "Node values must be preserved");
            result = result.next;
        }
        assertNull(result, "The resulting list must terminate");
    }

    @Test
    void example2() {
        int[] values = new int[] {2, 1, 3, 5, 6, 4};
        Problem03.ListNode[] nodes = new Problem03.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem03.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem03.ListNode result = new Problem03().groupByPosition(nodes[0]);
        int[] order = new int[] {0, 2, 4, 1, 3, 5};
        for (int index : order) {
            assertSame(nodes[index], result, "Expected the original node in the required position");
            assertEquals(values[index], result.val, "Node values must be preserved");
            result = result.next;
        }
        assertNull(result, "The resulting list must terminate");
    }

    @Test
    void example3() {
        int[] values = new int[] {4, 8, 2};
        Problem03.ListNode[] nodes = new Problem03.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem03.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem03.ListNode result = new Problem03().groupByPosition(nodes[0]);
        int[] order = new int[] {0, 2, 1};
        for (int index : order) {
            assertSame(nodes[index], result, "Expected the original node in the required position");
            assertEquals(values[index], result.val, "Node values must be preserved");
            result = result.next;
        }
        assertNull(result, "The resulting list must terminate");
    }

}

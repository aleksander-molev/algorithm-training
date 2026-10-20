package dev.alex.algorithmtraining.problems.week_43_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem05Test {
    @Test
    void example1() {
        int[] values = {1, 2, 3, 4};
        Problem05.ListNode[] nodes = new Problem05.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem05.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem05.ListNode result = new Problem05().reorder(nodes[0]);
        int[] order = {0, 3, 1, 2};
        for (int index : order) {
            assertSame(nodes[index], result, "Expected the original node in the required position");
            assertEquals(values[index], result.val, "Node values must be preserved");
            result = result.next;
        }
        assertNull(result, "The resulting list must terminate");
    }

    @Test
    void example2() {
        int[] values = {1, 2, 3, 4, 5};
        Problem05.ListNode[] nodes = new Problem05.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem05.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem05.ListNode result = new Problem05().reorder(nodes[0]);
        int[] order = {0, 4, 1, 3, 2};
        for (int index : order) {
            assertSame(nodes[index], result, "Expected the original node in the required position");
            assertEquals(values[index], result.val, "Node values must be preserved");
            result = result.next;
        }
        assertNull(result, "The resulting list must terminate");
    }

    @Test
    void example3() {
        int[] values = {8, 3, 7, 2, 9, 4};
        Problem05.ListNode[] nodes = new Problem05.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem05.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem05.ListNode result = new Problem05().reorder(nodes[0]);
        int[] order = {0, 5, 1, 4, 2, 3};
        for (int index : order) {
            assertSame(nodes[index], result, "Expected the original node in the required position");
            assertEquals(values[index], result.val, "Node values must be preserved");
            result = result.next;
        }
        assertNull(result, "The resulting list must terminate");
    }
    @Test
    void emptyAndSingleton() {
        Problem05 solution = new Problem05();
        assertNull(solution.reorder(null));
        Problem05.ListNode only = new Problem05.ListNode(7);
        assertSame(only, solution.reorder(only));
        assertEquals(7, only.val);
        assertNull(only.next);
    }

    @Test
    void variedLengthsAndRepeatedCalls() {
        Problem05 solution = new Problem05();
        for (int length = 2; length <= 100; length++) {
            verifyOrder(solution, length);
        }
    }

    @Test
    void maximumOddAndEvenLengths() {
        Problem05 solution = new Problem05();
        verifyOrder(solution, 99999);
        verifyOrder(solution, 100000);
    }

    private void verifyOrder(Problem05 solution, int length) {
        Problem05.ListNode[] nodes = new Problem05.ListNode[length];
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            values[i] = switch (i % 4) {
                case 0 -> -1000000000;
                case 1 -> 1000000000;
                default -> 7;
            };
            nodes[i] = new Problem05.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem05.ListNode result = solution.reorder(nodes[0]);
        for (int i = 0; i < length; i++) {
            int original = i % 2 == 0 ? i / 2 : length - 1 - i / 2;
            assertSame(nodes[original], result, "length=" + length + ", index=" + i);
            assertEquals(values[original], result.val);
            result = result.next;
        }
        assertNull(result, "Output must terminate after exactly the original nodes");
    }
}

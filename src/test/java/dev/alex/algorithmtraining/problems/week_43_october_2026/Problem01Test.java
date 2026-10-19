package dev.alex.algorithmtraining.problems.week_43_october_2026;

import dev.alex.algorithmtraining.model.ListNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem01Test {
    @Test
    void everyRemovalPositionPreservesOriginalNodesAndValues() {
        Problem01 solution = new Problem01();
        for (int length = 1; length <= 40; length++) {
            for (int n = 1; n <= length; n++) {
                verifyRemoval(solution, length, n);
            }
        }
    }

    @Test
    void maximumLengthHeadMiddleAndTailRemoval() {
        Problem01 solution = new Problem01();
        for (int n : new int[] {1, 50000, 100000}) {
            verifyRemoval(solution, 100000, n);
        }
    }

    private void verifyRemoval(Problem01 solution, int length, int n) {
        ListNode[] nodes = new ListNode[length];
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            values[i] = switch (i % 4) {
                case 0 -> -1000000000;
                case 1 -> 1000000000;
                default -> 7;
            };
            nodes[i] = new ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        ListNode result = solution.removeNthFromEnd(nodes[0], n);
        for (int i = 0; i < length; i++) {
            assertEquals(values[i], nodes[i].val);
            if (i == length - n) continue;
            assertSame(nodes[i], result, "length=" + length + ", n=" + n + ", index=" + i);
            result = result.next;
        }
        assertNull(result, "Output must contain exactly the surviving nodes and terminate");
    }

    @Test
    void removingOnlyNodeReturnsEmptyList() {
        assertNull(new Problem01().removeNthFromEnd(new ListNode(7), 1));
    }

    @Test
    void example1() {
        int[] values = new int[] {1, 2, 3, 4, 5};
        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        ListNode result = new Problem01().removeNthFromEnd(nodes[0], 2);
        int[] order = new int[] {0, 1, 2, 4};
        for (int index : order) {
            assertSame(nodes[index], result, "Expected the original node in the required position");
            assertEquals(values[index], result.val, "Node values must be preserved");
            result = result.next;
        }
        assertNull(result, "The resulting list must terminate");
    }

    @Test
    void example2() {
        int[] values = new int[] {7, 8, 9};
        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        ListNode result = new Problem01().removeNthFromEnd(nodes[0], 3);
        int[] order = new int[] {1, 2};
        for (int index : order) {
            assertSame(nodes[index], result, "Expected the original node in the required position");
            assertEquals(values[index], result.val, "Node values must be preserved");
            result = result.next;
        }
        assertNull(result, "The resulting list must terminate");
    }

    @Test
    void example3() {
        int[] values = new int[] {4, 5};
        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        ListNode result = new Problem01().removeNthFromEnd(nodes[0], 1);
        int[] order = new int[] {0};
        for (int index : order) {
            assertSame(nodes[index], result, "Expected the original node in the required position");
            assertEquals(values[index], result.val, "Node values must be preserved");
            result = result.next;
        }
        assertNull(result, "The resulting list must terminate");
    }

}

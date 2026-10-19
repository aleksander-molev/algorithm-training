package dev.alex.algorithmtraining.problems.week_43_october_2026;

import dev.alex.algorithmtraining.model.ListNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem02Test {
    @Test
    void emptyAndSingleton() {
        Problem02 solution = new Problem02();
        assertNull(solution.swapPairs(null));
        ListNode only = new ListNode(7);
        assertSame(only, solution.swapPairs(only));
        assertEquals(7, only.val);
        assertNull(only.next);
    }

    @Test
    void variedLengthsPreserveNodeIdentityValuesAndTermination() {
        Problem02 solution = new Problem02();
        for (int length = 2; length <= 100; length++) {
            verifyPairs(solution, length);
        }
    }

    @Test
    void maximumEvenAndOddLengths() {
        Problem02 solution = new Problem02();
        verifyPairs(solution, 100000);
        verifyPairs(solution, 99999);
    }

    private void verifyPairs(Problem02 solution, int length) {
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
        ListNode result = solution.swapPairs(nodes[0]);
        for (int position = 0; position < length; position++) {
            int original = position % 2 == 1 ? position - 1
                    : position + 1 < length ? position + 1 : position;
            assertSame(nodes[original], result);
            assertEquals(values[original], result.val);
            result = result.next;
        }
        assertNull(result);
    }

    @Test
    void example1() {
        int[] values = new int[] {1, 2, 3, 4};
        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        ListNode result = new Problem02().swapPairs(nodes[0]);
        int[] order = new int[] {1, 0, 3, 2};
        for (int index : order) {
            assertSame(nodes[index], result, "Expected the original node in the required position");
            assertEquals(values[index], result.val, "Node values must be preserved");
            result = result.next;
        }
        assertNull(result, "The resulting list must terminate");
    }

    @Test
    void example2() {
        int[] values = new int[] {5, 6, 7};
        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        ListNode result = new Problem02().swapPairs(nodes[0]);
        int[] order = new int[] {1, 0, 2};
        for (int index : order) {
            assertSame(nodes[index], result, "Expected the original node in the required position");
            assertEquals(values[index], result.val, "Node values must be preserved");
            result = result.next;
        }
        assertNull(result, "The resulting list must terminate");
    }

    @Test
    void example3() {
        int[] values = new int[] {8, 9};
        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        ListNode result = new Problem02().swapPairs(nodes[0]);
        int[] order = new int[] {1, 0};
        for (int index : order) {
            assertSame(nodes[index], result, "Expected the original node in the required position");
            assertEquals(values[index], result.val, "Node values must be preserved");
            result = result.next;
        }
        assertNull(result, "The resulting list must terminate");
    }

}

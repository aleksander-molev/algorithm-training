package dev.alex.algorithmtraining.problems.week_43_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem04Test {
    @Test
    void example1() {
        int[] values = {1, 2, 3, 4, 5};
        Problem04.ListNode[] nodes = new Problem04.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem04.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem04.ListNode result = new Problem04().reverseSection(nodes[0], 2, 4);
        int[] order = {0, 3, 2, 1, 4};
        for (int index : order) {
            assertSame(nodes[index], result, "Expected the original node in the required position");
            assertEquals(values[index], result.val, "Node values must be preserved");
            result = result.next;
        }
        assertNull(result, "The resulting list must terminate");
    }

    @Test
    void example2() {
        int[] values = {3, 6, 9, 12};
        Problem04.ListNode[] nodes = new Problem04.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem04.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem04.ListNode result = new Problem04().reverseSection(nodes[0], 1, 3);
        int[] order = {2, 1, 0, 3};
        for (int index : order) {
            assertSame(nodes[index], result, "Expected the original node in the required position");
            assertEquals(values[index], result.val, "Node values must be preserved");
            result = result.next;
        }
        assertNull(result, "The resulting list must terminate");
    }

    @Test
    void example3() {
        int[] values = {5, 8, 11};
        Problem04.ListNode[] nodes = new Problem04.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem04.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem04.ListNode result = new Problem04().reverseSection(nodes[0], 2, 2);
        int[] order = {0, 1, 2};
        for (int index : order) {
            assertSame(nodes[index], result, "Expected the original node in the required position");
            assertEquals(values[index], result.val, "Node values must be preserved");
            result = result.next;
        }
        assertNull(result, "The resulting list must terminate");
    }
    @Test
    void everySectionOfSmallLists() {
        Problem04 solution = new Problem04();
        for (int length = 1; length <= 40; length++) {
            for (int left = 1; left <= length; left++) {
                for (int right = left; right <= length; right++) {
                    verifySection(solution, length, left, right);
                }
            }
        }
    }

    @Test
    void maximumLengthSections() {
        Problem04 solution = new Problem04();
        verifySection(solution, 100000, 1, 100000);
        verifySection(solution, 100000, 1, 50000);
        verifySection(solution, 100000, 50000, 100000);
        verifySection(solution, 100000, 25000, 75000);
        verifySection(solution, 100000, 100000, 100000);
    }

    private void verifySection(Problem04 solution, int length, int left, int right) {
        Problem04.ListNode[] nodes = new Problem04.ListNode[length];
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            values[i] = switch (i % 4) {
                case 0 -> -1000000000;
                case 1 -> 1000000000;
                default -> 7;
            };
            nodes[i] = new Problem04.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem04.ListNode result = solution.reverseSection(nodes[0], left, right);
        for (int i = 0; i < length; i++) {
            int original = i >= left - 1 && i < right ? left + right - 2 - i : i;
            assertSame(nodes[original], result,
                    "length=" + length + ", left=" + left + ", right=" + right + ", index=" + i);
            assertEquals(values[original], result.val);
            result = result.next;
        }
        assertNull(result, "Output must terminate after exactly the original nodes");
    }
}

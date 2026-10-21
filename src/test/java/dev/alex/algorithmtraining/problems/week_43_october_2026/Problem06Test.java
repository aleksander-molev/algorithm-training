package dev.alex.algorithmtraining.problems.week_43_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem06Test {
    @Test
    void example1() {
        int[] values = {1, 2, 3, 4, 5};
        Problem06.ListNode[] nodes = new Problem06.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem06.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem06.ListNode result = new Problem06().rotateRight(nodes[0], 2);
        int[] order = {3, 4, 0, 1, 2};
        for (int index : order) {
            assertSame(nodes[index], result);
            assertEquals(values[index], result.val);
            result = result.next;
        }
        assertNull(result, "Output must terminate");
    }

    @Test
    void example2() {
        int[] values = {2, 4, 6};
        Problem06.ListNode[] nodes = new Problem06.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem06.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem06.ListNode result = new Problem06().rotateRight(nodes[0], 4);
        int[] order = {2, 0, 1};
        for (int index : order) {
            assertSame(nodes[index], result);
            assertEquals(values[index], result.val);
            result = result.next;
        }
        assertNull(result, "Output must terminate");
    }

    @Test
    void example3() {
        int[] values = {7, 8, 9};
        Problem06.ListNode[] nodes = new Problem06.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem06.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem06.ListNode result = new Problem06().rotateRight(nodes[0], 0);
        int[] order = {0, 1, 2};
        for (int index : order) {
            assertSame(nodes[index], result);
            assertEquals(values[index], result.val);
            result = result.next;
        }
        assertNull(result, "Output must terminate");
    }

    @Test
    void emptyListWithPositiveRotation() {
        assertNull(new Problem06().rotateRight(null, 3));
    }

    @Test
    void fullLengthRotation() {
        Problem06.ListNode a = new Problem06.ListNode(1);
        Problem06.ListNode b = new Problem06.ListNode(2);
        Problem06.ListNode c = new Problem06.ListNode(3);
        a.next = b;
        b.next = c;
        assertSame(a, new Problem06().rotateRight(a, 3));
        assertSame(b, a.next);
        assertSame(c, b.next);
        assertNull(c.next);
    }

    @Test
    void singletonWithPositiveRotation() {
        Problem06.ListNode node = new Problem06.ListNode(7);
        assertSame(node, new Problem06().rotateRight(node, 1));
        assertNull(node.next);
    }
    @Test
    void rotationsPreserveOriginalNodesAndValues() {
        Problem06 solution = new Problem06();
        for (int length = 0; length <= 40; length++) {
            for (int k = 0; k <= 3 * length + 1; k++) {
                verifyRotation(solution, length, k);
            }
            verifyRotation(solution, length, 1000000000);
        }
    }

    @Test
    void maximumLengthRotations() {
        Problem06 solution = new Problem06();
        for (int k : new int[] {0, 1, 50000, 99999, 100000, 100001, 999999999, 1000000000}) {
            verifyRotation(solution, 100000, k);
        }
    }

    private void verifyRotation(Problem06 solution, int length, int k) {
        Problem06.ListNode[] nodes = new Problem06.ListNode[length];
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            values[i] = switch (i % 4) {
                case 0 -> -1000000000;
                case 1 -> 1000000000;
                default -> 7;
            };
            nodes[i] = new Problem06.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem06.ListNode result = solution.rotateRight(length == 0 ? null : nodes[0], k);
        for (int i = 0; i < length; i++) {
            int index = (i + length - k % length) % length;
            assertSame(nodes[index], result, "length=" + length + ", k=" + k + ", index=" + i);
            assertEquals(values[index], result.val);
            result = result.next;
        }
        assertNull(result, "Output must terminate after exactly the original nodes");
    }
}

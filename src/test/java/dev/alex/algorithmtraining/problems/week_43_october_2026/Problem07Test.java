package dev.alex.algorithmtraining.problems.week_43_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem07Test {
    @Test
    void example1() {
        int[] values = {1, 2, 3, 3, 4, 4, 5};
        Problem07.ListNode[] nodes = new Problem07.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem07.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem07.ListNode result = new Problem07().retainUnique(nodes[0]);
        int[] order = {0, 1, 6};
        for (int index : order) {
            assertSame(nodes[index], result);
            assertEquals(values[index], result.val);
            result = result.next;
        }
        assertNull(result, "Output must terminate");
    }

    @Test
    void example2() {
        int[] values = {1, 1, 1, 2, 3};
        Problem07.ListNode[] nodes = new Problem07.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem07.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem07.ListNode result = new Problem07().retainUnique(nodes[0]);
        int[] order = {3, 4};
        for (int index : order) {
            assertSame(nodes[index], result);
            assertEquals(values[index], result.val);
            result = result.next;
        }
        assertNull(result, "Output must terminate");
    }

    @Test
    void example3() {
        int[] values = {2, 2, 4, 4};
        Problem07.ListNode[] nodes = new Problem07.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem07.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem07.ListNode result = new Problem07().retainUnique(nodes[0]);
        int[] order = {};
        for (int index : order) {
            assertSame(nodes[index], result);
            assertEquals(values[index], result.val);
            result = result.next;
        }
        assertNull(result, "Output must terminate");
    }

    @Test
    void emptySingletonAndExtremeValues() {
        Problem07 solution = new Problem07();
        verify(solution, new int[] {});
        verify(solution, new int[] {7});
        verify(solution, new int[] {-1000000000, -1000000000, 0, 1000000000});
    }

    @Test
    void everySmallGroupCombination() {
        Problem07 solution = new Problem07();
        for (int mask = 0; mask < 4096; mask++) {
            java.util.List<Integer> values = new java.util.ArrayList<>();
            int counts = mask;
            for (int value = -3; value <= 2; value++) {
                int count = counts % 4;
                counts /= 4;
                for (int j = 0; j < count; j++) values.add(value);
            }
            verify(solution, values.stream().mapToInt(Integer::intValue).toArray());
        }
    }

    @Test
    void maximumLengthInputs() {
        Problem07 solution = new Problem07();
        int[] values = new int[100000];
        verify(solution, values);
        for (int i = 0; i < values.length; i++) values[i] = i;
        verify(solution, values);
        for (int i = 0; i < values.length; i++) values[i] = i / 2;
        verify(solution, values);
        for (int i = 0; i < values.length; i++) values[i] = (i / 3) * 2 + (i % 3 == 2 ? 1 : 0);
        verify(solution, values);
    }

    private void verify(Problem07 solution, int[] values) {
        Problem07.ListNode[] nodes = new Problem07.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem07.ListNode(values[i]);
            if (i > 0) nodes[i - 1].next = nodes[i];
        }
        Problem07.ListNode result = solution.retainUnique(values.length == 0 ? null : nodes[0]);
        for (int i = 0; i < values.length; i++) {
            boolean unique = (i == 0 || values[i - 1] != values[i])
                    && (i + 1 == values.length || values[i + 1] != values[i]);
            if (unique) {
                assertSame(nodes[i], result, "Wrong survivor at input index " + i);
                result = result.next;
            }
            assertEquals(values[i], nodes[i].val, "Node values must be preserved");
        }
        assertNull(result, "Output must terminate after the unique nodes");
    }
}

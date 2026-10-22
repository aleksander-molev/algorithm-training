package dev.alex.algorithmtraining.problems.week_43_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem09Test {
    @Test void evenPalindrome() { check(new int[]{1,2,2,1}, true); }
    @Test void notPalindrome() { check(new int[]{1,2,3}, false); }
    @Test void oddPalindrome() { check(new int[]{4,7,4}, true); }

    @Test void emptyInput() { check(new int[]{}, true); }
    @Test void singletonInput() { check(new int[]{7}, true); }

    @Test void allSmallBinaryLists() {
        for (int length = 2; length <= 12; length++) {
            for (int mask = 0; mask < (1 << length); mask++) {
                int[] values = new int[length];
                for (int i = 0; i < length; i++) values[i] = (mask >>> i) & 1;
                boolean expected = true;
                for (int i = 0; i < length / 2; i++) {
                    if (values[i] != values[length - 1 - i]) expected = false;
                }
                check(values, expected);
            }
        }
    }

    @Test void maximumSizeAndExtremeValues() {
        int[] values = new int[100000];
        for (int i = 0; i < values.length / 2; i++) {
            values[i] = i % 2 == 0 ? -1000000000 : 1000000000;
            values[values.length - 1 - i] = values[i];
        }
        check(values, true);
        values[values.length - 1] = 0;
        check(values, false);
    }

    private void check(int[] values, boolean expected) {
        Problem09.ListNode[] nodes = new Problem09.ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Problem09.ListNode(values[i]);
            if (i > 0) nodes[i-1].next = nodes[i];
        }
        assertEquals(expected, new Problem09().isPalindrome(nodes.length == 0 ? null : nodes[0]));
        for (int i = 0; i < nodes.length; i++) {
            assertEquals(values[i], nodes[i].val);
            assertSame(i+1 < nodes.length ? nodes[i+1] : null, nodes[i].next);
        }
    }
}

package dev.alex.algorithmtraining.problems.week_43_october_2026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem08Test {
    private final Problem08 solution = new Problem08();
    @Test
    void example1() {
        Problem08.ListNode shared = chain(8, 9);
        Problem08.ListNode a = chain(1, 2);
        Problem08.ListNode b = chain(3);
        a.next.next = shared;
        b.next = shared;
        verify(a, b, shared);
    }

    @Test
    void example2() {
        Problem08.ListNode shared = chain(7, 10);
        Problem08.ListNode a = chain(4);
        Problem08.ListNode b = chain(5, 6);
        a.next = shared;
        b.next.next = shared;
        verify(a, b, shared);
    }

    @Test
    void example3() {
        verify(chain(1, 2), chain(1, 2), null);
    }

    private Problem08.ListNode chain(int... values) {
        Problem08.ListNode head = null;
        Problem08.ListNode tail = null;
        for (int value : values) {
            Problem08.ListNode node = new Problem08.ListNode(value);
            if (head == null) head = node;
            else tail.next = node;
            tail = node;
        }
        return head;
    }

    private void verify(Problem08.ListNode a, Problem08.ListNode b,
                        Problem08.ListNode expected) {
        java.util.Map<Problem08.ListNode, Problem08.ListNode> links = new java.util.IdentityHashMap<>();
        java.util.Map<Problem08.ListNode, Integer> values = new java.util.IdentityHashMap<>();
        for (Problem08.ListNode head : new Problem08.ListNode[] {a, b}) {
            for (Problem08.ListNode node = head; node != null; node = node.next) {
                links.put(node, node.next);
                values.put(node, node.val);
            }
        }
        assertSame(expected, solution.findIntersection(a, b));
        links.forEach((node, next) -> assertSame(next, node.next, "Links must remain unchanged"));
        values.forEach((node, value) -> assertEquals(value.intValue(), node.val));
    }
    @Test
    void allSmallPrefixAndSuffixLengths() {
        for (int a = 0; a <= 8; a++) {
            for (int b = 0; b <= 8; b++) {
                for (int shared = 0; shared <= 8; shared++) {
                    verifyShape(a, b, shared);
                }
            }
        }
    }

    @Test
    void maximumLengthLists() {
        verifyShape(100000, 100000, 0);
        verifyShape(99999, 0, 1);
        verifyShape(0, 99999, 1);
        verifyShape(0, 0, 100000);
        verifyShape(50000, 1, 50000);
        verifyShape(0, 100000, 0);
    }

    private void verifyShape(int prefixA, int prefixB, int suffixLength) {
        Problem08.ListNode shared = prepend(suffixLength, null);
        verify(prepend(prefixA, shared), prepend(prefixB, shared), shared);
    }

    private Problem08.ListNode prepend(int count, Problem08.ListNode suffix) {
        Problem08.ListNode head = suffix;
        for (int i = 0; i < count; i++) {
            Problem08.ListNode node = new Problem08.ListNode(i % 3 == 0 ? -7 : 7);
            node.next = head;
            head = node;
        }
        return head;
    }
}

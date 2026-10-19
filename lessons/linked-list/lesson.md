# Linked Lists: references, rewiring, and traversal

Introduced October 17, 2026. Goal: explain pointer roles, preserve reachability while rewiring, use dummy heads, and recognize fast/slow traversal. Applications include reversal, stable rearrangement, merging sorted chains, and cycle detection.

## Core model

A singly linked node stores a value and a reference to its successor. `head` is a reference to the first node; `null` ends an acyclic chain. Java assignment copies a reference, not a node. `a = b` moves a local reference; `a.next = b` changes the structure shared by every reference to that node. Compare node identity with `==`; equal values do not imply the same node.

All implementations below use this shared definition, nested inside a solution class:

```java
static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
```

Recognition clues:
- Input is a node chain and the task changes order or removes nodes: consider link rewiring.
- The first output node may change: consider a dummy predecessor.
- Relative positions, middle, or cycles matter: consider fast/slow pointers.

Accessing the kth node costs O(k); changing a known predecessor's successor costs O(1). Finding that predecessor may still cost O(n). These examples mutate existing links unless stated otherwise.

## Easy foundation: reverse an acyclic chain

**Problem** — Given `1 -> 2 -> 3 -> null`, return `3 -> 2 -> 1 -> null`, reusing the nodes. An empty input returns null.

**Why this technique applies** — Node order must change without indexed access. Each successor link can be redirected once.

**Solution** — Maintain a reversed prefix headed by `prev` and an untouched suffix headed by `cur`. Save the original successor before overwriting the link. Redirect, advance the reversed prefix, then advance into the saved suffix. Initially the prefix is empty; finally it contains every node. Trace: `(prev=null, cur=1)`, then `(prev=1, cur=2)`, then `(prev=2->1, cur=3)`.

**Java**
```java
public ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
        ListNode next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
    }
    return prev;
}
```

**Complexity** — O(n) time, O(1) auxiliary space.

Beginner mistake: overwriting `cur.next` and then following it loses the original suffix. The references point to existing nodes; three references do not allocate three lists.

## Medium application 1: stable partition

**Problem** — Given an acyclic list and x, put all nodes with value less than x before all other nodes, preserving relative order within both groups. Reuse the nodes. Input `3 -> 1 -> 4 -> 2 -> 5`, x=3; output `1 -> 2 -> 3 -> 4 -> 5`.

**Why this technique applies** — This is stable rearrangement of nodes. Compared with reversal, two growing output chains replace one reversed prefix. Dummy heads remove special handling for an empty group.

**Solution** — Save the next input node, detach the current node, append it to the appropriate tail, and continue. At every step each processed node belongs to exactly one stable output chain. Join the smaller chain to the other chain and return the first real node. Sorting is wrong because it need not preserve original group order and does extra work.

**Java**
```java
public ListNode partition(ListNode head, int x) {
    ListNode lowDummy = new ListNode(0);
    ListNode highDummy = new ListNode(0);
    ListNode low = lowDummy;
    ListNode high = highDummy;
    while (head != null) {
        ListNode next = head.next;
        head.next = null;
        if (head.val < x) {
            low.next = head;
            low = head;
        } else {
            high.next = head;
            high = head;
        }
        head = next;
    }
    low.next = highDummy.next;
    return lowDummy.next;
}
```

**Complexity** — O(n) time, O(1) auxiliary space; only two dummy nodes are allocated.

Boundary handling: either group may be empty; disconnect old links so the final result cannot retain stale links or accidentally form a cycle.

## Medium application 2: find the cycle entry

**Problem** — Nodes A(4), B(7), C(7), D(9) have links A->B->C->D->B. Return the actual B node. Return null for an acyclic chain. Values may repeat and nodes must not be modified.

**Why this technique applies** — Following successors repeatedly can revisit node identities. Compared with reversal, links stay unchanged and the invariant concerns relative traversal speeds.

**Solution** — Move slow by one edge and fast by two, checking both `fast` and `fast.next` before advancing. In a cycle the relative gap changes by one each iteration, so they meet. Reset one pointer to head and advance both one edge per step; their first meeting is the entry. If the prefix length is a, the distance from entry to the first meeting is b, and cycle length is c, then a+b is a multiple of c: fast's traveled distance is twice slow's and their difference is whole laps. Thus walking a more steps from the meeting reaches the entry. A HashSet of node identities is correct but takes O(n) extra space. Comparing values is wrong: distinct nodes may contain 7.

**Java**
```java
public ListNode cycleEntry(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            ListNode fromHead = head;
            while (fromHead != slow) {
                fromHead = fromHead.next;
                slow = slow.next;
            }
            return slow;
        }
    }
    return null;
}
```

**Complexity** — O(n) time and O(1) auxiliary space, where n is the number of distinct reachable nodes.

Boundary handling: null, one node, and a self-loop all work. The first meeting inside a cycle is not necessarily its entry.

## Advanced directions (overview only)

Reversing fixed-size groups combines local reversal with group-boundary discovery and reconnection; an incomplete final group may need preservation. Sorting a linked list combines splitting, merging, and recursion or iterative run management. Lists with extra random references need a way to preserve arbitrary cross-links during copying. The single-successor chain model alone is insufficient for those cross-links. Recognize the extra bookkeeping; implementation is outside today's goal.

## Contrasts and mistakes

- Array two pointers usually move indices; list pointers may change the structure itself.
- Fast/slow traversal does not automatically imply a sliding window: there may be no shrinkable interval or running aggregate.
- A stack can reverse values using O(n) memory; link reversal uses O(1) auxiliary space and changes node order.
- A dummy head is a stable predecessor, not part of the returned answer.
- Do not confuse moving a reference with copying or modifying a node.
- Guard two-step traversal; define which middle is intended for even lengths.
- Iterative reversal is constant space; recursive reversal uses O(n) call-stack space.

## Recognition and implementation checklist

Mental hook: **Save -> Rewire -> Advance**.

1. State the role of every reference and whether input mutation is allowed.
2. Identify which nodes are already processed and which remain reachable.
3. Save any successor that a link change would overwrite.
4. Use a dummy predecessor when the head can change.
5. Check empty input, singleton input, head changes, and tail termination.
6. Compare node identities when the task concerns shared nodes or cycles.
7. Count pointer movement for time and allocations/call frames for space.

No linked-list practice problems have yet been attempted in this repository. Teaching examples are references, not evidence of independent performance. Do not use these same tasks as the student's first independent assessment.

# Heap / Priority Queue

Introduced: October 25, 2026. Next roadmap topic after Linked List.

## Learning goals

Understand what a heap guarantees, choose its ordering from the role of its root, and explain the state it preserves. Apply these ideas to repeated minimum/maximum extraction, top-k selection, streaming thresholds, and merging sorted sources. These are common interview tasks where the next best candidate changes after each operation.

## Core idea and mental model

A priority queue gives access to the highest-priority item currently present. A binary min-heap implements it by keeping every parent no greater than its children. Therefore the root is the minimum; siblings and unrelated subtrees need not be ordered. A max-heap reverses the comparison.

Think of a tournament: the winner is available at the root, while the remaining contestants are only partially organized. A complete binary tree has logarithmic height. Insertion repairs one upward path; removing the root replaces it with the last element and repairs one downward path. Neither operation sorts the whole collection.

In an array-backed heap, children of index i are 2*i+1 and 2*i+2; the parent of i>0 is (i-1)/2. You should understand this model, but can use Java PriorityQueue in interviews unless implementation is requested.

Recognition clues:

- Repeatedly select the smallest/largest item while candidates are added or removed.
- Keep only k best items from a large input or stream.
- Several sorted sources compete to provide the next output item.

The most common beginner mistake is treating the heap as a fully sorted collection. Only the root has a global ordering guarantee; iteration does not produce sorted order.

## Java operations

`PriorityQueue<Integer>` defaults to a min-heap. Use `new PriorityQueue<Integer>(Comparator.reverseOrder())` for a max-heap. `offer(x)` inserts, `peek()` inspects the root, and `poll()` removes it. Empty peek/poll return null; unboxing that result throws NullPointerException. Duplicates are retained.

For a heap of size h: peek is O(1); offer and poll are O(log(h+1)); storage is O(h). Searching for or removing an arbitrary value is O(h). Building by repeated insertion is O(n log n); bottom-up heap construction can be O(n). The examples below use repeated insertion and claim its cost.

Use Integer.compare or Long.compare in comparators. Subtraction can overflow. Do not modify an item's priority while it remains inside the heap: the queue does not automatically repair itself. Remove and reinsert it, or use immutable replacement entries with a deliberate stale-entry policy.

## Easy foundation — repeated minimum extraction

**Problem** — Given integers, return a separate ascending array, preserving duplicates and leaving the input unchanged. Input [4,1,3,1] produces [1,1,3,4]. Empty input produces an empty array.

**Why this technique applies** — Each output position needs the minimum among the remaining values. After removing one minimum, the heap exposes the next one.

**Solution** — Insert all values into a min-heap. Repeatedly remove its root into the result. The invariant is that the heap contains exactly the values not yet output. This illustrates heap behavior; ordinary sorting is often simpler for a single batch.

**Java**
```java
import java.util.PriorityQueue;

public class HeapOrdering {
    public int[] ascending(int[] values) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int value : values) heap.offer(value);
        int[] result = new int[values.length];
        for (int i = 0; i < result.length; i++) result[i] = heap.poll();
        return result;
    }
}
```

**Complexity** — O(n log(n+1)) time, O(n) auxiliary space, plus O(n) output space.

## Medium application 1 — keep the best k

**Problem** — Return the kth largest value in a nonempty integer array, counting duplicates separately. Require 1 <= k <= values.length. Input [3,2,1,5,6,4], k=2 produces 5. Input [5,5,4], k=2 produces 5.

**Why this technique applies** — We need a ranked boundary rather than the complete sorted order. Compared with the easy example, we retain only k candidates. The root should expose the weakest retained candidate so it can be evicted: the k largest values require a MIN-heap.

**Solution** — Insert each value. Whenever the heap grows beyond k, remove its minimum. After every processed prefix, the heap contains its largest min(k, prefix length) values, with multiplicity. Once it has k items, its root is the kth largest. For [3,2,1,5,6,4], k=2, the retained multisets are {3}, {2,3}, {2,3}, {3,5}, {5,6}, {5,6}. Braces show membership, not internal heap iteration order.

A max-heap containing only k items with unconditional root removal discards the largest candidate, breaking the desired invariant. A max-heap of ALL n values followed by k removals is correct, but stores all n candidates.

**Java**
```java
import java.util.PriorityQueue;

public class KthLargest {
    public int kthLargest(int[] values, int k) {
        if (k < 1 || k > values.length) {
            throw new IllegalArgumentException("k outside input range");
        }
        PriorityQueue<Integer> best = new PriorityQueue<>();
        for (int value : values) {
            best.offer(value);
            if (best.size() > k) best.poll();
        }
        return best.peek();
    }
}
```

**Complexity** — O(n log(k+1)) time, O(k) auxiliary space. Using log(k+1) includes the linear k=1 case. Input is preserved.

### Streaming interpretation

The same invariant holds after EVERY insertion. Preserve this heap between arrivals and the root gives the current kth-largest threshold once at least k values have arrived. Before then, a kth-largest value does not exist: define that API explicitly. No old discarded value can later enter the largest k, because the retained threshold can only increase as new values arrive. This reasoning assumes insertions only; deletions or expiration invalidate that argument.

## Medium application 2 — merge sorted sources

**Problem** — Given k integer arrays, each already sorted in nondecreasing order, return all values in sorted order. Empty arrays are allowed. [[1,4,7],[2,5],[],[3,6]] produces [1,2,3,4,5,6,7]. Assume the total length fits a Java array.

**Why this technique applies** — We repeatedly need the minimum, but each source is already ordered. Compared with the easy example, we need only one candidate per nonempty source. A source's current first unused value is no greater than anything hidden behind it.

**Solution** — Put each nonempty source's first value in a min-heap, together with its source and index. Remove the smallest entry, output its value, and insert the next value from that same source if one exists. The heap contains exactly one first-unused candidate for each unfinished source. The global next value must be among these candidates. Ties may be removed in any order for this value-only output.

Putting every value in a heap ignores the sorted-source advantage and uses O(N) heap storage. Scanning all k heads for each output is correct but can cost O(Nk). Storing only the value loses the information required to advance the correct source.

**Java**
```java
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSources {
    private record Entry(int value, int source, int index) {}

    public int[] merge(int[][] sources) {
        PriorityQueue<Entry> heap = new PriorityQueue<>(
                Comparator.comparingInt(Entry::value));
        int total = 0;
        for (int s = 0; s < sources.length; s++) {
            total += sources[s].length;
            if (sources[s].length > 0) {
                heap.offer(new Entry(sources[s][0], s, 0));
            }
        }
        int[] result = new int[total];
        int out = 0;
        while (!heap.isEmpty()) {
            Entry entry = heap.poll();
            result[out++] = entry.value();
            int next = entry.index() + 1;
            int source = entry.source();
            if (next < sources[source].length) {
                heap.offer(new Entry(sources[source][next], source, next));
            }
        }
        return result;
    }
}
```

**Complexity** — Let N be total values, k be the number of arrays, and a be the number of nonempty arrays. O(k + N log(a+1)) time, O(a) live auxiliary space, plus O(N) output. The O(k) scan matters even if all arrays are empty. Input arrays are preserved.

## Advanced directions — conceptual overview, not worked examples

- Two heaps can maintain a partition around a changing middle rank. The added invariant is balanced partition sizes plus ordering between partitions; one heap alone no longer exposes everything needed.
- Expiring windows or changing priorities require deletion of entries that may be buried inside a heap. Plain root operations are insufficient. Indexed heaps, ordered multisets, or lazy deletion with validity bookkeeping add the missing capability; lazy deletion also needs careful storage analysis.
- Best-first exploration combines a priority queue with a graph or implicit search space. Removing the smallest candidate is only useful when the problem's assumptions justify the expansion and finalization rule. A heap alone is not a correctness proof.
- Large merge/search tasks may generate candidates lazily. The new work is proving frontier coverage and preventing repeated generation, rather than merely writing a comparator.

These directions are recognition targets for later blocks; no hard implementation is assigned here.

## Contrasts with patterns already learned

| Need | Usually consider | Key distinction |
|---|---|---|
| Full order once | Sorting | A heap avoids maintaining full order when only the next item matters. |
| Closest later greater/smaller value | Monotonic stack | Position and permanent dominance drive pruning; a heap orders by priority. |
| First arrival first | Queue | Arrival order determines the next item. |
| Repeated current best among candidates | Heap | Priority determines the next item. |
| Fast lookup/count by key | HashMap | Heap arbitrary-value lookup is linear. |
| Fixed sorted-array boundary | Binary search | Search a stable ordered domain rather than maintain changing candidates. |
| Minimum over a moving window | Often monotonic deque | Positional expiration and dominance can give linear total work. |

Repository connections: week_43_october_2026/Problem11 (price spans) and week_42_october_2026/Problem04 (circular next-greater values) illustrate the positional stack contrast. Their completed practice does not count as Heap practice. There are no assigned Heap problems yet.

## Recognition summary and implementation checklist

Mental hook: **The root is the next thing to use—or the first thing to evict.**

1. Say what an entry represents: value alone, or value plus identity/source/index.
2. State what must be at the root. Smallest next output means min-heap. Weakest of k largest also means min-heap. Weakest of k smallest means max-heap.
3. State membership: all remaining items, best k so far, or one candidate per source.
4. Define the update after poll: discard permanently, replace from the same source, or expand a frontier.
5. Check empty state, duplicate semantics, tie requirements, and overflow-safe comparison.
6. Count insertions/removals and maximum LIVE heap size; add output space separately.

Bad fits include full arbitrary rank queries, frequent arbitrary-key updates without extra structure, and tasks where the existing order supports a simpler linear technique.

## Short active recall before independent practice

Explain without looking back: why do k largest values use a min-heap? Why can a merge hide everything except each source's first unused value? Why does iterating a PriorityQueue fail to sort it?

Understanding and implementation have not yet been assessed. Choose a representative medium practice task after this check, using a task distinct from these worked examples. Do not infer mastery from reading reference code.

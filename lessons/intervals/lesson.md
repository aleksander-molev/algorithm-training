# Intervals: ordering turns overlap into a local decision

Introduced: 2026-11-01. Study block target: 2026-11-08; hard maximum: 2026-11-15.

## Learning goals

Recognize range problems, choose a useful ordering, state exactly what the maintained boundary means, and distinguish combining coverage from selecting compatible ranges. Apply this to reservations, occupied time, schedules, and range insertion.

## Core idea and mental model

An interval describes all positions between two endpoints. Write down endpoint semantics FIRST:

- Closed `[s,e]` includes both endpoints. `[1,3]` and `[3,5]` overlap at 3.
- Half-open `[s,e)` excludes the right endpoint. `[1,3)` and `[3,5)` do not overlap. This is useful for meetings: a room can be reused at the finishing time.

Sort by start when reasoning about coverage. Maintain one active combined range; all earlier emitted ranges are finished. Because future starts never decrease, a gap before the next start proves the active range can never connect to a later range.

For selecting the largest compatible subset, a different ordering helps: finish as early as possible, preserving room for future choices.

Recognition clues:
1. Input consists of starts/ends or occupied ranges.
2. The task asks about overlaps, combined coverage, conflicts, or simultaneous activity.
3. Relative endpoint order matters more than the number of individual coordinates inside a range.

Do not automatically allocate an array covering every possible coordinate. Endpoints may be sparse or huge.

## Easy foundation: detect overlap

**Problem** — Given two nonempty closed integer intervals `[a,b]` and `[c,d]`, determine whether they share a point. `[1,3]` and `[3,7]` return `true`; `[1,2]` and `[4,7]` return `false`. Assume `a <= b` and `c <= d`.

**Why this technique applies** — Two ranges share a point exactly when their later start is no later than their earlier end. No enumeration of covered points is needed.

**Solution** — Compare `max(a,c)` with `min(b,d)`. For nonempty half-open intervals, use `<` instead of `<=`.

**Java**
```java
class ClosedOverlap {
    public boolean overlaps(int a, int b, int c, int d) {
        return Math.max(a, c) <= Math.min(b, d);
    }
}
```

**Complexity** — O(1) time and O(1) auxiliary space.

Beginner mistake: checking only whether one start is inside the other interval, or mixing closed and half-open comparisons.

## Medium application 1: merge coverage

**Problem** — Given unsorted closed intervals, return sorted disjoint intervals covering exactly the same points. Touching endpoints merge. `[[8,10],[1,4],[2,6],[9,12]]` returns `[[1,6],[8,12]]`. Empty input returns an empty array. Preserve the input.

**Why this technique applies** — Unlike the two-range task, overlaps can form chains. Sorting by start makes every possible extension of the active component arrive before any final gap. Only the active merged range needs comparison.

**Solution** — Copy and sort intervals by start. Start an active range. If the next start is at most the active end, extend the end using `max`. Otherwise emit the active range and start another. Emit the final range after the loop. Invariant: emitted ranges are final; the active range is the union of the last connected component in the processed prefix.

Wrong approach: compare only with the immediately previous original interval. In `[[1,10],[2,3],[4,5]]`, the previous original end is 3, but the active component still ends at 10. Another mistake is assigning the next end directly, shrinking coverage on nested intervals.

**Java**
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeCoverage {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        int[][] sorted = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            sorted[i] = intervals[i].clone();
        }
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int start = sorted[0][0];
        int end = sorted[0][1];
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i][0] <= end) {
                end = Math.max(end, sorted[i][1]);
            } else {
                result.add(new int[]{start, end});
                start = sorted[i][0];
                end = sorted[i][1];
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }
}
```

**Complexity** — O(n log n) time; O(n) auxiliary space for copying and sorting, plus O(n) worst-case output. The scan itself uses O(1) boundary state. If already sorted, the scan takes O(n) time. Do not equate constant scan state with constant total space.

## Medium application 2: remove the fewest conflicting meetings

**Problem** — Given positive-length half-open meetings `[start,end)`, remove the minimum number so the remaining meetings do not overlap. Touching meetings are compatible. `[[1,3],[2,4],[3,5]]` returns `1`: remove `[2,4]`. Empty input returns `0`. Preserve the input.

**Why this technique applies** — The output is a subset of original meetings, not combined coverage. We must choose which meeting survives a conflict. Earliest finish leaves the most available time for the rest.

**Solution** — Sort by end. Keep the first meeting, then accept each meeting whose start is at least the last accepted end. Return total minus kept. Exchange reasoning: replacing the first meeting of an optimal schedule with the earliest-finishing meeting cannot invalidate any later meeting. Repeat on the remainder.

Extra state: last accepted end and number kept. Wrong approach: keep the earliest-starting meeting. For `[[1,10],[2,3],[3,4],[4,5]]`, that keeps only one, while the three shorter meetings are compatible. Merging would also change the objects rather than solve the selection task.

**Java**
```java
import java.util.Arrays;

class RemoveConflicts {
    public int minimumRemovals(int[][] meetings) {
        if (meetings.length == 0) return 0;
        int[][] sorted = meetings.clone();
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[1], b[1]));
        int kept = 1;
        int lastEnd = sorted[0][1];
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i][0] >= lastEnd) {
                kept++;
                lastEnd = sorted[i][1];
            }
        }
        return sorted.length - kept;
    }
}
```

**Complexity** — O(n log n) time and O(n) auxiliary space for the outer-array copy and object-array sorting. Rows are shared safely because the method never modifies endpoints. Output is one integer.

## Advanced directions — conceptual overview, not worked examples

- Sweep lines replace one active boundary with events and a count or ordered structure. Recognize tasks asking about simultaneous activity or changes at many endpoints. Equal-coordinate event ordering depends on endpoint semantics.
- Offline interval queries can combine sorted query processing with a heap. A single merged range is insufficient when a query must choose among many eligible intervals using another ranking.
- Weighted scheduling adds values to choices. Earliest finish alone no longer guarantees maximum total value; dynamic programming and predecessor search may be needed. Recognize this limitation now; implementation belongs to later roadmap blocks.
- Dynamic interval updates may require ordered maps or segment trees. A one-time sorted scan assumes the input remains fixed.

## Contrasts and recognition summary

- Combine covered positions: consider sorting by start and maintaining an active merged end.
- Keep the most compatible original ranges: consider sorting by end and an exchange argument.
- Count simultaneous activity: consider endpoint events or a structure tracking active endings.
- Sliding window maintains a contiguous section of a sequence under a constraint; interval scanning reasons about supplied endpoint pairs.
- Heap repeatedly chooses a current extremum; static merging needs only sorted order and one active boundary.
- Prefix sums are useful on dense bounded coordinates or after a suitable transformation. Sparse large endpoints favor endpoint-based reasoning.
- Ordinary interval techniques are a poor fit when objects cannot be represented as ranges on one ordered axis, or when selection has weights/dependencies that invalidate the greedy choice.

Mnemonic: **Meaning → Order → Boundary → Action**. Define endpoint meaning, choose ordering for the objective, name the maintained boundary, then decide extend/emit or keep/reject.

## Implementation checklist

1. Define closed/half-open semantics and whether touching counts.
2. Check empty input and valid endpoint assumptions.
3. Choose sort key based on the objective; use `Integer.compare`, not subtraction.
4. State the invariant in a sentence before coding.
5. Preserve input when required; outer copies alone still share rows.
6. Handle nested intervals, equal endpoints and the final active range.
7. Count sorting, copies, maintained structures and output separately in complexity.

## Practice and active recall

No earlier interval practice is recorded at introduction. Prior Heap work in `week_44_october_2026/Problem12` is a useful contrast: there the retained candidate set and root role matter; here endpoint meaning and the active boundary matter.

Understanding check before assigning a fresh Medium workspace:
- With closed ranges `[[1,10],[2,3],[10,12],[14,16]]`, what merged output results, and why is comparing only with the previous original end unsafe?
- With half-open ranges, do `[1,3)` and `[3,5)` conflict?

The next independent practice should transfer these ideas to a distinct task. Its solution must remain absent from this lesson until attempted. Teaching examples are not student solved problems or evidence of mastery.

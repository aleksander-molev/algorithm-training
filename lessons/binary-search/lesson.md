# Binary Search

Introduced in MODE: STUDY on 2026-10-11. Target transition: 2026-10-18; hard maximum: 2026-10-25.

## Overview and learning goals

Binary search repeatedly discards a region that cannot contain the answer. By the end of this block, recognize exact search, lower/upper boundaries, and search over possible answers; state an invariant; choose progressing updates; and account for the cost of checking a candidate. These ideas support interview tasks involving sorted data, duplicates, minimum feasible resources, and ordered decision problems.

## Core idea and mental model

Do not memorize updates independently of the question. Define the search domain and explain why the discarded half cannot contain the answer.

For exact search on a sorted array, use an inclusive interval [left, right]: any existing match is inside it. Equality finishes the search.

For first-true boundary search, use [left, right), initially [0, n]. Every index below left is known false; every actual index at or above right is known true. The first true boundary remains between left and right, inclusive; n means no actual index qualifies. While left < right, mid is an actual index. True gives right = mid; false gives left = mid + 1. At termination left is the boundary.

For a minimum feasible answer over integers, use inclusive candidate bounds [low, high], with high known feasible. A feasible mid remains a candidate: high = mid. An infeasible mid excludes itself and all smaller values: low = mid + 1.

Recognition clues:
- sorted values allow ordered comparisons;
- a predicate changes only once, from false to true (or the reverse);
- increasing a resource relaxes feasibility, so all answers above a feasible answer remain feasible.

## Easy foundation: exact lookup

**Problem** — Given a strictly increasing integer array and a target, return its index or -1. Empty arrays are allowed. [1, 3, 5, 7, 9], target 7 returns 3.

**Why this technique applies** — Sorted order means that if the middle is smaller than the target, every earlier value is too small too.

**Solution** — Keep an inclusive interval. Return on equality; otherwise remove the middle and the half ruled out by comparison. If the interval becomes empty, the target is absent.

**Java**
```java
class ExactLookup {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
```

**Complexity** — O(log(n + 1)) time, O(1) auxiliary space.

Beginner mistake: retaining mid after ruling it out can prevent progress; conversely discarding a qualifying mid in a boundary search can lose the answer.

## Medium application 1: duplicate counts via two boundaries

**Problem** — Given a sorted nondecreasing integer array, return the number of occurrences of target. [1, 2, 2, 2, 5], target 2 returns 3; target 4 returns 0. Empty arrays are allowed.

**Why this technique applies** — Compared with exact lookup, equality is not enough. Both nums[i] >= target and nums[i] > target change from false to true once. Two boundary positions delimit all occurrences.

**Solution** — Find lower bound (first >= target) and upper bound (first > target). Return upper - lower. Use n as the absent boundary and never read nums[n]. An exact match followed by an outward scan is correct but can take O(n) time for many duplicates. Do not implement upper bound as lower bound of target + 1: that can overflow at Integer.MAX_VALUE.

**Java**
```java
class OccurrenceCount {
    public int count(int[] nums, int target) {
        return boundary(nums, target, true) - boundary(nums, target, false);
    }

    private int boundary(int[] nums, int target, boolean strict) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean qualifies = strict ? nums[mid] > target : nums[mid] >= target;
            if (qualifies) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
```

**Complexity** — Two logarithmic searches: O(log(n + 1)) time, O(1) auxiliary space.

Extra handling: duplicate values, strict versus non-strict comparisons, and n as a valid result boundary. The array must be sorted; sorting an unsorted input changes the overall complexity and may change its contract.

## Medium application 2: minimum shipping capacity

**Problem** — Positive package weights must be shipped in their given order. Each day carries a consecutive group of packages of total weight at most capacity; a package cannot be split. Return the smallest capacity allowing shipment within days days. Nonempty weights, each at most 1,000,000, and 1 <= days <= weights.length; at most 100,000 packages. For [3, 2, 2, 4, 1] and days = 3, return 5: groups [3, 2], [2], [4, 1]. Capacity 4 needs four days.

**Why this technique applies** — The domain changes from array indices to candidate capacities. If capacity C works, every larger capacity works. Thus feasibility is false then true. Checking a capacity needs a full loading simulation rather than one array comparison.

**Solution** — The largest package is a lower bound; the total weight is a feasible upper bound. For a candidate, greedily fill each day until the next package would exceed capacity, then start a new day. Taking a shorter prefix cannot reduce the days needed: the greedy first day advances at least as far as any valid first day, and the same argument applies to the remainder. Search the first capacity whose simulation uses at most days. Use long for totals and capacity. Searching indices confuses the domain; dividing total weight by days ignores order and indivisible packages.

**Java**
```java
class ShippingCapacity {
    public long minimumCapacity(int[] weights, int days) {
        long low = 0;
        long high = 0;
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (canShip(weights, days, mid)) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private boolean canShip(int[] weights, int days, long capacity) {
        int usedDays = 1;
        long load = 0;
        for (int weight : weights) {
            if (load + weight > capacity) {
                usedDays++;
                load = 0;
                if (usedDays > days) return false;
            }
            load += weight;
        }
        return true;
    }
}
```

**Complexity** — O(n log(R + 1)) time and O(1) auxiliary space, where R = sum(weights) - max(weights) is the initial capacity range width. Computing the bounds costs O(n), including when R = 0.

## Advanced directions (conceptual overview, not worked examples)

- Expensive feasibility: combine answer search with greedy, graph algorithms, or dynamic programming. The major difficulty may be proving the checker correct; multiply search iterations by its cost.
- Rotated data: global sorted order no longer holds. Identify which region is ordered or locate a rotation boundary. With duplicates, equality may not identify a discardable half; worst-case linear behavior can result.
- Local direction searches: adjacent comparisons can preserve the existence of a peak without a globally false-then-true predicate. Do not force every binary search into lower-bound form.
- Continuous answers: integer termination no longer applies; use a specified tolerance or iteration count and reason about numerical precision.

## Contrasts and common mistakes

- Exact search asks for any match; boundary search asks for the first or last qualifying position. Their equality branches differ.
- Sliding window moves boundaries of a contiguous range; it does not halve a candidate answer domain.
- Prefix sums speed cumulative queries; they do not themselves justify eliminating half. They can support a feasibility checker.
- An optimization problem alone is not enough: prove the direction of feasibility before binary searching an answer.
- Returning a boundary index when the contract asks for a value is a contract error.
- A predicate need not be cheap. O(log R) iterations with an O(n) checker cost O(n log R).
- Use left + (right - left) / 2, and choose types large enough for bounds and aggregates. This midpoint formula assumes the difference fits the chosen type.
- Each branch must shrink the interval; check intervals of size one and two manually.

## Recognition checklist and learning accelerator

Mental hook: **Domain → condition → invariant → progress → return.**

First-true mnemonic: **True stays; false goes.** A true mid might be first, so retain it; a false mid cannot be first, so remove it.

Implementation checklist:
1. State exactly what the method returns: index, count, or value.
2. Choose inclusive or half-open bounds and keep the convention consistent.
3. State the elimination argument and the meaning of both bounds.
4. Check empty input if allowed, absent answers, duplicates, and numeric limits.
5. Confirm both updates make progress and the final return satisfies the contract.
6. Include candidate-check cost in time complexity.

Active recall: close the note and explain why right = mid is correct for first-true search, but right = mid - 1 is correct when an exact-search middle is too large.

## Repository practice references

Previously used: First Greater or Equal (2026-09-13), Search Insert Position (2026-09-14), Find First and Last Position (2026-09-15), Next Greatest Letter (2026-09-18), Find Minimum in Rotated Sorted Array (2026-09-24), and week_41_october_2026/Problem04.java (rotated target search, independently solved 2026-10-06).

The block's first new practice will test search on possible answers. Its solution is intentionally excluded until the student's attempt.

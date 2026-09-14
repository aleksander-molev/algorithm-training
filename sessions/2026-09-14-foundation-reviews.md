# Session — 2026-09-14

## Mode

review

## Intended duration

About 45 minutes.

## Goals

- Complete the due HashMap, two-pointers, binary-search, and implementation-precision reviews.
- Practice stating a method contract and invariant before coding.

## Problems

### Ransom Note

**Concept tested:** character-frequency accounting

**Result:** pass

**Highest hint level:** 0

The student independently proposed a `Map<Character, Integer>` count of available magazine characters, then consumed counts while scanning the ransom note. The implementation compiled and passed the provided examples. They identified empty input and a note longer than the magazine as relevant cases and rated confidence 5/5.

**Complexity:** O(m + n) time; O(k) extra space, up to O(m).

**Next review:** 2026-09-17, stage 1.

### Move Zeroes

**Concept tested:** in-place stable array compaction

**Result:** partial

**Highest hint level:** 2

The student first described shifting after each zero, correctly recognizing O(n²) worst-case time. After conceptual guidance, they used a write index to copy nonzero values forward and filled the suffix with zeros. The implementation compiled and produced `[1, 3, 12, 0, 0]` and `[0]` for the supplied examples.

**Complexity:** O(n) time; O(1) extra space.

**Coaching note:** State the maintained write-prefix invariant before implementation. The helper named `swap` was a forward copy, not a swap; the behavior was correct but the name should match it.

**Next review:** 2026-09-15, stage 0.

### Search Insert Position

**Concept tested:** lower-bound boundary search

**Result:** partial

**Highest hint level:** 2

The student identified O(log n) time but initially described only a general halving process. With a target-specific half-open invariant, they implemented the search. The first version used `hi = mid - 1` when `nums[mid] > target`, failing on `[1, 3]`, target `2`. They repaired it to preserve `mid` as a candidate. The final code compiled and printed the expected starter results plus `1` for that counterexample.

**Complexity:** O(log n) time; O(1) extra space.

**Next review:** 2026-09-15, stage 0.

## Session-level observations

- Frequency-map reasoning is now independently reliable in a related variant.
- For array compaction and boundary search, turn the intended invariant into explicit statements before code.
- Use a final counterexample pass that includes insertion below all values, between adjacent values, above all values, and exact match.

## Updates made

- `docs/progress.md`
- `docs/weak-points.md`
- `docs/problem-history.md`
- `sessions/2026-09-14-foundation-reviews.md`

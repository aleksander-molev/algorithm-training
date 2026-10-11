# Weak Points

This file contains recurring weaknesses that future sessions should actively revisit.

Do not record every typo. Record issues likely to affect future problem solving or interview performance.

## Active weak points

2026-10-11 final: student correctly identifies O(n) time and O(n) space for Problem09; constant factors clarified. Frequency review passed. No new weakness; contract tracking remains active after one recovery demonstration since October 8. Stage 3 retained, next mixed check October 12 for separated evidence on a different pattern.

2026-10-11: Problem09 independently correct after semantics clarification, five test methods pass including 500 occurrence-pairing comparisons and maximum input. No new weakness. One independent recovery demonstration since October 8 regression; retain active contract tracking until another demonstration on a different pattern separated in time. Student complexity statement pending; review dates unchanged.

2026-10-09 single-task assignment: Problem09 pending independent attempt. No new weakness or recovery evidence; existing statuses and dates unchanged.

2026-10-09: Problem08 correction verified. All nine tests pass, including 500 oracle comparisons and preservation. Correct empty-boundary initialization, earliest occurrence retention and long arithmetic. Retain active contract tracking: this is an assisted correction, not independent recovery. Next check October 10; no pending correction.

2026-10-08 second revision: symmetric trimming handles the centered example but omits off-center segments. [5, 1, 2, 5, 5] versus [9, 2, 1, 9, 9] expected 2, actual 0. Six of seven tests pass. Conceptual obstacle: arbitrary boundary pairs, rather than enumerating special segment categories. Level-2 cumulative-difference observation provided. Same unresolved attempt; occurrences and October 9 date unchanged.

2026-10-08 Problem08 revision: long fixes overflow; added suffix scan fixes previous suffix example. Still misses segments touching neither end: [5, 1, 2, 5] versus [9, 2, 1, 9] returns 0 instead of 2. Five of six tests pass. Same unresolved attempt, no additional occurrence; status and October 9 check unchanged.

2026-10-08 Problem08 assessment: only segments starting at index 0 are considered; [5, 1, 2] versus [9, 2, 1] returns 0 instead of 2. int prefix sums also wrap, creating false equality when a sums to 4294967296 and b sums to zero. Recurrence of numeric-range/contract tracking; level-1 feedback, correction pending. Next check October 9; no recovery evidence.

2026-10-08: single-task REVIEW workspace Problem08 assigned; awaiting independent attempt. No new weakness or recovery evidence; existing status and review dates unchanged.

2026-10-07 close: student recognized and corrected Problem07 initialization with firstIdx.put(0, 0). All five tests pass, including 500 oracle comparisons and preservation. Retain partial and active contract tracking after first-attempt bug; no correction remains pending.

2026-10-07 final assessment: Problem07 misses the empty prefix boundary, so valid subarrays starting at index 0 can be missed. [2, 1] returns 0 instead of 2. Correct sign/parity normalization and earliest-index preservation; implementation precision remains active. Correction deferred at student's session close; next check October 8.

2026-10-07: Problem06 time correctly reported O(n); student initially reports worst-case O(n) space despite the fixed 26-letter alphabet, then acknowledges O(1) correction. Reinforce accounting for the maximum number of distinct stored keys; no implementation bug. Sliding Window review partial, stage 1 retained, next review October 10.

2026-10-07: Problem06 independently correct, including zero budget and repeated shrinking. No new weakness; both October 7 recovery demonstrations occurred on the same date, so retain contract tracking pending separated-time evidence. Student complexity analysis pending.

2026-10-07: Problem05 independently correct, including empty input, neutral zeros, input preservation, and a maximum answer above int range. One recovery demonstration after the October 6 overflow; retain active status until a separated independent demonstration on a different pattern. Student complexity analysis pending. No new weakness.

2026-10-06 (verified 2026-10-07): Problem04 solved independently with correct progressing boundaries and virtual-index mapping. No new correctness weakness. Contract tracking remains active after Problem03 overflow on the same practice date; this does not establish two separated recovery demonstrations. Instance fields are unnecessary per-call state; local variables would make the method easier to reuse.

2026-10-06: Problem03 initially overflowed its int answer accumulator. Student changed it to long after local feedback; all five tests pass, including maximum input and 500 small oracle comparisons. Complexity correctly reported. Contract tracking remains active; add a maximum-answer/type check before submission. Retain partial and existing schedules.

2026-10-05: longest target-sum subarray solved independently with correct boundary handling, earliest-index preservation, input preservation, and complexity analysis. No new weakness observed.

2026-09-30 lesson update: complete Prefix Sum reference solutions were requested and added. No student implementation was assessed, so this provides no new weakness or recovery evidence.

### Implementation precision and task-contract tracking

**Category:** implementation-bug
**First observed:** 2026-09-13
**Last observed:** 2026-10-08
**Occurrences:** 11
**Status:** active again after Problem02 empty-input regression

**Observed behavior**

The high-level strategy is often recovered correctly, but initial implementations have required corrections to method contracts, return types/values, variable scope, or boundary-specific requirements. On 2026-09-15, two implementations were correct independently after a stated contract and invariant. On 2026-09-17, both a frequency-accounting review and a new variable-window implementation were correct independently, including targeted edge-case checks; keep the scheduled separated-time review before resolving this weakness.

**Example**

Two Sum initially returned a collection instead of the requested `int[]`; Valid Palindrome needed scope/type and alphanumeric corrections; lower-bound Binary Search initially used exact-match return logic. In the Search Insert review, the right boundary was first updated as if `mid` could be discarded, which failed for insertion between two values. On 2026-09-18, Next Greatest Letter returned immediately after an equal value, violating the strictly-greater contract when duplicates followed. On 2026-09-22, a shrinking window initially moved its left boundary in the wrong direction and did not update the minimum after each shrink. On 2026-09-24, Find Minimum in Rotated Sorted Array initially returned an index and used a boundary update that could fail to make progress.

**Recovery evidence**

2026-09-28: Max Consecutive Ones III was correct independently, including zero budget, consecutive zeros, a later longest run, and input preservation. Correct O(n) time and O(1) auxiliary-space analysis. This is one convincing demonstration since the latest regression; keep active until another independent demonstration on a different pattern, separated in time. Review stage advanced to 2 (pass).

2026-10-05: Maximum Size Subarray Sum Equals k was correct independently on a different pattern, one week later. Six test methods passed, including 500 comparisons with brute force, zero targets, repeated sums, signed values, maximum-size input, and input preservation. Correct O(n) expected time and O(n) auxiliary space. Together these provide two separated independent demonstrations; recurring implementation weakness resolved, with ordinary mixed review retained.

2026-10-05 later review: Problem02 handles tested non-empty arrays correctly, but returns 1 for empty input despite the explicit contract allowing length 0. Reopened contract tracking; student corrected the boundary branch after local feedback, and all five test methods passed. Complexity estimates remain correct.

**Training action**

Before coding, restate the method contract and target-specific invariant. Before submitting, run a short checklist: signature and types, return contract, representative edge cases, boundary updates, and complexity.

**Next review**

2026-10-12 (stage 3 retained; one independent recovery verified October 11, another on a different pattern needed)

**Resolved when**

Two independent solutions on different patterns are implemented correctly after a stated contract and edge-case check, separated in time.

---

## Entry format

### <weakness title>

**Category:** boundary-condition  
**First observed:** YYYY-MM-DD  
**Last observed:** YYYY-MM-DD  
**Occurrences:** 1  
**Status:** active

**Observed behavior**

Describe the concrete issue.

**Example**

Brief example of the mistake.

**Training action**

What should future sessions do?

**Next review**

YYYY-MM-DD

**Resolved when**

Describe objective evidence required before this can be marked resolved.

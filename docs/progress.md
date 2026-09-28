# Current Progress

Last updated: 2026-09-28

## Current status

Initial diagnostic completed on 2026-09-13.

## Current focus

Mixed session in progress: overdue variable-window review passed; one more overdue review is prepared before new roadmap material. Continue checking implementation precision through spaced repetition.

## Topic status

| Topic | Status | Confidence | Avg hint level | Last practiced | Notes |
|---|---|---:|---:|---|---|
| Complexity | Comfortable | - | 0 | 2026-09-13 | Correct warm-up analysis; distinguish sorting implementation space costs. |
| Arrays / Strings | Developing | - | 1 | 2026-09-13 | Palindrome scan solved after local implementation guidance. |
| HashMap / HashSet | Developing | - | 0 | 2026-09-24 | Correct count-and-consume implementation; review space-complexity accounting. |
| Two Pointers | Developing | 4 | 0 | 2026-09-15 | Independently passed a stable in-place filtering variant; stated the write-prefix invariant. |
| Sliding Window | Developing | - | 0.3 | 2026-09-28 | Independently solved Max Consecutive Ones III; correct O(n) time / O(1) space; targeted boundary tests passed. |
| Prefix Sum | Not started | - | - | - | |
| Binary Search | Developing | - | 1 | 2026-09-24 | Repaired a non-progressing boundary update in a rotated-array variant. |
| Stack | Not started | - | - | - | |
| Linked List | Not started | - | - | - | |
| Heap | Not started | - | - | - | |
| Intervals | Not started | - | - | - | |
| Trees | Not started | - | - | - | |
| Graphs | Not started | - | - | - | |
| Backtracking | Not started | - | - | - | |
| Greedy | Not started | - | - | - | |
| Dynamic Programming | Not started | - | - | - | |

## Due reviews

- Two pointers / in-place stable compaction (stage 1; last result: pass; last reviewed: 2026-09-15; next review: 2026-09-18; evidence: Remove Element review)
- Binary Search / boundary search (stage 1; last result: partial; last reviewed: 2026-09-24; next review: 2026-09-27; evidence: Find Minimum in Rotated Sorted Array review)
- Implementation precision / contract tracking (stage 2; last result: pass; last reviewed: 2026-09-28; next review: 2026-10-05; evidence: independent Max Consecutive Ones III implementation with correct boundary handling and input preservation)
- HashMap / frequency accounting (stage 2; last result: partial; last reviewed: 2026-09-24; next review: 2026-10-01; evidence: Ransom Note review)
- Sliding window / variable window (stage 1; last result: pass; last reviewed: 2026-09-28; next review: 2026-10-01; evidence: Max Consecutive Ones III review)

## Recent strengths

- Complexity: correctly analyzes common loop/sort compositions.
- HashMap: independently implemented frequency accounting with a clear consumption model.
- Two pointers: can build a correct inward scan after local implementation feedback.
- Binary search: can repair a half-open boundary interval after focused guidance.
- Correctly implements frequency count-and-consume logic, including duplicate handling.
- Independently handles a zero-budget array variant, including exhausted-budget transitions; reports linear time and constant auxiliary space correctly.

## Current weak points

- Implementation precision: method contracts, Java scope/type consistency, return values, and boundary updates need a deliberate final check.
- Pattern recognition: distinguish exact-match binary search from a boundary/lower-bound search; state a target-specific invariant before coding.
- Complexity reporting: account for auxiliary maps by the number of distinct stored keys.

## NEXT STUDY TOPIC

When the student starts `MODE: STUDY`, Prefix Sum MUST be the next training topic.

Until Prefix Sum has actually been introduced and its introduction date is recorded:
- `MODE: STUDY` must begin with Prefix Sum;
- do not use an old-topic warm-up inside `MODE: STUDY`;
- ignore pending old-topic workspaces as study-start candidates.

This rule does not override `MODE: REVIEW` or `MODE: INTERVIEW`. The student's explicit mode command is always authoritative.

This study lock is cleared only after the first genuine Prefix Sum teaching/practice session is recorded.

## Next recommended session

A new learning block is due.

Current block topic: Prefix Sum.
Block introduction date: not started yet — set this when Prefix Sum is actually introduced.
Target transition: normally about 7 days after introduction; may move earlier if it is learned quickly; hard maximum 14 days after introduction.

The first meaningful session of this block must:
1. introduce Prefix Sum first;
2. run the Teaching Phase;
3. solve initial Prefix Sum practice.

After Prefix Sum has been introduced, later sessions in this block may be review/practice-heavy.

Prefix Sum should normally occupy about one week, but this is adaptive:
- if it becomes comfortable quickly, move to the next topic early;
- if it is difficult, keep practicing it longer;
- in all cases, move on no later than 14 days after the actual introduction date.

Any remaining weakness should continue through spaced repetition instead of blocking the next topic.

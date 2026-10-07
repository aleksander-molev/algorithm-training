# Problem History

Compact history of completed or meaningfully attempted problems.

Detailed discussion belongs in `sessions/`.

2026-10-07 Problem07 correction verified: student seeded the empty boundary after local feedback. All five tests pass, including all 500 direct-enumeration comparisons, signed parity, empty input, and input preservation. Solved after level-1 feedback; retain partial, stage 0, next review 2026-10-08. No pending workspace; session closed.

2026-10-07 final assessment: Problem07 (longest equal-even/odd subarray), Medium, partial review. Three basic tests pass; two added test methods fail, including [2, 1] expected 2, actual 0. Empty boundary absent; earliest-index preservation and signed parity normalization correct. Coach complexity: expected O(n) time / O(n) auxiliary space; student analysis not supplied at session close. Level-1 local feedback; stage 0 retained, next review 2026-10-08. Student code unchanged, correction deferred. Session closed; no new task.

2026-10-07 final update: Problem06 independently correct; time analysis correct, fixed-alphabet space corrected and acknowledged. Partial review for complexity confusion, stage 1 retained, next review 2026-10-10. Problem07 (longest subarray with equal even/odd counts, Medium) assigned as the student's requested final task; pending, no result or scheduling advancement.

2026-10-07 REVIEW: Problem06, longest substring with at most k distinct characters (Sliding Window / frequency map, Medium), independently correct, hint 0. All five test methods pass including 500 oracle comparisons and maximum-size inputs. Coach complexity: expected O(n) time, O(1) auxiliary space for fixed lowercase alphabet. Student complexity explanation pending; scheduling unchanged.

Problem05 final assessment, 2026-10-07: student complexity correct; counting review pass, stage 1, next review 2026-10-10. Problem06 (longest substring with at most k distinct characters) assigned; awaiting attempt.

2026-10-07 REVIEW: Problem05, count subarrays with equal positive/negative counts and neutral zeros (Prefix Sum counting transfer, Medium), solved independently after example-semantics clarification. Five test methods pass, including maximum answer and 500 oracle comparisons. Coach assessment: expected O(n) time / O(n) auxiliary space. Student complexity explanation pending; scheduling unchanged.

2026-10-05 REVIEW: retain at most two copies of each sorted-array value attempted in `week_41_october_2026/Problem02.java`; corrected and verified after empty-input feedback.

2026-09-30: added Java reference solutions to the Prefix Sum lesson for range sums, exact-sum counting, longest balanced binary subarrays, rectangle sums, and shortest threshold-sum subarrays. This was a lesson-material update, not a student attempt; no solved-problem or review result is recorded.

| Date | Problem | Pattern | Difficulty | Result | Hint | Confidence | Repeat | Next review |
|---|---|---|---|---|---:|---:|---|---|
| 2026-10-05 | Maximum Size Subarray Sum Equals k | Prefix Sum / earliest boundary map | Medium | Solved independently; first practice pass | 0 | - | yes | 2026-10-06 |
| 2026-09-13 | Two Sum | HashMap complement lookup | Easy | Solved with hints | 1 | - | yes | 2026-09-14 |
| 2026-09-13 | Valid Palindrome | Two pointers / normalized comparison | Easy | Solved with hints | 1 | - | yes | 2026-09-14 |
| 2026-09-13 | First Greater or Equal | Binary-search lower bound | Easy | Solved with hints | 1 | - | yes | 2026-09-14 |
| 2026-09-14 | Ransom Note | Frequency accounting | Easy | Solved independently | 0 | 5 | yes | 2026-09-17 |
| 2026-09-14 | Move Zeroes | In-place stable compaction | Easy | Solved with conceptual hints | 2 | - | yes | 2026-09-15 |
| 2026-09-14 | Search Insert Position | Binary-search lower bound | Easy | Solved after boundary correction | 2 | - | yes | 2026-09-15 |
| 2026-09-15 | Find First and Last Position | Binary-search boundary search | Easy | Solved independently | 0 | 4 | yes | 2026-09-18 |
| 2026-09-15 | Remove Element | In-place stable filtering | Easy | Solved independently | 0 | 4 | yes | 2026-09-18 |
| 2026-09-17 | Valid Anagram | Frequency accounting | Easy | Solved independently | 0 | - | yes | 2026-09-24 |
| 2026-09-17 | Longest Substring Without Repeating Characters | Variable-size distinct-character window | Medium | Solved independently | 0 | - | yes | 2026-09-18 |
| 2026-09-18 | Next Greatest Letter | Binary-search upper boundary | Easy | Solved after local boundary correction | 1 | - | yes | 2026-09-21 |
| 2026-09-22 | Minimum Size Subarray Sum | Variable-size shrinking window | Medium | Solved after implementation corrections | 1 | - | yes | 2026-09-23 |
| 2026-09-24 | Ransom Note | Frequency accounting | Easy | Solved independently; complexity correction | 0 | - | yes | 2026-10-01 |
| 2026-09-24 | Find Minimum in Rotated Sorted Array | Binary-search boundary reasoning | Medium | Solved after boundary correction | 1 | - | yes | 2026-09-27 |
| 2026-09-28 | Max Consecutive Ones III | Variable window / zero budget | Medium | Solved independently; review pass | 0 | - | yes | 2026-10-01 |

| 2026-10-05 | Remove Duplicates from Sorted Array II | Two Pointers / stable compaction | Medium | Solved after empty-input correction; partial review | 1 | - | yes | 2026-10-08 |

2026-10-05: Problem03 (count balanced binary subarrays) assigned.

2026-10-06 REVIEW: existing Problem03 attempt assessed. Basic examples and 500 small oracle comparisons pass; maximum alternating input fails due to int accumulator overflow. Correct expected O(n) time / O(n) auxiliary space; student complexity explanation pending. Local feedback level 1; partial, correction pending. Counting variant stage 0, next review 2026-10-07; earliest-boundary-map schedule unchanged.

2026-10-06 correction: Problem03 now uses a long accumulator; all five tests pass. Student reports correct O(n) time / O(n) space (time expected for HashMap). Solved after level-1 feedback; retain partial, stage 0, due 2026-10-07.

2026-10-06: Problem04 (Search in Rotated Sorted Array, distinct values), Medium, solved independently; hint level 0. Five test methods pass, including exhaustive small rotations and targets, input preservation, repeated calls, maximum-size input, and extreme values. Coach assessment: O(log n) time / O(1) auxiliary space; student did not separately report complexity. Binary Search review pass, stage 2, next review 2026-10-13. Completed on 2026-10-06 per student; reported and verified on 2026-10-07. Session completed; no further task assigned.

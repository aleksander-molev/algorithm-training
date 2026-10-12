# Problem History

Compact history of completed or meaningfully attempted problems.

Detailed discussion belongs in `sessions/`.

2026-10-12 session closed after final Problem03 correction. Correct monotonic-stack solution; all six JUnit methods pass, including 500 oracle comparisons, input preservation, empty/singleton/extreme prices and 100000-element increasing/equal sequences. Each original price is pushed once and popped at most once: O(n) time, O(n) auxiliary stack space and O(n) output. Clear single-stack local implementation, original prices retained for comparison and equality handled correctly. Solved with conceptual assistance (level 2); initial repeated restoration made time quadratic, retain partial rather than independent pass. Monotonic-stack review stage 0, next review October 13. No pending correction. Problem03 is completed task 1/4 of the explicitly requested Stack-only sequence: next THREE assignments must be Stack only, unless student changes preference. Problem02 remains deferred unchanged. No new task today; no automatic mode selection.

2026-10-12 Problem03 revision checked: all five tests still pass, but O(n^2) remains. New restoration condition left.peek() > prices[i] is always true: only entries greater than prices[i] are transferred to left in this iteration, and left starts empty. Therefore every removed candidate is restored exactly as before. Clarify this local condition at hint level 1; optimization remains pending. Student code unchanged; no scheduling advancement or new task.

2026-10-12 Problem03 first attempt: correct outputs, all five JUnit methods pass (three examples, 500 direct first-eligible-price comparisons with preservation, empty/singleton/extreme prices). Implementation scans right to left, temporarily removes all larger suffix prices and restores them; this does not maintain a monotonic stack. Worst-case O(n^2) time on increasing prices because each suffix is removed/restored repeatedly; O(n) auxiliary space plus O(n) output. Student complexity statement pending. Level-0 guiding trace requested; optimization pending, review partial, no monotonic-stack stage advancement. Student implementation unchanged. This is task 1/4 of requested Stack-only sequence; three further Stack tasks remain, none to be assigned today. Problem02 deferred.

2026-10-12 explicit student override: next four coding tasks must be Stack only, starting with week_42_october_2026/Problem03 (first later less-or-equal price discount). Problem03 is task 1/4, assigned with three basic tests; attempt pending. Three further Stack tasks remain to be assigned in future turns/sessions, based on demonstrated needs. This preference overrides the normal 60/40 REVIEW mix until those four tasks are completed or student changes it. Problem02 shipping-capacity workspace preserved unchanged and deferred without attempt for later. Problem03 remains the final task for today; no further assignment this session.

2026-10-12 student requests exactly one final task. Unattempted discount Problem02 replaced before implementation with shipping capacity within a day budget (Medium, due Binary Search/search-on-answer transfer). Three basic tests, neutral stub, explicit order/whole-package/day semantics. Attempt and complexity pending; no scheduling advancement. After assessing this task, close session without assigning another. Earlier discount assignment superseded, not an attempt. ArrayDeque versus Stack API rationale explained using official Java documentation.

2026-10-12 Problem01 finalized: student correctly explains linear total work through removal on collisions; clarified that noncollision iterations transfer one left entry to right. Correctness, implementation quality and O(n) time/O(n) space assessed. Semantics clarification is not an algorithm hint; hint 0. Stack first-practice stage 0 due October 13 retained. Problem02 (first later less-or-equal price discount) assigned as a short transfer of the taught next-element idea, with three basic tests and no implementation. Attempt pending. Remaining-time question asked to adapt earlier-topic practice; session ongoing.

2026-10-12 Problem01 correction verified: all nine JUnit methods pass, including 1000 direct adjacent-collision simulations, empty/singleton inputs, extreme sizes, 100000-element chains, repeated calls and input preservation. Correct two-stack right-to-left implementation; student independently revised after task-semantics clarification, no algorithm solution supplied. Coach complexity O(n) time / O(n) auxiliary space; student explanation pending. First successful Stack practice: stage 0, next review October 13. Initial failures were affected by inadequate task wording; earlier recurrence attribution is superseded and does not establish a new durable weakness. No pending correction.

2026-10-12 Problem01 first attempt: partial, correction pending, level-1 counterexample feedback. Seven tests run, five pass. Moving-apart pair [-2, 1] incorrectly returns [-2]; [5, 10, -5, -20] incorrectly remains unchanged instead of [-20]. Solution unmodified. Coach complexity: O(n) time (each iteration removes at least one left-stack item), O(n) auxiliary space. Student complexity statement pending. No successful Stack practice stage yet.

2026-10-12 REVIEW: week_42_october_2026/Problem01 (asteroid collisions, Stack transfer, Medium) assigned with three basic tests. One-hour session; independent attempt and time/space complexity pending. No result, solved count, or review advancement.

2026-10-11 close: Problem10 (minimum eating speed, Medium) solved independently, hint 0. All five JUnit methods pass, including 500 direct-speed comparisons, maximum-size/hour cases, singleton inputs and input preservation. Correct progressing binary-search bounds and overflow-safe remaining-hour budget; readable local state and helpers. Coach complexity: O(n log M) time, O(1) auxiliary space, M = maximum pile size. Student complexity explanation not requested because the student ended today. First successful search-on-answer practice: stage 0, next review October 12. Earlier boundary-search schedule remains October 13. Stack remains current; no further task today.

2026-10-11 STUDY transition: Problem10 skipped without an attempt at the student's request to move beyond already practiced Binary Search; no correctness result, solved count, or scheduling advancement. Stack worked teaching examples (bracket matching, postfix evaluation, daily temperatures) saved in lessons/stack/lesson.md; these are not student attempts. Understanding check pending; no new coding task assigned yet.

2026-10-11 STUDY: Problem10, minimum eating speed (Binary Search / search on answer, Medium), assigned in week_41_october_2026 with three basic example tests after teaching and saving the lesson. Attempt pending; correctness, implementation quality and complexity unassessed; no solved count or review advancement.

2026-10-11 final: Problem09 review pass, hint 0. Student correctly identifies O(n) time and O(n) auxiliary space; constant factors simplified. Frequency accounting stage 2 -> 3, next review October 25. Single-task session complete; no pending task.

2026-10-11: Problem09 independently correct, algorithm hint level 0 (task semantics clarified). Five test methods pass, including 500 occurrence-pairing comparisons and maximum-length cases. Clear count-and-consume implementation. Coach complexity: expected O(n) time / O(n) auxiliary space due to unmatched-guess list. Student complexity statement pending; no review advancement yet. No further task.

2026-10-09 REVIEW: Problem09 (exact and misplaced digit matches with duplicates, Medium) assigned with three basic tests. Earlier-topic frequency accounting, overdue October 1. Exactly one task requested; attempt pending, no assessment or scheduling change.

2026-10-09 Problem08 correction verified: all nine tests pass, including 500 direct-enumeration comparisons, input preservation, empty/single inputs and maximum-size large differences. Correct final solution after level-2 feedback; expected O(n) time / O(n) auxiliary space. Coach assessed complexity; student analysis not supplied. Retain partial, stage 0, next review October 10. No pending task.

2026-10-08 Problem08 second revision: added symmetric trimming, six of seven tests pass, off-center segment still missed (expected 2, actual 0). Current O(n) time / O(1) auxiliary space; numeric range sufficient, input preserved. Level-2 cumulative-difference feedback; correction pending, partial stage 0 due October 9 retained. No new task.

2026-10-08 Problem08 revision checked: five of six tests pass. long sums fix overflow; two scans cover prefixes and suffixes, but omit segments touching neither end. New counterexample expected 2, actual 0. Current O(n) time / O(1) space; level-1 feedback, correction pending. Partial and October 9 review unchanged; student solution unmodified.

2026-10-08 Problem08 assessed: three basic tests pass, two targeted tests fail (interior matching segment and overflow false equality). Implementation checks only equal prefixes from index zero. Coach complexity: O(n) time / O(1) auxiliary space; student analysis not supplied. Level-1 feedback, partial review, earliest-boundary stage 0 retained, next review October 9. Student implementation unchanged; correction pending, no further task.

2026-10-08 REVIEW: Problem08 (longest aligned equal-sum segment in two arrays, Medium) assigned with three basic tests. Exactly one task requested. First attempt pending; no assessment or review advancement.

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

# Weak Points

2026-10-15 Problem08 post-session refinement verified: idx now starts at 0 and is incremented in the initial slow==fast branch, naturally returning 0 for empty input without a special guard. All six existing test methods pass, including 1000 oracle comparisons and maximum-length cases. O(n) time / O(1) auxiliary space unchanged. Initialization is more uniform; unused enhanced-for variable, multi-counter flow and old stack alternative remain cleanup opportunities. Student implementation unchanged by coach. Same assisted attempt, no additional solved task, recovery evidence or scheduling advancement; session remains closed.

2026-10-15 two-task REVIEW closed: Problem08 correction verified; all six JUnit methods pass, including 1000 original-frequency oracle comparisons, repeated calls, empty/singleton/extreme values and 100000-element distinct/paired/equal inputs. Active retainUnique is correct, O(n) time / O(1) auxiliary space. fast is monotone; each input position is skipped at most once, plus n outer iterations. It tentatively writes each group then retracts the output count for duplicates; writes stay at/before the current source group. Implementation quality: unused enhanced-for n and redundant outer traversal obscure control; old public retainUniqueStack/import/Count remain as cleanup, student code unchanged. Result solved with hints/corrections, maximum hint 3 (coach explicitly confirmed Two Pointers and read/write roles at student request); scheduling fail per hint policy, Two Pointers stage 1 -> 0, next review October 16. Contract tracking remains active, next check October 16; no independent recovery from assisted correction. Problem07 independently correct (five test methods pass), O(n) time/O(n) auxiliary space assessed by coach, student complexity statement not provided; monotonic stage 0 retained, next review October 16 without full independent review-pass claim. Both requested tasks complete; no pending algorithm correction or further task. Stack block dates unchanged.

2026-10-15 Problem08 revision: new retainUnique uses constant auxiliary space; original three tests pass, added empty-input test fails (expected 0, actual 1). idx starts at 1 and empty input never enters the loop. Local counterexample feedback level 1; correction pending, student implementation unchanged. Coach assessment O(n) time / O(1) auxiliary space for active method: fast only advances and outer loop has n iterations. Quality: unused enhanced-for variable and redundant loop control; legacy public stack alternative remains in class (workspace expects one public solution method). Prior coach response explicitly named Two Pointers and explained read/write roles after student asked; maximum assistance now level 3, so do not classify final review as independent/pass. Two Pointers stage 1 retained provisionally while correction pending; final scheduling outcome must account for level-3 assistance. No new weakness occurrence for this revision, task 2/2, no new task.

2026-10-15 Problem08 first attempt: all three basic tests pass, but implementation violates the explicit in-place/no-additional-array-or-collection contract by using Stack<Count>. On a strictly increasing input all n entries remain in the stack. Coach assessment O(n) time / O(n) auxiliary space; entries are pushed and popped at most once. Output construction appears consistent with sorted input; full validation deferred until contract correction. Labeled continue and two while loops add bookkeeping. Level-0 guiding question asks maximum stack size on a distinct increasing array and whether the result can be written directly into nums without a collection. Student code unchanged; correction pending, task 2/2, no further task. Contract-tracking recurrence: explicit storage restriction missed; active status retained, no recovery claim from this attempt. Two Pointers review partial, stage 1 retained, reviewed October 15, next review October 18. Problem07 complexity statement still pending; its existing schedule retained.

2026-10-15 two-task REVIEW: Problem07 independently correct, hint 0. All five JUnit methods pass: three examples, 500 direct-enumeration comparisons with input preservation and repeated calls, empty/singleton input, and maximum-length increasing/equal/decreasing prices. Correct compressed-span monotonic stack: each entry pushed once and popped at most once; coach assessment O(n) time / O(n) auxiliary space plus output. Local state and span aggregation clear. Optional cleanup: ArrayDeque, static nested entry and clearer entry naming. Student complexity statement pending; retain monotonic stage 0 and existing due date until finalized. One independent implementation recovery demonstration on October 15; do not mark durable recovery before complexity assessment. Problem08 (retain only values occurring exactly once in a sorted array, in-place) assigned as task 2/2 for overdue Two Pointers stable compaction (due October 8). Neutral stub and three basic tests; attempt pending, no further assignment this session.

2026-10-15 new MODE: REVIEW session opened for exactly two tasks. Problem07 (stock spans, Medium) assigned as task 1/2 with neutral stub and three basic tests; attempt and complexity pending. Plan one Stack transfer and one overdue earlier-topic variant, assigned sequentially. One further task remains unassigned. No new assessment, weakness or recovery evidence; review schedules and Stack block dates unchanged. Session ongoing; see sessions/2026-10-15-two-task-review.md.

2026-10-15 Problem06 final correction verified: indices now track appended output positions. All seven JUnit methods pass, including 500 exhaustive minimum-removal comparisons (validity, preserved letters, subsequence order, optimal length), repeated calls, empty/plain input and 100000-character cases. Correct minimum-removal algorithm: unmatched closings cannot be matched by future openings; remaining unmatched openings must be removed. Expected O(n) time with HashSet membership, O(n) auxiliary space. Local state and separate filtering clear; character field/top check redundant, idx can be sb.length(), ArrayDeque<Integer> would reduce bookkeeping. Student code unchanged. Solved after level-1 local feedback and meaningful corrections: partial matching practice, stage 0, reviewed October 15, next review October 16. No independent recovery claim. Problem06 completes task 4/4 of Stack-only commitment and task 3/3 of the session begun October 14. Session closed; no new task. Future REVIEW returns to normal 60/40 mix unless student changes scope; Stack block dates unchanged.

2026-10-15 Problem06 revision: original three tests pass; two added contract tests fail. ")(" expected empty, actual "("; ")a(b" expected "ab", actual "a(". Stack stores original input indices but filtering compares them with positions in sb, which shifts after skipped closing parentheses. Local index-coordinate feedback level 1; same attempt, no implementation edits, correction pending. Expected O(n) time with HashSet, O(n) auxiliary space; stack entries and exclusion set remain linear. Redundant character field/top check and legacy Stack are optional cleanup. No new weakness occurrence or review advancement for this revision; no new task, final Stack-only task still pending.

2026-10-15 continuation of MODE: REVIEW: Problem06 first attempt assessed. Two of three basic tests pass; "(ab" returns "(ab" instead of "ab". Unmatched closing parentheses are skipped correctly, but unmatched opening parentheses remain in the output. Level-0 guiding question focuses on what a nonempty stack means at the end and whether current character-only entries identify output positions. No solution supplied or student code edited. O(n) time / O(n) auxiliary space including stack and builder. Unused invalid counter and idx alias, redundant top-character check are cleanup opportunities. Correction pending; partial assessment, no new successful matching practice or review advancement. One task remains to complete in the Stack-only sequence, no additional task assigned. Student complexity statement pending.

2026-10-14 Problem05 correction verified: all six test methods pass, including 500 nested cases and maximum decoded length. readBack and final reconstruction now append then reverse, removing quadratic front insertion. For encoded length n, output length L and nesting depth D, O(n + L*(D+1)) upper-bound time because nested levels may reprocess expanded text, O(n+L) auxiliary space. Count front insertion remains but counts have at most three digits under contract, so constant per count. Character-stack implementation correct, local and readable; unused import and legacy Stack are optional cleanup. Efficiency improvement assisted at level 2 (append/reverse explicitly suggested); retain partial parsing first practice, start stage 0 due October 15. Problem05 completes task 3/4 of Stack sequence and task 2/3 today. Problem06 minimum parentheses removal (Medium) assigned with neutral stub, full minimum-removal/order/letter-preservation contract and three basic tests: task 4/4 sequence, 3/3 today. One Stack task remains to complete, none further to assign; close after assessment, no fourth task today.

2026-10-14 Problem05 first attempt: output correctness verified, all six JUnit methods pass (500 generated nested cases, empty/plain/multidigit/empty-body cases, repeated calls, 100000-character decoded result). Character-stack nesting and count order correct. Efficiency assessment pending: repeated StringBuilder.insert(0, ...) shifts existing characters; final reconstruction alone is Theta(L^2) for decoded length L. readBack adds quadratic work per extracted body, potentially repeated across nesting; safe generalized upper bound O(n*(L+1)^2), auxiliary space O(n+L), where n is encoded length. Local state and helper separation clear; unused StandardCharsets import and redundant builder reset are minor cleanup. Level-0 guiding question asks cost of final front-insertion loop; no optimized solution provided, student complexity statement pending. Current task remains 2/3 today; one further Stack assignment reserved. No parsing stage advancement or independent efficiency/mastery claim before assessment is finalized.

2026-10-14 Problem04 final correction verified: correct two-pass circular scan, entries pushed only in first pass, unresolved values receive -1. All 11 JUnit methods pass including 1000 direct-search comparisons, input preservation/repeated calls, extreme values, singleton and maximum-length increasing/decreasing/equal sequences. O(n) time / O(n) auxiliary space plus O(n) output. Each index pushed once and popped at most once; modulo is never evaluated for empty input. Readable local state; redundant inequality check, value/index objects and legacy Stack are optional quality improvements. Solved after level-1 counterexamples and meaningful corrections: retain partial monotonic-stack stage 0, next review October 15. No independent recovery claim. Problem04 completes task 2/4 of Stack sequence and task 1/3 today. Problem05 nested string decoding (Medium) assigned with neutral stub and three basic tests; task 3/4 in sequence and 2/3 today, attempt pending. Two Stack tasks remain to complete including Problem05; one remains unassigned.

2026-10-14 Problem04 revision: previous seven tests pass; added [3,5,1] fails (expected [5,-1,3], actual [5,-1,5]). Eight tests total, seven pass. Empty-input and equal-maximum handling corrected. Remaining suffix entries are all assigned the global maximum, losing the first qualifying value encountered after wraparound. Level-1 local counterexample; same unresolved attempt, implementation unchanged. O(n) time / O(n) auxiliary space plus output; second stack adds bookkeeping and the inner inequality check remains redundant. Correction pending; retain partial stage 0 and October 15 review, no new weakness occurrence or schedule advancement. Two further tasks remain unassigned today.

2026-10-14 Problem04 first attempt assessed: four original/example tests pass; seven tests total, three fail. [2,2]: expected [-1,-1], actual [-1,2]; [5,3,4,2]: expected [-1,4,5,5], actual [-1,4,5,4]; empty input throws EmptyStackException. Linear first pass correctly resolves strictly smaller pending values, but final stack unwinding treats adjacent unresolved entries as valid circular answers without checking traversal order or strictness. Local counterexample feedback level 1; implementation unchanged, correction pending. O(n) time (each entry pushed once/popped once), O(n) auxiliary space plus O(n) output. Redundant element.val != nums[i] inside a strictly-smaller loop; temporary trace comments remain. Student complexity explanation pending. Monotonic-stack review partial, stage 0 retained, next review October 15. Three Stack tasks remain to complete including Problem04; two tasks remain unassigned today.

2026-10-14 MODE: REVIEW opened for exactly three Stack tasks, honoring the remaining Stack-only sequence. Problem04 (circular next-greater values, Medium) assigned with a neutral stub and three basic tests: task 2/4 in the sequence, task 1/3 today. Attempt and complexity pending; three tasks remain to complete including Problem04, two remain unassigned. No assessment, review advancement or new weakness/recovery evidence. Existing schedules and learning-block dates retained; session ongoing.

This file contains recurring weaknesses that future sessions should actively revisit.

Do not record every typo. Record issues likely to affect future problem solving or interview performance.

## Active weak points


2026-10-13 Problem02 final correction verified: correct shipping-capacity binary search, upper bound weights.length*10000 is sufficient and <=1000000000 under the contract (no int overflow). All nine JUnit methods pass, including 500 direct capacity-enumeration comparisons, input preservation, repeated calls and maximum-length tests with days=1 and days=n. Local state, progressing bounds and capped feasibility helper are sound. O(n log(10000*n)) time / O(1) auxiliary space. Solved after level-1 local feedback; retain partial and search-on-answer stage 0 due October 14. No pending correction, no new task; three Stack-only assignments remain. Optional quality improvements: tighter max/sum bounds and boolean helper name because howManyDays returns a classification, not the actual day count. Student implementation unchanged.


2026-10-13 Problem02 revision: prior six tests now pass; added maximum-weight two-package case fails ([10000,10000], days=1: expected 20000, actual 10000). Seven tests total, six pass. Binary-search updates and final return are corrected; unreachable helper branch removed. Remaining upper bound 10000 constrains capacity to the maximum individual package weight, excluding valid multi-package loads. Correction pending, local feedback level 1; same attempt, no new weakness occurrence or schedule advancement. O(n log(R+1)) time / O(1) auxiliary space, currently fixed R=9999. Student implementation unchanged; no new task.

2026-10-13 Problem02 shipping-capacity assessment: recurrence of search-boundary/return-contract errors; hard-coded upper bound excludes allowed answers and ans remains zero when only earlier-finishing candidates are encountered. Four of six tests pass, correction pending, level-1 local feedback. Keep implementation precision active; no independent recovery evidence. Search-on-answer review stage 0 partial, next October 14.

2026-10-12 session closed after final Problem03 correction. Correct monotonic-stack solution; all six JUnit methods pass, including 500 oracle comparisons, input preservation, empty/singleton/extreme prices and 100000-element increasing/equal sequences. Each original price is pushed once and popped at most once: O(n) time, O(n) auxiliary stack space and O(n) output. Clear single-stack local implementation, original prices retained for comparison and equality handled correctly. Solved with conceptual assistance (level 2); initial repeated restoration made time quadratic, retain partial rather than independent pass. Monotonic-stack review stage 0, next review October 13. No pending correction. Problem03 is completed task 1/4 of the explicitly requested Stack-only sequence: next THREE assignments must be Stack only, unless student changes preference. Problem02 remains deferred unchanged. No new task today; no automatic mode selection.

2026-10-12 Problem03 revision checked: all five tests still pass, but O(n^2) remains. New restoration condition left.peek() > prices[i] is always true: only entries greater than prices[i] are transferred to left in this iteration, and left starts empty. Therefore every removed candidate is restored exactly as before. Clarify this local condition at hint level 1; optimization remains pending. Student code unchanged; no scheduling advancement or new task.

2026-10-12 Problem03 first attempt: correct outputs, all five JUnit methods pass (three examples, 500 direct first-eligible-price comparisons with preservation, empty/singleton/extreme prices). Implementation scans right to left, temporarily removes all larger suffix prices and restores them; this does not maintain a monotonic stack. Worst-case O(n^2) time on increasing prices because each suffix is removed/restored repeatedly; O(n) auxiliary space plus O(n) output. Student complexity statement pending. Level-0 guiding trace requested; optimization pending, review partial, no monotonic-stack stage advancement. Student implementation unchanged. This is task 1/4 of requested Stack-only sequence; three further Stack tasks remain, none to be assigned today. Problem02 deferred.

2026-10-12 explicit student override: next four coding tasks must be Stack only, starting with week_42_october_2026/Problem03 (first later less-or-equal price discount). Problem03 is task 1/4, assigned with three basic tests; attempt pending. Three further Stack tasks remain to be assigned in future turns/sessions, based on demonstrated needs. This preference overrides the normal 60/40 REVIEW mix until those four tasks are completed or student changes it. Problem02 shipping-capacity workspace preserved unchanged and deferred without attempt for later. Problem03 remains the final task for today; no further assignment this session.

2026-10-12 student requests exactly one final task. Unattempted discount Problem02 replaced before implementation with shipping capacity within a day budget (Medium, due Binary Search/search-on-answer transfer). Three basic tests, neutral stub, explicit order/whole-package/day semantics. Attempt and complexity pending; no scheduling advancement. After assessing this task, close session without assigning another. Earlier discount assignment superseded, not an attempt. ArrayDeque versus Stack API rationale explained using official Java documentation.

2026-10-12 Problem01 finalized: student correctly explains linear total work through removal on collisions; clarified that noncollision iterations transfer one left entry to right. Correctness, implementation quality and O(n) time/O(n) space assessed. Semantics clarification is not an algorithm hint; hint 0. Stack first-practice stage 0 due October 13 retained. Problem02 (first later less-or-equal price discount) assigned as a short transfer of the taught next-element idea, with three basic tests and no implementation. Attempt pending. Remaining-time question asked to adapt earlier-topic practice; session ongoing.

2026-10-12 Problem01 correction verified: all nine JUnit methods pass, including 1000 direct adjacent-collision simulations, empty/singleton inputs, extreme sizes, 100000-element chains, repeated calls and input preservation. Correct two-stack right-to-left implementation; student independently revised after task-semantics clarification, no algorithm solution supplied. Coach complexity O(n) time / O(n) auxiliary space; student explanation pending. First successful Stack practice: stage 0, next review October 13. Initial failures were affected by inadequate task wording; earlier recurrence attribution is superseded and does not establish a new durable weakness. No pending correction.

2026-10-12 Problem01 first attempt: partial, correction pending, level-1 counterexample feedback. Seven tests run, five pass. Moving-apart pair [-2, 1] incorrectly returns [-2]; [5, 10, -5, -20] incorrectly remains unchanged instead of [-20]. Solution unmodified. Coach complexity: O(n) time (each iteration removes at least one left-stack item), O(n) auxiliary space. Student complexity statement pending. No successful Stack practice stage yet.

2026-10-12: Stack review Problem01 assigned; attempt pending. No new weakness or recovery evidence. Contract tracking remains active; existing dates retained until assessment.

2026-10-11 close: Problem10 independently correct, five test methods pass including maximum inputs and 500 oracle comparisons. Remaining-hour subtraction rejects immediately when negative, avoiding cumulative overflow without long. No new weakness. Additional correct implementation on the same day as Problem09; retain active contract tracking and October 12 check because separated-time recovery is still required.

2026-10-11 Stack introduction: no student implementation assessed and no new weakness or recovery evidence. Existing contract-tracking status retained. Lesson highlights empty-stack checks, operand order, strict comparisons, repeated popping, and total-operation complexity. Binary Search practice skipped by request; skipping is not a failure.

2026-10-11 STUDY: Binary Search introduced; no implementation assessed and no new weakness or recovery evidence. Existing contract-tracking status and review dates retained. Practice checklist emphasizes return contract, progressing bounds, and aggregate numeric range.

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

### Monotonic-stack candidate pruning

**Category:** invariant / complexity
**First observed:** 2026-10-12
**Last observed:** 2026-10-12
**Occurrences:** 1
**Status:** active

Problem03 initially restored all larger candidates after each query, giving
correct answers but quadratic work. After conceptual feedback, the student
permanently discards dominated values; optimal correction verified.
Training: distinguish temporary storage from permanent removal of candidates
made unnecessary by a closer, no-larger value; count lifetime pushes and pops.
Next review: 2026-10-13, stage 0, partial assisted first practice.
Resolve after separated independent applications with correct lifetime analysis.

### Implementation precision and task-contract tracking

**Category:** implementation-bug
**First observed:** 2026-09-13
**Last observed:** 2026-10-13
**Occurrences:** 12
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

2026-10-13 (stage 3 retained; no new October 12 recurrence attributed after semantics clarification; independent recovery assessment pending)

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

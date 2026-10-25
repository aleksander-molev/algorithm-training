# Spaced Repetition Rules

2026-10-25 Problem11 independently correct, algorithm hint 0 (task semantics clarified only). All six JUnit methods pass: three original examples, empty/singleton/equal/extreme prices and repeated calls, all 9841 ternary price arrays of lengths 0–8 against a direct backward-scan oracle, and four 100000-day cases (increasing, decreasing, equal, decreasing followed by a maximum). Input preservation and separate output verified. Correct decreasing stack of price/span groups; each popped group is included in the current span, and equality correctly merges. Deferred result writes are correct because each stored span is already final when pushed. Coach assessment O(n) amortized total time / O(n) auxiliary space excluding output: each entry is pushed and popped once, worst stack size n. Quality: storing idx and writing results on pop/final drain are unnecessary; result[i] can be written once days is computed, allowing idx and final drain removal. Student implementation preserved. Student complexity statement absent; monotonic candidate-pruning stage 0 retained, last practiced October 25, next review October 26, no full pass advancement or durable recovery claim. Existing weaknesses retained; no new correctness weakness. Original three-task set complete: Problem09 and Problem10 corrected after local feedback, Problem11 independently correct. No pending correction or new task. Linked List target transition October 24 has passed; next STUDY should introduce Heap/Priority Queue, without automatically switching this REVIEW session or extending the old block (introduced October 17, hard maximum October 31).

2026-10-23 Problem10 correction verified: all eight JUnit methods pass, including original examples, both regression cases, empty/short source, repeated pattern letters, overlapping matches, repeated calls, all 2000 deterministic reference comparisons and four 100000-character cases (dense output, full-length pattern, repeated resets, repeated surplus). Correct fix: when a surplus current character replaces the same character at the left boundary, remaining demand for that character stays unchanged. Other removed characters restore their demand and pSize. Monotone left gives O(n+m) expected time under fixed lowercase alphabet; resets cost at most 26 entries. O(m) auxiliary space excluding O(r) output because p.toCharArray() allocates m characters; maps have at most 26 keys. Quality: correct but multiple repair/reset branches and ambiguous target/pSize names increase bookkeeping; clearer names and removing scratch comments would help. Student implementation preserved. Solved after level-1 local feedback and meaningful corrections; partial Sliding Window review, stage 1 retained, last practiced October 23, next review October 26 (three-day interval). Supersedes October 24 correction check, now complete. Student complexity statement absent; no independent recovery claim. Problem11 is the final pending task of the original three; no additional assignment. Linked List block dates unchanged.

2026-10-23 Problem10 revision: termination defect fixed, but frequency bookkeeping remains incorrect. Five of seven test methods pass; concrete regression s="aaba", p="abc" expects [] but returns [1] although c never appears. Deterministic reference comparisons also fail: s="babbaaabbcaccaaca", p="ccbba" expects [7], actual [5,6,7,10,11,12]. Level-1 local counterexample feedback retained; no pattern/pseudocode supplied. Student solution preserved. Coach complexity for terminating revision: O(n+m) expected time with fixed 26-letter alphabet, O(m) auxiliary space excluding output due to p.toCharArray(); left now advances monotonically and reset copies at most 26 entries. Quality: pSize and target counters can diverge after surplus-character handling. Correction and student complexity explanation pending; no solved credit or review advancement. Sliding Window stage 1 and October 24 follow-up retained. Problem11 remains pending.

2026-10-23 Problem10 first assessment: four of five JUnit methods pass (three original examples plus empty input, pattern longer than source, overlapping repeats and repeated calls). s="abbc", p="abc" should return [] but times out after two seconds: surplus-character inner loop leaves left unchanged when s[left] differs from currCh. Student implementation preserved; only tests added. Level-1 local counterexample/progress feedback, correction pending, no solved credit. Current worst-case runtime is unbounded due to nontermination; auxiliary space O(m) excluding output because p.toCharArray() allocates m characters, while lowercase maps are bounded by 26 keys. Quality: counter bookkeeping and nested repair/reset branches are fragile; do not infer correctness after the termination fix without broader tests. Sliding Window partial, stage 1 retained, last reviewed October 23, next check October 24 for pending correction. No durable new weakness or recovery claim; other schedules and block dates unchanged. Problem11 remains unattempted; no new task.

2026-10-22 Problem09 correction verified: all seven JUnit methods pass, including empty/singleton, all 8188 binary lists of lengths 2–12, original examples and two 100000-node cases. Original node values and every next link preserved, including after mismatches. Added early return correctly handles empty/singleton input. Correct reverse-first-half comparison and restoration; coach assessment O(n) time / O(1) auxiliary space. Quality: continuing restoration after mismatch is sound; clearer pointer names and removing scratch comments remain optional improvements. Student code unchanged by coach. Solved after level-1 boundary feedback, partial review; Linked List stage 0 retained, last practiced October 22, next review October 23. Student complexity explanation absent; existing contract weakness remains active without independent recovery claim. Problem10 and Problem11 remain pending, no additional task. Block dates unchanged.

2026-10-22 Problem09 first attempt: six of seven JUnit methods pass; singleton [7] throws NullPointerException at mid = mid.next because the first loop never initializes mid. Original examples, empty input, all 8188 binary lists of lengths 2–12, and two 100000-node cases pass with original node values/links restored. Reverse-first-half comparison with restoration is otherwise correct. Coach assessment O(n) time / O(1) auxiliary space. Quality: restoration continues after mismatch, correctly preserving the contract; mid/slow overlap, headtail naming and commented scratch code obscure roles. Level-1 local boundary feedback; correction and student complexity statement pending. Student implementation preserved. Partial Linked List review, stage 0 retained, last practiced October 22, next review October 23. Existing boundary-contract weakness remains active; no independent recovery or solved credit yet. Problem10 and Problem11 remain pending; no extra assignment.

2026-10-21 Problem08 correct after conceptual guidance (maximum hint level 2). All five JUnit methods pass: original examples, all 729 prefix/suffix length combinations 0–8, six maximum-size shapes, empty inputs, shared heads, one list contained in the other, disjoint equal-valued lists, repeated calls, node identity and complete next/value preservation. Correct length alignment and identity comparison. Counting loop processes all of A before B because of else; still O(n+m), not parallel counting. Alignment gives equal remaining lengths, so disjoint pointers reach null together safely. Coach assessment O(n+m) time / O(1) auxiliary space; student identified linear counting plus linear traversal before coding, space explanation not separately supplied. Quality: clear alignment; two separate length loops and Math.abs(countA-countB) would read more directly. Student code unchanged. Guidance history: clarified shared suffix; student proposed reversal, coach flagged mutation contract and shared-link effects, asked about equalizing distance (level 2), then confirmed the student length-alignment idea with concrete traversal steps. Do not classify as independent. Partial Linked List review, stage 0 retained, last practiced October 21, next review October 22; contract weakness remains active without independent recovery claim. Three-task session complete: Problem06 corrected after level-1 feedback, Problem07 independently correct, Problem08 correct after conceptual guidance. No pending coding correction or additional task. Block October 17–24, hard maximum October 31.

2026-10-21 Problem07 independently correct, hint 0. All six JUnit methods pass: original examples, empty/singleton/extreme values, all 4096 combinations of six sorted value-group counts 0–3, and four 100000-node cases (all equal, all distinct, pairs, alternating duplicate and singleton groups). Verified original surviving node identity/order, unchanged values, null termination and repeated calls on one instance. Correct tentative-append/rollback algorithm: copyPtr remains the predecessor of the candidate lastAdded, so a repeated group can be removed and replaced by the next candidate. Coach assessment O(n) time / O(1) auxiliary space, including one dummy node; head only advances, so nested loops do not multiply work. Quality: local state is safe, but copyPtr is a predecessor rather than a copy pointer; clearer names and removal of scratch comments would help. Student implementation unchanged. Student complexity explanation pending; Linked List stage 0 and October 22 review retained without full pass advancement or durable recovery claim. No new correctness weakness. Problem08 is the final pending task of the requested three; no additional assignment. Block dates unchanged.

2026-10-21 Problem06 correction verified: all eight JUnit methods pass, including original examples, empty/singleton, lengths 0–40 with rotations through three full lengths plus one and k=1000000000, eight 100000-node rotations, duplicate/extreme values, original node identities/order, preserved values, null termination and repeated calls on one instance. Correct reverse/split/reverse approach: reversing the first k nodes of the reversed list restores the original suffix order, while reversing the remainder restores the original prefix order. Empty input and zero normalized rotation now handled correctly. Coach assessment O(n) time / O(1) auxiliary space, including k=0 for nonempty input (two full traversals); no nodes allocated. Quality: successor saving is sound; clearer names for revers, tail and resTail would improve readability. Student implementation unchanged by coach. Solved after level-1 boundary feedback; partial review, stage 0 retained, last practiced October 21, next review October 22. Student complexity explanation absent; existing contract-tracking weakness retained without independent recovery claim. Problem07 and Problem08 remain pending; no further task. Linked List block October 17–24, hard maximum October 31.

2026-10-21 Problem06 first attempt: original three examples pass; three added boundary tests fail. Empty input with k=3 throws ArithmeticException at k % len (len=0). [1,2,3], k=3 and [7], k=1 throw NullPointerException at resTail.next because normalized k=0 leaves resTail null. Reverse/split/reverse approach works for the original nonzero-remainder examples and reuses nodes. Coach assessment O(n) worst-case time / O(1) auxiliary space; k=0 returns immediately. Quality: successor saving is correct, but result/tail/resTail naming obscures chain roles and the final join assumes a nonempty moved group. Local counterexample feedback level 1; student implementation unchanged, correction and student complexity statement pending. Boundary/empty-result contract weakness remains active; no recovery claim or solved count. Linked List stage 0 retained, partial, last reviewed October 21, next review October 22. Problem07 and Problem08 remain pending; no new task. Block dates unchanged.

2026-10-20 Problem05 independently correct, hint 0. All six JUnit methods pass: original examples, empty/singleton, lengths 2–100, 99999/100000 nodes, duplicate/extreme values, repeated calls, original node identity/order, preserved values and null termination. Correct alternative algorithm: count nodes, reverse the first ceil(n/2), weave the halves with parity-dependent starting side, then reverse the combined chain. Coach assessment O(n) time / O(1) auxiliary space, including one dummy node; a constant number of linear passes. Quality: extra final reversal and parity-specific merge add bookkeeping; half can use (n + 1) / 2 without floating point, and descriptive names would help. Student implementation unchanged. Both requested implementations independently correct; student complexity explanations absent. Retain Linked List stage 0, last practiced October 20, next review October 21, without full review-pass advancement or durable weakness recovery claim. No new correctness weakness; existing weaknesses retained. Two-task review complete, no further assignment. Linked List block remains October 17–24, hard maximum October 31.

2026-10-20 Problem04 independently correct, hint 0. All five JUnit methods pass: three original examples, all 11480 valid sections for lengths 1–40, and five 100000-node cases (whole list, prefix, suffix, interior, final singleton). Verified original node identity/order, unchanged duplicate/extreme values, null termination and repeated calls on one instance. Correct section reversal and reconnection. Coach assessment O(n) time / O(1) auxiliary space: input traversal only advances, with one helper node. Quality: res/resHead/end names and two count increments make the traversal harder to follow; no implementation changes required or made. Student complexity statement pending; retain Linked List stage 0 and existing due date provisionally, no full review-pass advancement or durable weakness recovery claim. No new correctness weakness; existing weaknesses retained. Problem05 remains task 2/2; no further assignment. Block dates unchanged.

2026-10-19 three-task Linked List REVIEW complete. Problem03 independently correct, hint 0: all six JUnit methods pass, including original examples, empty/singleton, lengths 2–100, 99999/100000 nodes, repeated calls, duplicate/extreme values, stable original-node grouping, preserved values and null termination. Correct two-chain stable grouping; clearing both previous tails before each append is safe because iter was saved by the preceding iteration and is distinct from both tails. Coach complexity O(L) time / O(1) auxiliary space (two dummy nodes). Quality: clear group tails, but tail clearing at the start of the next iteration makes reachability less immediate to follow; no change required. Student code unchanged. Problem01 solved after level-1 boundary correction; Problem02 and Problem03 independently correct. Complexity assessed by coach, no separate student statements; retain Linked List stage 0, next review October 20, no full review-stage advancement or durable weakness recovery claim. Existing weaknesses retained; block remains October 17–24 (hard maximum October 31). All three requested tasks complete, no further assignment.

2026-10-19 Problem02 independently correct, algorithm hint 0 (adjacent-pair semantics clarified only). All six JUnit methods pass: original examples, empty/singleton, lengths 2–100, 99999/100000-node lists, duplicate/extreme values, original node identity/order/value preservation, termination and repeated calls on one instance. Correct local pair rewiring with saved next-pair reference and predecessor reconnection. Coach complexity O(L) time / O(1) auxiliary space, each pair processed once without allocations. Implementation readable with a focused helper; helper next==null branch is redundant under caller guard, and prev = pairStart would express the new tail directly. Student implementation unchanged. Student complexity statement pending; Linked List stage 0 and October 20 review retained, no full review-pass advancement or durable recovery claim. Problem01 complete after correction; Problem03 remains the final pending task of three.

2026-10-19 Problem01 correction verified: all six test methods pass, including every deletion position for lengths 1–40 (820 cases), singleton removal, repeated calls on one solution instance, duplicate/extreme values and 100000-node head/middle/tail removals. Correct reverse/remove/reverse algorithm, original surviving node identities/order and values preserved, output terminates. Coach complexity O(L) time / O(1) auxiliary space; two helper nodes are constant space. Quality: helper-node identity comparisons and duplicated reversal loops add avoidable bookkeeping; no implementation edits by coach. Solved after level-1 boundary feedback, partial first practice; Linked List starts stage 0, practiced October 19, next review October 20. No independent recovery claim; existing active weaknesses retained. Problem02 and Problem03 remain pending, session open; no additional task.

2026-10-17 STUDY: Linked List becomes the most recently introduced learning block; Stack ended early with student agreement. Existing review dates/stages unchanged. Do not create a Linked List review stage until meaningful successful practice; teaching alone gives no scheduling advancement.

This file defines deterministic review scheduling for algorithm patterns and weak points.

## Default review stages

Use these stages after a meaningful learning attempt:

| Stage | Next review |
|---|---|
| 0 | 1 day |
| 1 | 3 days |
| 2 | 7 days |
| 3 | 14 days |
| 4 | 30 days |
| 5 | maintained / occasional mixed review |

A review should normally test the same concept with a related variant rather than the exact same code.

## Review outcome

After each scheduled review, classify the result.

### Pass

Use when all are mostly true:

- solved independently or with hint level 0–1;
- correct pattern recognized;
- reasoning is sound;
- complexity is explained correctly;
- implementation is stable.

Action:
- advance one stage;
- schedule the next interval from the table.

### Partial

Use when the core idea is understood but one of these happens:

- hint level 2;
- meaningful implementation bug;
- weak invariant explanation;
- complexity confusion;
- correct solution only after substantial self-correction.

Action:
- keep the same stage;
- schedule another review using the current stage interval, or sooner when appropriate.

### Fail

Use when any of these happens:

- hint level 3+ is required;
- the pattern is not recognized after a fair attempt;
- the student cannot explain why the solution works;
- the same conceptual mistake repeats;
- implementation cannot be completed without pseudocode/full explanation.

Action:
- move back one stage, minimum stage 0;
- schedule review for the next day;
- update `docs/weak-points.md` when the failure reveals a durable weakness.

## New concept

After the first meaningful successful attempt, start at stage 0 and schedule review in 1 day.

If the student already demonstrates strong independent mastery during diagnostic work, starting at stage 1 or 2 is allowed.

## Review scheduling after block introduction

Spaced repetition is subordinate to the learning-block schedule. It never has startup priority over a pending new-block introduction.

At session startup:
1. read `docs/progress.md` and determine the current learning block;
2. if the current block topic has not yet been introduced, introduce that topic before selecting any review problem;
3. only after the block topic has been introduced may due or overdue reviews drive task selection in later sessions;
4. when reviewing, prefer the highest-value weakness rather than mechanically choosing the oldest overdue item.

If `docs/progress.md` marks the current block introduction as not started yet:
- do not start in review mode;
- do not use an old-topic warm-up;
- do not select the oldest overdue item first;
- do not reuse an old pending workspace as the first task;
- introduce the current block topic first and record its actual introduction date.

Overdue reviews never delay a scheduled topic introduction or transition.

After the block topic has been introduced, review-heavy sessions are allowed. Weak review results affect future review frequency, not roadmap timing.

Progression guardrail:
- ordinary blocks are about 7 days by default and may end earlier;
- difficult blocks may extend up to 14 days from the actual introduction date;
- after 14 days, advance regardless of review results;
- weak topics remain in spaced repetition while the roadmap continues.

## Pattern transfer

Prefer this progression:

1. exact concept learned with guidance;
2. related problem with similar structure;
3. hidden-pattern variant;
4. mixed interview problem where the student must choose the pattern.

Do not count memorizing an old solution as a successful review.

## Tracking format

For active reviews, store enough information to know:

- topic or weakness;
- stage;
- last result: pass / partial / fail;
- last reviewed date;
- next review date;
- relevant problem or evidence.

`docs/progress.md` should contain the concise due-review view. Detailed evidence belongs in session files and `docs/weak-points.md`.

## Resolving a weak point

A weak point may be marked resolved after at least two convincing independent demonstrations separated in time, preferably including one related variant.

Resolved weak points do not need frequent dedicated reviews, but may still appear in mixed interview sessions.


## MODE: REVIEW session composition


2026-10-13 Problem02 final correction verified: correct shipping-capacity binary search, upper bound weights.length*10000 is sufficient and <=1000000000 under the contract (no int overflow). All nine JUnit methods pass, including 500 direct capacity-enumeration comparisons, input preservation, repeated calls and maximum-length tests with days=1 and days=n. Local state, progressing bounds and capped feasibility helper are sound. O(n log(10000*n)) time / O(1) auxiliary space. Solved after level-1 local feedback; retain partial and search-on-answer stage 0 due October 14. No pending correction, no new task; three Stack-only assignments remain. Optional quality improvements: tighter max/sum bounds and boolean helper name because howManyDays returns a classification, not the actual day count. Student implementation unchanged.

2026-10-13 assessment-only REVIEW: shipping-capacity Problem02 partial (four of six tests pass), correction pending. Search-on-answer stage 0 retained, last reviewed October 13, next review October 14. Boundary-search and Stack schedules unchanged; three Stack assignments remain. Contract tracking remains active after range/return-contract recurrence, no recovery evidence.

2026-10-12 session closed after final Problem03 correction. Correct monotonic-stack solution; all six JUnit methods pass, including 500 oracle comparisons, input preservation, empty/singleton/extreme prices and 100000-element increasing/equal sequences. Each original price is pushed once and popped at most once: O(n) time, O(n) auxiliary stack space and O(n) output. Clear single-stack local implementation, original prices retained for comparison and equality handled correctly. Solved with conceptual assistance (level 2); initial repeated restoration made time quadratic, retain partial rather than independent pass. Monotonic-stack review stage 0, next review October 13. No pending correction. Problem03 is completed task 1/4 of the explicitly requested Stack-only sequence: next THREE assignments must be Stack only, unless student changes preference. Problem02 remains deferred unchanged. No new task today; no automatic mode selection.

2026-10-12 Problem03 first attempt: correct outputs, all five JUnit methods pass (three examples, 500 direct first-eligible-price comparisons with preservation, empty/singleton/extreme prices). Implementation scans right to left, temporarily removes all larger suffix prices and restores them; this does not maintain a monotonic stack. Worst-case O(n^2) time on increasing prices because each suffix is removed/restored repeatedly; O(n) auxiliary space plus O(n) output. Student complexity statement pending. Level-0 guiding trace requested; optimization pending, review partial, no monotonic-stack stage advancement. Student implementation unchanged. This is task 1/4 of requested Stack-only sequence; three further Stack tasks remain, none to be assigned today. Problem02 deferred.

2026-10-12 explicit student override: next four coding tasks must be Stack only, starting with week_42_october_2026/Problem03 (first later less-or-equal price discount). Problem03 is task 1/4, assigned with three basic tests; attempt pending. Three further Stack tasks remain to be assigned in future turns/sessions, based on demonstrated needs. This preference overrides the normal 60/40 REVIEW mix until those four tasks are completed or student changes it. Problem02 shipping-capacity workspace preserved unchanged and deferred without attempt for later. Problem03 remains the final task for today; no further assignment this session.

2026-10-12 Problem01 correction verified: all nine JUnit methods pass, including 1000 direct adjacent-collision simulations, empty/singleton inputs, extreme sizes, 100000-element chains, repeated calls and input preservation. Correct two-stack right-to-left implementation; student independently revised after task-semantics clarification, no algorithm solution supplied. Coach complexity O(n) time / O(n) auxiliary space; student explanation pending. First successful Stack practice: stage 0, next review October 13. Initial failures were affected by inadequate task wording; earlier recurrence attribution is superseded and does not establish a new durable weakness. No pending correction.

2026-10-12 Problem01 first attempt: partial, correction pending, level-1 counterexample feedback. Seven tests run, five pass. Moving-apart pair [-2, 1] incorrectly returns [-2]; [5, 10, -5, -20] incorrectly remains unchanged instead of [-20]. Solution unmodified. Coach complexity: O(n) time (each iteration removes at least one left-stack item), O(n) auxiliary space. Student complexity statement pending. No successful Stack practice stage yet. Contract tracking partial, stage 3 retained, next check October 13; other schedules unchanged.

2026-10-11 close: Problem10 subsequently completed independently and verified with five passing test methods. First successful search-on-answer practice: stage 0, practiced October 11, next review October 12; complexity assessed by coach (student ended session). Existing boundary-search stage 2 due October 13 retained; contract tracking October 12 retained, because today's two demonstrations are not separated in time. Stack remains current without a practice schedule. No new task.

2026-10-11 Stack transition: student explicitly ended Binary Search early and skipped Problem10 without an attempt. Stack is now the most recently introduced learning block. Existing review stages and due dates remain unchanged, including Binary Search boundary-search review October 13. Teaching examples are not successful attempts; no Stack or search-on-answer stage is created yet. Begin Stack scheduling after its first meaningful successful practice attempt.

2026-10-11 STUDY: Binary Search is now the most recently introduced learning block. Existing boundary-search stage 2 review due October 13 remains unchanged; all older-topic dates retained. Search-on-answer practice Problem10 is pending. Create its stage-0 schedule only after the first meaningful successful attempt; teaching alone does not advance reviews.

2026-10-11 final: Problem09 complexity correctly identified by student as linear time and space; clarified O(2n) = O(n). Frequency accounting review pass, stage 2 -> 3, last reviewed October 11, next review October 25. Contract tracking independent implementation check pass, stage 3 retained while active recovery awaits second separated demonstration; next mixed check October 12. All other schedules unchanged. Single-task session complete.

2026-10-11: Problem09 frequency-accounting implementation independently correct; five test methods pass. Student complexity statement pending, so stage 2 and October 1 due date remain unchanged until final assessment. No new task. Contract tracking has one independent recovery demonstration since latest regression; active status retained.

2026-10-09 correction verified: Problem08 final solution correct, nine tests pass. Retain partial after level-2 feedback; earliest-boundary stage 0, last reviewed October 9, next review October 10. Contract tracking active, stage 3 retained, partial, next check October 10. No independent recovery evidence from assisted correction; other schedules unchanged.

2026-10-08 second revision: Problem08 six of seven tests pass; symmetric trimming still misses off-center interior segments. Level-2 conceptual feedback. Correction pending; retain partial, earliest-boundary stage 0 due October 9 and contract-tracking stage 3 check October 9. No scheduling changes.

2026-10-08 revision check: Problem08 overflow corrected, but interior segments touching neither end remain unsupported. Five of six tests pass. Retain partial, earliest-boundary stage 0 due October 9 and active contract-tracking stage 3 check October 9. No schedule advancement or new task.

2026-10-08: Problem08 partial review. Three basic tests pass; two targeted tests fail because interior segments are missed and int sums overflow. Earliest-boundary stage 0 retained, last reviewed October 8, next review October 9. Contract tracking active, stage 3 retained, partial, earlier check October 9. Correction pending; all other schedules unchanged. Exactly one task requested, no additional workspace.

2026-10-07 final correction: Problem07 empty-boundary initialization corrected by student and verified; all five tests pass. Retain partial from first attempt, earliest-boundary stage 0 due October 8, and active contract-tracking check October 8. No pending correction or task.

2026-10-07 session finalized: Problem07 earliest-boundary-map review partial due to missing empty prefix boundary. Three basic tests pass, two added test methods fail. Stage 0 retained, next review 2026-10-08. Correction deferred at student's request to end today. Contract tracking stage 3 remains active, partial, October 8 check retained. Counting review due October 10; Sliding Window due October 10; other dates unchanged.

2026-10-07: Problem06 Sliding Window review partial: implementation independent and correct, but auxiliary-space estimate required correction for the fixed alphabet. Stage 1 retained, next review 2026-10-10. Student acknowledged correction. Final requested Problem07 targets overdue Prefix Sum earliest-boundary-map transfer; pending, keep its existing schedule until assessed.

2026-10-07: Problem05 counting transfer solved independently; all five tests pass, including neutral zeros, maximum answer and oracle comparisons. Student correctly reports O(n) time / O(n) space (expected time with HashMap). Counting review pass, stage 0 -> 1, next review 2026-10-10. Earliest-boundary-map schedule unchanged because this task assesses counting. Problem06 assigned for overdue Sliding Window review; no result yet.

2026-10-05 scheduling update: Prefix Sum earliest-boundary-map practice first passed independently; start stage 0, next review 2026-10-06. Implementation precision passed on a second pattern after a one-week gap; resolved as a dedicated weakness, stage 3 routine mixed-review check due 2026-10-19. Other schedules unchanged.

When the student explicitly starts `MODE: REVIEW` mode:

- target about 60% of problems from the most recently studied learning block;
- target about 40% from all earlier learned topics;
- select the 40% primarily by due/overdue review dates from the calendar;
- distribute those 40% broadly across learned material rather than repeatedly choosing only the weakest topic;
- weak points may receive shorter future intervals, but weakness alone is not the task-selection priority;
- do not introduce a new roadmap topic in `MODE: REVIEW`.

The 60/40 target applies across the session as a whole.

2026-10-05 later update: sorted-array at-most-two compaction first attempt is partial (empty-input return contract); Two Pointers stays stage 1, next review 2026-10-08. Implementation precision reopened, stage 3 retained with an earlier check on 2026-10-08. Correction pending; do not advance either stage yet.

Problem02 correction verified on 2026-10-05 after level-1 local feedback; retain partial and existing 2026-10-08 dates. Problem03 pending; no scheduling evidence yet.

2026-10-06: Problem03 assessed, partial. Balanced-subarray counting passes small-input validation but overflows at maximum input. Track counting variant at stage 0, next review 2026-10-07; correction and student complexity explanation pending. Do not advance the earliest-boundary-map review from this different output contract. Implementation precision remains active with its 2026-10-08 check.

Problem03 correction verified on 2026-10-06: all five tests pass, complexity correctly reported. Retain partial and stage 0 counting review due 2026-10-07. Problem04 assigned for the overdue Binary Search review; no outcome or schedule advance yet.

2026-10-06 session finalized on 2026-10-07: Problem04 independently correct, Binary Search boundary-search review pass. Advance stage 1 to stage 2; next review 2026-10-13 (seven days from actual practice date). Complexity assessed by coach: O(log n) time / O(1) space; student analysis not elicited because the student ended the session. Other schedules unchanged.


2026-10-14: Problem04 circular next-greater review partial; four of seven tests pass, correction pending after level-1 local counterexamples. Monotonic-stack stage 0 retained, last reviewed October 14, next review October 15. Other pattern schedules unchanged; no advancement or recovery evidence.

2026-10-14 final Problem04: correction verified with 11 passing test methods; partial review retained after meaningful first-attempt defects, stage 0 due October 15. Problem05 parsing transfer assigned, no review scheduling evidence yet.

2026-10-14 Problem05 nested parsing: first successful practice after assisted efficiency improvement, partial stage 0, last practiced October 14, next review October 15. Six tests pass. Problem06 pending, no further scheduling evidence.

2026-10-15 Problem06 matching/minimum removal: first successful practice after local corrections, partial stage 0, next review October 16. Seven test methods pass. Other schedules retained; four-task Stack-only override fulfilled, normal REVIEW mix resumes in future sessions.

2026-10-15 Problem08: Two Pointers stable compaction review partial due to explicit in-place/no-collection contract violation (Stack uses O(n) auxiliary space). Stage 1 retained, last reviewed October 15, next review October 18; correction pending after level-0 guiding feedback. Contract tracking remains active; next check October 16. Problem07 independent implementation correct, complexity statement pending, monotonic-stack schedule unchanged.

2026-10-15 two-task session final: Problem08 corrected and verified (six test methods); maximum hint 3, Two Pointers stage 1 -> 0 under Fail scheduling rule, next review October 16. Supersedes provisional October 18 date. Contract tracking remains active, next check October 16. Problem07 independently correct implementation (five test methods), coach assessed O(n)/O(n), student complexity statement absent; monotonic candidate-pruning stage 0 retained, last reviewed October 15, next review October 16, no full pass advancement. Session complete, no new task.

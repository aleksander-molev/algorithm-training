# Spaced Repetition Rules

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

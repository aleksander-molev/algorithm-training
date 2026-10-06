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

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

## Due review priority

At session startup:

1. identify all reviews with `next review <= today`;
2. select the highest-value one or two review items that fit the review time budget;
3. review them briefly;
4. then continue with roadmap progression or the current new topic.

Do not interpret an overdue queue as a requirement to clear every overdue item before learning something new.

Default review budget:
- 45–60 minute session: 10–15 minutes;
- 75–90 minute session: 15–20 minutes.

The majority of a normal session should be spent on new/current learning material.

A full review-only session should happen only when:
- the student explicitly requests review-only mode; or
- a severe prerequisite regression makes the planned new topic unproductive.

If there is more review work than fits the budget, leave the remaining items scheduled/overdue for later sessions.

Progression guardrail:
- if two consecutive meaningful sessions introduced no genuinely new topic, the next normal session must introduce new material;
- a weak topic may remain in spaced repetition while the roadmap continues.

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

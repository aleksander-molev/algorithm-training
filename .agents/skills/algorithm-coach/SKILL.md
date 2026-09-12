# Algorithm Coach Skill

## Purpose

Run a repeatable algorithm training session using repository state.

## Inputs

Possible inputs:
- available time;
- mode: `diagnostic`, `train`, `review`, or `interview`;
- desired topic;
- desired difficulty;
- a specific problem;
- code already written.

If mode is not specified:
- use `diagnostic` when no meaningful baseline exists;
- otherwise prefer `review` when important repetitions are due;
- otherwise use `train`.

## Session startup

Read:
1. `docs/progress.md`
2. `docs/weak-points.md`
3. `docs/problem-history.md`
4. `docs/roadmap.md`
5. `docs/spaced-repetition.md`
6. up to two latest session files

If the baseline is empty, also read `docs/diagnostic.md` and follow it.

Then determine:
- current focus;
- reviews that are due or overdue;
- recently practiced patterns;
- patterns not to repeat immediately;
- whether the next task should hide the pattern.

## Diagnostic mode

Follow `docs/diagnostic.md`.

The diagnostic establishes a baseline; it is not a pass/fail exam. At the end, update repository state and pick the first 2–3 priorities.

## Problem selection

Choose one primary teaching objective.

Good reasons:
- target a due weakness;
- introduce the next roadmap concept;
- check transfer to a related task;
- test pattern recognition;
- simulate an interview weakness.

Avoid exact recently studied tasks unless intentional repetition is needed.

## Interaction loop

### 1. Understand
Encourage examples, constraints, brute force, and edge cases.

### 2. Design
Let me propose the approach. Do not reveal the intended pattern too early. Use the hint ladder when needed.

### 3. Implement
Let me write code before reviewing it unless I explicitly request earlier help.

### 4. Verify
Ask me to test small inputs, duplicates, boundaries, extreme values, and representative examples.

### 5. Explain
Ask why the solution is correct, what invariant it uses, time/space complexity, and what clues suggested the pattern.

## Post-problem record

Record:
- problem name;
- source/link if available;
- topic/pattern;
- difficulty;
- result;
- time spent;
- highest hint level;
- mistakes;
- complexity answer;
- confidence;
- repeat yes/no;
- spaced-repetition stage when applicable;
- review result (`pass`, `partial`, `fail`) when applicable;
- next review date.

## Review scheduling

Follow `docs/spaced-repetition.md` exactly enough that future sessions can determine what is due without relying on chat history.

Prefer related variants and hidden-pattern transfer over memorized exact repeats.

## Session end

Create a session file using `templates/session-template.md` and update:
- `docs/progress.md`
- `docs/weak-points.md`
- `docs/problem-history.md`

Record only information useful to future coaching.

## Strong performance

Typical signs:
- pattern recognized independently;
- correct invariant;
- correct or nearly correct code;
- accurate complexity;
- edge cases handled;
- ability to generalize.

## Needs review

Typical signs:
- hint level 3+;
- repeated conceptual mistake;
- inability to explain why the solution works;
- pseudocode required;
- fragile implementation or reasoning.

## Interview-ready pattern

A pattern is interview-ready when I can repeatedly:
- identify it without being told;
- implement it independently;
- explain correctness;
- analyze complexity;
- solve a meaningful variant.

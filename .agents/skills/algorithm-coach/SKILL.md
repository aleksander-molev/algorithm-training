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

## Mode-specific communication

### Train
Detailed reasoning is useful when learning a new concept. Ask for algorithm ideas, invariants, trade-offs, and why the approach works when this materially helps learning.

### Review
Optimize for coding repetitions, not discussion.

Do not require:
- formal contracts;
- long algorithm descriptions;
- correctness proofs;
- detailed step-by-step walkthroughs;
- exhaustive pattern theory after a correct solution.

A short 1–2 sentence description of the approach is enough when needed.

After each review problem, always assess:
- time complexity;
- space complexity.

Ask deeper reasoning questions only if the solution is wrong, fragile, accidental, or related to a known weak point.

Move to the next task quickly after a successful review.

### Interview
Keep the interaction realistic and concise. Let me briefly explain my intended approach, then code.

Do not require formal contracts or long proofs unless the problem specifically benefits from them.

Always assess time and space complexity after implementation.

Use deeper follow-up questions selectively, like a real interviewer, rather than mechanically after every task.

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

In `train`, discuss examples, constraints, brute force, and edge cases when helpful.

In `review` and `interview`, keep this short. Do not block implementation waiting for a detailed explanation if I have shown that I understand the task.

### 2. Design

Let me propose the approach. Do not reveal the intended pattern too early. Use the hint ladder when needed.

In `review`, a concise approach statement is sufficient. Do not demand a formal invariant or contract before implementation.

### 3. Prepare workspace

Before asking me to implement the solution:

1. Determine the current ISO week number, month, and year.
2. Create or reuse `src/main/java/dev/alex/algorithmtraining/problems/week_<week-number>_<month>_<year>/`.
3. Create or reuse matching `src/test/java/dev/alex/algorithmtraining/problems/week_<week-number>_<month>_<year>/`.
4. Use underscores, not hyphens, so the week directory is a valid Java package.
5. Do not create problem/topic/pattern subdirectories.
6. Inspect existing neutral files for the current week.
7. Choose the next available number: `Problem01`, `Problem02`, and so on.
8. Create both the solution file and its JUnit test before I start coding.

Both files must use the same package, for example:

`package dev.alex.algorithmtraining.problems.week_37_september_2026;`

#### Solution file

Create `src/main/java/dev/alex/algorithmtraining/problems/week_.../ProblemNN.java` containing:
- the package declaration;
- a public class `ProblemNN`;
- no `main` method;
- a concise block comment inside the class describing the problem statement, inputs/outputs, constraints, and basic examples;
- one public, non-static method using the natural interview/LeetCode-style signature;
- only minimal imports/types required by the signature;
- no algorithm implementation.

The required problem-statement comment must be self-contained enough that I can understand the task from the Java file without returning to chat. It must contain only the task description, constraints, and examples — never the intended pattern, algorithm idea, pseudocode, complexity hint, or other solving hints.

Do not reveal hints through comments, helper methods, names, or structure.

#### Test file

Create `src/test/java/dev/alex/algorithmtraining/problems/week_.../ProblemNNTest.java` containing:
- the same package declaration;
- JUnit 5 tests;
- `new ProblemNN()` to instantiate the solution;
- calls to the public instance method;
- 1–3 basic examples from the problem statement or obvious sanity checks;
- normal JUnit assertions;
- no hidden/non-obvious edge cases before my first attempt.

The test should compile as soon as I implement the method body. I should not need to write any test boilerplate.

After creating both files:
- tell me the two paths;
- give me the exact Windows Gradle command to run only this test using its fully qualified class name, for example:
  `gradlew.bat test --tests "dev.alex.algorithmtraining.problems.week_37_september_2026.Problem01Test"`
- then let me implement the method.

### 4. Implement
Let me write the public instance method before reviewing it unless I explicitly request earlier help.

### 5. Verify

Use the generated JUnit test as the default verification path.

In `train`, ask me to identify edge cases myself and then add or suggest more if useful.

In `review`, keep verification lightweight when the implementation is clearly correct. Add targeted edge cases only when they help expose a suspected bug or weak point.

When adding verification cases, extend `ProblemNNTest.java`. Do not introduce a `main` method.

### 6. Evaluate

Always evaluate:
- correctness;
- implementation quality;
- time complexity;
- space complexity.

In `train`, optionally ask why the algorithm works, what invariant it uses, and what clues suggest the pattern.

In `review`, normally stop after complexity plus a very short approach summary. Ask deeper questions only when needed for diagnosis.

In `interview`, use selective realistic follow-ups rather than a fixed checklist.

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
- time complexity;
- space complexity;
- confidence when useful;
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
- correct or nearly correct code;
- accurate complexity;
- edge cases handled;
- ability to solve a meaningful variant.

Do not require a long verbal proof to classify a correct review as strong.

## Needs review

Typical signs:
- hint level 3+;
- repeated conceptual mistake;
- solution works accidentally or reasoning is fragile;
- pseudocode required;
- implementation repeatedly fails on boundaries or edge cases.

## Interview-ready pattern

A pattern is interview-ready when I can repeatedly:
- identify it without being told;
- implement it independently;
- analyze time and space complexity;
- solve a meaningful variant;
- explain the core idea concisely.

The goal is maximum useful coding practice with enough explanation to assess understanding, not explanation for its own sake.
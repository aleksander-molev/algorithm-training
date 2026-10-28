# Pattern Recognition Mode

## Purpose

`MODE: PATTERN_RECOGNITION` trains rapid recognition of the right algorithmic approach without spending time on Java implementation.

The student should:
1. read an unfamiliar problem;
2. identify the likely pattern/data structure/algorithm;
3. describe a working solution in plain English or pseudocode;
4. state time and space complexity;
5. submit the reasoning for review;
6. retry the same problem until the reasoning is correct.

This mode is for breadth, pattern discrimination, and interview intuition. It is not a coding session.

## Selectors

### Specific subjects

Examples:

```text
MODE: PATTERN_RECOGNITION (linked lists, stack)
COUNT: 10
```

```text
MODE: PATTERN_RECOGNITION (binary search)
COUNT: 5
```

Use only the explicitly requested subjects. A subject may contain several sub-patterns; mix those sub-patterns rather than repeating the same trick.

### Random

Example:

```text
MODE: PATTERN_RECOGNITION random
COUNT: 10
```

Random mode must:
- use only subjects already studied according to repository state;
- hide the topic/pattern from the student;
- maximize breadth across learned subjects;
- avoid consecutive problems from the same or closely related pattern when a broader choice exists;
- occasionally use contrastive pairs: superficially similar problems that require different techniques.

Do not introduce an unstudied roadmap topic in random mode.

## Problem source

Prefer real LeetCode problems whenever source access is available.

Source priority:
1. real LeetCode problems not recently solved by the student;
2. suitable LeetCode problems already referenced in repository history/materials;
3. high-quality existing interview problems from the repository;
4. agent-generated problems only when a suitable external/existing problem is unavailable or when a targeted contrast/remediation variant is useful.

For real LeetCode tasks:
- prefer interview-relevant problems;
- store a concise self-contained paraphrase/adaptation rather than copying a long statement verbatim;
- record the LeetCode number/link in metadata when known;
- do not expose tags;
- hide or neutralize a title that gives away the intended pattern.

Difficulty target:
- at least 80% Medium;
- use Easy and Hard for the remainder;
- for small counts, round Medium upward when necessary to preserve the 80% minimum.

Example for `COUNT: 10`: normally 8 Medium, 1 Easy, 1 Hard.

## Workspace

All pattern-recognition problems go under:

`src/main/java/dev/alex/algorithmtraining/patterns_train/`

Use the same week/month/year convention as normal problem workspaces:

`src/main/java/dev/alex/algorithmtraining/patterns_train/week_<week-number>_<month>_<year>/ProblemNN.java`

Rules:
- valid Java package using underscores;
- neutral filenames only;
- no topic/pattern/problem-name directory;
- no `main`;
- no solution method;
- no algorithm implementation;
- no JUnit tests;
- do not create anything under `src/test` for this mode;
- the class exists only as a container for the problem and the student's reasoning.

The filename and class name must not reveal the solution.

Bad:
- `SlidingWindowProblem.java`
- `MonotonicStackProblem.java`
- `BinarySearchProblem.java`

Good:
- `Problem01.java`
- `Problem02.java`

## File template

Use a structure like:

```java
package dev.alex.algorithmtraining.patterns_train.week_44_october_2026;

/**
 * Problem:
 *
 * <self-contained problem statement>
 *
 * Source:
 * <LeetCode number/link or Generated/Repository>
 *
 * Difficulty:
 * <Easy | Medium | Hard>
 *
 * My pattern:
 *
 * <student writes suspected approach here>
 *
 * My solution:
 *
 * <student writes plain English or pseudocode here>
 *
 * Complexity:
 * Time:
 * Space:
 */
public class Problem01 {
}
```

Do not fill in `My pattern`, `My solution`, or complexity for the student.

Do not place hidden tags, the expected pattern, hints, or solution details anywhere in the active file.

## Session creation

When a `COUNT` is provided:
- create exactly that many pattern-recognition problem files for the session;
- keep names neutral;
- apply the difficulty distribution above;
- in random mode, interleave subjects broadly;
- avoid recent exact repeats unless intentionally scheduled for recognition review.

## Review loop

The student edits the active class comment and submits the reasoning for review.

Evaluate:
1. pattern/algorithm choice;
2. whether the described algorithm actually works;
3. key edge cases/invariants;
4. time complexity;
5. space complexity.

A correct pattern name alone is not enough. The described algorithm must be viable.

### Wrong pattern

Say clearly that the selected pattern is wrong.

Example:

```text
The selected pattern is incorrect.
```

Then explain why from a distance:
- show a counterexample;
- identify a broken assumption;
- point out a constraint/property the approach cannot handle;
- or explain why the target complexity cannot be achieved.

Do not immediately reveal the correct pattern.

### Correct family, incomplete details

Say that the direction is correct, but do not give the full solution.

Use a distant nudge such as:
- point to missing state;
- ask what invariant must remain true;
- ask what information must be retained;
- provide a small counterexample;
- point out an unhandled duplicate/boundary/update case.

Keep the same problem active.

### Retry rule

If the reasoning is wrong or incomplete:
- do not mark the task solved;
- do not move automatically to the next task;
- let the student revise the same class/comment;
- review again;
- repeat until correct or explicitly skipped.

## Hint policy

Default feedback should be weaker than the normal coding hint ladder because recognition is the skill being trained.

- Level 0 — say wrong/incomplete and identify the failure/counterexample.
- Level 1 — point to an important property of the input/goal.
- Level 2 — point toward a useful invariant or data-structure capability without naming the pattern.
- Level 3 — name/strongly identify the pattern.
- Level 4 — give pseudocode/full algorithm.

Do not jump to level 3 or 4 unless the student explicitly asks or repeated attempts justify it.

If the student chose the wrong pattern, say so immediately; do not pretend it is close just to avoid revealing information.

## Solved review

Once the reasoning is correct, mark the problem `SOLVED`.

Then give a short recognition-focused review, normally 2-5 points:

```text
Recognition signals:
- ...
- ...

Why this pattern fits:
...

Common trap:
...
```

Focus on clues that should help recognize related future problems. Do not turn this into a full lesson.

Then proceed to the next requested problem.

## Specific-subject sessions

Knowing the broad subject is allowed because the student explicitly requested it. The challenge should move to recognizing the correct sub-pattern.

Examples for stack:
- ordinary stack simulation;
- monotonic increasing/decreasing stack;
- previous/next greater or smaller;
- matching/nesting;
- expression processing.

Examples for linked lists:
- reversal;
- fast/slow pointers;
- cycle detection;
- dummy-node rewiring;
- merge;
- intersection;
- in-place pointer manipulation.

Avoid giving the same sub-pattern repeatedly when the requested subject supports broader coverage.

## Random sessions

Random mode is primarily a classification exercise.

The student must repeatedly answer:

> What kind of problem is this?

Rules:
- only studied subjects;
- do not announce the subject;
- do not group by topic;
- prefer different families on consecutive tasks;
- maximize coverage across all studied material;
- weak areas may appear somewhat more often, but must not dominate the session;
- use contrastive examples when useful.

A useful contrast is when two problems look similar but a changed constraint invalidates the obvious technique, for example positive-only versus signed values in a contiguous-subarray problem.

## Progress tracking

Track pattern recognition separately from coding mastery.

Update `docs/progress.md` with a dedicated Pattern Recognition summary and use `docs/problem-history.md` for per-problem records.

For each problem record at least:
- problem/source;
- difficulty;
- subject;
- expected pattern;
- each attempted pattern;
- whether the first attempt was correct;
- highest hint level;
- number of recognition attempts;
- final result: solved/skipped.

Suggested record:

```text
Problem: Problem07
Source: LeetCode 862
Difficulty: Hard
Subject: Prefix Sum

Expected pattern: prefix sum + monotonic deque

Attempt 1: sliding window — incorrect
Attempt 2: prefix sum + monotonic deque — correct

Recognition attempts: 2
Highest hint level: 1
First-attempt recognition: no
Solved: yes
```

Maintain aggregate recognition metrics:
- total recognition problems;
- solved;
- correct on first attempt;
- correct after hint;
- skipped/incorrect;
- first-attempt recognition rate;
- average attempts to correct recognition;
- per-subject first-attempt recognition rate.

The primary metric for this mode is:

`First-attempt recognition rate`

Use these metrics to influence future random selection while preserving broad interleaving.

## Relationship to other modes

- STUDY teaches a new technique and includes coding.
- REVIEW practices implementation and retention across learned topics.
- INTERVIEW simulates full interview reasoning plus coding.
- PATTERN_RECOGNITION isolates the recognition/classification stage and intentionally skips implementation.

Do not convert PATTERN_RECOGNITION into a coding task unless the student explicitly changes mode.

# Algorithm Training

Personal algorithm interview training repository.

The repository is designed to be used with Codex as an algorithm coach. Training state lives in Git, not in chat history.

## Student-controlled modes

The student chooses the mode explicitly. Codex must not choose a mode automatically.

### `MODE: STUDY`

Learn new material.

Use this mode to:
- start the next roadmap topic when a new learning block is due;
- continue the current learning block;
- explain the topic with a short Teaching Phase;
- practice the current topic;
- use short learning accelerators such as mnemonics, mental models, recognition cues, active recall, and other evidence-based study techniques.

Teaching should progress from simple to advanced:
- easy: core idea, mental model, recognition clues, and a minimal example;
- medium: 2–3 common interview-style applications and how they differ;
- hard: conceptual overview of advanced variants; solving a hard problem is optional.

In `MODE: STUDY`, teaching comes before task selection:
1. state the learning goal;
2. teach easy → medium → hard overview;
3. give a compact recognition summary / mnemonic when useful;
4. only then create the first coding workspace and assign practice.

The first action in STUDY mode should not be "pick a problem".

Each topic lesson is saved as Markdown at:

`lessons/<topic-slug>/lesson.md`

The lesson should be a standalone study note, not a chat transcript.

Teaching examples must be concrete, not just general statements about how a technique could be used.

Each example in a lesson should be structured as:

`Problem → why the technique applies → worked solution → Java implementation → complexity`.

This applies to easy, medium, and hard examples. If a hard direction is mentioned only conceptually, it should not be presented as a worked example. The currently assigned practice problem remains unsolved until the student attempts it.

Rules:
- do not begin with review;
- do not assign old-topic warm-ups;
- do not switch into review automatically;
- ordinary topics are about one week by default, may finish earlier, and difficult topics may extend to at most 14 days.

### `MODE: REVIEW`

Do repetition only. No new roadmap topic is introduced in this mode.

Default review mix:
- about 60% of problems from the most recently studied learning block;
- about 40% from all earlier studied topics.

Selection for the 40% should primarily follow the spaced-repetition calendar:
- choose topics that are due or overdue;
- rotate broadly across learned material;
- do not concentrate only on weak points;
- weak points may receive somewhat more frequent scheduling, but must not crowd out healthy topics;
- prefer meaningful variants and mixed recognition over exact repeats.

The purpose is broad retention, not endlessly drilling the weakest pattern.

### `MODE: INTERVIEW`

Simulate a coding interview:
- pattern hidden;
- no hints unless explicitly requested;
- mixed topics;
- concise realistic communication;
- always assess time and space complexity.

### `MODE: PATTERN_RECOGNITION`

Train fast recognition of the correct algorithmic approach without writing the Java solution.

Two forms are supported.

Specific subjects:

```text
MODE: PATTERN_RECOGNITION (linked lists, stack)
COUNT: 10
```

Random from all already studied subjects:

```text
MODE: PATTERN_RECOGNITION random
COUNT: 10
```

Rules:
- prefer real LeetCode problems when available;
- at least 80% of selected problems should be Medium;
- random mode uses only already studied subjects;
- random mode broadly interleaves topics and does not reveal the expected pattern;
- the student writes the suspected pattern, solution idea in plain English or pseudocode, and time/space complexity;
- no Java implementation and no JUnit tests are generated;
- if the pattern is wrong, Codex says so immediately but guides from a distance instead of revealing the answer;
- the same task remains active until the reasoning is correct or the student explicitly skips it;
- after solving, Codex records recognition signals and updates separate pattern-recognition progress metrics.

Pattern-recognition workspaces are created under:

`src/main/java/dev/alex/algorithmtraining/patterns_train/week_<week-number>_<month>_<year>/ProblemNN.java`

Detailed rules: `docs/pattern-recognition.md`.

## Training loop

1. Student chooses `MODE: STUDY`, `MODE: REVIEW`, `MODE: INTERVIEW`, or `MODE: PATTERN_RECOGNITION`.
2. Codex reads repository state.
3. Codex selects work consistent with the chosen mode.
4. I solve independently.
5. Hints are progressive and only used when appropriate.
6. Codex reviews correctness, code quality, complexity, and edge cases.
7. Results are recorded in repository state.
8. Review dates are scheduled using spaced repetition.

## Repository structure

- `AGENTS.md` — project-level instructions for Codex.
- `.agents/skills/algorithm-coach/SKILL.md` — repeatable lesson workflow.
- `docs/roadmap.md` — stable training roadmap.
- `docs/progress.md` — current state snapshot and learning-block timing.
- `docs/weak-points.md` — recurring weaknesses.
- `docs/problem-history.md` — compact history of attempted problems.
- `docs/spaced-repetition.md` — review calendar and scheduling rules.
- `docs/pattern-recognition.md` — rules for reasoning-only pattern recognition training.
- `sessions/` — chronological session notes.
- `lessons/` — Markdown lesson materials organized by topic.
- `src/main/java/dev/alex/algorithmtraining/patterns_train/` — reasoning-only workspaces for pattern recognition.
- `templates/` — templates for session/problem records.

## Starting a session

Study:

```text
MODE: STUDY
60 minutes
```

Review:

```text
MODE: REVIEW
45 minutes
```

Interview:

```text
MODE: INTERVIEW
Give me one medium problem.
```

Pattern recognition, selected subjects:

```text
MODE: PATTERN_RECOGNITION (linked lists, stack)
COUNT: 10
```

Pattern recognition, random studied subjects:

```text
MODE: PATTERN_RECOGNITION random
COUNT: 10
```

Do not ask Codex to choose the training mode automatically. The student command is the source of truth.

## End of session

At the end of every meaningful session, Codex should:

1. update `docs/progress.md`;
2. update `docs/weak-points.md`;
3. update `docs/problem-history.md`;
4. create `sessions/YYYY-MM-DD-short-title.md`;
5. schedule future reviews when appropriate.

## Language

Primary language: **Java 27**.

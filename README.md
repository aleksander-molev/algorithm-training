# Algorithm Training

Personal algorithm interview training repository.

The repository is designed to be used with Codex as an algorithm coach. Training state lives in Git, not in chat history.

## Student-controlled modes

The student chooses the mode explicitly. Codex must not choose a mode automatically.

### `/study`

Learn new material.

Use this mode to:
- start the next roadmap topic when a new learning block is due;
- continue the current learning block;
- explain the topic with a short Teaching Phase;
- practice the current topic;
- use short learning accelerators such as mnemonics, mental models, recognition cues, active recall, and other evidence-based study techniques.

Rules:
- do not begin with review;
- do not assign old-topic warm-ups;
- do not switch into review automatically;
- ordinary topics are about one week by default, may finish earlier, and difficult topics may extend to at most 14 days.

### `/review`

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

### `/interview`

Simulate a coding interview:
- pattern hidden;
- no hints unless explicitly requested;
- mixed topics;
- concise realistic communication;
- always assess time and space complexity.

## Training loop

1. Student chooses `/study`, `/review`, or `/interview`.
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
- `sessions/` — chronological session notes.
- `templates/` — templates for session/problem records.

## Starting a session

Study:

```text
/study
I have about 60 minutes.
```

Review:

```text
/review
I have about 45 minutes.
```

Interview:

```text
/interview
Give me one medium problem.
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

Primary language: **Java 21**.

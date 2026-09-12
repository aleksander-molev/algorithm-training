# Algorithm Training

Personal algorithm interview training repository.

The repository is designed to be used with Codex as an algorithm coach. Training state lives in Git, not in chat history.

## Training loop

1. Read current progress and weak points.
2. Select a suitable problem.
3. Let me solve it independently.
4. Give hints gradually only when needed.
5. Review reasoning, code, complexity, and edge cases.
6. Record mistakes and strengths.
7. Schedule repetitions using spaced repetition.
8. Update repository state at the end of the session.

## Modes

- `train` — learn or strengthen a topic; progressive hints are allowed.
- `review` — revisit due weak points and old patterns.
- `interview` — simulate a real interview; pattern hidden, hints only if requested.

## Repository structure

- `AGENTS.md` — project-level instructions for Codex.
- `.agents/skills/algorithm-coach/SKILL.md` — repeatable lesson workflow.
- `docs/roadmap.md` — stable training roadmap.
- `docs/progress.md` — current state snapshot.
- `docs/weak-points.md` — recurring weaknesses and review dates.
- `docs/problem-history.md` — compact history of attempted problems.
- `sessions/` — chronological session notes.
- `templates/` — templates for session/problem records.
- `problems/` — Java solutions grouped by topic.

## Starting a session

Examples:

```text
Start a training session. I have about 45 minutes.
```

```text
Start a training session in review mode.
```

```text
Interview mode. Give me one medium problem and do not reveal the pattern.
```

Before choosing a task, Codex should read repository state.

## End of session

At the end of every meaningful session, Codex should:

1. update `docs/progress.md`;
2. update `docs/weak-points.md`;
3. update `docs/problem-history.md`;
4. create `sessions/YYYY-MM-DD-short-title.md`;
5. schedule future reviews when appropriate.

## Language

Primary language: **Java 21**.

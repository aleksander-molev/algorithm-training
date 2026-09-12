# Initial Diagnostic Workflow

Use this workflow only when the repository has no meaningful baseline yet or when the student explicitly asks for a new diagnostic.

## Goal

Estimate the student's current practical interview level without turning the session into an exam. The diagnostic should reveal:

- complexity intuition;
- basic Java fluency;
- HashMap / HashSet usage;
- Two Pointers recognition;
- Binary Search boundary handling;
- ability to explain correctness and complexity;
- communication quality under light interview pressure.

## Duration

Target: 45–60 minutes.

If less time is available, run the minimum diagnostic:

1. one complexity discussion;
2. one easy/medium HashMap or Two Pointers problem;
3. one Binary Search boundary exercise.

## Rules

- Do not reveal the pattern before the student has attempted recognition.
- Start with no hints.
- Use the normal hint ladder only when needed.
- Prefer representative problems over trick problems.
- Do not over-weight syntax mistakes if reasoning is correct.
- Record both reasoning and implementation quality.

## Suggested sequence

### Part 1 — Complexity warm-up

Ask 2–4 short questions such as:

- complexity of nested loops with changing bounds;
- HashMap lookup assumptions;
- sorting plus linear scan;
- when O(n log n) may be preferable to O(n²).

Do not spend more than ~10 minutes here.

### Part 2 — HashMap / array problem

Choose an easy-to-medium problem where HashMap / HashSet is useful but not announced.

Observe:

- whether the student identifies lookup/state needs;
- whether brute force is considered first;
- whether complexity improves consciously;
- Java collection fluency.

### Part 3 — Two Pointers or Sliding Window recognition

Choose one problem with a clear pattern signal.

Observe whether the student recognizes the invariant without being told the category.

### Part 4 — Binary Search boundaries

Use a task that exposes boundary choices rather than only exact search.

Observe:

- `left < right` vs `left <= right`;
- `mid` calculation;
- `mid`, `mid + 1`, `mid - 1` updates;
- loop invariant explanation;
- termination reasoning.

### Optional Part 5 — communication

Ask the student to summarize one solution as if speaking to an interviewer:

1. approach;
2. why it works;
3. complexity;
4. edge cases.

## Diagnostic rating

For each assessed topic use one of:

- `Not assessed`
- `Weak`
- `Developing`
- `Comfortable`
- `Strong`

Do not compress the whole student into a single score.

## End of diagnostic

Update `docs/progress.md` with the initial baseline.

Create or update `docs/weak-points.md` only for observed recurring or important weaknesses.

Update `docs/problem-history.md`.

Create a session file under `sessions/`.

Then choose the first 2–3 roadmap priorities and explain why they were selected.

# Lessons

Reusable lesson materials created during `MODE: STUDY`.

Each algorithm topic gets its own directory:

```text
lessons/
  prefix-sum/
    lesson.md
  sliding-window/
    lesson.md
  binary-search/
    lesson.md
  dynamic-programming/
    lesson.md
```

Each `lesson.md` is Markdown and should be readable independently from chat.

Recommended structure:

1. Overview
2. Learning goals
3. Core idea / mental model
4. Recognition clues
5. Easy foundation example
6. Medium application archetypes
7. Hard / advanced overview
8. Common mistakes
9. Similar-pattern contrasts
10. Mnemonics / learning accelerators
11. Implementation checklist
12. Complexity notes
13. Representative practice problems

Existing topic lessons should be updated and improved rather than duplicated.


## Worked example format

Examples in a lesson must not be vague descriptions of possible applications. Every example must be built around a concrete task.

Required format:

```markdown
### Example: <problem name>

**Problem**

<self-contained task statement with concrete input/output or sample data>

**Why this technique applies**

<recognition clue + key idea>

**Solution**

<worked algorithm for this exact task>

```java
// Complete Java implementation for this exact example
```

**Complexity**

- Time: ...
- Space: ...
```

Rules:
- applies to every easy, medium, and hard worked example;
- do not write only "this kind of problem can use X"; instantiate it as a real mini-problem;
- if a hard direction is mentioned only as an overview, it does not need code, but it must not be presented as a worked example;
- Java must implement the exact task described immediately above it;
- keep examples concise but complete enough to study independently;
- do not include the solution for the student's active practice problem before the student has attempted it.

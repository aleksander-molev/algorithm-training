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


## Java examples

Every concrete task/example described in a lesson must be followed immediately by a Java example.

Format:

```markdown
### Example: <problem>

<short problem description>

```java
// Java example demonstrating the intended approach
```
```

Rules:
- applies to easy, medium, and hard examples whenever a concrete task is described;
- keep examples concise and readable;
- code should demonstrate the intended algorithmic idea, not just pseudocode;
- do not include the solution for the student's active practice problem before the student has attempted it.

# Weak Points

This file contains recurring weaknesses that future sessions should actively revisit.

Do not record every typo. Record issues likely to affect future problem solving or interview performance.

## Active weak points

### Implementation precision and task-contract tracking

**Category:** implementation-bug
**First observed:** 2026-09-13
**Last observed:** 2026-09-18
**Occurrences:** 5
**Status:** active

**Observed behavior**

The high-level strategy is often recovered correctly, but initial implementations have required corrections to method contracts, return types/values, variable scope, or boundary-specific requirements. On 2026-09-15, two implementations were correct independently after a stated contract and invariant. On 2026-09-17, both a frequency-accounting review and a new variable-window implementation were correct independently, including targeted edge-case checks; keep the scheduled separated-time review before resolving this weakness.

**Example**

Two Sum initially returned a collection instead of the requested `int[]`; Valid Palindrome needed scope/type and alphanumeric corrections; lower-bound Binary Search initially used exact-match return logic. In the Search Insert review, the right boundary was first updated as if `mid` could be discarded, which failed for insertion between two values. On 2026-09-18, Next Greatest Letter returned immediately after an equal value, violating the strictly-greater contract when duplicates followed.

**Training action**

Before coding, restate the method contract and target-specific invariant. Before submitting, run a short checklist: signature and types, return contract, representative edge cases, boundary updates, and complexity.

**Next review**

2026-09-19

**Resolved when**

Two independent solutions on different patterns are implemented correctly after a stated contract and edge-case check, separated in time.

---

## Entry format

### <weakness title>

**Category:** boundary-condition  
**First observed:** YYYY-MM-DD  
**Last observed:** YYYY-MM-DD  
**Occurrences:** 1  
**Status:** active

**Observed behavior**

Describe the concrete issue.

**Example**

Brief example of the mistake.

**Training action**

What should future sessions do?

**Next review**

YYYY-MM-DD

**Resolved when**

Describe objective evidence required before this can be marked resolved.

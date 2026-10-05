# Session — 2026-10-05 — Mixed review

## Mode and status

Explicit MODE: REVIEW. In progress; first task passed independently, second assigned.

## Selection

Target about 60% from the most recently studied block, Prefix Sum, and 40% from earlier learned topics. Earlier-topic selection will follow due dates and rotate broadly. No new roadmap topic introduced. The Prefix Sum target transition date is today; the next STUDY session should advance to the Binary Search block rather than making review performance a prerequisite.

## First workspace

- `src/main/java/dev/alex/algorithmtraining/problems/week_41_october_2026/Problem01.java`
- `src/test/java/dev/alex/algorithmtraining/problems/week_41_october_2026/Problem01Test.java`
- Task: longest non-empty contiguous subarray with sum k, signed integer input.
- Medium transfer variant; lesson reference examples were previously supplied, so this is a different output contract.
- Three basic example tests; method intentionally unimplemented.

## Evidence and scheduling

Problem01 passed independently, hint level 0. Correctly seeds the empty boundary and preserves the earliest occurrence of each sum. Insertion before lookup is harmless for this maximum-length contract: a newly inserted self-match when k = 0 contributes length zero. Prefix totals and subtraction fit int under the given constraints.

Implementation is readable and preserves input. The prefix array is unnecessary storage; a running total would simplify it while leaving worst-case asymptotic space unchanged. Student reported correct O(n) time (expected HashMap operations) and O(n) auxiliary space.

Validation: six JUnit methods passed, including the three initial examples, repeated prefix sums, zero targets, negative targets, maximum-size input, input preservation, and 500 deterministic small-array comparisons with a brute-force oracle. Gradle initially failed because the JUnit Platform launcher was missing; added testRuntimeOnly launcher dependency and reran successfully. Student code unchanged.

Scheduling: first successful Prefix Sum practice starts stage 0, due 2026-10-06. Implementation precision has two independent successes on different patterns separated by one week; mark resolved and retain stage 3 routine mixed review due 2026-10-19.

## Second workspace

`week_41_october_2026/Problem02.java` and matching test file: sorted-array retention of at most two copies per value, in place. Selected as a meaningful variant for the overdue Two Pointers / stable compaction review. Two basic example tests; awaiting first attempt. No review outcome or schedule advance for this task yet.

## Problem02 first-attempt assessment

Time O(n), auxiliary space O(1), correctly reported. The read pointer only moves forward across the nested loops. Two example tests, short non-empty inputs, signed duplicate runs, and 500 deterministic sorted-array comparisons with an independent frequency oracle passed. Empty-array test failed: expected 0, actual 1, due to the length-less-than-two branch. Five test methods ran; four passed. Student implementation unchanged; ask for a local boundary correction before proceeding.

Implementation quality: more state and nested control flow than needed; `len` is unused. Simplification feedback can follow correction. Record partial at Two Pointers stage 1, next review 2026-10-08. Reopen implementation contract tracking after this recurrence; retain stage 3 with earlier check 2026-10-08. Hint level 0 at assessment; final feedback identifies the failing input without supplying code.

## Problem02 correction verified

Student corrected the short-array branch and removed unused `len`. All five JUnit methods passed, including empty input and 500 oracle comparisons. Final implementation is correct, O(n) time and O(1) auxiliary space. Local boundary feedback level 1; retain partial review because the first attempt had a contract bug. No further schedule advance. Readability can improve by naming the read/write roles and reducing nested state; no rewrite required.

## Third workspace

Created Problem03 and three basic JUnit examples before assignment. Task: count non-empty binary subarrays with equal zero and one counts, returning long and preserving input. This meaningfully changes the output from longest length to total count and practices combining two already taught prefix-sum applications. Awaiting attempt. Two of three assigned tasks are now from the latest learning block, approximating the 60/40 session target.

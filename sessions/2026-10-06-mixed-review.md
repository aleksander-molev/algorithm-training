# Session — 2026-10-06 — Mixed review

## Mode and status

Explicit MODE: REVIEW. In progress; resumed the existing Problem03 attempt from the latest learning block, Prefix Sum. Target mix remains about 60% latest block and 40% earlier topics by due dates with broad rotation. No new topic introduced.

## Problem03 assessment

Count non-empty binary subarrays containing equally many zeros and ones. Student implementation unchanged.

Correctness: three basic examples and 500 deterministic small-input comparisons with direct counting pass; input preservation passes. Maximum alternating input of length 100000 fails: expected 2500000000, accumulator overflows int. Five JUnit methods run, four pass.

Implementation quality: the map consistently stores occurrence count minus one. This unconventional representation is correct: adding the incremented stored value counts the previous matching boundaries. Naming this state as counts obscures its meaning, but it is not a correctness bug. The early short-input branch is valid. The answer accumulator type violates the maximum-answer requirement.

Complexity: expected O(n) time with HashMap operations, O(n) auxiliary space. Student analysis pending.

Feedback level 1: show failing input and expected result, point to accumulator range, request local correction and time/space estimates without providing replacement code.

## Tracking

Partial counting review, stage 0, due 2026-10-07. Earliest-boundary-map schedule remains unchanged. Record recurrence of contract/type tracking; existing 2026-10-08 check retained. Await correction before selecting the next older-topic task.

## Correction verified and next workspace

Student changed count to long and correctly reported O(n) time / O(n) space. All five JUnit methods pass, including maximum alternating input, 500 oracle comparisons, and preservation checks. Time is expected under HashMap operations. Retain partial from the first-attempt overflow and existing dates. Implementation is correct; the frequency-minus-one representation could be made clearer but requires no rewrite.

Learning hook: check the maximum possible answer separately from maximum input length.

Created Problem04 and three basic example tests before assignment. Task: target index in a rotated strictly increasing distinct-value array, or -1 if absent. This transfers earlier rotated-array boundary reasoning to a different output contract and addresses the overdue Binary Search review while rotating away from yesterday's Two Pointers task. Ask for a brief approach and implementation, aiming for O(log n) time. Await first attempt; no review result recorded.

# Mixed review — October 22, 2026

2026-10-22 MODE: REVIEW: student requested three tasks spanning previously studied material; broad mixed coverage takes priority over the default 60/40 split for this set. Assigned week_43_october_2026/Problem09 (linked-list palindrome with complete restoration), Problem10 (all rearrangement starting indices), Problem11 (consecutive price spans). Coverage: Linked List/Two Pointers, Sliding Window/frequency accounting, Stack candidate pruning. Prefix Sum and Binary Search remain due for a later rotation; three tasks do not exhaust all learned variants. Neutral unimplemented stubs, three basic example tests each, no algorithm hints. Attempts and correctness/quality/time/space assessments pending. No solved count, new weakness, recovery claim or review-stage/date advancement. Linked List block remains October 17–24, hard maximum October 31. Exactly three tasks; session open.

Assess each submitted attempt for correctness, implementation quality, time and auxiliary space. Preserve student code and follow the hint ladder. Assignment alone is not scheduling evidence.

## Problem09 first assessment

2026-10-22 Problem09 first attempt: six of seven JUnit methods pass; singleton [7] throws NullPointerException at mid = mid.next because the first loop never initializes mid. Original examples, empty input, all 8188 binary lists of lengths 2–12, and two 100000-node cases pass with original node values/links restored. Reverse-first-half comparison with restoration is otherwise correct. Coach assessment O(n) time / O(1) auxiliary space. Quality: restoration continues after mismatch, correctly preserving the contract; mid/slow overlap, headtail naming and commented scratch code obscure roles. Level-1 local boundary feedback; correction and student complexity statement pending. Student implementation preserved. Partial Linked List review, stage 0 retained, last practiced October 22, next review October 23. Existing boundary-contract weakness remains active; no independent recovery or solved credit yet. Problem10 and Problem11 remain pending; no extra assignment.

Validation: targeted Gradle run, seven test methods, six passed and singleton failed. Coach added tests only; solution unchanged.

## Problem09 correction verified

2026-10-22 Problem09 correction verified: all seven JUnit methods pass, including empty/singleton, all 8188 binary lists of lengths 2–12, original examples and two 100000-node cases. Original node values and every next link preserved, including after mismatches. Added early return correctly handles empty/singleton input. Correct reverse-first-half comparison and restoration; coach assessment O(n) time / O(1) auxiliary space. Quality: continuing restoration after mismatch is sound; clearer pointer names and removing scratch comments remain optional improvements. Student code unchanged by coach. Solved after level-1 boundary feedback, partial review; Linked List stage 0 retained, last practiced October 22, next review October 23. Student complexity explanation absent; existing contract weakness remains active without independent recovery claim. Problem10 and Problem11 remain pending, no additional task. Block dates unchanged.

Validation: targeted Problem09Test Gradle run successful, seven test methods. Student solution preserved.

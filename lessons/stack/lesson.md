# Stack: unfinished work and pending answers

## Overview and learning goals

A stack handles the most recently stored item first: last in, first out (LIFO).
The important recognition question is: **Why must the most recent unresolved item be handled next?**

By the end of this block, recognize nesting, evaluation of completed subexpressions,
and next-greater/smaller queries; choose useful stack entries; state what the stack
contains; handle equality and empty stacks; explain linear time despite a nested loop.

## Core idea and Java API

Think of a stack as a pile of unfinished work. New work goes on top. Only the top
is directly accessible. Finishing it exposes the work immediately below it.

Use `Deque<T> stack = new ArrayDeque<>();` with imports from `java.util`.
`push(x)` adds to the top; `peek()` reads it; `pop()` removes it;
`isEmpty()` checks whether it exists. `pop()` on an empty stack throws.
Keep operations at the same end; do not mix `push` with removal from the opposite end.
`ArrayDeque` does not accept null entries. Its stack operations are amortized O(1).

Recognition clues:
- A closing item must finish the most recently opened item: nesting or parsing.
- An operation consumes the most recently completed values: expression evaluation.
- Items wait for the first later greater/smaller value: consider a monotonic stack.

## Easy foundation: bracket matching

**Problem** — Given a string containing only `()[]{}`, return whether brackets
are correctly paired and nested. Empty input is valid.
`"([])" -> true`; `"([)]" -> false`.

**Why this technique applies** — A closing bracket must match the latest
unmatched opening bracket. Counts lose nesting order: `([)]` has balanced counts
but is invalid. The stack contains unmatched openings, oldest at the bottom.

**Solution** — Push opening brackets. For a closing bracket, reject an empty
stack or a mismatching top; otherwise pop the matched opening. Accept only if
the stack is empty at the end. For `([])`, bottom-to-top states are `(`, `([`,
`(`, empty. A beginner mistake is matching against any earlier opening instead
of only the top, or accepting while unmatched openings remain.

**Java**
```java
import java.util.ArrayDeque;
import java.util.Deque;

public class BracketMatching {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char opening = stack.pop();
                if ((c == ')' && opening != '(')
                        || (c == ']' && opening != '[')
                        || (c == '}' && opening != '{')) return false;
            }
        }
        return stack.isEmpty();
    }
}
```

**Complexity** — O(n) time and O(n) auxiliary space in the worst case.

## Medium application 1: postfix expression evaluation

**Problem** — Evaluate a valid postfix expression represented by tokens. An
operator follows its two operands. Operators are `+`, `-`, `*`, `/`; integer
division truncates toward zero. Assume nonzero divisors and all values and
intermediate results fit in Java `int`.
`["8", "3", "-", "2", "*"] -> 10`, representing `(8 - 3) * 2`.

**Why this technique applies** — Compared with matching brackets, the stack
now contains completed values rather than opening symbols. An operator uses
the latest two values, replaces them with one result, and makes that result
available to a later operation. Those values may represent whole subexpressions.

**Solution** — Push numbers. For an operator, pop the right operand first and
the left operand second, calculate `left operator right`, and push the result.
The example's bottom-to-top states are `[8]`, `[8, 3]`, `[5]`, `[5, 2]`, `[10]`.
The invariant is a stack of completed subexpression values not yet consumed.
Wrong approach: treating the first popped value as the left operand changes
subtraction and division. An expression-order scan with a single accumulator
also cannot retain multiple completed operands.

**Java**
```java
import java.util.ArrayDeque;
import java.util.Deque;

public class PostfixEvaluation {
    public int evaluate(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            boolean operator = token.equals("+") || token.equals("-")
                    || token.equals("*") || token.equals("/");
            if (!operator) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            int right = stack.pop();
            int left = stack.pop();
            int result = switch (token) {
                case "+" -> left + right;
                case "-" -> left - right;
                case "*" -> left * right;
                case "/" -> left / right;
                default -> throw new IllegalArgumentException(token);
            };
            stack.push(result);
        }
        return stack.pop();
    }
}
```

**Complexity** — O(n) stack operations for n tokens; total time also includes
reading/parsing their characters. O(n) auxiliary space in the worst case.

## Medium application 2: daily temperatures

**Problem** — Given integer temperatures, return an array whose entry at day i
is the number of days until the first strictly warmer day. Return 0 when none
exists. `[73, 71, 72, 75] -> [3, 1, 1, 0]`.

**Why this technique applies** — Items now wait for an answer from the future.
A new temperature can resolve several pending days. Store indices, not only
values, because the answer is an index difference. From bottom to top, pending
temperatures are non-increasing; equal temperatures remain pending. This is a
monotonic stack: the stored values obey a useful ordering in addition to LIFO.

**Solution** — Scan left to right. While the current temperature is strictly
greater than the temperature at the top index, pop that index j and set
`answer[j] = i - j`. Push i after resolving all colder top entries.
Unresolved entries keep their initialized answer 0.

Bottom-to-top trace, showing `index:temperature`:

| Current day | Action | Pending stack |
|---|---|---|
| 0:73 | Push 0 | `[0:73]` |
| 1:71 | Push 1 | `[0:73, 1:71]` |
| 2:72 | Resolve 1 with distance 1; push 2 | `[0:73, 2:72]` |
| 3:75 | Resolve 2 with distance 1 and 0 with distance 3; push 3 | `[3:75]` |

Why only the top is needed: the top is the coldest pending day. If the current
temperature cannot resolve it, it cannot resolve a warmer entry below it.
Every popped day receives its first warmer day: if an earlier warmer day had
existed, it would already have popped that entry.

Compared with matching, one incoming value may finish multiple entries, so
use `while`, not `if`. Wrong approach: searching the remaining suffix separately
for each day takes O(n²) in the worst case. Sorting destroys the original
chronological relation. Using `>=` incorrectly counts an equal day as warmer.

**Java**
```java
import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public int[] daysUntilWarmer(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> pending = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!pending.isEmpty()
                    && temperatures[i] > temperatures[pending.peek()]) {
                int previous = pending.pop();
                answer[previous] = i - previous;
            }
            pending.push(i);
        }
        return answer;
    }
}
```

**Complexity** — O(n) time: each index is pushed once and popped at most once,
so all iterations of the inner loop total at most n. O(n) auxiliary stack space
and O(n) output space. A nested loop alone does not establish quadratic time.

## Advanced directions (overview, not worked examples)

- Histogram area problems add left/right boundary reasoning: popping finalizes
  the widest interval available at a particular height. Unlike daily temperatures,
  the output is an area rather than a distance. A shorter incoming bar can trigger
  finalization, and remaining entries need explicit treatment at the end. Recognize
  nearest-smaller boundaries and the combination of a monotonic stack with interval
  widths. Equality policy affects how duplicate heights share boundaries.
- Infix expression parsing adds operator precedence, associativity, parentheses,
  and possibly unary operators. The convenient postfix assumption that operands
  are ready when an operator arrives no longer holds. Operator and value stacks
  can be combined, or parsing can use recursion.
- Circular next-element variants add wraparound handling. A single linear pass
  no longer exposes every eligible future candidate; distinguish actual entries
  from repeated traversal before pushing duplicates.

These directions are for recognition during this introduction, not implementation
requirements or additional solved problems.

## Contrasts and recognition summary

| Need | Consider | Distinction |
|---|---|---|
| Most recent unresolved item | Stack | LIFO |
| Earliest waiting item | Queue | FIFO |
| Globally smallest/largest item | Heap | Priority, not arrival order |
| Aggregate over a contiguous active region | Sliding window | Maintain region boundaries |
| Locate a transition in a monotone predicate | Binary search | Eliminate portions of a search domain |
| First later greater/smaller value in original order | Monotonic stack | Maintain pending candidates; original input need not be sorted |

The stack's ordering does not make the input array sorted. Binary search over
arbitrary future temperatures is invalid: the condition is not monotone there.
A stack is usually a poor fit when arbitrary buried entries must be accessed
or when priorities are unrelated to arrival order.

Mental hook: **keep unfinished work; pop when it is finished or no longer useful.**
For each pop, explain which of those reasons applies. In daily temperatures,
the answer is finalized; other monotonic-stack formulations discard dominated
candidates, which is a different justification.

## Implementation checklist

1. State exactly what each entry stores and why: character, value, index, or frame.
2. Define top/bottom orientation and the invariant.
3. Guard empty-stack reads and removals.
4. Decide strict versus non-strict comparisons from the contract.
5. Decide whether one input resolves one entry or several (`if` versus `while`).
6. Define treatment of entries left at the end.
7. For evaluation, pop right operand before left and check numeric assumptions.
8. Count lifetime pushes/pops when explaining complexity; include stack space.

## Repository practice context

Stack was introduced on 2026-10-11. These are worked teaching examples, not
independently solved student problems. No Stack practice workspace has yet been
assigned. Earlier Binary Search Problem04 demonstrated independent interval
reasoning; Stack introduces a different invariant and does not require repeating
that work. Choose initial practice after a brief understanding check, and keep
its solution out of this lesson until the student attempts it.

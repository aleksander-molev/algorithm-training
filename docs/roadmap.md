# Algorithm Training Roadmap

This roadmap is intentionally stable. Codex may recommend changes, but should not substantially rewrite it automatically.

## Phase 0 — Foundations

- [ ] Complexity analysis
- [ ] Arrays and strings basics
- [ ] HashMap / HashSet
- [ ] Sorting basics
- [ ] Common Java collections and APIs

Exit criteria:
- explain O(1), O(log n), O(n), O(n log n), O(n²);
- choose array/list/set/map confidently;
- implement common loops and indexing without frequent bugs.

## Phase 1 — Core interview patterns

### Two Pointers
- [ ] opposite-direction pointers
- [ ] same-direction pointers
- [ ] in-place compaction
- [ ] sorted-array variants

### Sliding Window
- [ ] fixed window
- [ ] variable window
- [ ] frequency-map window
- [ ] at-most / exactly-k transformations

### Prefix Sum
- [ ] one-dimensional prefix sum
- [ ] prefix sum + HashMap
- [ ] range queries

### Binary Search
- [ ] classic exact search
- [ ] lower/upper bound
- [ ] search on answer
- [ ] boundary invariants

### Stack
- [ ] matching / parsing
- [ ] monotonic stack
- [ ] next greater/smaller element

Exit criteria:
- recognize the pattern from constraints and structure;
- solve representative medium tasks with hint level 0–1.

## Phase 2 — Linked structures

### Linked List
- [ ] pointer manipulation
- [ ] reverse list
- [ ] merge lists
- [ ] fast/slow pointers
- [ ] cycle detection

### Heap / Priority Queue
- [ ] top-k
- [ ] streaming min/max
- [ ] k-way merge

### Intervals
- [ ] merge
- [ ] insert
- [ ] sweep-style reasoning

## Phase 3 — Trees

### Binary Trees
- [ ] DFS recursive
- [ ] DFS iterative
- [ ] BFS / level order
- [ ] path problems
- [ ] subtree reasoning

### Binary Search Trees
- [ ] search
- [ ] validation
- [ ] predecessor/successor
- [ ] ordered traversal

## Phase 4 — Graphs

- [ ] graph representation
- [ ] DFS
- [ ] BFS
- [ ] connected components
- [ ] grid graphs
- [ ] cycle detection
- [ ] topological sort
- [ ] shortest path basics
- [ ] Union Find

## Phase 5 — Backtracking

- [ ] subsets
- [ ] permutations
- [ ] combinations
- [ ] constraint search
- [ ] pruning

## Phase 6 — Greedy

- [ ] greedy-choice reasoning
- [ ] intervals
- [ ] scheduling
- [ ] local-vs-global correctness arguments

## Phase 7 — Dynamic Programming

### Foundations
- [ ] memoization
- [ ] tabulation
- [ ] state definition
- [ ] transition definition

### Common families
- [ ] 1D DP
- [ ] grid DP
- [ ] knapsack-style
- [ ] subsequence DP
- [ ] interval DP basics

## Phase 8 — Interview integration

- [ ] mixed-pattern sets
- [ ] hidden-pattern problems
- [ ] 30–45 minute timed problems
- [ ] communication drills
- [ ] debugging under time pressure
- [ ] follow-up variants
- [ ] senior-level trade-off discussion

## Suggested initial focus

Start with:
1. HashMap / HashSet
2. Two Pointers
3. Sliding Window
4. Prefix Sum
5. Binary Search

Do not rush into DP before the core patterns are stable.

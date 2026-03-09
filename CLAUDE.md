# DSA Interview Prep Repository

Personal repository for practicing data structures and algorithms problems for coding interviews.

## Project Structure

Multi-module Gradle project. Languages: **Kotlin** (primary) and **Java** (older solutions).

```
dsa/
├── lib/          ← Main module, active development
│   └── src/main/java/com/example/lib/
│       ├── leetcode/         # LeetCode problems (numbered by topic)
│       │   ├── 01arrays/     # Arrays, sliding window, two pointers
│       │   ├── 02hashmap/
│       │   ├── 03linkedlist/
│       │   ├── backtrack/
│       │   ├── binarySearchTrees/
│       │   ├── binaryTrees/  # DFS and BFS sub-folders
│       │   ├── graphs/
│       │   ├── greedy/
│       │   ├── heaps/
│       │   ├── queue/
│       │   ├── recursion/
│       │   ├── sorting/
│       │   └── stack/
│       ├── topics/           # Topic-wise practice
│       │   ├── arrays/ (incl. twoPointerApproach/)
│       │   ├── backtracking/
│       │   ├── hashMap/, hashset/
│       │   ├── heap/
│       │   ├── linkedList/
│       │   ├── recursion/
│       │   ├── strings/
│       │   ├── trees/ (dfs/, bfs/, binarySearchTrees/)
│       │   └── trie/
│       ├── geeksforgeeks/    # GFG problems (arrays, binaryTree, dp, heap, sorting, stack, linkedList)
│       ├── hackerRank/       # HackerRank problems
│       ├── interview/        # Interview-specific problems
│       ├── demo/             # Kotlin language demos
│       └── codeReview/       # Code review exercises
├── code/         ← Older Java solutions
│   └── src/main/java/com/example/
│       ├── hackerRank/interviewPrep/   # HackerRank (arrays, hashMap)
│       └── topics/                      # Algos, search, sorting, graphTheory, DP
├── app/          ← Android app shell (boilerplate, not focus)
```

## Conventions

- **One file per problem.** Class name matches the problem (e.g., `NumberofIslands`, `maxDepth`).
- **`main()` function** at the bottom of files for quick local testing.
- **Multiple approaches** often kept in the same file (e.g., DFS + BFS, or revisions like `numIslands2020`, `numIslands23`).
- **Numbered prefixes** for ordering within folders (e.g., `01maxDepth.kt`, `02hasPathSum.kt`).
- **LeetCode URLs** included as comments when available.
- **Time/space complexity** analysis added in block comments for key problems.
- New solutions should go in `lib/src/main/java/com/example/lib/leetcode/` under the appropriate topic folder.

## Build

- Gradle wrapper: `./gradlew`
- Kotlin 1.7.21, Java 7 target (lib module)
- No test suite — solutions are verified via `main()` functions
- Run a solution: execute the `main()` function in IntelliJ/Android Studio

## DSA Notes (Obsidian)

Notes are in an Obsidian vault on Google Drive:
`~/Library/CloudStorage/GoogleDrive-vihaanverma21@gmail.com/My Drive/obsidian/Vihaan/learning/dsa folder/`

**Claude has read/write access to this folder.** Can create, edit, and reorganize notes here.

Notes folder structure mirrors the code topics:
- `01arrays/` — Arrays concept, two pointers, sliding window, prefix sum
- `02hashmaps/`
- `03 linked lists/`
- `graphs/` — Graph concepts, specific problem breakdowns with Excalidraw drawings
- `trees/` — Binary trees, BSTs, diameter, maxAncestorDiff
- `backtracking/`, `greedy folder/`, `heaps/`, `queues/`, `recursion/`, `stack/`
- `resources/` — Reference materials

Key docs:
- `Dsa Focus Areas.md` — Primary study source (LeetCode Interview Crash Course)
- `dsa revision plan.md` — Revision schedule
- `Dsa Timeline.md` — Study timeline
- `pro tips.md` — Problem-solving tips
- `Algo Complexity.md` — Complexity reference
- `Todo.md` — Pending problems/topics

Every problem should include complexity analysis (per focus areas doc).

## When Adding New Solutions

1. Place in `lib/.../leetcode/<topic>/` for LeetCode problems
2. Use Kotlin unless solving a Java-specific problem
3. Include the problem URL as a comment
4. Add a `main()` function with sample test cases
5. Keep multiple solution approaches in the same file if comparing

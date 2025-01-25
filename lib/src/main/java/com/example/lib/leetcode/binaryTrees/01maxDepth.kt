package com.example.lib.leetcode.binaryTrees

class maxDepth {

//    https://leetcode.com/problems/maximum-depth-of-binary-tree/


    /*
    Time Complexity

    The code uses a Depth-First Search (DFS) traversal to traverse every node in the binary tree exactly once. The function maxDepthDfs is called recursively for each node, visiting both the left and right child of every node.
    •	Let  n  be the number of nodes in the binary tree.
    •	Since each node is visited once, the time complexity is  O(n) .

    Space Complexity

    The space complexity is determined by the call stack used during the recursion.
    •	In the worst case:
    •	If the binary tree is skewed (all nodes have only one child), the recursion depth will be equal to  n , where  n  is the number of nodes in the tree. The space complexity in this case is  O(n) .
    •	In the best case:
    •	If the binary tree is balanced, the recursion depth will be equal to the height of the tree, which is  O(\log n)  for a balanced binary tree.

    Thus, the space complexity is:
    •	 O(h) , where  h  is the height of the binary tree.
    •	In the worst case,  h = n , so space complexity is  O(n) .
    •	In the best case (balanced tree),  h = \log n , so space complexity is  O(\log n) .

    Summary
    •	Time Complexity:  O(n)
    •	Space Complexity:  O(h) , where  h  is the height of the binary tree. In the worst case  O(n) , in the best case  O(\log n) .

     */

    var max = 0
    fun maxDepth(root: TreeNode?): Int {

        if (root == null) {
            return 0
        } else {
            maxDepthDfs(root, 1)
        }
        return max
    }

    fun maxDepthDfs(root: TreeNode?, depth: Int) {

        // term condition
        if (root == null) {
            return
        }

        max = maxOf(max, depth)
        maxDepthDfs(root?.left, depth + 1)
        maxDepthDfs(root?.right, depth + 1)
    }

    fun maxDepth2(root: TreeNode?, depth: Int) {
        if (root == null) {
            if (depth > max) {
                max = depth
            }
            return
        }

        maxDepth2(root?.left, depth + 1)
        maxDepth2(root?.right, depth + 1)
    }

    fun maxDepth2(root: TreeNode?): Int {
        maxDepth2(root, 0)
        return max
    }

    fun maxDepth1(root: TreeNode?): Int {

        if (root == null) {
            return 0
        } else {
            return 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right))
        }

    }

}

fun main() {
}
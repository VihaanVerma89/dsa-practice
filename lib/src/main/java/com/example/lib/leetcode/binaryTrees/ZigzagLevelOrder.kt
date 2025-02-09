package com.example.lib.leetcode.binaryTrees

import java.util.*
import kotlin.collections.ArrayList

class zigzagLevelOrder {

    /*
    Check out array dequeue for this problem
     */

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) return result

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        var leftToRight = true

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val levelNodes = LinkedList<Int>()

            for (i in 0 until levelSize) {
                val node = queue.poll()

                if (leftToRight) {
                    levelNodes.add(node.`val`)
                } else {
                    levelNodes.addFirst(node.`val`)
                }

                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }

            result.add(levelNodes)
            leftToRight = !leftToRight  // Toggle direction
        }

        return result
    }

    // works but uses a stack for right to left traversal on level
    fun zigzagLevelOrderWithStack(root: TreeNode?): List<List<Int>> {
        val r = arrayListOf<ArrayList<Int>>()

        if (root != null) {
            val q = LinkedList<TreeNode>()
            var node = root
            q.add(node)
            var d = 0
            val s = Stack<TreeNode>()
            while (q.isNotEmpty()) {

                val l2r = arrayListOf<Int>()
                val r2l = arrayListOf<Int>()

                for (i in 0 until q.size) {
                    node = q.remove()
                    if (d % 2 == 0) {
                        // l -> r traversal
                        if (node != null) {
                            l2r.add(node.`val`)
                        }
                    } else {
                        // l <-r traversal
                        s.push(node)
                    }
                    node?.left?.let { q.add(it) }
                    node?.right?.let { q.add(it) }
                }

                // level traversal complete
                if (d % 2 == 0) {
                    // l -> r
                    r.add(l2r)
                } else {
                    // l <- r
                    while (s.isNotEmpty()) {
                        var tempNode = s.pop()
                        r2l.add(tempNode.`val`)
                    }
                    r.add(r2l)
                }
                d++
            }

        }

        return r
    }

//    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
//
//        val r = arrayListOf<ArrayList<Int>>()
//
//        // traversal - bfs
//        val q = LinkedList<TreeNode>()
//
//        // level 0,2,4
//        // l - > r
//
//        // levels 1,3,5
//        // r -> l
//
//        return r
//    }

//    solution from https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/editorial/
    fun zigzagLevelOrderEditorial(root: TreeNode?): List<List<Int?>?>? {
        if (root == null) {
            return ArrayList()
        }
        val results: MutableList<List<Int?>?> = ArrayList()

        // add the root element with a delimiter to kick off the BFS loop
        val nodesDeque = LinkedList<TreeNode?>()
        nodesDeque.addLast(root)
        nodesDeque.addLast(null)
        var levelDeQue = LinkedList<Int?>()
        var l2r = true
        while (nodesDeque.size > 0) {
            val currNode = nodesDeque.pollFirst()
            if (currNode != null) {
                if (l2r) levelDeQue.addLast(currNode.`val`) else levelDeQue.addFirst(
                    currNode.`val`
                )
                if (currNode.left != null) nodesDeque.addLast(currNode.left)
                if (currNode.right != null) nodesDeque.addLast(currNode.right)
            } else {
                // we finish the scan of one level
                results.add(levelDeQue)
                levelDeQue = LinkedList()
                // prepare for the next level
                if (nodesDeque.size > 0) nodesDeque.addLast(null)
                l2r = !l2r
            }
        }
        return results
    }
}
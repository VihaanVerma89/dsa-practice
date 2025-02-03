package com.example.lib

import com.example.lib.leetcode.binaryTrees.TreeNode
import java.util.LinkedList
import java.util.Queue

class Solution {

    fun rightSideView(root: TreeNode?): List<Int> {

        val result = mutableListOf<Int>()
        if (root == null) {
            return result
        } else {
            val q: Queue<TreeNode> = LinkedList()
            q.add(root)

            while (q.isNotEmpty()) {
                val childNodes = q.size
                for (i in 0 until childNodes) {
                    val node = q.poll()
                    node?.left?.let { q.add(it) }
                    node?.right?.let { q.add(it) }
                    if (i == childNodes - 1) {
                        // we are at the last node for current level
                        result.add(node.`val`)
                    }
                }
            }
        }
        return result
    }
}

fun main() {

}


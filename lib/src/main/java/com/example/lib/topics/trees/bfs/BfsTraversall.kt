package com.example.lib.topics.trees.bfs

import com.example.lib.leetcode.trees.TreeNode
import java.util.LinkedList
import java.util.Queue

class BfsTraversall {


    fun bfs(root: TreeNode): Unit {

        val q: Queue<TreeNode> = LinkedList<TreeNode>()

        q.add(root)

        var node: TreeNode? = null

        while (q.isNotEmpty()) {
            val size = q.size
            for (i in 0..size) {
                node = q.remove()
                println(node.`val`)
                if (node.left != null) {
                    q.add(node.left!!)
                }
                if (node.right != null) {
                    q.add(node.right!!)
                }
            }

        }
    }

}

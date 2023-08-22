package com.example.lib.topics.trees.bfs

import com.example.lib.topics.trees.TreeNode
import java.util.*

class deepestLeavesSum {

    fun deepestLeavesSum(root: TreeNode?): Int {

        if (root == null) {
            return 0
        }


        val q = LinkedList<TreeNode>()
        q.add(root)
        val hmap = hashMapOf<String, Int>()

        var level = 0
        while (q.isNotEmpty()) {
            val levelNodes = q.size

            var node: TreeNode? = null
            for (i in 0 until levelNodes) {

                node = q.remove()
                if (node.right != null) {
                    q.add(node.right!!)
                }

                if (node.left != null) {
                    q.add(node.left!!)
                }

                if (node.left == null && node.right == null) {
                    // leaf node
                }
                if (hmap.contains("l$level")) {
                    val sum = hmap.get("l$level")
                    if (sum != null) {
                        hmap.put("l$level", sum + node.`val`)
                    }
                } else {
                    hmap.put("l$level", node.`val`)
                }
            }

            level++
        }

        return hmap.get("l${level - 1}") ?: 0

    }


}
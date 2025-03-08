package com.example.lib.leetcode.graphs

import com.example.lib.leetcode.binaryTrees.TreeNode
import java.util.LinkedList

class distanceK {

    fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {

        val result = mutableListOf<Int>()

        if (root == null) return result

        val graph = mutableMapOf<Int, MutableList<Int>>()

        fun dfs(node: TreeNode?) {

            if (node == null) return

            val s = node.`val`

            val l = node?.left?.`val`
            val r = node?.right?.`val`

            graph.getOrPut(node.`val`) { mutableListOf() }.apply {
                if (l != null)
                    add(l)
                if (r != null)
                    add(r)
            }

            if (l != null) {
                graph.getOrPut(l) { mutableListOf() }.add(s)
            }

            if (r != null) {
                graph.getOrPut(r) { mutableListOf() }.add(s)
            }

            dfs(node?.left)
            dfs(node?.right)

        }

        dfs(root)

        data class Node(val value: Int, val distance: Int)

        val q = LinkedList<Node>()
        val seen = hashSetOf<Int>()

        q.add(Node(target?.`val`!!, 0))
        seen.add(target.`val`)

        fun bfs() {
            while (q.isNotEmpty()) {

                val cn = q.poll()
                if (cn.distance == k) {
                    result.add(cn.value)
                    continue
                }


                for (node in graph.get(cn.value).orEmpty()) {
                    if (!seen.contains(node)) {
                        q.add(Node(node, cn.distance + 1))
                        seen.add(node)
                    }
                }
            }
        }

        bfs()


        return result
    }

}


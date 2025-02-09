package com.example.lib.leetcode.binaryTrees.bfs

import com.example.lib.topics.trees.TreeNode
import java.util.*

class deepestLeavesSum {


    fun deepestLeavesSum(root: TreeNode?):Int{

        var sum = 0
        if( root == null ) {
            return sum
        }
        else{
            val q: Queue<Pair<TreeNode,Int>> = LinkedList()
            q.add(Pair(root,0))
            var currLevel = 0
            while(q.isNotEmpty()){
                val ( node, level ) = q.poll()
                val value = node.`val`
                if(level>currLevel){
                    sum = 0
                    currLevel = level
                }
                sum+=value
                node?.left?.let{ q.add(Pair(it, level+1)) }
                node?.right?.let{ q.add(Pair(it, level+1)) }
            }
        }
        return sum
    }

    fun deepestLeavesSum1(root: TreeNode?): Int {

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
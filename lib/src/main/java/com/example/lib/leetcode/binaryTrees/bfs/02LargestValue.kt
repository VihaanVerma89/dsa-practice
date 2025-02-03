package com.example.lib.leetcode.binaryTrees.bfs

import com.example.lib.leetcode.binaryTrees.TreeNode
import java.util.LinkedList
import java.util.Queue

class LargestValue {


    fun largestValues(root: TreeNode?):List<Int>{

        val result = mutableListOf<Int>()
        if(root == null){ return result}
        else{

            val q : Queue<TreeNode> = LinkedList()
            q.add(root)

            var maxChildNode = Int.MIN_VALUE

            while(q.isNotEmpty()){

                val childNodes = q.size
                maxChildNode = Int.MIN_VALUE

                for(i in 0 until childNodes){

                    val node = q.poll()

                    maxChildNode = maxOf(maxChildNode, node.`val`)

                    node?.left?.let{q.add(it)}
                    node?.right?.let{q.add(it)}

                }
                result.add(maxChildNode)
            }
        }

        return result
    }
}
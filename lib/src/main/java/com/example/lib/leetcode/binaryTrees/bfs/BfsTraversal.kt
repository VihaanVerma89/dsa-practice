package com.example.lib.leetcode.binaryTrees.bfs

import com.example.lib.leetcode.binaryTrees.TreeNode
import java.util.LinkedList
import java.util.Queue

class BfsTraversal {

    fun bfs(root: TreeNode?){
        if(root == null) return

        val q : Queue<TreeNode> = LinkedList()
        q.add(root)

        while(q.isNotEmpty()){
            val node = q.poll()
            print("${node.`val`}")

            node?.left?.let{q.add(it)}
            node?.right?.let{q.add(it)}

        }

    }

    fun bfsWithLevel(root: TreeNode?){
        val q : Queue<TreeNode> = LinkedList()
        q.add(root)

        while(q.isNotEmpty()){
            val childNodes = q.size
            for( i in 0 until childNodes)
            {
                val node = q.poll()
                print("${node.`val`}")
                node?.left?.let{q.add(it)}
                node?.right?.let{q.add(it)}
            }
            println()
        }

    }
}

fun main(){

    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right= TreeNode(3)
    root.left?.left= TreeNode(4)
    root.left?.right= TreeNode(5)
    root.right?.left= TreeNode(6)
    root.right?.right= TreeNode(7)

    BfsTraversal().bfs(root)
    println("bfsWithLevel")
    BfsTraversal().bfsWithLevel(root)

}

package com.example.lib.topics.trees

import java.util.*


fun levelOrder(root: TreeNode?): List<List<Int>> {

    val result = ArrayList<ArrayList<Int>>()
    if (root == null) {
        return result
    }

    val q: Queue<TreeNode> = LinkedList()
    q.add(root)

    var level = 0
    while (q.isNotEmpty()) {
        val size = q.size
        var i = 0

        val levelNodes = arrayListOf<Int>()
        while (i < size) {
            val pop = q.remove()
            levelNodes.add(pop.`val`)
            i++
            if (pop.left != null) {
                q.add(pop.left)
            }
            if (pop.right != null) {
                q.add(pop.right)
            }
        }

        result.add(levelNodes)
    }
    return result
}

fun main() {
//    [3,9,20,null,null,15,7]

    val treeNode = TreeNode(3)
    treeNode?.left = TreeNode(9)
    treeNode?.right = TreeNode(20)

    treeNode?.left?.left = null
    treeNode?.right?.left = TreeNode(15)
    treeNode?.right?.right = TreeNode(7)
    levelOrder(treeNode)
}
//package com.example.lib.topics.trees.dfs
//
//import java.util.*
//
////https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
//class TopViewOfTree {
//    val m = TreeMap<Int, TreeNodePos>()
//
//    data class TreeNodePos(val treeNode: TreeNode, val pos: Int)
//
//    fun printTopView(treeNode: TreeNode, l: Int) {
//        val q: Queue<TreeNodePos> = LinkedList<TreeNodePos>()
//
//        val treeNodePos = TreeNodePos(treeNode, 0)
//        q.add(treeNodePos)
//
//        while (q.isNotEmpty()) {
//            val poll = q.poll()
//            poll?.let {
//                if (m.contains(it.pos)) {
//
//                } else {
//                    m.put(it.pos, it)
//                }
//            }
//
//            poll.treeNode.left?.let {
//                q.add(TreeNodePos(it, poll.pos - 1))
//            }
//
//            poll.treeNode.right?.let {
//                q.add(TreeNodePos(it, poll.pos + 1))
//            }
//        }
//
//        if (m.isNotEmpty()) {
//            for (e in m.entries) {
//                print("${e.value.treeNode.`val` }")
//            }
//        }
//
//    }
//
//}
//
//fun main() {
//    val o = TopViewOfTree()
//    val treeNode = TreeNode(1)
//    treeNode.left = TreeNode(2);
//    treeNode.right = TreeNode(3);
//    treeNode.left?.right = TreeNode(4);
//    treeNode.left?.right?.right = TreeNode(5);
//    treeNode.left?.right?.right?.right = TreeNode(6);
//    o.printTopView(treeNode, 0)
//}
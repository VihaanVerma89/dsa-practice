package com.example.lib.topics.trees.dfs

import java.util.*


class SymmetricTree1 {


    fun isSymmetric(root: TreeNode?): Boolean {

        val q: Queue<TreeNode> = LinkedList()
        var symmetric = true
        if (root != null) {
            q.add(root)
            q.add(root)
            while (q.isNotEmpty()) {
                val s = q.size

                val n1 = q.poll()
                val n2 = q.poll()

                if (n1 == null && n2 == null) {
                    continue
                }

                if (n1 == null || n2 == null) {
                    return false
                }

                if (n1.`val` == n2.`val`) {
                    q.add(n1.left)
                    q.add(n2.right)
                    q.add(n1.right)
                    q.add(n2.left)
                } else {
                    return false
                }

            }
        }
        return symmetric
    }


    fun isSymmetricRecursion(root: TreeNode?): Boolean {
        var symmetric = true
        if (root != null) {
            symmetric = isMirror(root, root)
        }
        return symmetric
    }


    private fun isMirrorRecursion(n1: TreeNode?, n2: TreeNode?): Boolean {
        var mirror = false

        if (n1 == null && n2 == null) {
            return true
        }
        if (n1 == null || n2 == null) {
            return false
        }
        if (n1.`val` == n2.`val`) {
            mirror = isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left)
        }
        return mirror
    }

}


fun main() {

}
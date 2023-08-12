package com.example.lib.leetcode.trees

class goodNodes {


    fun goodNodes1(root: TreeNode?): Int {


        var count = 0
        // base condition
        if (root == null) {
            // empty node
            return 0
        } else if (root?.left == null && root?.right == null) {
            // leaf node
            return 1
        } else if (root?.left != null || root?.right != null) {
            // regular node
            if (root?.left != null && root?.`val`!! <= root?.left!!.`val`) {
                count++
            }

            if (root?.right != null && root?.`val`!! <= root?.right!!.`val`) {
                count++
            }
        }


        val lc = goodNodes1(root?.left)
        val rc = goodNodes1(root?.right)
        return count + lc + rc
    }

    fun goodNodes(root: TreeNode?): Int {
        goodDfs(root, Int.MIN_VALUE)
        return count
    }

    var count = 0
    fun goodDfs(root: TreeNode?, maxValue: Int) {

        if (root == null) {
            return
        } else if (root.`val` >= maxValue) {
            // good node
            count++
        }

        goodDfs(root?.left, Math.max(maxValue, root?.`val` ?: Int.MIN_VALUE))
        goodDfs(root?.right, Math.max(maxValue, root?.`val` ?: Int.MIN_VALUE))

    }

}
package com.example.lib.leetcode.binaryTrees.dfs

import com.example.lib.leetcode.binaryTrees.TreeNode


class isSameTree {



    fun isSameTree(p: TreeNode?, q: TreeNode?):Boolean{

        var result = false
        if(p == null && q == null){result=true}
        else if(p!=null && q!= null){ result = dualDfs(p,q)}
        return result

    }

    fun dualDfs(root1: TreeNode?, root2: TreeNode?):Boolean{

        // term condition
        if(root1 == null && root2 == null)
        {
            return true
        }
        else if(root1?.`val`!=root2?.`val`){
            return false
        }


        // logic
        var lc = false
        var rc = false
        if(root1?.`val`==root2?.`val`){
            lc = dualDfs(root1?.left, root2?.left)
            rc = dualDfs(root1?.right, root2?.right)
        }

        return lc && rc
    }

    fun isSameTree01(p: TreeNode?, q: TreeNode?): Boolean {


        // base condition
        if (p == null && q == null) {
            return true
        } else if (p == null && q != null) {
            return false
        } else if (p != null && q == null) {
            return false
        }

        // logic
        val same = p?.`val` == q?.`val`

        // recursion
        return  same && isSameTree01(p?.left, q?.left) && isSameTree01(p?.right, q?.right)
    }


}

fun main() {
    val sameTree = isSameTree()
    val p = TreeNode(1).apply {
        left = TreeNode(2)
        right = null
    }

    val q = TreeNode(1).apply {
        right = TreeNode(2)
    }

    val  same = sameTree.isSameTree01(p, q)
    println("same : $same")
}


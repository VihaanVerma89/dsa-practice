package com.example.lib.leetcode.binaryTrees



class Solution{

    fun lowestCommonAncestor(root: TreeNode?, p:TreeNode?, q:TreeNode?): TreeNode?{

        if(root == null || root ==p || root ==q){
            return root
        }

        val l = lowestCommonAncestor(root?.left, p, q)
        val r = lowestCommonAncestor(root?.right, p, q)

        if(l !=null && r !=null){
            return root
        }

        return l ?: r
    }

}

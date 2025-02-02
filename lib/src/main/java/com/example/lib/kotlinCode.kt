package com.example.lib

import com.example.lib.leetcode.binaryTrees.TreeNode

class Solution{

    fun diameterOfBinaryTree(root:TreeNode?):Int{
        
        if(root == null){return 0}
        else {
            dfs(root,0)
        }
        return maxD
    }

    var maxD = 0

    fun dfs(node:TreeNode?, edges:Int) : Int{

        // term condition
        if(node!=null && node?.left == null && node?.right == null){
            // leaf node
            return edges
        }
        else if(node == null ){
            return 0
        }


        //logic
        val les = dfs(node?.left, edges+1)
        val res = dfs(node?.right,edges+1)

        var t1 = 0
        var t2 = 0 
        var d = 0 
        if(les > 0 ){
            t1 = les - edges
        }
        if(res > 0)
        {
            t2 = res - edges
        }

        d = t1+t2

        maxD = maxOf(maxD, d)

        return maxOf(les,res)

    }

}

fun main(){

}


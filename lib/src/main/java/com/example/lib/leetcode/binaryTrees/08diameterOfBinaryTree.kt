package com.example.lib.leetcode.binaryTrees

class `08diameterOfBinaryTree` {


/*
    Note : Copied from GTP
    var maxD = 0  // To keep track of the maximum diameter

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return maxD
    }

    // DFS to calculate height and update diameter
    fun dfs(node: TreeNode?): Int {
        if (node == null) return 0

        val leftHeight = dfs(node.left)
        val rightHeight = dfs(node.right)

        // Update the maximum diameter
        maxD = maxOf(maxD, leftHeight + rightHeight)

        // Return the height of the current node
        return 1 + maxOf(leftHeight, rightHeight)
    }

*/
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




    fun diameterOfBinaryTree1(root: TreeNode?): Int {

        if (root == null) {
            return 0
        }
        dfs1(root)
        return result
    }

    var result = 0
    fun dfs1(root: TreeNode?): Int {

        // base condition
        if (root == null) {
            return 0
        } else if (root?.left == null && root?.right == null) {
           // leaf node
            return 1
        }

        val l = dfs1(root?.left)
        val r = dfs1(root?.right)

        val d = l + r
        if (d > result) {
            result = d
        }

        return Math.max(l, r)
    }

}
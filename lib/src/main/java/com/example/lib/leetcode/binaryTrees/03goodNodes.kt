package com.example.lib.leetcode.binaryTrees

class `03goodNodes` {


    fun goodNodes(root: TreeNode?):Int{

        if( root == null){
            return result
        }
        else{
            goodNodesDfs(root, Int.MIN_VALUE)
        }

        return result

    }



    var result =  0

    fun goodNodesDfs(root: TreeNode?, max: Int)
    {

        // term condition
        if(root==null){return}

        // logic
        val value = root?.`val`?:0

        var nextMax = max
        if(value >= max){
            result++
            nextMax=value
        }


        goodNodesDfs(root?.left, nextMax)
        goodNodesDfs(root?.right,nextMax)

    }

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

    fun goodNodes2(root: TreeNode?): Int {
        goodDfs2(root, Int.MIN_VALUE)
        return count
    }

    var count = 0
    fun goodDfs2(root: TreeNode?, maxValue: Int) {

        if (root == null) {
            return
        } else if (root.`val` >= maxValue) {
            // good node
            count++
        }

        goodDfs2(root?.left, Math.max(maxValue, root?.`val` ?: Int.MIN_VALUE))
        goodDfs2(root?.right, Math.max(maxValue, root?.`val` ?: Int.MIN_VALUE))

    }

}
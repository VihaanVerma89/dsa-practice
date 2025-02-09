package com.example.lib.leetcode.binarySearchTrees

import com.example.lib.leetcode.binaryTrees.TreeNode

class insertIntoBST {

    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {

        val key = `val`
        // term condition
        if(root == null) { return TreeNode(key) }

        //logic
        val value = root.`val`

        if(key<value){
            root.left = insertIntoBST(root.left,key)
        }
        else if(key>value){
            root.right = insertIntoBST(root.right,key)
        }
        else if(key==value){
            println("invalid key")

        }

        //return to parent
        return root
    }

    fun insertIntoBST1(root: TreeNode?, `val`: Int): TreeNode? {

        if (root == null) {
            // empty input
            return TreeNode(`val`)
        } else {
            insertIntoBstWithTraversal1(root, `val`)
        }
        return root
    }

    fun insertIntoBstWithTraversal1(root: TreeNode?, `val`: Int): TreeNode? {
        // base condition
        if (root == null) {
            return null
        }

        // logic
        // find the spot
        // traversal
        // manipulate the node ref
        val currValue = root?.`val`!!
        var result: TreeNode? = null
        if (`val` < currValue) {
            result = insertIntoBstWithTraversal1(root?.left, `val`)
            if (result == null) {
                root.left = TreeNode(`val`)
            }
        } else if (currValue < `val`) {
            result = insertIntoBstWithTraversal1(root?.right, `val`)
            if (result == null) {
                root.right = TreeNode(`val`)
            }
        }
        return root
    }
}
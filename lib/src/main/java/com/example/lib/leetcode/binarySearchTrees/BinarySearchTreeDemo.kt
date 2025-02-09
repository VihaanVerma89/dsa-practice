package com.example.lib.leetcode.binarySearchTrees

import com.example.lib.leetcode.binaryTrees.TreeNode

class BinarySearchTreeDemo {


    fun searchBst(root: TreeNode?, key: Int): TreeNode?{

        // term condition

        if( root == null || root.`val` == key ) { return root } 


        // logic : divide the search in half

        return if( key < root.`val` ) {
            searchBst(root.left, key)
        }
        else {
            searchBst(root.right, key)
        }

    }


    fun insertBst(root: TreeNode?, key: Int): TreeNode{

        // term condition
        if(root == null) { return TreeNode(key) }


        //logic

        val value = root.`val`

        if(key<value){
            root.left = insertBst(root.left,key)
        }
        else if(key>value){
            root.right = insertBst(root.right,key)
        }
        else if(key==value){
            println("invalid key")

        }


        //return to parent
        return root
    }

}

fun main(){

    val root = TreeNode(1)

    BinarySearchTreeDemo().insertBst(root,2)
    BinarySearchTreeDemo().insertBst(root,3)
    BinarySearchTreeDemo().insertBst(root,4)
    BinarySearchTreeDemo().insertBst(root,5)
    BinarySearchTreeDemo().insertBst(root,6)
}










































package com.example.lib.leetcode.binaryTrees


class BinaryTreePreorderTraversal {
    fun preOrder1(root: TreeNode?) {
        // base condition
        if (root == null) {
            return
        }
        println(root?.`val`)
        preOrder1(root?.left)
        preOrder1(root?.right)
    }

    // + L R
    /*
    Balanced tree
    0 1 3 7 8 4 9 10 2 5 11 12 6 13 14
     */
    fun preOrder(root: TreeNode?) {
        // base condition for recursion
        if (root == null) {
            return
        }

        // current
        print(root?.`val`.toString() + " ")
        preOrder(root?.left)
        preOrder(root?.right)
    }

    fun inOrder(root: TreeNode?) {
        if (root == null) {
            return
        }

        inOrder(root?.left)
        print(root?.`val`.toString() + " ")
        inOrder(root?.right)
    }

    fun postOrder(root: TreeNode?) {
        if (root == null) {
            return
        }

        postOrder(root.left)
        postOrder(root.right)
        print(root?.`val`.toString() + " ")
    }

}

fun main() {
    val root = TreeNode(0).apply {
        left = TreeNode(1).apply {
            left = TreeNode(3).apply {
                left = TreeNode(6).apply { }
            }
            right = TreeNode(4).apply {
                left = TreeNode(7)
                right = TreeNode(8)
            }
        }
        right = TreeNode(2).apply {
            right = TreeNode(5)
        }
    }

    val balancedTree = TreeNode(0).apply {
        left = TreeNode(1).apply {
            left = TreeNode(3).apply {
                left = TreeNode(7).apply {
                }
                right = TreeNode(8).apply {
                }
            }
            right = TreeNode(4).apply {
                left = TreeNode(9).apply {
                }
                right = TreeNode(10).apply {
                }
            }
        }
        right = TreeNode(2).apply {
            left = TreeNode(5).apply {
                left = TreeNode(11).apply {
                }
                right = TreeNode(12).apply {
                }
            }
            right = TreeNode(6).apply {
                left = TreeNode(13).apply {
                }
                right = TreeNode(14).apply {
                }
            }
        }
    }

    val instance = BinaryTreePreorderTraversal()
//    instance.preOrder(balancedTree)
//    instance.inOrder(balancedTree)
    instance.postOrder(balancedTree)

}
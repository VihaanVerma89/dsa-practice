package com.example.lib.geeksforgeeks.ds.binaryTree;

import java.util.LinkedList;

/**
 * Created by vihaanverma on 25/11/17.
 */

public class InorderTraversalWithoutRecursion {

    public static void main(String[] args) {

        Node leftNode, rightNode;
        Node rootNode = new Node(10);

        leftNode = new Node(12);
        rightNode = new Node(15);

        rootNode.addLeftNode(leftNode);
        rootNode.addRightNode(rightNode);

        leftNode = new Node(25);
        rightNode = new Node(30);

        rootNode.getLeftNode().addLeftNode(leftNode);
        rootNode.getLeftNode().addRightNode(rightNode);

        leftNode = new Node(36);
        rootNode.getRightNode().addLeftNode(leftNode);

        inorderWithStack(rootNode);
    }

    static LinkedList<Node> stack = new LinkedList<>();

    public static void inorderWithStack(Node node) {

        if (node != null) {
            stack.push(node);

            while (stack.size() > 0) {

                while (node!=null && node.getLeftNode() != null )
                {
                    node = node.getLeftNode();
                    stack.push(node);
                }

                node = stack.pop();
                System.out.print(node.getValue()+"-");

                if (node.getRightNode() != null) {
                    node = node.getRightNode();
                    stack.push(node);
                } else {
                    node = null;
                }
            }
        }
    }
}

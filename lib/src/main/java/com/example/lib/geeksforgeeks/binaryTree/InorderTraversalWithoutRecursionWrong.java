package com.example.lib.geeksforgeeks.binaryTree;

import java.util.LinkedList;

/**
 * Created by vihaanverma on 25/11/17.
 */

public class InorderTraversalWithoutRecursionWrong {

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

            Node poppedNode = null;
            while (node != null) {

                while (node.getLeftNode() != null && poppedNode != node.getLeftNode()) {
                    node = node.getLeftNode();
                    stack.push(node);
                }

                poppedNode = popNode(stack);
                if (poppedNode != null) {
                    System.out.println(poppedNode.getValue());

                    if (poppedNode.getRightNode() != null) {
                        node = node.getRightNode();
                        stack.push(node);
                    } else {
                        node = stack.peek();
                    }
                }
            }
        }
    }

    private static Node popNode(LinkedList<Node> stack) {
        Node node = null;
        if (stack.size() > 0) {
            node = stack.pop();
        }
        return node;
    }

}

package com.example.geeksforgeeks.ds.binaryTree;

/**
 * Created by vihaanverma on 24/11/17.
 */

public class Node {

        int value;
        Node leftNode, rightNode;

        public Node(int value){
            this.value=value;
        }

        public void addLeftNode(Node node)
        {
            leftNode=node;
        }

        public void addRightNode(Node node)
        {
            rightNode=node;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
}

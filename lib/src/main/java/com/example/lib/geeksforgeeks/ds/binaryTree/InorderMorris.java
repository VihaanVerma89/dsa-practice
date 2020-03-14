package com.example.lib.geeksforgeeks.ds.binaryTree;

/**
 * Created by vihaanverma on 03/12/17.
 */

public class InorderMorris {

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

    private static void inorderWithStack(Node rootNode) {

        while(rootNode!=null)
        {
            Node tempNode, rightNode, leftNode;

            leftNode = rootNode.getLeftNode();
            if(leftNode!=null)
            {
                tempNode = leftNode;
                while(tempNode.getRightNode()!=null && tempNode.getRightNode()!=rootNode)
                {
                    tempNode = tempNode.getRightNode();
                }


                if(tempNode.getRightNode()==null)
                {
                    tempNode.addRightNode(rootNode);
                    rootNode=rootNode.getLeftNode();
                }
                else {
                    System.out.print(rootNode.getValue()+"=");
                    rootNode = rootNode.getRightNode();
                    tempNode.setRightNode(null);
                }

            }else{
                System.out.print(rootNode.getValue()+"=");
                rootNode = rootNode.getRightNode();
            }
        }
    }



















































}

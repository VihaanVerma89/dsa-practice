package com.example.geeksforgeeks.ds.binaryTree.binaryTodoublyLL;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by vihaanverma on 24/11/17.
 */

public class BinaryToDoubleLL {

    public static void main(String []args)
    {
        Node leftNode, rightNode;
        Node rootNode = new Node(10);

        leftNode = new Node(12);
        rightNode= new Node(15);

        rootNode.addLeftNode(leftNode);
        rootNode.addRightNode(rightNode);

        leftNode = new Node(25);
        rightNode= new Node(30);

        rootNode.getLeftNode().addLeftNode(leftNode);
        rootNode.getLeftNode().addRightNode(rightNode);

        leftNode = new Node(36);
        rootNode.getRightNode().addLeftNode(leftNode);

        LinkedList<Integer> dll = new BinaryToDoubleLL().getDoublyLinkedList(rootNode);

        Iterator<Integer> iterator = dll.iterator();
        int value;
        while(iterator.hasNext())
        {
            value = iterator.next();
            System.out.print(value);
            if(iterator.hasNext())
            {
                System.out.print("=");
            }
        }

        System.out.println();
    }

    LinkedList<Integer> dll = new LinkedList<>();
    public LinkedList<Integer> getDoublyLinkedList(Node rootNode)
    {
        traverse(rootNode);
        return dll;
    }

    Map<Node,Boolean> visited = new HashMap<>();
    public void traverse(Node node){
        if(visited.containsKey(node.getValue()))
        {
          return ;
        }

        Node leftNode = node.getLeftNode();
        if(leftNode!=null)
        {
            traverse(leftNode);
        }

        dll.add(node.getValue());
        visited.put(node, true);

        Node rightNode = node.getRightNode();
        if(rightNode!=null)
        {
            traverse(rightNode);
        }

        // leaf node
//        dll.add(node.getValue());

    }


}

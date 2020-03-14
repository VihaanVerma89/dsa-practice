package com.example.lib.geeksforgeeks.ds.binaryTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by vihaanverma on 03/12/17.
 */

public class VerticalOrderTraversal {
    public static void main(String[] args) {


        Node node = new Node(1);

        node.addLeftNode(new Node(2));
        node.addRightNode(new Node(3));

        node.getLeftNode().addLeftNode(new Node(4));
        node.getLeftNode().addRightNode(new Node(5));

        node.getRightNode().addLeftNode(new Node(6));
        node.getRightNode().addRightNode(new Node(7));


        node.getRightNode().getLeftNode().addRightNode(new Node(8));

        node.getRightNode().getRightNode().addRightNode(new Node(9));

        VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
        verticalOrderTraversal.verticalTraversal(node,0);
        verticalOrderTraversal.printList();
    }

    Map<Integer, LinkedList<Integer>> map = new TreeMap<>();
    private void verticalTraversal(Node node, int depth)
    {
        if(node==null)
        {
            return ;
        }

        LinkedList<Integer> list;
        if(map.containsKey(depth))
        {
             list = map.get(depth);
        }
        else{
            list = new LinkedList<>();
            map.put(depth, list);
        }

        list.add(node.getValue());

        verticalTraversal(node.getLeftNode(), depth-1);
        verticalTraversal(node.getRightNode(), depth+1);
    }

    private void printList(){

        for(Map.Entry<Integer, LinkedList<Integer>> entry : map.entrySet())
        {
            int key = entry.getKey();
            LinkedList list = entry.getValue();
            Iterator it = list.iterator();
            System.out.print(key + " - ");
            while(it.hasNext())
            {
                System.out.print(it.next()+ ",");
            }
            System.out.println();
        }
    }

}

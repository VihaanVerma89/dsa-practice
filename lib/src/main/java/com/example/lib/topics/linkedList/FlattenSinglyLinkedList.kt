package com.example.lib.topics.linkedList

import java.util.*

/*

You are given a singly linked list which in addition to the next pointer, could have a child pointer,
which may or may not point to a separate linked list. These child lists may have one or more children of their own,
and so on, to produce a multilevel data structure, as shown in the example below. Flatten the list so that all the nodes
appear in a single-level, linked list. You are given the head of the first level of the list.  
Example: Input: 
1---2---3---4---5---6--NULL
        |
        7---8---9---10--NULL
            |
            11--12--NULL
Output 1-2-3-7-8-11-12-9-10-4-5-6-NULL
*/

class Node(var value: Int) {
    var mNext: Node? = null
    var mChild: Node? = null
    override fun toString(): String {
        return "Node(value=$value)"
    }

}
class Test() {


    fun flatten(root: Node?): Node? {
        root?.let {
            val s = Stack<Node>()
            var curr = root
            while (curr != null) {
                val next = curr.mNext
                val child = curr.mChild
                if (child != null && next != null) {
                    s.push(next)
                    curr.mNext = child
                    curr = child
                } else if (child != null && next == null) {
                    curr = child
                    curr.mChild = null
                } else if (child == null && next != null) {
                    curr = next
                } else if (child == null && next == null) {
                    // reached null node
                    if (s.isNotEmpty()) {
                        val pop = s.pop()
                        curr.mNext = pop
                        curr = pop
                    } else {
                        curr = null
                    }
                }
            }
        }
        return root
    }

    fun printNodes(root: Node?) {
        root?.let {
            var curr = root
            while (curr != null) {
                println(curr.value)
                curr = curr.mNext
            }
        }
    }
}

fun main() {

    val test = Test()
    val exampleOne = getExampleOne()
    val flatten = test.flatten(exampleOne)
    test.printNodes(flatten)
}


fun getExampleOne(): Node {
    val list = getSampleListOfNodes()
    list[0].mNext = list[1];
    list[1].mNext = list[2];
    list[2].mNext = list[3];
    list[3].mNext = list[4];
    list[4].mNext = list[5];
    list[6].mNext = list[7];
    list[7].mNext = list[8];
    list[8].mNext = list[9];
    list[10].mNext = list[11];
    list[2].mChild = list[6];
    list[7].mChild = list[10];
    return list[0]
}


fun getSampleListOfNodes(): List<Node> {
    val list = arrayListOf<Node>()
    for (i in 1..12) {
        list.add(Node(i))
    }
    return list
}
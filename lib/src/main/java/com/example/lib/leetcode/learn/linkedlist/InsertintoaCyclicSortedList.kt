package com.example.lib.leetcode.learn.linkedlist

import com.sun.org.apache.xalan.internal.xsltc.dom.CurrentNodeListFilter

class InsertintoaCyclicSortedList {

    /*
    iv
    0-4
    4-0

    */

    fun insert(head: Node?, insertVal: Int): Node? {
        var result = head

        val node = Node(insertVal)
        if (head == null) {
            result = node
            node.next = node
        } else {
            // len 1
            if (result?.next == result) {
                result?.next = node
                node?.next = result
            } else {
                // len 2
                var inserted = false
                var c = head
                var p: Node? = null

                fun append(c: Node?, node: Node?) {
                    val next = c?.next
                    c?.next = node
                    node?.next = next
                    inserted = true
                }

                while (!inserted) {
                    val currVal = c?.`val`
                    val preValue = p?.`val`
                    val nextVal = c?.next?.`val`

                    if (currVal != null && nextVal != null && currVal == insertVal) {
                        // append at the comparison node when insertVal is equal
                        append(c, node)

                    } else if (preValue != null && currVal != null && preValue < insertVal && insertVal < currVal) {
                        // prev. iv. curr
                        append(p, node)
                    } else if (currVal != null && nextVal != null && currVal < insertVal && insertVal < nextVal) {
                        // curr. iv. next
                        append(c, node)
                    } else if (nextVal != null && currVal != null && currVal > nextVal) {
                        // end of the list
                        // 3-0

                        // 6-3 iv = 1
                        // 6-1-3
                        if (insertVal < nextVal) {
                            // curr. iv. next at circle end
                            append(c, node)
                        } else if (insertVal == nextVal) {
                            // will be handled by first if condition
                        } else if (insertVal > nextVal) {
                            // will be handled by insert in between condition
                        }
                    } else if (c == head && p != null) {
                        // we have reached head again after one cycle and couldn't find insert postion
                        append(p,node)
                    }

                    p = c
                    c = c?.next
                }
            }

        }
        return result
    }


    class Node(var `val`: Int) {
        var next: Node? = null
    }

}

fun main() {
    val o = InsertintoaCyclicSortedList()
    val node = InsertintoaCyclicSortedList.Node(3)
    node.apply {
        next = InsertintoaCyclicSortedList.Node(4).apply {
            next = InsertintoaCyclicSortedList.Node(1).apply {
                next = node
            }
        }
    }
    o.insert(node, 2)
}
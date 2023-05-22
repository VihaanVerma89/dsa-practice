package com.example.lib.leetcode.linkedlist



class InsertintoaCyclicSortedListWrong {

    class Node(var `val`: Int) {
        var next: Node? = null
    }

    fun insert(head: Node?, insertVal: Int): Node? {
        var root = head
        val node = Node(insertVal)
        // case 0
        if (root == null) {
            node.next = node
            return node
        } else {
            // case 1
            if (root.next == root) {
                root.next = node
                node.next = root
            } else {
                // more than 2 nodes
                var inserted = false
                var c = root
                var p: Node? = null
                var headVisitCount = 0
                while (!inserted) {
                    val currValue = c?.`val`
                    val nextValue = c?.next?.`val`
                    val prevValue = p?.`val`
                    if (c == head) {
                        headVisitCount++
                    }
                    if (currValue != null && nextValue != null) {
                        if (insertVal in currValue..nextValue) {
                            val next = c?.next
                            c?.next = node
                            node.next = next
                            inserted = true
                        } else if (prevValue != null && currValue < prevValue && currValue < nextValue && headVisitCount > 1) {
                            // we are at the end of the list
                            // insert 0 ?
                            // 2 - 1
                            p?.next = node
                            node.next = c
                            inserted = true
                        } else if (prevValue != null && currValue >= prevValue && currValue > nextValue && headVisitCount > 1) {
                            // we are at the end of the list
                            // insert 3 ?
                            // 2 - 1
                            p?.next = node
                            node.next = c
                            inserted = true
                        } else if (headVisitCount > 1) {
                            // we have again reached the head and were not able to add the node anywhere
                            // the node to be added is either the lowest or the highest
                            p?.next = node
                            node.next = c
                            inserted = true
                        }
                    }
                    p = c
                    c = c?.next
                }
            }

        }
        return root
    }
}
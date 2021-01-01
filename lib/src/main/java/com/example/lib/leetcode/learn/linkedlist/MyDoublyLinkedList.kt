package com.example.lib.leetcode.learn.linkedlist

class MyDoublyLinkedList() {

    class DLinkNode(var value: Int) {
        var prev: DLinkNode? = null
        var next: DLinkNode? = null
    }

    /** Initialize your data structure here. */

    var head: DLinkNode? = null
    var tail: DLinkNode? = null
    var len = 0

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    fun get(index: Int): Int {
        var value = -1
        val dNode = getDNode(index)
        dNode?.let {
            value = it.value
        }
        return value
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    fun addAtHead(`val`: Int) {
        if (head == null) {
            initDLL(`val`)
        } else {
            val dLinkNode = DLinkNode(`val`)
            head?.prev = dLinkNode
            dLinkNode.next = head
            head = dLinkNode
        }
        len++
    }

    private fun initDLL(i: Int) {
        val dLinkNode = DLinkNode(i)
        head = dLinkNode
        tail = dLinkNode
    }

    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(`val`: Int) {
        if (tail == null) {
            initDLL(`val`)
        } else {
            val dLinkNode = DLinkNode(`val`)
            dLinkNode.prev = tail
            tail?.next = dLinkNode
            tail = dLinkNode
        }
        len++
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, `val`: Int) {
        if (index > len) {
            return
        }
        if (index == 0) {
            addAtHead(`val`)
        } else if (index == len) {
            addAtTail(`val`)
        } else if (index in 1 until len) {
            // index is 1..len-1
            val indexNode = getDNode(index)

            val dLinkNode = DLinkNode(`val`)
            dLinkNode.prev = indexNode?.prev
            dLinkNode.next = indexNode
            indexNode?.prev?.next = dLinkNode
            indexNode?.prev = dLinkNode
            len++
        }
    }

    private fun getDNode(index: Int): DLinkNode? {
        var node: DLinkNode? = null
        head?.let {
            var n = head
            var i = 0
            while (n != null) {
                if (index == i) {
                    node = n
                    break
                }
                n = n.next
                i++
            }
        }
        return node
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {
        if (index >= len)
            return

        if (index == 0) {
            deleteAtHead()
        } else if (index == len - 1) {
            deleteAtTail()
        } else if (index in 1 until len) {
            val dNode = getDNode(index)
            val prev = dNode?.prev
            val next = dNode?.next
            prev?.next = next
            next?.prev = prev
            dNode?.next = null
            dNode?.prev = null
            len--
        }

    }

    private fun deleteAtHead() {
        head?.let {
            val next = it.next
            next?.prev = null
            it.next = null
            head = next
            len--
        }
    }

    private fun deleteAtTail() {
        tail?.let {
            val prev = it.prev
            prev?.next = null
            tail?.prev = null
            tail = prev
            len--
        }
    }


}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(`val`)
 * obj.addAtTail(`val`)
 * obj.addAtIndex(index,`val`)
 * obj.deleteAtIndex(index)
 */
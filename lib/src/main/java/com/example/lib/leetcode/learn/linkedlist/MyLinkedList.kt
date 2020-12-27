package com.example.lib.leetcode.learn.linkedlist

class MyLinkedList() {

    /** Initialize your data structure here. */
    class Node(var value: Int) {
        var next: Node? = null
    }

    private var head: Node? = null
    private var tail: Node? = null
    private var size = 0

    /** obj.get() the value of the index-th node in the linked list. If the index is invalid, return -1. */
    fun get(index: Int): Int {
        val value = getNode(index)?.value ?: -1
        return value
    }

    private fun getNode(index: Int): Node? {
        var node: Node? = null
        if (index < size) {
            head?.let {
                node = it
                var i = 0
                while (i < index) {
                    node = node?.next
                    i++
                }
                // i == index
            }
        }
        return node
    }

    /** Add a node of value val before the first element of the linked list.
     *  After the insertion, the new node will be the first node of the linked list. */
    fun addAtHead(`val`: Int) {
        if (head == null) {
            init(`val`)
        } else {
            val node = Node(`val`)
            node.next = head
            head = node
        }
        size++
    }

    private fun init(value: Int) {
        if (head == null) {
            val node = Node(value)
            head = node
            tail = node
        }
    }


    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(`val`: Int) {
        if (head == null) {
            init(`val`)
        } else {
            val node = Node(`val`)
            tail?.next = node
            tail = node
        }
        size++
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, `val`: Int) {
        if (index == 0) {
            addAtHead(`val`)
        } else if (index <= size - 1) {
            var i = 0
            var node: Node? = head
            while (i < index - 1) {
                i++
                node = node?.next
            }

            // i is at index - 1
            var newNode = Node(`val`)
            val rightNode = node?.next
            node?.next = newNode
            newNode.next = rightNode
            size++
        } else if (index == size) {
            // append
            addAtTail(`val`)
        } else if (index > size) {
            //ignore
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {
        if (index < size) {
            var i = 0
            var node: Node? = head
            if (index == 0) {
                deleteHead(index)
            } else if (index == size - 1) {
                deleteTail(index)
            } else {
                // delete in between
                while (i < index - 1) {
                    i++
                    node = node?.next
                }
                // i == index -1
                val leftNode = node
                val rightNode = node?.next?.next
                leftNode?.next = rightNode
                size--
            }
        }
    }

    private fun deleteHead(index: Int) {
//        if (index == 0) {
        head?.let {
            val currHead = it
            val next = head?.next
            head = next
            currHead?.next = null
            size--
        }
//        }
    }

    private fun deleteTail(index: Int) {
//        if (index == size - 1) {
        val node = getNode(index - 1)
        node?.let {
            node?.next = null
            tail = node
            size--
        }
//        }
    }

    fun printList() {
        var node = head
        while (node != null) {
            print("${node.value},")
            node = node.next
        }
        println()
    }

}


fun main() {
//    Your MyLinkedList object will be instantiated and called as such:
    var obj = MyLinkedList()
    obj.addAtHead(84)
    obj.printList()
    obj.addAtTail(2)
    obj.printList()
    obj.addAtTail(39)
    obj.printList()
    obj.get(3)
    obj.get(1)
    obj.addAtTail(42)
    obj.printList()
    obj.addAtIndex(1, 80)
    obj.printList()
    obj.addAtHead(14)
    obj.printList()
    obj.addAtHead(1)
    obj.printList()
    obj.addAtTail(53)
    obj.printList()
    obj.addAtTail(98)
    obj.printList()
    obj.addAtTail(19)
    obj.printList()
    obj.addAtTail(12)
    obj.printList()
    obj.get(2)
    obj.addAtHead(16)
    obj.printList()
    obj.addAtHead(33)
    obj.printList()
    obj.addAtIndex(4, 17)
    obj.printList()
    obj.addAtIndex(6, 8)
    obj.printList()
    obj.addAtHead(37)
    obj.printList()
    obj.addAtTail(43)
    obj.printList()
//    obj.deleteAtIndex(11)
    obj.printList()
    obj.addAtHead(80)
    obj.printList()
    obj.addAtHead(31)
    obj.printList()
    obj.addAtIndex(13, 23)
    obj.printList()
    obj.addAtTail(17)
    obj.printList()
    obj.get(4)
    obj.addAtIndex(10, 0)
    obj.printList()
    obj.addAtTail(21)
    obj.printList()
    obj.addAtHead(73)
    obj.printList()
    obj.addAtHead(22)
    obj.printList()
    obj.addAtIndex(24, 37)
    obj.printList()
    obj.addAtTail(14)
    obj.printList()
    obj.addAtHead(97)
    obj.printList()
    obj.addAtHead(8)
    obj.printList()
    obj.get(6)
    obj.deleteAtIndex(17)
    obj.printList()
    obj.addAtTail(50)
    obj.printList()
    obj.addAtTail(28)
    obj.printList()
    obj.addAtHead(76)
    obj.printList()
    obj.addAtTail(79)
    obj.printList()
    obj.get(18)
    obj.deleteAtIndex(30)
    obj.printList()
    obj.addAtTail(5)
    obj.printList()
    obj.addAtHead(9)
    obj.printList()
    obj.addAtTail(83)
    obj.printList()
    obj.deleteAtIndex(3)
    obj.printList()
    obj.addAtTail(40)
    obj.printList()
    obj.deleteAtIndex(26)
    obj.printList()
    obj.addAtIndex(20, 90)
    obj.printList()
    obj.deleteAtIndex(30)
    obj.printList()
    obj.addAtTail(40)
    obj.printList()
    obj.addAtHead(56)
    obj.printList()
    obj.addAtIndex(15, 23)
    obj.printList()
    obj.addAtHead(51)
    obj.printList()
    obj.addAtHead(21)
    obj.printList()
    obj.get(26)
    obj.addAtHead(83)
    obj.printList()
    obj.get(30)
    obj.addAtHead(12)
    obj.printList()
    obj.deleteAtIndex(8)
    obj.printList()
    obj.get(4)
    obj.addAtHead(20)
    obj.printList()
    obj.addAtTail(45)
    obj.printList()
    obj.get(10)
    obj.addAtHead(56)
    obj.printList()
    obj.get(18)
    obj.addAtTail(33)
    obj.printList()
    obj.get(2)
    obj.addAtTail(70)
    obj.printList()
    obj.addAtHead(57)
    obj.printList()
    obj.addAtIndex(31, 24)
    obj.printList()
    obj.addAtIndex(16, 92)
    obj.printList()
    obj.addAtHead(40)
    obj.printList()
    obj.addAtHead(23)
    obj.printList()
    obj.deleteAtIndex(26)
    obj.printList()
    obj.get(1)
    obj.addAtHead(92)
    obj.printList()
    obj.addAtIndex(3, 78)
    obj.printList()
    obj.addAtTail(42)
    obj.printList()
    obj.get(18)
    obj.addAtIndex(39, 9)
    obj.printList()
    obj.get(13)
    obj.addAtIndex(33, 17)
    obj.printList()
    obj.get(51)
    obj.addAtIndex(18, 95)
    obj.printList()
    obj.addAtIndex(18, 33)
    obj.printList()
    obj.addAtHead(80)
    obj.printList()
    obj.addAtHead(21)
    obj.printList()
    obj.addAtTail(7)
    obj.printList()
    obj.addAtIndex(17, 46)
    obj.printList()
    obj.get(33)
    obj.addAtHead(60)
    obj.printList()
    obj.addAtTail(26)
    obj.printList()
    obj.addAtTail(4)
    obj.printList()
    obj.addAtHead(9)
    obj.printList()
    obj.get(45)
    obj.addAtTail(38)
    obj.printList()
    obj.addAtHead(95)
    obj.printList()
    obj.addAtTail(78)
    obj.printList()
    obj.get(54)
    obj.addAtIndex(42, 86)
    obj.printList()
}



package com.example.lib.topics.linkedList.mylinkedlist


class MyNode {
    var value: Int = Int.MAX_VALUE
    var next: MyNode? = null
}

class MyLinkedList {

    var head: MyNode? = null
    var size = 0

    fun get(index: Int): Int {
        var value = -1
        // valid index
        if (index < size) {
            val nodeAt = getNodeAt(index)
            nodeAt?.value?.apply {
                value = this
            }
        }
        return value
    }

    fun addAtHead(`val`: Int) {
        // no nodes present
        if (head == null) {
            head = MyNode().apply {
                value = `val`
            }
        } else {
            // head already present
            val newHeadNode = MyNode()
            newHeadNode.value = `val`
            newHeadNode.next = head
            head = newHeadNode
        }
        size++
    }

    fun addAtTail(`val`: Int) {
        // list is empty
        if (head == null) {
            addAtHead(`val`)
        } else {
            // list has more than 1 elements
            val nodeAt = getNodeAt(size - 1)
            val myNode = MyNode().apply {
                value = `val`
            }
            nodeAt?.next = myNode
            size++
        }
    }

    private fun getNodeAt(index: Int): MyNode? {
        var node: MyNode? = null
        if (index < size) {
            var i = 0
            var temp = head
            while (i < index) {
                temp = temp?.next
                i++
            }
            node = temp
        }
        return node
    }

    fun addAtIndex(index: Int, `val`: Int) {
        // add at head
        if (index == 0) {
            addAtHead(`val`)
        } else if (index == size) {
            // add at tail
            addAtTail(`val`)
        } else if (index > size) {
            // invalid index
        } else {
            // add in between
            val prevNode = getNodeAt(index - 1)
            if (prevNode == null) {
                println("how is prevNode is null in add in between ??")
            } else {
                val myNode = MyNode().apply {
                    value = `val`
                }
                myNode.next = prevNode.next
                prevNode.next = myNode
            }
            size++
        }
    }

    fun deleteAtIndex(index: Int) {
        if (index < size) {
            if (index == 0) {
                head = head?.next
            } else if (index == size - 1) {
                val prevNode = getNodeAt(index - 1)
                prevNode?.next = null
            } else {
                // delete inbetween
                val prevNode = getNodeAt(index - 1)
                prevNode?.next = prevNode?.next?.next
            }
            size--
        } else {
            // invalid index
        }
    }

    fun printList() {
        println()
        var i = 0
        var node = head
        while (i != size) {
            print(" ${node?.value} ")
            i++
            node = node?.next
        }
    }
}

fun main() {
//    Your MyLinkedList object will be instantiated and called as such:
    // ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
    //[[],[7],[2],[1],                                      [3,0],      [2],[6],[4],                             [4], [4],[5,0],[6]]
    testcase2()

}

fun testcase2() {
    var obj = MyLinkedList()
    obj.addAtTail(1)
    obj.addAtTail(3)
    obj.get(1)
}

fun testcase1() {
    var obj = MyLinkedList()
    obj.addAtHead(7)
    obj.addAtHead(2)
    obj.addAtHead(1)
    obj.printList()

    obj.addAtIndex(3, 0)
    obj.printList()
    obj.deleteAtIndex(2)
    obj.printList()
    obj.addAtHead(6)
    obj.printList()
    obj.addAtTail(4)
    obj.printList()
    obj.get(4)

    obj.addAtHead(4)
    obj.printList()
    obj.addAtIndex(5, 0)
    obj.printList()
    obj.addAtHead(6)
    obj.printList()
}
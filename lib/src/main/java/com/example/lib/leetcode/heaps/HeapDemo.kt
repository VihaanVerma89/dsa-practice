package com.example.lib.leetcode.heaps

import java.util.PriorityQueue

class HeapDemo {

    fun minHeapTest() {
        val heap = PriorityQueue<Int>()
        heap.add(1)
        heap.add(2)
        heap.add(3)

        println("min in heap ${heap.peek()}")
        println("heap.remove()")
        heap.remove()
        println("heap size : ${heap.size} , min : ${heap.peek()}")
    }

    fun maxHeapTest() {
        val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())

        maxHeap.add(1)
        maxHeap.add(2)
        maxHeap.add(3)

        println("maxHeap peek() : ${maxHeap.peek()}")
        println("maxHeap remove(): ${maxHeap.remove()}")
        println("maxHeap size(): ${maxHeap.size}")


    }
}

fun main() {
//    HeapDemo().minHeapTest()
    HeapDemo().maxHeapTest()
}
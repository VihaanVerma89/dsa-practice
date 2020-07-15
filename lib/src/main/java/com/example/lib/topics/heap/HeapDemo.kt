package com.example.lib.topics.heap

import java.util.*

class HeapDemo {
    fun printHeap(priorityQueue: PriorityQueue<Int>) {
        val iterator = priorityQueue.iterator()
        while (iterator.hasNext()) {
            val next = iterator.next()
            print("$next ")
        }
    }

    fun heapDemo() {
        val itemCount = 10

        val minHeap = PriorityQueue<Int>(itemCount)
        val maxHeap = PriorityQueue<Int>(itemCount, Comparator { t: Int, t2: Int -> t2 - t })
        val random = java.util.Random()
        val a = intArrayOf(60 ,15 ,22 ,72 ,88 ,82 ,38 ,76 ,15 ,34 ,69 ,75 ,99 ,32 ,55 ,94 ,61 ,30 ,16 ,49)

        for (i in 0 until 20) {
            val nextInt = random.nextInt(100)
            minHeap.add(nextInt)
            maxHeap.add(nextInt)
        }

        println("\nMin heap")
        printHeap(minHeap)

        println("\nMax heap")
        printHeap(maxHeap)
    }

}

fun main() {
    HeapDemo().heapDemo()
}


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

    data class Person(val name: String, val age: Int)

    val aComp = Comparator<Person> { p1, p2 -> p1.age - p2.age }

    val dComp = Comparator<Person> { p1, p2 -> p2.age - p1.age }
    val people = listOf(
        Person("Alice", 1),
        Person("Alice", 2),
        Person("Alice", 3),
        Person("Alice", 4),
        Person("Alice", 5),
        Person("Bob", 6),
        Person("Charlie", 7)
    )

    fun descendingCompatorTest() {

        val pq = PriorityQueue<Person>(dComp)
        for (i in people) {
            pq.add(i)
            if (pq.size > k) {
                pq.remove()
            }
        }

        while (pq.isNotEmpty()) {
            println("top -> ${pq.poll()}")
        }
    }

    val k = 3
    fun ascendingComparatorTest() {

        val pq = PriorityQueue<Person>(aComp)

        for (i in people) {
            pq.add(i)
            if (pq.size > k) {
                pq.remove()
            }
        }

        while (pq.isNotEmpty()) {
            println("top -> ${pq.remove()}")
        }

    }
}

fun main() {
//    HeapDemo().minHeapTest()
//    HeapDemo().maxHeapTest()

    println("asc comparator test")
    HeapDemo().ascendingComparatorTest()

    println("desc comparator test")
    HeapDemo().descendingCompatorTest()

}
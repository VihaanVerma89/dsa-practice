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

    val ascendingAgeCompator = Comparator<Person>{ p1, p2 -> p1.age - p2.age}
//    val descendingAgeComparator = Comparator<Person> { p1, p2 -> p1.age.compareTo(p2.age) }.reversed()
    val descendingAgeComparator = Comparator<Person> { p1, p2 -> p1.age - p2.age }.reversed()
    fun descendingCompatorTest(){

        val people = listOf(
            Person("Alice", 30),
            Person("Bob", 25),
            Person("Charlie", 35)
        )


        val ascSortedPeople = people.sortedWith(ascendingAgeCompator)
        println("asc order : $ascSortedPeople")

        val descSortedPeople = people.sortedWith(descendingAgeComparator)
        println("desc order : $descSortedPeople")
    }
}

fun main() {
//    HeapDemo().minHeapTest()
//    HeapDemo().maxHeapTest()

    HeapDemo().descendingCompatorTest()
}
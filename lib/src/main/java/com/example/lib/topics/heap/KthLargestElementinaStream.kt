package com.example.lib.topics.heap

import java.util.*

/*
int[] arr = [4,5,8,2];
//2,4,5,8
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
2,3,4,5,8
kthLargest.add(5);   // returns 5
2,3,4,5,5,8
kthLargest.add(10);  // returns 5
2,3,4,5,5,8,10
kthLargest.add(9);   // returns 8
2,3,4,5,5,8,9,10
kthLargest.add(4);   // returns 8
2,3,4,4,5,5,8,9,10
* */
class KthLargestElementinaStream(val k: Int, nums: IntArray) {

    val minHeap = PriorityQueue<Int>()

    init {
        for (i in nums) {
            addToHeap(i)
        }
    }

    fun add(value: Int): Int {
        var addToHeap = -1
        addToHeap = addToHeap(value)
        return addToHeap
    }

    fun addToHeap(value: Int): Int {
        minHeap.add(value)
        var poll = -1
        val size = minHeap.size
        if (size == k) {
            poll = minHeap.peek()
        } else if (size < k) {
            poll = minHeap.peek()
        } else if (size > k) {
            poll == minHeap.poll()
            poll = minHeap.peek()
        }
        return poll
    }


}

fun main() {

    val intArrayOf = intArrayOf(4, 5, 8, 2)
    val o = KthLargestElementinaStream(3, intArrayOf)
    var add = o.add(3)
    println(add)

    add = o.add(5)
    println(add)

    add = o.add(10)
    println(add)

    add = o.add(9)
    println(add)

    add = o.add(4)
    println(add)
}
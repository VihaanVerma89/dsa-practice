package com.example.lib.leetcode.MovingAverage1.q

import java.util.*

//https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1368/
class MovingAverage(val size: Int) {

    /*
    * 0 1 2
    *   1 2 3
    *     3 4 5
    *       4 5 6
    *         5 6 7
    * */
    val q: Queue<Int> = LinkedList<Int>()
    var sum = 0
    var offerCount = 0
    fun next1(`val`: Int): Double {
        offerCount++
        if (q.size == size) {
            // q is full
            val poll = q.poll()
        }

        // q is not full
        q.offer(`val`)

        var sum = 0.toDouble()
        for (e in q) {
            sum += e
        }
        var d = size
        if (offerCount < size) {
            d = offerCount
        }
        val avg = sum / d
        return avg
    }

    fun next(`val`: Int): Double {

        // sum of elements / number of elements
        var avg: Double = 0.0

        if (q.size < size) {
            q.offer(`val`)
            sum += `val`
            avg = sum.toDouble() / q.size
        } else if (q.size == size) {
            val poll = q.poll()
            sum -= poll
            q.offer(`val`)
            sum += `val`
            avg = sum.toDouble() / q.size
        } else if (q.size > 3) {
            println("we shouldnt reach here")
        }

        return avg
    }

}

fun main() {

}

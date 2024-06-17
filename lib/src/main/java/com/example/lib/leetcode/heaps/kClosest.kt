package com.example.lib.leetcode.heaps

import java.util.PriorityQueue

//class kClosest {
//
//    class CoordinateDistance(val distance: Double, val coordinates: IntArray)
//
//    val comparator = Comparator<CoordinateDistance> { p0, p1 -> (p0.distance - p1.distance).toInt() }.reversed()
//
//    val maxHeap = PriorityQueue<CoordinateDistance>(comparator)
//    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
//
//        for (point in points) {
//            val d = getDistanceFromOrigin(point[0], point[1])
//            maxHeap.add(CoordinateDistance(d, point))
//            if (maxHeap.size > k) {
//                val value = maxHeap.poll()
//                println("removed from top: ${value.distance}, ${value.coordinates}")
//            }
//        }
//
//        var i = 0
//        val result = Array(k) { IntArray(2) { 0 } }
//        while (maxHeap.isNotEmpty()) {
//            val node = maxHeap.poll()
//            result[i++] = node.coordinates
//        }
//        return result
//    }
//
//    fun getDistanceFromOrigin(x: Int, y: Int): Double {
//        val d = Math.sqrt((x * x + y * y).toDouble())
//        println("d : $d")
//        return d
//    }
//
//    fun test() {
//        val result = Array<IntArray>(2, { IntArray(2) })
//
//        println(result)
//    }
//}


class kClosest {

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {

        val compareByDistance: Comparator<Pair<Double, IntArray>> = compareBy { it.first }

    }

}

fun main() {
//   val result =  kClosest().kClosest(arrayOf(intArrayOf(1, 3), intArrayOf(-2, 2)), 1)
    val result =
        kClosest().kClosest(arrayOf(intArrayOf(3, 3), intArrayOf(5, -1), intArrayOf(-2, 4)), 2)
    println(result.toString())
//    val result =
//        kClosest().kClosest(arrayOf(intArrayOf(3, 3), intArrayOf(5, -1), intArrayOf(-2, 4)), 2)
//    println(result)
//
//    kClosest().test()
}
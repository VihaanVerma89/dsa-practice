package com.example.lib.topics.arrays

import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

class KClosestPointstoOrigin {
    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        val r = arrayListOf<IntArray>()

        val distanceMap = hashMapOf<Double, ArrayList<IntArray>>()
        val c = kotlin.Comparator { n1: Double, n2: Double -> n2.compareTo(n1) }
        val pq = PriorityQueue(c)
        for (point in points) {
            val distance = getDistance(point[0], point[1])
            if (distanceMap.containsKey(distance)) {
                //append
                val arrayList = distanceMap[distance]
                arrayList?.add(point)
            } else {
                val a = arrayListOf<IntArray>()
                a.add(point)
                distanceMap[distance] = a
            }
            pq.add(distance)
            if (pq.size > K) {
                pq.poll()
            }
        }

        for (distance in pq) {
            val arrayList = distanceMap[distance]
            if (arrayList != null) {
                for (intArray in arrayList) {
                    r.add(intArray)
                }
            }
            distanceMap.remove(distance)
        }
        return r.toTypedArray()
    }

    fun getDistance(x: Int, y: Int): Double {
        val x2 = x.toDouble().pow(2.0)
        val y2 = y.toDouble().pow(2.0)
        var r = sqrt(x2 + y2)
        return r
    }
}

fun main() {
    val i = arrayOf(intArrayOf(0, 1), intArrayOf(0, 1))
    KClosestPointstoOrigin().kClosest(i, 2)
}

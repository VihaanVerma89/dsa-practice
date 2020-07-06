package com.example.lib.topics.arrays

//https://www.geeksforgeeks.org/find-a-fixed-point-in-a-given-array/

class FindaFixedPoint {

    fun getIndex(a: IntArray): Int {
        var index = -1
        if (a.size > 0) {
            var hi = a.size
            var lo = 0
            while (lo < hi) {
                var mid = hi - 1
                val n = a[mid]
                if (n == mid) {
                    return mid
                } else if (n > mid) {
                    hi = mid
                } else if (n < mid) {
                    lo = mid
                }
            }
        }

        return index
    }
}

fun main() {
    val test = FindaFixedPoint()
    val a = intArrayOf(-10, -5, 0, 3, 7)
//    val a = intArrayOf(0,2,3,4,5)
    val index = test.getIndex(a)
    println(index)
}
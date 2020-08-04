package com.example.lib.topics.arrays

//https://leetcode.com/problems/merge-intervals/
class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val ra: ArrayList<IntArray> = arrayListOf()
        val a = intervals
        if (intervals.isNotEmpty()) {
            val c = Comparator { a1: IntArray, a2: IntArray -> a1[0] - a2[0] }
            intervals.sortWith(c)
            ra.add(intervals[0])
            for (i in 1 until intervals.size) {
                if (overlaps(ra.last(), intervals[i])) {
                    val mergeArray = mergeArray(ra.last(), intervals[i])
                    ra[ra.lastIndex] = mergeArray
                } else {
                    ra.add(intervals[i])
                }
            }
        }

        return ra.toTypedArray()
    }

    fun mergeArray(a: IntArray, b: IntArray): IntArray {
        val intArray = IntArray(2)
        intArray[0] = a[0]
        if (b[1] >= a[1]) {
            intArray[1] = b[1]
        } else {
            intArray[1] = a[1]
        }
        return intArray
    }

    fun overlaps(a: IntArray, b: IntArray): Boolean {
        val s1 = a[0]
        val e1 = a[1]

        val s2 = b[0]
        val e2 = b[1]

        var overlaps = false
        when {
            s2 in s1..e1 -> {
                overlaps = true
            }
            e2 in s1..e1 -> {
                overlaps = true
            }
            s1 in s2..e2 -> {
                overlaps = true
            }
            e1 in s2..e2 -> {
                overlaps = true
            }
        }
        return overlaps
    }
}

fun main() {
    val mergeIntervals = MergeIntervals()
//    val a = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
    val a = arrayOf(intArrayOf(1, 4), intArrayOf(0, 4))
    val merge = mergeIntervals.merge(a)
}
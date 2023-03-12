package com.example.lib.topics.arrays.twoPointerApproach


class MergeSortedArray {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    }

    fun mergeBySort(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        for (i in 0 until n) {
            nums1[m + i] = nums2[i]
        }
        nums1.sort()
    }

    fun mergeByCopy(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val num1Copy = nums1.copyOf()

        var j = 0
        var k = 0
        for (i in nums1.indices) {
            if (j < m) {
                // compare both arrays
                if (num1Copy[j] < nums2[k]) {
                    nums1[i] = num1Copy[j]
                    j++
                } else if (num1Copy[j] == nums2[k]) {
                    nums1[i] = num1Copy[j]
                    j++
                } else if (num1Copy[j] > nums2[k]) {
                    nums1[i] = nums2[k]
                    k++
                }
            } else {
                // shift remaining from nums2
                nums1[i] = nums2[k]
                k++
            }
        }
    }

    fun mergeBySort2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m
        var j = 0

        while (i < m + n && j < n) {
            nums1[i] = nums2[j]
            i++
            j++
        }
        nums1.sort()
    }
}

fun main() {
    val msa = MergeSortedArray()
    val input1 = intArrayOf(1,2,3,0,0,0)
    val input2 = intArrayOf(2,5,6)

    val m = 3
    val n = 3
    msa.mergeByCopy(input1, m, input2, n)
    println(input1.joinToString(","))

}
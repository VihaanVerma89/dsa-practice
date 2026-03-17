package com.example.lib.leetcode.`01arrays`.twoPointerApproach


// https://leetcode.com/problems/merge-sorted-array/editorial/
class MergeSortedArray {

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

    fun mergeByCopy2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

        val num1Copy = nums1.copyOf()
        var p1 = 0
        var p2 = 0

        for (i in nums1.indices) {

            // pull value from both array
            if (p1 < m && p2 < n) {
                if (num1Copy[p1] <= nums2[p2]) {
                    nums1[i] = num1Copy[p1]
                    p1++
                } else if (num1Copy[p1] > nums2[p2]) {
                    nums1[i] = nums2[p2]
                    p2++
                }
            } else if (p1 < m && p2 >= n) {
                // pull only from copy
                nums1[i] = num1Copy[p1]
                p1++
            } else if (p1 >= m && p2 < n) {
                // pull from nums2 only
                nums1[i] = nums2[p2]
                p2++
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

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m
        var j = 0

        for (i in m until m + n) {
            nums1[i] = nums2[j]
            j++
        }
        return nums1.sort()
    }

    // [4,5,6,0,0,0]
    // [1,2,3]
    fun mergeByThreePointers(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var p1 = m - 1
        var p2 = nums2.lastIndex
        var p = nums1.lastIndex

        for (i in nums1.lastIndex downTo 0) {
            if (p1 >= 0 && p2 >= 0) {
                // compare both arrays
                if (nums1[p1] <= nums2[p2]) {
                    // last elemement of nums2 is bigger
                    nums1[p] = nums2[p2]
                    p--
                    p2--
                } else if (nums1[p1] > nums2[p2]) {
                    // last element of nums1 is bigger
                    nums1[p] = nums1[p1]
                    p--
                    p1--
                }
            } else if (p1 >= 0 && p2 < 0) {
                println("second array empty")
            } else if (p1 < 0 && p2 >= 0) {
                println("first array empty")
                nums1[p] = nums2[p2]
                p--
                p2--
            }

            println(nums1.contentToString())

        }

    }

}

fun main() {
    val msa = MergeSortedArray()
    val input1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val input2 = intArrayOf(2, 5, 6)

    val m = 3
    val n = 3
    msa.mergeByCopy(input1, m, input2, n)
    println(input1.joinToString(","))

}
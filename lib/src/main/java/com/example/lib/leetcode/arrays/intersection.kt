package com.example.lib.leetcode.arrays

class intersection {

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {

        val hset1 = hashSetOf<Int>()
        val hset2 = hashSetOf<Int>()

        for (num in nums1) {
            hset1.add(num)
        }

        for (num in nums2) {
            hset2.add(num)
        }

        hset1.retainAll(hset2)

        val output = IntArray(hset1.size)
        for ((i, value) in hset1.withIndex()) {
            output[i] = value
        }
        return output
    }
}
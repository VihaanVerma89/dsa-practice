package com.example.lib.leetcode.learn.arrays

class containsDuplicate {

    fun containsDuplicate(nums: IntArray): Boolean {
        val hset = hashSetOf<Int>()

        for (num in nums) {
            if (hset.contains(num)) {
                return true
            } else {
                hset.add(num)
            }
        }

        return false
    }

}
package com.example.lib.leetcode.`01arrays`

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
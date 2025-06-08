package com.example.lib.leetcode.`02hashmap`

class missingNumber {

    fun missingNumber(nums: IntArray): Int {

        val hset = hashSetOf<Int>()
        for (i in nums) {
            hset.add(i)
        }

        for (i in 0..nums.size) {
            if (hset.contains(i)) {

            } else {
                return i
            }
        }
        return -1
    }
}
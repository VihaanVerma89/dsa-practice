package com.example.lib.leetcode.`02hashmap`

class `04missingNumber` {


    fun missingNumber(nums: IntArray): Int {

        val hSet = HashSet<Int>()

        for (i in 0..nums.size) {
            hSet.add(i)
        }


        for (num in nums) {
            hSet.remove(num)
        }

        var result = Int.MIN_VALUE
        for (i in hSet) {
            result = i
        }

        return result
    }


    fun missingNumber1(nums: IntArray): Int {

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
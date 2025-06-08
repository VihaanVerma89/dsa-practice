package com.example.lib.leetcode.`01arrays`

class singleNumber {


    fun singleNumber(nums: IntArray): Int {
        val hset = hashSetOf<Int>()
        var numSum = 0
        var hSum = 0
        for (num in nums) {

            if (!hset.contains(num)) {
                hset.add(num)
                hSum += num
            }
            numSum+=num
        }

        return 2*hSum-numSum
    }

    fun singleNumberHset(nums: IntArray): Int {

        val hset = hashSetOf<Int>()
        for (num in nums) {
            if (hset.contains(num)) {
                hset.remove(num)
            } else {
                hset.add(num)
            }
        }

        return hset.elementAt(0)
    }

}
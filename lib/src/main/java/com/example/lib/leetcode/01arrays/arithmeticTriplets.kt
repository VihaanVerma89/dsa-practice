package com.example.lib.leetcode.`01arrays`

class arithmeticTriplets {

    fun arithmeticTriplets(nums: IntArray, diff: Int): Int {

        var r = 0

        val hmap = hashMapOf<Int, Int>()


        for (iv in nums.withIndex()) {
            hmap.put(iv.value, iv.index)
        }

        for (iv in nums.withIndex()) {
            val jValue = iv.value + diff
            if (hmap.contains(jValue)) {
                val kValue = jValue + diff
                if (hmap.contains(kValue)) {
                    r++
                }
            }
        }

        return r

    }

}

fun main() {

}
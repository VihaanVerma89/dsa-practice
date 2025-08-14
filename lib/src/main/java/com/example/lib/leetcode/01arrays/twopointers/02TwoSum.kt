package com.example.lib.leetcode


class TwoSum {

    //    https://leetcode.com/problems/two-sum/
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hMap = hashMapOf<Int, Int>()
        val ans = IntArray(2) { -1 }

        for ((i, v) in nums.WithIndex()) {

            val diff = target - v

            if (hMap.contains(diff)) {
                ans[0] = hMap.get(diff)!!
                ans[1] = i
            } else {
                hMap[v] = i
            }

        }
        return ans
    }

}

fun main() {
    val input = intArrayOf(1, 2, 3, 4)
    val o = TwoSum().twoSum(input, 5)
    println(o.contentToString())
}
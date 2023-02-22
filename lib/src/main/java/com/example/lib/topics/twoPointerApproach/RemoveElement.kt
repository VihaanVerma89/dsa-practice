package com.example.lib.topics.twoPointerApproach

class RemoveElement {
//    https://leetcode.com/problems/remove-element/
    fun removeElement(nums: IntArray, value: Int): Int {
        var i = 0
        var j = nums.lastIndex
        var swap = 0


        while (i <= nums.lastIndex && i <= j) {
            val currentValue = nums[i]
            if (currentValue == value) {
                // match
                if (i == j) {
                    nums[i] = -1
                } else {
                    val t = nums[j]
                    nums[j] = currentValue
                    nums[i] = t
                }
                j--
                swap++
            } else {
                // not a match
                i++
            }
        }
        val unique = nums.size - swap
        return unique
    }
}

fun main() {
    val c = RemoveElement()
    val nums = intArrayOf()
    val value = 2
    c.removeElement(nums, value)
    println(nums)
}
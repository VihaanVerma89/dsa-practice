package com.example.lib.topics.twoPointerApproach


fun removeDuplicatesSol(nums: IntArray): Int {

    var i = 0
    if (nums.size > 1) {
        var j = 0
        while (j != nums.size) {
            if (nums[i] == nums[j]) {
                j++
            } else {
                i++
                swap(nums, i, j)
                j++
            }
        }
        if (i >= 0) {
            i++
        }
    } else {
        i = 1
    }

    return i
}


/*
* https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/
* */
fun removeDuplicates(nums: IntArray): Int {
    var i = 0
    var j = 0
    var u = 1

    while (j != nums.size) {
        if (nums[i] == nums[j]) {
            // duplicate
            j++
        } else {
            // not duplicate
            i++
            u++
            nums[i] = nums[j]
        }
    }
    return u
}

fun swap(nums: IntArray, to: Int, from: Int) {
    val temp = nums[to]
    nums[to] = nums[from]
    nums[from] = temp
}

fun main() {

}
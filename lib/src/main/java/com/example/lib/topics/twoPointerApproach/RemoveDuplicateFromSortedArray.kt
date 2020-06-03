package com.example.lib.topics.twoPointerApproach


fun removeDuplicates(nums: IntArray): Int {

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

fun swap(nums: IntArray, to: Int, from: Int) {
    val temp = nums[to]
    nums[to] = nums[from]
    nums[from] = temp
}

fun main() {

}
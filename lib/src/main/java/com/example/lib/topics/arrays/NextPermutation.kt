package com.example.lib.topics.arrays

fun nextPermutation(nums: IntArray): Unit {

    var i = nums.size - 2
    while (i >= 0 && nums[i + 1] <= nums[i]) {
        i--
    }

    if (i >= 0) {
        var j = nums.size - 1

        while (j >= 0 && nums[j] <= nums[i]) {
            j--
        }

    }


}


fun main() {

}
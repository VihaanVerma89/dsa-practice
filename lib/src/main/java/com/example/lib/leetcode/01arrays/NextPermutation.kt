package com.example.lib.leetcode.`01arrays`

/*  https://leetcode.com/explore/interview/card/google/59/array-and-strings/3050/
Note:
- this problem is difficult
 */

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
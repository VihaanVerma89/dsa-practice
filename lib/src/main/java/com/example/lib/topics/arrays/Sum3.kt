package com.example.lib.topics.arrays


fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()

    val res = arrayListOf<ArrayList<Int>>()
    for (i in 0..nums.size) {
        if (i == 0 || nums[i] != nums[i - 1]) {
            twoSumII(nums, i, res)
        }
    }
    return res
}

fun twoSumII(nums: IntArray, i: Int, res: ArrayList<ArrayList<Int>>) {
    var lo = i + 1
    var hi = nums.size - 1
    while (lo < hi) {

        val sum = nums[i] + nums[lo] + nums[hi]
        if (sum < 0) {
            lo++
        } else if (sum > 0) {
            hi++
        } else {
            val arrayListOf = arrayListOf(nums[i], nums[lo], nums[hi])
            res.add(arrayListOf)
        }
    }

}

fun main() {

}

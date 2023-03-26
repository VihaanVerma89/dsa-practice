package com.example.lib.topics.arrays

class rotate {
    /*

    1 <= nums.length <= 105
    -231 <= nums[i] <= 231 - 1
    0 <= k <= 105

    * */
    fun rotate(nums: IntArray, k: Int): Unit {

        if (k == 0) {
            return
        }

        if (k >= nums.size) {
            val modResult = nums.size % k
            if (modResult == 0) {
                return
            }
        }

        val copyNums = nums.copyOf()
        for ((index, value) in copyNums.withIndex()) {
            val newIndex = (index + k) % nums.size
            println("index $index offset ${index + k} newIndex = $newIndex")
            nums[newIndex] = copyNums[index]
        }

    }

}

fun main() {
//    val array = intArrayOf(1,2,3,4,5,6,7)
    val array = intArrayOf(-1, -100, 3, 99)
    val obj = rotate()
    val k = 2
    obj.rotate(array, 2)
    println(array)
}
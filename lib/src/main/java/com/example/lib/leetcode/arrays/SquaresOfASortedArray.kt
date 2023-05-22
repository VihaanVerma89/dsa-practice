package com.example.lib.leetcode.arrays

class SquaresOfASortedArray {

    fun sortedSquares(nums: IntArray): IntArray {
        if (nums.isNotEmpty()) {
            if (nums.size == 1) {
                nums[0] = nums[0] * nums[0]
                return nums
            } else {
                var s = 0
                var e = nums.size-1

                var result = IntArray(nums.size)
                var i = nums.size - 1
                while (i >= 0) {
                    val s2 = nums[s] * nums[s]
                    val e2 = nums[e] * nums[e]
                    if (s2 > e2) {
                        result[i] = s2
                        s++
                    } else if (s2 == e2) {
                        result[i] = s2
                        s++
                    } else if (s2 < e2) {
                        result[i] = e2
                        e--
                    } else {
                        // not possible
                    }
                    i--
                }
                return result
            }
        }
        return nums
    }

    fun sortedSquares1(nums: IntArray): IntArray {

        var i = 0
        var j = nums.size - 1
        val ansArray = IntArray(nums.size)
        if (nums.isNotEmpty()) {
            var ai = ansArray.size - 1

            while (ai >= 0) {
                val ie = nums[i]
                val ie2 = ie * ie
                val je = nums[j]
                val je2 = je * je
                if (ie2 < je2) {
                    ansArray[ai] = je2
                    j--
                } else if (ie2 == je2) {
                    ansArray[ai] = je2
                    j--
                } else if (ie2 > je2) {
                    ansArray[ai] = ie2
                    i++
                }
                ai--
            }
        }
        return ansArray
    }
}

fun main() {
    val s = SquaresOfASortedArray()
}
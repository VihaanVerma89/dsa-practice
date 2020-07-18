package com.example.lib.topics.arrays

class ProductofArrayExceptSelf {
    fun productExceptSelf1(nums: IntArray): IntArray {

        val length = nums.size
        val l = IntArray(length)
        val r = IntArray(length)
        val ans = IntArray(length)

        l[0] = 1
        for (i in 1 until length) {
            l[i] = nums[i - 1] * l[i - 1]
        }

        r[length - 1] = 1
        for (i in length - 2 downTo  0) {
            r[i] = nums[i + 1] * r[i + 1]
        }

        for (i in 0 until length) {
            ans[i] = l[i] * r[i]
        }

        return ans
    }

    fun productExceptSelf(nums: IntArray): IntArray? {

        val length = nums.size
        val L = IntArray(length)
        val R = IntArray(length)
        val answer = IntArray(length)

        L[0] = 1
        for (i in 1 until length) {
            L[i] = nums[i - 1] * L[i - 1]
        }

        R[length - 1] = 1
        for (i in length - 2 downTo 0) {
            R[i] = nums[i + 1] * R[i + 1]
        }

        for (i in 0 until length) {
            answer[i] = L[i] * R[i]
        }
        return answer
    }
}

fun main() {
    val o = ProductofArrayExceptSelf()
    val a = intArrayOf(1, 2, 3, 4)
    o.productExceptSelf(a)
}
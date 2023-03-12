package com.example.lib.leetcode.learn.arrays

class CheckIfExist {

    fun checkIfExist(arr: IntArray): Boolean {
        var e = false
        var hashSet = hashSetOf<Int>()

        for (num in arr) {
            val d = num * 2
            // 2n exists
            if (hashSet.contains(d)) {
                e = true
            }
            // n/2 exists for n
            else if (num % 2 == 0 && hashSet.contains(num / 2)) {
                e = true
            }
            hashSet.add(num)
        }

        return e
    }
}

fun main() {
    val obj = CheckIfExist()
    val checkIfExist = obj.checkIfExist(intArrayOf(-2, 0, 10, -19, 4, 6, -8))
    println("Exists: $checkIfExist")
}
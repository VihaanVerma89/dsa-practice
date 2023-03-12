package com.example.lib.leetcode.learn.arrays

class DuplicateZeros {

    /*
   [1,0,2,3,0,4,5,0]
   [1,0,2,3,0,4,,]

    i          j
   [1,0,2,3,0,4,,]
   [1,0,0,2,3,0,0,4]


    i           j
   0,0,0,0,0,0,0

          ij
   */

    fun duplicateZeros(arr: IntArray): Unit {
        // set i , j pointers

        var i = 0
        var j = arr.lastIndex

        while (i < j) {
            val value = arr[i]
            if (value == 0) {
                j--
            }
            i++
        }

        // i == j
        i = j
        j = arr.lastIndex
        while (i >= 0 && j>=0) {
            val value = arr[i]
            if (value == 0) {
                arr[j--] = arr[i]
                if (j >= 0) {
                    arr[j] = arr[i]
                    j--
                }
            } else {
                arr[j] = arr[i]
                j--
            }
            i--
        }
    }
}

fun main() {
    val obj = DuplicateZeros()
    val a = intArrayOf()
    obj.duplicateZeros(a)
}
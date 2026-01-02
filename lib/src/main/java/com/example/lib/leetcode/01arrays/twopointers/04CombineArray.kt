package com.example.lib.leetcode.`01arrays`.twopointers

import kotlin.collections.mutableListOf as mutableListOf

//https://leetcode.com/problems/merge-sorted-array/
class `04CombineArray` {

    fun combine(arr1: IntArray?, arr2: IntArray?): List<Int> {

        var i = 0
        var j = 0


        if (arr1 != null && arr2 != null) {
            val result = mutableListOf<Int>()
            var r = 0
            while (i < arr1.size && j < arr2.size) {
                val value1 = arr1[i]
                val value2 = arr2[j]

                if (value1 < value2) {
                    result[r++] = value1
                } else if (value1 >= value2) {
                    result[r++] = value2
                }

                i++
                j++
            }

            while (i < arr1.size) {
                result[r++] = arr1[i++]
            }

            while (j < arr2.size) {
                result[r++] = arr2[j++]
            }

            return result
        } else {
            // null array passed
            return listOf()
        }

    }
}
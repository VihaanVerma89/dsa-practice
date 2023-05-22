package com.example.lib.leetcode.arrays

class reverseString {
    fun reverseString(s: CharArray): Unit {

        var i = 0
        var j = s.lastIndex

        while (i != j || i > j) {
            val t = s[i]
            s[i] = s[j]
            s[j] = t
            i++
            j--
        }

    }
}
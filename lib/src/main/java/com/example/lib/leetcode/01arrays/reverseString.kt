package com.example.lib.leetcode.`01arrays`

class reverseString {
    fun reverseString1(s: CharArray): Unit {
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

    fun reverseString(s: CharArray) {
        var i = 0
        var j = s.size - 1
        var temp: Char = ' '

        while (i < j) {
            temp = s[i]
            s[i] = s[j]
            s[j] = temp
            i++
            j--
        }
    }
}
package com.example.lib.leetcode.arrays.twopointers

class Palindrome {

    fun isPalindrome(s: String): Boolean {

        var result = true
        var l = 0
        var r = s.length - 1

        while (l < r) {
            if (s.get(r) != s.get(l)) {
                return false
            }
            l++
            r--
        }

        return result
    }
}

fun main() {
    val result = Palindrome().isPalindrome("racecar")
    println(result)
}
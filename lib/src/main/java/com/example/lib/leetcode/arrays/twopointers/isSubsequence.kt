package com.example.lib.leetcode.arrays.twopointers

class isSubsequence {

    fun isSubsequence(s: String?, t: String?): Boolean {

        var i = 0
        var j = 0
        if (s != null && t != null) {
            while (i < s.length && j < t.length) {
                if (s[i] == t[j]) {
                    i++
                }
                j++
            }
            return s.length == i
        }
        return false
    }
}
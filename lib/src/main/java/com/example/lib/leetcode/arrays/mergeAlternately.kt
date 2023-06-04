package com.example.lib.leetcode.arrays

class mergeAlternately {


    fun mergeAlternately(word1: String, word2: String): String {
        var r = ""

        var i = 0

        while (i < word1.length || i < word2.length) {

            if (i < word1.length) {
                r += word1.get(i)
            }

            if (i < word2.length) {
                r += word2.get(i)
            }
            i++
        }

        return r
    }

}
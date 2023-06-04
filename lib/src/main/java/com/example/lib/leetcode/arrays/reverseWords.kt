package com.example.lib.leetcode.arrays

import java.util.*

class reverseWords {

    fun reverseWords(s: String): String {

        var sb = StringBuilder()

        var i = 0
        var j = 0

        while (j < s.length) {

            val c = s.get(j)
            if (c == ' ') {
                var k = j - 1

                //set i at word start
                // set k at word end
                while (k >= i) {
                    var rc = s.get(k)
                    sb.append(rc)
                    k--
                }
                // set i to start of next word
                j++
                i = j
            } else {
                j++
            }
        }

        return sb.toString()
    }
}

fun main() {
    val reverseWords = reverseWords()
    val input ="Let's take LeetCode contest"
    val output = reverseWords.reverseWords(input)
    println("output: $output")
}
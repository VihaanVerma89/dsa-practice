package com.example.lib.leetcode.backtrack

import com.example.lib.leetcode.backtrack1.backtrack
import kotlin.math.absoluteValue

class numsSameConsecDiff {


    fun backtrack(n: Int, k: Int, s: String, ansList: ArrayList<Int>) {
        // term condition
        if (s.length == n) {
            ansList.add(s.toInt())
            return
        }

        println("s value $s")
        // traversal
        for (i in 0..9) {
            if (s == "" && i == 0) {
                // cant start with 0
            } else {
                if (s == "") {
                    backtrack(n, k, s + i, ansList)
                } else {
                    // diff logic
                    val diff = s.last().digitToInt() - i
                    if (diff.absoluteValue == k) {
                        // valid path to pursue
                        backtrack(n, k, s + i, ansList)
                    }
                }
            }
        }
    }


    fun numsSameConsecDiff(n: Int, k: Int): IntArray {
        val ansList = arrayListOf<Int>()
        backtrack(n, k, "", ansList)
        return ansList.toIntArray()
    }

}
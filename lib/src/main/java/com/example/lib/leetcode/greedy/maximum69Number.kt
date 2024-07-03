package com.example.lib.leetcode.greedy

class maximum69Number {

    fun maximum69Number(num: Int): Int {
        val t = num.toString()
        val sb = StringBuilder()
        var changed = false
        for (i in t) {
            if (changed.not() && i == '6') {
                changed = true
                sb.append(9)
            } else {
                sb.append(i)
            }
        }
        return sb.toString().toInt()
    }

}
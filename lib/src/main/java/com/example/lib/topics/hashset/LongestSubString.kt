package com.example.lib.topics.hashset


fun getLongestSubString(s: String): Int {
    var l = 0

    var i = 0
    var j = 0

    if (s.isNotEmpty()) {
        val end = s.length
        val hashSetOfChar = hashSetOf<Char>()

        while (i != end && j != end) {
            val c = s[j]
            if (hashSetOfChar.contains(c)) {
                val c1 = s[i]
                hashSetOfChar.remove(c1)
                i++
            } else {
                hashSetOfChar.add(c)
                j++
                val subl = j - i
                l = l.coerceAtLeast(subl)
            }
        }
    }

    return l
}

fun main() {

//    val s = "abcabcbb"
    val s = " "
    val l = getLongestSubString(s)
    println(l)
}
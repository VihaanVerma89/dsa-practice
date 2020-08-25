package com.example.lib.topics.strings

class StringSplitInHalf {

    fun splitInHalf(s: String): Pair<String, String> {
        var firstHalf = ""
        var secondHalf = ""
        if (s.isNotEmpty()) {
            val mid = (s.length - 1) / 2
            firstHalf = s.substring(0, mid+1)
            secondHalf = s.substring(mid + 1, s.length)
        }
        return Pair<String, String>(firstHalf, secondHalf)
    }

}

fun main() {

    val words = arrayOf("", "a", "ab", "abc", "abcd", "abcdef")
    val o = StringSplitInHalf()
    for (w in words) {
        val splitInHalf = o.splitInHalf(w)
        println("word : $w")
        println("first half ${splitInHalf.first}")
        println("second half ${splitInHalf.second}")
    }

}
package com.example.lib.topics.strings

class LongestPalindromicSubstring {

    fun longestPalindrome(s: String): String {
        var r = ""
        if (!s.isNullOrEmpty()) {

            var start = 0
            var end = 0

            for (i in 0..s.length) {
                var l1 = expandAroundCenter(s, i, i)
                var l2 = expandAroundCenter(s, i, i + 1)

                var len = Math.max(l1, l2)

                if (len > end - start) {
                    start = i - (len - 1) / 2
                    end = i + len / 2
                }

            }
            r = s.substring(start, end + 1)
        }

        return r
    }

    fun expandAroundCenter(s: String, left: Int, right: Int): Int {
        var l = left
        var r = right

        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }

        return r - l - 1
    }

}

fun main() {

    val o = LongestPalindromicSubstring()

//    val s = "caba"
//    val s = "caba"
    val s = "abcabccbaabc"
    val longestPalindrome = o.longestPalindrome(s)
    println(longestPalindrome)
}
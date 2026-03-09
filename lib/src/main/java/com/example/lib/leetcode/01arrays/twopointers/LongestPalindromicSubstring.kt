package com.example.lib.leetcode.`01arrays`.twopointers

class LongestPalindromicSubstring {


    fun longestPalindrome(s: String): String{

        var maxLen = Int.MIN_VALUE
        var start = Int.MIN_VALUE

        fun expand(left: Int, right: Int){

            var l = left ; var r = right

            while( l > 0 && r < s.length && s[l]==s[r] ){

                val len = right - left + 1
                if( len > maxLen ) {
                    maxLen = len
                    start = l
                }

                l--
                r++

            }

        }



        for (i in s.indices){
            expand(i,i)
            expand(i, i+1)
        }

        val result = s.substring(start, start + maxLen)
        return result

    }

    fun longestPalindrome2020(s: String): String {
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
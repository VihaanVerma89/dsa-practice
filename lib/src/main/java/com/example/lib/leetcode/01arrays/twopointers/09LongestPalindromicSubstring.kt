package com.example.lib.leetcode.`01arrays`.twopointers

class LongestPalindromicSubstring {





    /*

Input:

    babad

Output:
    bab
    aba

Logic:

    babad
    l
      m
        r

    ccc
    l
     m
      r
     */

    fun longestPalindrome25Mar26_2(s: String): String {


        var l = 0
        var r = 0
        var len = 0
        var maxLen = Int.MIN_VALUE
        var start = -1

        fun expand(left: Int, right: Int){

            var l = left
            var r = right

            while(l >= 0 && r <= s.lastIndex){

                if( s[l] != s[r]){
                    break
                }

                len = r - l + 1

                if (len > maxLen){
                    start = l
                    maxLen = maxOf(maxLen,len)
                }

                l--
                r++
            }

        }

        for( i in s.indices){
            expand(i,i)
            expand(i,i+1)
        }

        return if(maxLen == Int.MIN_VALUE) "" else s.substring(start,start+maxLen)

    }





    /*

Input:

babad

Output:
bab
aba

Logic:

babad
l
  m
    r

ccc
l
 m
  r


⏺ There are a couple of bugs in your expand-around-center approach:

  Bug 1: start = m is wrong. m is the center, not the left edge of the palindrome. For "racecar" at m=3, the palindrome is
  length 7 but substring(3, 10) is out of bounds.

  Bug 2: Even vs odd start differs. When len2 wins, the start position calculation is different from when len wins, but you
   use the same start = m for both.

  The simplest fix — have expand directly track start using the left pointer:

  class Solution {
      fun longestPalindrome(s: String): String {
          var maxLen = 0
          var start = 0

          fun expand(left: Int, right: Int) {
              var l = left
              var r = right
              while (l >= 0 && r <= s.lastIndex && s[l] == s[r]) {
                  if (r - l + 1 > maxLen) {
                      maxLen = r - l + 1
                      start = l
                  }
                  l--
                  r++
              }
          }

          for (m in s.indices) {
              expand(m, m)       // odd length
              expand(m, m + 1)   // even length
          }

          return s.substring(start, start + maxLen)
      }
  }

  The key change: instead of returning length and trying to reconstruct start from m, just set start = l inside expand —
  that's the actual left boundary of the palindrome.


 */

    fun longestPalindrome25Mar26(s: String): String {

        var l = 0
        var r = 0
        var m = 0

        fun expand(left: Int, right:Int): Int{

            var l = left
            var r = right
            var len = Int.MIN_VALUE
            while (l >=0 && r <= s.lastIndex){
                if(s[l] !=s [r]){
                    return len
                }
                len = r - l +1
                l--
                r++
            }
            return len
        }

        var maxLen = Int.MIN_VALUE
        var start = - 1
        for ( m in s.indices){
            l = m
            r = m
            // expand
            val len = expand(l,r)
            val len2 = expand(l,r+1)
            if( len > maxLen || len2 > maxLen){
                start = m
                maxLen = maxOf(maxLen,len,len2)
            }
        }

        return if(maxLen==Int.MIN_VALUE) "" else s.substring(start,maxLen)

    }


    fun longestPalindrome12thMarch(s: String): String {

        if( s.length < 2) return s

        var start = Int.MIN_VALUE
        var maxLen = Int.MIN_VALUE

        fun expand(left: Int, right: Int){

            var l = left
            var r = right

            while(l > -1 && r < s.length && s[l] == s[r]){

                val len = r - l + 1
                if(len > maxLen){
                    // bigger palindrome found
                    maxLen = len
                    start = l
                }

                l--
                r++
            }

        }


        for( i in s.indices){
            expand(i,i)
            expand(i,i+1)
        }

        return s.substring(start, start + maxLen)

    }

    fun longestPalindrome9thMarch(s: String): String{

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
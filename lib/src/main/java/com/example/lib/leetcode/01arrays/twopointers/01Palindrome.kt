package com.example.lib.leetcode.`01arrays`.twopointers

// https://leetcode.com/problems/valid-palindrome/
class Palindrome {



    fun isPalindrome25Mar26(s: String): Boolean {

        var l = 0
        var r = s.lastIndex

        while( l < r ){

            // move l,r on alpha-numeric
            while(l < r && s[l].isLetterOrDigit().not()) l++
            while( r > l && s[r].isLetterOrDigit().not()) r--

            if(s[l].lowercaseChar() != s[r].lowercaseChar() ) return false
            l++
            r--

        }

        return true
    }

    fun isPalindrome(s: String): Boolean {

        var l = 0
        var r = s.lastIndex


        while ( l < r ) {

            while( l < s.length && s[l].isLetterOrDigit().not()) l++
            while( r > -1 && s[r].isLetterOrDigit().not()) r--

            // all index processed ?
            if( l > s.lastIndex || r < 0 || l > r) return true

            // have l and r on valid alpha num for comparison
            if(s[l].lowercaseChar() != s[r].lowercaseChar() ) return false

            l++
            r--
        }

        return true

    }

    fun isPalindromeSimple(s: String): Boolean {

        var result = true
        var l = 0
        var r = s.length - 1

        while (l < r) {
            if (s.get(r) != s.get(l)) {
                return false
            }
            l++
            r--
        }

        return result
    }
}

fun main() {
    val result = Palindrome().isPalindrome("racecar")
    println(result)
}
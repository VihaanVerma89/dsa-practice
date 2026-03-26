package com.example.lib.leetcode.`01arrays`.twopointers

import jdk.internal.org.jline.utils.Colors.s

class `05isSubsequence` {




    /*

abc
   i
ahbgdc
      j

 */
    fun isSubsequence25Mar26_2(s: String, t: String): Boolean {


        var i = 0
        var j = 0

        while( i< s.length && j < t.length){
            if( s[i] == t[j]){
                i++
            }
            j++
        }

        return if( i == s.length) true else false

    }



    /*

abc
   i
ahbgdc
      j

 */
    /*

    abc
       i
    ahbgdc
          j

     */
    // works but o(n^2
    fun isSubsequence25Mar26(s: String, t: String): Boolean {

        var i = 0
        var j = 0
        var result = true

        while( i < s.length){

            while(j < t.length  && i<s.length){
                if(s[i] == t[j]){
                    i++
                }
                j++
            }

            if(j == t.length && i != s.length) return false

        }

        return result
    }

    fun isSubsequence25Mar2(s: String, t: String): Boolean {

        if(s.isEmpty()) return true

        var l = 0
        var r = 0

        while(r < t.length && l < s.length){

            if(t[r] == s[l]){
                l++
            }

            r++
        }

        return l == s.length
    }

    fun isSubsequence(s: String?, t: String?): Boolean {

        var i = 0
        var j = 0
        if (s != null && t != null) {
            while (i < s.length && j < t.length) {
                if (s[i] == t[j]) {
                    i++
                }
                j++
            }
            return s.length == i
        }
        return false
    }
}
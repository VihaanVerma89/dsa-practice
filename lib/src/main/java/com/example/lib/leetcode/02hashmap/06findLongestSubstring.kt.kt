package com.example.lib.leetcode


class `06findLongestSubstring.kt` {

    /*
    https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/705/hashing/4512/

    Example 1: You are given a string s and an integer k. Find the length of the longest substring that contains at most k distinct characters.
    For example, given s = "eceba" and k = 2, return 3. The longest substring with at most 2 distinct characters is "ece".
     */
    fun findLongestSubString(s: String, k: Int): Int {

        var l = 0
        var maxLen = Int.MIN_VALUE
        val hm = HashMap<Char, Int>()


        for (r in s.indices) {

            val c = s[r]
            hm[c] = hm.getOrDefault(c, 0) + 1

            while (hm.size > k) {

                val lc = s[l]

                hm[lc] = hm[lc]!! - 1

                if (hm[lc] == 0) {

                    hm.remove(lc)
                }

                l++
            }

            // hm.size  <= k

            val len = r - l + 1
            maxLen = maxOf(maxLen, len)

        }

        return maxLen

    }

    fun findLongestSubstringWithKChars(s:String, k: Int): Int{

        var l = 0
        var maxLen = Int.MIN_VALUE
        val hm = HashMap<Char, Int>( )


        for ( r in s.indices ) {

            val c = s[r]

            hm[c] = hm.getOrDefault(c, 0 ) + 1

            while( hm[c]!! > k ){

                val lc = s[l]
                hm[lc] = hm[lc]!! - 1

                l++
            }

            // hm[c] <=k

            val len = r - l + 1
            maxLen = maxOf(maxLen, len)
        }

        return maxLen
    }

}
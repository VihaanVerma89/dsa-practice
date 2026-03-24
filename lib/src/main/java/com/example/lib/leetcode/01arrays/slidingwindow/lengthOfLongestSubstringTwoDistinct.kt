package com.example.lib.leetcode.`01arrays`.slidingwindow

// https://leetcode.com/explore/interview/card/google/59/array-and-strings/3054/
class lengthOfLongestSubstringTwoDistinct {

    /*

  eceba
  l
    r

  e - 2
  c - 1
  b - x invalid

  eceba
   l
    r


  ccaabbb
    l
        r

  */
    fun lengthOfLongestSubstringTwoDistinct(s: String): Int {


        val map = hashMapOf<Char,Int>()
        var l = 0
        var maxLen = Int.MIN_VALUE
        for( r in s.indices){

            val c = s[r]
            map[c] = map.getOrDefault(c,0)+1


            while(map.size >2){
                val lc = s[l]
                map[lc] = map.getOrDefault(lc,1) - 1
                if(map[lc]==0) map.remove(lc)

                l++
            }

            if ( map.size == 2){
                val len = r-l+1
                maxLen = maxOf(maxLen,len)
            }
        }

        return if(maxLen == Int.MIN_VALUE) return s.length else maxLen
    }



}
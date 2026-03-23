package com.example.lib.leetcode.`01arrays`.slidingwindow

/*
https://leetcode.com/explore/interview/card/google/59/array-and-strings/345/
 */

class minWindow {
    /*
    Doesn't solve the problem.

⏺ Take s = "AABBC", t = "ABC".

  - tMap = {A:1, B:1, C:1}

  When your window covers the full string, sMap = {A:2, B:2, C:1}.

  This is a valid window — it contains all chars of t. But tMap == sMap is false because A:2 != A:1 and B:2 != B:1.

  So your code never records this as a valid window and skips it entirely.

     */



    fun minWindow(s:String, t:String): String{

        val tMap = hashMapOf<Char,Int>()
        val sMap = hashMapOf<Char,Int>()


        for( c in t ) {
            tMap[c] = tMap.getOrDefault(c,0)+1
        }


        // Create a sliding window
        var have = 0
        var need = tMap.size
        var minLen = Int.MAX_VALUE
        var l = 0
        var start = 0
        for(r in s.indices ) {
            val c = s[r]

            /*
             * AAABC
             * l
             *     r
             *
             * A - 3
             * B - 1
             * C - 1
             *
             * ABC
             *
             * tMap
             * A - 1
             * B - 1
             * C - 1
             *
             */

            if( tMap.contains(c) ){
                sMap[c]=sMap.getOrDefault(c,0)+1

                if( sMap[c] == tMap[c] ) have++

            }
            else{
                // ignore non matching  c
            }


            // shrink the window
            // when have == need we have a valid window
            // calculate and shrink

            while( need == have ){

                val len = r - l + 1

                if( len < minLen){
                    start = l
                    minLen = minOf(minLen, len)
                }

                val lc = s[l]


                if( lc in sMap){

                    sMap[lc] = sMap.getOrDefault(lc, 1) -1



                    if( sMap[lc]!! < tMap[lc]!! ){
                        have--
                    }

                    val count = sMap[lc]

                    if(count == 0 ){
                        sMap.remove(lc)
                    }

                }

                l++
            }
        }


        return if(minLen == Int.MAX_VALUE) return "" else s.substring(start,start+minLen)

    }



    fun minWindow21Mar26(s: String, t: String): String {

        var minLen = Int.MAX_VALUE
        var start = 0

        val tMap = hashMapOf<Char,Int>()
        for(c in t){
            tMap[c] = tMap.getOrDefault(c,0)+1
        }

        val sMap = hashMapOf<Char,Int>()
        var l = 0

        for( r in s.indices){

            val c = s[r]

            if(tMap.contains(c)){
                sMap[c] = sMap.getOrDefault(c,0)+1
            }

            var rc = s[l]
            while(tMap.contains(rc).not()  || tMap == sMap){
                if( tMap == sMap){
                    if(r-l+1 < minLen){
                        minLen = minOf(minLen, r-l+1)
                        start = l
                    }
                    sMap[rc] = sMap.getOrDefault(rc,1) - 1
                    if(sMap[rc]==0){
                        sMap.remove(rc)
                    }
                }
                l++
                rc = s[l]
            }
        }

        return s.substring(start,start+minLen).ifEmpty{""}

    }

}
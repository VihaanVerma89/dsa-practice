import java.util.Stack

class Solution {
    
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
        }

            // shrink the window
            // when have == need we have a valid window
            // calculate and shrink

            when( need == have ){

                val len = r - l + 1

                if( len < minLen){
                    start = l 
                    minLen = minOf(minLen, len)
                }

                val lc = s[l]

               
                if( lc in sMap){

                    sMap[lc]--

                    val count = sMap[lc]
                    if(lc == 0 ){
                        sMap.remove(lc)
                    }

                    if( sMap[lc] < tMap[lc] ){
                        have--
                    }

                }

                l++
            }


            return if(minLen == Int.MAX_VALUE) return "" else s.substring(start,start+minLen)

        }
}




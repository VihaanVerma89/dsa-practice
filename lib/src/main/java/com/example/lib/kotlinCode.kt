import java.util.Stack

class Solution {


    /*
     *
     * k = 8 
     *
     * 3,1,2,7,4,2,1,1,5
     * 
     *
     */

    fun findLength( nums: IntArray, k: Int ) : Int {


        var r = 0 
        var l = 0 
        var curSum = 0 
        var maxLen = Int.MIN_VALUE

        while( r < nums.size ) {


            curSum += nums[ r ] 

            while( curSum > k ) {

                curSum -= nums[ l ]
                l++

            }

            // sum < k

            maxLen = maxOf( maxLen, r - l + 1 )

            r++
        }

        return maxLen

    }


}

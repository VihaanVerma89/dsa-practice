import java.util.Stack

class Solution {

    fun subarraySum( nums: IntArray, k: Int): Int{

        var l = 0
        var r = 0 
        var count = 0 

        val sum = IntArray(nums.size)

        sum[0] = nums[0]

        // create sum array
        for( r in 1 until nums.size){
            sum[r] = sum[r-1] + nums[r]
        }

        for( r in 0 until nums.size){


            while( sum[r] - sum[l] > k ) {
                l++
            }

            if ( sum[r] - sum[l] ==k ) {
                count += r - l + 1
            }

        }

        return count


    }
}


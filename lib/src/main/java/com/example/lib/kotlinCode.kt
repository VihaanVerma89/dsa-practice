import java.util.Stack

class Solution {


    for( r in nums.indices ) {

        if( nums[r] == 0 ){

            // no swap


        }
        else if( nums[r] != 0 ){

            // swap
            nums[l] = nums[r].also{ nums[r] = nums[l] }
            l++

        }


    }


}



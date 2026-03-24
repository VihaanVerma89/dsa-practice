import java.util.Stack

class Solution {
    

    fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<List<Int>> {


        val ansList = mutableListOf<List<Int>>()

        if( nums.isEmpty()){
            ansList.add(listOf(lower,upper))
            return ansList
        }



        var d = 0 

        if(abs(lower - nums[0])> 1){

            ansList.add(listOf(lower,nums[0]-1)
        }

        // for( (i,v) in nums.withIndex()){
        for( i in 1 .. nums.lastIndex )

            d = abs(nums[i]-nums[i-1])

            if(d > 1){
                // gap exists
                ansList.add(listOf(nums[i-1]+1, nums[i]-1])
            }
        }


        if( abs(upper-nums[nums.lastIndex])> 1){

            ansList.add(nums[nums.lastIndex]+1, upper)

        }

        return ansList

    }
}




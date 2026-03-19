package com.example.lib.leetcode.`01arrays`


/*

https://leetcode.com/problems/3sum/

Notes on the problem
- array has mix of positive and negative numbers.
- to get a sum of 0  we can use l , r on a sorted array to find indexes faster
- One index remains constant and l,r are checked for sum becoming zero
 */




/*


duplicate i values

[-1,0,1,2,-1,-4]

-4,-1,-1,0,1,2
    i
         l r
    -1   0 1  = 0

-4,-1,-1,0,1,2
       i
         l r
         - 1 0 1 = 0



0,0,0,0
i
  l   r
  0 + 0 + 0 = 0

0,0,0,0
i
    lr


-1 0 1 2 -1 -4

-4 -1 -1 0 1 2
    i
       l     r
    -1  0 1 = 0


 */
fun threeSum18Mar26(nums: IntArray): List<List<Int>> {

    nums.sort()
    val ansList = mutableListOf<List<Int>>()

    for( i in 0 .. nums.size - 2 ){

        if( i>0 && nums[i] == nums[i-1]){
            //duplicate
            continue
        }

        var l = i + 1
        var r = nums.lastIndex

        while( l < r ){


            val sum = nums[i] + nums[l] + nums[r]

            when{

                sum == 0 -> {
                    // indexes found
                    ansList.add(listOf(nums[i], nums[l], nums[r]))

                    // check for duplicate values of l , r
                    while(l < r  && nums[l]==nums[l-1] && l-1 >i) l++
                    while(r > l && nums[r-1] == nums[r] && r-1 < r) r--
                    l++
                    r-- ˝
                }
                sum < 0 -> {
                    l++
                }
                sum > 0 -> {
                    r--
                }
            }
        }

    }

    return ansList

}

fun threeSum13Mar26(nums: IntArray): List<List<Int>> {

    nums.sort()
    val result = mutableListOf<List<Int>>()

    for ( i in 0 until nums.size-2){

        if( i> 0 && nums[i] == nums[i-1]){
            // duplicate i value. Skip
            continue
        }

        var l = i+1
        var r = nums.lastIndex

        while ( l < r ){

            val sum = nums[i] + nums[l] + nums[r]

            when{

                sum == 0 -> {
                    result.add(listOf(nums[i], nums[l], nums[r]))
                    while( l < r && nums[l] == nums[l+1])l++
                    while( r > l && nums[r-1] == nums[r])r--
                    l++
                    r--
                }

                sum < 0 -> {
                    l++
                }

                sum > 0 ->{
                    r--
                }
            }
        }

    }
    return result
}

fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()

    val res = arrayListOf<ArrayList<Int>>()
    for (i in 0..nums.size) {
        if (i == 0 || nums[i] != nums[i - 1]) {
            twoSumII(nums, i, res)
        }
    }
    return res
}

fun twoSumII(nums: IntArray, i: Int, res: ArrayList<ArrayList<Int>>) {
    var lo = i + 1
    var hi = nums.size - 1
    while (lo < hi) {

        val sum = nums[i] + nums[lo] + nums[hi]
        if (sum < 0) {
            lo++
        } else if (sum > 0) {
            hi++
        } else {
            val arrayListOf = arrayListOf(nums[i], nums[lo], nums[hi])
            res.add(arrayListOf)
        }
    }

}

fun main() {

}

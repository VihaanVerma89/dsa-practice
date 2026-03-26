package com.example.lib.leetcode.`01arrays`.twopointers


/*

https://leetcode.com/problems/3sum/

Notes on the problem
- array has mix of positive and negative numbers.
- to get a sum of 0  we can use l , r on a sorted array to find indexes faster
- One index remains constant and l,r are checked for sum becoming zero


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


/*


  Bug 1: Missing i duplicate skip. The outer loop doesn't skip duplicate values of nums[i], producing duplicate triplets.

  Example: [0,0,0,0] → [[0,0,0], [0,0,0]] instead of [[0,0,0]]

  Bug 2: j/k skip happens before j++/k--. When j == i+1, the check nums[j] == nums[j-1] compares against nums[i], not the previously-used j value. This over-skips and misses
  valid triplets.

  Example: [-1,-1,-1,0,1,2] → misses [-1,0,1]

  Fix — move j++/k-- before the skip loops, and add the i skip:

  for (i in nums.indices) {
      if (i > 0 && nums[i] == nums[i - 1]) continue  // fix #1

      j = i + 1
      k = nums.lastIndex

      while (j < k) {
          val sum = nums[i] + nums[j] + nums[k]
          if (sum == 0) {
              ans.add(listOf(nums[i], nums[j], nums[k]))
              j++                                        // fix #2: increment first
              k--
              while (j < k && nums[j] == nums[j - 1]) j++
              while (k > j && nums[k] == nums[k + 1]) k--
          } else if (sum > 0) {
              k--
          } else {
              j++
          }
      }
  }

 */
fun threeSum25Mar26(nums: IntArray): List<List<Int>> {

    nums.sort()
    var j = 0
    var k = 0

    val ans = mutableListOf<List<Int>>()

    for( i in 0 until  nums.size -2){

        j = i+1
        k = nums.lastIndex

        while ( j < k ){

            val sum = nums[i]+nums[j]+nums[k]

            if( sum == 0 ){
                ans.add(listOf(nums[i], nums[j], nums[k]))
                while(j<k && nums[j]==nums[j-1])j++
                while(k>j && nums[k]==nums[k-1])k--
                j++
                k--
            }
            else if( sum > 0){
                k--
            }
            else if ( sum < 0 )
            {
                j++
            }
        }

    }

    return ans
}

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

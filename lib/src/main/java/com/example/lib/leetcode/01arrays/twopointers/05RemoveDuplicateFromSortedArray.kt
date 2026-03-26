package com.example.lib.leetcode.`01arrays`.twopointers


// https://leetcode.com/problems/remove-duplicates-from-sorted-array/


/*
0,0,1,1,1,2,2,3,3,4
l
    r
0,1,0,1,1,2
  l
          r
0,1,2,1,1,0,2,3
      l
              r
 */
fun removeDuplicates25Mar26(nums: IntArray): Int {

    var l = 0
    var r = 0

    for(r in nums.indices){

        if(nums[l]!=nums[r])
        {
            l++
            nums[l] = nums[r].also{ nums[r] = nums[l]}
        }

    }
    return l+1
}

fun removeDuplicatesSol(nums: IntArray): Int {

    var i = 0
    if (nums.size > 1) {
        var j = 0
        while (j != nums.size) {
            if (nums[i] == nums[j]) {
                j++
            } else {
                i++
                swap(nums, i, j)
                j++
            }
        }
        if (i >= 0) {
            i++
        }
    } else {
        i = 1
    }

    return i
}


/*
* https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/
* */
fun removeDuplicates19thFeb23(nums: IntArray): Int {
    var i = 0
    var j = 0
    var u = 1

    while (j != nums.size) {
        if (nums[i] == nums[j]) {
            // duplicate
            j++
        } else {
            // not duplicate
            i++
            u++
            nums[i] = nums[j]
        }
    }
    return u
}


/*

[0,0,1,1,1,2,2,3,3,4]

[0,,1,1,1,2,2,3,3,4]

*/
fun removeDuplicates(nums: IntArray): Int {
    var k = 1
    var j = 1

    var lastSeen = nums[0]
    for (i in 1..nums.lastIndex) {
        val num = nums[i]
        if (num == lastSeen) {
            // same number

        } else {
            // new number
            nums[j] = num
            j++
            lastSeen = num
            k++
        }
    }

    return k
}

fun swap(nums: IntArray, to: Int, from: Int) {
    val temp = nums[to]
    nums[to] = nums[from]
    nums[from] = temp
}

fun main() {

}

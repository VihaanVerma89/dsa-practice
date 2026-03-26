package com.example.lib.leetcode.`01arrays`.twopointers

class RemoveElement {
//    https://leetcode.com/problems/remove-element/


    /*

3,2,2,3 val = 3

2,2,_,_

3,2,2,3
l
  r
2,3,2,3
  l
    r
2,2,3,3
    l
      r

swap l,r when r is at val
 */
    fun removeElement25Mar26(nums: IntArray, `val`: Int): Int {

        var l = 0
        val value = `val`
        for( r in nums.indices){

            if(nums[r]!=value){
                nums[l] = nums[r].also{nums[r]=nums[l]}
                l++
            }
        }

        return l
    }

    fun removeElement(nums: IntArray, `val`: Int): Int {

        var l = 0
        var value = `val`

        for( r in nums.indices ){

            if( nums[r] == value )
            {
                // this value needs to be moved ahead
                // assume l is pointing to it
            }
            else if( nums[r] != value ){

                // swap needs to happen
                nums[l] = nums[r].also{ nums[r] = nums[l]}
                l++
            }
        }


        return l
    }

    fun removeElement1(nums: IntArray, value: Int): Int {
        var i = 0
        var j = nums.lastIndex
        var swap = 0


        while (i <= nums.lastIndex && i <= j) {
            val currentValue = nums[i]
            if (currentValue == value) {
                // match
                if (i == j) {
                    nums[i] = -1
                } else {
                    val t = nums[j]
                    nums[j] = currentValue
                    nums[i] = t
                }
                j--
                swap++
            } else {
                // not a match
                i++
            }
        }
        val unique = nums.size - swap
        return unique
    }
}

fun main() {
    val c = RemoveElement()
    val nums = intArrayOf()
    val value = 2
    c.removeElement(nums, value)
    println(nums)
}

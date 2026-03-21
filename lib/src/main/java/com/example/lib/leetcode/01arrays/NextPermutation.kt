package com.example.lib.leetcode.`01arrays`

/*  https://leetcode.com/explore/interview/card/google/59/array-and-strings/3050/
Note:
- this problem is difficult
 */


fun nextPermutation20Mar26(nums: IntArray): Unit {

    var r = nums.lastIndex
    var sFound = falsar
    var l = 0


    while( !sFound && r>0 ){

        if(nums[r-1] < nums[r]){
            sFound = true
            l = r-1
        }

        r--
    }

    if(sFound){
        // swap and reverse
        r = nums.lastIndex

        while ( l < r){
            if(nums[r] > nums[l]){
                nums[l] = nums[r].also{nums[r]=nums[l]}

                l++
                r = nums.lastIndex
                // l .. r need to be reversed
                while( l < r){
                    nums[l] = nums[r].also{nums[r]=nums[l]}
                    l++
                    r--
                }

            }
            r--
        }
    }
    else{
        nums.reversed()
    }

}

fun nextPermutation30May20(nums: IntArray): Unit {

    var i = nums.size - 2
    while (i >= 0 && nums[i + 1] <= nums[i]) {
        i--
    }

    if (i >= 0) {
        var j = nums.size - 1

        while (j >= 0 && nums[j] <= nums[i]) {
            j--
        }

    }


}


fun main() {

}
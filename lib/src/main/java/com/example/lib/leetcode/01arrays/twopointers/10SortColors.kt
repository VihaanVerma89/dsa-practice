package com.example.lib.leetcode.`01arrays`.twopointers

// https://leetcode.com/problems/sort-colors/
class `10SortColors` {



    /*

    Was able to solve but not smoothly.
     */
    fun sortColors25Mar26(nums: IntArray){


        var l = 0
        var r = nums.lastIndex
        var i = 0

        while( i <= r){

            if(nums[i]==0){
                //move to left
                nums[l] = nums[i].also{nums[i]=nums[l]}
                l++
                i++
            }
            else if(nums[i]==2){
                // move to right
                nums[r] = nums[i].also{nums[i]=nums[r]}
                r--
            }
            else if(nums[i]==1){
                // ?
                i++
            }
        }


    }

    fun sortColors13Mar26(nums: IntArray){
        var l = 0
        var r = nums.lastIndex
        var i = 0
        while( i <= r ){

            if ( nums[i] == 0 ){
                // move to start
                nums[l] = nums[i].also{ nums[i] = nums[l] }
                l++
                i++
            }
            else if (nums[i] == 1){
                i++
            }
            else if ( nums[i] == 2){
                // move to end
                nums[r] = nums[i].also{ nums[i] = nums[r] }
                r--
            }

        }
    }

    fun sortColors10Mar26(nums: IntArray) {
        var low = 0        // boundary for 0s
        var mid = 0        // current element
        var high = nums.lastIndex  // boundary for 2s

        while (mid <= high) {
            when (nums[mid]) {
                0 -> {
                    nums[low] = nums[mid].also { nums[mid] = nums[low] }
                    low++; mid++
                }
                1 -> mid++
                2 -> {
                    nums[mid] = nums[high].also { nums[high] = nums[mid] }
                    high--
                    // don't advance mid — swapped value needs inspection
                }
            }
        }
    }


}
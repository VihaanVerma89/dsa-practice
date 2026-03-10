package com.example.lib.leetcode.`01arrays`.twopointers

// https://leetcode.com/problems/sort-colors/
class SortColors {


    fun sortColors(nums: IntArray) {
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
package com.example.lib.geeksforgeeks.arrays

class SearchinRotatedSortedArray {

    fun findMin2(nums: IntArray): Int {
        var min = Int.MAX_VALUE
        if (nums.isEmpty()) {

        } else if (nums.size == 1) {
            return nums[0]
        } else if (nums.isNotEmpty()) {
            var lo = 0
            var hi = nums.size - 1

            if (nums[hi] > nums[0]) {
                return nums[0]
            }

            while (lo <= hi) {
                val mid = (lo + hi) / 2

                // high -> low
                if (nums[mid] > nums[mid + 1]) {
                    return nums[mid + 1]
                }

                // low -> high
                if (nums[mid - 1] > nums[mid]) {
                    return nums[mid]
                }

                val f = nums[lo]
                val l = nums[hi]

                if (f < nums[mid]) {
                    // left is sorted array and right is not
                    lo = mid + 1
                } else if (f > nums[mid]) {
                    // right is unsorted array and left is sorted
                    hi = mid - 1
                }

            }
        }
        return min
    }

    fun findMin1(nums: IntArray): Int {
        var min = -1
        if (nums.isEmpty()) {
            min = -1
        } else if (nums.size == 1) {
            min = nums[0]
        }
        if (nums.size > 1) {
            var lo = 0
            var hi = nums.size - 1
            var mid = 0
            while (lo <= hi) {
                mid = (lo + hi) / 2
                val f = nums[lo]
                val l = nums[hi]

                if (nums[mid + 1] < nums[mid]) {
                    return nums[mid + 1]
                }

                if (f > l) {
                    lo = mid + 1
                } else {
                    hi = mid - 1
                }
            }
        }
        return min
    }
}

fun main() {
    val o = SearchinRotatedSortedArray()
    val a = intArrayOf(1, 2)
    o.findMin(a)
}

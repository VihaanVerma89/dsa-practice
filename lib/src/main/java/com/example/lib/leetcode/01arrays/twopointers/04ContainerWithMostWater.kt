package com.example.lib.leetcode.`01arrays`.twopointers


class ContainerWithMostWater {


    fun  maxArea25Mar26(height: IntArray): Int {

        var l = 0
        var r = height.lastIndex

        var maxArea = Int.MIN_VALUE
        var area = 0

        while ( l < r ){
            val w = r - l
            area =  w * minOf(height[l] , height[r])

            if(height[l]< height[r])
            {
                l++
            }
            else if(height[l] >= height[r]){
                r--
            }
            maxArea = maxOf(maxArea,area)
        }

        return maxArea

    }

    // 5th oct , 2020
    fun maxArea5Oct20(a: IntArray): Int {
        var l = 0
        var r = a.size - 1
        var maxA = 0
        while (l < r) {
            val ca = (r - l) * Math.min(a[l], a[r])
            maxA = Math.max(maxA, ca)

            if (a[l] < a[r]) {
                l++
            } else {
                r--
            }

        }
        return maxA
    }

    fun maxArea24May20(height: IntArray): Int {

        var maxArea = 0
        var l = 0
        var r = height.size - 1

        while (l < r) {

            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++
            } else {
                r--
            }
        }
        return maxArea
    }

}

fun main() {

}
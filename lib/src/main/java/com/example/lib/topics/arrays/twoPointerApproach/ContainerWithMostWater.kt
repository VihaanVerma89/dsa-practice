package com.example.lib.topics.arrays.twoPointerApproach

import kotlin.math.max


class ContainerWithMostWater {

    // 5th oct , 2020
    fun maxArea(a: IntArray): Int {
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

    fun maxArea1(height: IntArray): Int {

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
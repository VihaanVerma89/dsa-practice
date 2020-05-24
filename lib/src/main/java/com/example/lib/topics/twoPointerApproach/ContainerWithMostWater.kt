package com.example.lib.topics.twoPointerApproach

import kotlin.math.max


fun maxArea(height: IntArray): Int {
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


fun main() {

}
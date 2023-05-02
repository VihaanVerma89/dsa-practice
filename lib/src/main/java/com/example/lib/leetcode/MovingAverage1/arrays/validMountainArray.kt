package com.example.lib.leetcode.MovingAverage1.arrays

class validMountainArray {

    fun validMountainArray(arr: IntArray): Boolean {
        var mountain = false

        if (arr.size < 3) {
            // not a mountain
        } else {
            // may be a mountain
            var i = 0
            var j = 0
            var peakReached = false
            mountain = true
            while (i < arr.size) {
                if (peakReached) {
                    if (arr[i] > arr[i + 1]) {
                        // downwards
                    } else if (arr[i] <= arr[i + 1]) {
                        mountain = false
                        break
                    }
                } else {
                    if (arr[i] < arr[i + 1]) {
                        // mostly mountain
                    } else if (arr[i] == arr[i + 1]) {
                        mountain = false
                        break
                    } else if (arr[i] > arr[i + 1]) {
                        // may be peak
                        peakReached = true
                    }
                }

                i++
            }
        }


        return mountain
    }
}


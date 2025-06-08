package com.example.lib.leetcode.`01arrays`

class plusOne {

    fun plusOne(digits: IntArray): IntArray {

        var i = digits.lastIndex

        var shiftRequired = true

        while (shiftRequired && i >= 0) {
            if (digits[i] + 1 == 10) {
                digits[i] = 0
                i--
            } else {
                digits[i] += 1
                shiftRequired = false
            }


        }

        // need new array and shifting
        if (i < 0 && shiftRequired) {
            val newArray = IntArray(digits.size + 1)
            var j = digits.lastIndex

            while (j != 0) {
                newArray[j] = digits[j]
                j--
            }

            newArray[j] = 1
            return newArray
        }

        return digits
    }

}

fun main() {

}


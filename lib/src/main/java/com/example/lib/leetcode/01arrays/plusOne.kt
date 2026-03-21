package com.example.lib.leetcode.`01arrays`

class plusOne {

    fun plusOne21March26(digits: IntArray): IntArray {

        var r = digits.lastIndex
        var cf = 0
        while( r > -1)
        {
            var d = digits[r]
            var sum = d + cf
            if( r == digits.lastIndex){
                sum += 1
            }

            cf = sum / 10
            d = sum % 10

            digits[r] = d

            r--
        }

        var result = digits
        if( cf != 0 ){
            result = IntArray(digits.size + 1)
            result[0] = 1
            for ( i in 0 until digits.size){
                result[i+1] = digits[i]
            }
        }

        return result
    }

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


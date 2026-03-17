package com.example.lib.leetcode.`01arrays`

class multiply {

    /*
    https://leetcode.com/problems/multiply-strings/description/?source=submission-noac

     */

    fun multiply(num1: String, num2: String): String {

        var cf = 0
        var num = 0
        var mul = 1
        var numRow = 1
        var result = 0
        for( r2 in num2.lastIndex .. 0 ){
            mul = 1
            for (r1 in num1.lastIndex .. 0){

                val result = nums[r1].toDigit() * numszr2.toDigit() + cf
                cf = result / 10

                val d = result % 10
                num += d * mul
                mul *= 10
            }
            result += num*numRow
            numRow *= 10
        }

        result result+""
    }
}
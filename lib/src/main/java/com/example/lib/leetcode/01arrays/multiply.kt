package com.example.lib.leetcode.`01arrays`

class multiply {

    /*
    https://leetcode.com/problems/multiply-strings/description/?source=submission-noac

     */


    /*
    - This solution works but you can't get it in first attempt
    - Important things to remember
    1. The product of two number can be stored in IntArray(num1.len + num2.len)
    2. Since we can store the result in array by adding single digits we can avoid the buffer-overflow problem with primtive types
    3. since the index start from end we can use i + j + 1 and store the results in IntArray
    4. i+j+1 points to result , i+j points to carry forward
    5. Carry forward can erase values of index and must be added to the index


    ⏺ Let's trace with num1 = "123", num2 = "456" and see where = breaks vs +=.

  The problem shows up at i=1, j=1:

  After j=2 row is done:
  result = [0, 0, 0, 7, 3, 8]

  i=1, j=2 → 3×5=15  sum=15+result[4]=18
    result[4] = 8
    result[3] += 1  →  7 + 1 = 8  ✓  (with +=)
    result[3] =  1  →  overwrites 7  ✗  (with =)

  With =: result becomes [0, 0, 0, 1, 8, 8] — the 7 from 123 × 6 is gone.

  With +=: result becomes [0, 0, 0, 8, 8, 8] — the carry 1 is added to the existing 7.

  In short: = erases the work done by previous iterations. += preserves it and adds the new carry on top.

     */
    fun multiply18thMarch26(num1: String, num2: String): String {

        if ( num1 =="0" || num2 =="0") return "0"

        val result = IntArray(num1.length + num2.length)

        for( i in num2.lastIndex downTo 0 ){
            for( j in num1.lastIndex downTo 0 ){

                val mul = num1[j].digitToInt() * num2[i].digitToInt()
                val cf = result[i+j+1]
                val sum = mul + cf
                result[i+j+1] = sum % 10
                result[i+j] += sum / 10
            }
        }

        return result.joinToString("").trimStart('0').ifEmpty{"0"}
    }

    // Not correct. Has buffer overflow problem
    fun multiply16Mar26(num1: String, num2: String): String {

        // if ( num1 == 0 || num2 == 0 ) return 0

        var num = 0
        var cf = 0
        var mul = 1
        var numsArray = IntArray(num1.length + num2.length)
        var i = 0

        for (n2 in num2.lastIndex downTo 0) {

            mul = 1
            cf = 0
            num = 0
            for (n1 in num1.lastIndex downTo 0) {

                var p = num1[n1].digitToInt() * num2[n2].digitToInt()
                p += cf


                if (n1 == 0) {
                    // there are no carry forward
                    p = p * mul
                    num += p
                } else {
                    var d = p % 10
                    d = d * mul
                    mul *= 10
                    num += d
                    cf = p / 10
                }

            }

            numsArray[i] = num
            i++

        }

        // sum the final result
        var result = 0
        mul = 1
        for (j in 0 until i) {
            result += numsArray[j] * mul
            mul *= 10
        }

        return result.toString()

    }


    // This is what I wrote in first attempt. It' not working.
    fun multilpy16Mar26(num1: String, num2: String): String {

        var cf = 0
        var num = 0
        var mul = 1
        var numRow = 1
        var result = 0
        for (r2 in num2.lastIndex downTo 0) {
            mul = 1
            cf = 0
            for (r1 in num1.lastIndex downTo 0) {

                val prod = num1[r1].digitToInt() * num2[r2].digitToInt() + cf
                cf = prod / 10

                val d = prod % 10
                num += d * mul
                mul *= 10
            }


            result += num * numRow
            numRow *= 10
            num = 0
        }

        return result
    }
}
package com.example.lib.leetcode.`01arrays`

// https://leetcode.com/explore/interview/card/google/59/array-and-strings/471/
class nextClosestTime {


    /*
    Got this solution from claude code.
     */
    fun nextClosestTime(time: String): String {

        val digits = setOf(time[0], time[1], time[3],time[4])
        val curMins = time.substring(0,2).toInt()*60 + time.substring(3,5).toInt()

        val totalMins = 24 * 60
        for(i in 1..totalMins){

            val nxt = (curMins+i) % totalMins
            val h = nxt / 60
            val m = nxt % 60

            val result = "%02d:%02d".format(h,m)

            var match = true
            for( c in result){
                if ( c in digits || c ==':' ){
                    continue
                }
                else{
                    match = false
                    break
                }
            }

            if (match) return result
        }

        return time
    }

    /*
    - Wrote this in the first attempt
   - I got the logic almost right but couldn't finish the code in 45 mins
   - Also there needs to be a better way to get the next day time :/

   Logic :
    19:34 -> 1,9,3,4 -> 1 3 4 9
    __ __

    h 0 to 24
    m 0 to 59

    carry forward at 60

    1 9 3 4
    _ _ _ _

          9

    1 9 3 9
    _ _ _ _
        4

    1 9 5 9
    _ _ _ _

    1 1 1 1 // move to text day



    m1 - 0 to 5
    m2 - 0 to 9

    h1 - 0 , 1, 2
    h2 - 0 to 9

    h1 = 0          1           2
    h2 = 0 to 9     0 to 9      0 to 3
    */
    fun nextClosestTime24Mar26Wrong(time: String): String {


        // check if you can find next time in current day
        val h1 = time[0].digitToInt()
        val h2 = time[1].digitToInt()
        val m1 = time[3].digitToInt()
        val m2 = time[4].digitToInt()

        val timeList = listOf(h1, h2, m1, m2)

        /*

        _ _ : _ _
        0 1 2 3 4
        */
        var temp = 0
        val sortedDigits = listOf(h1, h2, m1, m2).sorted()

        fun getNextGreaterNumber(n: Int, sortedDigits: IntArray) {
            var result = -1
            for (i in sortedDigits) {
                if (i > n) return i
            }
            return result
        }

        for (r in time.lastIndex downTo 0) {


            if (r == 4) { // m2 0..9 possible
                temp = timeList[3]
                // can we increase to next number ?
                val result = getNextGreaterNumber(temp, sortedDigits)
                if (result != -1) {
                    time[r] = result
                    return result
                }
            } else if (r == 3) { // m1 0..5 possible
                temp = timeList[2]
                val result = getNextGreaterNumber(temp, sortedDigits)
                if (result in 0..5) {
                    time[r] = result
                    return result
                }
            } else if (r == 1) { // h2 0 .. 9 possible if h1 is 0 or 1
                // if h1 is 2 then 0 .. 3 possible
                temp = timeList[1] // h2
                val h1 = timeList[0]
                if (h1 in 0..1) {
                    // h2 0 .. 9 possible
                    val result = getNextGreaterNumber(temp, sortedDigits)
                    if (result != -1) {
                        time[r] = result
                        return result
                    }
                } else if (h1 in 0..2) {
                    // h2 only 0 .. 3
                    val result = getNextGreaterNumber(temp, sortedDigits)
                    if (result in 0..3) {
                        time[r] = result
                        return result
                    }
                }
            } else if (r == 0) {
                // we have reached h1
                temp = timeList[0]
                val result = getNextGreaterNumber(temp, sortedDigits)
                if (result in 0..2) {
                    time[0] = result
                    return result
                }
            }


        }


        // if we reach here then we need to move to next day time


        // move the time ahead in next day
        /*
         _ _ : _ _
         h1 = minOf(0,1,2)
         h2 = depends on h1


         _ _ _ _
         00:00
         0,1,2

        */

        // can we put 0 , 1 , 2 in h1 ?
        var result = "00:00"
        if (sortedDigits.contains(0)) {
            result[0] = '0'
        } else if (sortedDigits.contains('1')) {
            result[0] = '1'

        } else if (sortedDigits.contains('2')) {
            result[0] = '2'
        } else {
            result[0] = '?'
        }

        if (result[0] == '0' || result['0'] == 1) {
            // h2 can be in 0 .. 9
            result[1] = sortedDigits[0]
        } else if (result[0] == '2') {
            // h2 can be in 0 .. 3

        }


    }
}
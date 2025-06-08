package com.example.lib.leetcode.`01arrays`

class SquaresOfASortedArray {


    fun sortedSquares(nums: IntArray): IntArray {

        var l = 0
        var r = nums.size - 1

        var pos = r
        val result = IntArray(nums.size){0}

        while( l<=r ){

            val ls = nums[l] * nums[l]
            val rs = nums[r] * nums[r]

            if( ls <= rs ){
                result[pos] = rs
                r--
            }else{
                result[pos] = ls
                l++
            }

            pos--
        }

        return result
    }

    fun sortedSquares4(nums: IntArray): IntArray {

        var i = 0
        var j = nums.size - 1
        var k = j

        var ansArray = IntArray(nums.size)

        while (i <= j) {

            val i2 = nums[i] * nums[i]
            val j2 = nums[j] * nums[j]

            if (i2 <= j2) {
                ansArray[k--] = j2
                j--
            } else if (i2 > j2) {
                ansArray[k--] = i2
                i++
            }
        }
        return ansArray
    }

    // This is very bad quality code I have written to cover different cases
    // I didn't see that pattern that biggest number will be on the array edge and two pointers can work well.
    // it still doesn't work and needs more handling :/
    fun sortedSquares3(nums: IntArray): IntArray {

        if (nums.size == 1) {
            return intArrayOf(nums[0] * nums[0])
        }

        var i = 0
        var j = 0
        var posValueFound = false
        var resultArray = IntArray(nums.size)
        var k = 0

        val hashSet = hashSetOf<Int>()
        val firstNumber = nums[0]
        if (firstNumber < 0) {
            // negative values are present
            while (i < nums.size) {

                // find pos value
                if (!posValueFound && nums[i] >= 0) {
                    posValueFound = true
                    j = i - 1
                }

                if (hashSet.contains(i).not()) {
                    nums[i] = nums[i] * nums[i]
                    hashSet.add(i)
                }


                // merging ongoing
                if (posValueFound && j >= 0) {
                    if (nums[j] > nums[i]) {
                        resultArray[k++] = nums[i]
                        i++
                    } else if (nums[j] <= nums[i]) {
                        resultArray[k++] = nums[j]
                        j--
                    }
                } else if (j < 0) {
                    // merging is done
                    resultArray[k++] = nums[i]
                    i++
                } else {
                    // merging not yet started
                    i++
                }

            }

            if (posValueFound == false) {
                // all values were negative. Damn !
                j = nums.size - 1
                i = 0
                while (i < nums.size) {
                    resultArray[i++] = nums[j--]
                }
            }

        } else {
            // no negative values exists
            while (i < nums.size) {
                nums[i] = nums[i] * nums[i]
                resultArray[i] = nums[i]
                i++
            }
        }

        return resultArray
    }

    fun sortedSquares2(nums: IntArray): IntArray {
        if (nums.isNotEmpty()) {
            if (nums.size == 1) {
                nums[0] = nums[0] * nums[0]
                return nums
            } else {
                var s = 0
                var e = nums.size - 1

                var result = IntArray(nums.size)
                var i = nums.size - 1
                while (i >= 0) {
                    val s2 = nums[s] * nums[s]
                    val e2 = nums[e] * nums[e]
                    if (s2 > e2) {
                        result[i] = s2
                        s++
                    } else if (s2 == e2) {
                        result[i] = s2
                        s++
                    } else if (s2 < e2) {
                        result[i] = e2
                        e--
                    } else {
                        // not possible
                    }
                    i--
                }
                return result
            }
        }
        return nums
    }

    fun sortedSquares1(nums: IntArray): IntArray {

        var i = 0
        var j = nums.size - 1
        val ansArray = IntArray(nums.size)
        if (nums.isNotEmpty()) {
            var ai = ansArray.size - 1

            while (ai >= 0) {
                val ie = nums[i]
                val ie2 = ie * ie
                val je = nums[j]
                val je2 = je * je
                if (ie2 < je2) {
                    ansArray[ai] = je2
                    j--
                } else if (ie2 == je2) {
                    ansArray[ai] = je2
                    j--
                } else if (ie2 > je2) {
                    ansArray[ai] = ie2
                    i++
                }
                ai--
            }
        }
        return ansArray
    }


}

fun main() {
    val s = SquaresOfASortedArray()
    val result = s.sortedSquares(intArrayOf(-4, -1, 0, 3, 10))
    println(result)

}
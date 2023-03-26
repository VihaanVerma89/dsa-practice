package com.example.lib.topics.strings

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
class ReverseInt {

    fun reverse(x: Int): Int {

        var modResult = 0
        var reverseInt = 0
        var number = x
        val max = Integer.MAX_VALUE
        val min = Integer.MIN_VALUE

        while (number != 0) {
            modResult = number % 10
            if (reverseInt > max / 10 || reverseInt == max / 10 && modResult > 7) {
                return 0
            } else if (reverseInt < min / 10 || reverseInt == min / 10 && modResult < -8) {
                return 0
            }
            reverseInt = reverseInt * 10 + modResult
            number /= 10
        }

        return reverseInt
    }

}


fun main() {
    val obj = ReverseInt()
    val input = 123
    val reverse = obj.reverse(input)
    println(reverse)
}

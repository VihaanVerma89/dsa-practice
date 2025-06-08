package com.example.lib.leetcode.`01arrays`.slidingwindow

// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
class countGoodSubstrings {

    // input "aababcabc"
    fun countGoodSubstrings(s: String): Int {
        var count = 0

        var i = 0
        var j = 0
        var nextChar: Char
        var hset = hashSetOf<Char>()

        while (i < s.length - 2) {

            nextChar = s.get(j)


            if (hset.contains(nextChar)) {
                // duplicate
                i++
                j = i
                hset.clear()
            } else {
                // not duplicate
                hset.add(nextChar)

                if (j - i + 1 == 3) {
                    // good string found
                    count++
                    i++
                    j = i
                    hset.clear()
                } else {
                    // not duplicate but less than 3
                    j++
                }

            }
        }
        return count
    }

    fun countGoodSubstrings1(s: String): Int {
        var i = 0
        var j = 0
        var condition = true
        var hset = hashSetOf<Char>()
        var nextChar: Char
        var count = 0
        while (i < s.length - 2 && j < s.length) {

            nextChar = s.get(j)

            if (hset.contains(nextChar)) {
                // duplicate char
                i++
                j = i
                hset.clear()
            } else {
                // not duplicate
                hset.add(nextChar)
                if (j - i == 2) {
                    // good string found
                    count++
                    i++
                    j = i
                    hset.clear()
                } else {
                    j++
                }
            }

        }
        return count
    }
}

fun main() {
    val o = countGoodSubstrings()
    val input = "aababcabc"
    val countGoodSubstrings = o.countGoodSubstrings(input)
    println("count $countGoodSubstrings")
}

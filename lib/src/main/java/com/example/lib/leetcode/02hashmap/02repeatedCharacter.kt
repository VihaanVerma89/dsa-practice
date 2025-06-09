package com.example.lib.leetcode


// https://leetcode.com/problems/first-letter-to-appear-twice/description/
// difficulty: easy
class `02repeatedCharacter` {
    fun repeatedCharacter(s: String): Char {

        val hm = HashMap<Char, Int>()
        var result = ' '

        for (c in s) {
            if (hm.contains(c)) {
                result = c
                break
            } else {
                hm[c] = 1
            }
        }


        return result

    }

}
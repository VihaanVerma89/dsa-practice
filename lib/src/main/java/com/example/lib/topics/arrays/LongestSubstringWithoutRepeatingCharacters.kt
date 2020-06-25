package com.example.lib.topics.arrays

class LongestSubstringWithoutRepeatingCharacters {

    fun lengthOfLongestSubstring(s: String): Int {

        val cset = hashSetOf<Char>()

        var i = 0
        var j = 0
        for (c in s) {
            if (cset.contains(c)) {
                i++
                cset.remove(c)
            } else {
                cset.add(c)
                j++
            }
        }

        return (j - i).coerceAtLeast(0)

    }
}

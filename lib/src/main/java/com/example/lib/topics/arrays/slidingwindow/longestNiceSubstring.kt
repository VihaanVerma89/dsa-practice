package com.example.lib.topics.arrays.slidingwindow

class longestNiceSubstring {

    fun longestNiceSubstring(s: String): String {
        var longestNiceSubstring = ""
        var longestLen = 0

        var i = 0
        var j = 0

        while (i < s.length) {
            j = i
            while (j <= s.length) {
                val sub = s.substring(i, j)
                val nice = isNice(sub)
                if (nice) {
                    if (sub.length > longestLen) {
                        longestLen = sub.length
                        longestNiceSubstring = sub
                    }
                }
                j++
            }
            i++
        }
        return longestNiceSubstring
    }

    fun isNice(s: String): Boolean {
        var nice = true
        val hset = hashSetOf<Char>()
        for (i in s) {
            hset.add(i)
        }

        for (i in s) {
//            if (hset.contains(i.uppercaseChar()) && hset.contains(i.lowercaseChar())) {
            if (hset.contains(Character.toUpperCase(i)) && hset.contains(Character.toLowerCase(i))) {
                // looks good
            } else {
                // not nice
                nice = false
                break
            }
        }
        return nice
    }

}
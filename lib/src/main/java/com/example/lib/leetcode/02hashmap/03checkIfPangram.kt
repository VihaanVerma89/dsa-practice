package com.example.lib.leetcode.`02hashmap`

class `03checkIfPangram` {


    fun checkIfPangram(sentence: String): Boolean {
        val hSet = HashSet<Char>()

        for (c in sentence) {
            if (c.isLetter()) {
                hSet.add(c.lowercaseChar())
            }
        }

        return hSet.size == 26
    }

    fun checkIfPangram01(sentence: String): Boolean {
        var hset = hashSetOf<Char>()

        for (s in sentence) {
            if (hset.contains(s)) {

            } else {
                hset.add(s)
            }
        }

        return hset.size == 26
    }
}
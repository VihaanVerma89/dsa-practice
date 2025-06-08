package com.example.lib.leetcode.`02hashmap`

class checkIfPangram {
    fun checkIfPangram(sentence: String): Boolean {
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
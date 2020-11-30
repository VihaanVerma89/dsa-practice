package com.example.lib.topics.misc

import kotlin.collections.HashSet

class WordBreak {

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val hashSet = HashSet<String>(wordDict)
        return wordBreak(s, hashSet, 0)
    }

    private fun wordBreak(s: String, wordDict: HashSet<String>, start: Int): Boolean {

        if (start == s.length) {
            // we reached the end of string with all valid segments
            return true
        }

        for (end in start..s.length) {
            val substring = s.substring(start, end)
            if (wordDict.contains(substring)) {
                // we have a valid segment
                // update start to point to next input
                val wordBreak = wordBreak(s, wordDict, end)
                if (wordBreak) {
                    return true
                }
            }
        }
        return false
    }

    fun main() {
        val w = WordBreak()
        val s = ""
        val wordDict = listOf<String>("leet", "code")
        val wordBreak = w.wordBreak(s, wordDict)
        println(wordBreak)
    }
}

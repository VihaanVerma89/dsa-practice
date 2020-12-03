package com.example.lib.topics.heap

import java.util.*

class TopKFrequentWords {

    data class WordFreq(val word: String, var freq: Int)

    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val arrayListOf = arrayListOf<String>()
        val hashMapOf = hashMapOf<String, WordFreq>()
        val c = Comparator { t: WordFreq, t2: WordFreq ->
            var r = 0
            if (t.freq < t2.freq) {
                r = -1
            } else if (t.freq == t2.freq) {
                r = t.word.compareTo(t2.word) * -1
            } else if (t.freq > t2.freq) {
                r = 1
            }
            r
        }
        val pq = PriorityQueue<WordFreq>(c)

        for (word in words) {
            if (hashMapOf.containsKey(word)) {
                hashMapOf.get(word)?.let {
                    it.freq++
                }
            } else {
                val wordFreq = WordFreq(word, 1)
                hashMapOf.put(word, wordFreq)
            }
        }

        for (entry in hashMapOf.entries) {
            pq.add(entry.value)
            if (pq.size > k) {
                val poll = pq.poll()
            }
        }

        while (pq.isNotEmpty()) {
            val poll = pq.poll()
            arrayListOf.add(poll.word)
        }
//        return arrayListOf.reversed()
        return arrayListOf
    }
}

fun main() {
    val words = arrayOf("i", "love", "leetcode", "i", "love", "coding")
    val k = 2
    val t = TopKFrequentWords()
    val topKFrequent = t.topKFrequent(words, k)
    val joinToString = topKFrequent.joinToString(",")
    println(joinToString)
}
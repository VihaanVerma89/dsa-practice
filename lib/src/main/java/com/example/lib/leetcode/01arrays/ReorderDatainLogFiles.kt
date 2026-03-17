package com.example.lib.leetcode.`01arrays`

class ReorderDatainLogFiles {

    fun reorderLogFiles(logs: Array<String>): Array<String> {
        if (logs.isNotEmpty()) {
            logs.sortWith(Comparator { s1: String, s2: String ->
                var r = 0

                /*
                log
                1. alpha numeric
                2. digit or letter
                * */

                val s1split = s1.split(" ")
                val s2split = s2.split(" ")

                val s1Split1 = s1split[1].get(0)
                val s2Split1 = s2split[1].get(0)


                if (s1Split1.isLetter() && s2Split1.isLetter()) {
                    r = compareLogSplits(s1split, s2split)
                } else if (s1Split1.isLetter() && s2Split1.isDigit()) {
                    r = -1
                } else if (s1Split1.isDigit() && s2Split1.isLetter()) {
                    r = 1
                } else if (s1Split1.isDigit() && s2Split1.isDigit()) {
                    r = 0
                }

                r
            })
        }
        return logs
    }

    fun compareLogSplits(s1split: List<String>, s2split: List<String>): Int {
        var i = 1
        var compareTo = s1split[i].compareTo(s2split[i])
        while (compareTo == 0 && i < s1split.size && i < s2split.size) {
            compareTo = s1split[i].compareTo(s2split[i])
            i++
        }
        var r = compareTo
        if (compareTo == 0) {
            r = s1split[0].compareTo(s2split[0])
        }
        return r
    }
}

fun main() {
    val o = ReorderDatainLogFiles()
    val logs = arrayOf("dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero")
    o.reorderLogFiles(logs)

}
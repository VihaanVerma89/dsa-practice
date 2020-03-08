package com.example.lib.hackerRank.hashMaps.commonSubString

import java.util.*


private fun twoStrings(s1: String, s2: String): String {
    val m1 = getStringCharCountHashMap(s1)
    val m2 = getStringCharCountHashMap(s2)

    var charFound = false
    for (key in m1.keys) {
        if (m2.contains(key)) {
            charFound = true
            break;
        }
    }
    var result = ""
    result = if (charFound) {
        "YES"
    } else {
        "NO"
    }
    return result
}

private fun getStringCharCountHashMap(s: String): HashMap<Char, Int> {
    val map = hashMapOf<Char, Int>()
    var value = Int.MAX_VALUE
    for (c in s) {
        if (map.contains(c)) {
            value = map[c]!!
            value++
        } else {
            value = 1
        }
        map[c] = value
    }
    return map
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s1 = scan.nextLine()

        val s2 = scan.nextLine()

        val result = twoStrings(s1, s2)

        println(result)
    }
}

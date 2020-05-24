package com.example.lib.topics.strings

import java.lang.Exception


fun myAtoi(str: String): Int {
    var r = 0
    val trim = str.trim()

    val split = trim.split(" ")
    val sign = split[0]
    if (sign.startsWith("+") || sign.startsWith("-")) {
        val prefix = sign[0]
        val number = sign.removeRange(0, 1)
        r = getMaxIntFromString(number)
        if (prefix.equals("-")) {
            r = "-$r".toInt()
        }
    } else {
        r = getMaxIntFromString(sign)
    }
    return r
}

fun getMaxIntFromString(s: String): Int {
    var r = 0
    try {
        r = s.toInt()
    } catch (e: Exception) {

        Int.MAX_VALUE
    }
    return r
}

fun main() {
    val s = ""
    val myAtoi = myAtoi(s)
    println(myAtoi)
}
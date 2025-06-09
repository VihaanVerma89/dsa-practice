package com.example.lib.leetcode.`02hashmap`

import kotlin.collections.iterator

class HashMapDemo {

    fun printKeys(hashMap: HashMap<String, String>) {
        for (e in hashMap) {
            println(e.key + " " + e.value)
        }
    }

}

fun main() {

    val hashMap = hashMapOf<String, String>()
    hashMap.put("1", "one")
    hashMap.put("2", "two")
    hashMap.put("3", "three")
    hashMap.put("4", "four")
    hashMap.put("5", "five")
    hashMap.put("6", "six")
    hashMap.put("7", "seven")
    hashMap.put("8", "eight")
    hashMap.put("9", "nine")
    hashMap.put("10", "ten")

    val o = HashMapDemo()
    for (i in 0..3) {
        println("$i time")
        o.printKeys(hashMap)
    }

    // getOrPut
    val getOrPut = hashMap.getOrPut("11") { "elevent" }
    println("getOrPut $getOrPut")


    // getOrDefault
    val getOrDefault = hashMap.getOrDefault("12", "twelve")
    println("getOrDefault $getOrDefault")


    // k,v iterations
    for ((k, v) in hashMap) {
       println("key: $k, value: $v")
    }

    // withIndex
    for (iv in hashMap.entries.withIndex()) {
        println("withIndex ${iv.index} ${iv.value.key} ${iv.value.value}")
    }
}
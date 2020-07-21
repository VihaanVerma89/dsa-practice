package com.example.lib.topics.hashMap

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
}
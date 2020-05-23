package com.example.lib.topics.hashMap


fun convert(s: String, numRows: Int): String {
    var result = ""
    if (s.isNotEmpty()) {
        if (numRows > 1) {
            val hashMapOfString = hashMapOf<Int, String>()
            var r = 0
            var down = true
            for ((i, c) in s.withIndex()) {
                if (hashMapOfString.contains(r)) {
                    val string = hashMapOfString[r]
                    val plus = string.plus(c)
                    hashMapOfString[r] = plus
                } else {
                    hashMapOfString[r] = c.toString()
                }
                if (down) {
                    r++
                } else {
                    r--
                }

                if (r == numRows) {
                    down = false
                    r -= 2
                } else if (r == -1) {
                    down = true
                    r += 2
                }
            }

            for (i in 0 until numRows) {
                if (hashMapOfString.containsKey(i)) {
                    result += hashMapOfString.get(i)
                }
            }
        }
        else{
            result = s
        }

    }

    return result
}


fun main() {
    val s = "PAYPALISHIRING"
    val r = convert(s, 4)
    println(r)
}
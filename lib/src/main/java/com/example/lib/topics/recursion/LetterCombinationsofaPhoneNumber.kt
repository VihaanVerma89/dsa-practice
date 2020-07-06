package com.example.lib.topics.recursion

class LetterCombinationsofaPhoneNumber {


    fun letterCombinationsRec(
        m: HashMap<String, String>,
        digits: String,
        r: ArrayList<String>
    ): ArrayList<String> {

        if (digits.isEmpty()) {
            return arrayListOf()
        } else if (digits.length == 1) {
            val arrayListOf = arrayListOf<String>()
            val s = m[digits]
            if (s != null) {
                for (i in s) {
                    val add = arrayListOf.add(i + "")
                }
            }
            return arrayListOf
        } else {
            val dropLast = digits.dropLast(1)
            val result = letterCombinationsRec(m, dropLast, r)
            val lastChar = digits.last()
            val lastCharValues: String? = m[lastChar + ""]
            for (i in result) {
                if (lastCharValues != null) {
                    for (c in lastCharValues) {
                        val cs = i + c
                        r.add(cs)
                    }
                }
            }
        }
        return r
    }

    fun letterCombinations(digits: String): List<String> {
        val r = arrayListOf<String>()
        val m = hashMapOf<String, String>()
        m.put("2", "abc")
        m.put("3", "def")
        m.put("4", "ghi")
        m.put("5", "jkl")
        m.put("6", "mno")
        m.put("7", "pqrs")
        m.put("8", "tuv")
        m.put("9", "wxyz")
        return letterCombinationsRec(m, digits, r)
    }


}

fun main() {

    val c = LetterCombinationsofaPhoneNumber()
    val digits = "234"
    val letterCombinations = c.letterCombinations(digits)
    println(letterCombinations.joinToString { "," })
}
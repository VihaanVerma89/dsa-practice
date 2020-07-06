package com.example.lib.topics.recursion

class LetterCombinationsofaPhoneNumber {


    fun letterCombinationsRec(
        m: HashMap<String, String>,
        digits: String,
        r: ArrayList<String>
    ): ArrayList<String> {

        var resultR = arrayListOf<String>()
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
            var size = result.size - 1
            if (lastCharValues != null) {
                while (size >= 0) {
                    for (c in lastCharValues) {
                        val cs = result[size] + c
                        resultR.add(cs)
                    }
                    size--
                }
            }
//            for (i in result) {
//                if (lastCharValues != null) {
//                    for (c in lastCharValues) {
//                        val cs = i + c
//                        r.add(cs)
//                    }
//                }
//            }
        }
        return resultR
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
//    val digits = "234"
    val digits = "23"
    val letterCombinations = c.letterCombinations(digits)
    val joinToString = letterCombinations.joinToString(",")
    println(joinToString)
}
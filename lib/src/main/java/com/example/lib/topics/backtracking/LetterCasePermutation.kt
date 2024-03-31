package com.example.lib.topics.backtrack1ing

//https://leetcode.com/problems/letter-case-permutation/solution/
class LetterCasePermutation {
//    fun letterCasePermutation(S: String): List<String>? {
//        val ans: MutableList<StringBuilder> = ArrayList()
//        ans.add(StringBuilder())
//        for (c in S.toCharArray()) {
//            val n = ans.size
//            if (Character.isLetter(c)) {
//                for (i in 0 until n) {
//                    ans.add(StringBuilder(ans[i]))
//                    ans[i].append(Character.toLowerCase(c))
//                    ans[n + i].append(Character.toUpperCase(c))
//                }
//            } else {
//                for (i in 0 until n) ans[i].append(c)
//            }
//        }
//        val finalans: MutableList<String> = ArrayList()
//        for (sb in ans) finalans.add(sb.toString())
//        return finalans
//    }

    fun letterCasePermutation(s: String): List<String>? {
        return letterCasePermutationRec(s, s.length - 1)
    }

    fun letterCasePermutationRec(s: String, pos: Int): ArrayList<String> {

        var rList = arrayListOf<String>()
        if (pos == 0) {
            val c = s[pos]
            if (c.isDigit()) {
                rList.add(c.toString())
            } else if (c.isLetter()) {
                rList.add(c.toUpperCase().toString())
                rList.add(c.toLowerCase().toString())
            }
            return rList
        }

        val cList = arrayListOf<String>()
        val c = s[pos]
        if (c.isDigit()) {
            cList.add(c.toString())
        } else if (c.isLetter()) {
            cList.add(c.toUpperCase().toString())
            cList.add(c.toLowerCase().toString())
        }

        val tempList = letterCasePermutationRec(s, pos - 1)

        for (t in tempList) {
            for (c in cList) {
                rList.add(t + c)
            }
        }

        return rList
    }
}

fun main() {
    val o = LetterCasePermutation()
    val s = "a1b2"
    val letterCasePermutation = o.letterCasePermutation(s)
    val joinToString = letterCasePermutation?.joinToString(",")
    println(joinToString)
}
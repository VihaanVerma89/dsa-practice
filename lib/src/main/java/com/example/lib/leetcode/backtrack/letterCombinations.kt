package com.example.lib.leetcode.backtrack1

class letterCombinations {

    fun backtrack1(
        hmap: HashMap<Int, List<String>>,
        digits: String,
        digit: Char?,
        position: Int,
        tempList: ArrayList<String>,
        ansList: ArrayList<String>
    ) {

        // base condition
        if (tempList.size == digits.length) {
            // ad
            ansList.add(tempList.joinToString(""))
            return
        }

        val charList = hmap[digit?.digitToInt()]
        // abc
        if (charList != null) {
            for (charIv in charList.withIndex()) {
                // a
                tempList.add(charIv.value)
                val nextDigit = digits.getOrNull(position + 1)
                backtrack1(hmap, digits, nextDigit, position + 1, tempList, ansList)
                tempList.removeLast()
            }
        }

    }

    fun letterCombinations1(digits: String): List<String> {

        if (digits.isNullOrEmpty()) {
            return listOf()
        }

        val hmap = hashMapOf<Int, List<String>>()

        hmap.put(2, listOf("a", "b", "c"))
        hmap.put(3, listOf("d", "e", "f"))
        hmap.put(4, listOf("g", "h", "i"))
        hmap.put(5, listOf("j", "k", "l"))
        hmap.put(6, listOf("m", "n", "o"))
        hmap.put(7, listOf("p", "q", "r", "s"))
        hmap.put(8, listOf("t", "u", "v"))
        hmap.put(9, listOf("w", "x", "y", "z"))

        val tempList = arrayListOf<String>()
        val ansList = arrayListOf<String>()

        backtrack1(hmap, digits, digits[0], 0, tempList, ansList)
        return ansList
    }


    fun bTrack(
        digits: String,
        index: Int,
        digitsArrayList: ArrayList<ArrayList<String>>,
        stringBuffer: StringBuffer,
        ansList: ArrayList<String>
    ) {

        // base condition
        if (stringBuffer.length == digits.length) {
            val ans = StringBuffer(stringBuffer).toString()
            ansList.add(ans)
            return
        }


        // traversal

        val digit = digits.get(index).digitToInt()
        val digitChars = digitsArrayList.get(digit)
        for (digitChar in digitChars) {
            // forward
            stringBuffer.append(digitChar)
            bTrack(digits, index + 1, digitsArrayList, stringBuffer, ansList)
            // reverse
            stringBuffer.deleteCharAt(stringBuffer.length - 1)
        }
    }


    fun letterCombinations(digits: String): List<String> {

        // sanity
        if (digits.isNullOrEmpty()) {
            return emptyList()
        }


        val digitsArrayList = arrayListOf<ArrayList<String>>(
            arrayListOf<String>(),
            arrayListOf<String>(),
            arrayListOf<String>("a", "b", "c"),
            arrayListOf<String>("d", "e", "f"),
            arrayListOf<String>("g", "h", "i"),
            arrayListOf<String>("j", "k", "l"),
            arrayListOf<String>("m", "n", "o"),
            arrayListOf<String>("p", "q", "r", "s"),
            arrayListOf<String>("t", "u", "v"),
            arrayListOf<String>("w", "x", "y", "z")
        )

        val ansList = arrayListOf<String>()
        bTrack(digits, 0, digitsArrayList, StringBuffer(), ansList)
        return ansList
    }

}


fun main() {
    val result = letterCombinations().letterCombinations("23")
    println(result)
}
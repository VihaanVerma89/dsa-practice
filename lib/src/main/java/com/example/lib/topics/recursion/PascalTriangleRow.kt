package com.example.lib.topics.recursion


class PascalTriangleRow {


    val valuesMap = hashMapOf<String, Int>()
    fun getValueAt(r: Int, c: Int): Int {
        var value = Int.MAX_VALUE

        val key = "$r,$c"
        if (valuesMap.containsKey(key)) {
            value = valuesMap[key]!!
            return value
        }

        if (r == 0 && c == 0) {
            value = 1
        } else if (r == 0) {
            value = 1
        } else if (r == c) {
            value = 1
        }

        value = getValueAt(r-1,c-1) + getValueAt(r-1,c)

        valuesMap[key] = value

        return value
    }


    fun getRow(rowIndex: Int): List<Int> {
        val rowValues = arrayListOf<Int>()
        for (ri in 0..rowIndex) {
            for (ci in 0..ri) {

                val valueAt = getValueAt(ri, ci)

                if (ri == rowIndex) {
                    rowValues.add(valueAt)
                }
            }
        }
        return rowValues
    }

}

fun main() {

}
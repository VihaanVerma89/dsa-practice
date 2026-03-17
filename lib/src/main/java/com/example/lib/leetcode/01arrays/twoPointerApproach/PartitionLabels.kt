package com.example.lib.leetcode.`01arrays`.twoPointerApproach

class PartitionLabels {
    fun partitionLabels(s: String): List<Int> {
        val lastPositionArray = IntArray(26) {
            0
        }

        for (iv in s.withIndex()) {
            val index = iv.index
            val value = iv.value
            val arrayIndex = value - 'a'
            lastPositionArray[arrayIndex] = index
        }

        var lastIndex = 0
        var partitionStart = 0
        var ans = arrayListOf<Int>()
        for (iv in s.withIndex()) {
            val index = iv.index
            val value = iv.value
            val arrayIndex = value - 'a'
            val charLastIndex = lastPositionArray[arrayIndex]
            if (charLastIndex > lastIndex) {
                lastIndex = charLastIndex
            }

            if (lastIndex == index) {
                var i = index - partitionStart + 1
                ans.add(i)
                partitionStart = index + 1
            }
        }
        return ans
    }

    //    fun partitionLabels(s: String): List<Int> {
//        val last = IntArray(26) {
//            -1
//        }
//
//        for (civ in s.withIndex()) {
//            val i = civ.value - 'a'
//            last[i] = civ.index
//        }
//
//        var j = 0
//        var anchor = 0
//        val ans = arrayListOf<Int>()
//
//        for (civ in s.withIndex()) {
//            val index = civ.index
//            val v = civ.value - 'a'
//            val lastPosition = last[v]
//            j = Math.max(j, lastPosition)
//            if (index == j) {
//                ans.add(index - anchor + 1)
//                anchor = index + 1
//            }
//        }
//        return ans
//    }


}

fun main() {
    val p = PartitionLabels()
    val s = "abccaddbeffe"
    val partitionLabels = p.partitionLabels(s)
    val joinToString = partitionLabels.joinToString(",")
    println(joinToString)
}
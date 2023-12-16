package com.example.lib.leetcode.backtrack


class Subsets {

    fun subsets(nums: IntArray): List<List<Int>>? {
        val input = intArrayOf(1, 2, 3)
        val ans = arrayListOf<ArrayList<Int>>()
        val currList = arrayListOf<Int>()
        backtrack(input,0, currList, ans)
        return ans
    }


    fun backtrack(
        input: IntArray,
        start: Int,
        currList: ArrayList<Int>,
        ans: ArrayList<ArrayList<Int>>
    ) {

        // base condition
        if (start > input.size) {
            return
        }

        // collect
        ans.add(ArrayList(currList))

        for (i in start until input.size) {
            currList.add(input[i])
            backtrack(input, i + 1, currList, ans)
            // travel back in stack
            currList.removeAt(currList.size - 1)
        }

    }

}

fun main() {
    Subsets().subsets(intArrayOf(1, 2, 3))
//    Subsets().limitedBackTrack(intArrayOf(1, 2, 3), 0)
}
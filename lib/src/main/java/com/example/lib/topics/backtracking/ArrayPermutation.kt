package com.example.lib.topics.backtrack1ing

import com.example.lib.topics.recursion.printLinkedList
import java.util.*
import kotlin.collections.ArrayList

//https://leetcode.com/problems/permutations/
class ArrayPermutation {

    fun backtrack1(n: Int,
                  nums: ArrayList<Int>?,
                  output: MutableList<List<Int>?>,
                  first: Int) {
        // if all integers are used up
        println("first: $first")
        if (first == n) {
            println("Valid output #${nums?.joinToString(",")}")
            output.add(ArrayList(nums))
        }
        for (i in first until n) {
            // place i-th integer first
            // in the current permutation
            println("i $i first $first")
            println("swap i $i first $first")
            Collections.swap(nums, first, i)
            if (nums != null) {
                println("${nums.joinToString(",")}")
            }
            println("backtrack1ing with n $n, nums: ${nums?.joinToString(",")} first+1: ${first+1}")
            // use next integers to complete the permutations
            backtrack1(n, nums, output, first + 1)
            // backtrack1
            Collections.swap(nums, first, i)
            println("i $i first $first")
            println("swap i $i first $first")
            if (nums != null) {
                println("${nums.joinToString(",")}")
            }
        }
    }

    fun permute(nums: IntArray): List<List<Int>?>? {
        // init output list
        val output: MutableList<List<Int>?> = LinkedList()

        // convert nums into list since the output is a list of lists
        val nums_lst = ArrayList<Int>()
        for (num in nums) nums_lst.add(num)
        val n = nums.size
        backtrack1(n, nums_lst, output, 0)
        return output
    }
}

fun main() {
    val a = intArrayOf(1, 2, 3)
    val arrayPermutation = ArrayPermutation()
    val permute = arrayPermutation.permute(a)

}
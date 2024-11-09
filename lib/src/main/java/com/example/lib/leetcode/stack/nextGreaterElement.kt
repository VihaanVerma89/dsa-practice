package com.example.lib.leetcode.stack

import java.util.*
import kotlin.collections.HashMap

fun main() {
    val nums1 = intArrayOf(4, 1, 2)
    val nums2 = intArrayOf(1, 3, 4, 2)

    val result = nextGreaterElement().nextGreaterElement(nums1, nums2)
    println(result.contentToString())
}

// https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/706/stacks-and-queues/4612/
class nextGreaterElement {


    /*
    num1 is subset of nums2
     */
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {

        val result = IntArray(nums1.size) {
            -1
        }

        // value -> Index
        val hmap2 = HashMap<Int, Int>()

        for (iv2 in nums2.withIndex()) {
            hmap2.put(iv2.value, iv2.index)
        }

//        val stack = Stack<Int>()
        for (iv1 in nums1.withIndex()) {
            if (hmap2.contains(iv1.value)) {
                val index2 = hmap2.get(iv1.value)
                val value = nums2[index2!!]
                for (j in index2 until nums2.size) {
                    if (value < nums2[j]) {
                        result[iv1.index] = nums2[j]
                        break
                    }
                }
            }
        }
        return result
    }

    /*

    num1
    o(n)

    nums2
    hmap2
    value -> index
    o(m)


     */
    fun nextGreaterElement1(nums1: IntArray, nums2: IntArray): IntArray {

        val hmap2 = hashMapOf<Int, Int>()
        val result = IntArray(nums1.size)

        // o(m) + o(m)
        for (iv in nums2.withIndex()) {
            if (hmap2.contains(iv.value)) {
                println("duplicate value shouldnt be there")
            } else {
                hmap2.put(iv.value, iv.index)
            }
        }

        for (iv1 in nums1.withIndex()) {
            if (hmap2.contains(iv1.value)) {
                //subset value present in nums2
                var j = hmap2.get(iv1.value)!!
                var value = -1
                var nge = -1
                while (j < nums2.size) {
                    value = nums2[j]
                    if (value > iv1.value) {
                        // next greater element found
                        nge = value
                        break
                    }
                    j++
                }

                // either we reach end or nge found
                if (nge != -1) {
                    result[iv1.index] = nge
                } else if (j == nums2.size) {
                    result[iv1.index] = -1
                }

            } else {
                // skip
                result[iv1.index] = -1
            }
        }
        return result
    }

    fun nextGreaterElementEditorial(nums1: IntArray, nums2: IntArray): IntArray? {
        val stack: Stack<Int> = Stack()
        val map: HashMap<Int, Int> = HashMap()
        for (i in nums2.indices) {
            while (!stack.empty() && nums2[i] > stack.peek())
                map[stack.pop()] = nums2[i]
            stack.push(nums2[i])
        }
        while (!stack.empty()) map[stack.pop()] = -1
        val res = IntArray(nums1.size)
        for (i in nums1.indices) {
            res[i] = map[nums1[i]]!!
        }
        return res
    }


    fun nextGreaterElements2(nums1: IntArray, nums2: IntArray): IntArray {
        val result = IntArray(nums1.size)

        val s = Stack<Int>()
        val hmap = hashMapOf<Int, Int>()

        // prepare value -> nge map
        for (iv in nums2.withIndex()) {
            if (s.isNotEmpty()) {
                val peek = s.peek()
                if (peek < iv.value) {
                    // greater element found
                    while (s.isNotEmpty() && s.peek() < iv.value) {
                        val pop = s.pop()
                        hmap.put(pop, iv.value)
                    }
                    // peek is lower than value
                    s.push(iv.value)
                } else if (peek >= iv.value) {
                    // smaller or same value found
                    s.push(iv.value)
                }
            } else {
                s.push(iv.value)
            }
        }

        for (iv in nums1.withIndex()) {

            if (hmap.contains(iv.value)) {
                // match found
                result[iv.index] = hmap.get(iv.value)!!
            } else {
                result[iv.index] = -1
            }
        }



        return result
    }


}


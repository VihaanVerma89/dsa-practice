package com.example.lib.leetcode.arrays

class intersection2 {

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val hmap1 = hashMapOf<Int, Int>()
        val hmap2 = hashMapOf<Int, Int>()

        for (num in nums1) {
            if (hmap1.contains(num)) {
                val value = hmap1.get(num)
                hmap1.put(num, value?.plus(1) ?: -1)
            } else {
                hmap1.put(num, 1)
            }
        }

        for (num in nums2) {
            if (hmap2.contains(num)) {
                val value = hmap2.get(num)
                hmap2.put(num, value?.plus(1) ?: -1)
            } else {
                hmap2.put(num, 1)
            }
        }

        val rhmap = hashMapOf<Int, Int>()
        var asize = 0
        for (entry in hmap1.entries) {
            if (hmap2.contains(entry.key)) {
                // match
                val value1 = entry.value
                val value2 = hmap2.get(entry.key)!!

                var diff = Math.min(value1,value2)
//                if (value1 > value2) {
//                    diff = value1 - value2
//                } else if (value1 == value2) {
//                    diff = value1
//                } else if (value2 > value1) {
//                    diff = value2 - value1
//                }

                asize += diff
                rhmap.put(entry.key, diff)

                println("diff: $diff, size:$asize, key: ${entry.key}")
            } else {
                // no match
            }
        }

        var rArray = IntArray(asize)
        var i = 0
        for (entry in rhmap.entries) {
            for (j in 0 until entry.value) {
                rArray[i++] = entry.key
            }
        }
        return rArray
    }
}

fun main() {
    val obj = intersection2()
    val input1 = intArrayOf(
        43,
        85,
        49,
        2,
        83,
        2,
        39,
        99,
        15,
        70,
        39,
        27,
        71,
        3,
        88,
        5,
        19,
        5,
        68,
        34,
        7,
        41,
        84,
        2,
        13,
        85,
        12,
        54,
        7,
        9,
        13,
        19,
        92
    )
    val input2 =
        intArrayOf(
            10,
            8,
            53,
            63,
            58,
            83,
            26,
            10,
            58,
            3,
            61,
            56,
            55,
            38,
            81,
            29,
            69,
            55,
            86,
            23,
            91,
            44,
            9,
            98,
            41,
            48,
            41,
            16,
            42,
            72,
            6,
            4,
            2,
            81,
            42,
            84,
            4,
            13
        )

    val result = obj.intersect(input1, input2)
    println("result : ${result.joinToString(",")}")
}
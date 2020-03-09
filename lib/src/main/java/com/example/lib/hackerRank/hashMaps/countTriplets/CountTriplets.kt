package com.example.lib.hackerRank.hashMaps.countTriplets

fun countTriplets(arr: Array<Long>, r: Long): Long {
    var count = 0.toLong()
    val numberCountHashMap = getNumberCountHashMap(arr)
    var v1 = 0.toLong()
    var v2 = 0.toLong()
    var v3 = 0.toLong()

    val processedV1Map = hashMapOf<Long, Boolean>()
    for ((index, value) in arr.withIndex()) {
        v1 = arr[index]
        v2 = v1 * r
        v3 = v2 * r
        if (processedV1Map.containsKey(v1)) {

        } else {
            if (numberCountHashMap.contains(v1) && numberCountHashMap.contains(v2) && numberCountHashMap.contains(
                    v3
                )
            ) {
                var possibleValues = 1
                numberCountHashMap[v1]?.let {
                    possibleValues *= it.size
                }
                numberCountHashMap[v2]?.let {
                    possibleValues *= it.size
                }
                numberCountHashMap[v3]?.let {
                    possibleValues *= it.size
                }
                count += possibleValues
            }
            processedV1Map[v1] = true
        }

    }
    return count
}

fun getNumberCountHashMap(arr: Array<Long>): HashMap<Long, ArrayList<Long>> {
    val map = hashMapOf<Long, ArrayList<Long>>()
    var value = arrayListOf<Long>()
    for ((index, value) in arr.withIndex()) {
        val valueLong = value.toLong()
        val indexLong = index.toLong()
        if (map.containsKey(value)) {
            val arrayList = map[valueLong]
            arrayList?.add(valueLong)
        } else {
            val values = arrayListOf<Long>()
            values.add(index.toLong())
            map[valueLong] = values
        }
    }
    return map
}


fun main(args: Array<String>) {
    val nr = readLine()!!.trimEnd().split(" ")

    val n = nr[0].toInt()

    val r = nr[1].toLong()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toLong() }.toTypedArray()

    val ans = countTriplets(arr, r)

    println(ans)
}

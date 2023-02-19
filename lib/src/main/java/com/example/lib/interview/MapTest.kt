package com.example.lib.interview


class MapTest {


    fun getAnsMap(categoriesMap: HashMap<String, ArrayList<String>>, dateMap: HashMap<String, List<Int>>): HashMap<String, Int> {
        val ansMap = hashMapOf<String, Int>()

        for (key in categoriesMap.keys) {

            var ansOneCount = 0
            val categoriesList = categoriesMap.get(key)
            if (categoriesList != null) {
                val collectedList = ArrayList<List<Int>>()
                for (categoryName in categoriesList) {
                    // get category name
                    val dateList = dateMap[categoryName]
                    if (dateList != null) {
                        collectedList.add(dateList)
                    }
                }


// iterate arrays and check for 1
                for (c in 0 until collectedList[0].size) {
                    var oneCount = 0
                    for (r in 0 until collectedList.size) {
                        val value = collectedList[r][c]
                        if (value == 1) {
                            oneCount++
                        }
                    }
                    // end of coloumn
                    if (oneCount == collectedList.size) {
                        // found 1 in all columns
                        ansOneCount++
                    }
                }

            }

            // update ans map```
            ansMap[key] = ansOneCount
        }

        return ansMap
    }
}

fun main() {
    val o = MapTest()


    val categoriesMap = hashMapOf<String, ArrayList<String>>()
    categoriesMap["mobile"] = arrayListOf("android", "ios")
    categoriesMap["overall"] = arrayListOf("android", "ios", "desktop", "ipad")
    categoriesMap["apple"] = arrayListOf("ios", "ipad")


    val dateMap = hashMapOf<String, List<Int>>()
    dateMap.put("android", listOf(1, 1, 1, 1, 0, 0, 1))
    dateMap.put("ios", listOf(0, 1, 0, 1, 0, 0, 1))
    dateMap.put("desktop", listOf(1, 0, 0, 0, 1, 1, 1))
    dateMap.put("ipad", listOf(1, 0, 1, 1, 0, 1, 1))

    val ansMap = o.getAnsMap(categoriesMap, dateMap)


}


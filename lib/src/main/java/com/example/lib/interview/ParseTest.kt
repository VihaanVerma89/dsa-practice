package com.example.lib.interview


class ParseTest {

    fun getList(input: String): ArrayList<HashMap<String, String>> {
        val r = arrayListOf<HashMap<String, String>>()
        if (input.isNotEmpty()) {
            val lines = input.split("\n")
            val headers = arrayListOf<String>()
            var ln = 0
            for (line in lines) {
                val values = line.split(",")
                val fixedValues = arrayListOf<String>()

                // fix "x, y" problem
                if (line.contains("\"")) {
                    var i = 0
                    var s = -1
                    var e = -1
                    for ((index, value) in values.withIndex()) {

                        if (value.contains("\"")) {
                            if (s == -1) {
                                // find start
                                s = index
                            } else {
                                // find end
                                e = index
                            }
                        } else {
                            // multiple lines needs to be merged.
                            var mergeLine = ""
                            if (s != -1 && e != -1) {
                                for (i in s..e+1) {
                                    if (i != (e+1)) {
                                        mergeLine += values[i]
                                        mergeLine += ","
                                    } else {
                                        mergeLine += values[i]
                                    }
                                }
                                fixedValues.add(mergeLine)
                            } else {
                                fixedValues.add(value)
                            }
//                            s = -1
//                            e = -1
                        }
                    }
                } else {
                    // line is valid
                    fixedValues.addAll(values)
                }


                if (ln == 0) {
                    // header line
                    for (value in fixedValues) {
                        headers.add(value)
                    }
                } else {
                    // values lines
//                    val valuesMap = hashMapOf<String, String>()
                    val hashMapOf = hashMapOf<String, String>()
                    for ((index, value) in fixedValues.withIndex()) {
                        val header = headers[index]
                        hashMapOf[header] = value
                    }
                    r.add(hashMapOf)
                }
                ln++
            }
        }

        return r
    }

}

fun main() {

    val o = ParseTest()

    val input = "product_id,name,description,price\n" +
            "1,blender,blends,20\n" +
            "2,rice cooker, cooks rice,\$30\n" +
            "3, saucepan, too much      whitespace    , \$10\n" +
            "4d, scale, \"  a description, including a comma  \", \$30.30"

    val output = o.getList(input)
    println(output)
}


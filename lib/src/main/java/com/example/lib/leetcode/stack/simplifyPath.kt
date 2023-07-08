package com.example.lib.leetcode.stack

import java.util.*

class simplifyPath {

    /*
    Valid path
    - starts with /
    - ends without /
    - // is equivalent to /
    .. is parent
    . is current dir
     */
    fun simplifyPathAttempt1(path: String): String {
        val s = Stack<Char>()
        for (iv in path.withIndex()) {

            if (iv.value == '/' && s.isNotEmpty() && s.peek() == '/') {
                // if current top of stack is / dont add another slash
                /*
                / /
                t c
                 */
                // skip
            } else if (iv.value == '/' && s.isNotEmpty() && s.peek() != '/' && s.peek() != '.') {
                // add slash at end of regular char
                /*
                c /
                t c
                 */
                s.add(iv.value)
            } else if (iv.value != '/' && s.isNotEmpty() && s.peek() == '.') {
                // regular char found add it to stack
                /*
                . /
                t c
               .. /
                 */
                s.add(iv.value)
//            } else if (1) {
//                /*
//                . .
//                t c
//                 */
//            } else if () {
//                /*
//                . c
//                t c
//                 */

            } else if (iv.value == '.' && s.isNotEmpty() && s.peek() == '.') {
                // .. found
                // stack top -> .
                // current value -> .

                // ..x situation. What is x ?
                // .. . x ?
                // .. . . ?
                // .. . / ?
                //  t c x

                val nextIndex = iv.index + 1
                if (nextIndex < path.length) {
                    val nextChar = path.get(nextIndex)
                    if (nextChar == '.') {
                        // ... found. We can consider current '.' as valid.
                        // tcx
                        s.add(iv.value)
                    } else if (nextChar == '/') {
                        /*
                         ../ found do we need to move to parent directory ?
                         /../ -> yes
                          tcx
                         .../ -> no
                        */

                        val previousChar = s.get(iv.index - 1)
                        if (previousChar == '/') {
                            // /../ -> yes
                            // ptcx
                            // move to parent directory
                            if (s.isNotEmpty()) {
                                while (s.isNotEmpty() && s.peek() != '/') {
                                    s.pop()
                                }
                                // either s is empty or top is /
                                // since '/' is nextChar for loop will take care.
                            } else {
                                // stack empty cant move to parent directory
                                println("stack empty cant move to parent directory")
                            }
                        } else {
                            // .../ -> no
                            // ptcx
                            s.add(iv.value)
                        }
                    } else {
                        println("..$nextChar found. What to do ?")
                    }
                }
            }
        }


        // if / is on top of stack then remove it
        if (s.isNotEmpty() && s.peek() == '/') {
            s.pop()
        }

        var result = ""
        // get the string in the stack
        while (s.isNotEmpty()) {
            result += s.pop()
        }

        return result
    }


    fun simplifyPathAttempt2(path: String): String {
        var result = ""

        val s = Stack<Char>()

        for (iv in path.withIndex()) {

            if (iv.value != '/' || iv.value != '.') {
                // add simple chars in stack
                s.add(iv.value)
            } else if (iv.value == '/') {
                /*
                 handle addition of /
                 x + /
                 t   c
                 what can be values of x ?
                 - char
                 - /
                 - .
                 */

                if (s.isNotEmpty()) {
                    val top = s.peek()
                    if (top != '/' || top != '.') {
                        // top is regular char . Char + /
                        s.add(iv.value)
                    } else if (top == '/') {
                        // top is /
                        // skip adding / on /
                    } else if (top == '.') {
                        /*
                     ??. + /
                      c. + / -> fine
                      .. + / --> need stack state change
                      /. + /

                         */
                    }
                } else {
                    // stack is empty add / to start
                    s.add('/')
                }


            } else if (iv.value == '.') {
                // handle .
            }
        }

        return result
    }


    /*


        /users/vihaan/code/android/

        /../
     */
    fun simplifyPath(path: String): String? {

        val dirs = path.split("/")
        val s = Stack<String>()

        for (dir in dirs) {
            if (dir == ".") {
                // ignore
            } else if (dir == "..") {
                if (s.isNotEmpty()) {
                    s.pop()
                }
            } else if (dir.isEmpty()) {
                // ignore
            } else if (dir.isNotEmpty()) {
                // valid directory
                s.push(dir)
            } else {
                println("why are we here ? dir : $dir")
            }
        }


        // s has only valid directroy name or is empty
        var result = ""
        if (s.isEmpty()) {
            if (dirs.size > 0) {
                result = "/"
            }
        } else {
            // form valid path
            val sb = StringBuilder()
            for (dir in s) {
                sb.append("/")
                sb.append(dir)
            }
            result = sb.toString()
        }

        return result
    }
}

fun main() {
    val instance = simplifyPath()
    val input = "/users/home/vihaan/code"
    val output = instance.simplifyPath(input)
    println("output $output")
}
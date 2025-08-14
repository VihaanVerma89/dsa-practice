package com.example.lib.codeReview

class CodeReview2{

    fun getUserFullName(user: Map<String,String>): String{
        return user.get("firstName").toString() +" "+ user.get("lastName")
    }


    data class User(val firstName:String, val lastName:String)
//    val user = User("Vihaan", "Verma")
    val user = User("Vihaan", "Verma")

    fun getUserName(user: User): String {
        val sb = StringBuilder()
        sb.append(user.firstName ?: "Unknown")
        sb.append(" ")
        sb.append(user.lastName ?: "Unknown")
        return sb.toString()
    }
}

fun main() {
    val user = mapOf("firstName" to "John", "lastName" to "Doe")
    val codeReview2 = CodeReview2()
    println(codeReview2.getUserFullName(user))  // Output: JohnDoe


    val emptyUser = emptyMap<String,String>()
    println(codeReview2.getUserFullName(emptyUser))  // Output: null


}
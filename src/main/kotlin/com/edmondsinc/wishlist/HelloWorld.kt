package com.edmondsinc.wishlist

class HelloWorld{}
const val name = "Tyler" //this is a final val. val == final in Java.
var greeting: String? = "hi"

//? makes it nullable. In Kotlin, types are non-nullable by default.
//also, var is not final. so re-assignable.
var nullString: String? = null

fun main() {

    //this is showing that we can assign variables based on the result of conditionals.
    val greetingToPrint = if(greeting != null) greeting else "hi"
    val greetingToPrintWhen = when(greeting) {
        null -> "hi"           //when is like a Java Switch(case). when(expression) {}
        "hi" -> "I updated"    //then each item is a case pointing to what to do.
        else -> "Default"      //so this line is "else, set my variable to Default"
    }
    println(greetingToPrintWhen)
//    if(greeting != null){
//        println(greeting)
//    }else{
//        println("default greeting")
//    }
//
//    greeting = "Big Greet"
//    when(greeting){
//        null -> println("hi")
//        else -> println(greeting)
//    }

}




package _3_function._3_extension

import _3_function.strings.lastChar

fun main(args: Array<String>) {
    println("Kotlin".lastChar)

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
}
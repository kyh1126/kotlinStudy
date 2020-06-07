package _3_function._3_extension

import _3_function.strings.joinToString

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4, 5)

    val extensionResult = list.joinToString(prefix = "[", postfix = "]")
    list.joinToString().forEach { print(it) }
    println("/ $extensionResult :: ${extensionResult.javaClass}")

    val collectionsResult = list.joinToString(prefix = "[", postfix = "]") { "$it" }
    list.joinToString() { "$it" }.forEach { print(it) }
    println("/ $collectionsResult :: ${collectionsResult.javaClass}")
}
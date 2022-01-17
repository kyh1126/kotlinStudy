package _3_function._1_collection

fun main(args: Array<String>) {
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1..30)
    val map = hashMapOf(1 to "one", 3 to "three", 5 to "five")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    val strings = listOf("first", "second", "third")
    println("last: " + strings.last())

    val numbers = setOf(1, 20)
    // val numbers = setOf(1..20)
    println(numbers.maxOrNull())
}

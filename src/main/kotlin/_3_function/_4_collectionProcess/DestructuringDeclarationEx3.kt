package _3_function._4_collectionProcess

fun main(args: Array<String>) {
    val arr = arrayOf(1, 2, 3, 4)
    arr.withIndex().onEach { (index, element) -> println("index: $index, element: $element") }

    val map = mapOf(1 to "one", 7.to("seven"))
    map.mapValues { (k, v) -> println("key: $k, value: $v") }
}